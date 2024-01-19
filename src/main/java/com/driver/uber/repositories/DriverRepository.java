package com.driver.uber.repositories;

import com.driver.uber.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    public Optional<Driver> findByMobileNo(String mobileNo);
}
