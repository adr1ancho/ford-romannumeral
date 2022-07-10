package onion.adr1ancho.numeral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanToNumberTest {

    private RomanToNumber romanToNumber;

    @BeforeEach
    void setUp() {
        romanToNumber = new RomanToNumber();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testToRomanNumeral(final int number, final String romanNumeral) {
        assertEquals(number, romanToNumber.intValue(romanNumeral.toLowerCase()));
    }

    @Test
    void testNullCase() {
        assertThrows(IllegalArgumentException.class, () -> romanToNumber.intValue(null));
    }

    @Test
    void testIllegalString() {
        assertThrows(IllegalArgumentException.class, () -> romanToNumber.intValue("abcde"));
    }
}