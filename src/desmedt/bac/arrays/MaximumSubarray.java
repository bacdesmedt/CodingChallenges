package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
    Given an array of integers arr, create a function that returns the sum of
    the subarray that has the greatest sum.
    And we don't consider the empty array as a subarray
 */
public class MaximumSubarray {
    public static void main(String[] args) {

        test(new int[]{ -6,-18,14,11,-3,15,-3,20,-14,5,-20,15,-18,-3,0 }, 54);
        test(new int[]{ -4,-17,22,22,6,-13,17,26,10,-19,1,10,25,11,-11 }, 118);

    }

    public static void test(int[] array, int expected) {
        TestUtils.test(array,expected,MaximumSubarray::getMaximumSubarraySum);
    }

    public static int getMaximumSubarraySum(int[] arr) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= arr.length; i++) {
            int element = arr[arr.length - i];
            sum = Math.max(element, sum + element);
            max = Math.max(max, sum);
        }

        return max;
    }

}
