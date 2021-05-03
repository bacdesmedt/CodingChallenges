package desmedt.bac.logic;

import desmedt.bac.test.TestUtils;

/*
There are three towers. The objective of the game is to move all the disks over to tower #3, but you can't place a
larger disk onto a smaller disk.

Create a function that takes a number disks as an argument and returns the minimum amount
of steps needed to complete the game.
Examples
towerHanoi(3) ➞ 7

towerHanoi(5) ➞ 31

towerHanoi(0) ➞ 0
Notes
The amount of disks is always a positive integer.
1 disc can be changed per move.
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        test(3, 7);
        test(5, 31);
        test(0, 0);
//        hanoiWithSteps(5);
    }

    public static void test(int disks, int steps) {
        TestUtils.test(disks, steps, TowerOfHanoi::hanoiRecursive);
    }

    public static int towerHanoi(int disks) {
        return (int) (Math.pow(2, disks) - 1);
    }

    public static int hanoiRecursive(int disks) {
        if (disks <= 1) return disks;
        return 2 * hanoiRecursive(disks - 1) + 1;
    }

    public static void hanoiWithSteps(int disks) {
//        System.out.println("disks:" + disks + "\t-\t" + towerHanoi(disks) + "steps taken:");
        hanoiWithSteps(disks, 1, 3);
    }

    public static void hanoiWithSteps(int disks, int start, int end) {
        if (disks > 0) {
            if (disks == 1) printStep(start, end);
            else {
                int other = 6 - (start + end);
                hanoiWithSteps(disks - 1, start, other);
                printStep(start, end);
                hanoiWithSteps(disks - 1, other, end);
            }
        } else System.out.println("no disks, no play");
    }

    public static void printStep(int source, int destination) {
        char from = (char) (source - 1 + 'A');
        char to = (char) (destination - 1 + 'A');
        System.out.println(from + " ⇨ " + to);
    }

}
