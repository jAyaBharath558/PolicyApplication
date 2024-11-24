package com.example.policyApp.Service;

import com.example.policyApp.Entity.Claims;

import java.util.List;
import java.util.Optional;

public interface ClaimsService {
    Claims saveClaim(Claims claim);
    Claims updateClaim(int id, Claims claim);
    Optional<Claims> getClaimById(int id);
    List<Claims> getAllClaims();
    void deleteClaim(int id);
}