package com.example.policyApp.DTO;


import com.example.policyApp.Entity.Settlement;
import com.example.policyApp.Entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementDTO extends JpaRepository<Settlement,Integer> {
}
