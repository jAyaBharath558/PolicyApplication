package com.example.policyApp.Service;

import com.example.policyApp.Entity.Policy_holderEntity;

import java.util.List;
import java.util.Optional;

public interface Policy_holderService {
    Policy_holderEntity savePolicyHolder(Policy_holderEntity policyHolder);
    Policy_holderEntity updatePolicyHolder(int id, Policy_holderEntity policyHolder);
    Optional<Policy_holderEntity> getPolicyHolderById(int id);
    List<Policy_holderEntity> getAllPolicyHolders();
    void deletePolicyHolder(int id);
}
