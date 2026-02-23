package com.example.test.service;

import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NetworkInterfaceService {
    public void checkMyNetworkCards() {
        try {
            List<PcapNetworkInterface> allDevs = Pcaps.findAllDevs();
            System.out.println("\n✅ INITIALIZING NETWORK SCAN...");
            for (PcapNetworkInterface nif : allDevs) {
                System.out.println("📡 ACTIVE INTERFACE: [" + nif.getDescription() + "]");
            }
            System.out.println("----------------------------------------------\n");
        } catch (Exception e) {
            System.err.println("Scan Error: " + e.getMessage());
        }
    }
}