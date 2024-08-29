package com.sewingfactory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leather_details")
public class LeatherDetail {
    public LeatherDetail(
        String name,
        float bp
    ) {
        this.name = name;
        this.basePrice = bp;
    }

    @Id   
    @GeneratedValue   
    private Long id;

    private String name;

    private Float basePrice;

    // TODO add material
    // TODO add employee
    
    @ManyToOne()
    private Employee created_by;

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

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float price) {
        this.basePrice = price;
    }

    public Employee getcreated_by() {
        return created_by;
    }

    public void setcreated_by(Employee employee) {
        this.created_by = employee;
    }

    @Override
    public String toString() {
        return "LeatherDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", createdBy='" + created_by + '\'' +
                '}';
    }
}
