package sesson12.bai_tap.productManagement;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Product product1 = new Product("Hoodie", "AH", 200000);
        Product product2 = new Product("Jeans", "QJ", 120000);
        Product product3 = new Product("Sweeter", "AS", 150000);
        Product product4 = new Product("Bucket Hat", "MBH", 70000);
        ProductManager productManager = new ProductManager();
        productManager.addProduct(product1);
        productManager.addProduct(product2);
        productManager.addProduct(product3);
        productManager.addProduct(product4);
        Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println("-----Student System--------");
            System.out.println("1. Display products list");
            System.out.println("2. Add new product");
            System.out.println("3. Update");
            System.out.println("4. remove");
            System.out.println("5. Search product");
            System.out.println("6. Exit");
            System.out.print("Please input number: ");
            select = sc.nextInt();
            switch (select){
                case 1:
                    productManager.displayProductList();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter the name of product: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the id of product: ");
                    String id = sc.nextLine();
                    System.out.println("Enter the price of product: ");
                    int price = sc.nextInt();
                    Product product = new Product(name, id, price);
                    productManager.addProduct(product);
                    System.out.println("The product has been added!");
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the id of product you want to edit");
                    String idEdit = sc.nextLine();
                    productManager.setProduct(idEdit);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the id of product you want to edit");
                    String idRemove = sc.nextLine();
                    productManager.removeProduct(idRemove);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter the product you want to find: ");
                    String searchName = sc.nextLine();
                    Product productFind = productManager.searchProduct(searchName);
                    if (productFind != null){
                        System.out.println("Your product: " + productFind.toString());
                    } else {
                        System.out.println("No product found!");
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
