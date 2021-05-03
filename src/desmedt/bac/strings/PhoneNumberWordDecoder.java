package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

/*
Create a program that converts a phone number with letters to one with only numbers.

Number	Letter
0	none
1	none
2	ABC
3	DEF
4	GHI
5	JKL
6	MNO
7	PQRS
8	TUV
9	WXYZ
Examples
textToNum("123-647-EYES") ➞ "123-647-3937"
textToNum("(325)444-TEST") ➞ "(325)444-8378"
textToNum("653-TRY-THIS") ➞ "653-879-8447"
textToNum("435-224-7613") ➞ "435-224-7613"

Notes
All inputs will be formatted as a string representing a proper phone number in the format XXX-XXX-XXXX or
(XXX)XXX-XXXX, using numbers and capital letters.
Check the Resources tab for more info on telephone keypads.
 */
public class PhoneNumberWordDecoder {

    public static void main(String[] args) {

        test("123-647-EYES", "123-647-3937");
        test("(325)444-TEST", "(325)444-8378");
        test("653-TRY-THIS", "653-879-8447");
        test("435-224-7613", "435-224-7613");

    }

    public static void test(String input, String outcome) {
        TestUtils.test(input, outcome, PhoneNumberWordDecoder::textToNum);
    }

    public static String textToNum(String phone) {
        return phone.replaceAll("[ABC]", "2")
                .replaceAll("[DEF]", "3")
                .replaceAll("[GHI]", "4")
                .replaceAll("[JKL]", "5")
                .replaceAll("[MNO]", "6")
                .replaceAll("[PQRS]", "7")
                .replaceAll("[TUV]", "8")
                .replaceAll("[WXYZ]", "9");
    }
}
