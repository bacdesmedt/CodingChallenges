package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
    Needle in a Hex String
Find the index of a string within a hex encoded string.

You will be given a string which needs to be found in another string which has previously been translated into hex.
You will need to return the first index of the needle within the hex encoded string.

Examples
firstIndex("68 65 6c 6c 6f 20 77 6f 72 6c 64", "world") ➞ 6
firstIndex("47 6f 6f 64 62 79 65 20 77 6f 72 6c 64", "world") ➞ 8
firstIndex("42 6f 72 65 64 20 77 6f 72 6c 64", "Bored") ➞ 0
 */
public class HexString {

    public static void main(String[] args) {
        test("68 65 6c 6c 6f 20 77 6f 72 6c 64", "world", 6);

        test("47 6f 6f 64 62 79 65 20 77 6f 72 6c 64", "world", 8);

        test("42 6f 72 65 64 20 77 6f 72 6c 64", "Bored", 0);
    }

    public static void test(String hex, String needle, int expected) {
        TestUtils.test(hex, needle, expected, HexString::firstIndex);
    }

    public static int firstIndex(String hex, String needle) {
        return Arrays.stream(hex.split(" +"))
                .map(h -> Character.toString((char) Integer.parseInt(h, 16)))
                .reduce("", String::concat)
                .indexOf(needle);

    }
}
