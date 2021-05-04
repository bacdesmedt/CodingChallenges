package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.HashSet;

/*
    Given a string str, create a function that returns the first repeating character
    If such a character doesn't exist, return the null character '\0'
*/
public class FirstRepeatingChar {
    public static void main(String[] args) {
        TestUtils.test("abcdefghije",'e',FirstRepeatingChar::findChar);
    }

    public static char findChar(String string) {
        var hashSet = new HashSet<Character>();

        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if(hashSet.contains(c)) {
                return c;
            } else {
                hashSet.add(c);
            }
        }
        return '\0';
    }
}
