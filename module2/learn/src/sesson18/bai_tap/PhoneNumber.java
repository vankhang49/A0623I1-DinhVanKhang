package sesson18.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public PhoneNumber() {
        pattern = Pattern.compile(PHONE_REGEX);
    }
    public boolean validate(String regex) {
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        String[] validPhone = {"(84)-(0978489648)", "(32)-(0701973563)",  "(84)-(0905123456)"};
        String[] invalidPhone = {"(a4)-(0978489648)", "(32)-(0ab1973cd63)",  "(84)-(09051&%456)"};
        for (String p: validPhone){
            boolean valid = phoneNumber.validate(p);
            System.out.println("Class " + p + " is valid: " + valid);
        }
        for (String p: invalidPhone){
            boolean valid = phoneNumber.validate(p);
            System.out.println("Class " + p + " is valid: " + valid);
        }
    }
}
