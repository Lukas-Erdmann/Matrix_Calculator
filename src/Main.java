/**
 * The Matrix Calculator provides tools to perform matrix operations on one or two matrices.
 * It can perform simple calculations like addition, multiplication or transposition,
 * but also more complex operations like conjugating and transposing complex matrices.
 *
 * @author Lukas Erdmann
 * @version 1.0
 * @since 2022-11-17
 */

import static control.BasicIO.*;
import static control.MatrixCalc.*;
import static control.MatrixCreate.*;
import static control.TypeConversion.*;
import static model.OperationParameters.*;
import static model.UIStrings.*;
import static model.MathObjects.*;
import static view.DisplayMath.*;
import static view.DisplayUI.*;

public class Main {
    private static Matrix A;
    private static Matrix B;
    private static Matrix resultMatrix;
    private static double[] resultNumber;
    private static Matrix ansMatrix;

    public static void main(String[] args) {
        while (true) {
            //Display main menu
            mainMenu();

            exceptionHandler(() -> {
                int[] dimIntArr = new int[getStrArrSize()];
                //Input prompt to set matrix dimensions
                if (isUseAnsMatrix() && (getStrArrSize() == 4)) {
                    twoMatrixModeAns();
                    int[] dimBIntArr = exceptionHandler(() -> stringToIntArray(basicInputPromptStr(matDimLines), 2));
                    int[] dimAIntArr = {ansMatrix.getColumns(), ansMatrix.getRows()};
                    System.arraycopy(dimAIntArr, 0, dimIntArr, 0, dimAIntArr.length);
                    System.arraycopy(dimBIntArr, 0, dimIntArr, 2, dimBIntArr.length);
                } else if (!(getStrArrSize() == 2 && isUseAnsMatrix())) {
                    dimIntArr = exceptionHandler(() -> stringToIntArray(basicInputPromptStr(matDimLines), getStrArrSize()));
                }

                /*
                 * Matrix A is always generated as at least one matrix is needed. Three cases are possible:
                 *    1. The previous result matrix is used --> Matrix A = MatrixResult
                 *    2. The matrix is filled with random numbers in a given interval
                 *    3. The element values are input manually
                 */
                if (isUseAnsMatrix()) {
                    A = ansMatrix;
                } else if (isGenerateRanNum()) {
                    A = createRandom(dimIntArr[0], dimIntArr[1], true);
                } else {
                    A = createManual(dimIntArr[0], dimIntArr[1], true);
                }
                /*
                 * When two matrices are needed for the operation, matrix B is also generated:
                 * The elements are either randomly generated or manually set.
                 */
                if (getOperationMode() == 1 || getOperationMode() == 2) {
                    if (isGenerateRanNum()) {
                        B = createRandom(dimIntArr[2], dimIntArr[3], false);
                    } else {
                        B = createManual(dimIntArr[2], dimIntArr[3], false);
                    }
                }

                //Get calculated results
                //Todo: Handle exceptions occurring during calculation
                switch (getOperationMode()) {
                    case 1 -> resultMatrix = matrixAdd(A, B);
                    case 2 -> resultMatrix = matrixMultiply(A, B);
                    case 3 -> resultMatrix = transposeMatrix(A);
                    case 4 -> resultMatrix = conjugateMatrix(A);
                    case 6 -> resultNumber = calcTrace(A);
                    default -> throw new IllegalArgumentException("Operation mode error");
                }
                ;
                ansMatrix = resultMatrix;
            });

            //Display input matrices and results
            System.out.println();
            int matAWidth = getLongestElement(makeComplexStringMatrix(A));
            displayMatrix(makeComplexStringMatrix(A), "Matrix A", matAWidth);
            if (getOperationMode() == 1 || getOperationMode() == 2) {
                int matBWidth = getLongestElement(makeComplexStringMatrix(B));
                displayMatrix(makeComplexStringMatrix(B), "Matrix B", matBWidth);
            }
            if (getOperationMode() == 6) {
                displayDouble(doubleArrayToComplexString(resultNumber), "Trace");
            }else {
                int matResultWidth = getLongestElement(makeComplexStringMatrix(resultMatrix));
                displayMatrix(makeComplexStringMatrix(resultMatrix), "Solution", matResultWidth);
            }

            setStayInMenu(true);

        }
    }
}