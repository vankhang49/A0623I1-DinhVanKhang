package sesson11.bai_tap.treeMap;

import java.util.Scanner;
import java.util.TreeMap;

public class frequencyAppears {
    public static void frequencyAppears(String str){
        str = str.toLowerCase();
        String[] arr = str.split("");
        TreeMap<String, Integer> countChar = new TreeMap<>();
        for (String word : arr) {
            if (countChar.containsKey(word)) {
                countChar.put(word, countChar.get(word) + 1);
            } else {
                countChar.put(word, 1);
            }
        }
        System.out.println("List of words and number of occurrences in alphabetical order: ");
        for (String word: countChar.keySet()){
            System.out.println(word + " : " + countChar.get(word));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of characters: ");
        String str = sc.nextLine();
        frequencyAppears(str);
    }
}
