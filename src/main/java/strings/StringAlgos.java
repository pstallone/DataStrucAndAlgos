package strings;

import java.util.HashMap;
import java.util.Map;

public class StringAlgos {


    public static boolean hasUniqueChars(String str) {
        boolean hasUnique = true;
        boolean[] charCheckArr = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // if char location is true, there was previously a char detected
            // char is index
            if (charCheckArr[c]) {
                hasUnique = false;
                break;
            } else {
                charCheckArr[c] = true;
            }
        }
        return hasUnique;
    }

    public static char findFirstNonRepeatingCharInUnicodeStr(String str ) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        // populate map key is char, val is count
        char firstRepeat = 0; // null char
        for (int i = 0; i < str.length(); i++) {
            charCountMap.compute(str.charAt(i), (k, v) -> (v == null) ? 1 : v+1);
        }
        // iterate string checking char count array
        for (int j = 0; j < str.length(); j++) {
            if (charCountMap.get(str.charAt(j)) == 1) {
                firstRepeat = str.charAt(j);
                break;
            }
        }
        return firstRepeat;
    }

    public static String removeChars(String inputStr, String removeStr) {
        // create array for remove chars with boolean val, char index, assume ASCII only
        boolean[] remCharCheck = new boolean[128]; // default false
        for (int i = 0; i < removeStr.length(); i++) {
            remCharCheck[removeStr.charAt(i)] = true;
        }

        char[] outChars = inputStr.toCharArray();
        // loop through outChars, checking char against toRemove array if true skip
        // write char back onto outChars
        int oidx = 0;
        for (int i = 0; i < outChars.length; i++) {
            if (remCharCheck[outChars[i]] == false) {
                outChars[oidx] = outChars[i];
                oidx++;
            }
            if (i == outChars.length-1 && oidx < i) {
                // fill in rest of chars with space char
                for (int j = oidx; j < outChars.length; j++) {
                    outChars[j] = ' ';
                }
            }
        }

        //return Arrays.toString(outChars).trim(); // no good, returns "[ ... ]"
        return String.copyValueOf(outChars).trim();
    }
}
