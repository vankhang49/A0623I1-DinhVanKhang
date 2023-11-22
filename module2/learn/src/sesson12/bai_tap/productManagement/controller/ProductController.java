package sesson12.bai_tap.productManagement.controller;

import sesson12.bai_tap.productManagement.BO.ProductService;
import sesson12.bai_tap.productManagement.BOImpl.ProductServiceImp;
import sesson12.bai_tap.productManagement.DTO.Product;

import java.util.Scanner;

public class ProductController {
    private final ProductService service = new ProductServiceImp();
    public void func(int select){
        Scanner scanner = new Scanner(System.in);
        switch (select){
            case 1: //Display products list
                service.displayProduct();
                break;
            case 2: //Add new product
                System.out.print("Input name of product: ");
                String name = scanner.nextLine();
                System.out.print("Input id of product: ");
                String id = scanner.nextLine();
                System.out.println("Input price of product: ");
                int price = scanner.nextInt();
                Product product = new Product(name, id, price);
                service.addProduct(product);
                break;
            case 3: //Update List
                System.out.print("Input id of product you need to edit: ");
                id = scanner.nextLine();
                service.setProduct(id);
                break;
            case 4: //remove
                System.out.print("Input id of product you need to remove: ");
                id = scanner.nextLine();
                service.removeProduct(id);
                break;
            case 5: //Search product
                System.out.print("Input name of product you need to find: ");
                name = scanner.nextLine();
                service.searchProduct(name);
                break;
            case 6: //Exit
                System.exit(0);
        }
    }
}
