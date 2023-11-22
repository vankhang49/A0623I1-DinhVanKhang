package sesson18.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        EmailExample emailExample = new EmailExample();
        String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
        String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };
        for (String email : validEmail) {
            boolean valid = emailExample.validate(email);
            System.out.println("Email is " + email +" is valid: "+ valid);
        }
        for (String email : invalidEmail) {
            boolean inValid = emailExample.validate(email);
            System.out.println("Email is " + email +" is valid: "+ inValid);
        }
    }
}
