package com.falsecolor.calculator;

public class RomanConverter {
    public int toArabic(String roman) throws Exception{
        if (roman.length() == 0) return 0;
        for (RomanLetters letter : RomanLetters.values())
            if (roman.startsWith(letter.name()))
                return letter.getArabic() +
                        toArabic(roman.substring(letter.name().length()));
        throw new Exception("No roman letter found");
    }
    public String toRoman(int arabic) throws Exception{
        if (arabic == 0) return "";
        for (RomanLetters letter : RomanLetters.values())
            if (letter.getArabic() <= arabic)
                return letter.name() +
                        toRoman(arabic - letter.getArabic());
        throw new Exception("No roman letter found");
    }
}
