package com.springdemo.libapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;

@Entity
public class Customer {

    @Id
    private Integer customer_id;
    private String emailid;
    private String name;
    public Customer(Integer customer_id, String emailid, String name) {
        this.customer_id = customer_id;
        this.emailid = emailid;
        this.name = name;
    }

    public Customer() {

    }

    public Integer getId() {
        return customer_id;
    }

    public void setId(int id) {
        this.customer_id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
