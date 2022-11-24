package control;

import java.util.Objects;
import java.util.Scanner;

public class TypeConversion {

    //Todo: Make conversion function that can parse a/b fractions.
    /**
     * Takes a string and splits it into single integer elements.
     * String is split along delimiters (sp , ;) and checks for right amounts of elements.
     * Throws error if elements are not integers. If successful returns integer array.
     * @param argStr        Input string
     * @param argSize       Wanted amount of elements
     * @return              Integer array
     */
    public static int[] stringToIntArray(String argStr, int argSize) {
        String[] argStrArr;
        argStrArr = argStr.split("[;, ]"); //Split input string into single integers with delimiters
        if (argStrArr.length != argSize) { //Check if argument count was correct/ delimiters worked
            throw new IllegalArgumentException("ERROR: Wrong number of arguments / delimiter error.");
        }

        //Create integer array from string array
        int[] argIntArr = new int[argStrArr.length];
        for(int i = 0; i < argStrArr.length; i++) {
            Scanner sc = new Scanner(argStrArr[i]);
            if (!sc.hasNextInt()) { //Check if elements are integers
                throw new NumberFormatException("ERROR: " + argStrArr[i] + " is not an integer.");
            }

            argIntArr[i] = Integer.parseInt(argStrArr[i]); //write elements into integer array
        }
        return argIntArr;
    }

    /**
     * Takes a string and splits it into single float elements.
     * String is split along delimiters (sp , ;) and checks for right amounts of elements.
     * Throws error if elements are not floats. If successful returns float array.
     * @param argStr        Input string
     * @param argSize       Wanted amount of elements
     * @return              Float array
     */
    public static double[] stringToDoubleArray(String argStr, int argSize) {
        String[] argStrArr;
        argStrArr = argStr.split("[;, ]"); //Split input string into single floats with delimiters
        if (argStrArr.length != argSize) { //Check if argument count was correct/ delimiters worked
            throw new IllegalArgumentException("ERROR: Wrong number of arguments / delimiter error.");
        }

        //Create float array from string array
        double[] argFloatArr = new double[argStrArr.length];
        for(int i = 0; i < argStrArr.length; i++) {
            Scanner sc = new Scanner(argStrArr[i]);
            if (!sc.hasNextDouble()) { //Check if elements are floats
                throw new NumberFormatException("ERROR: " + argStrArr[i] + " is not a double.");
            }

            argFloatArr[i] = Double.parseDouble(argStrArr[i]); //write elements into float array
        }
        return argFloatArr;
    }

    /**
     * Takes a string and splits it into single string elements. Checks for right amount of elements.
     * Elements are stored in string array. Used for complex number math.
     * @param argStr        Input string
     * @param argSize       Wanted amount of elements
     * @return              Output string array
     */
    public static String[] stringToStrArray(String argStr, int argSize) {
        String[] argStrArr;
        argStrArr = argStr.split("[;, ]"); //Split input string into single integers with delimiters
        if (argStrArr.length != argSize) { //Check if argument count was correct/ delimiters worked
            throw new IllegalArgumentException("ERROR: Wrong number of arguments / delimiter error.");
        }

        return argStrArr;
    }

    /**
     * Takes a string and splits it into single string elements with custom delimiter.
     * Elements are stored in string array.
     * @param argStr        Input string
     * @param delimiter     Delimiter to split the string
     * @return              Output string array
     */
    public static String[] stringToStrArray(String argStr, String delimiter) {
        String[] argStrArr;
        argStrArr = argStr.split(delimiter); //Split input string into single integers with delimiters

        return argStrArr;
    }

