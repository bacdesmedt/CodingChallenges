package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words,
find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 */
public class LowestMissingInteger {

    public static void main(String[] args) {
        int[] arr1 = { 3, 4, -1, 1 }; //should give 2
        int[] arr2 = { 1, 2, 0 }; //should give 3

        test(arr1, 2);
        test(arr2, 3);
        testWithoutSorting(arr1, 2);
        testWithoutSorting(arr2, 3);

    }

    public static void test(int[] array, int expected) {
        TestUtils.test(array, expected, LowestMissingInteger::lowestMissingInt);
    }

    public static void testWithoutSorting(int[] array, int expected) {
        TestUtils.test(array, expected, LowestMissingInteger::lowestMissingIntWithoutSort);
    }

    public static int lowestMissingInt(int[] input) {
        Arrays.sort(input);
        for (int i = 1; i < input.length; i++) {
            if (input[i] > 0 && input[i - 1] >= 0)
                if (input[i] - input[i - 1] > 1)
                    return input[i - 1] + 1;
        }
        return input[input.length - 1] + 1;
    }

    public static int lowestMissingIntWithoutSort(int[] input) {
        if (input == null || input.length == 0) return 0;

        int length = Arrays.stream(input).max().getAsInt() + 1;
        boolean[] check = new boolean[length];
        check[0] = true;

        for (int value : input) {
            if (value > 0) check[value] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if (!check[i]) return i;
        }

        return check.length;
    }
}
