package com.sewingfactory.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee(
        String fn,
        String ln,
        Boolean e
    ) {
        this.first_name = fn;
        this.last_name = ln;
        this.experienced = e;
    }

    public Employee() {}

    @Id   
    @GeneratedValue   
    private Long id;

    @NotBlank(message = "Името на служител не може да е празно")
    @Length(min = 2, max = 20, message = "Необходимия брой символи за име на служител е между 2 и 20")
    private String first_name;

    @NotBlank(message = "Фамилията на служител не може да е празна")
    @Length(min = 2, max = 20, message = "Необходимия брой символи за фамилия на служител е между 2 и 20")
    private String last_name;

    private Boolean experienced;

    @OneToMany(mappedBy = "created_by", fetch = FetchType.EAGER)
    private List<ManufacturedLeatherDetail> manufacturedLeatherDetail = new ArrayList<>();

    public List<ManufacturedLeatherDetail> getManufacturedLeatherDetail() {
        return manufacturedLeatherDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    } 

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    } 

    public Boolean getExperienced() {
        return experienced;
    }

    public void setExperienced(Boolean experienced) {
        this.experienced = experienced;
    } 

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", experienced='" + experienced + '\'' +
                '}';
    }
}
