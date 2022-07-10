package onion.adr1ancho.numeral;

import java.util.Map;

import static java.util.Map.entry;

public class RomanToNumber {

    private static final Map<Character, Integer> NUMBER_TRANSLATIONS = Map.ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000)
    );

    public int intValue(String arg) {

        if (null == arg) {
            throw new IllegalArgumentException("Argument is null");
        }

        final String processedString = arg
                .toUpperCase()
                .replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC");

        int value = 0;
        for (int i = 0; i < processedString.length(); i++) {
            final Integer intValue = NUMBER_TRANSLATIONS.get(processedString.charAt(i));
            if (null == intValue) {
                throw new IllegalArgumentException("String contains non Roman numeral");
            }
            value = value + intValue;
        }
        return value;
    }
}
