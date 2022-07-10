package onion.adr1ancho.numeral;

import java.util.TreeMap;

public class NumberToRoman {

    private static final TreeMap<Integer, String> TREE_MAP = new TreeMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public String toRomanNumeral(final int number) {
        final Integer floor = TREE_MAP.floorKey(number);
        if (floor == null) {
            throw new IllegalArgumentException("Number is now supported");
        }
        if (number == floor) {
            return TREE_MAP.get(number);
        }
        return TREE_MAP.get(floor) + toRomanNumeral(number - floor);
    }

}