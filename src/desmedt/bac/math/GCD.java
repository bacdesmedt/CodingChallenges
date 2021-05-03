package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
Create a function that takes an array of numbers and returns the greatest common factor of those numbers.

Examples
gcd({84, 70, 42, 56}) ➞ 14
gcd({19, 38, 76, 133}) ➞ 19
gcd({120, 300, 95, 425, 625}) ➞ 5

Notes
The GCD is the largest factor that divides all numbers in the array.
 */
public class GCD {

    public static void main(String[] args) {
        TestUtils.test(new int[]{ 84, 70, 42, 56 }, 14, GCD::gcds);
        TestUtils.test(new int[]{ 19, 38, 76, 133 }, 19, GCD::gcds);
        TestUtils.test(new int[]{ 120, 300, 95, 425, 625 }, 5, GCD::gcds);
    }

    public static int gcds(int[] arr) {
        if (arr != null && arr.length > 0) {
            if (arr.length == 1) return arr[0];
            else {
                int gcd = gcd(arr[0], arr[1]);
                for (int i = 2; i < arr.length; i++) {
                    gcd = gcd(gcd, arr[i]);
                }
                return gcd;
            }
        }
        return 0;
    }

    public static int gcd(int number1, int number2) {
        int big = Math.max(number1, number2);
        int small = Math.min(number1, number2);

        if (small == 0) return big;

        return gcd(small, big % small);
    }
}
