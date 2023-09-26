package sesson4.bai_tap;
import java.util.Scanner;
public class CalculateQuadraticEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number a: ");
        double a = sc.nextDouble();
        System.out.println("Enter a number b: ");
        double b = sc.nextDouble();
        System.out.println("Enter a number c: ");
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double discriminant = quadraticEquation.getDiscriminant();
        if(discriminant<0){
            System.out.println("The equation has no solution!");
        } else if(discriminant ==0){
            System.out.println("The equation has a single karma x1 = x2 = " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has 2 solutions: x1 = "
                    + quadraticEquation.getRoot1() + ", x2 = " + quadraticEquation.getRoot2());
        }
    }
}
class QuadraticEquation{
    double a, b, c;
    public QuadraticEquation(){
    }
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getDiscriminant(){
        return (this.b*this.b) - 4*this.a*this.c;
    }
    public double getRoot1(){
        double x1 = 0;
        double getDiscriminant = getDiscriminant();
        if(getDiscriminant == 0){
            x1 = (-this.b)/(2*a);
        } else if(getDiscriminant>0){
            x1 = (-this.b - Math.sqrt(getDiscriminant))/this.a;
        }
        return x1;
    }
    public double getRoot2(){
        double x2 = 0;
        double getDiscriminant = getDiscriminant();
        if(getDiscriminant == 0){
            x2= (-this.b)/(2*a);
        } else if(getDiscriminant>0) {
            x2 = (-this.b + Math.sqrt(getDiscriminant))/this.a;
        }
        return x2;
    }
}
