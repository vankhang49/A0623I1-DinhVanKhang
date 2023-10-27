package sesson12.bai_tap.productManagement.view;

import sesson12.bai_tap.productManagement.controller.ProductController;

import java.util.Scanner;

public class ProductViewer {
    private static final ProductController viewer = new ProductController();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int select;
        do{
            System.out.println("-----Product Management System--------");
            System.out.println("1. Display product list");
            System.out.println("2. Add new product");
            System.out.println("3. Update product");
            System.out.println("4. remove product");
            System.out.println("5. Search product");
            System.out.println("6. Exit");
            System.out.print("Please input number: ");
            select = scanner.nextInt();
            viewer.func(select);
        }while (true);
    }
}
