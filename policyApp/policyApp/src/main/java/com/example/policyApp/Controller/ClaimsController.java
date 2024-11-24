package com.example.policyApp.Controller;

import com.example.policyApp.Entity.Claims;
import com.example.policyApp.Service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimsController {

    @Autowired
    ClaimsService claimsService;
    // Create a new Claim
    @PostMapping("/createClaim")
    public ResponseEntity<Claims> createClaim(@RequestBody Claims claim) {
        Claims savedClaim = claimsService.saveClaim(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    }

    // Update an existing Claim
    @PutMapping("/updataClaim/{id}")
    public ResponseEntity<Claims> updateClaim(@PathVariable int id, @RequestBody Claims claim) {
        try {
            Claims updatedClaim = claimsService.updateClaim(id, claim);
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Claim by ID
    @GetMapping("/getClaim/{id}")
    public ResponseEntity<Claims> getClaimById(@PathVariable int id) {
        Optional<Claims> claim = claimsService.getClaimById(id);
        return claim.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Claims
    @GetMapping("/getallClaim")
    public ResponseEntity<List<Claims>> getAllClaims() {
        List<Claims> claims = claimsService.getAllClaims();
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    // Delete a Claim by ID
    @DeleteMapping("/deleteClaim/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable int id) {
        try {
            claimsService.deleteClaim(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
