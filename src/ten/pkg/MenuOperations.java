/*
 ==============================================================
 == Date: 7/6/2011 
 == Programmer: Joshua Stacy 
 == Program: Tape_Calculator 
 == Class Name: MenuOperations 
 == Purpose: This class contains methods for Menu Operations
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import required packages
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import javax.swing.*;

public class MenuOperations {

    private static String configFile = Main.filePath + "UserConfigs.cfg";
    private static String savePath = Main.filePath.substring(0, Main.filePath.indexOf("Files"));

    //Method to add tape to display
    public static void NewTape(boolean defaultLogic) {
        int tabs = (Main.VAR.GetTabs());
        int opLogic = Main.GUI.getRBSelection();
        if (defaultLogic) {
            opLogic = Main.CFG.GetDefaultLogic();
        }
        if (tabs < 20) {
            Main.VAR.SetIndex(0, 0, 0, tabs);
            Main.VAR.SetLogicState(tabs, Main.CFG.GetDefaultLogic());
            Main.VAR.InitializeTape(tabs, opLogic);
            Main.GUI.TapeTabs.addTab(Main.VAR.GetFileName(tabs), Main.GUI.ScrollingTapeArray[tabs]);
            Main.GUI.TapeTabs.setSelectedIndex(tabs);
            Main.VAR.SetTabs(tabs + 1);
            Main.VAR.SetTabTitle(tabs, Main.VAR.GetFileName(tabs));
            int logic = Main.VAR.GetOpLogic(tabs);
            if (logic == 0) {
                Main.VAR.SetTapeStr(tabs, TapeEdit.TapeBuffer("Adding Machine Logic") + "\n" + "\n");
            } else if (logic == 1) {
                Main.VAR.SetTapeStr(tabs, TapeEdit.TapeBuffer("Standard Calculator Logic") + "\n" + "\n");
            }
            if (defaultLogic) {
                Main.GUI.SetOpLogic(Main.CFG.GetDefaultLogic(), tabs);
            }
            Main.GUI.setTape(tabs, Main.VAR.GetTapeStr(tabs));
        } else {
            ErrorMessages.MaximumTabs();
        }
    }

    //Method to save active tape to listed file
    public static void SaveTape(int activeTape) throws FileNotFoundException {
        String fullFile = Main.VAR.GetFullFileName(activeTape);
        String WriteStr = Main.VAR.GetTapeStr(activeTape);
        String FileType = Main.VAR.GetFileExtension(activeTape);
        int spaceCount = 0;
        if (FileType.equalsIgnoreCase(".txt") || FileType.equalsIgnoreCase(".rtf")) {
            PrintWriter outFile = new PrintWriter(fullFile);
            int StringLength = WriteStr.length();
            int i = 0;
            char Character;
            while (i < StringLength - 1) {
                Character = WriteStr.charAt(i);
                if (Character == '\n') {
                    outFile.println();
                } else if (Character == '\u0020') {
                    outFile.print(' ');
                } else {
                    outFile.print(Character);
                }
                i += 1;
            }
            outFile.close();
            Main.VAR.SetTapeChanged(activeTape, false);
        } else if (FileType.equalsIgnoreCase(".csv")) {
            PrintWriter outFile = new PrintWriter(fullFile);
            int StringLength = WriteStr.length();
            int i = 0;
            char Character;
            while (i < StringLength - 1) {
                Character = WriteStr.charAt(i);
                if (Character == '\n') {
                    outFile.println();
                } else if (Character == '\u0020') {
                    spaceCount++;
                } else if (Character == '+' || Character == '-' || Character == '*' || Character == '/' || Character == '=') {
                    outFile.print(Character);
                    outFile.print(',');
                    spaceCount = 0;
                } else if (Character == 'A' || Character == 'S') {
                    outFile.print(' ');
                    outFile.print(Character);
                    spaceCount = 0;
                } else {
                    if (spaceCount > 4) {
                        outFile.print(',');
                    }
                    outFile.print(Character);
                    spaceCount = 0;
                }
                i += 1;
            }
            outFile.close();
            Main.VAR.SetTapeChanged(activeTape, false);
        } else {
            ErrorMessages.InvalidFileFormat();
        }
    }
//Method to save active tape to specified file

    public static void SaveAs() {
        int activeTape = Main.GUI.getActiveTape();
        String filePath = Main.CFG.GetDefaultSaveLocation();
        String fileName = Main.VAR.GetFileName(activeTape);
        String fileExtension = Main.CFG.GetDefaultFileType();
        JFileChooser chooser = new JFileChooser(filePath);


        int option = chooser.showSaveDialog(chooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            String fullFile = chooser.getSelectedFile().toString();
            try {
                SetFileNameStr(activeTape, fullFile);
                MenuOperations.SaveTape(activeTape);
                Main.VAR.SetTabTitle(activeTape, Main.VAR.GetFileName(activeTape));
            } catch (FileNotFoundException ex) {
                Main.VAR.SetFilePath(activeTape, filePath);
                Main.VAR.SetFileName(activeTape, fileName);
                Main.VAR.SetFileExtension(activeTape, fileExtension);
                ErrorMessages.FileNotFound(chooser.getSelectedFile().toString());
            }
        } else {
        }
    }

    public static void OpenTape() {
        int activeTape = Main.GUI.getActiveTape();
        boolean tapeChange = Main.VAR.GetTapeChanged(activeTape);
        if (tapeChange) {
            int i = TapeChanged(activeTape);
            if (i != 21) {
                Open(activeTape, 0);
            }
        } else {
            Open(activeTape, 0);
        }
    }

    public static void OpenTapeInTab() {
        int tabs = Main.VAR.GetTabs();
        if (tabs < 20) {
            Open(tabs, 1);
        } else {
            ErrorMessages.MaximumTabs();
        }
    }

    public static void OpenFile(int t, String fullFileName) {
        int i = 0;
        int j, k;
        int x = 0;
        int xx = 0;
        int y = 0;
        int z = 0;
        int I = 0;
        int J = 0;
        int O = 0;
        int decimalPlaces = Main.CFG.GetDecimalPlaces(t);
        int logicState = Main.VAR.GetLogicState(t);
        int opLogic = Main.VAR.GetOpLogic(t);
        int error = 0;
        String line, entry, tape, extension;
        String numStr = "";
        char next = ' ';
        char op = ' ';
        BigDecimal number = BigDecimal.ZERO;
        extension = fullFileName.substring(fullFileName.lastIndexOf("."), fullFileName.length());
        if (extension.equalsIgnoreCase(".txt") || extension.equalsIgnoreCase(".rtf")) {
            try {
                Scanner inFile = new Scanner(new FileReader(fullFileName));
                tape = "";
                line = inFile.nextLine();
                if (line.length() > 0) {
                    line = RemoveSpaces(line);
                }
                tape = TapeEdit.TapeBuffer(line) + "\n";
                if (line.equalsIgnoreCase("Adding Machine Logic")) {
                    opLogic = 0;
                    Main.VAR.SetOpLogic(t, opLogic);
                    error = -99;
                } else if (line.equalsIgnoreCase("Standard Calculator Logic")) {
                    opLogic = 1;
                    Main.VAR.SetOpLogic(t, opLogic);
                    error = -99;
                } else {
                    ErrorMessages.GeneralFileErrorOpen();
                }

                if (error != 0) {
                    Main.GUI.SetOpLogic(opLogic, t);
                    switch (opLogic) {
                        case 0:
                            while (inFile.hasNextLine()) {
                                line = inFile.nextLine();
                                if (line.length() > 0) {
                                    line = RemoveSpaces(line);
                                }
                                line = TapeEdit.TapeBuffer(line) + "\n";
                                tape += line;
                                i++;
                            }
                            tape += "\n";
                            Main.VAR.SetTapeStr(t, tape);
                            Main.VAR.SetTapeChanged(t, false);
                            i++;
                            inFile.close();

                            //Split Tape output into vector
                            Vector<String> lines = new Vector<String>();
                            entry = " ";
                            for (i = 0; i < tape.length(); i++) {
                                next = tape.charAt(i);
                                if (next == ' ') {
                                } else if (next == '\n') {
                                    lines.addElement(entry);
                                    entry = "";
                                } else {
                                    entry += next;
                                }
                            }

                            //Load work
                            for (i = 2; i < lines.size(); i++) {
                                for (j = i; j < lines.size(); j++) {
                                    entry = lines.elementAt(j);
                                    if (entry.equals("")) {
                                        entry = lines.elementAt(j - 1);
                                        if (entry.contains("=")) {
                                            i = j + 1;
                                        } else if (entry.contains("Subtotal")) {
                                            for (k = i; k < (j - 1); k++) {
                                                entry = lines.elementAt(k);
                                                if (k == i) {
                                                    numStr = entry;
                                                    I = 0;
                                                    O = 0;
                                                } else {
                                                    op = entry.charAt(0);
                                                    numStr = entry.substring(1, entry.length());
                                                    if (op == '+' || op == '-' || op == '*' || op == '/') {
                                                        Main.VAR.SetOpArray(op, O, J, t);
                                                        if (O < Main.VAR.oLimit - 1) {
                                                            O++;
                                                        }
                                                        Main.VAR.SetIndex(I, J, O, t);
                                                    } else {
                                                        error = 0;
                                                        k = lines.size();
                                                        j = lines.size();
                                                        i = lines.size();
                                                    }
                                                }
                                                try {
                                                    number = new BigDecimal(Evaluate.Trim(decimalPlaces, numStr), Main.CFG.GetDefaultMath());
                                                    Main.VAR.SetNumbers(number, I, J, t);
                                                    if (O < Main.VAR.iLimit - 1) {
                                                        I++;
                                                    }
                                                    Main.VAR.SetIndex(I, J, O, t);
                                                } catch (Exception e) {
                                                    error = 0;
                                                    k = lines.size();
                                                    j = lines.size();
                                                    i = lines.size();
                                                }
                                            }
                                            if (J < Main.VAR.jLimit - 1) {
                                                J++;
                                                O = 0;
                                                I = 0;
                                                Main.VAR.SetIndex(I, J, O, t);
                                            }
                                        }
                                        i = j + 1;

                                    } else {
                                    }
                                }
                            }
                            if (error == 0) {
                                ErrorMessages.InvalidFileFormat();
                                //Clear Arrays
                                number = BigDecimal.ZERO;
                                for (J = 0; J < Main.VAR.jLimit; J++) {
                                    for (I = 0; I < Main.VAR.iLimit; I++) {
                                        Main.VAR.SetNumbers(number, I, J, t);
                                    }
                                    op = ' ';
                                    for (O = 0; O < Main.VAR.oLimit; O++) {
                                        Main.VAR.SetOpArray(op, O, J, t);
                                    }
                                }
                                I = 0;
                                O = 0;
                                J = 0;
                                Main.VAR.SetIndex(I, J, O, t);
                                logicState = 0;
                                Main.VAR.SetLogicState(t, logicState);
                            } else {
                                if (I == 0) {
                                    logicState = 0;
                                } else if (I == 1) {
                                    logicState = 1;
                                } else if (I == 2) {
                                    if (O == 0) {
                                        logicState = 3;
                                    } else {
                                        logicState = 4;
                                    }
                                } else if (I >= Main.VAR.iLimit) {
                                    if (J < Main.VAR.jLimit - 1) {
                                        I = 0;
                                        O = 0;
                                        Main.VAR.SetIndex(I, J, O, t);
                                    }
                                    logicState = 0;
                                } else {
                                    logicState = 4;
                                }
                                Main.VAR.SetLogicState(t, logicState);
                            }
                            break;
                        case 1:
                            while (inFile.hasNextLine()) {
                                line = inFile.nextLine();
                                line = TapeEdit.TapeBuffer(line) + "\n";
                                tape += line;
                                i++;
                            }
                            tape += "\n";
                            Main.VAR.SetTapeStr(t, tape);
                            Main.VAR.SetTapeChanged(t, false);
                            i++;
                            inFile.close();
                            break;
                    }
                }
            } catch (FileNotFoundException ex) {
                ErrorMessages.FileNotFound(fullFileName);
            }
        } else {
            ErrorMessages.InvalidFileFormat();
        }
    }

    public static void SetFileNameStr(int index, String fullFile) {
        int i = 0;
        int lastSlash = 0;
        char X;
        String subStr1;
        String subStr2;
        String subStr3;
        String subStr4;

        while (i < fullFile.length()) {
            X = fullFile.charAt(i);
            if (X == '\\') {
                lastSlash = i;
            }
            i++;
        }
        subStr1 = fullFile.substring(0, lastSlash + 1);
        subStr2 = fullFile.substring(lastSlash + 1, fullFile.length());
        Main.VAR.SetFilePath(index, subStr1);
        subStr1 = subStr2;
        i = 0;
        lastSlash = subStr1.length();
        while (i < subStr1.length()) {
            X = subStr1.charAt(i);
            if (X == '.') {
                lastSlash = i;
            }
            i++;
        }
        subStr3 = subStr1.substring(0, lastSlash);

        Main.VAR.SetFileName(index, subStr3);
        if (lastSlash < subStr1.length()) {
            subStr4 = subStr1.substring(lastSlash, subStr1.length());
            Main.VAR.SetFileExtension(index, subStr4);
        }
    }

    public static void CloseTape() {
        int activeTape = Main.GUI.getActiveTape();
        int tabs = Main.VAR.GetTabs();
        int I = Main.VAR.GetIndexI(activeTape);
        int J = Main.VAR.GetIndexJ(activeTape);
        int O = Main.VAR.GetIndexO(activeTape);
        int OpLogic = Main.VAR.GetOpLogic(activeTape);
        BigDecimal Number = new BigDecimal(0);
        char op = ' ';
        if (tabs == 1) {
            ErrorMessages.MinimumTabs();
        } else {
            int i = activeTape;
            boolean tapeChange;
            tapeChange = Main.VAR.GetTapeChanged(activeTape);
            if (tapeChange) {
                i = TapeChanged(activeTape);
            }
            if (i != 21) {
                int tab = Main.VAR.GetClosedTabs();
                for (int index = 4; index > 0; index--) {
                    Main.VAR.SetClosedTapeStr(index, Main.VAR.GetClosedTapeStr(index - 1));
                    Main.VAR.SetClosedFilePath(index, Main.VAR.GetClosedFilePath(index - 1));
                    Main.VAR.SetClosedFileName(index, Main.VAR.GetClosedFileName(index - 1));
                    Main.VAR.SetClosedFileExtension(index, Main.VAR.GetClosedFileExtension(index - 1));
                    Main.VAR.SetClosedTapeTabIndex(index, Main.VAR.GetClosedTapeTabIndex(index - 1));
                    Main.VAR.SetClosedTapeChanged(index, Main.VAR.GetClosedTapeChanged(index - 1));
                    Main.VAR.SetClosedIndex(I, J, O, index);
                    Main.VAR.SetClosedOpLogic(index, Main.VAR.GetClosedOpLogic(index - 1));
                    for (int y = 1; y <= J; y++) {
                        for (int x = 0; x <= I; x++) {
                            Main.VAR.SetClosedNumbers(Main.VAR.GetClosedNumbers(x, y, index - 1), x, y, index);
                        }
                        for (int a = 1; a <= O; a++) {
                            Main.VAR.SetClosedOpArray(Main.VAR.GetClosedOpArray(a, y, index - 1), a, y, index);
                        }
                    }
                }
                Main.VAR.SetClosedTapeStr(0, Main.VAR.GetTapeStr(activeTape));
                Main.VAR.SetClosedFilePath(0, Main.VAR.GetFilePath(activeTape));
                Main.VAR.SetClosedFileName(0, Main.VAR.GetFileName(activeTape));
                Main.VAR.SetClosedFileExtension(0, Main.VAR.GetFileExtension(activeTape));
                Main.VAR.SetClosedTapeTabIndex(0, activeTape);
                Main.VAR.SetClosedTapeChanged(0, Main.VAR.GetTapeChanged(activeTape));
                Main.VAR.SetClosedIndex(I, J, O, 0);
                Main.VAR.SetClosedOpLogic(0, OpLogic);

                for (int y = 1; y <= J; y++) {
                    for (int x = 0; x <= I; x++) {
                        Number = Main.VAR.GetClosedNumbers(x, y, 0);
                        Main.VAR.SetClosedNumbers(Number, x, y, 0);
                    }
                    for (int a = 1; a <= O; a++) {
                        op = Main.VAR.GetClosedOpArray(a, y, 0);
                        Main.VAR.SetClosedOpArray(op, a, y, 0);
                    }
                }
                //If Less than 5 tapes have been closed, set next tape to activeTape
                if (tab < 5) {
                    Main.VAR.SetClosedTabs(tab + 1);
                }
                //Main.VAR.InitializeTape(activeTape);
                for (int i1 = activeTape; i1 < (tabs - 1); i1++) {
                    Main.VAR.SetTapeStr(i1, Main.VAR.GetTapeStr(i1 + 1));
                    Main.VAR.SetFilePath(i1, Main.VAR.GetFilePath(i1 + 1));
                    Main.VAR.SetFileName(i1, Main.VAR.GetFileName(i1 + 1));
                    Main.VAR.SetFileExtension(i1, Main.VAR.GetFileExtension(i1 + 1));
                    Main.VAR.SetTabTitle(i1, Main.VAR.GetFileName(i1 + 1));
                    Main.GUI.setTape(i1, Main.VAR.GetTapeStr(i1 + 1));
                    Main.VAR.SetTapeChanged(i1, Main.VAR.GetTapeChanged(i1 + 1));
                    Main.VAR.InitializeTape(i1 + 1, Main.VAR.GetOpLogic(i1 + 1));
                    Main.VAR.SetIndex(Main.VAR.GetIndexI(i1 + 1), Main.VAR.GetIndexJ(i1 + 1), Main.VAR.GetIndexO(i1 + 1), 0);
                    Main.VAR.SetOpLogic(i1, Main.VAR.GetOpLogic(i1 + 1));
                    for (int y = 1; y <= Main.VAR.GetIndexJ(i1 + 1); y++) {
                        for (int x = 0; x <= Main.VAR.GetIndexI(i1 + 1); x++) {
                            Number = Main.VAR.GetNumbers(x, y, i1 + 1);
                            Main.VAR.SetNumbers(Number, x, y, i1);
                        }
                        for (int a = 1; a <= Main.VAR.GetIndexO(i1 + 1); a++) {
                            op = Main.VAR.GetOpArray(a, y, i1 + 1);
                            Main.VAR.SetOpArray(op, a, y, i1);
                        }
                    }
                }
                Main.VAR.InitializeTape(19, Main.CFG.GetDefaultLogic());
                Main.VAR.SetTabs(tab - 1);
                Main.GUI.TapeTabs.removeTabAt(tabs - 1);
                if (activeTape == 0) {
                    Main.GUI.TapeTabs.setSelectedIndex(activeTape);
                    Main.VAR.SetTabs(tabs - 1);
                } else {
                    Main.GUI.TapeTabs.setSelectedIndex(activeTape - 1);
                    Main.VAR.SetTabs(tabs - 1);
                }
            }
        }
        Main.VAR.InitializeTape(tabs - 1, Main.CFG.GetDefaultLogic());
    }

    public static void Close() {
        Main.LIS.SaveLicenseKey();
        try {
            SaveUserConfiguration();
        } catch (java.io.FileNotFoundException aeRef) {
            ErrorMessages.FileNotFound("UserConfiguration.cfg");
        }
        int i;
        int close = 0;
        boolean tapeChange;
        for (i = 0; i < 20; i++) {
            tapeChange = Main.VAR.GetTapeChanged(i);
            if (tapeChange) {
                close = TapeChanged(i);
                if (close == 21) {
                    i = 20;
                }
            }
        }
        if (close != 21) {
            System.exit(0);
        }
    }

    public static int TapeChanged(int activeTape) {
        int option;
        option = JOptionPane.showOptionDialog(null, "File " + "\""
                + Main.VAR.GetFileName(activeTape) + "\"" + " Has Changed!" + "\n" + "Save File?",
                "Save File?", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        switch (option) {
            case JOptionPane.YES_OPTION:
                try {
                    MenuOperations.SaveTape(activeTape);
                } catch (FileNotFoundException ex) {
                    ErrorMessages.FileNotFound(Main.VAR.GetFileName(activeTape).toString());
                }
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CANCEL_OPTION:
                activeTape = 21;
                break;
        }
        return activeTape;
    }

    public static void Open(int activeTape, int newTab) {
        String tapeStr;
        JFileChooser chooser = new JFileChooser(Main.CFG.GetDefaultSaveLocation());
        int option = chooser.showOpenDialog(chooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (newTab == 1) {
                NewTape(false);
            } else {
            }
            String fullFile = chooser.getSelectedFile().toString();
            OpenFile(activeTape, fullFile);
            SetFileNameStr(activeTape, fullFile);
            Main.VAR.SetTabTitle(activeTape, Main.VAR.GetFileName(activeTape));
            tapeStr = Main.VAR.GetTapeStr(activeTape);
            Main.GUI.setTape(activeTape, tapeStr);
        } else {
        }
    }

    public static void SaveUserConfiguration() throws FileNotFoundException {
        try {
            PrintWriter outFile = new PrintWriter(configFile);
            System.out.println("Opening: " + configFile);
            String WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetDefaultLogic()));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetDecimalPlaces(0)));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetDecimalPlaces(1)));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetTaxPlus());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetTaxMinus());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetDefaultSaveLocation());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetDefaultFileType());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetDisplayFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetDisplayFontSize()));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetMemoryFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetMemoryFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetMemoryButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetMemoryFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetEditFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetEditFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetEditButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetEditFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetAccountingFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetAccountingFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetAccountingButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetAccountingFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetFinancialFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetFinancialFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetFinancialButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetFinancialFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetAlgebraFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetAlgebraFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetAlgebraButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetAlgebraFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Main.CFG.GetTrigFontString());
            outFile.println(WriteStr);
            WriteStr = Encryption.encrypt(Integer.toString(Main.CFG.GetTrigFontSize()));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetTrigButtonColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            WriteStr = Main.CFG.GetTrigFontColor().toString();
            WriteStr = Encryption.encrypt(StripString(WriteStr));
            outFile.println(WriteStr);
            outFile.close();
        } catch (Exception e) {
            TestMessages.VoidMessage("Unable to Save User Configuration.");//:" + "\n\n" + e); //File: " + configFile + '\n' + e);
        }
    }

    public static void LoadUserConfiguration() throws FileNotFoundException {
        String line;
        int number, red, green, blue;
        Color color;
        try {
            Scanner inFile = new Scanner(new FileReader(configFile));
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetDefaultLogic(number);
            Main.VAR.SetOpLogic(0, number);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetDecimalPlaces(0, number);
            Main.CFG.SetConfigurationMath(0, number);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetDecimalPlaces(1, number);
            Main.CFG.SetConfigurationMath(1, number);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetTaxPlus(line);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetTaxMinus(line);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetDefaultSaveLocation(line);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetDefaultFileType(line);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetDisplayFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetDisplayFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetMemoryFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetMemoryFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetMemoryButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetMemoryFontColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetEditFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetEditFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetEditButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetEditFontColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetAccountingFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetAccountingFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetAccountingButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetAccountingFontColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetFinancialFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetFinancialFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetFinancialButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetFinancialFontColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetAlgebraFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetAlgebraFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetAlgebraButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetAlgebraFontColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            Main.CFG.SetTrigFontString(line);
            line = Encryption.decrypt(inFile.nextLine());
            number = Integer.parseInt(line);
            Main.CFG.SetTrigFontSize(number);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetTrigButtonColor(color);
            line = Encryption.decrypt(inFile.nextLine());
            red = RedInt(line);
            green = GreenInt(line);
            blue = BlueInt(line);
            color = new java.awt.Color(red, green, blue);
            Main.CFG.SetTrigFontColor(color);
        } catch (FileNotFoundException ex) {
            ErrorMessages.UserPreferencesNotSet();
        } catch (Exception e) {
            LoadDefaultConfiguration();
        }
    }

    public static void LoadDefaultConfiguration() {
        int activeTape = 0;
        Main.CFG.SetDefaultLogic(0);
        Main.VAR.SetOpLogic(activeTape, 0);
        Main.CFG.SetDecimalPlaces(0, 2);
        Main.CFG.SetConfigurationMath(0, 2);
        Main.CFG.SetDecimalPlaces(1, 9);
        Main.CFG.SetConfigurationMath(1, 9);
        Main.CFG.SetTaxPlus("10");
        Main.CFG.SetTaxMinus("10");
        Main.CFG.SetDisplayFontSize(12);
        Main.CFG.SetTapeFontSize(10);
        Main.CFG.SetMemoryFontSize(10);
        Main.CFG.SetEditFontSize(8);
        Main.CFG.SetAccountingFontSize(9);
        Main.CFG.SetFinancialFontSize(11);
        Main.CFG.SetAlgebraFontSize(15);
        Main.CFG.SetTrigFontSize(15);
        Main.CFG.SetDisplayFontString("Monospaced");
        Main.CFG.SetTapeFontString("Monospaced");
        Main.CFG.SetMemoryFontString("Dialog");
        Main.CFG.SetEditFontString("Dialog");
        Main.CFG.SetAccountingFontString("Dialog");
        Main.CFG.SetFinancialFontString("Dialog");
        Main.CFG.SetAlgebraFontString("Dialog");
        Main.CFG.SetTrigFontString("Dialog");
        Main.CFG.SetDefaultSaveLocation(savePath + "SavedData/");
        Main.CFG.SetDefaultFileType(".txt");
        Main.CFG.SetMemoryFontColor(Color.white);
        Color color = new java.awt.Color(102, 0, 204);
        Main.CFG.SetMemoryButtonColor(color);
        Main.CFG.SetEditFontColor(Color.white);
        color = new java.awt.Color(204, 0, 51);
        Main.CFG.SetEditButtonColor(color);
        Main.CFG.SetAccountingFontColor(Color.white);
        color = new java.awt.Color(0, 102, 255);
        Main.CFG.SetAccountingButtonColor(color);
        Main.CFG.SetFinancialFontColor(Color.white);
        color = new java.awt.Color(0, 155, 0);
        Main.CFG.SetFinancialButtonColor(color);
        Main.CFG.SetAlgebraFontColor(Color.white);
        color = new java.awt.Color(0, 102, 255);
        Main.CFG.SetAlgebraButtonColor(color);
        Main.CFG.SetTrigFontColor(Color.black);
        color = new java.awt.Color(0, 255, 255);
        Main.CFG.SetTrigButtonColor(color);
    }

    public static void LoadSmallDefaultConfiguration() {
        int activeTape = 0;
        Main.CFG.SetDefaultLogic(0);
        Main.VAR.SetOpLogic(activeTape, 0);
        Main.CFG.SetDecimalPlaces(0, 2);
        Main.CFG.SetConfigurationMath(0, 2);
        Main.CFG.SetDecimalPlaces(1, 9);
        Main.CFG.SetConfigurationMath(1, 9);
        Main.CFG.SetTaxPlus("10");
        Main.CFG.SetTaxMinus("10");
        Main.CFG.SetDisplayFontSize(10);
        Main.CFG.SetTapeFontSize(6);
        Main.CFG.SetMemoryFontSize(6);
        Main.CFG.SetEditFontSize(6);
        Main.CFG.SetAccountingFontSize(8);
        Main.CFG.SetFinancialFontSize(6);
        Main.CFG.SetAlgebraFontSize(12);
        Main.CFG.SetTrigFontSize(12);
        Main.CFG.SetDisplayFontString("Monospaced");
        Main.CFG.SetTapeFontString("Monospaced");
        Main.CFG.SetMemoryFontString("Dialog");
        Main.CFG.SetEditFontString("Dialog");
        Main.CFG.SetAccountingFontString("Dialog");
        Main.CFG.SetFinancialFontString("Dialog");
        Main.CFG.SetAlgebraFontString("Dialog");
        Main.CFG.SetTrigFontString("Dialog");
        Main.CFG.SetDefaultSaveLocation(savePath + "SavedData/");
        Main.CFG.SetDefaultFileType(".txt");
        Main.CFG.SetMemoryFontColor(Color.white);
        Color color = new java.awt.Color(102, 0, 204);
        Main.CFG.SetMemoryButtonColor(color);
        Main.CFG.SetEditFontColor(Color.white);
        color = new java.awt.Color(204, 0, 51);
        Main.CFG.SetEditButtonColor(color);
        Main.CFG.SetAccountingFontColor(Color.white);
        color = new java.awt.Color(0, 102, 255);
        Main.CFG.SetAccountingButtonColor(color);
        Main.CFG.SetFinancialFontColor(Color.white);
        color = new java.awt.Color(0, 155, 0);
        Main.CFG.SetFinancialButtonColor(color);
        Main.CFG.SetAlgebraFontColor(Color.white);
        color = new java.awt.Color(0, 102, 255);
        Main.CFG.SetAlgebraButtonColor(color);
        Main.CFG.SetTrigFontColor(Color.black);
        color = new java.awt.Color(0, 255, 255);
        Main.CFG.SetTrigButtonColor(color);
    }

    public static String StripString(String inputString) {
        String red = inputString.substring(inputString.indexOf('=') + 1, inputString.indexOf(','));
        String green = inputString.substring(inputString.indexOf('g') + 2, inputString.lastIndexOf(','));
        String blue = inputString.substring(inputString.lastIndexOf('=') + 1, inputString.lastIndexOf(']'));

        String outputString = "(" + red + "," + green + "," + blue + ")";
        return outputString;
    }

    public static int RedInt(String inputString) {
        String red = inputString.substring(inputString.indexOf('(') + 1, inputString.indexOf(','));
        int redInt = Integer.parseInt(red);
        return redInt;
    }

    public static int GreenInt(String inputString) {
        String green = inputString.substring(inputString.indexOf(',') + 1, inputString.lastIndexOf(','));
        int greenInt = Integer.parseInt(green);
        return greenInt;
    }

    public static int BlueInt(String inputString) {
        String blue = inputString.substring(inputString.lastIndexOf(',') + 1, inputString.indexOf(')'));
        int blueInt = Integer.parseInt(blue);
        return blueInt;
    }

    public static String RemoveSpaces(String inputString) {
        String outputString;
        int index = 0;
        char nextChar;

        for (int i = 1; i < inputString.length(); i++) {
            nextChar = inputString.charAt(i);
            if (nextChar != ' ') {
                i = inputString.length() + 1;
            } else {
                index = i;
            }
        }
        outputString = inputString.substring(index + 1, inputString.length());
        return outputString;
    }

    public static String RemoveLeadingSpaces(String inputString) {
        String outputString;
        int index = 0;
        char nextChar;

        for (int i = 1; i < inputString.length(); i++) {
            nextChar = inputString.charAt(i);
            if (nextChar != ' ') {
                i = inputString.length() + 1;
            } else {
                index = i;
            }
        }
        outputString = inputString.substring(index + 1, inputString.length());
        return outputString;
    }
}
