package sesson12.bai_tap.productManagement.BO;

import sesson12.bai_tap.productManagement.DTO.Product;

public interface ProductService {
    void addProduct(Product product);
    void setProduct(String id);
    void removeProduct(String idRemove);
    void displayProduct();
    void searchProduct(String name);
}
