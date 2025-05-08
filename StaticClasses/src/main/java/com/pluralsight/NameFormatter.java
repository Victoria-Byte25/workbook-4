package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {}

    // Format: LastName, FirstName
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Format: LastName, Prefix FirstName MiddleName, Suffix
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder result = new StringBuilder(lastName + ", ");

        if (prefix != null && !prefix.isEmpty()) {
            result.append(prefix).append(" ");
        }

        result.append(firstName);

        if (middleName != null && !middleName.isEmpty()) {
            result.append(" ").append(middleName);
        }

        if (suffix != null && !suffix.isEmpty()) {
            result.append(", ").append(suffix);
        }

        return result.toString();
    }

    // Format from full name string
    public static String format(String fullName) {
        String[] parts = fullName.split(",");
        String namePart = parts[0].trim();
        String suffix = parts.length > 1 ? parts[1].trim() : "";

        String[] nameTokens = namePart.split(" ");
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameTokens.length == 4) {
            prefix = nameTokens[0];
            firstName = nameTokens[1];
            middleName = nameTokens[2];
            lastName = nameTokens[3];
        } else if (nameTokens.length == 3) {
            firstName = nameTokens[0];
            middleName = nameTokens[1];
            lastName = nameTokens[2];
        } else if (nameTokens.length == 2) {
            firstName = nameTokens[0];
            lastName = nameTokens[1];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
