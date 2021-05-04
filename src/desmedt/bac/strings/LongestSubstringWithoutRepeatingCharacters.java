package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.HashMap;

/*
    Given a String str made of only alphabetical letter, create a function
    that returns the length of the longest substring without repeating characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        var str ="Given a String str made of only alphabetical letter, create a function " +
                "that returns the length of the longest substring without repeating characters";

        TestUtils.test(str,10, (String string)-> longestSubstringWithoutRepeating(string));
    }

    static int longestSubstringWithoutRepeating(String string) {
        return longestSubstringWithoutRepeating(string, 0);
    }

    static int longestSubstringWithoutRepeating(String string, int max){
        var map = new HashMap<Character,Integer>();
        var characters = string.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            var ch = characters[i];
            if (map.containsKey(ch)) {
                max = Math.max(max, i);
                return longestSubstringWithoutRepeating(string.substring( map.get(ch) + 1), max);
            }
            else map.put(ch, i);
        }
        return Math.max(max,string.length());
    }

}
