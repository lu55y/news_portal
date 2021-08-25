package by.it.academy.service.validator;

import by.it.academy.bean.RegistrationInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    //A-Z characters are permitted
    //a-z characters are permitted
    //0-9 digits are permitted
    //Underscore(_), dash(-), and dot(.) are permitted
    //Other characters are not permitted
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    //^ represents starting character of the string.
    //(?=.*[0-9]) represents a digit must occur at least once.
    //(?=.*[a-z]) represents a lower case alphabet must occur at least once.
    //(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
    //(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
    //(?=\\S+$) white spaces don’t allowed in the entire string.
    //.{8, 20} represents at least 8 characters and at most 20 characters.
    //$ represents the end of the string.
    private static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

    public Validation() {
    }

    public boolean validate(RegistrationInfo info) {
        String email = info.getEmail();
        String password = info.getPassword();
        if (!email.isEmpty() && !password.isEmpty()) {
            if (validateEmail(email) && validatePassword(password)) {
            return true;
            }
            System.out.println("ERROR: not valid");
            return false;
        } else
            System.out.println("ERROR: info is empty!");
            return false;
    }

    private static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
