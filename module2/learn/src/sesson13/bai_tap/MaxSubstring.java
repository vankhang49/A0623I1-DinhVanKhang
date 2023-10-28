package sesson13.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxSubstring {
    public static String maxSubstring(String string){
        LinkedList<Character> maxList = new LinkedList<>();
        LinkedList<Character> childList = new LinkedList<>();

        for (int i = 0; i < string.length(); i++){
            if (childList.size() > 1 && string.charAt(i) <= childList.getLast()
            && childList.contains(string.charAt(i))){
                childList.clear();
            }
            childList.add(string.charAt(i));
            if (childList.size() > maxList.size()){
                maxList.clear();
                maxList.addAll(childList);
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        for (Character c: maxList){
            strBuilder.append(c);
        }
        return string = strBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        System.out.println(str);
        System.out.println(maxSubstring(str));
    }
}

/*********************************************************************
 *             Độ phức tạp của thuật toán                            *
 *        1 vòng lặp * 3 câu lệnh: O(n)                              *
 *        1 vòng lặp * 1 câu lệnh: O(n)                              *
 *      T(n) = O(n) + O(n)                                           *
 *      T(n) = O(n)                                                  *
 *      => Độ phức tap của thuật toán là T(n) = O(n)                 *
 * Tức độ phức tạp của thuật toán bằng độ dài của chuỗi              *
 *********************************************************************/
