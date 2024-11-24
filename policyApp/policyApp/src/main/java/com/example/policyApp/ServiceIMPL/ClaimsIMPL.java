package com.example.policyApp.ServiceIMPL;

import com.example.policyApp.Entity.Claims;
import com.example.policyApp.Service.ClaimsService;
import com.example.policyApp.DTO.ClaimsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimsIMPL implements ClaimsService {
    @Autowired
    ClaimsDTO claimsDTO;

    @Override
    public Claims saveClaim(Claims claim) {
        return claimsDTO.save(claim);
    }

    @Override
    public Claims updateClaim(int id, Claims claim) {
        if (claimsDTO.existsById(id)) {
            claim.setClaim_number(id);
            return claimsDTO.save(claim);
        } else {
            throw new RuntimeException("Claim with id " + id + " not found.");
        }
    }

    @Override
    public Optional<Claims> getClaimById(int id) {
        return claimsDTO.findById(id);
    }

    @Override
    public List<Claims> getAllClaims() {
        return claimsDTO.findAll();
    }

    @Override
    public void deleteClaim(int id) {
        if (claimsDTO.existsById(id)) {
            claimsDTO.deleteById(id);
        } else {
            throw new RuntimeException("Claim with id " + id + " not found.");
        }
    }

}
