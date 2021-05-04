package desmedt.bac.logic;

import desmedt.bac.test.TestUtils;

import java.util.stream.LongStream;

/*
    Write a Java program to find possible unique paths from top-left corner to bottom-right corner of a given
    grid (m x n).
    Note: You can move either down or right at any point in time.
 */
public class PathsThroughGrid {

    public static void main(String[] args) {
        test(4, 4, 20);
        test(3, 4, 10);
        test(4, 6, 56);
        test(8, 7, 1716);
    }

    public static void test(int rows, int columns, int expected) {
        TestUtils.test(rows, columns, expected, PathsThroughGrid::pathFinder);
    }

    public static int pathFinder(int rows, int columns) {
        int[][] paths = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (row == 0 || column == 0) paths[row][column] = 1;

                else paths[row][column] = paths[row - 1][column] + paths[row][column - 1];
            }
        }

        return paths[rows - 1][columns - 1];
    }
}
