package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
A string is an almost-palindrome if, by changing only one character, you can make it a palindrome. Create a function
that returns true if a string is an almost-palindrome and false otherwise.

        Examples
        almostPalindrome("abcdcbg") ➞ true
// Transformed to "abcdcba" by changing "g" to "a".

        almostPalindrome("abccia") ➞ true
// Transformed to "abccba" by changing "i" to "b".

        almostPalindrome("abcdaaa") ➞ false
// Can't be transformed to a palindrome in exactly 1 turn.

        almostPalindrome("1234312") ➞ false
        Notes
        Return false if the string is already a palindrome. */
public class AlmostPalindrome {

    public static void main(String[] args) {
        test("abcdcbg", true);
        test("abccia", true);
        test("abcdaaa", false);
        test("1234312", false);
    }

    public static void test(String string, boolean expected) {
        TestUtils.test(string, expected, AlmostPalindrome::almostPalindrome);
    }

    public static boolean almostPalindrome(String string) {
        int mismatch = 0;

        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) mismatch++;
        }
        return mismatch == 1;
    }
}
