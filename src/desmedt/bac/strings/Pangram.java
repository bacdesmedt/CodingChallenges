package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the
sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at
least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not.
Ignore numbers and punctuation.

 */
public class Pangram {

    public static void main(String[] args) {
        test("The quick brown fox jumps over the lazy dog.",true);
        test("You shall not pass!",false);
        test("Pack my box with five dozen liquor jugs.",true);
    }

    public static void test(String string, boolean expected) {
        TestUtils.test(string,expected,Pangram::isPangram);
    }

    public static boolean isPangram(String string) {
        return string.toLowerCase()
                .codePoints()
                .filter(Character::isLetter)
                .distinct()
                .count()
                == 26;
    }

}