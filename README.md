🛡️ PacketShield-DPI

PacketShield is a high-performance Network Security Engine built for real-time Deep Packet Inspection (DPI).
It monitors network traffic at the packet level to detect, log, and simulate blocking of restricted domains.

🚀 Core Features
🔎 Live Traffic Sniffing

Captures packets across all active network interfaces (WiFi, Ethernet, USB) using Pcap4J + Npcap.

🧠 Deep Packet Inspection (DPI)

Analyzes raw packet bytes and extracts domain-level information (including HTTPS SNI inspection) to detect restricted targets.

🚨 Real-Time Security Alerts

Triggers structured console-based alerts whenever unauthorized access is detected.

🗄️ Dynamic Rule Engine

Integrated with Spring Data JPA + H2 Database for dynamic management of blocked domains.

⚡ Multithreaded Monitoring

Parallel sniffing threads per active interface ensure real-time monitoring with minimal latency.

🔥 Firewall Simulation Logic

Implements TCP RST injection logic to simulate forced connection termination.

🏗️ System Architecture

Flow:

Network Interface
⬇
Packet Capture (Pcap4J)
⬇
Packet Decoder
⬇
DPI Engine
⬇
Rule Engine (H2 Database)
⬇
Security Alert / TCP Reset

Works below the Application Layer (Network & Transport Layer Focus).

🛠️ Technical Stack

Backend: Java, Spring Boot 3.x

Persistence: Spring Data JPA / Hibernate

Database: H2 (In-Memory)

Networking: Pcap4J, Npcap

Architecture: Multithreaded, Event-Driven

Development Methodology: AI-assisted debugging (Gemini)

📋 How It Works
1️⃣ Initialize

Scans and lists all available network interfaces.

2️⃣ Monitor

Starts asynchronous sniffing threads for each active interface.

3️⃣ Inspect

Decodes packets and extracts domain signatures (including HTTPS handshake analysis).

4️⃣ Match

Compares extracted domain with blacklist stored in H2 Database.

5️⃣ Alert / Terminate

If matched:

🚫 [SECURITY ALERT] logged

TCP RST packet injected

🎯 Learning Outcomes

HTTPS handshake & SNI inspection

TCP packet crafting fundamentals

Firewall behavior simulation

Concurrent packet processing

Backend + Low-Level Networking integration

⚙️ Quick Start

Install Npcap (Enable WinPcap Compatibility Mode).

Clone the repository.

Run the application as Administrator.

Monitor console for real-time packet inspection logs.

⚠️ Disclaimer

This project is for educational and research purposes only.
Use only in authorized environments.
