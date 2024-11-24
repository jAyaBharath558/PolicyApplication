package com.example.policyApp.DTO;

import com.example.policyApp.Entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyDTO extends JpaRepository<Policy,Integer> {
}
