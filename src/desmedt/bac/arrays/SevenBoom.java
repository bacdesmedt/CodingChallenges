package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;

/*
Create a function that takes an array of numbers and return "Boom!" if the digit 7 appears in the array.
Otherwise, return "there is no 7 in the array".

Examples
sevenBoom([1, 2, 3, 4, 5, 6, 7]) ➞ "Boom!"
// 7 contains the number seven.

sevenBoom([8, 6, 33, 100]) ➞ "there is no 7 in the array"
// None of the items contain 7 within them.

sevenBoom([2, 55, 60, 97, 86]) ➞ "Boom!"
// 97 contains the number seven.
 */
public class SevenBoom {

    public static void main(String[] args) {
        test(new int[]{ 1, 2, 3, 4, 5, 6, 7 }, "Boom!");
        test(new int[]{ 8, 6, 33, 100 }, "there is no 7 in the array");
        test(new int[]{ 2, 55, 60, 97, 86 }, "Boom!");
    }

    public static void test(int[] input, String expected) {
        TestUtils.test(input, expected, SevenBoom::sevenBoom);
    }

    public static String sevenBoom(int[] arr) {
        if (Arrays.toString(arr).contains("7"))
            return "Boom!";

        return "there is no 7 in the array";
    }
}
