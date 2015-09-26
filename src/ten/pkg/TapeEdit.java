/*
 ==============================================================
 == Date:          1/23/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    TapeEdit
 == Purpose: This class contains methods for editing the scrolling tape.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import javax.swing.*;

public class TapeEdit {
    //Create Variables for operations

    private static String numStr1, numStr2, numStr3, resultStr, opStr, opStr2, tapeStr, newTapeStr;
    private static int size, spaceCount, activeTape;

    public static void TapeSet(int numbers) {
        GetAll();
        switch (numbers) {
            case 2:
                newTapeStr = tapeStr + TapeBuffer(numStr1) + "\n" + TapeBuffer(opStr + "    " + numStr2)
                        + "\n" + TapeBuffer("=    " + resultStr) + "\n" + "\n";
                break;
            case 3:
                newTapeStr = tapeStr + TapeBuffer(numStr1) + "\n" + TapeBuffer(opStr + "    " + numStr2)
                        + "\n" + TapeBuffer(opStr2 + "    " + numStr3) + "\n"
                        + TapeBuffer("=    " + resultStr) + "\n" + "\n";
                break;
        }
        SetAll();
    }

    public static void AddingMachineTapeSet(int i, int j, int o, int t) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(t);
        newTapeStr += TapeBuffer(Main.VAR.GetNumbers(0, j, t).toString()) + "\n";
        Main.VAR.SetTapeStr(t, newTapeStr);
        for (int a = 0; a < i - 1; a++) {
            newTapeStr += TapeBuffer(Main.VAR.GetOpArray(a, j, t) + "    "
                    + Main.VAR.GetNumbers(a + 1, j, t).toString()) + "\n";
            Main.VAR.SetTapeStr(t, newTapeStr);
        }
        newTapeStr += TapeBuffer("=    " + resultStr) + "\n" + "\n";
        SetAll();
    }

    public static void SubtotalHeader(int i, int j, int t) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(t);
        newTapeStr += TapeBuffer(Main.VAR.GetNumbers(i, j, t).toString()) + "\n";
        SetAll();
    }

    public static void SubtotalTapeSet(int i, int j, int o, int t) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(t);
        newTapeStr += TapeBuffer(Main.VAR.GetOpArray(o, j, t) + "    "
                + Main.VAR.GetNumbers(i, j, t).toString()) + "\n";
        SetAll();
    }

    public static void SubtotalFooter(String result, int j, int c) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(activeTape);
        newTapeStr += TapeBuffer("Subtotal " + (j + 1) + " (" + c + " Entries):  " + result)
                + "\n" + "\n";
        SetAll();
    }

    public static void TotalContinue(String number, String opStr) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(activeTape);
        newTapeStr += TapeBuffer(opStr + "    " + number) + "\n";
        SetAll();
    }

    public static void TotalFooter(int c, int j, String result) {
        GetAll();
        newTapeStr = Main.VAR.GetTapeStr(activeTape);
        newTapeStr += TapeBuffer((j) + " Subtotals, " + c + " Entries") + "\n"
                + TapeBuffer("Grand Total:    " + result)
                + "\n" + "\n";
        SetAll();
    }

    public static String TapeBuffer(String inputStr) {
        int charCount = inputStr.length();
        String bufferStr = "";
        GetAll();
        if (size == 4) {
            spaceCount = 31;
        } else {
            spaceCount = 32;
        }
        spaceCount -= charCount;

        while (bufferStr.length() < spaceCount) {
            bufferStr += " ";
        }

        bufferStr += inputStr;
        return bufferStr;
    }

    private static void GetAll() {
        activeTape = Main.GUI.getActiveTape();
        if (activeTape < 0) {
            activeTape = 0;
        }
        size = Main.CFG.GetSize();
        numStr1 = Main.VAR.GetNumStr1();
        numStr2 = Main.VAR.GetNumStr2();
        numStr3 = Main.VAR.GetNumStr3();
        resultStr = Main.VAR.GetResultStr();
        opStr = Main.VAR.GetOpStr();
        opStr2 = Main.VAR.GetOpStr2();
        tapeStr = Main.VAR.GetTapeStr(activeTape);
    }

    private static void SetAll() {
        activeTape = Main.GUI.getActiveTape();
        Main.VAR.SetNumStr1(numStr1);
        Main.VAR.SetNumStr2(numStr2);
        Main.VAR.SetNumStr3(numStr3);
        Main.VAR.SetResultStr(resultStr);
        Main.VAR.SetOpStr(opStr);
        Main.VAR.SetOpStr2(opStr2);
        Main.VAR.SetTapeStr(activeTape, newTapeStr);
        SetTape();
    }

    private static void SetTape() {
        activeTape = Main.GUI.getActiveTape();
        Main.GUI.setTape(activeTape, newTapeStr);
        Main.VAR.SetTapeChanged(activeTape, true);
    }
}
