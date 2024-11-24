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
@Table(name = "Policy")
public class Policy {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int policy_number;
    @Column(name = "covered_type")
    String covered_type;
    @Column(name = "is_active")
    String is_active;
    @Column(name = "expires_date")
    String expiry_date;

    @ManyToOne
    @JoinColumn(name = "policy_holder_id",nullable = false)
    Policy_holderEntity PolicyHolder;

    @OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
    List<Claims> claims;
}
