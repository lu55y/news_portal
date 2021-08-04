package by.it.academy.service.validator;

import by.it.academy.beans.RegistrationInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String VALID_EMAIL="\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    private static final String VALID_PASSWORD="(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public Validation() {
    }

    public boolean validate(RegistrationInfo info) {
        return false;
    }

    private static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(VALID_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(VALID_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
