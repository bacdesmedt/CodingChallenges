package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
Given an array of numbers. You have to sort the odd numbers in ascending order while leaving the
even numbers at their original positions.
Examples

[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
public class OnlySortOdds {

    public static void main(String[] args) {
        test(new int[]{ 7, 1 }, new int[]{ 1, 7 });
        test(new int[]{ 5, 8, 6, 3, 4 }, new int[]{ 3, 8, 6, 5, 4 });
        test(new int[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, new int[]{ 1, 8, 3, 6, 5, 4, 7, 2, 9, 0 });
    }

    public static void test(int[] input, int[] expected) {
        TestUtils.test(input, expected, OnlySortOdds::sortOdds);
    }

    public static int[] sortOdds(int[] array) {
        if (array != null & array.length > 1) {
            int[] odds = Arrays.stream(array).filter(i -> i % 2 != 0).sorted().toArray();
            int o = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 != 0) array[i] = odds[o++];
            }
        }

        return array;
    }
}
