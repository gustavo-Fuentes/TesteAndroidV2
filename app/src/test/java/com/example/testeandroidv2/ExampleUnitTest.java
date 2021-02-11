package com.example.testeandroidv2;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validatePassword(){

        assertTrue(passwordValidate("Test@1"));


    }

    public boolean passwordValidate(String password) {

        String password_regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&+^=])(?=\\S+$).{4,}$";
        return password.matches(password_regex);
    }

}