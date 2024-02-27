package com.springdemo.libapi.service;

import com.springdemo.libapi.Repo.CustomerRepo;
import com.springdemo.libapi.entity.Customer;
import com.springdemo.libapi.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void save(MultipartFile file){
        try {
            List<Customer> customerListToDb = Helper.convertExcelToList(file.getInputStream());
            this.customerRepo.saveAll(customerListToDb);
        }
        catch(Exception e){
                e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomer(){
        return this.customerRepo.findAll();
    }
}
