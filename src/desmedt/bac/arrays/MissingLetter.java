package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

/*
Create a function that takes an array of increasing letters and return the missing letter.

Examples
missingLetter(["a", "b", "c", "e", "f", "g"]) ➞ "d"
missingLetter(["O", "Q", "R", "S"]) ➞ "P"
missingLetter(["t", "u", "v", "w", "x", "z"]) ➞ "y"
missingLetter(["m", "o"]) ➞ "n"

Notes
Tests will always have exactly one letter missing.
The length of the test array will always be at least two.
Tests will be in one particular case (upper or lower but never both).
 */
public class MissingLetter {

    public static void main(String[] args) {
        test(new String[]{ "a", "b", "c", "e", "f", "g" }, "d");
        test(new String[]{ "O", "Q", "R", "S" }, "P");
        test(new String[]{ "t", "u", "v", "w", "x", "z" }, "y");
        test(new String[]{ "m", "o" }, "n");
    }

    public static void test(String[] strings, String expected) {
        TestUtils.test(strings, expected, MissingLetter::missingLetter);
    }

    public static String missingLetter(String[] arr) {
        if (arr != null && arr.length > 0) {
            char first = arr[0].charAt(0);
            int length = arr[arr.length - 1].charAt(0) - first + 1;
            boolean[] checks = new boolean[length];
            for (String s : arr) {
                int i = s.charAt(0) - first;
                checks[i] = true;
            }

            for (int i = 0; i < checks.length; i++) {
                if (!checks[i]) return Character.toString((char) i + first);
            }
        }
        return null;
    }
}
