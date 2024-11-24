package com.example.policyApp.DTO;

import com.example.policyApp.Entity.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerDTO extends JpaRepository<Reviewer,Integer> {
}
