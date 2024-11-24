package com.example.policyApp.Service;

import com.example.policyApp.Entity.Settlement;

import java.util.List;
import java.util.Optional;

public interface SettlementService {
    Settlement saveSettlement(Settlement settlement);
    Settlement updateSettlement(int id, Settlement settlement);
    Optional<Settlement> getSettlementById(int id);
    List<Settlement> getAllSettlements();
    void deleteSettlement(int id);
}
