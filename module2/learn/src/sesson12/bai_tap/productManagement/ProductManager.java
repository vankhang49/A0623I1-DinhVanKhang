package sesson12.bai_tap.productManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager extends ArrayList<Product>{
    Scanner sc = new Scanner(System.in);
    private final ArrayList<Product> productArrayList;
    public ProductManager(){
        productArrayList = new ArrayList<>();
    }
    public void addProduct(Product product) {
        productArrayList.add(product);
    }
    public void setProduct(String id){
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
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
        }
    }
    public Product removeProduct(String idRemove){
        System.out.println(productArrayList.size());
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println(productArrayList.get(i).getId());
            if (productArrayList.get(i).getId().equals(idRemove)) {
                System.out.println(productArrayList.get(i).getName() + " has been deleted");
                return productArrayList.remove(i);
            }
        }
        return null;
    }
    public void displayProductList(){
        sortProductList();
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
    }
    public Product searchProduct(String name){
        for (Product product : productArrayList) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void sort(Comparator<? super Product> c) {
        super.sort(c);
    }

    public void sortProductList(){
        Collections.sort(productArrayList);
    }
}
