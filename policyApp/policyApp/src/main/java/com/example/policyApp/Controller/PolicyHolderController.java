package com.example.policyApp.Controller;

import com.example.policyApp.Entity.Policy_holderEntity;
import com.example.policyApp.Service.Policy_holderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/policyHolder")
public class PolicyHolderController {
    @Autowired
    Policy_holderService policy_holderService;

    @PostMapping("/createPolicyHolder")
    public ResponseEntity<Policy_holderEntity> createPolicyHolder(@RequestBody Policy_holderEntity policyHolderEntity){
        Policy_holderEntity savedPolicyHolder=policy_holderService.savePolicyHolder(policyHolderEntity);
        return new ResponseEntity<>(savedPolicyHolder, HttpStatus.CREATED);
    }

    // Update an existing Policy Holder
    @PutMapping("/updatePolicyHolder/{id}")
    public ResponseEntity<Policy_holderEntity> updatePolicyHolder(@PathVariable int id, @RequestBody Policy_holderEntity policyHolder) {
        Policy_holderEntity updatedPolicyHolder = policy_holderService.updatePolicyHolder(id, policyHolder);
        return new ResponseEntity<>(updatedPolicyHolder, HttpStatus.OK);
    }

    // Get a Policy Holder by ID
    @GetMapping("/PolicyHolderById{id}")
    public ResponseEntity<Policy_holderEntity> getPolicyHolderById(@PathVariable int id) {
        Optional<Policy_holderEntity> policyHolder = policy_holderService.getPolicyHolderById(id);
        if (policyHolder.isPresent()) {
            return new ResponseEntity<>(policyHolder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all Policy Holders
    @GetMapping("/allPolicyHolders")
    public ResponseEntity<List<Policy_holderEntity>> getAllPolicyHolders() {
        List<Policy_holderEntity> policyHolders = policy_holderService.getAllPolicyHolders();
        return new ResponseEntity<>(policyHolders, HttpStatus.OK);
    }

    // Delete a Policy Holder
    @DeleteMapping("/deletePolicyHolder/{id}")
    public ResponseEntity<Void> deletePolicyHolder(@PathVariable int id) {
        try {
            policy_holderService.deletePolicyHolder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
