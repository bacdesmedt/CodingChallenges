package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if
that character appears only once in the original string, or ")" if that character appears more than once in the
original string. Ignore capitalization when determining if a character is a duplicate.
Examples

"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("

 */
public class DuplicateEncoder {

    public static void main(String[] args) {
        test("din", "(((");
        test("recede", "()()()");
        test("Success", ")())())");
        test("(( @", "))((");
    }

    public static void test(String input, String expected) {
        TestUtils.test(input,expected,DuplicateEncoder::encode);
    }

    public static String encode(String word){
        Map<String, Long> map = word.toLowerCase()
                .chars()
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String output ="";
        for (char c : word.toLowerCase().toCharArray()) {
            if (map.get(Character.toString(c)) > 1)
                output = output.concat(")");
            else output = output.concat("(");
        }
        return output;
    }
}
