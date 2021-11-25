package com.enbaev;

public class CheckForRegistration {

    public static boolean checkNullForRegistration(String name, String lastName, String women,
                                                   String men, String password) {
        String space = "";
        if (name.equals(space) || lastName.equals(space) || password.equals(space)) {
            return false;
        }
        return women != null || men != null;
    }

    public static boolean checkCorrectPassword(String password) {
        return password.length() >= 6;
    }

    public static boolean checkAgree(String agree) {
        return agree == null;
    }

    public static boolean checkNameLastNameContainsNumber(String name, String lastName) {
        return name.matches("[A-z]*") && lastName.matches("[A-z]*");
    }
}
