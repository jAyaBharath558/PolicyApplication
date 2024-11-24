package com.example.policyApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "Claims")
public class Claims {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int claim_number;
    @Column(name = "claim_date")
    String claim_date;
    @Column(name = "claim_type")
    String claim_type;
    @Column(name = "is_filed")
    String is_filed;
    @Column(name = "amount")
    long amount;

    @ManyToOne
    @JoinColumn(name = "policy_number",nullable = false)
    Policy policy;

    @OneToMany(mappedBy = "claim_number",cascade = CascadeType.ALL)
    List<Reviewer> reviewers;

    @OneToMany(mappedBy = "claim_number",cascade = CascadeType.ALL)
    List<Settlement> settlements;
}
