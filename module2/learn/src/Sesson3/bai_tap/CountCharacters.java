package Sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class CountCharacters {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = "Counts the number of repetitions of a character in string";
        System.out.println("Enter a character you want to count: ");
        char a = sc.next().charAt(0);
        int count = countCharacter(str, a);
        System.out.println("The number of occurrences of the character" + a + " is "+ count);
    }
    public static int countCharacter(String str, char character){
        int count = 0;
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == character){
                count++;
            }
        }
        return count;
    }
}
