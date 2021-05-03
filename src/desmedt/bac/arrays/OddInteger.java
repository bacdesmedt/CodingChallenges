package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Create a function that takes an array and finds the integer which appears an odd number of times.

Examples
findOdd([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5]) ➞ -1

findOdd([20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5]) ➞ 5

findOdd([10]) ➞ 10
Notes
There will always only be one integer that appears an odd number of times.
 */
public class OddInteger {

    public static void main(String[] args) {
        test(new int[]{ 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }, -1);
        test(new int[]{ 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 }, 5);
        test(new int[]{ 10 }, 10);
    }

    public static void test(int[] arr, int expected) {
        TestUtils.test(arr, expected, OddInteger::findOdd);
    }

    public static int findOdd(int[] array) {

        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .findAny()
                .orElseThrow()
                .getKey();

    }
}
