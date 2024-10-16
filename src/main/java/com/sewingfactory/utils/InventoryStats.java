package com.sewingfactory.utils;

public class InventoryStats {
    private Long id;
    private String name;
    private Long count;
    private Double price;

    public InventoryStats(Long id) {
        this.id = id;
    }

    public InventoryStats(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public InventoryStats(Long id, String name, Double price, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Long getCount() {
        return count;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
    
        InventoryStats that = (InventoryStats) o;
    
        if (this.id == null || that.id == null) return false;
        
        return this.id == that.id;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.intValue() : 0;
    }
    
    @Override
    public String toString() {
        return "InventoryStats [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price + "]";
    }
}
