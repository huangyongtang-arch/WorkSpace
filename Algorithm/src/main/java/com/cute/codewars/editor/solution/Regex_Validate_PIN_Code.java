package com.cute.codewars.editor.solution;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
/**
 * @ClassName Regex_Validate_PIN_Code
 * @Description
 * @Author tommy
 * @Date 7/6/2020 7:32 PM
 **/
public class Regex_Validate_PIN_Code {
    public static boolean validatePIN(String pin) {
        if (pin.length() != 4 && pin.length() != 6) {
            return false;
        }
        int count = pin.replaceAll("[^\\d]", "").length();
        if (count == 4 || count == 6) {
            return true;
        }
        return false;
    }
    public static boolean validatePin1(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }
    public static boolean validatePin2(String pin) {
        if (pin.length() == 4 || pin.length() == 6) {
            return pin.chars().allMatch(Character::isDigit);
        }
        return false;
    }
    public static boolean validatePin3(String pin) {
        // Your code here...
        return (pin.length() == 4 || pin.length() == 6) && pin.replaceAll("[0-9]","").length() == 0;
    }
    public static boolean validatePin4(String pin) {
        return pin.matches("^\\d{4}(\\d\\d)?$");
    }
    @Test
    public void solution(){
        System.out.println(Regex_Validate_PIN_Code.validatePIN("1234"));
        System.out.println(Regex_Validate_PIN_Code.validatePIN("a234"));
        System.out.println(Regex_Validate_PIN_Code.validatePIN("123456"));
        System.out.println(Regex_Validate_PIN_Code.validatePIN("1234567"));
        System.out.println(Regex_Validate_PIN_Code.validatePIN("1234"));
        System.out.println(Regex_Validate_PIN_Code.validatePIN("-1234"));
    }

    public static class SolutionTest {
        @Test
        public void validPins() {
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("1234"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("0000"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("1111"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("123456"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("098765"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("000000"));
            assertEquals(true, Regex_Validate_PIN_Code.validatePIN("090909"));
        }

        @Test
        public void nonDigitCharacters() {
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("a234"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN(".234"));
        }

        @Test
        public void invalidLengths() {
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("1"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("12"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("123"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("12345"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("1234567"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("-1234"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("1.234"));
            assertEquals(false, Regex_Validate_PIN_Code.validatePIN("00000000"));
        }
    }
}
