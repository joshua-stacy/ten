/*
 ==============================================================
 == Date: 6/15/2011
 == Programmer: Joshua Stacy
 == Program: Tape_Calculator
 == Class Name: Operations
 == Purpose: This class contains methods for performing
 == mathematical operations.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import javax.swing.*;
import java.math.*;

public class Operations {

    private static String numStr1, numStr2, numStr3, resultStr, opStr, opStr2,
            displayStr, newOpStr, powerStr, rootStr;
    private static int logicState, opLogic, decimalPlaces, i, j, o, t, c;
    private static BigDecimal num1, num2, num3, result, mem1, mem2, power, root;
    private static char op, op2, oldOp, newOp;

    public static void NumberButton(String inputStr) {
        inputStr = FormatInput(inputStr);
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    numStr1 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num1, i, j, t);
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 1:
                    if (numStr1.contains(".") == false && num1.compareTo(BigDecimal.ZERO) == 0) {
                        numStr1 = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        numStr1 += inputStr;
                        numStr1 = Evaluate.Trim(decimalPlaces, numStr1);
                    }
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num1, i, j, t);
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num1, i, j, t);
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    numStr2 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 2;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.contains(".") == false && num2.compareTo(BigDecimal.ZERO) == 0) {
                        numStr2 = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        numStr2 += inputStr;
                        numStr2 = Evaluate.Trim(decimalPlaces, numStr2);
                    }
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 2;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    numStr2 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(num2, i, j, t);
                        logicState = 0;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                    numStr1 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 1:
                    if (numStr1.contains(".") == false && num1.compareTo(BigDecimal.ZERO) == 0) {
                        numStr1 = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        numStr1 += inputStr;
                        numStr1 = Evaluate.Trim(decimalPlaces, numStr1);
                    }
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    numStr2 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.contains(".") == false && num2.compareTo(BigDecimal.ZERO) == 0) {
                        numStr2 = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        numStr2 += inputStr;
                        numStr2 = Evaluate.Trim(decimalPlaces, numStr2);
                    }
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                case 7:
                    Main.VAR.ResetStandardCalculator();
                    numStr1 = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 5:
                    numStr3 = inputStr;
                    try {
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 6;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 5;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    if (numStr3.contains(".") == false && num1.compareTo(BigDecimal.ZERO) == 0) {
                        numStr3 = inputStr;
                    } else {
                        numStr3 += inputStr;
                    }
                    try {
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 6;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr3 = "0";
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 5;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 11:
                case 21:
                case 31:
                    powerStr = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetPower(powerStr);
                        logicState += 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        powerStr = "0";
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetPower(powerStr);
                        if (logicState == 11) {
                            logicState = 1;
                        } else if (logicState == 21) {
                            logicState = 3;
                        } else if (logicState == 31) {
                            logicState = 6;
                        }
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 12:
                case 22:
                case 32:
                    if (powerStr.contains(".") == false && power.compareTo(BigDecimal.ZERO) == 0) {
                        powerStr = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        powerStr += inputStr;
                        powerStr = Evaluate.Trim(decimalPlaces, powerStr);
                    }
                    try {
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetPower(powerStr);
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        powerStr = "0";
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetPower(powerStr);
                        if (logicState == 12) {
                            logicState = 1;
                        } else if (logicState == 22) {
                            logicState = 3;
                        } else if (logicState == 32) {
                            logicState = 6;
                        }
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 41:
                case 51:
                case 61:
                    rootStr = Evaluate.Trim(decimalPlaces, inputStr);
                    try {
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetRoot(rootStr);
                        logicState += 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        rootStr = "0";
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetPower(rootStr);
                        if (logicState == 41) {
                            logicState = 1;
                        } else if (logicState == 51) {
                            logicState = 3;
                        } else if (logicState == 61) {
                            logicState = 6;
                        }
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 42:
                case 52:
                case 62:
                    if (rootStr.contains(".") == false && root.compareTo(BigDecimal.ZERO) == 0) {
                        rootStr = Evaluate.Trim(decimalPlaces, inputStr);
                    } else {
                        rootStr += inputStr;
                        rootStr = Evaluate.Trim(decimalPlaces, rootStr);
                    }
                    try {
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetRoot(rootStr);
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        rootStr = "0";
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        Main.VAR.SetRoot(rootStr);
                        if (logicState == 12) {
                            logicState = 1;
                        } else if (logicState == 22) {
                            logicState = 3;
                        } else if (logicState == 32) {
                            logicState = 6;
                        }
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
            }
        }
    }

    public static void DecimalButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    numStr1 = "0.";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num1, i, j, t);
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 1:
                    if (numStr1.contains(".")) {
                    } else {
                        numStr1 += ".";
                    }
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    numStr2 = "0.";
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.contains(".")) {
                    } else {
                        numStr2 += ".";
                    }
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    numStr1 = "0.";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num1, i, j, t);
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                    numStr1 = "0.";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 1:
                    if (numStr1.contains(".")) {
                    } else {
                        numStr1 += ".";
                    }
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    numStr2 = "0.";
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.contains(".")) {
                    } else {
                        numStr2 += ".";
                    }
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                case 7:
                    Main.VAR.ResetStandardCalculator();
                    numStr1 = "0.";
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 5:
                    numStr3 = "0.";
                    num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                    logicState = 6;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    if (numStr3.contains(".")) {
                    } else {
                        numStr3 += ".";
                    }
                    logicState = 6;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 11:
                case 21:
                case 31:
                    powerStr = "0.";
                    power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                    logicState += 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 12:
                case 22:
                case 32:
                    if (powerStr.contains(".")) {
                    } else {
                        powerStr += ".";
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 41:
                case 51:
                case 61:
                    rootStr = "0.";
                    root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                    logicState += 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 42:
                case 52:
                case 62:
                    if (rootStr.contains(".")) {
                    } else {
                        rootStr += ".";
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
            }
        }
    }

    public static void OpButton(String inputStr) {
        inputStr = FormatInput(inputStr);
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    if (opStr.equals("+")) {
                        Main.VAR.SetNumbers(num1, i, j, t);
                        if (i < Main.VAR.iLimit - 1) {
                            i++;
                        } else {
                            InformationMessages.SubTotalLimit();
                        }
                        Main.VAR.SetIndex(i, j, o, t);
                        displayStr = numStr1 + " " + opStr;
                        logicState = 2;
                    } else if (opStr.equalsIgnoreCase("-")) {
                        num1 = num1.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        numStr1 = num1.toString();
                        numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                        Main.VAR.SetNumbers(num1, i, j, t);
                        if (i < Main.VAR.iLimit - 1) {
                            i++;
                        } else {
                            InformationMessages.SubTotalLimit();
                        }
                        Main.VAR.SetIndex(i, j, o, t);
                        logicState = 2;
                    } else {
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    break;
                case 3:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    Main.VAR.SetNumbers(num2, i, j, t);
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    Main.VAR.SetOpArray(op, o, j, t);
                    if (o < Main.VAR.oLimit - 1) {
                        o++;
                    } else {
                    }
                    Main.VAR.SetIndex(i, j, o, t);
                    logicState = 4;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    oldOp = Main.VAR.GetOpArray(o - 1, j, t);
                    if (i == Main.VAR.iLimit - 1 && o == Main.VAR.oLimit - 1 && Main.VAR.GetNumbers(i, j, t).compareTo(BigDecimal.ZERO) != 0) {
                        oldOp = Main.VAR.GetOpArray(o, j, t);
                        if (oldOp == '-') {
                            num2 = Main.VAR.GetNumbers(i, j, t);
                            num2 = num2.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                            Main.VAR.SetNumbers(num2, i, j, t);
                            numStr2 = Evaluate.DecimalPlaces(decimalPlaces, num2.toString());
                        } else {
                        }
                        Main.VAR.SetOpArray(op, o, j, t);
                    } else {
                        if (oldOp == '-') {
                            num2 = Main.VAR.GetNumbers(i - 1, j, t);
                            if (op == '-') {
                                num2 = num2.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                            }
                            Main.VAR.SetNumbers(num2, i - 1, j, t);
                            numStr2 = Evaluate.DecimalPlaces(decimalPlaces, num2.toString());
                        } else {
                        }
                        Main.VAR.SetOpArray(op, o - 1, j, t);
                    }
                    logicState = 4;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 11:
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                    break;
                case 1:
                case 2:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    logicState = 2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                case 7:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    logicState = 2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    opStr2 = inputStr;
                    op2 = opStr2.charAt(0);
                    if (op == '+' || op == '-') {
                        if (op2 == '+' || op2 == '-') {
                            try {
                                resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                                SetAll();
                                TapeEdit.TapeSet(2);
                                result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                                num1 = result;
                                numStr1 = resultStr;
                                opStr = inputStr;
                                op = opStr.charAt(0);
                                logicState = 2;
                                SetAll();
                                SetDisplay(opLogic, logicState, "");
                            } catch (Exception e) {
                                Main.VAR.ResetStandardCalculator();
                                SetDisplay(opLogic, logicState, "");
                            }
                        } else if (op2 == '*' || op2 == '/') {
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        }
                    } else if (op == '*' || op == '/') {
                        try {
                            SetAll();
                            TapeEdit.TapeSet(2);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = inputStr;
                            op = opStr.charAt(0);
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
                case 5:
                    opStr2 = inputStr;
                    op2 = opStr2.charAt(0);
                    logicState = 5;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    newOpStr = inputStr;
                    newOp = newOpStr.charAt(0);
                    if (newOp == '+' || newOp == '-') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                            SetAll();
                            TapeEdit.TapeSet(3);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = newOpStr;
                            op = newOp;
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    } else if (newOp == '*' || newOp == '/') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Evaluate(numStr2, numStr3, op2)));
                            numStr2 = resultStr;
                            num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                            opStr2 = newOpStr;
                            op2 = newOp;
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
                case 12:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr1)));
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                case 22:
                    opStr2 = inputStr;
                    op2 = opStr2.charAt(0);
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr2)));
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    if (op == '+' || op == '-') {
                        if (op2 == '+' || op2 == '-') {
                            try {
                                resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                                SetAll();
                                TapeEdit.TapeSet(2);
                                result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                                num1 = result;
                                numStr1 = resultStr;
                                opStr = inputStr;
                                op = opStr.charAt(0);
                                logicState = 2;
                                SetAll();
                                SetDisplay(opLogic, logicState, "");
                            } catch (Exception e) {
                                Main.VAR.ResetStandardCalculator();
                                SetDisplay(opLogic, logicState, "");
                            }
                        } else if (op2 == '*' || op2 == '/') {
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                            break;
                        }
                    } else if (op == '*' || op == '/') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                            SetAll();
                            TapeEdit.TapeSet(2);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = inputStr;
                            op = opStr.charAt(0);
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
                case 32:
                    newOpStr = inputStr;
                    newOp = newOpStr.charAt(0);
                    numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr3)));
                    num3 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    if (newOp == '+' || newOp == '-') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                            SetAll();
                            TapeEdit.TapeSet(3);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = newOpStr;
                            op = newOp;
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    } else if (newOp == '*' || newOp == '/') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Evaluate(numStr2, numStr3, op2)));
                            numStr2 = resultStr;
                            num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                            opStr2 = newOpStr;
                            op2 = newOp;
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
                case 42:
                    opStr = inputStr;
                    op = opStr.charAt(0);
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr1)));
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    logicState = 2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                case 52:
                    opStr2 = inputStr;
                    op2 = opStr2.charAt(0);
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr2)));
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    if (op == '+' || op == '-') {
                        if (op2 == '+' || op2 == '-') {
                            try {
                                resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                                SetAll();
                                TapeEdit.TapeSet(2);
                                result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                                num1 = result;
                                numStr1 = resultStr;
                                opStr = inputStr;
                                op = opStr.charAt(0);
                                logicState = 2;
                                SetAll();
                                SetDisplay(opLogic, logicState, "");
                            } catch (Exception e) {
                                Main.VAR.ResetStandardCalculator();
                                SetDisplay(opLogic, logicState, "");
                            }
                        } else if (op2 == '*' || op2 == '/') {
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                            break;
                        }
                    } else if (op == '*' || op == '/') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                            SetAll();
                            TapeEdit.TapeSet(2);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = inputStr;
                            op = opStr.charAt(0);
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
                case 62:
                    newOpStr = inputStr;
                    newOp = newOpStr.charAt(0);
                    numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr3)));
                    num3 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    if (newOp == '+' || newOp == '-') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                            SetAll();
                            TapeEdit.TapeSet(3);
                            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                            num1 = result;
                            numStr1 = resultStr;
                            opStr = newOpStr;
                            op = newOp;
                            logicState = 2;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    } else if (newOp == '*' || newOp == '/') {
                        try {
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Evaluate(numStr2, numStr3, op2)));
                            numStr2 = resultStr;
                            num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                            opStr2 = newOpStr;
                            op2 = newOp;
                            logicState = 5;
                            SetAll();
                            SetDisplay(opLogic, logicState, "");
                        } catch (Exception e) {
                            Main.VAR.ResetStandardCalculator();
                            SetDisplay(opLogic, logicState, "");
                        }
                    }
                    break;
            }
        }
    }

    public static void EqualsButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                case 1:
                case 2:
                case 3:
                    break;
                case 4:
                    numStr1 = Main.VAR.GetNumbers(0, j, t).toString();
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                    for (int a = 0; a < i - 1; a++) {
                        numStr2 = Main.VAR.GetNumbers(a + 1, j, t).toString();
                        op = Main.VAR.GetOpArray(a, j, t);
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                        SetAll();
                        numStr1 = resultStr;
                    }
                    TapeEdit.AddingMachineTapeSet(i, j, o, t);
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 1:
                case 2:
                case 5:
                case 11:
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                    break;
                case 3:
                case 4:
                case 7:
                    try {
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                        SetAll();
                        TapeEdit.TapeSet(2);
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        resultStr = result.toEngineeringString();
                        num1 = result;
                        numStr1 = Evaluate.DecimalPlaces(decimalPlaces, resultStr);
                        op = opStr.charAt(0);
                        logicState = 4;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 6:
                    try {
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                        SetAll();
                        TapeEdit.TapeSet(3);
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        num1 = result;
                        numStr1 = resultStr;
                        op = opStr.charAt(0);
                        logicState = 7;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 12:
                    try {
                        numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr1)));
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 22:
                    try {
                        numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr2)));
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        num1 = result;
                        numStr1 = resultStr;
                        logicState = 1;
                        TapeEdit.TapeSet(2);
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 32:
                    try {
                        numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyPower(powerStr, numStr3)));
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        num1 = result;
                        numStr1 = resultStr;
                        logicState = 1;
                        TapeEdit.TapeSet(3);
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 42:
                    try {
                        numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr1)));
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 52:
                    try {
                        numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr2)));
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        num1 = result;
                        numStr1 = resultStr;
                        logicState = 1;
                        TapeEdit.TapeSet(2);
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 62:
                    try {
                        numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.xyRoot(rootStr, numStr3)));
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, numStr3, op, op2));
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        num1 = result;
                        numStr1 = resultStr;
                        logicState = 1;
                        TapeEdit.TapeSet(3);
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
            }
        }
    }

    public static void SignChangeButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 2:
                case 5:
                case 11:
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                    break;
                case 1:
                    try {
                        num1 = num1.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        numStr1 = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, num1.toString()));
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 3:
                    try {
                        num2 = num2.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        numStr2 = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, num2.toString()));
                        displayStr = numStr1 + " " + opStr + " " + numStr2;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 4:
                case 7:
                    try {
                        result = result.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, result.toString()));
                        num1 = result;
                        numStr1 = resultStr;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 6:
                    try {
                        num3 = num3.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        numStr3 = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, num3.toString()));
                        displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3;
                        SetAll();
                        SetDisplay(opLogic, logicState, "");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 12:
                case 22:
                case 32:
                    try {
                        power = power.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        powerStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, power.toString()));
                        SetAll();
                        SetDisplay(opLogic, logicState, "^");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
                case 42:
                case 52:
                case 62:
                    try {
                        root = root.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
                        rootStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Trim(decimalPlaces, root.toString()));
                        SetAll();
                        SetDisplay(opLogic, logicState, "^");
                    } catch (Exception e) {
                        Main.VAR.ResetStandardCalculator();
                        SetDisplay(opLogic, logicState, "");
                    }
                    break;
            }
        }
    }

    public static void SquaredButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                case 2:
                    num1 = num1.pow(2, Main.CFG.GetDefaultMath());
                    logicState = 1;
                    numStr1 = num1.toString();
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num1, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                case 4:
                    num2 = num2.pow(2, Main.CFG.GetDefaultMath());
                    logicState = 3;
                    numStr2 = num2.toString();
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, numStr2);
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 11:
                case 12:
                case 21:
                case 22:
                case 31:
                case 32:
                case 41:
                case 42:
                case 51:
                case 52:
                case 61:
                case 62:
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                    num1 = num1.pow(2, Main.CFG.GetDefaultMath());
                    numStr1 = num1.toString();
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                    Main.VAR.SetNum1(numStr1);
                    op = ' ';
                    opStr = " ";
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                case 5:
                    num2 = num2.pow(2, Main.CFG.GetDefaultMath());
                    numStr2 = num2.toString();
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, numStr2);
                    Main.VAR.SetNum1(numStr2);
                    op2 = ' ';
                    opStr2 = " ";
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    num3 = num3.pow(2, Main.CFG.GetDefaultMath());
                    numStr3 = num3.toString();
                    numStr3 = Evaluate.DecimalPlaces(decimalPlaces, numStr3);
                    Main.VAR.SetNum1(numStr3);
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        }
    }

    public static void SquareRootButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                case 2:
                    result = Evaluate.nRoot(2, num1);
                    logicState = 1;
                    numStr1 = result.toString();
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                    num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num1, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                case 4:
                    result = Evaluate.nRoot(2, num2);
                    logicState = 3;
                    numStr2 = result.toString();
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, numStr2);
                    num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    displayStr = numStr2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 11:
                case 12:
                case 21:
                case 22:
                case 31:
                case 32:
                case 41:
                case 42:
                case 51:
                case 52:
                case 61:
                case 62:
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                    result = Evaluate.nRoot(2, num1);
                    numStr1 = result.toString();
                    numStr1 = Evaluate.DecimalPlaces(decimalPlaces, numStr1);
                    Main.VAR.SetNum1(numStr1);
                    op = ' ';
                    opStr = " ";
                    logicState = 1;
                    displayStr = numStr1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                case 5:
                    result = Evaluate.nRoot(2, num2);
                    numStr2 = result.toString();
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, numStr2);
                    Main.VAR.SetNum1(numStr2);
                    op2 = ' ';
                    opStr2 = " ";
                    logicState = 3;
                    displayStr = numStr2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    result = Evaluate.nRoot(2, num3);
                    numStr3 = result.toString();
                    numStr3 = Evaluate.DecimalPlaces(decimalPlaces, numStr3);
                    Main.VAR.SetNum1(numStr3);
                    logicState = 3;
                    displayStr = numStr3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        }
    }

    public static void PercentButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    numStr2 = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr2, "100", '/'));
                    numStr2 = Evaluate.Evaluate(Main.VAR.GetNumbers(i - 1, j, t).toString(), numStr2, '*');
                    num2 = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    logicState = 3;
                    displayStr = numStr2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    break;
            }

        } else {
        }
    }

    public static void BackSpaceButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                    if (numStr1.length() > 1) {
                        numStr1 = numStr1.substring(0, numStr1.length() - 1);
                    } else {
                        numStr1 = "0";
                    }
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    Main.VAR.SetNumbers(num1, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    if (numStr1.length() > 1) {
                        numStr1 = numStr1.substring(0, numStr1.length() - 1);
                    } else {
                        numStr1 = "0";
                    }
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        Main.VAR.SetIndex(i, j, o, t);
                        logicState = 0;
                    }
                    i--;
                    Main.VAR.SetNumbers(num1, i, j, t);
                    Main.VAR.SetIndex(i, j, o, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.length() > 1) {
                        numStr2 = numStr2.substring(0, numStr2.length() - 1);
                    } else {
                        numStr2 = "0";
                    }
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    Main.VAR.SetNumbers(num2, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    if (numStr2.length() > 1) {
                        numStr2 = numStr2.substring(0, numStr2.length() - 1);
                    } else {
                        numStr2 = "0";
                    }
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    i--;
                    o--;
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(' ', o, j, t);
                    Main.VAR.SetIndex(i, j, o, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 2:
                case 5:
                case 11:
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                    break;
                case 1:
                    if (numStr1.length() > 1) {
                        numStr1 = numStr1.substring(0, numStr1.length() - 1);
                    } else {
                        numStr1 = "0";
                    }
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    if (numStr2.length() > 1) {
                        numStr2 = numStr2.substring(0, numStr2.length() - 1);
                    } else {
                        numStr2 = "0";
                    }
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                case 7:
                    if (resultStr.length() > 1) {
                        resultStr = resultStr.substring(0, resultStr.length() - 1);
                    } else {
                        resultStr = "0";
                    }
                    try {
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        resultStr = "0";
                        result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    numStr1 = resultStr;
                    num1 = result;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    if (numStr3.length() > 1) {
                        numStr3 = numStr3.substring(0, numStr3.length() - 1);
                    } else {
                        numStr3 = "0";
                    }
                    try {
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr3 = "0";
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 12:
                case 22:
                case 32:
                    if (powerStr.length() > 1) {
                        powerStr = powerStr.substring(0, powerStr.length() - 1);
                    } else {
                        powerStr = "0";
                    }
                    try {
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        logicState -= 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        powerStr = "0";
                        power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                        logicState -= 1;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 42:
                case 52:
                case 62:
                    if (rootStr.length() > 1) {
                        rootStr = rootStr.substring(0, rootStr.length() - 1);
                    } else {
                        rootStr = "0";
                    }
                    try {
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        logicState -= 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        rootStr = "0";
                        root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                        logicState -= 1;
                    }
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        }
    }

    public static void ClearEntryButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                    break;
                case 1:
                    numStr1 = "0";
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    Main.VAR.SetNumbers(num1, i, j, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    numStr1 = "0";
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 1;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    i--;
                    Main.VAR.SetNumbers(num1, (i), j, t);
                    Main.VAR.SetIndex(i, j, o, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    numStr2 = "0";
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    Main.VAR.SetNumbers(num2, (i), j, t);
                    Main.VAR.SetIndex(i, j, o, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 4:
                    numStr2 = "0";
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 3;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    }
                    i--;
                    o--;
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(' ', o, j, t);
                    Main.VAR.SetIndex(i, j, o, t);
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
            }
        } else if (opLogic == 1) {
            switch (logicState) {
                case 0:
                case 4:
                case 7:
                    break;
                case 1:
                    numStr1 = "0";
                    try {
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr1 = "0";
                        num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    logicState = 0;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 2:
                    op = ' ';
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 3:
                    numStr2 = "0";
                    try {
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 2;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr2 = "0";
                        num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    logicState = 2;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 5:
                    op2 = ' ';
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 6:
                    numStr3 = "0";
                    try {
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 5;
                    } catch (Exception e) {
                        ErrorMessages.InvalidNumber();
                        numStr3 = "0";
                        num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                        logicState = 0;
                    }
                    logicState = 5;
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case 11:
                case 41:
                    logicState = 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 21:
                case 51:
                    logicState = 3;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 31:
                case 61:
                    logicState = 6;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 12:
                case 22:
                case 32:
                    powerStr = "0";
                    power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
                    logicState -= 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
                case 42:
                case 52:
                case 62:
                    rootStr = "0";
                    root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
                    logicState -= 1;
                    SetAll();
                    SetDisplay(opLogic, logicState, "^");
                    break;
            }
        }
    }

    public static void ClearSubTotalButton() {
        int option = InformationMessages.ClearSubTotal();
        switch (option) {
            case JOptionPane.YES_OPTION:
                GetAll();
                num1 = BigDecimal.ZERO;
                for (int x = 0; x <= i; x++) {
                    Main.VAR.SetNumbers(num1, x, j, t);
                }
                op = ' ';
                for (int y = 0; y <= o; y++) {
                    Main.VAR.SetOpArray(op, y, j, t);
                }
                i = 0;
                o = 0;
                Main.VAR.SetIndex(0, j, 0, t);
                logicState = 0;
                ClearVariables();
                SetAll();
                SetDisplay(opLogic, logicState, "");
                break;
            case JOptionPane.NO_OPTION:
                break;
        }
    }

    public static void ClearAllButton() {
        GetAll();
        if (opLogic == 0) {
            int option = InformationMessages.ClearSubTotal();
            switch (option) {
                case JOptionPane.YES_OPTION:
                    num1 = BigDecimal.ZERO;
                    for (int y = 0; y < Main.VAR.jLimit; y++) {
                        for (int x = 0; x < Main.VAR.iLimit; x++) {
                            Main.VAR.SetNumbers(num1, x, y, t);
                        }
                        op = ' ';
                        for (int a = 0; a < Main.VAR.oLimit; a++) {
                            Main.VAR.SetOpArray(op, a, y, t);
                        }
                    }
                    i = 0;
                    o = 0;
                    j = 0;
                    Main.VAR.SetIndex(0, j, 0, t);
                    logicState = 0;
                    ClearVariables();
                    SetAll();
                    SetDisplay(opLogic, logicState, "");
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        } else if (opLogic == 1) {
            Main.VAR.ResetStandardCalculator();
            SetDisplay(opLogic, logicState, "");
        }
    }

    private static void GetAll() {
        t = Main.GUI.getActiveTape();
        numStr1 = Main.VAR.GetNumStr1();
        numStr2 = Main.VAR.GetNumStr2();
        numStr3 = Main.VAR.GetNumStr3();
        resultStr = Main.VAR.GetResultStr();
        powerStr = Main.VAR.GetPowerStr();
        rootStr = Main.VAR.GetRootStr();
        opStr = Main.VAR.GetOpStr();
        opStr2 = Main.VAR.GetOpStr2();
        displayStr = Main.VAR.GetDisplayStr();
        opLogic = Main.VAR.GetOpLogic(t);
        decimalPlaces = Main.CFG.GetDecimalPlaces(opLogic);
        logicState = Main.VAR.GetLogicState(t);
        num1 = Main.VAR.GetNum1();
        num2 = Main.VAR.GetNum2();
        num3 = Main.VAR.GetNum3();
        result = Main.VAR.GetResult();
        power = Main.VAR.GetPower();
        root = Main.VAR.GetRoot();
        mem1 = Main.VAR.GetMem1();
        mem2 = Main.VAR.GetMem2();
        op = Main.VAR.GetOp();
        t = Main.VAR.GetIndexT();
        i = Main.VAR.GetIndexI(t);
        j = Main.VAR.GetIndexJ(t);
        o = Main.VAR.GetIndexO(t);
    }

    private static void SetAll() {
        t = Main.GUI.getActiveTape();
        Main.VAR.SetNumStr1(numStr1);
        Main.VAR.SetNumStr2(numStr2);
        Main.VAR.SetNumStr3(numStr3);
        Main.VAR.SetResultStr(resultStr);
        Main.VAR.SetPowerStr(powerStr);
        Main.VAR.SetRootStr(rootStr);
        Main.VAR.SetOpStr(opStr);
        Main.VAR.SetOpStr2(opStr2);
        Main.VAR.SetDisplayStr(displayStr);
        Main.VAR.SetLogicState(t, logicState);
        Main.VAR.SetNum1(numStr1);
        Main.VAR.SetNum2(numStr2);
        Main.VAR.SetNum3(numStr3);
        Main.VAR.SetResult(resultStr);
        Main.VAR.SetPower(powerStr);
        Main.VAR.SetRoot(rootStr);
        Main.VAR.SetOp(op);
        Main.VAR.SetOp2(op2);
        Main.VAR.SetIndex(i, j, o, t);
    }

    public static int FirstOp(int y) {
        int firstOp = 0;
        for (int x = Main.VAR.oLimit - 1; x >= 0; x--) {
            op = Main.VAR.GetOpArray(x, y, t);
            if (op == '+' || op == '-') {
                firstOp = x;
            }
        }
        return firstOp;
    }

    public static int LastOp(int y) {
        int lastOp = 0;
        for (int x = 0; x < Main.VAR.oLimit; x++) {
            op = Main.VAR.GetOpArray(x, y, t);
            if (op == '+' || op == '-') {
                lastOp = x;
            }
        }
        return lastOp;
    }

    public static void ClearVariables() {
        numStr1 = "0";
        numStr2 = "0";
        numStr3 = "0";
        resultStr = "0";
        powerStr = "0";
        rootStr = "0";
        opStr = "";
        opStr2 = "";
        displayStr = "";
        newOpStr = "";
        num1 = BigDecimal.ZERO;
        num2 = BigDecimal.ZERO;
        num3 = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        power = BigDecimal.ZERO;
        root = BigDecimal.ZERO;
        op = ' ';
        op2 = ' ';
        oldOp = ' ';
        newOp = ' ';
    }

    public static String FormatInput(String input) {
        String formatted = input;
        return formatted;
    }

    public static void SetDisplay(int mode, int state, String special) {
        GetAll();
        if (mode == 0) {    //Op Logic
            switch (state) {
                case 0:
                case 1:
                    displayStr = numStr1;
                    break;
                case 2:
                    displayStr = numStr1 + " " + opStr;
                    break;
                case 3:
                    displayStr = numStr2;
                    break;
                case 4:
                    displayStr = numStr2 + " " + opStr;
            }

        } else if (mode == 1) {
            switch (state) {
                case 0:
                case 1:
                case 7:
                    displayStr = numStr1;
                    break;
                case 2:
                    displayStr = numStr1 + " " + opStr;
                    break;
                case 3:
                    displayStr = numStr1 + " " + opStr + " " + numStr2;
                    break;
                case 4:
                    displayStr = numStr1;
                    break;
                case 5:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2;
                    break;
                case 6:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3;
                    break;
                case 11:
                    displayStr = numStr1 + " " + special + " ()";
                    break;
                case 12:
                    displayStr = numStr1 + " " + special + " (" + powerStr + ")";
                    break;
                case 21:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + special + " ()";
                    break;
                case 22:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + special + " (" + powerStr + ")";
                    break;
                case 31:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3 + " " + special + " ()";
                    break;
                case 32:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3 + " " + special + " (" + powerStr + ")";
                    break;
                case 41:
                    displayStr = numStr1 + " " + special + " (1/ )";
                    break;
                case 42:
                    displayStr = numStr1 + " " + special + " (1/" + rootStr + ")";
                    break;
                case 51:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + special + " (1/ )";
                    break;
                case 52:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + special + " (1/" + rootStr + ")";
                    break;
                case 61:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3 + " " + special + " (1/ )";
                    break;
                case 62:
                    displayStr = numStr1 + " " + opStr + " " + numStr2 + " " + opStr2 + " " + numStr3 + " " + special + "(1/" + rootStr + ")";
                    break;
            }
        }
        Main.GUI.setDisplayText(displayStr);
    }
}
