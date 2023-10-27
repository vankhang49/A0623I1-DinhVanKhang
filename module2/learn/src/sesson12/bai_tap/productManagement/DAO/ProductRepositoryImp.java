package sesson12.bai_tap.productManagement.DAO;

import sesson12.bai_tap.productManagement.DTO.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductRepositoryImp implements ProductRepository {
    Scanner sc = new Scanner(System.in);
    private static final ArrayList<Product> productArrayList = new ArrayList<>();;
    static {
        productArrayList.add(new Product("Hoodie", "AH", 200000));
        productArrayList.add(new Product("Jeans", "QJ", 120000));
        productArrayList.add(new Product("Sweeter", "AS", 150000));
        productArrayList.add(new Product("Bucket Hat", "MBH", 70000));
    }

    @Override
    public int getSize() {
        return productArrayList.size();
    }

    @Override
    public void addProduct(Product product) {
        productArrayList.add(product);
    }

    @Override
    public void setProduct(String id) {
        Product product = searchProductById(id);
        System.out.println("Enter your choice of the item you want to edit: ");
        String choice = sc.nextLine();
        switch (choice) {
            case "name":
                System.out.println("Enter the name you want to edit: ");
                String nameEdit = sc.nextLine();
                product.setName(nameEdit);
                break;
            case "id":
                System.out.println("Enter the id you want to edit: ");
                String idEdit = sc.nextLine();
                product.setId(idEdit);
                break;
            case "price":
                System.out.println("Enter the price you want to edit: ");
                int priceEdit = sc.nextInt();
                product.setPrice(priceEdit);
                break;
        }
    }

    @Override
    public Product removeProduct(String idRemove) {
        Product product = searchProductById(idRemove);
        int index = productArrayList.indexOf(product);
        return productArrayList.remove(index);
    }

    @Override
    public void displayProduct() {
        sortProductList();
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
    }

    @Override
    public Product searchProductById(String id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
    @Override
    public Product searchProduct(String name) {
        for (Product product : productArrayList) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    @Override
    public void sortProductList() {
        Collections.sort(productArrayList);
    }
}