    /**
     * Reads complex number string and parses real and imaginary parts into size-2 int array.
     * Checks for right formatting and if inputs are integers. If one part is zero it can be omitted.
     * Output doesn't contain i anymore.
     * @param argStr        Input string
     * @return              1-dim size-2 int output array
     */
    public static double[] parseComplexNumber(String argStr) {
        Scanner sc = new Scanner(System.in);

        boolean isRealPositive = true;
        boolean doesRealExist = true;
        boolean isImagPositive = true;
        if (argStr.charAt(0) == '-') {   // See if first expression is negative
            isRealPositive = false;
        }
        if (argStr.substring(1).contains("-")) {
            isImagPositive = false;
        }
        String[] split = argStr.split("[+-]");
        if (split[0].equals("")) {  // Handle expressions beginning with `-`
            split[0] = split[1];
            if (split.length == 3) {
                split[1] = split[2];
            } else if (split.length >= 3) {
                throw new IllegalArgumentException("Error: Input is not a properly formatted complex number");
            }
        }
        //Todo: be able to parse a/b fractions and floating point numbers
        double realPart = 0;
        double imagPart = 0;
        if (split[0].contains("i")) { // Assumes input is not empty
            doesRealExist = false;
            try {
                imagPart = Double.parseDouble((isRealPositive ? "+" : "-") + split[0].substring(0, split[0].length() - 1));
            } catch (IllegalArgumentException e) {
                if (Objects.equals(split[0], "i") && isRealPositive) {
                    imagPart = 1;
                } else if (Objects.equals(split[0], "i")) {
                    imagPart = -1;
                } else {
                    throw new IllegalArgumentException("Error: " + split[0] + " is not an integer.");
                }
            }
        }else {
            try {
                realPart = Double.parseDouble((isRealPositive ? "+" : "-") + split[0]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error: " + split[0] + " is not an integer.");
            }
        }
        if (split.length > 1 && doesRealExist) {     // Parse second part of expr if it exists
            if (split[1].contains("i")) {
                try {
                    imagPart = Double.parseDouble((isImagPositive ? "+" : "-") + split[1].substring(0, split[1].length() - 1));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Error: " + split[1] + " is not an integer.");
                }
            }else if (split[0].contains("i")) {
                try {
                    realPart = Double.parseDouble((isImagPositive ? "+" : "-") + split[1]);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Error: " + split[1] + " is not an integer.");
                }
            }
        }
        // Use realPart and imagPart ...
        double[] returnArr = new double[2];

        returnArr[0] = realPart;
        returnArr[1] = imagPart;

        return returnArr;
    }

    /**
     * Takes a size-2 int array interpreted as a complex number and creates a simplified string from it.
     * Zero-parts are not displayed. Used to display complex matrix.
     * @param argArr        Input size-2 int array
     * @return              Complex number string
     */
    public static String doubleArrayToComplexString(double[] argArr) {
        int realInt = (int)argArr[0];
        String realIntStr = String.valueOf(realInt);
        int imagInt = (int)argArr[1];
        String imagIntStr = String.valueOf(imagInt);
        boolean isRealWhole = false;
        boolean isImagWhole = false;

        if ((int)argArr[0] == argArr[0]) {
            isRealWhole = true;
        }
        if ((int)argArr[1] == argArr[1]) {
            isImagWhole = true;
        }

        String complexNumber = "";
        if (argArr[0] == 0 && argArr[1] == 0) { //a,b == 0
            complexNumber = "0";
        } else if (argArr[0] == 0) {            //a == 0, b != 0
            complexNumber = (isImagWhole ? imagIntStr : argArr[1]) + "i";
        } else {                                //a != 0
            if (argArr[1] > 0) {                    //b > 0
                complexNumber = (isRealWhole ? realIntStr : argArr[0]) + "+" + (isImagWhole ? imagIntStr : argArr[1]) + "i";
            } else if (argArr[1] == 0) {            //b == 0
                complexNumber = String.valueOf((isRealWhole ? realIntStr : argArr[0]));
            } else {                                //b < 0
                complexNumber = String.valueOf((isRealWhole ? realIntStr : argArr[0])) + String.valueOf((isImagWhole ? imagIntStr : argArr[1])) + "i";
            }
        }

        return complexNumber;
    }
}
