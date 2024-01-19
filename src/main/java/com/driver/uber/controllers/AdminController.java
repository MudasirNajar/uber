package com.driver.uber.controllers;

import com.driver.uber.models.Admin;
import com.driver.uber.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    public void addAdmin(@RequestBody Admin admin) {
        adminService.adminRegister(admin);
    }

    @PutMapping("/updatePassword")
    public Admin updatePassword(@RequestParam("adminId") Integer adminId,
                                @RequestParam("newPassword") String password) {
        return adminService.updatePassword(adminId, password);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("adminId") Integer adminId) {
        return adminService.deleteById(adminId);
    }
}
