package com.example.customerdb;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String company;

    @OneToMany(mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public Set<Customer> customers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}