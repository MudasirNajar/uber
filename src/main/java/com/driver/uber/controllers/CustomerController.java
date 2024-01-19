package com.driver.uber.controllers;

import com.driver.uber.models.Customer;
import com.driver.uber.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("customerId") Integer customerId){
        return customerService.deleteById(customerId);
    }


}
