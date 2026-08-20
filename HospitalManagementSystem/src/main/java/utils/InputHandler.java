package utils;

import java.util.Scanner;

public class InputHandler {
    private Scanner sc;

    public InputHandler() {sc = new Scanner(System.in);}

    //numbers
    private boolean isWholeNumber(String input) {
        if (HelperUtils.isEmpty(input)) {
            return false;
        }
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDecimalNumber(String line) {
        if (HelperUtils.isEmpty(line)) {return false;}
        try {Double.parseDouble(line.trim());return true;
        } catch (NumberFormatException e) {return false;}
    }

    public String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (HelperUtils.isValidText(input)) {
                return input.trim();
            }
            System.out.println("Invalid: input cannot be empty");
        }
    }

    public int readInt(String prompt){
        while (true) {
            System.out.print(prompt + ": ");
            String input = sc.nextLine();
            if (isWholeNumber(input)) {
                return Integer.parseInt(input.trim()); //convert to proper data type
            }
            System.out.println("a whole number is required.");
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = sc.nextLine();
            if (isDecimalNumber(input)) {
                return Double.parseDouble(input.trim());
            }
            System.out.println("a decimal number is required.");
        }
    }



}
