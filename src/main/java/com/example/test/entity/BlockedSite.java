package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BlockedSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String domainName; // e.g., "youtube.com"

    // 1. Default Constructor (JPA ko iski zarurat hoti hai)
    public BlockedSite() {
    }

    // 2. Parameterized Constructor (Data asani se dalne ke liye)
    public BlockedSite(String domainName) {
        this.domainName = domainName;
    }

    // 3. Getters and Setters (Fields ki value nikalne aur badalne ke liye)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    // 4. ToString (Debug karte waqt data console par dikhane ke liye)
    @Override
    public String toString() {
        return "BlockedSite [id=" + id + ", domainName=" + domainName + "]";
    }
}