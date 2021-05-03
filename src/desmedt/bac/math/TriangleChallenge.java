package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

/*
Given the shortest side of a 30° by 60° by 90° triangle you have to find out the other 2 sides,
(return the longest side, medium-length side).

Examples
otherSides(1) ➞ [2.0, 1.73]

otherSides(12) ➞ [24.0, 20.78]

otherSides(2) ➞ [4.0, 3.46]

otherSides(3) ➞ [6.0, 5.2]
Notes
30° by 60° by 90° triangles always follow this rule, let's say the shortest side length is x units,
the hypotenuse would be 2x units and the other side would be x * root3 units.
The results in the Tests are rounded up to 2 decimal places.
Return the result as an array.
 */
public class TriangleChallenge {

    public static void main(String[] args) {
        TestUtils.test(1, new double[]{ 2.0, 1.73 }, TriangleChallenge::otherSides);
        TestUtils.test(12, new double[]{ 24.0, 20.78 }, TriangleChallenge::otherSides);
        TestUtils.test(2, new double[]{ 4.0, 3.46 }, TriangleChallenge::otherSides);
        TestUtils.test(3, new double[]{ 6.0, 5.2 }, TriangleChallenge::otherSides);
    }

    public static double[] otherSides(int a) {
        return new double[]{
                2D * a,
                rounded(a * Math.sqrt(3D))
        };
    }

    public static double rounded(double d) {
        return Math.round(d * 100) / 100D;
    }
}
