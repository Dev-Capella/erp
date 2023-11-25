package com.capella.domain.model.customer;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "Customers")
@Getter
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
}
