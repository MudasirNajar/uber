package com.driver.uber.services;

import com.driver.uber.models.Driver;
import com.driver.uber.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public Driver addDriver(Driver driver) {
        String mobileNo = driver.getMobileNo();
        Optional<Driver> driverOptional = driverRepository.findByMobileNo(mobileNo);
        if(driverOptional.isPresent()){
            return null;
        }
        return driverRepository.save(driver);
    }

    public String deleteById(Integer driverId) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if (driverOptional.isPresent()) {
            driverRepository.deleteById(driverId);
            return "Driver deleted successfully";
        } else {
            return "Driver doesn't exist";
        }
    }
}
