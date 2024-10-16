package com.sewingfactory.entities;

import com.sewingfactory.utils.CompanySingleton;

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
        Company c = CompanySingleton.getCompany();
        double experiencePenalty = e.getExperienced() ? 1 : 2.5;
        double laborCost = (e.getExperienced() ? c.getSeniorSalary() : c.getJuniorSalary()) * ld.getLaborInHours() * experiencePenalty;
        this.price_for_manufacturing = laborCost + ld.getPriceForMaterials();
    }

    public ManufacturedLeatherDetail() {}

    @Id   
    @GeneratedValue   
    private Long id;

    @ManyToOne()
    private Employee created_by;

    @ManyToOne()
    private LeatherDetail leather_detail;

    private double price_for_manufacturing;

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

    public double getPriceForManufacturing() {
        return price_for_manufacturing;
    }

    public void setPriceForManufacturing(float priceForManufactoring) {
        this.price_for_manufacturing = priceForManufactoring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
    
        ManufacturedLeatherDetail that = (ManufacturedLeatherDetail) o;
    
        if (this.leather_detail == null || that.leather_detail == null) return false;
        
        return this.leather_detail.getId() == that.leather_detail.getId();
    }
    
    @Override
    public int hashCode() {
        return leather_detail != null ? (int) leather_detail.getId() : 0;
    }

    @Override
    public String toString() {
        return "ManufacturedLeatherDetail{" +
                "id=" + id +
                '}';
    }
}
