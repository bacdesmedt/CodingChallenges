package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
You are given an input list of strings, ordered by ascending length.

Write a function that returns True if, for each pair of consecutive strings, the second string can be formed from
the first by adding a single letter either at the beginning or end.

Examples
canBuild(["a", "at", "ate", "late", "plate", "plates"]) ➞ True
canBuild(["a", "at", "ate", "late", "plate", "plater", "platter"]) ➞ False
# "platter" is formed by adding "t" in the middle of "plater"
canBuild(["it", "bit", "bite", "biters"]) ➞ False
# "biters" is formed by adding two letters - we can only add one
canBuild(["mean", "meany"]) ➞ True

Notes
Return False if a word is NOT formed by adding only one letter.
Return False if the letter is added to the middle of the previous word.
Letters in tests will all be lower case.
 */
public class WordBuilding {

    public static void main(String[] args) {
        test(new String[]{ "a", "at", "ate", "late", "plate", "plates" }, true);
        test(new String[]{ "a", "at", "ate", "late", "plate", "plater", "platter" }, false);
        test(new String[]{ "it", "bit", "bite", "biters" }, false);
        test(new String[]{ "mean", "meany" }, true);
    }

    public static void test(String[] strings, boolean expected) {
        TestUtils.test(strings, expected, WordBuilding::canBuild);
    }

    public static boolean canBuild(String[] strings) {

        boolean can = true;
        int index = 1;

        while (can && index < strings.length) {
            String current = strings[index];
            String previous = strings[index - 1];
            can = (current.startsWith(previous) || current.endsWith(previous))
                    && current.length() - previous.length() == 1;
            index++;
        }
        return can;
    }
}
