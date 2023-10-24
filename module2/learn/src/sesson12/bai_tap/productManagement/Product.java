package sesson12.bai_tap.productManagement;

public class Product implements Comparable<Product> {
    private String name;
    private String id;
    private int price;
    public Product(){};
    public Product(String name, String id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{'" + name + "', id = " + id +", price = " + price + '}';
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.getPrice(), o.getPrice());
    }
}
