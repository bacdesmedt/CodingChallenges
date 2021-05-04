package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Given a String string made of alphabetical letters only, create a function that returns the length of
    the longest palindrome that can be made from those letters.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        test("abbaba",5);
        test("abbaaa",6);
        test("abbabab",7);
        test("abdccdceeebebc",13);
    }

    public static void test(String string, int expected) {
        TestUtils.test(string, expected, LongestPalindrome::longestPalindrome);
    }

    public static int longestPalindrome(String string) {
        if (string == null || string.isEmpty() || !string.matches("(?i)^[a-z]+$")) return 0; // validity check

        Map<String, Long> map = string.codePoints()
                .mapToObj(codePoint -> Character.toString((char) codePoint))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long sum = map.values().stream().map(l -> (l % 2 == 0) ? l : l - 1).reduce(0L, Long::sum);

        return (int) (sum < string.length() ? sum + 1 : sum);
    }
}
