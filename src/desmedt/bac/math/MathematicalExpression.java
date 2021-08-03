package desmedt.bac.math;

import desmedt.bac.test.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathematicalExpression {
    public static void main(String[] args) {

        test("12* 123",1476d);
        test("2 /2+3 * 4.75- -6",21.25);
        test("2 / (2 + 3) * 4.33 - -6",7.732);
        test("12* 123/-(-5 + 2)", 492.0);
        test("(1 - 2) + -(-(-(-4)))", 3d);

    }

    public static void test(String input, double result) {
        TestUtils.test(input, result, MathematicalExpression::calculate);
    }

    public static double calculate(String expression) {
        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        expression = expression.replaceAll(" ","");

        //Handle brackets
        while (expression.contains("(")) {
            int open = expression.lastIndexOf("(");
            if(open >= 0){
                int close = open + expression.substring(open).indexOf(")");
                expression = expression.replace(
                        expression.substring(open,close+1),
                        calculate(expression.substring(open+1,close)) + ""
                );
            }
        }

        //separate numbers from operators
        while (!expression.isEmpty()){
            boolean negative = false;

            while (expression.startsWith("-")) {
                negative = !negative;
                expression = expression.substring(1);
            }

            String num = expression.codePoints()
                    .mapToObj(cp -> Character.toString((char) cp))
                    .takeWhile(string -> string.matches("[0-9.]"))
                    .reduce(String::concat).get();

            double d = Double.parseDouble(num);
            numbers.add(negative? -d : d);
            if(num.length() < expression .length()) {
                String operator = Character.toString(expression.charAt(num.length()));
                operators.add(operator);
                expression = expression.substring(num.length() + 1);
            } else expression = "";

        }

        // product & quotient
        while (operators.contains("*") || operators.contains("/")) {
            for (int i = 0; i < operators.size(); i++) {
                String operator = operators.get(i);
                if (operator.equals("*") || operator.equals("/")) {
                    double d1 = numbers.get(i);
                    double d2 = numbers.get(i + 1);
                    double outcome = operator.equals("*") ? d1 * d2 : d1 / d2;
                    numbers.set(i, null);
                    numbers.set(i + 1, outcome);
                    operators.set(i,null);
                }
            }
            numbers.removeIf(Objects::isNull);
            operators.removeIf(Objects::isNull);
        }

        //Addition & subtraction
        while (operators.contains("+") || operators.contains("-")) {
            for (int i = 0; i < operators.size(); i++) {
                String operator = operators.get(i);
                if (operator.equals("+") || operator.equals("-")) {
                    double d1 = numbers.get(i);
                    double d2 = numbers.get(i + 1);
                    double outcome = operator.equals("+") ? d1 + d2 : d1 - d2;
                    numbers.set(i, null);
                    numbers.set(i + 1, outcome);
                    operators.set(i,null);
                }
            }
            numbers.removeIf(Objects::isNull);
            operators.removeIf(Objects::isNull);
        }

        return numbers.get(0);
    }
}
