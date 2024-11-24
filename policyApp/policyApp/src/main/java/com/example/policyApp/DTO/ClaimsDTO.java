package com.example.policyApp.DTO;

import com.example.policyApp.Entity.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsDTO extends JpaRepository<Claims,Integer> {
}
