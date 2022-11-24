package model;

public abstract class MathObjects {

    public static class Matrix {    //Matrix class

        private int rows;
        private int columns;

        private double[][][] matrix;

        /**
         * Constructor of custom Matrix class. Takes 2-dim double array of complex numbers to construct
         * 3-dim matrix with size of rows * columns * 2.
         * @param elements      2-dim double array
         * @param rows       Integer number of matrix columns
         * @param columns          Integer number of matrix rows
         */
        public Matrix (double[][] elements, int rows, int columns) throws IllegalArgumentException {
            if ( (elements.length != rows * columns) || (rows < 1) || (columns < 1) ) {
                throw new IllegalArgumentException("Matrix dimensions don`t match.");
            }

            this.rows = rows;
            this.columns = columns;

            this.matrix = new double[rows][columns][2];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.matrix[i][j][0] = elements[i * columns + j][0];
                    this.matrix[i][j][1] = elements[i * columns + j][1];
                }
            }
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

        public double getElement (int row, int column, int part) {
            return matrix[row][column][part];
        }

        public void setElement (int row, int column, int part, double value) {
            matrix[row][column][part] = value;
        }
    }

}
