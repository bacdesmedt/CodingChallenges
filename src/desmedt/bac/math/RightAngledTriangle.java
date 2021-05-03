package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
    Is It A Right-Angled Triangle?

Given varying information about a shape, create a function that returns true if the shape could be a right-angle
triangle and false if not.
You will be given an array of numbers and a string stating whether the numbers are angles or sides.
The information may indicate more than one possible shape, but we just need to know if these
details could be found in a right-angled triangle.
Examples
isRightAngle([30, 60], "angle") ➞ true
// A third angle could be 90

isRightAngle([20, 20, 20, 20], "angle") ➞ false
// More than 3 sides

isRightAngle([4, 5, 3], "side") ➞ true
// 3**2 + 4**2 = 5**2

isRightAngle([4, 5], "side") ➞ true
// Third side may be 3
 */
public class RightAngledTriangle {

    public static final String ANGLE = "angle";
    public static final String SIDE = "side";

    public static void main(String[] args) {
        test(new int[]{ 30, 60 }, ANGLE, true);
        test(new int[]{ 20, 20, 20, 20 }, ANGLE, false);
        test(new int[]{ 4, 5, 3 }, SIDE, true);
        test(new int[]{ 4, 5 }, SIDE, true);
    }

    public static void test(int[] input, String description, boolean expected) {
        TestUtils.test(input, description, expected, RightAngledTriangle::isRightAngle);
    }

    public static boolean isRightAngle(int[] arr, String description) {
        if (arr == null || arr.length < 2 || arr.length > 3 || description == null)
            return false;

        if (description.equals(ANGLE)) {
            if (arr.length == 2) return (arr[0] + arr[1] == 90) || arr[0] == 90 || arr[1] == 90;
            else {
                for (int i : arr) {
                    if (i == 90) return true;
                }
            }
        } else if (description.equals(SIDE)) {
            if (arr.length == 2) return true;
            else {
                return arr[0] == Math.hypot(arr[1], arr[2])
                        || arr[1] == Math.hypot(arr[0], arr[2])
                        || arr[2] == Math.hypot(arr[1], arr[0]);
            }
        }

        return false;
    }
}
