package sesson11.bai_tap.covertDecimalToBinary;

import java.util.Stack;

public class ConvertCoefficients {
    public static Stack<Integer> covertDecimalToBinary(Stack<Integer> stack){
        Stack<Integer> binaryStack = new Stack<>();
        for (int item: stack){
            binaryStack.push(Integer.valueOf(Integer.toBinaryString(item)));
        }
        return binaryStack;
    }
    public static Stack<Integer> covertBinaryToDecimal(Stack<Integer> stack){
        Stack<Integer> decimalStack = new Stack<>();
        for (int item: stack){
            decimalStack.push(Integer.parseInt(String.valueOf(item), 2));
        }
        return decimalStack;
    }
    public static Stack<String> covertDecimalToHexadecimal(Stack<Integer> stack){
        Stack<String> hexadecimalStack = new Stack<>();
        for (int item: stack){
            hexadecimalStack.push(Integer.toHexString(item));
        }
        return hexadecimalStack;
    }
    public static Stack<Integer> covertHexadecimalToDecimal(Stack<Integer> stack){
        Stack<Integer> decimalStack = new Stack<>();
        for (int item: stack){
            decimalStack.push(Integer.parseInt(String.valueOf(item), 16));
        }
        return decimalStack;
    }
    public static StringBuilder toCoString(Stack<Integer> stack){
        StringBuilder str = new StringBuilder();
        for (int item: stack){
            str.append(item);
        }
        return str;
    }
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        Stack<Integer> binaryStack = covertDecimalToBinary(myStack);
        for (int item: binaryStack){
            System.out.print(item + " ");
        }
        System.out.println("\n" + toCoString(binaryStack));

        Stack<String> hexadecimalStack = covertDecimalToHexadecimal(myStack);
        for (String item: hexadecimalStack){
            System.out.print(item + " ");
        }
    }
}
