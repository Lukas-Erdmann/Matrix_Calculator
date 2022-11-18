package model;

import java.util.Arrays;

public class MathObjects {

    public static class Matrix {    //Matrix class

        private int columns;
        private int rows;

        private double[][][] matrix;

        /**
         * Constructor of custom Matrix class. Takes 2-dim double array of complex numbers to construct
         * 3-dim matrix with size of columns * rows * 2.
         * @param elements      2-dim double array
         * @param columns       Integer number of matrix columns
         * @param rows          Integer number of matrix rows
         */
        public Matrix (double[][] elements, int columns, int rows) {   //constructor of matrix class
            this.columns = columns;
            this.rows = rows;

            this.matrix = new double[columns][rows][2];

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    this.matrix[i][j][0] = elements[i * columns + j][0];
                    this.matrix[i][j][1] = elements[i * columns + j][1];
                }
            }
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public double getElement (int column, int row, int part) {
            return matrix[column][row][part];
        }
    }

}
