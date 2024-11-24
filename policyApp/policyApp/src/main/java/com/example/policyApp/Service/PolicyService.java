package com.example.policyApp.Service;

import com.example.policyApp.Entity.Policy;

import java.util.List;
import java.util.Optional;

public interface PolicyService {
    Policy savePolicy(Policy policy);
    Policy updatePolicy(int id, Policy policy);
    Optional<Policy> getPolicyById(int id);
    List<Policy> getAllPolicies();
    void deletePolicy(int id);
}
