package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Create a function that takes in a sentence as input and returns the most common last vowel in the sentence as a single character string.

Examples
commonLastVowel("Hello World!") ➞ "o"

commonLastVowel("Watch the characters dance!") ➞ "a"

commonLastVowel("OOI UUI EEI AAI") ➞ "i"
Notes
There will only be one common last vowel in each sentence.
If the word has one vowel, treat the vowel as the last one even if it is at the start of the word.
The question asks you to compile all of the last vowels of each word and returns the vowel in the list which appears most often.
y won't count as a vowel.
Return outputs in lowercase.
 */
public class MostCommonLastVowel {

    public static void main(String[] args) {
        test("Hello World!", "o");
        test("Watch the characters dance!", "a");
        test("OOI UUI EEI AAI", "i");
    }

    public static void test(String string, String expected) {
        TestUtils.test(string, expected, MostCommonLastVowel::commonLastVowel);
    }

    public static String commonLastVowel(String string) {
        String[] words = string.toLowerCase().split(" +");
        String vowels = getVowels(words[words.length - 1]);

        return string.toLowerCase().codePoints()
                .mapToObj(cp -> Character.toString((char) cp))
                .filter(letter -> letter.matches(vowels))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow().getKey();
    }

    public static String getVowels(String word) {
        String lastVowels = word.codePoints()
                .mapToObj(cp -> Character.toString((char) cp))
                .filter(letter -> letter.matches("(?i)[aeiou]"))
                .reduce("", String::concat);
        return String.format("(?i)[%s]", lastVowels);
    }
}
