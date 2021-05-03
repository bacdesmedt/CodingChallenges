package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
Create a function that determines whether a number is Oddish or Evenish. A number is Oddish if the sum of all of
its digits is odd, and a number is Evenish if the sum of all of its digits is even. If a number is Oddish, return "Oddish". Otherwise, return "Evenish".

For example, oddishOrEvenish(121) should return "Evenish", since 1 + 2 + 1 = 4.
oddishOrEvenish(41) should return "Oddish", since 4 + 1 = 5.

Examples
oddishOrEvenish(43) ➞ "Oddish"
// 4 + 3 = 7
// 7 % 2 = 1

oddishOrEvenish(373) ➞ "Oddish"
// 3 + 7 + 3 = 13
// 13 % 2 = 1

oddishOrEvenish(4433) ➞ "Evenish"
// 4 + 4 + 3 + 3 = 14
// 14 % 2 = 0
 */
public class OddishOrEvenish {

    public static final String EVENISH = "Evenish";
    public static final String ODDISH = "Oddish";

    public static void main(String[] args) {
        test(121, EVENISH);
        test(41, ODDISH);
        test(43, ODDISH);
        test(373, ODDISH);
        test(4433, EVENISH);
    }

    public static void test(int input, String expected) {
        TestUtils.test(input, expected, OddishOrEvenish::oddishOrEvenish);
    }

    public static String oddishOrEvenish(int num) {
        int sum = 0;
        for (char c : Integer.toString(num).toCharArray()) {
            sum += (c - '0');
        }

        return (sum % 2 == 0) ? EVENISH : ODDISH;
    }
}
