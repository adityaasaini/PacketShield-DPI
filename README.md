🛡️PacketShield-DPI

A real-time Deep Packet Inspection (DPI) engine developed using Java and Spring Boot.
This project monitors network traffic at packet level to detect, log, and simulate blocking of restricted domains.
--
🚀 ##Features

🔎 Live Traffic Sniffing
Captures packets across all active network interfaces (WiFi, Ethernet, USB)
Built using Pcap4J + Npcap
---
🧠 ##Deep Packet Inspection (DPI)

Analyzes raw packet bytes
Extracts domain-level information (including HTTPS SNI inspection)
Detects restricted domains in real-time
---
🚨 Real-Time Security Alerts
Instant console-based security logging
Detects unauthorized access attempts

🗄️ Dynamic Rule Engine
Integrated with Spring Data JPA + H2 Database
Supports runtime management of blocked domains

🔥 Firewall Simulation Logic
Implements TCP RST packet injection
Simulates forced connection termination

⚡ Multithreaded Monitoring
Parallel packet sniffing across multiple interfaces
Ensures high-performance real-time processing

🧱 Architecture
The project follows a modular layered design:

text
Packet Capture Layer → DPI Engine Layer → Rule Engine Layer → Alert System → Persistence Layer
Packet Capture Layer – Captures raw packets using Pcap4J

DPI Engine Layer – Decodes and analyzes packet data

Rule Engine Layer – Matches extracted domains with database rules

Alert System – Logs alerts and triggers TCP reset

Persistence Layer – Manages blocked domains using H2 + JPA

🛠️ Tech Stack
Technology	Purpose
Java	Core programming language
Spring Boot 3.x	Application framework
Spring Data JPA / Hibernate	Database ORM
H2 Database	In-Memory database
Pcap4J	Packet capture library
Npcap	Windows packet capture driver
Git & GitHub	Version control
📂 Project Structure
text
src/main/java/com/packetshield/
├── config/
├── controller/
├── dpi/
├── model/
├── repository/
├── service/
└── util/
⚙️ How to Run
Clone the repository

bash
git clone https://github.com/adityasaini/PacketShield-DPI.git
Install Npcap

Download from npcap.com

Enable WinPcap compatibility mode during installation

Run as Administrator

bash
mvn spring-boot:run
Monitor console logs for real-time packet inspection output

🎯 Learning Outcomes
Deep Packet Inspection fundamentals

HTTPS handshake & SNI analysis

TCP packet crafting concepts

Multithreading in real-time systems

Backend + low-level networking integration

📌 Future Enhancements
Web dashboard for live monitoring

REST API for dynamic rule management

Advanced payload-based filtering

Intrusion Detection System (IDS) features

👨‍💻 Author
Aditya Saini
Aspiring Java Backend & Security Developer
GitHub | LinkedIn

⭐ Star this repository if you found it helpful!
