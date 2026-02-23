🛡️ PacketShield-DPI

A real-time Deep Packet Inspection (DPI) engine built using Java and Spring Boot.
This project monitors network traffic at the packet level to detect, log, and simulate blocking of restricted domains.

🚀 Features
🔎 Live Traffic Sniffing

Captures packets across all active network interfaces (WiFi, Ethernet, USB)

Built using Pcap4J + Npcap

🧠 Deep Packet Inspection (DPI)

Analyzes raw packet bytes

Extracts domain-level information (including HTTPS SNI inspection)

Detects restricted targets in real time

🚨 Real-Time Security Alerts

Structured console-based alert logging

Immediate detection of unauthorized access attempts

🗄️ Dynamic Rule Engine

Integrated with Spring Data JPA + H2 Database

Supports runtime domain management without restart

⚡ Multithreaded Monitoring

Parallel sniffing threads per network interface

Ensures high-performance real-time monitoring

🔥 Firewall Simulation Logic

Implements TCP RST packet injection

Simulates forced connection termination

🏗️ System Architecture

Flow:

Network Interface
→ Packet Capture (Pcap4J)
→ Packet Decoder
→ DPI Engine
→ Rule Engine (H2 Database)
→ Security Alert / TCP Reset

Works below the Application Layer (Network & Transport Layer focus).

🛠️ Tech Stack

Backend: Java, Spring Boot 3.x

Persistence: Spring Data JPA / Hibernate

Database: H2 (In-Memory)

Networking: Pcap4J, Npcap

Architecture: Multithreaded, Event-Driven

Development Approach: AI-assisted debugging (Gemini)

📋 How It Works
1️⃣ Initialize

Scans and lists all available network interfaces.

2️⃣ Monitor

Starts asynchronous sniffing threads for each active interface.

3️⃣ Inspect

Decodes packets and extracts domain signatures.

4️⃣ Match

Compares extracted domain with blacklist stored in H2 Database.

5️⃣ Alert / Terminate

🚫 [SECURITY ALERT] logged

TCP RST packet injected

⚙️ How to Run

Install Npcap (Enable WinPcap Compatibility Mode).

Clone the repository.

Run the application as Administrator.

Monitor console logs for real-time packet inspection.

⚠️ Disclaimer

This project is built strictly for educational and research purposes.
Use only in authorized environments
