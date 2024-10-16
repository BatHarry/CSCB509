package com.sewingfactory.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    @NotBlank(message = "Името на продукт не може да е празно")
    @Length(min = 2, max = 100, message = "Необходимия брой символи за име на продукт е между 2 и 100")
    private String name;

    @Min(value = 1, message = "Цената на продукт не може да е по-малко от 1лв")
    @Max(value = 10000, message = "Цената на продукт не може да е повече от 10000лв")
    private Double base_price;

    @DecimalMin(value = "0.5", message = "Времето за изработка на продукт не може да е по-малко от 1")
    @Max(value = 10000, message = "Цената на продукт не може да е повече от 10000лв")
    private Float labor_in_hours;

    @DecimalMin(value = "0.5", message = "Цената на материалите не може да е по-малко от 0.5лв")
    @Max(value = 1000, message = "Цената на материалите не може да е повече от 1000лв")
    private Float price_for_materials;

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
