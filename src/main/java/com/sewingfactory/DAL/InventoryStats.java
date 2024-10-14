package com.sewingfactory.DAL;

public class InventoryStats {
    private String name;
    private Long count;
    private Float price;

    public InventoryStats(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public InventoryStats(String name, Float price, Long count) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Long getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "InventoryStats [name=" + name + ", count=" + count + ", price=" + price + "]";
    }
}
