package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
Create a function that will recursively count the number of digits of a number. Conversion of the number to a string is not allowed, thus, the approach is recursive.

Examples
digitsCount(4666) ➞ 4
digitsCount(544) ➞ 3
digitsCount(121317) ➞ 6
digitsCount(0) ➞ 1
digitsCount(12345) ➞ 5
digitsCount(1289396387328L) ➞ 13
Notes
You are expected to solve this challenge via recursion.
 */
public class RecursiveCounting {

    public static void main(String[] args) {
        TestUtils.test(4666L, 4, RecursiveCounting::countDigits);
        TestUtils.test(544L, 3, RecursiveCounting::countDigits);
        TestUtils.test(121317L, 6, RecursiveCounting::countDigits);
        TestUtils.test(0L, 1, RecursiveCounting::countDigits);
        TestUtils.test(12345L, 5, RecursiveCounting::countDigits);
        TestUtils.test(1289396387328L, 13, RecursiveCounting::countDigits);
    }

    public static int countDigits(long n) {
        return 1 + ((n >= 10) ? countDigits(n / 10) : 0);
    }
}
