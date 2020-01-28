package com.muskan.driver.controller;

import com.muskan.driver.exception.RecordNotFoundException;
import com.muskan.driver.model.Driver;
import com.muskan.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/driver")
public class DiverController {
    @Autowired
    DriverService service;

    @RequestMapping(path = "/getAll", method = {RequestMethod.GET})
    public ResponseEntity<List<Driver>> getAllDrivers() throws RecordNotFoundException {

        List<Driver> allDrivers = service.getAllDrivers();
        return new ResponseEntity<>(allDrivers, HttpStatus.OK);

    }

    @RequestMapping(path = "/add", method = {RequestMethod.POST})
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver){

        Driver createdDriver = service.createOrUpdateDriver(driver);
        return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);

    }

    @RequestMapping(path = "get/{id}", method = {RequestMethod.GET})
    public Driver getDriverById(@PathVariable("id") Long id) throws RecordNotFoundException {

        Driver driver = service.getDriver(id);
        return driver;
    }

    @RequestMapping(path = "/update", method = {RequestMethod.PUT})
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){

        Driver updatedDriver = service.createOrUpdateDriver(driver);
        return new ResponseEntity<>(updatedDriver, HttpStatus.ACCEPTED);

    }

    @RequestMapping(path = "/delete/{id}", method = {RequestMethod.DELETE})
    public HttpStatus deleteDriverById(@PathVariable("id") Long id) throws RecordNotFoundException{
        service.deleteDriver(id);
        return  HttpStatus.OK;
    }

    @RequestMapping(path = "/deleteAll", method = {RequestMethod.DELETE})
    public HttpStatus deleteAllDrivers(){
        service.deleteAll();
        return HttpStatus.OK;
    }


}
