package com.sewingfactory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "manufactured_leather_details")
public class ManufacturedLeatherDetail {

    public ManufacturedLeatherDetail(Employee e, LeatherDetail ld) {
        this.created_by = e;
        this.leather_detail = ld;
    }

    public ManufacturedLeatherDetail() {}

    @Id   
    @GeneratedValue   
    private Long id;

    @ManyToOne()
    private Employee created_by;

    @ManyToOne()
    private LeatherDetail leather_detail;

    private float price_for_manufacturing;

    private boolean isSold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy( Employee created_by) {
        this.created_by = created_by;
    }

    public LeatherDetail getLeatherDetail() {
        return leather_detail;
    }

    public void setCreatedBy( LeatherDetail leather_detail) {
        this.leather_detail = leather_detail;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public float getPriceForManufacturing() {
        return price_for_manufacturing;
    }

    public void setPriceForManufacturing(float priceForManufactoring) {
        this.price_for_manufacturing = priceForManufactoring;
    }

    @Override
    public String toString() {
        return "ManufacturedLeatherDetail{" +
                "id=" + id +
                '}';
    }
}
