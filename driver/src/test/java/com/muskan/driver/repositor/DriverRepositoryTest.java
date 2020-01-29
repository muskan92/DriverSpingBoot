package com.muskan.driver.repositor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by braj on 29/01/20.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class DriverRepositoryTest {

    @Autowired
    DriverRepository driverRepository;

    @Test
    void findById() {
        driverRepository.findById(1l);

    }

}