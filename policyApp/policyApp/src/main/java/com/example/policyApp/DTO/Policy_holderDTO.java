package com.example.policyApp.DTO;


import com.example.policyApp.Entity.Policy_holderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Policy_holderDTO extends JpaRepository<Policy_holderEntity,Integer> {
}
