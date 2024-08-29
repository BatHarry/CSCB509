package com.sewingfactory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    @Id   
    @GeneratedValue   
    private Long id;

    private String first_name;

    private String last_name;

    private Boolean experienced;

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
