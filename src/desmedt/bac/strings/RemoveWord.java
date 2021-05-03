package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
Implement a method removeWord() that takes two string parameters:

sentence - the sentence you are to remove a word from.
word - the word you are to remove from the sentence.
Your method should take a string, sentence and remove word from it.
It will return a new string without word in the sentence.

Examples
removeWord("One two three four", "two") ➞ "One three four"

removeWord("Bob has a kid", "kid") ➞ "Bob has a"
 */
public class RemoveWord {

    public static void main(String[] args) {
        test("One two three four", "two", "One three four");
        test("Bob has a kid", "kid", "Bob has a");
    }

    public static void test(String string, String word, String expected) {
        TestUtils.test(string, word, expected, RemoveWord::removeWord);
    }

    public static String removeWord(String string, String word) {
        String[] words = string.split(" +");
        StringBuilder builder = new StringBuilder(string.length() - word.length());

        for (String s : words) {
            if (!s.equals(word)) {
                builder.append(s);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }
}
