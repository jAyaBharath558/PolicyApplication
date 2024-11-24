package com.example.policyApp.Controller;

import com.example.policyApp.Entity.Settlement;
import com.example.policyApp.Service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/settlements")
public class SettlementController {

    @Autowired
    SettlementService settlementService;

    // Create a new Settlement
    @PostMapping("/updateSettlements")
    public ResponseEntity<Settlement> createSettlement(@RequestBody Settlement settlement) {
        Settlement savedSettlement = settlementService.saveSettlement(settlement);
        return new ResponseEntity<>(savedSettlement, HttpStatus.CREATED);
    }

    // Update an existing Settlement
    @PutMapping("/updateSettlements/{id}")
    public ResponseEntity<Settlement> updateSettlement(@PathVariable int id, @RequestBody Settlement settlement) {
        try {
            Settlement updatedSettlement = settlementService.updateSettlement(id, settlement);
            return new ResponseEntity<>(updatedSettlement, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Settlement by ID
    @GetMapping("/getSettlements/{id}")
    public ResponseEntity<Settlement> getSettlementById(@PathVariable int id) {
        Optional<Settlement> settlement = settlementService.getSettlementById(id);
        return settlement.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Settlements
    @GetMapping("/getallSettlements")
    public ResponseEntity<List<Settlement>> getAllSettlements() {
        List<Settlement> settlements = settlementService.getAllSettlements();
        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }

    // Delete a Settlement by ID
    @DeleteMapping("/deleteSettlement/{id}")
    public ResponseEntity<Void> deleteSettlement(@PathVariable int id) {
        try {
            settlementService.deleteSettlement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}