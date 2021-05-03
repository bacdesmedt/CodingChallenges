package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

/*
Number of Boomerangs
A boomerang is a V-shaped sequence that is either upright or upside down. Specifically, a boomerang can be defined as:
sub-array of length 3, with the first and last digits being the same and the middle digit being different.

Some boomerang examples:

[3, 7, 3], [1, -1, 1], [5, 6, 5]
Create a function that returns the total number of boomerangs in an array.

To illustrate:

[3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2]
// 3 boomerangs in this sequence:  [3, 7, 3], [1, 5, 1], [2, -2, 2]
Be aware that boomerangs can overlap, like so:

[1, 7, 1, 7, 1, 7, 1]
// 5 boomerangs (from left to right): [1, 7, 1], [7, 1, 7], [1, 7, 1], [7, 1, 7], and [1, 7, 1]
Examples
countBoomerangs([9, 5, 9, 5, 1, 1, 1]) ➞ 2

countBoomerangs([5, 6, 6, 7, 6, 3, 9]) ➞ 1

countBoomerangs([4, 4, 4, 9, 9, 9, 9]) ➞ 0
Notes
[5, 5, 5] (triple identical digits) is NOT considered a boomerang because the middle digit is identical to the first and last.
 */
public class Boomerangs {

    public static void main(String[] args) {
        test(new int[]{ 9, 5, 9, 5, 1, 1, 1 }, 2);

        test(new int[]{ 5, 6, 6, 7, 6, 3, 9 }, 1);

        test(new int[]{ 4, 4, 4, 9, 9, 9, 9 }, 0);
    }

    public static void test(int[] array, int expected) {
        TestUtils.test(array, expected, Boomerangs::countBoomerangs);
    }

    public static int countBoomerangs(int[] arr) {
        int boomerangs = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] != arr[i] && arr[i - 1] == arr[i + 1]) boomerangs++;
        }
        return boomerangs;
    }
}
