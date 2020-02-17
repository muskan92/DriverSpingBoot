package com.muskan.driver.controller;

import com.muskan.driver.exception.RecordNotFoundException;
import com.muskan.driver.model.Driver;
import com.muskan.driver.repositor.DriverRepository;
import com.muskan.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/driver")
public class DiverController {

    @Autowired
    DriverService service;
    @Autowired
    DriverRepository driverRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/getAll", method = {RequestMethod.GET})
    public ResponseEntity<List<Driver>> getAllDrivers() throws RecordNotFoundException {

        List<Driver> allDrivers = service.getAllDrivers();
        return new ResponseEntity<>(allDrivers, HttpStatus.OK);
    }
    //Using Query param

    @RequestMapping(path = "/getAllActive", method = {RequestMethod.GET})
    public ResponseEntity<List<Driver>> getAllActiveDrivers(@RequestParam("isActive") boolean isActive) throws RecordNotFoundException{

        List<Driver> activeDrivers = service.getAllActiveDrivers(isActive);
        return new ResponseEntity<>(activeDrivers, HttpStatus.OK);
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


    @RequestMapping(path = "/getCache", method = {RequestMethod.GET})
    public ResponseEntity<Driver> getCache() throws RecordNotFoundException {

       // Driver Drivers = testCacheLevel();
        logger.info("service.getAllDrivers() first........");

        Driver driver = service.getDriver(1L);
        logger.info("service.getAllDrivers() second........");

        Driver driver1 = service.getDriver(1L);
        //logger.info(driver.toString());

        return new ResponseEntity(driver1, HttpStatus.OK);

    }

    @Transactional
    public Driver testCacheLevel() throws RecordNotFoundException {

        logger.info("in controller.testCacheLevel");
        Optional<Driver> driver = driverRepository.findById(1L);
        Optional<Driver> driver1 = driverRepository.findById(1L);
        logger.info(driver.get().toString());
        return driver.get();
    }


}
