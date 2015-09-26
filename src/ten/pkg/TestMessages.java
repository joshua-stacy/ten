/*
 ==============================================================
 == Date:          6/20/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    TestMessages
 == Purpose:       This class contains methods which display 
 ==                informational messages used to test the program.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import java.math.BigDecimal;
import javax.swing.*;

public class TestMessages {
    
    public static void FilePathData() {
        JOptionPane.showMessageDialog(null, "File Path: " + Main.filePath,
                "Open Tabs", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void VoidMessage(String input) {
        JOptionPane.showMessageDialog(null, input, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void TestData() {
        int activeTape = Main.GUI.getActiveTape();
        JOptionPane.showMessageDialog(null, "NumStr1: " + Main.VAR.GetNumStr1()
                + "\n" + "NumStr2: " + Main.VAR.GetNumStr2() + "\n"
                + "NumStr3: " + Main.VAR.GetNumStr3() + "\n"
                + "PowerStr: " + Main.VAR.GetPowerStr() + "\n"
                + "\n" + "OpStr: " + Main.VAR.GetOpStr() + "\n"
                + "OpStr2: " + Main.VAR.GetOpStr2() + "\n" + "\n" //+ "DisplayStr: "
                //+ Main.VAR.GetDisplayStr() + "\n" + "TapeStr: " + "\n"
                //+ Main.VAR.GetTapeStr(activeTape) 
                + "\n" + "OpLogic: " + Main.VAR.GetOpLogic(activeTape)
                + "\n" + "LogicState: "
                + Main.VAR.GetLogicState(activeTape) + "\n" + "Num1: " + Main.VAR.GetNum1()
                + "\n" + "Num2: " + Main.VAR.GetNum2() + "\n" + "Num3: "
                + Main.VAR.GetNum3() + "\n" + "Result: " + Main.VAR.GetResult()
                + "\n" + "Power: " + Main.VAR.GetPower() + "\nMem1: " + Main.VAR.GetMem1() + "\n" + "Mem2: "
                + Main.VAR.GetMem2() + "\n" + "Op: " + Main.VAR.GetOp(), null,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void FileData(int i) {
        int activeTape = Main.GUI.getActiveTape();
        String tapeStr = Main.VAR.GetTapeStr(i);
        String tapeFilePathStr = Main.VAR.GetFilePath(i);
        String tapeFileNameStr = Main.VAR.GetFileName(i);
        String tapeFileExtensionStr = Main.VAR.GetFileExtension(i);
        String tapeFullFileStr = Main.VAR.GetFullFileName(i);
        boolean tapeChanged = Main.VAR.GetTapeChanged(i);
        JOptionPane.showMessageDialog(null, "Tape #: " + activeTape + "\n"
                + "File Path: " + tapeFilePathStr + "\n" + "File Name: "
                + tapeFileNameStr + "\n" + "File Extension: " + tapeFileExtensionStr
                + "\n" + "Full File: " + tapeFullFileStr + "\n" + "Tape Changed: "
                + tapeChanged, null,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void AddingMachineArrayData() {
        int t = Main.VAR.GetIndexT();
        int i = Main.VAR.GetIndexI(t);
        int j = Main.VAR.GetIndexJ(t);
        int o = Main.VAR.GetIndexO(t);
        int logicState = Main.VAR.GetLogicState(t);
        JOptionPane.showMessageDialog(null, "Index I: " + i + "\n" + "Index J: "
                + j + "\n" + "Index O: " + o + "\n" + "Index T: " + t + "\n"
                + "Logic State: " + logicState, "Indexes",
                JOptionPane.INFORMATION_MESSAGE);

        // for (int c = 0; c <= t; c++) {
        for (int b = 0; b < Main.VAR.jLimit; b++) {
            for (int a = 0; a < Main.VAR.iLimit; a++) {
                JOptionPane.showMessageDialog(null, "Number at [" + t + "] [" + b + "] ["
                        + a + "]: " + Main.VAR.GetNumbers(a, b, t).toString(),
                        "Numbers Array", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //}

        //for (int z = 0; z <= t; z++) {
        //for (int y = 0; y < 3; y++) {
        for (int x = 0; x < 9; x++) {
            JOptionPane.showMessageDialog(null, "Operation at [" + t + "] [" + j + "] [" + x + "]: "
                    + Main.VAR.GetOpArray(x, j, t), "Operations Array", JOptionPane.INFORMATION_MESSAGE);
        }
        //}
        //}
    }
    
    public static void TapeLogicData() {
        String message = "";
        int tabs = Main.VAR.GetTabs();
        for (int i = 0; i < tabs; i++) {
            message += "Op Logic of Tape " + i + ": " + Main.VAR.GetOpLogic(i)+ "\n";
        }
        JOptionPane.showMessageDialog(null, message, "Open Tapes",
                JOptionPane.INFORMATION_MESSAGE);
        
        message = "";
        for (int i = 0; i < 20; i++) {
            message += "Op Logic of Tape " + i + ": " + Main.VAR.GetOpLogic(i)+ "\n";
        }
        
        JOptionPane.showMessageDialog(null, message, "All Tapes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void TapeStringData() {
        int activeTape = Main.GUI.getActiveTape();
        for (int i = 0; i <= activeTape + 1; i++) {
            String tapeStr = Main.VAR.GetTapeStr(i);
            JOptionPane.showMessageDialog(null, "Tape String #: " + i + "\n"
                    + tapeStr, null,
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static void TapeArrayData() {
        OpenTabsData();
        FilePathsData();
        FileNamesData();
        FileExtensionsData();
        TapeStringsData();
        TapeChangedData();
    }

    public static void ClosedTapeArrayData() {
        //ClosedTabsData();
        //ClosedFilePathsData();
        //ClosedFileNamesData();
        //ClosedFileExtensionsData();
        //ClosedTapeStringsData();
        //ClosedTapeIndexData();
        //ClosedTapeChangedData();
        ClosedTapeLogicData();
    }

    public static void OpenTabsData() {
        JOptionPane.showMessageDialog(null, "Total Open Tabs: " + Main.VAR.GetTabs(),
                "Open Tabs", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void FilePathsData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetFilePath(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetFilePath(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetFilePath(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetFilePath(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetFilePath(4).toString() + "\n" + "Tape 5: "
                + Main.VAR.GetFilePath(5).toString() + "\n" + "Tape 6: "
                + Main.VAR.GetFilePath(6).toString() + "\n" + "Tape 7: "
                + Main.VAR.GetFilePath(7).toString() + "\n" + "Tape 8: "
                + Main.VAR.GetFilePath(8).toString() + "\n" + "Tape 9: "
                + Main.VAR.GetFilePath(9).toString() + "\n" + "Tape 10: "
                + Main.VAR.GetFilePath(10).toString() + "\n" + "Tape 11: "
                + Main.VAR.GetFilePath(11).toString() + "\n" + "Tape 12: "
                + Main.VAR.GetFilePath(12).toString() + "\n" + "Tape 13: "
                + Main.VAR.GetFilePath(13).toString() + "\n" + "Tape 14: "
                + Main.VAR.GetFilePath(14).toString() + "\n" + "Tape 15: "
                + Main.VAR.GetFilePath(15).toString() + "\n" + "Tape 16: "
                + Main.VAR.GetFilePath(16).toString() + "\n" + "Tape 17: "
                + Main.VAR.GetFilePath(17).toString() + "\n" + "Tape 18: "
                + Main.VAR.GetFilePath(18).toString() + "\n" + "Tape 19: "
                + Main.VAR.GetFilePath(19).toString(), "File Paths",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void FileNamesData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetFileName(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetFileName(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetFileName(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetFileName(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetFileName(4).toString() + "\n" + "Tape 5: "
                + Main.VAR.GetFileName(5).toString() + "\n" + "Tape 6: "
                + Main.VAR.GetFileName(6).toString() + "\n" + "Tape 7: "
                + Main.VAR.GetFileName(7).toString() + "\n" + "Tape 8: "
                + Main.VAR.GetFileName(8).toString() + "\n" + "Tape 9: "
                + Main.VAR.GetFileName(9).toString() + "\n" + "Tape 10: "
                + Main.VAR.GetFileName(10).toString() + "\n" + "Tape 11: "
                + Main.VAR.GetFileName(11).toString() + "\n" + "Tape 12: "
                + Main.VAR.GetFileName(12).toString() + "\n" + "Tape 13: "
                + Main.VAR.GetFileName(13).toString() + "\n" + "Tape 14: "
                + Main.VAR.GetFileName(14).toString() + "\n" + "Tape 15: "
                + Main.VAR.GetFileName(15).toString() + "\n" + "Tape 16: "
                + Main.VAR.GetFileName(16).toString() + "\n" + "Tape 17: "
                + Main.VAR.GetFileName(17).toString() + "\n" + "Tape 18: "
                + Main.VAR.GetFileName(18).toString() + "\n" + "Tape 19: "
                + Main.VAR.GetFileName(19).toString(), "File Names",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void FileExtensionsData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetFileExtension(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetFileExtension(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetFileExtension(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetFileExtension(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetFileExtension(4).toString() + "\n" + "Tape 5: "
                + Main.VAR.GetFileExtension(5).toString() + "\n" + "Tape 6: "
                + Main.VAR.GetFileExtension(6).toString() + "\n" + "Tape 7: "
                + Main.VAR.GetFileExtension(7).toString() + "\n" + "Tape 8: "
                + Main.VAR.GetFileExtension(8).toString() + "\n" + "Tape 9: "
                + Main.VAR.GetFileExtension(9).toString() + "\n" + "Tape 10: "
                + Main.VAR.GetFileExtension(10).toString() + "\n" + "Tape 11: "
                + Main.VAR.GetFileExtension(11).toString() + "\n" + "Tape 12: "
                + Main.VAR.GetFileExtension(12).toString() + "\n" + "Tape 13: "
                + Main.VAR.GetFileExtension(13).toString() + "\n" + "Tape 14: "
                + Main.VAR.GetFileExtension(14).toString() + "\n" + "Tape 15: "
                + Main.VAR.GetFileExtension(15).toString() + "\n" + "Tape 16: "
                + Main.VAR.GetFileExtension(16).toString() + "\n" + "Tape 17: "
                + Main.VAR.GetFileExtension(17).toString() + "\n" + "Tape 18: "
                + Main.VAR.GetFileExtension(18).toString() + "\n" + "Tape 19: "
                + Main.VAR.GetFileExtension(19).toString(), "File Extensions",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void TapeStringsData() {
        for (int i = 0; i < 20; i++) {
            JOptionPane.showMessageDialog(null, "Tape " + i + ": " + "\n\n"
                    + Main.VAR.GetTapeStr(i).toString(), "Tape Strings",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void TapeChangedData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetTapeChanged(0) + "\n" + "Tape 1: "
                + Main.VAR.GetTapeChanged(1) + "\n" + "Tape 2: "
                + Main.VAR.GetTapeChanged(2) + "\n" + "Tape 3: "
                + Main.VAR.GetTapeChanged(3) + "\n" + "Tape 4: "
                + Main.VAR.GetTapeChanged(4) + "\n" + "Tape 5: "
                + Main.VAR.GetTapeChanged(5) + "\n" + "Tape 6: "
                + Main.VAR.GetTapeChanged(6) + "\n" + "Tape 7: "
                + Main.VAR.GetTapeChanged(7) + "\n" + "Tape 8: "
                + Main.VAR.GetTapeChanged(8) + "\n" + "Tape 9: "
                + Main.VAR.GetTapeChanged(9) + "\n" + "Tape 10: "
                + Main.VAR.GetTapeChanged(10) + "\n" + "Tape 11: "
                + Main.VAR.GetTapeChanged(11) + "\n" + "Tape 12: "
                + Main.VAR.GetTapeChanged(12) + "\n" + "Tape 13: "
                + Main.VAR.GetTapeChanged(13) + "\n" + "Tape 14: "
                + Main.VAR.GetTapeChanged(14) + "\n" + "Tape 15: "
                + Main.VAR.GetTapeChanged(15) + "\n" + "Tape 16: "
                + Main.VAR.GetTapeChanged(16) + "\n" + "Tape 17: "
                + Main.VAR.GetTapeChanged(17) + "\n" + "Tape 18: "
                + Main.VAR.GetTapeChanged(18) + "\n" + "Tape 19: "
                + Main.VAR.GetTapeChanged(19), "File Changed Status",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedTapeChangedData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedTapeChanged(0) + "\n" + "Tape 1: "
                + Main.VAR.GetClosedTapeChanged(1) + "\n" + "Tape 2: "
                + Main.VAR.GetClosedTapeChanged(2) + "\n" + "Tape 3: "
                + Main.VAR.GetClosedTapeChanged(3) + "\n" + "Tape 4: "
                + Main.VAR.GetClosedTapeChanged(4), "File Changed Status",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void ClosedTapeLogicData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedOpLogic(0) + "\n" + "Tape 1: "
                + Main.VAR.GetClosedOpLogic(1) + "\n" + "Tape 2: "
                + Main.VAR.GetClosedOpLogic(2) + "\n" + "Tape 3: "
                + Main.VAR.GetClosedOpLogic(3) + "\n" + "Tape 4: "
                + Main.VAR.GetClosedOpLogic(4), "File Changed Status",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedTabsData() {
        JOptionPane.showMessageDialog(null, "Total Closed Tabs: " + Main.VAR.GetClosedTabs(),
                "Closed Tapes", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedFilePathsData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedFilePath(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetClosedFilePath(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetClosedFilePath(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetClosedFilePath(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetClosedFilePath(4).toString(), "Closed File Paths",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedFileNamesData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedFileName(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetClosedFileName(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetClosedFileName(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetClosedFileName(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetClosedFileName(4).toString(), "Closed File Names",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedFileExtensionsData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedFileExtension(0).toString() + "\n" + "Tape 1: "
                + Main.VAR.GetClosedFileExtension(1).toString() + "\n" + "Tape 2: "
                + Main.VAR.GetClosedFileExtension(2).toString() + "\n" + "Tape 3: "
                + Main.VAR.GetClosedFileExtension(3).toString() + "\n" + "Tape 4: "
                + Main.VAR.GetClosedFileExtension(4).toString(), "Closed File Extensions",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void ClosedTapeStringsData() {
        for (int i = 0; i < 5; i++) {
            JOptionPane.showMessageDialog(null, "Tape " + i + ": " + "\n\n"
                    + Main.VAR.GetClosedTapeStr(i).toString(), "Tape Strings",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void ClosedTapeIndexData() {
        JOptionPane.showMessageDialog(null, "Tape O: "
                + Main.VAR.GetClosedTapeTabIndex(0) + "\n" + "Tape 1: "
                + Main.VAR.GetClosedTapeTabIndex(1) + "\n" + "Tape 2: "
                + Main.VAR.GetClosedTapeTabIndex(2) + "\n" + "Tape 3: "
                + Main.VAR.GetClosedTapeTabIndex(3) + "\n" + "Tape 4: "
                + Main.VAR.GetClosedTapeTabIndex(4), "Closed Tape Indices",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowConfigurations() {
        ShowDecimalPlaceConfigurations();
        ShowDisplayWindowConfigurations();
        ShowDefaultLogicConfigurations();
        ShowDefaultFileTypeConfigurations();
        ShowDefaultSaveLocationConfigurations();
        ShowMemoryConfigurations();
        ShowEditConfigurations();
        ShowAccountingConfigurations();
        ShowFinancialConfigurations();
        ShowAlgebraConfigurations();
        ShowTrigConfigurations();
    }

    public static void ShowDecimalPlaceConfigurations() {
        JOptionPane.showMessageDialog(null, "Adding Machine Decimal Places: " + Main.CFG.GetDecimalPlaces(0) + "\n"
                + "Adding Machine Configuration Math: " + Main.CFG.GetConfigurationMath(0) + "\n" + 
                "Standard Calculator Decimal Places: " + Main.CFG.GetConfigurationMath(1) + "\n" +
                "Standard Calculator Configuration Math: " + Main.CFG.GetDecimalPlaces(1),
                "Display Window Configuration", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void ShowDisplayWindowConfigurations() {
        JOptionPane.showMessageDialog(null, "Display Window Font: " + Main.CFG.GetDisplayFontString() + "\n"
                + "Display Font Size: " + Main.CFG.GetDisplayFontSize(),
                "Display Window Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowDefaultLogicConfigurations() {
        JOptionPane.showMessageDialog(null, "Default Logic: " + Main.CFG.GetDefaultLogic(),
                "Default Logic Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowDefaultFileTypeConfigurations() {
        JOptionPane.showMessageDialog(null, "Default File Type: " + Main.CFG.GetDefaultFileType(),
                "Default File Type Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowDefaultSaveLocationConfigurations() {
        JOptionPane.showMessageDialog(null, "Default Save Location: " + Main.CFG.GetDefaultSaveLocation(),
                "Default Save Location", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowMemoryConfigurations() {
        JOptionPane.showMessageDialog(null, "Memory Font: " + Main.CFG.GetMemoryFontString() + "\n"
                + "Memory Font Size: " + Main.CFG.GetMemoryFontSize() + "\n"
                + "Memory Color: " + Main.CFG.GetMemoryButtonColor().toString() + "\n"
                + "Memory Font Color: " + Main.CFG.GetMemoryFontColor(),
                "Memory Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowEditConfigurations() {
        JOptionPane.showMessageDialog(null, "Edit Font: " + Main.CFG.GetEditFontString() + "\n"
                + "Edit Font Size: " + Main.CFG.GetEditFontSize() + "\n"
                + "Edit Color: " + Main.CFG.GetEditButtonColor().toString() + "\n"
                + "Edit Font Color: " + Main.CFG.GetEditFontColor(),
                "Edit Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowAccountingConfigurations() {
        JOptionPane.showMessageDialog(null, "Accounting Font: " + Main.CFG.GetAccountingFontString() + "\n"
                + "Accounting Font Size: " + Main.CFG.GetAccountingFontSize() + "\n"
                + "Accounting Color: " + Main.CFG.GetAccountingButtonColor().toString() + "\n"
                + "Accounting Font Color: " + Main.CFG.GetAccountingFontColor(),
                "Accounting Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowFinancialConfigurations() {
        JOptionPane.showMessageDialog(null, "Financial Font: " + Main.CFG.GetFinancialFontString() + "\n"
                + "Financial Font Size: " + Main.CFG.GetFinancialFontSize() + "\n"
                + "Financial Color: " + Main.CFG.GetFinancialButtonColor().toString() + "\n"
                + "Financial Font Color: " + Main.CFG.GetFinancialFontColor(),
                "Financial Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowAlgebraConfigurations() {
        JOptionPane.showMessageDialog(null, "Algebra Font: " + Main.CFG.GetAlgebraFontString() + "\n"
                + "Algebra Font Size: " + Main.CFG.GetAlgebraFontSize() + "\n"
                + "Algebra Color: " + Main.CFG.GetAlgebraButtonColor().toString() + "\n"
                + "Algebra Font Color: " + Main.CFG.GetAlgebraFontColor(),
                "Algebra Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowTrigConfigurations() {
        JOptionPane.showMessageDialog(null, "Trigonometry Font: " + Main.CFG.GetTrigFontString() + "\n"
                + "Trigonometry Font Size: " + Main.CFG.GetTrigFontSize() + "\n"
                + "Trigonometry Color: " + Main.CFG.GetTrigButtonColor().toString() + "\n"
                + "Trigonometry Font Color: " + Main.CFG.GetTrigFontColor(),
                "Trigonometry Configuration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void PowerData(BigDecimal power, BigDecimal number) {
        int activeTape = Main.GUI.getActiveTape();
        JOptionPane.showMessageDialog(null, "Power Evaluation\n\n"
                + "Number: " + number.toString() + "\n"
                + "Power: " + power.toString(), null,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void RootData(BigDecimal root, BigDecimal number) {
        int activeTape = Main.GUI.getActiveTape();
        JOptionPane.showMessageDialog(null, "Root Evaluation\n\n"
                + "Number: " + number.toString() + "\n"
                + "Root: " + root.toString(), null,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void LogData(BigDecimal log, BigDecimal number) {
        int activeTape = Main.GUI.getActiveTape();
        JOptionPane.showMessageDialog(null, "Log Evaluation\n\n"
                + "Number: " + number.toString() + "\n"
                + "Log: " + log.toString(), null,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
