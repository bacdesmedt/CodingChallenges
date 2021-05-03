package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
A word nest is created by taking a starting word, and generating a new string by placing the word inside itself.
This process is then repeated.

Nesting 3 times with the word "incredible":

start  = incredible
first  = incre|incredible|dible
second = increin|incredible|credibledible
third  = increinincr|incredible|ediblecredibledible
The final nest is "increinincrincredibleediblecredibledible" (depth = 3).

Given a starting word and the final word nest, return the depth of the word nest.

Examples
wordNest("floor", "floor") ➞ 0

wordNest("code", "cocodccococodededeodeede") ➞ 5

wordNest("incredible", "increinincrincredibleediblecredibledible") ➞ 3

//Part 2
Given a starting word and a final word nest, return true if the word nest is valid. Return false otherwise.

Examples
validWordNest("deep", "deep") ➞ true

validWordNest("novel", "nonnonovnovnovelelelvelovelvel") ➞ true

validWordNest("painter", "ppaintppapaipainterinternteraintererainter") ➞ false
// Doesn't show starting word after being collapsed.

validWordNest("shape", "sssshapeshapehahapehpeape") ➞ false
// Word placed outside, not inside itself.
Notes
Valid word nests can only be created by repeatedly placing the word inside itself, so at any point when
collapsing the nest, there should only be one instance of the word to be found.
 */
public class WordNest {

    public static void main(String[] args) {
        test1("floor", "floor", 0);
        test1("code", "cocodccococodededeodeede",5);
        test1("incredible", "increinincrincredibleediblecredibledible",3);
        System.out.println();
        test2("deep", "deep", true);
        test2("novel", "nonnonovnovnovelelelvelovelvel",true);
        test2("painter", "ppaintppapaipainterinternteraintererainter", false);
        test2("shape", "sssshapeshapehahapehpeape", false);
    }

    public static void test1(String word, String nest, int expected) {
        TestUtils.test(word,nest,expected,WordNest::wordNest);
    }

    public static int wordNest(String word, String nest) {
        int count = 0 ;
        while(nest.contains(word) && !nest.equals(word)) {
            count ++;
            int index = nest.indexOf(word);
            nest = nest.substring(0,index).concat(nest.substring(index + word.length()));
        }
        return count;
    }

    public static void test2(String word, String nest, boolean expected) {
        TestUtils.test(word,nest,expected,WordNest::validWordNest);
    }
    public static boolean validWordNest(String word, String nest) {

        while(nest.contains(word) && !nest.equals(word)) {
            int index = nest.indexOf(word);
            nest = nest.substring(0,index).concat(nest.substring(index + word.length()));
        }
        return nest.equals(word);
    }
}
