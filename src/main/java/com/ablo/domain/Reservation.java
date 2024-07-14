package com.ablo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "code", unique = true, length = 20)
    private String code;

    @Column(name = "bags_count", nullable = false)
    private int bagsCount;

    @CreationTimestamp
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @CreationTimestamp
    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "extras")
    private String extras;

    @Lob
    @Column(name = "note")
    private String note;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference(value = "user-reservations")
    private User user;
}
