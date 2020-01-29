package com.muskan.driver.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * Created by braj on 28/01/20.
 */
@Embeddable
@Data
public class Address {

    String houseNum;
    String street;
    String zip;
    String city;
    String state;
    String country;
    Boolean present;
    Date createdOn;
    Date updatedBOn;
    String createdBy;
    String updatedBy;

    @Enumerated(EnumType.STRING)
    AddressType type;


    public enum AddressType{
        HOME("Home Address"),OFFICE("Office Address");
         AddressType(String description) {
            this.description = description;
        }

        String description;

    }

}
