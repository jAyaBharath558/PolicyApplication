package com.example.policyApp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name="Reviewer")
public class Reviewer {
    @Id
            @GeneratedValue(strategy= GenerationType.IDENTITY)
    int reviewer_id;

    @Column(name = "username")
    String username;
    @Column(name = "phone_number")
    String phone_number;
    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "claim_number",nullable = false)
    Claims claim_number;

}
