package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
lPaeesh le pemu mnxit ehess rtnisg! Oh, sorry, that was supposed to say: Please help me unmix these strings!
Somehow my strings have all become mixed up; every pair of characters has been swapped.
Help me undo this so I can understand my strings again.

Examples
unmix("123456") ➞ "214365"
unmix("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
unmix("badce") ➞ "abcde"

Notes
The length of a string can be odd — in this case the last character is not altered (as there's nothing to swap it with).
 */
public class UnmixStrings {

    public static void main(String[] args) {
        test("123456", "214365");
        test("hTsii  s aimex dpus rtni.g", "This is a mixed up string.");
        test("badce", "abcde");
    }

    public static void test(String string, String expected) {
        TestUtils.test(string, expected, UnmixStrings::unmix);
    }

    public static String unmix(String string) {
        StringBuilder builder = new StringBuilder(string.length());

        for (String s : string.split("(?<=\\G..)")) {
            if (s.length() > 1) {
                builder.append(s.charAt(1));
                builder.append(s.charAt(0));
            } else builder.append(s);
        }

        return builder.toString();
    }
}
