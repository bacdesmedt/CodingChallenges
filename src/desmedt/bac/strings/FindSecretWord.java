package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static desmedt.bac.strings.Secrets.*;

/*
There is a secret string which is unknown to you. Given a collection of random triplets from the string,
recover the original string.
A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before
the next in the given string. "whi" is a triplet for the string "whatisup".

As a simplification, you may assume that no letter occurs more than once in the secret string.

You can assume nothing about the triplets given to you other than that they are valid triplets and that they
contain sufficient information to deduce the original string. In particular, this means that the secret string
will never contain letters that do not occur in one of the triplets given to you.


Note: test cases weren't revealed until all of them succeeded
 */
public class FindSecretWord {

    public static void main(String[] args) {

        test(TRIPLETS_1, EXPECTED_1);
        test(TRIPLETS_2, EXPECTED_2);
        test(TRIPLETS_3, EXPECTED_3);
        test(TRIPLETS_4, EXPECTED_4);
        test(TRIPLETS_5, EXPECTED_5);

    }

    public static void test(char[][] triplets, String expected) {
        TestUtils.test(triplets, expected, FindSecretWord::recoverSecret);
    }

    public static String recoverSecret(char[][] triplets) {
        List<Character> characterList = getCharacterList(triplets);
        boolean reordered = true;

        while (reordered) {
            reordered = false;
            for (char[] triplet : triplets) {
                if (reorder(characterList, triplet[0], triplet[1])
                        || reorder(characterList, triplet[1], triplet[2])) {

                    reordered = true;
                }
            }
        }
        return characterList.stream()
                .map(String::valueOf)
                .reduce(String::concat)
                .get();
    }

    public static boolean reorder(List<Character> list, char c1, char c2) {
        if (list.indexOf(c1) > list.indexOf(c2)) {
            list.remove(list.indexOf(c1));
            list.add(list.indexOf(c2), c1);
            return true;
        }
        return false;
    }

    public static List<Character> getCharacterList(char[][] triplets) {
        return Arrays.stream(triplets)
                .map(String::valueOf)
                .map(s -> s.codePoints()
                        .mapToObj(codePoint -> (char) codePoint)
                        .collect(Collectors.toList())
                )
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
