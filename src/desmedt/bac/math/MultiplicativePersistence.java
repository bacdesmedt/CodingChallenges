package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
    Create a function that takes a number and returns its multiplicative persistence, which is the number of times
    you must multiply the digits in num until you reach a single digit.

Examples
keepMultiplying(39) ➞ 3
// Because 3 * 9 = 27, 2 * 7 = 14, 1 * 4 = 4 and 4 has only one digit.
keepMultiplying(999) ➞ 4
// Because 9 * 9 * 9 = 729, 7 * 2 * 9 = 126, 1 * 2 * 6 = 12, and finally 1 * 2 = 2.
keepMultiplying(4) ➞ 0
// Because 4 is already a one-digit number.

 */
public class MultiplicativePersistence {

    public static void main(String[] args) {
        TestUtils.test(39, 3, MultiplicativePersistence::keepMultiplying);
        TestUtils.test(999, 4, MultiplicativePersistence::keepMultiplying);
        TestUtils.test(4, 0, MultiplicativePersistence::keepMultiplying);
    }

    public static int keepMultiplying(int num) {
        if (num < 0) num = Math.abs(num);
        if (num < 10) return 0;

        int[] ints = Integer.toString(num).codePoints().map(codepoint -> codepoint - '0').toArray();
        int product = 1;
        for (int i : ints) {
            product *= i;
        }

        if (product > 9) return 1 + keepMultiplying(product);
        else return 1;

    }
}
