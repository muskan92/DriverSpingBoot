package com.muskan.driver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Ride {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date rideOn;
    private String toLocation;
    private String fromLocation;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "driver_id")
    private Driver driver;


}
