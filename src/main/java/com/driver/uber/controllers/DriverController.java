package com.driver.uber.controllers;

import com.driver.uber.models.Driver;
import com.driver.uber.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public Driver addDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("driverId") Integer driverId){
        return driverService.deleteById(driverId);
    }

}
