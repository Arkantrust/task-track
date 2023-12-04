package me.arkantrust.view.io;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;

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
    protected static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
     * The function reads a user input and validates it to ensure it is a number in
     * the range specified in regex.
     * 
     * @param range The range parameter is a string that represents the range of
     *              numbers that the user can enter.
     * 
     * @return The method is returning the Integer read from stdin.
     * 
     * 
     * <h2>Example</h2>
     * <pre> {@code
     * // The user can only enter 1, 2 or 3
     * Integer input = readInt("^[1-3]$");
     * 
     * } </pre>
     * 
     * <h2>Example 2</h2>
     * <pre> {@code
     * // The user can enter any positive number
     * Integer input = readInt("^[1-9][0-9]*$");
     * 
     * } </pre>
     */
    public Integer readInt(String range) {

        String input = readLine();

        while (!input.matches(range)) {

            printError("Invalid input, please try again: ");
            printBlue("$ ");
            input = readLine();
            
        }

        return Integer.valueOf(input);

    }

}
