package com.ahamedifham;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTests {
    @Test
    public void checkValid10DISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result  = validator.checkISBN("0140449116");
        assertTrue("first value" ,result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value" ,result);
    }

    @Test
    public void checkValid13DISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result  = validator.checkISBN("9781853260087");
        assertTrue(result);
        result = validator.checkISBN("9781853267338");
        assertTrue(result);
    }

    @Test
    public void checkInvalid10DISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result  = validator.checkISBN("0140449016");
        assertFalse(result);
    }

    @Test
    public void checkInvalid13DISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result  = validator.checkISBN("9781853267336");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void checkIncorrectLengthOfISBN(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void invalid10DNumberFormatInput(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("1b3456789");
    }

    @Test
    public void ISBN10DNumbersEndingInXAreValid()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result  = validator.checkISBN("012000030X");
        assertTrue(result);
    }
}
