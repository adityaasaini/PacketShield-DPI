🛡️ PacketShield-DPI

PacketShield is a high-performance Network Security Engine built for real-time Deep Packet Inspection (DPI).
It monitors network traffic at the packet level to detect, log, and simulate blocking of access attempts to restricted domains.

This project demonstrates practical firewall logic, low-level packet analysis, and backend-driven rule management — all integrated into a scalable architecture.

🚀 Core Features
🔎 Live Traffic Sniffing

Captures packets across all active network interfaces (WiFi, Ethernet, USB) using Pcap4J + Npcap.

🧠 Deep Packet Inspection (DPI)

Analyzes raw packet bytes and extracts domain-level information (including HTTPS SNI field inspection) to identify restricted targets.

🚨 Real-Time Security Alerts

Triggers structured console-based alerts with professional security headers whenever unauthorized access is detected.

🗄️ Dynamic Rule Engine

Integrated with Spring Data JPA + H2 Database to manage blacklisted domains dynamically without restarting the engine.

⚡ Multithreaded Monitoring

Implements parallel sniffing threads per active network interface to ensure real-time, zero-latency packet inspection.

🔥 Firewall Simulation Logic

Implements TCP RST packet injection logic to simulate forced connection termination for blocked traffic.

🏗️ System Architecture Overview
Network Interface → Packet Capture → Packet Decoder → DPI Engine → Rule Engine (DB) → Alert System / TCP Reset

The system works below the application layer, focusing on transport and network-level inspection before traffic reaches backend services.

🛠️ Technical Stack

Backend: Java, Spring Boot 3.x
Persistence Layer: Spring Data JPA / Hibernate
Database: H2 (In-Memory)
Networking: Pcap4J, Npcap
Architecture Style: Multithreaded, Event-Driven
Development Approach: AI-assisted debugging (Gemini) for refining complex packet parsing and networking logic

📋 How It Works
1️⃣ Initialize

The engine scans and lists all available network interfaces on the system.

2️⃣ Monitor

An asynchronous sniffing thread is started for each active interface.

3️⃣ Inspect

Captured packets are decoded and analyzed to detect blacklisted domain signatures (including HTTPS handshake inspection).

4️⃣ Match

The extracted domain is compared against the H2 Database rule set.

5️⃣ Alert / Terminate

If a match is found:

A 🚫 [SECURITY ALERT] is logged

A TCP RST packet is injected to simulate connection termination
