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

    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt + " [between " + min + " and " + max + "]");

            if (HelperUtils.inRange(value, min, max)) {return value;}

            System.out.println("Invalid: input out of range");
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = sc.nextLine();

            if (isDecimalNumber(input)) {return Double.parseDouble(input.trim());}

            System.out.println("a decimal number is required.");
        }
    }

    //read yes or no from user
    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            String line = sc.nextLine().trim().toLowerCase();

            if (line.equals("yes") || line.equals("y")) {return true;}
            if (line.equals("no") || line.equals("n")) {return false;}

            System.out.println("Invalid input. it should be yes/no");
        }
    }

    public String readOneOf(String prompt, String[] allowed) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();

            if (HelperUtils.isOneOf(input, allowed)) {return input;}

            System.out.print("Allowed values are: "+allowed.toString());
            System.out.println();
        }
    }
}
