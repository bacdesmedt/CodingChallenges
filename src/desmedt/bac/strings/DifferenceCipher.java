package desmedt.bac.strings;

import desmedt.bac.test.TestUtils;

public class DifferenceCipher {

    public static void main(String[] args) {
        testEncrypt("Hello", new int[]{ 72, 29, 7, 0, 3 });
        testDecrypt(new int[]{ 72, 33, -73, 84, -12, -3, 13, -13, -68 }, "Hi there!");
        testEncrypt("Sunshine", new int[]{ 83, 34, -7, 5, -11, 1, 5, -9 });
    }

    public static void testEncrypt(String input, int[] expected) {
        TestUtils.test(input, expected, DifferenceCipher::encrypt);
    }

    public static void testDecrypt(int[] arr, String expected) {
        TestUtils.test(arr, expected, DifferenceCipher::decrypt);
    }

    public static int[] encrypt(String str) {
        int[] cipher = new int[str.length()];
        char[] charArray = str.toCharArray();
        cipher[0] = charArray[0];
        for (int i = 1; i < cipher.length; i++) {
            cipher[i] = charArray[i] - charArray[i - 1];
        }
        return cipher;
    }

    public static String decrypt(int[] arr) {
        int c = 0;
        String result = "";
        for (int i : arr) {
            c += i;
            result = result.concat(Character.toString((char) c));
        }
        return result;
    }
}
