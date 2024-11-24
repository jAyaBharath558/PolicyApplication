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
@Table(name = "Policy_holder")
public class Policy_holderEntity {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Policy_holder_id;

    @Column(name = "name")
    String name;
    @Column(name = "DOB")
    String DOB;
    @Column(name = "nominee")
    String nominee;
    @Column(name = "Contact_number")
    long contact_number;
    @Column(name = "occupation")
    String occupation;
    @Column(name = "income")
    long income;
    @Column(name = "aadher_number")
    String aadhar_number;
    @Column(name = "bank_name")
    String bank_name;
    @Column(name = "account_number")
    long account_number;
    @Column(name = "ifsc_code")
    String ifsc_code;
    @Column(name = "update_stream")
    String update_stream;
    @Column(name = "zipcode")
    long zipcode;
    @OneToMany(mappedBy ="PolicyHolder", cascade=CascadeType.ALL)
    List<Policy> policies;
}
