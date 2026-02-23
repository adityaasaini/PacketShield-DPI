package com.example.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.test.entity.BlockedSite;
import com.example.test.repository.BlockedSiteRepository;
import com.example.test.service.NetworkInterfaceService;
import com.example.test.service.PacketCaptureService;


@SpringBootApplication
@EnableAsync
public class PacketShieldDpiApplication implements CommandLineRunner {

	private final NetworkInterfaceService networkService;
	private final PacketCaptureService captureService;
	private final BlockedSiteRepository repository; // 👈 Yeh missing tha

	// Constructor mein humne repository ko bhi add kar diya hai
	public PacketShieldDpiApplication(NetworkInterfaceService networkService, 
			PacketCaptureService captureService,
			BlockedSiteRepository repository) {
		this.networkService = networkService;
		this.captureService = captureService;
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PacketShieldDpiApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
	    // 1. Manually site add karo agar DB khali hai
	    if (repository.count() == 0) {
	        repository.save(new BlockedSite("youtube.com"));
	        repository.save(new BlockedSite("bing.com"));
	        System.out.println("✅ Sites added to Database!");
	    }
	    
	    networkService.checkMyNetworkCards();
	    captureService.startSniffing();
	}
}