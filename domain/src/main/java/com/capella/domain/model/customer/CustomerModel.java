package com.capella.domain.model.customer;


import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String surname;
}
