package com.muskan.driver.model;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Data
public class Driver extends LoginUser{


    private boolean isBooked;

    @Embedded
    private Address address;


}
