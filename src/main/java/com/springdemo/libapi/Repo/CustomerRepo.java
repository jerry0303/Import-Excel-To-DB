package com.springdemo.libapi.Repo;

import com.springdemo.libapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
