package com.ahamedifham;

public class ValidateISBN {

    public static final int LONG_ISBN = 13;
    public static final int SHORT_ISBN = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String value) {
        if (value.length() == LONG_ISBN) {
            return isThisAValidLongISBN(value);
        } else if ( value.length() == SHORT_ISBN){
            return isThisAValidShortISBN(value);
        } else {
            throw new NumberFormatException("Ivalid number of digits for ISBN");
        }
    }

    private boolean isThisAValidShortISBN(String value) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                if (i == 9 && value.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN number should only consists of digits");
                }
            } else {
                int valueToConsider = Integer.parseInt(value.substring(i, i + 1));
                total += valueToConsider * (SHORT_ISBN - i);
            }
        }
        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isThisAValidLongISBN(String value) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(value.charAt(i));
            } else {
                total += Character.getNumericValue(value.charAt(i)) * 3;
            }
        }
        return total % LONG_ISBN_MULTIPLIER == 0;
    }
}
