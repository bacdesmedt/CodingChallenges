package desmedt.bac.logic;

/*
There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns
the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2


What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of
positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
Generalize your function to take in X.
 */
public class StairProblem {

    public static void main(String[] args) {

        int n = 15;
        int[] x = { 1, 3, 5 };

        System.out.println("1: " + staircase1(n));
        System.out.println();
        System.out.println("2: " + staircase2(n));
        System.out.println();
        System.out.println("3: " + staircase3(n, x));
        System.out.println();
        System.out.println("4: " + staircase4(n, x));

    }

    // N stairs in 1 or 2 steps recursively
    public static int staircase1(int n) {
        return n <= 1 ? 1 : (staircase1(n - 1) + staircase1(n - 2));
    }

    // N stairs in 1 or 2 steps iteratively
    public static int staircase2(int n) {
        int a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            b += a;
            a = b - a;
        }

        return b;
    }

    // N stairs in X steps recursively
    public static int staircase3(int n, int[] steps) {
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else {
            int out = 0;
            for (int x : steps) out += staircase3(n - x, steps);
            return out;
        }
    }

    // N stairs in X steps iteratively
    public static int staircase4(int n, int[] steps) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int x : steps) {
                if (i - x >= 0) {
                    cache[i] += cache[i - x];
                }
            }

        }

        return cache[n];
    }

}
