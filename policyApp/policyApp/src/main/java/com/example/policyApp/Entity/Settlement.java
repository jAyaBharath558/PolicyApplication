package com.example.policyApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "Settlement")
public class Settlement {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Settlement_number;
    @Column(name = "settlement_date")
    String settlement_date;
    @Column(name = "amount")
    long amount;
    @Column(name = "settlement_status")
    String settlement_status;

    @ManyToOne
    @JoinColumn(name = "claim_number",nullable = false)
    Claims claim_number;
}
