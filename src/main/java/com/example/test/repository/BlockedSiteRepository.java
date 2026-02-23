package com.example.test.repository;

import com.example.test.entity.BlockedSite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BlockedSiteRepository extends JpaRepository<BlockedSite, Long> {
    Optional<BlockedSite> findByDomainName(String domainName);
}