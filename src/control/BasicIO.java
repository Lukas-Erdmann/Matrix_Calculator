package control;

import java.util.Scanner;

import static control.TypeConversion.*;

public class BasicIO {
    /**
     * Displays strings of an array in given line and is capable to display multiple strings in a single line.
     * The first row of the array must contain the line number. Therefore, the element must be parsable as an integer.
     * The second row contains the strings to be displayed.
     * @param header            2-dim string array containing line numbers and strings to displays
     * @return                  User input string
     */
    public static String basicInputPromptStr(String[][] header) {

        int line = 0;
        //Header lines to print
        for (int i = 0; i < header.length; i++) {
            if (i == header.length - 1) {
                System.out.println(header[i][1]);
                line++;
            }else if (Integer.parseInt(header[i + 1][0]) > line) {
                System.out.println(header[i][1]);
                line++;
            }else {
                System.out.print(header[i][1]);
            }
        }

        Scanner scannerStr = new Scanner(System.in);
        return scannerStr.nextLine();
    }

    /**
     * Displays strings of an array in given line and is capable to display multiple strings in a single line.
     * The first row of the array must contain the line number. Therefore, the element must be parsable as an integer.
     * The second row contains the strings to be displayed.
     * @param header            2-dim string array containing line numbers and strings to displays
     * @return                  User input integer
     */
    public static int basicInputPromptInt(String[][] header) {

        int line = 0;
        //Header lines to print
        for (int i = 0; i < header.length; i++) {
            if (i == header.length - 1) {
                System.out.println(header[i][1]);
                line++;
            }else if (Integer.parseInt(header[i + 1][0]) > line) {
                System.out.println(header[i][1]);
                line++;
            }else {
                System.out.print(header[i][1]);
            }
        }

        Scanner scannerStr = new Scanner(System.in);
        return scannerStr.nextInt();
    }

    /**
     * Display input prompt and tries to convert user input to an integer array. If the input is wrong,
     * it prompts the user to try again and displays the correct error message.
     * @param header        Header text to display
     * @param arraySize     Needed number of input elements
     * @return              Integer array
     */
    public static int[] tryParsingIntegers (String[][] header, int arraySize) {
        while (true) {
            try {
                String inputStr = basicInputPromptStr(header);
                return stringToIntArray(inputStr, arraySize);
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    /**
     * Display input prompt and tries to convert user input to a complex 2-dim double array.
     * If the input is wrong, it prompts the user to try again and displays the correct error message.
     * @param header        Header text to display
     * @param arraySize     Needed number of input elements
     * @return              Complex number array
     */
    public static double[][] tryParsingComplex (String[][] header, int arraySize) {
        while (true) {
            try {
                String inputStr = basicInputPromptStr(header);
                String[] strArray = stringToStrArray(inputStr, arraySize);
                double[][] doubleArray = new double[strArray.length][2];
                for (int i = 0; i < strArray.length; i++) {
                    doubleArray[i] = parseComplexNumber(strArray[i]);
                }
                return doubleArray;
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}