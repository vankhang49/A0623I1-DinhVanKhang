package caseStudy.untils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    static Scanner sc = new Scanner(System.in);
    public static String validate(String regex,String ip) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        boolean isValid = matcher.matches();

        while (!isValid) {
            System.out.println("Format is incorrect, please re-enter!");
            ip = sc.nextLine();

            matcher = pattern.matcher(ip);
            isValid = matcher.matches();
        }
        return ip;
    }
}
