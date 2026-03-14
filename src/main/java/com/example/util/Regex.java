package com.example.util;

import java.util.regex.Pattern;

public class Regex {
    public static boolean isEmailValid(String email) {
        return Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
                      .matcher(email).matches();
    }

    public static boolean isContactValid(String contact) {
        // Matches basic 10-digit phone numbers
        return Pattern.compile("^\\d{10}$").matcher(contact).matches();
    }
}