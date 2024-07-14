package com.ablo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToOne(mappedBy = "address")
    private User user;
}
