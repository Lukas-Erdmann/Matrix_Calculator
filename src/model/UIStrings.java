package model;

public class UIStrings {

    public static String strUseAns = " ";
    public static String strRanNum = " ";
    public static String strDataFromFile = " ";
    public static String[] TITLE_OVERHEAD_LINE = {"0", "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"};

    //-----------------
    // Main menu lines
    //Todo: Make more pages for main menu
    //Todo: Refresh only the parts of main menu that actually change (Buffer?)
    public static String[] MAIN_MENU_LINE_01 = {"1", "Choose operation mode:"};
    public static String[] MAIN_MENU_LINE_02 = {"2", ""};
    public static String[] MAIN_MENU_LINE_03 = {"3", "1. Matrix addition"};
    public static String[] MAIN_MENU_LINE_04 = {"4", "2. Matrix multiplication"};
    public static String[] MAIN_MENU_LINE_05 = {"5", "3. Transpose Matrix"};
    public static String[] MAIN_MENU_LINE_06 = {"6", "4. Conjugate Matrix"};
    public static String[] MAIN_MENU_LINE_07 = {"7", "5. Form Determinant"};
    public static String[] MAIN_MENU_LINE_08 = {"8", "6. Calculate Trace"};
    public static String[] MAIN_MENU_LINE_09A = {"9", "7. ["};
    public static String[] MAIN_MENU_LINE_09B = {"9", strDataFromFile};
    public static String[] MAIN_MENU_LINE_09C = {"9", "] Get data from file"};
    public static String[] MAIN_MENU_LINE_10A = {"10", "8. ["};
    public static String[] MAIN_MENU_LINE_10B = {"10", strUseAns}; // index 11
    public static String[] MAIN_MENU_LINE_10C = {"10", "] Use previous solution"};
    public static String[] MAIN_MENU_LINE_11A = {"11", "9. ["};
    public static String[] MAIN_MENU_LINE_11B = {"11", strRanNum}; // index 14
    public static String[] MAIN_MENU_LINE_11C = {"11", "] Generate random elements"};
    public static String[] MAIN_MENU_LINE_12 = {"12", "0. Exit application"};

    public static String[][] mainMenuLines = {TITLE_OVERHEAD_LINE, MAIN_MENU_LINE_01, MAIN_MENU_LINE_02, MAIN_MENU_LINE_03, MAIN_MENU_LINE_04, MAIN_MENU_LINE_05, MAIN_MENU_LINE_06, MAIN_MENU_LINE_07, MAIN_MENU_LINE_08, MAIN_MENU_LINE_09A, MAIN_MENU_LINE_09B, MAIN_MENU_LINE_09C, MAIN_MENU_LINE_10A, MAIN_MENU_LINE_10B, MAIN_MENU_LINE_10C, MAIN_MENU_LINE_11A, MAIN_MENU_LINE_11B, MAIN_MENU_LINE_11C, MAIN_MENU_LINE_12};

    //-------------------------------
    // Input matrix dimensions lines
    public static String[] MAT_DIM_LINE_01A = {"1", "Input matrix dimensions (Syntax: "};
    public static String[] MAT_DIM_LINE_01B = {"1", "MATRIX_DIMENSIONS"};
    public static String[] MAT_DIM_LINE_01C = {"1", "):"};

    public static String[][] matDimLines = {TITLE_OVERHEAD_LINE, MAT_DIM_LINE_01A, MAT_DIM_LINE_01B, MAT_DIM_LINE_01C};

    //---------------------------
    // Input random number range
    public static String[] RAN_NUM_A_LINE_01 = {"1", "Input random number range for matrix A (Syntax: Re(min),Re(max),Im(min),Im(max)):"};

    public static String[][] ranNumALines = {TITLE_OVERHEAD_LINE, RAN_NUM_A_LINE_01};

    public static String[] RAN_NUM_B_LINE_01 = {"1", "Input random number range for matrix B (Syntax: Re(min),Re(max),Im(min),Im(max)):"};

    public static String[][] ranNumBLines = {TITLE_OVERHEAD_LINE, RAN_NUM_B_LINE_01};

    //--------------------------------
    // Input matrix elements manually
    public static String[] MAN_NUM_LINE_01A = {"1", "Input matrix elements (Syntax: "};
    public static String[] MAN_NUM_LINE_01M = {"1", "MATRIX_NAME"};
    public static String[] MAN_NUM_LINE_01R = {"1", "MATRIX_ROW"};
    public static String[] MAN_NUM_LINE_01B = {"1", "0,"};
    public static String[] MAN_NUM_LINE_01C = {"1", "1,"};
    public static String[] MAN_NUM_LINE_01D = {"1", "2,...):"};
    public static String[][] manNumLines = {TITLE_OVERHEAD_LINE, MAN_NUM_LINE_01A, MAN_NUM_LINE_01M, MAN_NUM_LINE_01R, MAN_NUM_LINE_01B, MAN_NUM_LINE_01M, MAN_NUM_LINE_01R, MAN_NUM_LINE_01C, MAN_NUM_LINE_01M, MAN_NUM_LINE_01R, MAN_NUM_LINE_01D};
}