🛡️ PacketShield-DPI
A real-time Deep Packet Inspection (DPI) engine built using Java and Spring Boot.

📝 Project Overview
This project monitors network traffic at the packet level to detect, log, and simulate blocking of restricted domains. It works below the Application Layer, focusing on the Network and Transport layers.

🚀 Key Features
🔎 Live Traffic Sniffing: Captures packets across all active network interfaces like WiFi, Ethernet, and USB.

🧠 Deep Packet Inspection (DPI): Analyzes raw packet bytes to extract domain-level information, including HTTPS SNI inspection.

🚨 Real-Time Security Alerts: Features structured console-based alert logging for immediate detection of unauthorized access.

🗄️ Dynamic Rule Engine: Integrated with Spring Data JPA and H2 Database for runtime domain management without restarts.

⚡ Multithreaded Monitoring: Uses parallel sniffing threads per interface to ensure high-performance monitoring.

🔥 Firewall Simulation Logic: Implements TCP RST packet injection to simulate forced connection termination.

🏗️ System Architecture
Traffic Flow:
Network Interface → Packet Capture (Pcap4J) → Packet Decoder → DPI Engine → Rule Engine (H2 Database) → Security Alert / TCP Reset

🛠️ Tech Stack
Backend: Java, Spring Boot 3.x

Persistence: Spring Data JPA / Hibernate

Database: H2 (In-Memory)

Networking: Pcap4J, Npcap

Approach: AI-assisted debugging and architecture refinement (Gemini).

📋 How It Works
Initialize: Scans and lists all available network interfaces.

Monitor: Starts asynchronous sniffing threads for each active interface.

Inspect: Decodes packets and extracts domain signatures.

Match: Compares signatures with the blacklist stored in the H2 Database.

Action: Logs a 🚫 [SECURITY ALERT] and injects a TCP RST packet.

⚙️ How to Run
Install Npcap: Ensure "WinPcap Compatibility Mode" is enabled.

Clone: Download the repository to your local machine.

Admin Rights: Run the application as Administrator (required for packet injection).

Monitor: Check console logs for real-time inspection.

⚠️ Disclaimer
This project is built strictly for educational and research purposes. Please use it only in authorized environments.
