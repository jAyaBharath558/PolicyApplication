package com.example.policyApp.Controller;

import com.example.policyApp.Entity.Policy;
import com.example.policyApp.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    // Create a new Policy
    @PostMapping("/createPolicy")
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy savedPolicy = policyService.savePolicy(policy);
        return new ResponseEntity<>(savedPolicy, HttpStatus.CREATED);
    }

    // Update an existing Policy
    @PutMapping("/updatepolicy/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable int id, @RequestBody Policy policy) {
        try {
            Policy updatedPolicy = policyService.updatePolicy(id, policy);
            return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Policy by ID
    @GetMapping("/getpolicy/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable int id) {
        Optional<Policy> policy = policyService.getPolicyById(id);
        return policy.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Policies
    @GetMapping("/getallpolicy")
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    // Delete a Policy by ID
    @DeleteMapping("/deletepolicy/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable int id) {
        try {
            policyService.deletePolicy(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
