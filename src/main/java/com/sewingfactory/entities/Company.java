package com.sewingfactory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

    public Company(String name, float juniorSalary, float seniorSalary) {
        this.name = name;
        this.juniorSalary = juniorSalary;
        this.seniorSalary = seniorSalary;
    }

    public Company() {}

    @Id   
    @GeneratedValue   
    private Long id;

    private String name;

    @Column(name = "junior_salary")
    private float juniorSalary;

    @Column(name = "senior_salary")
    private float seniorSalary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getJuniorSalary() {
        return juniorSalary;
    }

    public void setJuniorSalary(float juniorSalary) {
        this.juniorSalary = juniorSalary;
    }

    public float getSeniorSalary() {
        return seniorSalary;
    }

    public void setSeniorSalary(float seniorSalary) {
        this.seniorSalary = seniorSalary;
    }

    public String toString() {
        return "Company {\n" +
            "id: " + id + ", \n" +
            "name: " + name + ", \n" +
            "juniorSalary: " + juniorSalary + ", \n" +
            "seniorSalary: " + seniorSalary + ", \n" +
            "}";
    }
}
