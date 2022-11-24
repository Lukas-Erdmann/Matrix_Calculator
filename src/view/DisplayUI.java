package view;

import static model.UIStrings.*;
import static control.BasicIO.*;
import static model.OperationParameters.*;

public class DisplayUI {

    private static boolean stayInMenu = true;

    /**
     * Displays the main menu of the calculator and sets the operation mode
     * according to user input.
     */
    public static void mainMenu () {
        while (stayInMenu) {

            //Menu to choose operation mode
            int menuInput = basicInputPromptInt(mainMenuLines);
            //Todo: Use direct input method that reads live keyboard input

            switch (menuInput) {
                case 1:
                    setOperationMode(1);
                    twoMatrixMode();
                    stayInMenu = false;
                    break;
                case 2:
                    setOperationMode(2);
                    twoMatrixMode();
                    stayInMenu = false;
                    break;
                case 3:
                    setOperationMode(3);
                    oneMatrixMode();
                    stayInMenu = false;
                    break;
                case 4:
                    setOperationMode(4);
                    oneMatrixMode();
                    stayInMenu = false;
                    break;
                case 5:
                    restartMenu();
                    /*
                    setOperationMode(5);
                    oneMatrixMode();
                    stayInMenu = false;
                    break;
                     */
                    break;
                case 6:
                    setOperationMode(6);
                    oneMatrixMode();
                    stayInMenu = false;
                    break;
                case 7:
                    MAIN_MENU_LINE_09B[1] = toggleOption(isDataFromFile());
                    setDataFromFile(!isDataFromFile());
                    if (isGenerateRanNum()) {
                        setGenerateRanNum(false);
                        MAIN_MENU_LINE_11B[1] = " ";
                    }
                    break;
                case 8:
                    MAIN_MENU_LINE_10B[1] = toggleOption(isUseAnsMatrix());
                    setUseAnsMatrix(!isUseAnsMatrix());
                    break;
                case 9:
                    MAIN_MENU_LINE_11B[1] = toggleOption(isGenerateRanNum());
                    setGenerateRanNum(!isGenerateRanNum());
                    if (isDataFromFile()) {
                        setDataFromFile(false);
                        MAIN_MENU_LINE_09B[1] = " ";
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    restartMenu();
            }
        }
    }

    /**
     * Restarts the main menu if user input is not valid.
     */
    private static void restartMenu () {
        System.out.println("Operation mode not available. Try again!");
        System.out.println();
        mainMenu();
        System.exit(0);
    }

    /**
     * Provides char for displaying if option is toggled.
     * Accepts boolean of the toggled option.
     * @param option        Boolean of binary option
     * @return              String ("X" || " ")
     */
    private static String toggleOption (boolean option) {
        String strOn = "X";
        String strOff = " ";

        option = !option;
        return option ? strOn : strOff;
    }


    public static boolean isStayInMenu() {
        return stayInMenu;
    }

    public static void setStayInMenu(boolean stayInMenu) {
        DisplayUI.stayInMenu = stayInMenu;
    }
}
