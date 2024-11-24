package com.example.policyApp.ServiceIMPL;

import com.example.policyApp.DTO.PolicyDTO;
import com.example.policyApp.Entity.Policy;
import com.example.policyApp.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyIMPL implements PolicyService {

    @Autowired
    PolicyDTO policyDTO;

    @Override
    public Policy savePolicy(Policy policy) {
        return policyDTO.save(policy);
    }

    @Override
    public Policy updatePolicy(int id, Policy policy) {
        if (policyDTO.existsById(id)) {
            policy.setPolicy_number(id);
            return policyDTO.save(policy);
        } else {
            throw new RuntimeException("Policy with id " + id + " not found.");
        }
    }

    @Override
    public Optional<Policy> getPolicyById(int id) {
        return policyDTO.findById(id);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyDTO.findAll();
    }

    @Override
    public void deletePolicy(int id) {
        if (policyDTO.existsById(id)) {
            policyDTO.deleteById(id);
        } else {
            throw new RuntimeException("Policy with id " + id + " not found.");
        }
    }
}
