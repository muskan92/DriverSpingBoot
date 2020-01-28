package com.muskan.driver.service;

import com.muskan.driver.exception.RecordNotFoundException;
import com.muskan.driver.model.Driver;
import com.muskan.driver.repositor.DriverRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    DriverRepository driverRepository;

    public List<Driver> getAllDrivers() throws RecordNotFoundException {

        List<Driver> driverList = driverRepository.findAll();
        if(driverList.size()==0){
            throw new RecordNotFoundException("No driver found");
        }

        return driverList;
    }

    public Driver getDriver(Long id) throws RecordNotFoundException {

        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if(!optionalDriver.isPresent()){
            throw new RecordNotFoundException("Driver does not exist for "+id);
        }
        return optionalDriver.get();
    }

    @Transactional
    public Driver createOrUpdateDriver(Driver entity){


        Optional<Driver> optionalDriver = driverRepository.findById(entity.getId());

        if(optionalDriver.isPresent()){
            logger.info("Updating entity");
            optionalDriver.get().setUpdated_at(new Date());
            optionalDriver.get().setActive(entity.isActive());
            optionalDriver.get().setMobile(entity.getMobile());

            return driverRepository.save(optionalDriver.get());

        }else
        {
            logger.info("saving entity");
            return driverRepository.save(entity);
        }

    }

    public void deleteDriver(Long id) throws RecordNotFoundException {

        Optional<Driver> optionalDriverdriver = driverRepository.findById(id);
        if(optionalDriverdriver.isPresent()){
            logger.info("deleting driver with id : "+id);
            driverRepository.delete(optionalDriverdriver.get());
        }else {
            throw new RecordNotFoundException("No driver found with id :" +id);
        }
    }

    public void deleteAll() {

        logger.info("Deleting all drivers");
        driverRepository.deleteAll();
    }
}
