package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;
import java.util.HashSet;

/*
    Given an array of integers arr that contains n+1 elements between 1 and n inclusive,
    create a function that returns the duplicate element.
    Assume only 1 duplicate number, but multiple instances possible
*/
public class FindDuplicate {

    public static void main(String[] args) {
        test(new int[] { 7, 5, 2, 6, 2, 1, 4, 3, 2 }, 2);
        test(new int[] { 2, 4, 3, 1, 5, 3 }, 3);
        test(new int[] { 1, 2, 3, 3 }, 3);
    }

    public static void test(int[] array, int expected) {
        TestUtils.test(array, expected, FindDuplicate::findDuplicates);
    }

    public static int findDuplicates(int[] arr) {
        var map = new HashSet<Integer>();
        for (int i : arr) {
            if (map.contains(i))
                return i;
            else
                map.add(i);
        }
        return 0;
    }

}
