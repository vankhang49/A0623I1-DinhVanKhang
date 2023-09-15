package Sesson2.bai_tap;
import java.util.Scanner;
public class ShowTypes {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle " +
                "(The corner is square at 4 different angles: " +
                "top-left, top-right, botton-left, botton-right)");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter length: ");
                int length = sc.nextInt();
                System.out.println("Enter width: ");
                int width = sc.nextInt();
                String draw = "";
                for(int i = 1; i<=width; i++){
                    for(int j = 1; j<=length; j++){
                        draw += "*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                break;
            case 2:
                System.out.println("Enter height: ");
                int height = sc.nextInt();
                draw = "";
                for(int i = 1; i<=height; i++){
                    for(int j = 1; j<=i; j++){
                        draw += "*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                draw= "";
                for(int i = height; i>=1; i--){
                    for(int j = 1; j<=i; j++){
                        draw += "*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                draw= "";
                for(int i = 1; i<=height; i++){
                    for(int j = 1; j<i; j++){
                        draw += " ";
                    }
                    for(int k = 1; k<= height-i+1; k++){
                        draw+="*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                draw= "";
                for(int i = 1; i<=height; i++){
                    for(int j = 1; j<=height-i; j++){
                        draw += " ";
                    }
                    for(int k = 1; k<= i; k++){
                        draw+="*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                break;
            case 3:
                System.out.println("Enter height: ");
                height = sc.nextInt();
                draw = "";
                for(int i = 1; i<=height; i++){
                    for(int j = 1; j<=height-i; j++){
                        draw += " ";
                    }
                    for(int k = 1; k<= 2*i-1; k++){
                        draw += "*";
                    }
                    draw += "\n";
                }
                System.out.println(draw);
                break;
            case 4:
                System.out.println("No choice!");
                break;
        }
    }
}
