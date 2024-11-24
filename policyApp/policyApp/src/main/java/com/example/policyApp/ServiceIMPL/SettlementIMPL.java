package com.example.policyApp.ServiceIMPL;

import com.example.policyApp.DTO.SettlementDTO;
import com.example.policyApp.Entity.Settlement;
import com.example.policyApp.Service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettlementIMPL implements SettlementService {
    @Autowired
    SettlementDTO settlementDTO;


    @Override
    public Settlement saveSettlement(Settlement settlement) {
        return settlementDTO.save(settlement);
    }

    @Override
    public Settlement updateSettlement(int id, Settlement settlement) {
        if (settlementDTO.existsById(id)) {
            settlement.setSettlement_number(id);
            return settlementDTO.save(settlement);
        } else {
            throw new RuntimeException("Settlement with id " + id + " not found.");
        }
    }

    @Override
    public Optional<Settlement> getSettlementById(int id) {
        return settlementDTO.findById(id);
    }

    @Override
    public List<Settlement> getAllSettlements() {
        return settlementDTO.findAll();
    }

    @Override
    public void deleteSettlement(int id) {
        if (settlementDTO.existsById(id)) {
            settlementDTO.deleteById(id);
        } else {
            throw new RuntimeException("Settlement with id " + id + " not found.");
        }
    }
}
