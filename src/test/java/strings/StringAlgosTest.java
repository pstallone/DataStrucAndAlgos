package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgosTest {

    @Test
    public void stringIsNotUniqueTest() {
        assertFalse(StringAlgos.hasUniqueChars("the sun is out"));
    }

    @Test
    public void stringIsUniqueTest() {
        assertTrue(StringAlgos.hasUniqueChars("the long_day"));
    }

    @Test
    public void findFirstNonRepeatingCharInUnicodeStrTest() {
        assertEquals('r', StringAlgos.findFirstNonRepeatingCharInUnicodeStr("teeter"));
        assertEquals('n', StringAlgos.findFirstNonRepeatingCharInUnicodeStr("efficiency"));
    }

    @Test
    public void removeChars() {
        String output =  StringAlgos.removeChars("the talking dog", "td");
        assertTrue(output.equals("he alking og"));

        output =  StringAlgos.removeChars("the talking dog", "tal");
        assertTrue(output.equals("he king dog"));

    }

}