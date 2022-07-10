package onion.adr1ancho.numeral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberToRomanTest {

    private NumberToRoman numberToRoman;

    @BeforeEach
    void setUp() {
        numberToRoman = new NumberToRoman();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testToRomanNumeral(final int input, final String output) {
        assertEquals(output, numberToRoman.toRomanNumeral(input));
    }

    @Test
    void testZero() {
        assertThrows(IllegalArgumentException.class, () -> numberToRoman.toRomanNumeral(0));
    }

    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> numberToRoman.toRomanNumeral(-1));
    }
}