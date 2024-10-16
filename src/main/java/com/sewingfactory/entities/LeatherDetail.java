package com.sewingfactory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leather_details")
public class LeatherDetail {
    public LeatherDetail(
        String name,
        Double bp,
        Float lih,
        Float pfm
    ) {
        this.name = name;
        this.base_price = bp;
        this.labor_in_hours = lih;
        this.price_for_materials = pfm;
    }

    public LeatherDetail() {}

    @Id   
    @GeneratedValue   
    private Long id;

    private String name;

    private Double base_price;

    private Float labor_in_hours;

    private Float price_for_materials;
    
    // @ManyToOne()
    // private Employee created_by;

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

    public Double getBasePrice() {
        return base_price;
    }

    public void setBasePrice(Double price) {
        this.base_price = price;
    }

    public Float getLaborInHours() {
        return labor_in_hours;
    }

    public void setLaborInHours(Float labor_in_hours) {
        this.labor_in_hours = labor_in_hours;
    }

    public Float getPriceForMaterials() {
        return price_for_materials;
    }

    public void setPriceForMaterials(Float price_for_materials) {
        this.price_for_materials = price_for_materials;
    }

    @Override
    public String toString() {
        return "LeatherDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice='" + base_price + '\'' +
                '}';
    }
}
