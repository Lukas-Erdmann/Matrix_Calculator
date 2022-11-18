package control;

import model.MathObjects.Matrix;

import java.util.Random;

import static control.BasicIO.*;
import static model.UIStrings.*;

public class MatrixCreate
{
    /**
     * Creates an n*m matrix with random numbers between min and max bounds. Min and max are input by user.
     * Can display input message for matrix A and B separately.
     * @param columns       Integer number of columns
     * @param rows          Integer number of rows
     * @param isMatrixA     Boolean: If true -> Matrix A, else -> Matrix B
     * @return              Result Matrix
     */
    public static Matrix createRandom (int columns, int rows, boolean isMatrixA) {
        double[][] elements = new double[columns * rows][2];
        int[] ranIntArr = isMatrixA ? tryParsingIntegers(ranNumALines, 4) : tryParsingIntegers(ranNumBLines, 4);

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                elements[i * columns + j][0] = generateRandomNumber(ranIntArr[0], ranIntArr[1]);
                elements[i * columns + j][1] = generateRandomNumber(ranIntArr[2], ranIntArr[3]);
            }
        }
        return new Matrix(elements, columns, rows);
    }

    /**
     * Creates an n*m matrix with manually input numbers. User input happens row-wise with commas as delimiters.
     * Can display input message for matrix A and B separately.
     * @param columns       Integer number of columns
     * @param rows          Integer number of rows
     * @param isMatrixA     Boolean: If true -> Matrix A, else -> Matrix B
     * @return              Result Matrix
     */
    public static Matrix createManual (int columns, int rows, boolean isMatrixA) {
        double[][] elements = new double[columns * rows][2];
        initializeWithZero(elements);

        MAN_NUM_LINE_01M[1] = isMatrixA ? "A" : "B";

        for (int i = 0; i < columns; i++) {
            MAN_NUM_LINE_01R[1] = String.valueOf(i);
            //Input prompt to manually set matrix elements
            double[][] elementArray = tryParsingComplex(manNumLines, rows);

            for (int j = 0; j < rows; j++) {
                elements[i * columns + j] = elementArray[j];
            }
        }

        return new Matrix(elements, columns, rows);
    }

    /**
     * Generates a random integer between min and max bound.
     * Bounds can be negative, but min must be smaller than max.
     * @param argMin        Min bound
     * @param argMax        Max bound
     * @return              Random integer
     */
    public static int generateRandomNumber (int argMin, int argMax) {
        return new Random().nextInt(argMin, argMax);
    }

    /**
     * Initializes 2-dim double array with zeros.
     * @param array         Uninitialized 2-dim double array
     */
    public static void initializeWithZero (double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }
}
