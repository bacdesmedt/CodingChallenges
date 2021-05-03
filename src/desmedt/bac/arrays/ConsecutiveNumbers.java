package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
Create a function that determines whether elements in an array can be re-arranged to form a
consecutive list of numbers where each number appears exactly once.

Examples
cons([5, 1, 4, 3, 2]) ➞ true
// Can be re-arranged to form [1, 2, 3, 4, 5]
cons([5, 1, 4, 3, 2, 8]) ➞ false
cons([5, 6, 7, 8, 9, 9]) ➞ false
// 9 appears twice
 */
public class ConsecutiveNumbers {

    public static void main(String[] args) {
        test(new int[]{ 5, 1, 4, 3, 2 }, true);
        test(new int[]{ 5, 1, 4, 3, 2, 8 }, false);
        test(new int[]{ 5, 6, 7, 8, 9, 9 }, false);
    }

    public static void test(int[] array, boolean expected) {
        TestUtils.test(array, expected, ConsecutiveNumbers::cons);
    }

    public static boolean cons(int[] array) {
        int[] sorted = Arrays.stream(array).sorted().distinct().toArray();
        return sorted.length == array.length
                && sorted[sorted.length - 1] - sorted[0] == sorted.length - 1;
    }
}
