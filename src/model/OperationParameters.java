package model;

import model.UIStrings.*;

import static model.UIStrings.*;

public class OperationParameters {
    private static boolean generateRanNum = false;
    private static boolean useAnsMatrix = false;
    private static int operationMode = 0;
    private static int strArrSize = 0;


    public static void oneMatrixMode () {
        MAT_DIM_LINE_01B[1] = "aX,aY";
        strArrSize = 2;
    }

    public static void twoMatrixMode () {
        MAT_DIM_LINE_01B[1] = "aX,aY,bX,bY";
        strArrSize = 4;
    }

    public static void twoMatrixModeAns () {
        MAT_DIM_LINE_01B[1] = "bX,bY";
        strArrSize = 4;
    }

    //Getters and Setters
    public static boolean isGenerateRanNum() {
        return generateRanNum;
    }

    public static void setGenerateRanNum(boolean generateRanNum) {
        OperationParameters.generateRanNum = generateRanNum;
    }

    public static boolean isUseAnsMatrix() {
        return useAnsMatrix;
    }

    public static void setUseAnsMatrix(boolean useAnsMatrix) {
        OperationParameters.useAnsMatrix = useAnsMatrix;
    }

    public static int getOperationMode() {
        return operationMode;
    }

    public static void setOperationMode(int operationMode) {
        OperationParameters.operationMode = operationMode;
    }

    public static int getStrArrSize() {
        return strArrSize;
    }

    public static void setStrArrSize(int strArrSize) {
        OperationParameters.strArrSize = strArrSize;
    }
}
