package com.muskan.driver.repositor;

import com.muskan.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByIsBooked(boolean isBooked);

    Optional<Driver> findById(Long id);

    List<Driver> findByIsActive(boolean isActive);

}
