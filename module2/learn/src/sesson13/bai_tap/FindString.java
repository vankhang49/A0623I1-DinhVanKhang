package sesson13.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class FindString {
    public static String findString(String str){
        LinkedList<Character> maxList = new LinkedList<>();
        for (int i = 0; i < str.length(); i++){
            LinkedList<Character> childList = new LinkedList<>();
            childList.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++){
                if (str.charAt(j) > childList.getLast()){
                    childList.add(str.charAt(j));
                }
            }
            if(childList.size() > maxList.size()){
                maxList.clear();
                maxList.addAll(childList);
            }
            childList.clear();
        }
        StringBuilder strBuilder = new StringBuilder();
        for (Character c: maxList){
            strBuilder.append(c);
        }
        return str = strBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        String findHeight = findString(str);
        System.out.println(findHeight);
    }
}

/*********************************************************************
 *             Độ phức tạp của thuật toán                            *
 *      * ( 1 vòng lặp ngoài: O(n)                                   *
 *        1 vòng lặp bên trong * 1 câu lệnh rẽ nhánh: O((n-1)*1)     *
 *        1 câu lệnh rẽ nhánh: O(1) ) *                              *
 *        1 vòng lặp: O(n)                                           *
 *      T(n) = O(n*(n-1)*1 + n)                                      *
 *      T(n) = O(n^2 - n +n)                                         *
 *      => Độ phức tap của thuật toán là T(n) = O(n^2)               *
 * Tức độ phức tạp của thuaật toán bằng bình phương độ dài của chuỗi *
 *********************************************************************/
