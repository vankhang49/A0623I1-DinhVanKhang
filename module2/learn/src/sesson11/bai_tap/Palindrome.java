package sesson11.bai_tap;
import java.util.*;

public class Palindrome {
    public static boolean palindromeCheck(String str){
        str = str.replaceAll(" ", "").toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        for (char item: str.toCharArray()){
            queue.offer(item);
        }
        char[] arr = new char[str.length()];
        for (int i = queue.size()-1; i >=0 ; i--){
            arr[i] = queue.poll();
        }
        String reverseStr = new String(arr);
        return str.equals(reverseStr);
    }

    public static void main(String[] args) {
        String str = "Able was I ere i saw Elba";
        if(palindromeCheck(str)){
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }

    }
}
