package sesson18.thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public AccountExample() {
        pattern = Pattern.compile(ACCOUNT_REGEX);
    }
    public boolean validate(String regex) {
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        String[] validAccount = {"123abc_", "_abc123", "______", "123456", "abcdefg"};
        String[] invalidAccount = {".@", "12345", "1234_", "abcde"};
        for (String account: validAccount){
            boolean valid = accountExample.validate(account);
            System.out.println("Account " + account + " is valid: " + valid);
        }
        for (String account: invalidAccount){
            boolean valid = accountExample.validate(account);
            System.out.println("Account " + account + " is valid: " + valid);
        }
    }
}
