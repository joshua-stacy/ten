/*
 ==============================================================
 == Date:          8/01/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    Configuration
 ==  Purpose:       This class contains variables and methods for
 ==                getting and setting configuration values.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import java.math.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Configuration {

    private int DefaultLogic, Padding, UserScreenHeight;
    private int[] DecimalPlaces = new int[2];
    private MathContext DefaultMath = new MathContext(50, RoundingMode.HALF_UP);
    private MathContext[] ConfigurationMath = {new MathContext(16, RoundingMode.HALF_UP), new MathContext(16, RoundingMode.HALF_UP)};
    private int DisplayFontSize, TapeFontSize, MemoryFontSize, EditFontSize,
            AccountingFontSize, FinancialFontSize, AlgebraFontSize, TrigFontSize;
    private String DisplayFontString, TapeFontString, MemoryFontString, EditFontString,
            AccountingFontString, FinancialFontString, AlgebraFontString, TrigFontString,
            DefaultSaveLocation, DefaultFileType, TaxPlusString, TaxMinusString;
    private Color MemoryFontColor, MemoryButtonColor, EditFontColor, EditButtonColor,
            AccountingFontColor, AccountingButtonColor, FinancialFontColor, FinancialButtonColor,
            AlgebraFontColor, AlgebraButtonColor, TrigFontColor, TrigButtonColor;

    public void Configuration() {
        Initialize();
    }

    public void Initialize() {
        String savePath = Main.filePath.substring(0, Main.filePath.indexOf("Files"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        UserScreenHeight = (int) screenSize.getHeight();
        if (UserScreenHeight < 750) {
            Padding = 4;
            Main.CFG.SetDefaultFileType(".txt");
            Main.CFG.SetDefaultSaveLocation(savePath + "SavedData/");
            MenuOperations.LoadSmallDefaultConfiguration();

        } else {
            Padding = 5;
            Main.CFG.SetDefaultFileType(".txt");
            Main.CFG.SetDefaultSaveLocation(savePath + "CrumbCake/SavedData/");
            MenuOperations.LoadDefaultConfiguration();
        }
        try {
            MenuOperations.LoadUserConfiguration();
        } catch (Exception e) {
        }
    }

    public int GetSize() {
        return Padding;
    }

    public void SetSize(int inputInt) {
        Padding = inputInt;
    }

    public int GetDecimalPlaces(int index) {
        return DecimalPlaces[index];
    }

    public void SetDecimalPlaces(int index, int inputInt) {
        DecimalPlaces[index] = inputInt;
    }

    public String GetTaxPlus() {
        return TaxPlusString;
    }

    public void SetTaxPlus(String inputString) {
        TaxPlusString = inputString;
    }

    public String GetTaxMinus() {
        return TaxMinusString;
    }

    public void SetTaxMinus(String inputString) {
        TaxMinusString = inputString;
    }

    public int GetDefaultLogic() {
        return DefaultLogic;
    }

    public void SetDefaultLogic(int inputInt) {
        DefaultLogic = inputInt;
    }

    public MathContext GetDefaultMath() {
        return DefaultMath;
    }

    public void SetDefaultMath(int inputInt) {
        DefaultMath = new MathContext(inputInt, RoundingMode.HALF_UP);
    }

    public MathContext GetConfigurationMath(int index) {
        return ConfigurationMath[index];
    }

    public void SetConfigurationMath(int index, int inputInt) {
        ConfigurationMath[index] = new MathContext(inputInt, RoundingMode.HALF_UP);
    }

    public int GetDisplayFontSize() {
        return DisplayFontSize;
    }

    public void SetDisplayFontSize(int inputInt) {
        DisplayFontSize = inputInt;
    }

    public int GetTapeFontSize() {
        return TapeFontSize;
    }

    public void SetTapeFontSize(int inputInt) {
        TapeFontSize = inputInt;
    }

    public int GetMemoryFontSize() {
        return MemoryFontSize;
    }

    public void SetMemoryFontSize(int inputInt) {
        MemoryFontSize = inputInt;
    }

    public int GetEditFontSize() {
        return EditFontSize;
    }

    public void SetEditFontSize(int inputInt) {
        EditFontSize = inputInt;
    }

    public int GetAccountingFontSize() {
        return AccountingFontSize;
    }

    public void SetAccountingFontSize(int inputInt) {
        AccountingFontSize = inputInt;
    }

    public int GetFinancialFontSize() {
        return FinancialFontSize;
    }

    public void SetFinancialFontSize(int inputInt) {
        FinancialFontSize = inputInt;
    }

    public int GetAlgebraFontSize() {
        return AlgebraFontSize;
    }

    public void SetAlgebraFontSize(int inputInt) {
        AlgebraFontSize = inputInt;
    }

    public int GetTrigFontSize() {
        return TrigFontSize;
    }

    public void SetTrigFontSize(int inputInt) {
        TrigFontSize = inputInt;
    }

    public String GetDisplayFontString() {
        return DisplayFontString;
    }

    public void SetDisplayFontString(String inputString) {
        DisplayFontString = inputString;
    }

    public String GetTapeFontString() {
        return TapeFontString;
    }

    public void SetTapeFontString(String inputString) {
        TapeFontString = inputString;
    }

    public String GetMemoryFontString() {
        return MemoryFontString;
    }

    public void SetMemoryFontString(String inputString) {
        MemoryFontString = inputString;
    }

    public String GetEditFontString() {
        return EditFontString;
    }

    public void SetEditFontString(String inputString) {
        EditFontString = inputString;
    }

    public String GetAccountingFontString() {
        return AccountingFontString;
    }

    public void SetAccountingFontString(String inputString) {
        AccountingFontString = inputString;
    }

    public String GetFinancialFontString() {
        return FinancialFontString;
    }

    public void SetFinancialFontString(String inputString) {
        FinancialFontString = inputString;
    }

    public String GetAlgebraFontString() {
        return AlgebraFontString;
    }

    public void SetAlgebraFontString(String inputString) {
        AlgebraFontString = inputString;
    }

    public String GetTrigFontString() {
        return TrigFontString;
    }

    public void SetTrigFontString(String inputString) {
        TrigFontString = inputString;
    }

    public String GetDefaultSaveLocation() {
        return DefaultSaveLocation;
    }

    public void SetDefaultSaveLocation() {

        JFileChooser chooser = new JFileChooser(DefaultSaveLocation);
        chooser.setCurrentDirectory(new java.io.File(DefaultSaveLocation));
        chooser.setDialogTitle("Default Save Location");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            switch (Main.OS.GetOS()) {
                case 0:
                    DefaultSaveLocation = chooser.getSelectedFile().toString() + "\\";
                    break;
                case 1:
                case 2:
                    DefaultSaveLocation = chooser.getSelectedFile().toString() + "/";
            }
        } else {
            System.out.println("No Selection ");
        }
    }

    public void SetDefaultSaveLocation(String inputString) {
        DefaultSaveLocation = inputString;
    }

    public String GetDefaultFileType() {
        return DefaultFileType;
    }

    public void SetDefaultFileType(String inputString) {
        DefaultFileType = inputString;
    }

    public Color GetMemoryFontColor() {
        return MemoryFontColor;
    }

    public void SetMemoryFontColor(Color inputColor) {
        MemoryFontColor = inputColor;
    }

    public Color GetMemoryButtonColor() {
        return MemoryButtonColor;
    }

    public void SetMemoryButtonColor(Color inputColor) {
        MemoryButtonColor = inputColor;
    }

    public Color GetEditFontColor() {
        return EditFontColor;
    }

    public void SetEditFontColor(Color inputColor) {
        EditFontColor = inputColor;
    }

    public Color GetEditButtonColor() {
        return EditButtonColor;
    }

    public void SetEditButtonColor(Color inputColor) {
        EditButtonColor = inputColor;
    }

    public Color GetAccountingFontColor() {
        return AccountingFontColor;
    }

    public void SetAccountingFontColor(Color inputColor) {
        AccountingFontColor = inputColor;
    }

    public Color GetAccountingButtonColor() {
        return AccountingButtonColor;
    }

    public void SetAccountingButtonColor(Color inputColor) {
        AccountingButtonColor = inputColor;
    }

    public Color GetFinancialFontColor() {
        return FinancialFontColor;
    }

    public void SetFinancialFontColor(Color inputColor) {
        FinancialFontColor = inputColor;
    }

    public Color GetFinancialButtonColor() {
        return FinancialButtonColor;
    }

    public void SetFinancialButtonColor(Color inputColor) {
        FinancialButtonColor = inputColor;
    }

    public Color GetAlgebraFontColor() {
        return AlgebraFontColor;
    }

    public void SetAlgebraFontColor(Color inputColor) {
        AlgebraFontColor = inputColor;
    }

    public Color GetAlgebraButtonColor() {
        return AlgebraButtonColor;
    }

    public void SetAlgebraButtonColor(Color inputColor) {
        AlgebraButtonColor = inputColor;
    }

    public Color GetTrigFontColor() {
        return TrigFontColor;
    }

    public void SetTrigFontColor(Color inputColor) {
        TrigFontColor = inputColor;
    }

    public Color GetTrigButtonColor() {
        return TrigButtonColor;
    }

    public void SetTrigButtonColor(Color inputColor) {
        TrigButtonColor = inputColor;
    }
}
