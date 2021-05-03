package desmedt.bac.arrays;

import desmedt.bac.test.TestUtils;

import java.util.HashSet;
import java.util.function.BiPredicate;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */
public class AddsUpToK {

    public static void main(String[] args) {
        int[] array = { 10, 15, 3, 7 };
        int k = 17;
        BiPredicate<int[], Integer> doesAddUpToK = AddsUpToK::addsUpToK;

        TestUtils.test(array, k, true, doesAddUpToK);
    }

    public static boolean addsUpToK(int[] array, int k) {
        HashSet<Integer> set = new HashSet<>(array.length);

        for (int i : array) {
            if (set.contains(k - i)) return true;
            else set.add(i);
        }
        return false;
    }
}
