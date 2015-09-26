/*
 ==============================================================
 == Date:          1/12/2012
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    AlgebraOperations
 == Purpose:       This class contains methods for performing algebraic operations.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;

//Import necessary packages
import java.math.*;

public class AlgebraOperations {

    private static String numStr1, numStr2, numStr3, resultStr, opStr, opStr2,
            displayStr, specialStr;
    private static int logicState, opLogic, decimalPlaces, i, j, o, t, c, number;
    private static BigDecimal num1, num2, num3, result, mem1, mem2, min, max;
    private static char op, op2, oldOp, newOp;

    public static void XYPowerButton() {
        specialStr = "^";
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
            case 7:
                break;
            case 1:
            case 4:
                logicState = 11;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
            case 3:
                logicState = 21;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
            case 6:
                logicState = 31;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
        }
    }

    public static void XYRootButton() {
        specialStr = "^";
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
            case 7:
                break;
            case 1:
            case 4:
                logicState = 41;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
            case 3:
                logicState = 51;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
            case 6:
                logicState = 61;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "^");
                break;
        }
    }

    public static void EXPowerButton() {
        GetAll();
        String e = Main.VAR.GetEStr();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr1 = Evaluate.xyPower(numStr1, e);
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr2 = Evaluate.xyPower(numStr2, e);
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr3 = Evaluate.xyPower(numStr3, e);
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void NaturalLogarithmButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.NaturalLog(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.NaturalLog(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.NaturalLog(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void TenXPowerButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr1 = Evaluate.xyPower(numStr1, "10");
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr2 = Evaluate.xyPower(numStr2, "10");
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Power...");
                numStr3 = Evaluate.xyPower(numStr3, "10");
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void LogarithmButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Log(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Log(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Logarithm...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Log(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void SineButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Sine...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Sine(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Sine...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Sine(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Sine...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Sine(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void CosineButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Cosine...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Cosine(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Cosine...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Cosine(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Cosine...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Cosine(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void TangentButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating Tangent...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Tangent(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating Tangent...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Tangent(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating Tangent...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.Tangent(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    public static void ArcSineButton() {
        min = new BigDecimal("-1", Main.CFG.GetDefaultMath());
        max = new BigDecimal("1", Main.CFG.GetDefaultMath());
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                if ((num1.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcSine...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcSine(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcSine", min.toString(), max.toString());
                }
                break;
            case 3:
                if ((num2.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcSine...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcSine(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcSine", min.toString(), max.toString());
                }
                break;
            case 6:
                if ((num3.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcSine...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcSine(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcSine", min.toString(), max.toString());
                }
                break;
        }
    }

    public static void ArcCosineButton() {
        min = new BigDecimal("-1", Main.CFG.GetDefaultMath());
        max = new BigDecimal("1", Main.CFG.GetDefaultMath());
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                if ((num1.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcCosine...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcCosine(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcCosine", min.toString(), max.toString());
                }
                break;
            case 3:
                if ((num2.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcCosine...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcCosine(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcCosine", min.toString(), max.toString());
                }
                break;
            case 6:
                if ((num3.compareTo(max) <= 0) && (num1.compareTo(min) >= 0)) {
                Main.GUI.setDisplayText("Calculating ArcCosine...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcCosine(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                } else {
                    ErrorMessages.InvalidNumber("ArcCosine", min.toString(), max.toString());
                }
                break;
        }
    }

    public static void ArcTangentButton() {
        GetAll();
        switch (logicState) {
            case 0:
            case 2:
            case 5:
                break;
            case 1:
            case 4:
            case 7:
                Main.GUI.setDisplayText("Calculating ArcTangent...");
                numStr1 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcTangent(numStr1)));
                num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
                logicState = 1;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 3:
                Main.GUI.setDisplayText("Calculating ArcTangent...");
                numStr2 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcTangent(numStr2)));
                num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
                logicState = 3;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
            case 6:
                Main.GUI.setDisplayText("Calculating ArcTangent...");
                numStr3 = Evaluate.DecimalPlaces(decimalPlaces, (Evaluate.ArcTangent(numStr3)));
                num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
                logicState = 6;
                SetAll();
                Operations.SetDisplay(opLogic, logicState, "");
                break;
        }
    }

    private static void GetAll() {
        t = Main.GUI.getActiveTape();
        numStr1 = Main.VAR.GetNumStr1();
        numStr2 = Main.VAR.GetNumStr2();
        numStr3 = Main.VAR.GetNumStr3();
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
