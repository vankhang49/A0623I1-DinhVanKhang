package sesson18.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassCodeGym {
    private Pattern pattern;
    private Matcher matcher;
    private static final String CLASSNAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";

    public ClassCodeGym() {
        this.pattern = Pattern.compile(CLASSNAME_REGEX);
    }
    public boolean validate(String regex) {
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        ClassCodeGym classCodeGym = new ClassCodeGym();
        String[] validClass = {"C0318G", "A0623I", "P0723H"};
        String[] invalidClass = {"M0318G", "P0323A"};
        for (String c: validClass){
            boolean valid = classCodeGym.validate(c);
            System.out.println("Class " + c + " is valid: " + valid);
        }
        for (String c: invalidClass){
            boolean valid = classCodeGym.validate(c);
            System.out.println("Class " + c + " is valid: " + valid);
        }
    }
}
