package com.falsecolor.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Parser parser = new Parser();
        String[] parts = parser.splitInput(input);
        boolean isRoman = parser.checkForRoman(parts[0]);
        if (isRoman != parser.checkForRoman(parts[2]))
            throw new Exception("You cant mix roman and arabic numbers");

        RomanConverter converter = new RomanConverter();
        int a = isRoman ? converter.toArabic(parts[0]) : Integer.parseInt(parts[0]);
        int b = isRoman ? converter.toArabic(parts[2]) : Integer.parseInt(parts[2]);
        int c;
        switch (parts[1]) {
            case "+": c = a + b; break;
            case "-": c = a - b; break;
            case "*": c = a * b; break;
            case "/": c = a / b; break;
            default: throw new Exception("Unknown sign");
        }
        System.out.println(isRoman ? converter.toRoman(c) : c);


    }
}
