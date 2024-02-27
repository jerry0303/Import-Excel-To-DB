package com.springdemo.libapi.controller;

import com.springdemo.libapi.entity.Customer;
import com.springdemo.libapi.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.springdemo.libapi.service.CustomerService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("customer/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){

        if(Helper.checkIsExcel(file)){
            //true
            this.customerService.save(file);

            return ResponseEntity.ok(Map.of("message",  "File is uploaded  & data is saved to DB"));
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel file only");
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }
}
