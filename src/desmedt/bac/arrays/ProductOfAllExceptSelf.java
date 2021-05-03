package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;
/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */

public class ProductOfAllExceptSelf {

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] expected1 = { 120, 60, 40, 30, 24 };
        int[] array2 = { 3, 2, 1 };
        int[] expected2 = { 2, 3, 6 };

        test(array1, expected1);
        test(array2, expected2);
        System.out.println();
        testWithoutDivision(array1, expected1);
        testWithoutDivision(array2, expected2);
    }

    public static void test(int[] array, int[] expected) {
        TestUtils.test(array, expected, ProductOfAllExceptSelf::productOfAllOthers);
    }

    public static void testWithoutDivision(int[] array, int[] expected) {
        TestUtils.test(array, expected, ProductOfAllExceptSelf::productOfAllOthersNoDivision);
    }

    public static int[] productOfAllOthers(int[] source) {
        int[] result = new int[source.length];
        int product = 1;
        for (int i : source) {
            product *= i;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = product / source[i];
        }

        return result;
    }


    public static int[] productOfAllOthersNoDivision(int[] source) {
        int[] result = new int[source.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            for (int j = 0; j < source.length; j++) {
                if (i != j) {
                    result[i] *= source[j];
                }
            }
        }

        return result;
    }
}
