package view;

import java.util.Arrays;

public class DisplayMath {

    /**
     * Displays a 2-dim int matrix with correctly aligned elements. Prints matrix name and spacer above matrix.
     * Width provided is adjusted with width parameter. Space width depends on width of title and
     * amount and width of matrix elements. Used to display non-complex matrices.
     * @param matrix         Input 2-dim int matrix
     * @param title          String of matrix name
     * @param width          int of max elements width
     */
    public static void displayMatrix (double[][][] matrix, String title, int width) {
        //Print header
        System.out.println(title);
        for (int i = 0; i < title.length() || i <= matrix.length * width + matrix.length; i++) {
            System.out.print("-");
        }
        System.out.println();

        //Print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k <= width - (Arrays.toString(matrix[i][j])).length(); k++) {
                    System.out.print(" ");
                }
                System.out.print(Arrays.toString(matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Displays a 2-dim string matrix with correctly aligned elements. Prints matrix name and spacer above matrix.
     * Width provided is adjusted with width parameter. Space width depends on width of title and
     * amount and width of matrix elements. Used to display complex matrices.
     * @param matrix         Input 2-dim string matrix
     * @param title          String of matrix name
     * @param width          int of max elements width
     */
    public static void displayMatrix (String[][] matrix, String title, int width) {
        //Print header
        System.out.println(title);
        for (int i = 0; i < title.length() || i <= matrix.length * width + matrix.length; i++) {
            System.out.print("-");
        }
        System.out.println();

        //Print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k <= width - (String.valueOf(matrix[i][j])).length(); k++) {
                    System.out.print(" ");
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayDouble (String value, String title) {
        //Print header
        System.out.println(title);
        for (int i = 0; i < title.length() || i <= value.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(value);
        System.out.println();
    }
}
