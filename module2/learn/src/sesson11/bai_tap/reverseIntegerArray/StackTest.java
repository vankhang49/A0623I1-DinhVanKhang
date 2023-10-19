package sesson11.bai_tap.reverseIntegerArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("choose one of 2 options: ");
            System.out.println("1. Reverse integerList");
            System.out.println("2. Reverse String");
            System.out.println("0. Out programing");
            int select = sc.nextInt();
            switch (select){
                case 1:
                    LinkedList<Integer> integerList= new LinkedList<>();
                    System.out.println("Enter the number of elements you want to import: ");
                    int length = sc.nextInt();
                    for(int i = 0; i < length; i++){
                        System.out.println("Enter the " + (i+1) + "th number: ");
                        integerList.addFirst(sc.nextInt());
                    }
                    System.out.println("Your integer list: ");
                    for (Integer item : integerList){
                        System.out.print(item + " ");
                    }
                    reverseIntegerArray(integerList);
                    System.out.println("\nYour list after reverse: ");
                    for (Integer item : integerList){
                        System.out.print(item + " ");
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter a string of characters: ");
                    String str = sc.nextLine();
                    String[] arr = str.split("");
                    LinkedList<String> charList = new LinkedList<>(Arrays.asList(arr));
                    System.out.println("String after reverse: ");
                    reverseString(charList);
                    str = toString(charList);
                    System.out.println(str);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    public static void reverseIntegerArray(LinkedList<Integer> list){
        Stack<Integer> stack = new Stack<>();
        for (Integer item: list){
            stack.push(item);
        }
        list.clear();
        while (!stack.isEmpty()){
            list.addLast(stack.pop());
        }
    }
    public static void reverseString(LinkedList<String> list){
        Stack<String> stack = new Stack<>();
        for (String item: list){
            stack.push(item);
        }
        list.clear();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
    }
    public static String toString(LinkedList<String> list){
        StringBuilder str = new StringBuilder();
        for(String item: list){
            str.append(item);
        }
        return str.toString();
    }
}
