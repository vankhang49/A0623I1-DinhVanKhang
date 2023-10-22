package sesson11.bai_tap;

import java.util.Stack;

public class CheckBracket {
    public static boolean checkBracket(String str){
        str = str.replaceAll(" ", "").toLowerCase();
        Stack<Character> bStack = new Stack<>();
        for (char c: str.toCharArray()){
            if (c == '('){
                bStack.push(c);
            } else if (c == ')'){
                if (bStack.isEmpty()){
                    return false;
                }
                char left = bStack.pop();
                if (left != '('){
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "s * (s - a) * (s - b) * (s - c)";
        String expression2 = "(- b + (b^2 - 4*a*c)^(0.5/ 2*a))";
        String expression3 = "s * (s - a) * (s - b * (s - c)";
        String expression4 = "s * (s - a) * s - b) * (s - c)";
        String expression5 = "(- b + (b^2 - 4*a*c)^(0.5/ 2*a))";

        System.out.println(expression1 + " → " + checkBracket(expression1));
        System.out.println(expression2 + " → " + checkBracket(expression2));
        System.out.println(expression3 + " → " + checkBracket(expression3));
        System.out.println(expression4 + " → " + checkBracket(expression4));
        System.out.println(expression5 + " → " + checkBracket(expression5));
    }
}
