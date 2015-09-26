/*
 ==============================================================
 == Date:          //2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    AccountingOperations
 == Purpose:       This class contains methods for Accounting buttons.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;

//Import necessary packages
import javax.swing.*;
import java.math.*;

public class AccountingOperations {

    private static String numStr1, numStr2, numStr3, resultStr, opStr, opStr2,
            displayStr, newOpStr, taxPlusStr, taxMinusStr;
    private static int logicState, opLogic, decimalPlaces, i, j, o, t, c;
    private static BigDecimal num1, num2, num3, result, mem1, mem2;
    private static char op, op2, oldOp, newOp;

    public static void SubTotalButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                if (o > 0) {
                    int firstOp = Operations.FirstOp(j);
                    int lastOp = Operations.LastOp(j);
                    numStr1 = Evaluate.Trim(decimalPlaces, Main.VAR.GetNumbers(firstOp, j, t).toString());
                    TapeEdit.SubtotalHeader(firstOp, j, t);
                    c = 1;
                    for (int a = firstOp; a <= lastOp; a++) {
                        op = Main.VAR.GetOpArray(a, j, t);
                        if (op == '+' || op == '-') {
                            numStr2 = Evaluate.Trim(decimalPlaces, Main.VAR.GetNumbers(a + 1, j, t).toString());
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, numStr2, op));
                            numStr1 = resultStr;
                            TapeEdit.SubtotalTapeSet(a + 1, j, a, t);
                            c++;
                            SetAll();
                            Main.GUI.setDisplayText("");
                        }
                    }
                    TapeEdit.SubtotalFooter(resultStr, j, c);
                    Main.VAR.ResetStandardCalculator();
                    if (j < Main.VAR.jLimit - 1) {
                        j++;
                    } else {
                        InformationMessages.TotalLimit();
                    }
                    i = 0;
                    o = 0;
                    logicState = 0;
                    SetAll();
                    Main.GUI.setDisplayText("");
                } else {
                }
                break;
        }
    }

    public static void TotalButton() {
        SubTotalButton();
        GetAll();
        int counter = 0;
        switch (logicState) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                
                resultStr = "0";
                if (o > 0 || j > 0) {
                    for (int b = 0; b < j; b++) {
                        numStr1 = "0";
                        numStr2 = "0";
                        opStr = "+";
                        int firstOp = Operations.FirstOp(b);
                        int lastOp = Operations.LastOp(b);
                        numStr1 = Evaluate.Trim(decimalPlaces, Main.VAR.GetNumbers(firstOp, b, t).toString());
                        if (b == 0) {
                            resultStr = numStr1;
                        } else {
                            numStr1 = Evaluate.Trim(decimalPlaces, Main.VAR.GetNumbers(firstOp, b, t).toString());
                            resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(numStr1, resultStr, opStr.charAt(0)));
                            SetAll();
                            Main.GUI.setDisplayText("");
                        }
                        c = 1;
                        counter++;
                        for (int a = firstOp; a <= lastOp; a++) {
                            op = Main.VAR.GetOpArray(a, b, t);
                            if (op == '+' || op == '-') {
                                numStr2 = Evaluate.Trim(decimalPlaces, Main.VAR.GetNumbers(a + 1, b, t).toString());
                                resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(resultStr, numStr2, op));
                                c++;
                                counter++;
                                SetAll();
                                Main.GUI.setDisplayText("");
                            }
                        }
                    }
                    
                    TapeEdit.TotalFooter(counter, j, resultStr);
                    Main.VAR.ResetStandardCalculator();
                    if (o > 0) {
                        if (j < Main.VAR.jLimit - 1) {
                            j++;
                        } else {
                            InformationMessages.TotalLimit();
                        }
                        i = 0;
                        o = 0;
                        Main.VAR.SetIndex(i, j, o, t);
                        logicState = 0;
                    }
                    SetAll();
                    Main.GUI.setDisplayText("");
                } else {
                }
                break;
        }
    }

    public static void SetTaxPlus() {
        int error = -99;
        double number = -1;
        String option = JOptionPane.showInputDialog(null, "Set Tax+ Rate (%)", Main.CFG.GetTaxPlus());
        if (option != null) {
            try {
                number = Double.parseDouble(option);
                error = 0;
            } catch (NullPointerException nx) {
                error = -99;
            } catch (NumberFormatException e) {
                error = -99;
            }
            if (error == 0 && number >= 0 && number < 100) {
                Main.CFG.SetTaxPlus(option);
            } else {
                ErrorMessages.TaxRateError();
            }
        }
    }

    public static void SetTaxMinus() {
        int error = -99;
        double number = -1;
        String option = JOptionPane.showInputDialog(null, "Set Tax Rate (%)", Main.CFG.GetTaxMinus());
        if (option != null) {
            try {
                number = Double.parseDouble(option);
                error = 0;
            } catch (NullPointerException nx) {
                error = -99;
            } catch (NumberFormatException e) {
                error = -99;
            }
            if (error == 0 && number >= 0 && number < 100) {
                Main.CFG.SetTaxMinus(option);
            } else {
                ErrorMessages.TaxRateError();
            }
        }
    }

    public static void TaxPlusButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                case 3:
                    break;
                case 1:
                    taxPlusStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(taxPlusStr, "100", '/'));
                    resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(Main.VAR.GetNumbers(i, j, t).toString(), taxPlusStr, '*'));
                    op = '+';
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    num2 = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(op, o, j, t);
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    if (o < Main.VAR.oLimit - 1) {
                        o++;
                    } else {
                    }
                    Main.VAR.SetIndex(i, j, o, t);
                    logicState = 4;
                    displayStr = resultStr;
                    SetAll();
                    Main.GUI.DisplayText.setText(displayStr);
                    break;
                case 2:
                case 4:
                    taxPlusStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(taxPlusStr, "100", '/'));
                    resultStr = Evaluate.Evaluate(Main.VAR.GetNumbers(i - 1, j, t).toString(), taxPlusStr, '*');
                    op = '+';
                    num2 = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(op, o, j, t);
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    if (o < Main.VAR.oLimit - 1) {
                        o++;
                    } else {
                    }
                    Main.VAR.SetIndex(i, j, o, t);
                    logicState = 4;
                    displayStr = resultStr;
                    SetAll();
                    Main.GUI.DisplayText.setText(displayStr);
                    break;
            }

        } else {
        }
    }

    public static void TaxMinusButton() {
        GetAll();
        if (opLogic == 0) {
            switch (logicState) {
                case 0:
                case 3:
                    break;
                case 1:
                    taxMinusStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(taxMinusStr, "100", '/'));
                    resultStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(Main.VAR.GetNumbers(i, j, t).toString(), taxMinusStr, '*'));
                    op = '-';
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    num2 = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(op, o, j, t);
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    if (o < Main.VAR.oLimit - 1) {
                        o++;
                    } else {
                    }
                    Main.VAR.SetIndex(i, j, o, t);
                    logicState = 4;
                    displayStr = resultStr;
                    SetAll();
                    Main.GUI.DisplayText.setText(displayStr);
                    break;
                case 2:
                case 4:
                    taxMinusStr = Evaluate.DecimalPlaces(decimalPlaces, Evaluate.Evaluate(taxMinusStr, "100", '/'));
                    resultStr = Evaluate.Evaluate(Main.VAR.GetNumbers(i - 1, j, t).toString(), taxMinusStr, '*');
                    op = '-';
                    num2 = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
                    Main.VAR.SetNumbers(num2, i, j, t);
                    Main.VAR.SetOpArray(op, o, j, t);
                    if (i < Main.VAR.iLimit - 1) {
                        i++;
                    } else {
                        InformationMessages.SubTotalLimit();
                    }
                    if (o < Main.VAR.oLimit - 1) {
                        o++;
                    } else {
                    }
                    Main.VAR.SetIndex(i, j, o, t);
                    logicState = 4;
                    displayStr = resultStr;
                    SetAll();
                    Main.GUI.DisplayText.setText(displayStr);
                    break;
            }

        } else {
        }
    }

    private static void GetAll() {
        t = Main.GUI.getActiveTape();
        numStr1 = Main.VAR.GetNumStr1();
        numStr2 = Main.VAR.GetNumStr2();
        numStr3 = Main.VAR.GetNumStr3();
        taxPlusStr = Main.CFG.GetTaxPlus();
        taxMinusStr = Main.CFG.GetTaxMinus();
        resultStr = Main.VAR.GetResultStr();
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
        Main.VAR.SetOpStr(opStr);
        Main.VAR.SetOpStr2(opStr2);
        Main.VAR.SetDisplayStr(displayStr);
        Main.VAR.SetLogicState(t, logicState);
        Main.VAR.SetNum1(numStr1);
        Main.VAR.SetNum2(numStr2);
        Main.VAR.SetNum3(numStr3);
        Main.VAR.SetResult(resultStr);
        Main.VAR.SetOp(op);
        Main.VAR.SetOp2(op2);
        Main.VAR.SetIndex(i, j, o, t);
    }
}