package com.driver.uber.services;

import com.driver.uber.models.Admin;
import com.driver.uber.models.Customer;
import com.driver.uber.models.Driver;
import com.driver.uber.repositories.AdminRepository;
import com.driver.uber.repositories.CustomerRepository;
import com.driver.uber.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void adminRegister(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin updatePassword(Integer adminId, String password) {

        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            admin.setPassword(password);
            return adminRepository.save(admin);
        } else {
            return null;
        }
    }

    public void deleteAdmin(Integer adminId) {
        //Delete admin without using deleteById method
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            adminRepository.delete(admin);
        }
    }

    public List<Driver> getListOfDrivers() {
        //Find the list of all drivers
        return driverRepository.findAll();
    }

    public List<Customer> getListOfCustomers(){
        return customerRepository.findAll();
    }
}
