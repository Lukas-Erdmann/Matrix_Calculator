package control;

import static control.MatrixCreate.initializeWithZero;
import static control.TypeConversion.*;
import static model.MathObjects.Matrix;

public class MatrixCalc {

    /**
     * Calculates the sum of two complex matrices.
     * @param A         Complex input matrix A
     * @param B         Complex input matrix B
     * @return          Complex output matrix C
     */
    public static Matrix matrixAdd (Matrix A, Matrix B) {

        int aX = A.getColumns();
        int aY = A.getRows();
        int bX = B.getColumns();
        int bY = B.getRows();

        if (aY != bY | aX != bX) {
            throw new IllegalArgumentException("Matrix dimensions don`t match.");
        }

        int cX = aX, cY = aY;
        double[][] elementsC = new double[cX * cY][2];
        initializeWithZero(elementsC);

        for (int i = 0; i < aX; i++) { // aX
            for (int j = 0; j < bY; j++) { // bY
                elementsC[i * cX + j][0] = A.getElement(i, j, 0) + B.getElement(i, j, 0);
                elementsC[i * cX + j][1] = A.getElement(i, j, 1) + B.getElement(i, j, 1);
            }
        }

        return new Matrix(elementsC, cX, cY);
    }

    /**
     * Calculates the product of two complex matrices.
     * @param A         Complex input matrix A
     * @param B         Complex input matrix B
     * @return          Complex output matrix C
     */
    public static Matrix matrixMultiply (Matrix A, Matrix B) {

        int aX = A.getColumns();
        int aY = A.getRows();
        int bX = B.getColumns();
        int bY = B.getRows();

        if (aY != bX) {
            throw new IllegalArgumentException("A:Rows: " + aY + " did not match B:Columns " + bX + ".");
        }

        int cX = aX, cY = aY;
        double[][] elementsC = new double[cX * cY][2];
        initializeWithZero(elementsC);

        for (int i = 0; i < aX; i++) { // aX
            for (int j = 0; j < bY; j++) { // bY
                for (int k = 0; k < aY; k++) { // sum of single element multiplication
                    elementsC[i * cX + j][0] += A.getElement(i, k, 0) * B.getElement(k, j, 0) - A.getElement(i, k, 1) * B.getElement(k, j, 1);
                    elementsC[i * cX + j][1] += A.getElement(i, k, 0) * B.getElement(k, j, 1) + A.getElement(i, k, 1) * B.getElement(k, j, 0);
                }
            }
        }

        return new Matrix(elementsC, cX, cY);
    }

    /**
     * Transposes a complex matrix: A_ij --> A_ji
     * @param matrix        Complex input matrix
     * @return              complex transposed matrix
     */
    public static Matrix transposeMatrix (Matrix matrix) {
        double[][] elements = new double[matrix.getRows() * matrix.getColumns()][2];
        initializeWithZero(elements);

        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                elements[i * matrix.getColumns() + j][0] = matrix.getElement(j, i, 0);
                elements[i * matrix.getColumns() + j][1] = matrix.getElement(j, i, 1);
            }
        }
        return new Matrix(elements, matrix.getRows(), matrix.getColumns());
    }

    /**
     * Conjugates a complex matrix. Consists of transposing matrix and then conjugating all numbers
     * that are not on the main diagonal.
     * @param argMatrix     Complex input matrix
     * @return              Complex output matrix
     */
    public static Matrix conjugateMatrix(Matrix argMatrix) {
        double[][] elements = new double[argMatrix.getRows() * argMatrix.getColumns()][2];
        initializeWithZero(elements);
        Matrix matrix = transposeMatrix(argMatrix);

        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                elements[i * matrix.getColumns() + j][0] = matrix.getElement(i, j, 0);
                elements[i * matrix.getColumns() + j][1] = matrix.getElement(i, j, 1);
                if (i != j) {
                    elements[i * matrix.getColumns() + j][1] *= -1;
                }
            }
        }
        return new Matrix(elements, matrix.getColumns(), matrix.getRows());
    }

    public static double[] calcDeterminant (Matrix matrix) {
        //Todo: Write algorithm for Laplace expansion
        return new double[]{0, 0};
    }

    public static double[] calcTrace (Matrix matrix) {
        if (matrix.getColumns() != matrix.getRows()) {
            throw new IllegalArgumentException("Matrix has to be quadratic.");
        }

        double[] trace = {0, 0};
        for (int i = 0; i < matrix.getColumns(); i++) {
            trace[0] += matrix.getElement(i, i, 0);
            trace[1] += matrix.getElement(i, i, 1);
        }

        return trace;
    }

    /**
     * Gets the longest string in a complex matrix and returns its length.
     * @param matrix        Complex input matrix
     * @return              Length of the longest string
     */
    public static int getLongestElement (String[][] matrix) {
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((String.valueOf(matrix[i][j])).length() > max) {
                    max = (String.valueOf(matrix[i][j])).length();
                }
            }
        }
        return max;
    }

    /**
     * Converts a 3-dim double matrix into 2-dim string matrix. The innermost array is parsed
     * as a complex number string and written into the new matrix.
     * Used to correctly display complex matrix.
     * @param matrix        3-dim double input matrix
     * @return              2-dim Complex string matrix
     */
    public static String[][] makeComplexStringMatrix (Matrix matrix) {
        String[][] complexMatrix = new String[matrix.getColumns()][matrix.getRows()];
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                complexMatrix[i][j] = null;
            }
        }

        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                double[] intArray = {matrix.getElement(i, j, 0), matrix.getElement(i, j, 1)};
                complexMatrix[i][j] = doubleArrayToComplexString(intArray);
            }
        }
        return complexMatrix;
    }
}