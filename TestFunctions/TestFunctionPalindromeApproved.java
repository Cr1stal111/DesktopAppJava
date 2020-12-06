// package java_projects.desktopAppJava.TestFunctions;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFunctionPalindromeApproved {

    Palindrome palindrome = new Palindrome();
    
    private static boolean empty;

    private static boolean approve;

    private static boolean reject;

    @BeforeClass
    public static void setUp() {
        approve = true;
        reject = false;
    }

    @Test
    public void testPalindromeApproved() {

        assertTrue(palindrome.isPalindromeApproved(approve));
    }

    @Test
    public void testPalindromeRejected() {

        assertTrue(palindrome.isPalindromeApproved(reject));
    }
    
    @Test
    public void testPalindromeEmpty() {

        assertTrue(palindrome.isPalindromeApproved(empty));
    }

    @AfterClass
    public static void finish() {
        System.out.println("Testing is over");
    }
}
