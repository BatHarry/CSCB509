package com.sewingfactory.DAL;

public class InventoryStats {
    private Long id;
    private String name;
    private Long count;
    private Float price;

    public InventoryStats(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public InventoryStats(Long id, String name, Float price, Long count) {
        this.id = id;
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
    public void setPrice(Float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "InventoryStats [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price + "]";
    }
}
