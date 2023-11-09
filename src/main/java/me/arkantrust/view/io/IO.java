package me.arkantrust.view.io;

import java.util.Scanner;

/**
 * The IO class provides methods for reading user input, printing messages in
 * different colors, and validating user input.
 */
public class IO {

    protected static final Scanner in = new Scanner(System.in);

    protected static final String RESET = "\033[0m";
    protected static final String BLUE = "\033[0;34m";
    protected static final String RED = "\033[01;31m";
    protected static final String BOLD = "\033[0;1m";

    /**
     * Wraps the <code>nextLine()</code> method from the
     * <code>java.util.Scanner</code> class.
     * 
     * @return String read from stdout.
     */
    protected static String readLine() {

        return in.nextLine();

    }

    /**
     * Wraps the <code>out.print()</code> method from the
     * <code>java.util.Scanner</code> class.
     * 
     * @param message A string variable that represents the message to be printed.
     */
    protected static void print(String message) {

        System.out.print(message);

    }

    /**
     * Prints a given instruction in bold format.
     * 
     * @param instruction A string representing the instruction to be printed.
     */
    protected static void printInstruction(String instruction) {

        print(BOLD + instruction + RESET);

    }

    /**
     * The function "printError" prints a given error message in bold and red color.
     * 
     * @param message A string containing the error message to be printed.
     */
    protected static void printError(String message) {

        print("\n" + RED + message + RESET + "\n\n");

    }

    /**
     * The function "printBlue" prints a message in blue color.
     * 
     * @param message The message parameter is a string that represents the message
     *                to be printed in blue color.
     */
    protected static void printBlue(String message) {

        print(BLUE + message + RESET);

    }

    /**
     * The function prints a message in red color.
     * 
     * @param message The message parameter is a string that represents the message
     *                that you want to print in red color.
     */
    protected static void printRed(String message) {

        print(RED + message + RESET);

    }

    /**
     * The function reads a user input and validates it to ensure it is a number
     * between 1 and 3.
     * 
     * @return The method is returning the Integer read from stdin.
     */
    public Integer readMenuItem() {

        boolean valid = false;

        while (!valid) {

            try {

                Integer choice = Integer.valueOf(readLine());

                if (choice < 1 || choice > 4) {

                    printError("Invalid input. Please enter a number between 1 and 3");
                    printInstruction("$ ");

                }

                return choice;

            } catch (NumberFormatException e) {

                printError("Invalid input. Please enter a number between 1 and 3");
                printInstruction("$ ");

            }

        }

        return null; // This will never be reached

    }

}

