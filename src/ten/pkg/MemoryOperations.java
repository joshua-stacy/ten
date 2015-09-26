/*
 ==============================================================
 == Date:          3/12/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    MemoryOperations
 == Purpose:       This class contains methods for Memory buttons.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import java.math.*;

public class MemoryOperations {
    //Create Variables for operations

    private static String numStr1, numStr2, resultStr, opStr, displayStr;
    private static int logicState;
    private static BigDecimal num1, num2, result, mem1, mem2;
    private static char op;

    public static void Mem1Button() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
                num1 = mem1;
                try {
                    numStr1 = num1.toString();
                    logicState = 1;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
            case 2:
            case 3:
                num2 = mem1;
                try {
                    numStr2 = num2.toString();
                    logicState = 3;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
            case 4:
                Main.VAR.ResetStandardCalculator();
                num1 = mem1;
                try {
                    numStr1 = num1.toString();
                    logicState = 1;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
        }
        SetAll();
    }

    public static void Mem1AddButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
            case 2:
                mem1 = mem1.add(num1, Main.CFG.GetDefaultMath());
                break;
            case 3:
                mem1 = mem1.add(num2, Main.CFG.GetDefaultMath());
                break;
            case 4:
                mem1 = mem1.add(result, Main.CFG.GetDefaultMath());
                break;
        }
        SetAll();
    }

    public static void Mem1Subtract() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
            case 2:
                mem1 = mem1.subtract(num1, Main.CFG.GetDefaultMath());
                break;
            case 3:
                mem1 = mem1.subtract(num2, Main.CFG.GetDefaultMath());
                break;
            case 4:
                mem1 = mem1.subtract(result, Main.CFG.GetDefaultMath());
                break;
        }
        SetAll();
    }

    public static void Mem1ClearButton() {
        GetAll();
        numStr1 = "0.0";
        mem1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
        SetAll();
    }

    public static void Mem2Button() {
        GetAll();

        switch (logicState) {
            case 0:
            case 1:
                num1 = mem2;
                try {
                    numStr1 = num1.toString();
                    logicState = 1;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
            case 2:
            case 3:
                num2 = mem2;
                try {
                    numStr2 = num2.toString();
                    logicState = 3;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
            case 4:
                Main.VAR.ResetStandardCalculator();
                num1 = mem2;
                try {
                    numStr1 = mem2.toString();
                    logicState = 1;
                } catch (Exception e) {
                    ErrorMessages.InvalidNumber();
                    numStr1 = "0";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 0;
                }
                Main.GUI.setDisplayText(numStr1);
                break;
        }
        SetAll();
    }

    public static void Mem2AddButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
            case 2:
                mem2 = mem2.add(num1, Main.CFG.GetDefaultMath());
                break;
            case 3:
                mem2 = mem2.add(num2, Main.CFG.GetDefaultMath());
                break;
            case 4:
                mem2 = mem2.add(result, Main.CFG.GetDefaultMath());
                break;
        }
        SetAll();
    }

    public static void Mem2SubtractButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
            case 2:
                mem2 = mem2.subtract(num1, Main.CFG.GetDefaultMath());
                break;
            case 3:
                mem2 = mem2.subtract(num2, Main.CFG.GetDefaultMath());
                break;
            case 4:
                mem2 = mem2.subtract(result, Main.CFG.GetDefaultMath());
                break;
        }
        SetAll();
    }

    public static void Mem2ClearButton() {
        GetAll();
        numStr2 = "0.0";
        mem2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
        SetAll();
    }

    private static void GetAll() {
        int activeTape = Main.GUI.getActiveTape();
        numStr1 = Main.VAR.GetNumStr1();
        numStr2 = Main.VAR.GetNumStr2();
        resultStr = Main.VAR.GetResultStr();
        opStr = Main.VAR.GetOpStr();
        displayStr = Main.VAR.GetDisplayStr();
        logicState = Main.VAR.GetLogicState(activeTape);
        num1 = Main.VAR.GetNum1();
        num2 = Main.VAR.GetNum2();
        result = Main.VAR.GetResult();
        mem1 = Main.VAR.GetMem1();
        mem2 = Main.VAR.GetMem2();
        op = Main.VAR.GetOp();
    }

    private static void SetAll() {
        int activeTape = Main.GUI.getActiveTape();
        Main.VAR.SetNumStr1(numStr1);
        Main.VAR.SetNumStr2(numStr2);
        Main.VAR.SetResultStr(resultStr);
        Main.VAR.SetOpStr(opStr);
        Main.VAR.SetDisplayStr(displayStr);
        Main.VAR.SetLogicState(activeTape, logicState);
        Main.VAR.SetNum1(numStr1);
        Main.VAR.SetNum2(numStr2);
        Main.VAR.SetResult(result.toString());
        Main.VAR.SetMem1(mem1.toString());
        Main.VAR.SetMem2(mem2.toString());
        Main.VAR.SetOp(op);
    }
}
