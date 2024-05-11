package com.satvik.flightreservation.entities;

import jakarta.persistence.Entity;

import lombok.*;


@Getter
@Setter
@Entity
public class Passenger extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;



}


