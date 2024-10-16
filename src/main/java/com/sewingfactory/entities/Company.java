package com.sewingfactory.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    @NotBlank(message = "Името на компанията не може да е празно")
    @Length(min = 2, max = 15, message = "Необходимия броя символи за имена на компания е между 2 и 15")
    private String name;

    @Min(value = 10, message = "Заплатата на младши работник не може да е по-малко от 10")
    @Max(value = 100, message = "Заплатата на младши работник не може да е повече от 100")
    @Column(name = "junior_salary")
    private float juniorSalary;

    @Min(value = 50, message = "Заплатата на старши работник не може да е по-малко от 50")
    @Max(value = 1000, message = "Заплатата на старши работник не може да е повече от 1000")
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
