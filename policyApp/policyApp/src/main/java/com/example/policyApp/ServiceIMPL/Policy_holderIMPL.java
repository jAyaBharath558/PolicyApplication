package com.example.policyApp.ServiceIMPL;

import com.example.policyApp.DTO.Policy_holderDTO;

import com.example.policyApp.Entity.Policy_holderEntity;
import com.example.policyApp.Service.Policy_holderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Policy_holderIMPL implements Policy_holderService {

    @Autowired
    Policy_holderDTO PolicyholderDTO;


    @Override
    public Policy_holderEntity savePolicyHolder(Policy_holderEntity policyHolder) {
        return PolicyholderDTO.save(policyHolder);
    }

    @Override
    public Policy_holderEntity updatePolicyHolder(int id, Policy_holderEntity policyHolder) {
        if(PolicyholderDTO.existsById(id)){
            policyHolder.setPolicy_holder_id(id);
            return  PolicyholderDTO.save(policyHolder);
        }else {
            throw  new RuntimeException("policy holder with id "+id+"not found");
        }
    }

    @Override
    public Optional<Policy_holderEntity> getPolicyHolderById(int id) {
        return PolicyholderDTO.findById(id);
    }

    @Override
    public List<Policy_holderEntity> getAllPolicyHolders() {
        return PolicyholderDTO.findAll();
    }

    @Override
    public void deletePolicyHolder(int id) {
        if(PolicyholderDTO.existsById(id)){
            PolicyholderDTO.deleteById(id);
        }else {
            throw  new RuntimeException("policy holder with id "+id+"not found");
        }
    }
}
