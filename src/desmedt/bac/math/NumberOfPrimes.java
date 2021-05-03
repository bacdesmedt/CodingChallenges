package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
Create a function that finds how many prime numbers there are, up to the given integer.

Examples
primeNumbers(10) ➞ 4
// 2, 3, 5 and 7
primeNumbers(20) ➞ 8
// 2, 3, 5, 7, 11, 13, 17 and 19
primeNumbers(30) ➞ 10
// 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29
 */
public class NumberOfPrimes {

    public static void main(String[] args) {
        TestUtils.test(10, 4, NumberOfPrimes::countPrimesInRange);
        TestUtils.test(20, 8, NumberOfPrimes::countPrimesInRange);
        TestUtils.test(30, 10, NumberOfPrimes::countPrimesInRange);
    }

    public static int countPrimesInRange(int range) {
        int count = 0;
        for (int i = 2; i <= range; i += 2) {
            if (isPrime(i)) count++;
            if (i == 2) i--;
        }
        return count;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) return false;
        }
        return number > 1;
    }
}
