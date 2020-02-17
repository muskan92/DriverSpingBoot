package com.muskan.driver.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.OverridesAttribute;

@Entity
@Data
@ToString(callSuper = true)
public class Driver extends LoginUser{


    private boolean isBooked;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zip", column=@Column(name = "zipCode"))
    })
    private Address address;


}
