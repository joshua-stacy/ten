/*
 ==============================================================
 == Date:          6/21/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    Variables
 == Purpose:       This class contains variables for storing,
 ==                evaluating, and accessing numbers.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import java.math.*;
import javax.swing.*;

public class Variables {

    private String NumStr1, NumStr2, NumStr3, ResultStr, PowerStr, RootStr,
            OpStr, OpStr2, DisplayStr;
    private String TapeStr[] = new String[20];
    private String TapeFilePathStr[] = new String[20];
    private String TapeFileNameStr[] = new String[20];
    private String TapeFileExtensionStr[] = new String[20];
    private String ClosedTapeStr[] = new String[5];
    private String ClosedTapeFilePathStr[] = new String[5];
    private String ClosedTapeFileNameStr[] = new String[5];
    private String ClosedTapeFileExtensionStr[] = new String[5];
    private int ClosedTapeTabIndex[] = new int[5];
    private int OpLogic[] = new int[20];
    private int LogicState[] = new int[20];
    private int ClosedOpLogic[] = new int[5];
    private int ClosedLogicState[] = new int[5];
    private int Tabs, ClosedTabs, T;
    private int[] I = new int[20];
    private int[] J = new int[20];
    private int[] O = new int[20];
    private BigDecimal Num1, Num2, Num3, Result, Power, Root, Mem1, Mem2,
            TaxPlus, TaxMinus;
    private BigDecimal E = new BigDecimal("2.71828182845904523536028747135266249775724709369995", Main.CFG.GetDefaultMath());
    private BigDecimal Pi = new BigDecimal("3.14159265358979323846264338327950288419716939937510", Main.CFG.GetDefaultMath());
    private String EStr = E.toString();
    private String PiStr = Pi.toString();
    private BigDecimal[][][] Numbers = new BigDecimal[50][25][20];  //10 rows, 3 columns
    private char[][][] OpArray = new char[49][25][20];
    private BigDecimal[][][] ClosedNumbers = new BigDecimal[50][25][5];
    private char[][][] ClosedOpArray = new char[49][25][5];
    private int[] ClosedI = new int[5];
    private int[] ClosedJ = new int[5];
    private int[] ClosedO = new int[5];
    public int iLimit = 50;
    public int oLimit = 49;
    public int jLimit = 25;
    private char Op, Op2;
    private boolean TapeChanged[] = new boolean[20];
    private boolean ClosedTapeChanged[] = new boolean[5];

    public void Variables() {
        InitializeTape(0, 0);
        Initialize();
    }

    public void Initialize() {
        NumStr1 = "0";
        NumStr2 = "0";
        NumStr3 = "0";
        ResultStr = "0";
        PowerStr = "0";
        RootStr = "0";
        OpStr = "";
        OpStr2 = "";
        Op = ' ';
        Op2 = ' ';
        Tabs = 1;
        ClosedTabs = 0;
        for (int i = 0; i < 20; i++) {
            LogicState[i] = 0;
            OpLogic[i] = Main.CFG.GetDefaultLogic();
        }
        Num1 = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Num2 = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Num3 = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Result = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Power = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Root = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Mem1 = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        Mem2 = new BigDecimal(NumStr1, Main.CFG.GetDefaultMath());
        T = 0;
        TaxPlus = new BigDecimal(.05, Main.CFG.GetDefaultMath());
        TaxMinus = new BigDecimal(.05, Main.CFG.GetDefaultMath());
        TapeChanged[0] = false;
        if (OpLogic[0] == 0) {
            TapeStr[0] = TapeEdit.TapeBuffer("Adding Machine Logic") + "\n" + "\n";
            SetTapeStr(0, TapeStr[0]);
        } else if (OpLogic[0] == 1) {
            TapeStr[0] = TapeEdit.TapeBuffer("Standard Calculator Logic") + "\n" + "\n";
        }
        TapeFilePathStr[0] = Main.CFG.GetDefaultSaveLocation();
        TapeFileNameStr[0] = "Untitled_0";
        TapeFileExtensionStr[0] = Main.CFG.GetDefaultFileType();
        for (int i = 0; i < 20; i++) {
            I[i] = 0;
            J[i] = 0;
            O[i] = 0;
            TapeChanged[i] = false;
            if (OpLogic[0] == 0) {
                TapeStr[0] = TapeEdit.TapeBuffer("Adding Machine Logic") + "\n" + "\n";
                SetTapeStr(0, TapeStr[0]);
            } else if (OpLogic[0] == 1) {
                TapeStr[0] = TapeEdit.TapeBuffer("Standard Calculator Logic") + "\n" + "\n";
            }
            TapeStr[i] = " ";
            TapeFilePathStr[i] = Main.CFG.GetDefaultSaveLocation();
            TapeFileNameStr[i] = "Untitled_" + i;
            TapeFileExtensionStr[i] = Main.CFG.GetDefaultFileType();
        }
        for (int i = 0; i < 5; i++) {
            ClosedTapeChanged[i] = false;
            ClosedTapeStr[i] = " ";
            ClosedTapeFilePathStr[i] = Main.CFG.GetDefaultSaveLocation();
            ClosedTapeFileNameStr[i] = "None";
            ClosedTapeFileExtensionStr[i] = Main.CFG.GetDefaultFileType();
            ClosedOpLogic[i] = 0;
            ClosedLogicState[i] = 0;
            ClosedI[i] = 0;
            ClosedJ[i] = 0;
            ClosedO[i] = 0;
        }
        for (int i = 0; i < iLimit; i++) {
            for (int j = 0; j < jLimit; j++) {
                for (int t = 0; t < 20; t++) {
                    Numbers[i][j][t] = new BigDecimal(0, Main.CFG.GetDefaultMath());
                }
            }
        }
        for (int o = 0; o < oLimit; o++) {
            for (int j = 0; j < jLimit; j++) {
                for (int t = 0; t < 20; t++) {
                    OpArray[o][j][t] = ' ';
                }
            }
        }
        for (int i = 0; i < iLimit; i++) {
            for (int j = 0; j < jLimit; j++) {
                for (int t = 0; t < 5; t++) {
                    ClosedNumbers[i][j][t] = new BigDecimal(0, Main.CFG.GetDefaultMath());
                }
            }
        }
        for (int o = 0; o < oLimit; o++) {
            for (int j = 0; j < jLimit; j++) {
                for (int t = 0; t < 5; t++) {
                    ClosedOpArray[o][j][t] = ' ';
                }
            }
        }
    }

    public void InitializeTape(int Tape, int logic) {
        TapeStr[Tape] = " ";
        TapeChanged[Tape] = false;
        TapeFilePathStr[Tape] = Main.CFG.GetDefaultSaveLocation();
        TapeFileExtensionStr[Tape] = Main.CFG.GetDefaultFileType();
        I[Tape] = 0;
        J[Tape] = 0;
        O[Tape] = 0;
        OpLogic[Tape] = logic;
        for (int b = 0; b > 3; b++) {
            for (int a = 0; a > 9; a++) {
                Numbers[a][b][Tape] = BigDecimal.ZERO;
            }
            for (int x = 0; x > 9; x++) {
                OpArray[b][x][Tape] = ' ';
            }
        }
    }

    public void InitializeClosedTape(int Tape) {
        ClosedTapeStr[Tape] = " ";
        ClosedTapeFilePathStr[Tape] = Main.CFG.GetDefaultSaveLocation();
        ClosedTapeFileNameStr[Tape] = "None";
        ClosedTapeFileExtensionStr[Tape] = Main.CFG.GetDefaultFileType();
        ClosedTapeChanged[Tape] = false;
        ClosedI[Tape] = 0;
        ClosedJ[Tape] = 0;
        ClosedO[Tape] = 0;
        ClosedOpLogic[Tape] = Main.CFG.GetDefaultLogic();
        for (int b = 0; b > 3; b++) {
            for (int a = 0; a > 9; a++) {
                ClosedNumbers[a][b][Tape] = BigDecimal.ZERO;
            }
            for (int x = 0; x > 9; x++) {
                ClosedOpArray[b][x][Tape] = ' ';
            }
        }
    }

    public void ResetStandardCalculator() {
        NumStr1 = "0";
        NumStr2 = "0";
        NumStr3 = "0";
        ResultStr = "0";
        PowerStr = "0";
        RootStr = "0";
        OpStr = "";
        OpStr2 = "";
        Op = ' ';
        Op2 = ' ';
        LogicState[Main.GUI.getActiveTape()] = 0;
        Num1 = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Num2 = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Num3 = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Result = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Power = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Root = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Mem1 = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
        Mem2 = new BigDecimal("0.0", Main.CFG.GetDefaultMath());
    }

    public void ResetAddingMachine() {
    }

    //Getters & Setters
    public BigDecimal GetE() {
        return E;
    }

    public String GetEStr() {
        return EStr;
    }

    public String GetNumStr1() {
        return NumStr1;
    }

    public void SetNumStr1(String inputStr) {
        NumStr1 = inputStr;
    }

    public String GetNumStr2() {
        return NumStr2;
    }

    public void SetNumStr2(String inputStr) {
        NumStr2 = inputStr;
    }

    public String GetNumStr3() {
        return NumStr3;
    }

    public void SetNumStr3(String inputStr) {
        NumStr3 = inputStr;
    }

    public String GetResultStr() {
        return ResultStr;
    }

    public void SetResultStr(String inputStr) {
        ResultStr = inputStr;
    }

    public String GetPowerStr() {
        return PowerStr;
    }

    public void SetPowerStr(String inputStr) {
        PowerStr = inputStr;
    }

    public String GetRootStr() {
        return RootStr;
    }

    public void SetRootStr(String inputStr) {
        RootStr = inputStr;
    }

    public String GetOpStr() {
        return OpStr;
    }

    public void SetOpStr(String inputStr) {
        OpStr = inputStr;
    }

    public String GetOpStr2() {
        return OpStr2;
    }

    public void SetOpStr2(String inputStr) {
        OpStr2 = inputStr;
    }

    public String GetDisplayStr() {
        return DisplayStr;
    }

    public void SetDisplayStr(String inputStr) {
        DisplayStr = inputStr;
    }

    public String GetTapeStr(int ActiveTape) {
        return TapeStr[ActiveTape];
    }

    public void SetTapeStr(int index, String inputStr) {
        TapeStr[index] = inputStr;
    }

    public String GetFilePath(int ActiveTape) {
        return TapeFilePathStr[ActiveTape];
    }

    public void SetFilePath(int index, String inputStr) {
        TapeFilePathStr[index] = inputStr;
    }

    public String GetFileName(int ActiveTape) {
        return TapeFileNameStr[ActiveTape];
    }

    public void SetFileName(int index, String inputStr) {
        TapeFileNameStr[index] = inputStr;
    }

    public String GetFileExtension(int ActiveTape) {
        return TapeFileExtensionStr[ActiveTape];
    }

    public void SetFileExtension(int index, String inputStr) {
        TapeFileExtensionStr[index] = inputStr;
    }

    public String GetFullFileName(int index) {
        String FullFile;
        FullFile = TapeFilePathStr[index] + TapeFileNameStr[index]
                + TapeFileExtensionStr[index];
        return FullFile;
    }

    public String GetClosedFullFileName(int index) {
        String FullFile;
        FullFile = ClosedTapeFilePathStr[index] + ClosedTapeFileNameStr[index]
                + ClosedTapeFileExtensionStr[index];
        return FullFile;
    }

    public String GetClosedTapeStr(int index) {
        return ClosedTapeStr[index];
    }

    public void SetClosedTapeStr(int index, String inputStr) {
        ClosedTapeStr[index] = inputStr;
    }

    public String GetClosedFilePath(int ActiveTape) {
        return ClosedTapeFilePathStr[ActiveTape];
    }

    public void SetClosedFilePath(int index, String inputStr) {
        ClosedTapeFilePathStr[index] = inputStr;
    }

    public String GetClosedFileName(int index) {
        return ClosedTapeFileNameStr[index];
    }

    public void SetClosedFileName(int index, String inputStr) {
        ClosedTapeFileNameStr[index] = inputStr;
    }

    public String GetClosedFileExtension(int index) {
        return ClosedTapeFileExtensionStr[index];
    }

    public void SetClosedFileExtension(int index, String inputStr) {
        ClosedTapeFileExtensionStr[index] = inputStr;
    }

    public int GetClosedTapeTabIndex(int index) {
        return ClosedTapeTabIndex[index];
    }

    public void SetClosedTapeTabIndex(int index, int inputInt) {
        ClosedTapeTabIndex[index] = inputInt;
    }

    public int GetLogicState(int activeTape) {
        return LogicState[activeTape];
    }

    public void SetLogicState(int activeTape, int inputInt) {
        LogicState[activeTape] = inputInt;
    }

    public int GetOpLogic(int activeTape) {
        return OpLogic[activeTape];
    }

    public void SetOpLogic(int activeTape, int inputInt) {
        OpLogic[activeTape] = inputInt;
    }

    public int GetClosedOpLogic(int activeTape) {
        return ClosedOpLogic[activeTape];
    }

    public void SetClosedOpLogic(int activeTape, int inputInt) {
        ClosedOpLogic[activeTape] = inputInt;
    }

    public int GetTabs() {
        return Tabs;
    }

    public void SetTabs(int inputInt) {
        Tabs = inputInt;
    }

    public int GetClosedTabs() {
        return ClosedTabs;
    }

    public void SetClosedTabs(int inputInt) {
        ClosedTabs = inputInt;
    }

    public BigDecimal GetNum1() {
        return Num1;
    }

    public void SetNum1(String inputString) {
        Num1 = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetNum2() {
        return Num2;
    }

    public void SetNum2(String inputString) {
        Num2 = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetNum3() {
        return Num3;
    }

    public void SetNum3(String inputString) {
        Num3 = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetResult() {
        return Result;
    }

    public void SetResult(String inputString) {
        Result = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetPower() {
        return Power;
    }

    public void SetPower(String inputString) {
        Power = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetRoot() {
        return Root;
    }

    public void SetRoot(String inputString) {
        Root = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public void SetNumbers(BigDecimal inputBigDecimal, int i, int j, int t) {
        Numbers[i][j][t] = inputBigDecimal;
    }

    public BigDecimal GetNumbers(int i, int j, int t) {
        return Numbers[i][j][t];
    }

    public void SetClosedNumbers(BigDecimal inputBigDecimal, int i, int j, int t) {
        ClosedNumbers[i][j][t] = inputBigDecimal;
    }

    public BigDecimal GetClosedNumbers(int i, int j, int t) {
        return ClosedNumbers[i][j][t];
    }

    public void SetOpArray(char inputChar, int o, int j, int t) {
        OpArray[o][j][t] = inputChar;
    }

    public char GetOpArray(int o, int j, int t) {
        return OpArray[o][j][t];
    }

    public void SetClosedOpArray(char inputChar, int o, int j, int t) {
        ClosedOpArray[o][j][t] = inputChar;
    }

    public char GetClosedOpArray(int o, int j, int t) {
        return ClosedOpArray[o][j][t];
    }

    public void SetIndex(int inputI, int inputJ, int inputO, int inputT) {
        I[inputT] = inputI;
        J[inputT] = inputJ;
        O[inputT] = inputO;
        T = inputT;
    }

    public void SetClosedIndex(int inputI, int inputJ, int inputO, int inputT) {
        ClosedI[inputT] = inputI;
        ClosedJ[inputT] = inputJ;
        ClosedO[inputT] = inputO;
    }

    public int GetIndexI(int inputT) {
        return I[inputT];
    }

    public int GetIndexJ(int inputT) {
        return J[inputT];
    }

    public int GetIndexO(int inputT) {
        return O[inputT];
    }

    public int GetClosedIndexI(int inputT) {
        return ClosedI[inputT];
    }

    public int GetClosedIndexJ(int inputT) {
        return ClosedJ[inputT];
    }

    public int GetClosedIndexO(int inputT) {
        return ClosedO[inputT];
    }

    public int GetIndexT() {
        return T;
    }

    public BigDecimal GetMem1() {
        return Mem1;
    }

    public void SetMem1(String inputString) {
        Mem1 = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public BigDecimal GetMem2() {
        return Mem2;
    }

    public void SetMem2(String inputString) {
        Mem2 = new BigDecimal(inputString, Main.CFG.GetDefaultMath());
    }

    public char GetOp() {
        return Op;
    }

    public void SetOp(char inputOp) {
        Op = inputOp;
    }

    public char GetOp2() {
        return Op2;
    }

    public void SetOp2(char inputOp) {
        Op2 = inputOp;
    }

    public boolean GetTapeChanged(int activeTape) {
        return TapeChanged[activeTape];
    }

    public void SetTapeChanged(int index, boolean inputBoolean) {
        TapeChanged[index] = inputBoolean;
    }

    public boolean GetClosedTapeChanged(int activeTape) {
        return ClosedTapeChanged[activeTape];
    }

    public void SetClosedTapeChanged(int index, boolean inputBoolean) {
        ClosedTapeChanged[index] = inputBoolean;
    }

    public void SetTabTitle(int index, String fileName) {
        if (fileName.length() > 12) {
            fileName = fileName.substring(0, 8) + "...";
        } else {
            while (fileName.length() < 12) {
                fileName = " " + fileName;
            }
        }
        Main.GUI.TapeTabs.setTitleAt(index, fileName);
    }

    public String FormatTabTitle( String fileName) {
        if (fileName.length() > 12) {
            fileName = fileName.substring(0, 8) + "...";
        } else {
            while (fileName.length() < 12) {
                fileName = " " + fileName;
            }
        }
        return fileName;
    }
}
