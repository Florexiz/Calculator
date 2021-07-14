package com.falsecolor.calculator;

public class Parser {
    public boolean checkForRoman(String input) throws Exception{
        int countArabic = 0;
        int countRoman = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((int)input.charAt(i) >= 48 && (int)input.charAt(i) <= 57)
                countArabic++;
            else
                countRoman++;
        }
        if (countArabic != 0 && countRoman != 0)
            throw new Exception("You can't mix arabic and roman symbols");
        if (countRoman > 0)
            return true;
        else
            return false;
    }
    public String[] splitInput(String input) throws Exception{
        String[] parts = input.split(" ");
        if(parts.length == 3 &&
                parts[0].length() > 0 &&
                parts[1].length() == 1 &&
                parts[2].length() > 0)
            return parts;
        throw new Exception("Wrong string format");
    }
}
