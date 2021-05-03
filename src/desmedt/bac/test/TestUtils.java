package desmedt.bac.test;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.*;

/**
 * Helper class for testing the solutions of these challenges. Instead of having to check the values, these methods
 * check the obtained result and compare it to the expected result. If the test tailed, it will print both.
 * I know there are some libraries out there that do this for you, but I haven't gotten around to look deeper
 * into it, it's on my to-do-list though.
 */
public class TestUtils {

    public static void test(int input, int expected, @NotNull IntUnaryOperator operator){
        printTestResult(operator.applyAsInt(input),expected);
    }

    public static void test(int a, int b, int expected, @NotNull IntBinaryOperator operator){
        printTestResult(operator.applyAsInt(a,b),expected);
    }

    public static <R>void test(int input, R expected, @NotNull IntFunction<R> function) {
        printTestResult(function.apply(input),expected);
    }

    public static void test(int input, boolean expected, @NotNull IntPredicate predicate){
        printTestResult(predicate.test(input),expected);
    }


    public static void test(double input, double expected, @NotNull DoubleUnaryOperator operator){
        printTestResult(operator.applyAsDouble(input),expected);
    }

    public static void test(double a, double b, double expected, @NotNull DoubleBinaryOperator operator){
        printTestResult(operator.applyAsDouble(a,b),expected);
    }

    public static <R>void test(double input, R expected, @NotNull DoubleFunction<R> function) {
        printTestResult(function.apply(input),expected);
    }

    public static void test(double input, boolean expected, @NotNull DoublePredicate predicate){
        printTestResult(predicate.test(input),expected);
    }


    public static void test(long input, long expected, @NotNull LongUnaryOperator operator){
        printTestResult(operator.applyAsLong(input),expected);
    }

    public static void test(long a, long b, long expected, @NotNull LongBinaryOperator operator){
        printTestResult(operator.applyAsLong(a,b),expected);
    }

    public static <R>void test(long input, R expected, @NotNull LongFunction<R> function) {
        printTestResult(function.apply(input),expected);
    }

    public static void test(long input, boolean expected, @NotNull LongPredicate predicate){
        printTestResult(predicate.test(input),expected);
    }


    public static <T>void test(T input, T expected, @NotNull UnaryOperator<T> operator){
        printTestResult(operator.apply(input),expected);
    }

    public static <T>void test(T a, T b, T expected, @NotNull BinaryOperator<T> operator){
        printTestResult(operator.apply(a,b),expected);
    }

    public static <T,R>void test(T input, R expected, @NotNull Function<T,R> function) {
        printTestResult(function.apply(input),expected);
    }

    public static <T,U,R>void test(T t, U u, R expected, @NotNull BiFunction<T,U,R> function) {
        printTestResult(function.apply(t,u),expected);
    }

    public static <T>void test(T input, boolean expected, @NotNull Predicate<T> predicate){
        printTestResult(predicate.test(input),expected);
    }

    public static <T,U>void test(T t, U u, boolean expected, @NotNull BiPredicate<T,U> predicate) {
        printTestResult(predicate.test(t,u),expected);
    }

    private static <T>void printTestResult(T outcome, T expected){
        if(isArray(expected)){
            Object[] outcomeArray = getArray(outcome);
            Object[] expectedArray = getArray(expected);
            System.out.println(
                    Arrays.equals(outcomeArray,expectedArray) ?
                            "Test successful!" :
                            "Test failed: got "
                                    + Arrays.toString(outcomeArray)
                                    + "\texpected "
                                    + Arrays.toString(expectedArray)
            );
        } else {
            System.out.println(
                    outcome.equals(expected) ?
                            "Test successful!" :
                            "Test failed: got " + outcome + "\texpected " + expected
            );
        }
    }

    private static Object[] getArray(Object object){
        if(!isArray(object)) return new Object[]{object};

        Object[] outputArray = new Object[Array.getLength(object)];

        for(int i = 0; i < outputArray.length; ++i){
            outputArray[i] = Array.get(object, i);
        }

        return outputArray;
    }

    private static boolean isArray(Object obj) {
        return obj!=null && obj.getClass().isArray();
    }
}
