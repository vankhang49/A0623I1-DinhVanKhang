package sesson9.viewer;

import sesson9.controller.StudentController;

import java.util.Scanner;

public class StudentViewer {
    private static final StudentController viewer = new StudentController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("-----Student System--------");
            System.out.println("1. List");
            System.out.println("2. Add new");
            System.out.println("3. Update");
            System.out.println("4. remove");
            System.out.println("5. Exit");
            System.out.print("Please input number: ");
            select = scanner.nextInt();
            viewer.function(select);
        } while (true);
    }
}
