package java_projects.desktopAppJava.TestFunctions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import jdk.jfr.Timestamp;

public class TestFunctionPalindromeRejected {

    Palindrome palindrome = new Palindrome();

    private static String string1;

    private static String string2;

    private static String string3;

    private static String string4;

    private static String string5;

    @BeforeClass
    public static void setUp() {
        string1 = null;
        string2 = "Палиндром";
        string3 = "ПалиндромморднилаП";
        string4 = "ItTi";
        string5 = "";
    }

    @Test
    public void testPalindromeStringIsNull() {
        boolean test = palindrome.isPalindromeRejected(string1);
        assertEquals(true, test);
    }

    @Test
    public void testPalindromeStringIsNullAttempt2() {
        assertNull(string1);
    }

    @Test
    public void testPalindromeStringIsEmpty() {
        assertNull(string5);
    }

    @Test
    public void testPalindromeString2() {
        assertTrue(palindrome.isPalindromeRejected(string2));
    }

    @Test
    public void testPalindromeString3() {
        assertTrue(palindrome.isPalindromeRejected(string3));
    }

    @Test
    public void testPalindromeString4() {
        assertTrue(palindrome.isPalindromeRejected(string4));
    }

    @AfterClass
    public static void finish() {
        System.out.println("Testing is over");
    }
}
