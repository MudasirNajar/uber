package com.driver.uber.services;

import com.driver.uber.models.Customer;
import com.driver.uber.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        String customerMobileNo = customer.getMobileNo();
        Optional<Customer> customerOptional = customerRepository.findByMobileNo(customerMobileNo);
        if (customerOptional.isPresent()) {
            return null;
        } else {
            return customerRepository.save(customer);
        }
    }

    public String deleteById(Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(customerId);
            return "Customer deleted successfully";
        } else {
            return "Customer doesn't exist";
        }
    }
}
