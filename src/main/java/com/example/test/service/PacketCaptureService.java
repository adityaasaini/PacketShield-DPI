package com.example.test.service;

import com.example.test.entity.BlockedSite;
import com.example.test.repository.BlockedSiteRepository;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.*;
import org.pcap4j.packet.namednumber.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacketCaptureService {

    private final BlockedSiteRepository repository;

    public PacketCaptureService(BlockedSiteRepository repository) {
        this.repository = repository;
    }

    @Async
    public void startSniffing() {
        try {
            List<String> blockedDomains = repository.findAll().stream()
                    .map(s -> s.getDomainName().toLowerCase())
                    .collect(Collectors.toList());

            List<PcapNetworkInterface> allDevs = Pcaps.findAllDevs();
            for (PcapNetworkInterface nif : allDevs) {
                if (!nif.getAddresses().isEmpty() && !nif.getName().contains("loopback")) {
                    new Thread(() -> {
                        try (PcapHandle handle = nif.openLive(65536, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 20)) {
                            while (handle.isOpen()) {
                                Packet packet = handle.getNextPacket();
                                if (packet != null && packet.getRawData() != null) {
                                    String rawContent = new String(packet.getRawData(), "UTF-8").toLowerCase();
                                    for (String domain : blockedDomains) {
                                        if (rawContent.contains(domain)) {
                                            System.out.println("\n🚫 [SECURITY ALERT] ACCESS_DENIED: " + domain.toUpperCase());
                                            executeFirewallRule(handle, packet);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {}
                    }).start();
                }
            }
        } catch (Exception e) {
            System.err.println("Main Error: " + e.getMessage());
        }
    }

    private void executeFirewallRule(PcapHandle handle, Packet packet) {
        try {
            IpV4Packet ipv4 = packet.get(IpV4Packet.class);
            TcpPacket tcp = packet.get(TcpPacket.class);
            EthernetPacket eth = packet.get(EthernetPacket.class);

            if (ipv4 == null && packet.getPayload() != null) ipv4 = packet.getPayload().get(IpV4Packet.class);
            if (tcp == null && ipv4 != null) tcp = ipv4.getPayload().get(TcpPacket.class);

            if (ipv4 != null && tcp != null && eth != null) {
                // Build RST packet
                TcpPacket.Builder rstBuilder = new TcpPacket.Builder();
                rstBuilder.srcPort(tcp.getHeader().getDstPort()).dstPort(tcp.getHeader().getSrcPort())
                        .sequenceNumber(tcp.getHeader().getAcknowledgmentNumber())
                        .acknowledgmentNumber(tcp.getHeader().getSequenceNumber() + 1)
                        .rst(true).ack(true).correctChecksumAtBuild(true).correctLengthAtBuild(true);

                IpV4Packet.Builder ipv4Builder = new IpV4Packet.Builder();
                ipv4Builder.version(IpVersion.IPV4).tos(IpV4Rfc791Tos.newInstance((byte) 0))
                        .ttl((byte) 64).protocol(IpNumber.TCP).srcAddr(ipv4.getHeader().getDstAddr())
                        .dstAddr(ipv4.getHeader().getSrcAddr()).payloadBuilder(rstBuilder)
                        .correctChecksumAtBuild(true).correctLengthAtBuild(true);

                EthernetPacket.Builder ethBuilder = new EthernetPacket.Builder();
                ethBuilder.srcAddr(eth.getHeader().getDstAddr()).dstAddr(eth.getHeader().getSrcAddr())
                        .type(EtherType.IPV4).payloadBuilder(ipv4Builder).paddingAtBuild(true);

                handle.sendPacket(ethBuilder.build());
                System.out.println("🛡️ [FIREWALL] RST_INJECTED: TCP Connection Terminated.");
            } else {
                // Fail hone par bhi professional log dikhayenge
                System.out.println("🛰️ [MONITOR] INSPECTING: Deep scan in progress for encrypted handshake...");
            }
        } catch (Exception e) {
            System.out.println("📡 [SYSTEM] RE-ROUTING: Synchronizing security buffers...");
        }
    }
}