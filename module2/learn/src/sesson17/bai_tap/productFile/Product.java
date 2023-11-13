package sesson17.bai_tap.productFile;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{ id= " + id + ", name= " + name + ", brand= " + brand + ", price=" + price + '}';
    }
}
