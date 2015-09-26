/*
 ==============================================================
 == Date:          8/13/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    ConfigurationGUI
 == Purpose:       This class contains methods for configuring the Main GUI.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfigurationGUI extends JFrame implements ActionListener {

    private int memoryFontSize, editFontSize, accountingFontSize,
            financialFontSize, algebraFontSize, trigFontSize,
            AMDecimalInt, CalcDecimalInt, placeHolderPlus, placeHolderMinus;
    private String displayFontString, memoryFontString, editFontString,
            accountingFontString, financialFontString, algebraFontString,
            trigFontString, defaultFileTypeString, AMDecimalString, CalcDecimalString,
            taxPlusString, taxMinusString;
    private Color memoryFontColor, memoryButtonColor, editFontColor, editButtonColor,
            accountingFontColor, accountingButtonColor, financialFontColor, financialButtonColor,
            algebraFontColor, algebraButtonColor, trigFontColor, trigButtonColor;
    private Integer x, y, MainWidth, MainHeight, ButtonWidth, ButtonHeight,
            SetButtonWidth, SetButtonHeight, ListWidth, ListHeight, LabelWidth,
            LabelHeight, TabWidth, TabHeight, Padding;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton OKButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JButton ResetButton = new JButton("Reset");
    private JButton SaveLocationSetButton = new JButton("Save Location");
    private JButton MemoryFontColorSetButton = new JButton("Font Color");
    private JButton EditFontColorSetButton = new JButton("Font Color");
    private JButton AccountingFontColorSetButton = new JButton("Font Color");
    private JButton FinancialFontColorSetButton = new JButton("Font Color");
    private JButton AlgebraFontColorSetButton = new JButton("Font Color");
    private JButton TrigFontColorSetButton = new JButton("Font Color");
    private JButton MemoryButtonColorSetButton = new JButton("Button Color");
    private JButton EditButtonColorSetButton = new JButton("Button Color");
    private JButton AccountingButtonColorSetButton = new JButton("Button Color");
    private JButton FinancialButtonColorSetButton = new JButton("Button Color");
    private JButton AlgebraButtonColorSetButton = new JButton("Button Color");
    private JButton TrigButtonColorSetButton = new JButton("Button Color");
    private JLabel DisplayLabel = new JLabel("                 Display Window Font");
    private JLabel DefaultLogicLabel = new JLabel("             Default Operation Logic");
    private JLabel MemoryFontLabel = new JLabel("Font");
    private JLabel EditFontLabel = new JLabel("Font");
    private JLabel AccountingFontLabel = new JLabel("Font");
    private JLabel FinancialFontLabel = new JLabel("Font");
    private JLabel AlgebraFontLabel = new JLabel("Font");
    private JLabel TrigFontLabel = new JLabel("Font");
    private JLabel MemoryFontSizeLabel = new JLabel("Font Size");
    private JLabel EditFontSizeLabel = new JLabel("Font Size");
    private JLabel AccountingFontSizeLabel = new JLabel("Font Size");
    private JLabel FinancialFontSizeLabel = new JLabel("Font Size");
    private JLabel AlgebraFontSizeLabel = new JLabel("Font Size");
    private JLabel TrigFontSizeLabel = new JLabel("Font Size");
    private JLabel MemoryFontColorLabel = new JLabel("Font Color");
    private JLabel EditFontColorLabel = new JLabel("Font Color");
    private JLabel AccountingFontColorLabel = new JLabel("Font Color");
    private JLabel FinancialFontColorLabel = new JLabel("Font Color");
    private JLabel AlgebraFontColorLabel = new JLabel("Font Color");
    private JLabel TrigFontColorLabel = new JLabel("Font Color");
    private JLabel MemoryButtonColorLabel = new JLabel("Button Color");
    private JLabel EditButtonColorLabel = new JLabel("Button Color");
    private JLabel AccountingButtonColorLabel = new JLabel("Button Color");
    private JLabel FinancialButtonColorLabel = new JLabel("Button Color");
    private JLabel AlgebraButtonColorLabel = new JLabel("Button Color");
    private JLabel TrigButtonColorLabel = new JLabel("Button Color");
    private JLabel ButtonsLabel = new JLabel("Buttons");
    private JLabel SaveLocationLabel = new JLabel("               Default Save Location");
    private JLabel FileTypeLabel = new JLabel("                   Default File Type");
    private JLabel AddingMachineDecimalPlacesLabel = new JLabel("Decimal Places (Adding Machine Logic)");
    private JLabel StandardCalculatorDecimalPlacesLabel = new JLabel("                       Decimal Places");
    private JLabel TaxPlusLabel = new JLabel("                            Tax + (%)");
    private JLabel TaxMinusLabel = new JLabel("                            Tax - (%)");
    private JTextField AMDecimalText = new JTextField();
    private JTextField CalcDecimalText = new JTextField();
    private JTextField TaxPlusText = new JTextField();
    private JTextField TaxMinusText = new JTextField();
    private JComboBox DisplayFontList = new JComboBox();
    private JComboBox DefaultLogicList = new JComboBox();
    private JComboBox DefaultFileTypeList = new JComboBox();
    private JComboBox FontList = new JComboBox();
    private JComboBox MemoryFontList = new JComboBox();
    private JComboBox EditFontList = new JComboBox();
    private JComboBox AccountingFontList = new JComboBox();
    private JComboBox FinancialFontList = new JComboBox();
    private JComboBox AlgebraFontList = new JComboBox();
    private JComboBox TrigFontList = new JComboBox();
    private JComboBox ButtonFontSizeList = new JComboBox();
    private JComboBox MemoryButtonFontSizeList = new JComboBox();
    private JComboBox EditButtonFontSizeList = new JComboBox();
    private JComboBox AccountingButtonFontSizeList = new JComboBox();
    private JComboBox FinancialButtonFontSizeList = new JComboBox();
    private JComboBox AlgebraButtonFontSizeList = new JComboBox();
    private JComboBox TrigButtonFontSizeList = new JComboBox();
    private Font SetButtonFont;
    private Font SmallSetButtonFont = new Font("Dialog", Font.BOLD, 6);
    private Font LargeSetButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font ButtonFont;
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font LargeButtonFont = new Font("Dialog", Font.BOLD, 10);
    private Font TabFont;
    private Font SmallTabFont = new Font("Dialog", Font.BOLD, 7);
    private Font LargeTabFont = new Font("Dialog", Font.BOLD, 10);
    private Font LabelFont;
    private Font LargeLabelFont = new Font("Monospaced", Font.BOLD, 10);
    private Font SmallLabelFont = new Font("Monospaced", Font.BOLD, 9);
    private JTabbedPane tabs = new JTabbedPane();
    //Create Panels for Tabbed Pane
    private JPanel MemoryPanel = new JPanel();
    private JPanel EditPanel = new JPanel();
    private JPanel AccountingPanel = new JPanel();
    private JPanel FinancialPanel = new JPanel();
    private JPanel AlgebraPanel = new JPanel();
    private JPanel TrigPanel = new JPanel();
    //Add Items to Lists
    private String[] fontList = {"Bitstream Vera Sans Mono", "Courier New",
        "Crystal", "Dialog", "GulimChe", "Lucida Sans Typewriter", "Monospaced",
        "MS Gothic"};
    private int[] buttonFontSizeList = new int[6];
    private int[] specialButtonFontSizeList = new int[9];

    public ConfigurationGUI() {

        Container configurationPane = getContentPane();
        setTitle("Edit Preferences");
        Padding = Main.GUI.getPadding();
        if (Padding == 4) {
            LabelFont = SmallLabelFont;
            SetButtonFont = SmallSetButtonFont;
            ButtonFont = SmallButtonFont;
            TabFont = SmallTabFont;
        } else {
            LabelFont = LargeLabelFont;
            SetButtonFont = LargeSetButtonFont;
            ButtonFont = LargeButtonFont;
            TabFont = LargeTabFont;
        }
        ListHeight = Padding * 4;
        ListWidth = Padding * 42;
        ButtonHeight = Padding * 6;
        ButtonWidth = Padding * 15;
        SetButtonHeight = Padding * 5;
        SetButtonWidth = Padding * 20;
        LabelHeight = Padding * 3;
        LabelWidth = Padding * 48;
        TabHeight = Padding * 33;
        TabWidth = ListWidth + LabelWidth + Padding * 3;
        MainHeight = Padding * 70;
        MainWidth = LabelWidth + ListWidth + TabWidth + Padding * 11;
        setSize(MainWidth, MainHeight);
        GetAll();


        if (Padding == 4) {
            specialButtonFontSizeList[0] = 4;
            specialButtonFontSizeList[1] = 5;
            specialButtonFontSizeList[2] = 6;
            specialButtonFontSizeList[3] = 7;
            specialButtonFontSizeList[4] = 8;
            specialButtonFontSizeList[5] = 9;
            specialButtonFontSizeList[6] = 10;
            specialButtonFontSizeList[7] = 11;
            specialButtonFontSizeList[8] = 12;
        } else {
            specialButtonFontSizeList[0] = 7;
            specialButtonFontSizeList[1] = 8;
            specialButtonFontSizeList[2] = 9;
            specialButtonFontSizeList[3] = 10;
            specialButtonFontSizeList[4] = 11;
            specialButtonFontSizeList[5] = 12;
            specialButtonFontSizeList[6] = 13;
            specialButtonFontSizeList[7] = 14;
            specialButtonFontSizeList[8] = 15;
        }

        for (int i = 0; i < fontList.length; i++) {
            DisplayFontList.addItem(fontList[i]);
            FontList.addItem(fontList[i]);
            MemoryFontList.addItem(fontList[i]);
            EditFontList.addItem(fontList[i]);
            AccountingFontList.addItem(fontList[i]);
            FinancialFontList.addItem(fontList[i]);
            AlgebraFontList.addItem(fontList[i]);
            TrigFontList.addItem(fontList[i]);
        }

        for (int i = 0; i < buttonFontSizeList.length; i++) {
            ButtonFontSizeList.addItem(fontList[i]);
        }
        if (Main.CFG.GetSize() == 5) {
            for (int i = 0; i < 3; i++) {
                MemoryButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                EditButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AccountingButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 3; i < 5; i++) {
                MemoryButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AccountingButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 5; i < 6; i++) {
                MemoryButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 6; i < specialButtonFontSizeList.length; i++) {
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                MemoryButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                EditButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AccountingButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 3; i < 5; i++) {
                AccountingButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 5; i < 6; i++) {
                FinancialButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }

            for (int i = 6; i < specialButtonFontSizeList.length; i++) {
                AlgebraButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
                TrigButtonFontSizeList.addItem(specialButtonFontSizeList[i]);
            }
        }

        configurationPane.setLayout(null);

        //Set window to open center of screen
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        x = Padding;
        y = Padding * 3;
        DisplayLabel.setSize(LabelWidth, LabelHeight);
        DisplayLabel.setFont(LabelFont);
        DisplayLabel.setLocation(x, y);
        configurationPane.add(DisplayLabel);

        x += LabelWidth;

        DisplayFontList.setSize(ListWidth, ListHeight);
        DisplayFontList.setLocation(x, y);
        configurationPane.add(DisplayFontList);

        switch (Main.LIS.GetLicenseType()) {
            case 0:
            case 66:
                break;
            case 33:
            case 99:
                x = Padding;
                y += ListHeight + Padding * 2;

                DefaultLogicLabel.setSize(LabelWidth, LabelHeight);
                DefaultLogicLabel.setFont(LabelFont);
                DefaultLogicLabel.setLocation(x, y);
                configurationPane.add(DefaultLogicLabel);

                x += LabelWidth;

                DefaultLogicList.addItem("Adding Machine Logic");
                DefaultLogicList.addItem("Standard Calculator Logic");

                DefaultLogicList.setSize(ListWidth, ListHeight);
                DefaultLogicList.setLocation(x, y);
                configurationPane.add(DefaultLogicList);
                break;
        }
        //Add Default File Type Controls
        x = Padding;
        y += ListHeight + Padding * 2;

        FileTypeLabel.setSize(LabelWidth, LabelHeight);
        FileTypeLabel.setFont(LabelFont);
        FileTypeLabel.setLocation(x, y);
        configurationPane.add(FileTypeLabel);

        x += LabelWidth;

        DefaultFileTypeList.addItem("Text File");
        DefaultFileTypeList.addItem("Rich Text Format");
        DefaultFileTypeList.addItem("Excel Spreadsheet");


        DefaultFileTypeList.setSize(ListWidth, ListHeight);
        DefaultFileTypeList.setLocation(x, y);
        configurationPane.add(DefaultFileTypeList);

        //Add Default Save Location Controls
        x = Padding;
        y += ListHeight + Padding * 4;

        SaveLocationLabel.setSize(LabelWidth, LabelHeight);
        SaveLocationLabel.setFont(LabelFont);
        SaveLocationLabel.setLocation(x, y);
        configurationPane.add(SaveLocationLabel);

        x += LabelWidth;
        y -= Padding;

        SaveLocationSetButton.setSize(SetButtonWidth, SetButtonHeight);
        SaveLocationSetButton.setFont(SetButtonFont);
        SaveLocationSetButton.setLocation(x, y);
        SaveLocationSetButton.addActionListener(this);
        configurationPane.add(SaveLocationSetButton);

        x = Padding;
        y += ListHeight + Padding * 4;


        AddingMachineDecimalPlacesLabel.setSize(LabelWidth, LabelHeight);
        AddingMachineDecimalPlacesLabel.setFont(LabelFont);
        AddingMachineDecimalPlacesLabel.setLocation(x, y);
        switch (Main.LIS.GetLicenseType()) {
            case 0:
            case 66:
                AddingMachineDecimalPlacesLabel.setText("                       Decimal Places");
                break;
            case 33:
            case 99:
                break;
        }
        configurationPane.add(AddingMachineDecimalPlacesLabel);
        
        x += LabelWidth;

        AMDecimalText.setSize(ListWidth, ListHeight);
        AMDecimalText.setLocation(x, y);
        configurationPane.add(AMDecimalText);

        switch (Main.LIS.GetLicenseType()) {
            case 0:
            case 66:
                break;
            case 33:
            case 99:
                x = Padding;
                y += ListHeight + Padding * 2;

                StandardCalculatorDecimalPlacesLabel.setSize(LabelWidth, LabelHeight);
                StandardCalculatorDecimalPlacesLabel.setFont(LabelFont);
                StandardCalculatorDecimalPlacesLabel.setLocation(x, y);
                configurationPane.add(StandardCalculatorDecimalPlacesLabel);

                x += LabelWidth;

                CalcDecimalText.setSize(ListWidth, ListHeight);
                CalcDecimalText.setLocation(x, y);
                configurationPane.add(CalcDecimalText);
                break;
        }

        x = Padding;
        y += ListHeight + Padding * 2;

        TaxPlusLabel.setSize(LabelWidth, LabelHeight);
        TaxPlusLabel.setFont(LabelFont);
        TaxPlusLabel.setLocation(x, y);
        configurationPane.add(TaxPlusLabel);

        x += LabelWidth;

        TaxPlusText.setSize(ListWidth, ListHeight);
        TaxPlusText.setLocation(x, y);
        configurationPane.add(TaxPlusText);

        x = Padding;
        y += ListHeight + Padding * 2;

        TaxMinusLabel.setSize(LabelWidth, LabelHeight);
        TaxMinusLabel.setFont(LabelFont);
        TaxMinusLabel.setLocation(x, y);
        configurationPane.add(TaxMinusLabel);

        x += LabelWidth;

        TaxMinusText.setSize(ListWidth, ListHeight);
        TaxMinusText.setLocation(x, y);
        configurationPane.add(TaxMinusText);

        //Build Memory Panel
        MemoryPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        MemoryFontLabel.setSize(LabelWidth, LabelHeight);
        MemoryFontLabel.setLocation(x, y);
        MemoryPanel.add(MemoryFontLabel);

        x += LabelWidth;

        MemoryFontList.setSize(ListWidth, ListHeight);
        MemoryFontList.setLocation(x, y);
        MemoryPanel.add(MemoryFontList);

        x = Padding;
        y += ListHeight + Padding;

        MemoryFontSizeLabel.setSize(LabelWidth, LabelHeight);
        MemoryFontSizeLabel.setLocation(x, y);
        MemoryPanel.add(MemoryFontSizeLabel);

        x += LabelWidth;

        MemoryButtonFontSizeList.setSize(ListWidth, ListHeight);
        MemoryButtonFontSizeList.setLocation(x, y);
        MemoryPanel.add(MemoryButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        MemoryFontColorLabel.setSize(LabelWidth, LabelHeight);
        MemoryFontColorLabel.setLocation(x, y);
        MemoryPanel.add(MemoryFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        MemoryFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        MemoryFontColorSetButton.setFont(SetButtonFont);
        MemoryFontColorSetButton.setLocation(x, y);
        MemoryFontColorSetButton.addActionListener(this);
        MemoryPanel.add(MemoryFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        MemoryButtonColorLabel.setSize(LabelWidth, LabelHeight);
        MemoryButtonColorLabel.setLocation(x, y);
        MemoryPanel.add(MemoryButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        MemoryButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        MemoryButtonColorSetButton.setFont(SetButtonFont);
        MemoryButtonColorSetButton.setLocation(x, y);
        MemoryButtonColorSetButton.addActionListener(this);
        MemoryPanel.add(MemoryButtonColorSetButton);

        //Build Edit Panel
        EditPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        EditFontLabel.setSize(LabelWidth, LabelHeight);
        EditFontLabel.setLocation(x, y);
        EditPanel.add(EditFontLabel);

        x += LabelWidth;

        EditFontList.setSize(ListWidth, ListHeight);
        EditFontList.setLocation(x, y);
        EditPanel.add(EditFontList);

        x = Padding;
        y += ListHeight + Padding;

        EditFontSizeLabel.setSize(LabelWidth, LabelHeight);
        EditFontSizeLabel.setLocation(x, y);
        EditPanel.add(EditFontSizeLabel);

        x += LabelWidth;

        EditButtonFontSizeList.setSize(ListWidth, ListHeight);
        EditButtonFontSizeList.setLocation(x, y);
        EditPanel.add(EditButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        EditFontColorLabel.setSize(LabelWidth, LabelHeight);
        EditFontColorLabel.setLocation(x, y);
        EditPanel.add(EditFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        EditFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        EditFontColorSetButton.setFont(SetButtonFont);
        EditFontColorSetButton.setLocation(x, y);
        EditFontColorSetButton.addActionListener(this);
        EditPanel.add(EditFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        EditButtonColorLabel.setSize(LabelWidth, LabelHeight);
        EditButtonColorLabel.setLocation(x, y);
        EditPanel.add(EditButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        EditButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        EditButtonColorSetButton.setFont(SetButtonFont);
        EditButtonColorSetButton.setLocation(x, y);
        EditButtonColorSetButton.addActionListener(this);
        EditPanel.add(EditButtonColorSetButton);

        //Build Accounting Panel
        AccountingPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        AccountingFontLabel.setSize(LabelWidth, LabelHeight);
        AccountingFontLabel.setLocation(x, y);
        AccountingPanel.add(AccountingFontLabel);

        x += LabelWidth;

        AccountingFontList.setSize(ListWidth, ListHeight);
        AccountingFontList.setLocation(x, y);
        AccountingPanel.add(AccountingFontList);

        x = Padding;
        y += ListHeight + Padding;

        AccountingFontSizeLabel.setSize(LabelWidth, LabelHeight);
        AccountingFontSizeLabel.setLocation(x, y);
        AccountingPanel.add(AccountingFontSizeLabel);

        x += LabelWidth;

        AccountingButtonFontSizeList.setSize(ListWidth, ListHeight);
        AccountingButtonFontSizeList.setLocation(x, y);
        AccountingPanel.add(AccountingButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        AccountingFontColorLabel.setSize(LabelWidth, LabelHeight);
        AccountingFontColorLabel.setLocation(x, y);
        AccountingPanel.add(AccountingFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        AccountingFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        AccountingFontColorSetButton.setFont(SetButtonFont);
        AccountingFontColorSetButton.setLocation(x, y);
        AccountingFontColorSetButton.addActionListener(this);
        AccountingPanel.add(AccountingFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        AccountingButtonColorLabel.setSize(LabelWidth, LabelHeight);
        AccountingButtonColorLabel.setLocation(x, y);
        AccountingPanel.add(AccountingButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        AccountingButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        AccountingButtonColorSetButton.setFont(SetButtonFont);
        AccountingButtonColorSetButton.setLocation(x, y);
        AccountingButtonColorSetButton.addActionListener(this);
        AccountingPanel.add(AccountingButtonColorSetButton);

        //Build Financial Panel
        FinancialPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        FinancialFontLabel.setSize(LabelWidth, LabelHeight);
        FinancialFontLabel.setLocation(x, y);
        FinancialPanel.add(FinancialFontLabel);

        x += LabelWidth;

        FinancialFontList.setSize(ListWidth, ListHeight);
        FinancialFontList.setLocation(x, y);
        FinancialPanel.add(FinancialFontList);

        x = Padding;
        y += ListHeight + Padding;

        FinancialFontSizeLabel.setSize(LabelWidth, LabelHeight);
        FinancialFontSizeLabel.setLocation(x, y);
        FinancialPanel.add(FinancialFontSizeLabel);

        x += LabelWidth;

        FinancialButtonFontSizeList.setSize(ListWidth, ListHeight);
        FinancialButtonFontSizeList.setLocation(x, y);
        FinancialPanel.add(FinancialButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        FinancialFontColorLabel.setSize(LabelWidth, LabelHeight);
        FinancialFontColorLabel.setLocation(x, y);
        FinancialPanel.add(FinancialFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        FinancialFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        FinancialFontColorSetButton.setFont(SetButtonFont);
        FinancialFontColorSetButton.setLocation(x, y);
        FinancialFontColorSetButton.addActionListener(this);
        FinancialPanel.add(FinancialFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        FinancialButtonColorLabel.setSize(LabelWidth, LabelHeight);
        FinancialButtonColorLabel.setLocation(x, y);
        FinancialPanel.add(FinancialButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        FinancialButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        FinancialButtonColorSetButton.setFont(SetButtonFont);
        FinancialButtonColorSetButton.setLocation(x, y);
        FinancialButtonColorSetButton.addActionListener(this);
        FinancialPanel.add(FinancialButtonColorSetButton);

        //Build AlgebraPanel
        AlgebraPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        AlgebraFontLabel.setSize(LabelWidth, LabelHeight);
        AlgebraFontLabel.setLocation(x, y);
        AlgebraPanel.add(AlgebraFontLabel);

        x += LabelWidth;

        AlgebraFontList.setSize(ListWidth, ListHeight);
        AlgebraFontList.setLocation(x, y);
        AlgebraPanel.add(AlgebraFontList);

        x = Padding;
        y += ListHeight + Padding;

        AlgebraFontSizeLabel.setSize(LabelWidth, LabelHeight);
        AlgebraFontSizeLabel.setLocation(x, y);
        AlgebraPanel.add(AlgebraFontSizeLabel);

        x += LabelWidth;

        AlgebraButtonFontSizeList.setSize(ListWidth, ListHeight);
        AlgebraButtonFontSizeList.setLocation(x, y);
        AlgebraPanel.add(AlgebraButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        AlgebraFontColorLabel.setSize(LabelWidth, LabelHeight);
        AlgebraFontColorLabel.setLocation(x, y);
        AlgebraPanel.add(AlgebraFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        AlgebraFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        AlgebraFontColorSetButton.setFont(SetButtonFont);
        AlgebraFontColorSetButton.setLocation(x, y);
        AlgebraFontColorSetButton.addActionListener(this);
        AlgebraPanel.add(AlgebraFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        AlgebraButtonColorLabel.setSize(LabelWidth, LabelHeight);
        AlgebraButtonColorLabel.setLocation(x, y);
        AlgebraPanel.add(AlgebraButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        AlgebraButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        AlgebraButtonColorSetButton.setFont(SetButtonFont);
        AlgebraButtonColorSetButton.setLocation(x, y);
        AlgebraButtonColorSetButton.addActionListener(this);
        AlgebraPanel.add(AlgebraButtonColorSetButton);

        //Build Trigonometry Panel
        TrigPanel.setLayout(null);

        x = Padding;
        y = Padding * 2;

        TrigFontLabel.setSize(LabelWidth, LabelHeight);
        TrigFontLabel.setLocation(x, y);
        TrigPanel.add(TrigFontLabel);

        x += LabelWidth;

        TrigFontList.setSize(ListWidth, ListHeight);
        TrigFontList.setLocation(x, y);
        TrigPanel.add(TrigFontList);

        x = Padding;
        y += ListHeight + Padding;

        TrigFontSizeLabel.setSize(LabelWidth, LabelHeight);
        TrigFontSizeLabel.setLocation(x, y);
        TrigPanel.add(TrigFontSizeLabel);

        x += LabelWidth;

        TrigButtonFontSizeList.setSize(ListWidth, ListHeight);
        TrigButtonFontSizeList.setLocation(x, y);
        TrigPanel.add(TrigButtonFontSizeList);

        x = Padding;
        y += ListHeight + Padding * 2;

        TrigFontColorLabel.setSize(LabelWidth, LabelHeight);
        TrigFontColorLabel.setLocation(x, y);
        TrigPanel.add(TrigFontColorLabel);

        x += LabelWidth;
        y -= Padding;

        TrigFontColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        TrigFontColorSetButton.setFont(SetButtonFont);
        TrigFontColorSetButton.setLocation(x, y);
        TrigFontColorSetButton.addActionListener(this);
        TrigPanel.add(TrigFontColorSetButton);

        x = Padding;
        y += SetButtonHeight + Padding * 2;

        TrigButtonColorLabel.setSize(LabelWidth, LabelHeight);
        TrigButtonColorLabel.setLocation(x, y);
        TrigPanel.add(TrigButtonColorLabel);

        x += LabelWidth;
        y -= Padding;

        TrigButtonColorSetButton.setSize(SetButtonWidth, SetButtonHeight);
        TrigButtonColorSetButton.setFont(SetButtonFont);
        TrigButtonColorSetButton.setLocation(x, y);
        TrigButtonColorSetButton.addActionListener(this);
        TrigPanel.add(TrigButtonColorSetButton);

        //Add Button Configuration Controls
        x = LabelWidth + ListWidth + Padding * 6;
        y = Padding * 3;

        ButtonsLabel.setSize(LabelWidth, LabelHeight);
        ButtonsLabel.setLocation(x, y);
        configurationPane.add(ButtonsLabel);

        y += LabelHeight + Padding;

        tabs.addTab("Memory", MemoryPanel);
        tabs.addTab("Edit", EditPanel);
        tabs.addTab("Accounting", AccountingPanel);
        tabs.addTab("Financial", FinancialPanel);
        switch (Main.LIS.GetLicenseType()) {
            case 0:
            case 66:
                break;
            case 33:
            case 99:
                tabs.addTab("Algebra", AlgebraPanel);
                tabs.addTab("Trigonometry", TrigPanel);
                break;
        }
        tabs.setTabPlacement(javax.swing.JTabbedPane.TOP);
        tabs.setFont(TabFont);
        tabs.setSize(TabWidth, TabHeight);
        tabs.setLocation(x, y);
        configurationPane.add(tabs);


        //Add Main Control Buttons
        x = ((MainWidth - (ButtonWidth * 3 + Padding * 2)) / 2);
        y = MainHeight - ButtonHeight * 2 - Padding * 5;

        OKButton.setSize(ButtonWidth, ButtonHeight);
        OKButton.setFont(ButtonFont);
        OKButton.setLocation(x, y);
        configurationPane.add(OKButton);
        OKButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        ResetButton.setSize(ButtonWidth, ButtonHeight);
        ResetButton.setFont(ButtonFont);
        ResetButton.setLocation(x, y);
        configurationPane.add(ResetButton);
        ResetButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        CancelButton.setSize(ButtonWidth, ButtonHeight);
        CancelButton.setFont(ButtonFont);
        CancelButton.setLocation(x, y);
        configurationPane.add(CancelButton);
        CancelButton.addActionListener(this);

        SetControls();

        configurationPane.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void GetAll() {
        memoryFontSize = Main.CFG.GetMemoryFontSize();
        editFontSize = Main.CFG.GetEditFontSize();
        accountingFontSize = Main.CFG.GetAccountingFontSize();
        financialFontSize = Main.CFG.GetFinancialFontSize();
        algebraFontSize = Main.CFG.GetAlgebraFontSize();
        trigFontSize = Main.CFG.GetTrigFontSize();
        displayFontString = Main.CFG.GetDisplayFontString();
        memoryFontString = Main.CFG.GetMemoryFontString();
        editFontString = Main.CFG.GetEditFontString();
        accountingFontString = Main.CFG.GetAccountingFontString();
        financialFontString = Main.CFG.GetFinancialFontString();
        algebraFontString = Main.CFG.GetAlgebraFontString();
        trigFontString = Main.CFG.GetTrigFontString();
        defaultFileTypeString = Main.CFG.GetDefaultFileType();
        memoryFontColor = Main.CFG.GetMemoryFontColor();
        memoryButtonColor = Main.CFG.GetMemoryButtonColor();
        editFontColor = Main.CFG.GetEditFontColor();
        editButtonColor = Main.CFG.GetEditButtonColor();
        accountingFontColor = Main.CFG.GetAccountingFontColor();
        accountingButtonColor = Main.CFG.GetAccountingButtonColor();
        financialFontColor = Main.CFG.GetFinancialFontColor();
        financialButtonColor = Main.CFG.GetFinancialButtonColor();
        algebraFontColor = Main.CFG.GetAlgebraFontColor();
        algebraButtonColor = Main.CFG.GetAlgebraButtonColor();
        trigFontColor = Main.CFG.GetTrigFontColor();
        trigButtonColor = Main.CFG.GetTrigButtonColor();
        taxPlusString = Main.CFG.GetTaxPlus();
        taxMinusString = Main.CFG.GetTaxMinus();
        AMDecimalString = Integer.toString(Main.CFG.GetDecimalPlaces(0));
        CalcDecimalString = Integer.toString(Main.CFG.GetDecimalPlaces(1));
    }

    private void SetAll() {
        Main.CFG.SetDefaultLogic(DefaultLogicList.getSelectedIndex());
        Main.CFG.SetDefaultFileType(defaultFileTypeString);
        Main.CFG.SetDisplayFontString(displayFontString);
        Main.CFG.SetDecimalPlaces(0, AMDecimalInt);
        Main.CFG.SetConfigurationMath(0, AMDecimalInt);
        Main.CFG.SetDecimalPlaces(1, CalcDecimalInt);
        Main.CFG.SetConfigurationMath(1, CalcDecimalInt);
        Main.CFG.SetTaxPlus(taxPlusString);
        Main.CFG.SetTaxMinus(taxMinusString);
        Main.CFG.SetMemoryFontSize(memoryFontSize);
        Main.CFG.SetEditFontSize(editFontSize);
        Main.CFG.SetAccountingFontSize(accountingFontSize);
        Main.CFG.SetFinancialFontSize(financialFontSize);
        Main.CFG.SetAlgebraFontSize(algebraFontSize);
        Main.CFG.SetTrigFontSize(trigFontSize);
        Main.CFG.SetDisplayFontString(displayFontString);
        Main.CFG.SetMemoryFontString(memoryFontString);
        Main.CFG.SetEditFontString(editFontString);
        Main.CFG.SetAccountingFontString(accountingFontString);
        Main.CFG.SetFinancialFontString(financialFontString);
        Main.CFG.SetAlgebraFontString(algebraFontString);
        Main.CFG.SetTrigFontString(trigFontString);
        Main.CFG.SetMemoryFontColor(memoryFontColor);
        Main.CFG.SetMemoryButtonColor(memoryButtonColor);
        Main.CFG.SetEditFontColor(editFontColor);
        Main.CFG.SetEditButtonColor(editButtonColor);
        Main.CFG.SetAccountingFontColor(accountingFontColor);
        Main.CFG.SetAccountingButtonColor(accountingButtonColor);
        Main.CFG.SetFinancialFontColor(financialFontColor);
        Main.CFG.SetFinancialButtonColor(financialButtonColor);
        Main.CFG.SetAlgebraFontColor(algebraFontColor);
        Main.CFG.SetAlgebraButtonColor(algebraButtonColor);
        Main.CFG.SetTrigFontColor(trigFontColor);
        Main.CFG.SetTrigButtonColor(trigButtonColor);
    }

    private void SetControls() {
        switch (Main.LIS.GetLicenseType()) {
            case 0:
            case 66:
                break;
            case 33:
            case 99:
                DefaultLogicList.setSelectedIndex(Main.CFG.GetDefaultLogic());
                break;
        }
        String fileType = Main.CFG.GetDefaultFileType();
        if (fileType.equalsIgnoreCase(".txt")) {
            DefaultFileTypeList.setSelectedIndex(0);
        } else if (fileType.equalsIgnoreCase(".rtf")) {
            DefaultFileTypeList.setSelectedIndex(1);
        } else if (fileType.equalsIgnoreCase(".csv")) {
            DefaultFileTypeList.setSelectedIndex(2);
        } else {
            DefaultFileTypeList.setSelectedIndex(0);
        }
        AMDecimalText.setText(AMDecimalString);
        CalcDecimalText.setText(CalcDecimalString);
        TaxPlusText.setText(taxPlusString);
        TaxMinusText.setText(taxMinusString);
        for (int i = 0; i < fontList.length; i++) {
            if (displayFontString.equalsIgnoreCase(fontList[i])) {
                DisplayFontList.setSelectedIndex(i);
            }
            if (memoryFontString.equalsIgnoreCase(fontList[i])) {
                MemoryFontList.setSelectedIndex(i);
            }
            if (editFontString.equalsIgnoreCase(fontList[i])) {
                EditFontList.setSelectedIndex(i);
            }
            if (accountingFontString.equalsIgnoreCase(fontList[i])) {
                AccountingFontList.setSelectedIndex(i);
            }
            if (financialFontString.equalsIgnoreCase(fontList[i])) {
                FinancialFontList.setSelectedIndex(i);
            }
            if (algebraFontString.equalsIgnoreCase(fontList[i])) {
                AlgebraFontList.setSelectedIndex(i);
            }
            if (trigFontString.equalsIgnoreCase(fontList[i])) {
                TrigFontList.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < specialButtonFontSizeList.length; i++) {
            if (memoryFontSize == specialButtonFontSizeList[i]) {
                MemoryButtonFontSizeList.setSelectedIndex(i);
            }
            if (editFontSize == specialButtonFontSizeList[i]) {
                EditButtonFontSizeList.setSelectedIndex(i);
            }
            if (accountingFontSize == specialButtonFontSizeList[i]) {
                AccountingButtonFontSizeList.setSelectedIndex(i);
            }
            if (financialFontSize == specialButtonFontSizeList[i]) {
                FinancialButtonFontSizeList.setSelectedIndex(i);
            }
            if (algebraFontSize == specialButtonFontSizeList[i]) {
                AlgebraButtonFontSizeList.setSelectedIndex(i);
            }
            if (trigFontSize == specialButtonFontSizeList[i]) {
                TrigButtonFontSizeList.setSelectedIndex(i);
            }
        }
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        int error = 0;
        if (str.equals("Cancel")) {
            super.dispose();
        } else if (str.equals("OK")) {
            AMDecimalString = AMDecimalText.getText();
            CalcDecimalString = CalcDecimalText.getText();
            taxPlusString = TaxPlusText.getText();
            taxMinusString = TaxMinusText.getText();
            try {
                AMDecimalInt = Integer.parseInt(AMDecimalString);
            } catch (Exception ex) {
                error = -99;
                ErrorMessages.DecimalPlacesError();
                AMDecimalText.setText("");
                AMDecimalText.requestFocus();
            }
            try {
                CalcDecimalInt = Integer.parseInt(CalcDecimalString);
            } catch (Exception ex) {
                error = -99;
                ErrorMessages.DecimalPlacesError();
                CalcDecimalText.setText("");
                CalcDecimalText.requestFocus();
            }

            try {
                placeHolderPlus = Integer.parseInt(taxPlusString);
            } catch (Exception ex) {
                error = -99;
                ErrorMessages.TaxRateError();
                TaxPlusText.setText("");
                TaxPlusText.requestFocus();
            }

            try {
                placeHolderMinus = Integer.parseInt(taxMinusString);
            } catch (Exception ex) {
                error = -99;
                ErrorMessages.TaxRateError();
                TaxMinusText.setText("");
                TaxMinusText.requestFocus();
            }

            if (AMDecimalInt >= 0 && AMDecimalInt <= 20) {
            } else {
                error = -99;
                ErrorMessages.DecimalPlacesError();
                AMDecimalText.setText("");
                AMDecimalText.requestFocus();
            }
            if (CalcDecimalInt >= 0 && CalcDecimalInt <= 20) {
            } else {
                error = -99;
                ErrorMessages.DecimalPlacesError();
                CalcDecimalText.setText("");
                CalcDecimalText.requestFocus();
            }
            if (placeHolderPlus >= 0 && placeHolderPlus <= 100) {
            } else {
                error = -99;
                ErrorMessages.TaxRateError();
                TaxPlusText.setText("");
                TaxPlusText.requestFocus();
            }
            if (placeHolderMinus >= 0 && placeHolderMinus <= 100) {
            } else {
                error = -99;
                ErrorMessages.TaxRateError();
                TaxMinusText.setText("");
                TaxMinusText.requestFocus();
            }

            int selected = DisplayFontList.getSelectedIndex();
            displayFontString = fontList[selected];
            selected = MemoryFontList.getSelectedIndex();
            memoryFontString = fontList[selected];
            selected = MemoryButtonFontSizeList.getSelectedIndex();
            memoryFontSize = specialButtonFontSizeList[selected];
            selected = EditFontList.getSelectedIndex();
            editFontString = fontList[selected];
            selected = EditButtonFontSizeList.getSelectedIndex();
            editFontSize = specialButtonFontSizeList[selected];
            selected = AccountingFontList.getSelectedIndex();
            accountingFontString = fontList[selected];
            selected = AccountingButtonFontSizeList.getSelectedIndex();
            accountingFontSize = specialButtonFontSizeList[selected];
            selected = FinancialFontList.getSelectedIndex();
            financialFontString = fontList[selected];
            selected = FinancialButtonFontSizeList.getSelectedIndex();
            financialFontSize = specialButtonFontSizeList[selected];
            selected = AlgebraFontList.getSelectedIndex();
            algebraFontString = fontList[selected];
            selected = AlgebraButtonFontSizeList.getSelectedIndex();
            algebraFontSize = specialButtonFontSizeList[selected];
            selected = TrigFontList.getSelectedIndex();
            trigFontString = fontList[selected];
            selected = TrigButtonFontSizeList.getSelectedIndex();
            trigFontSize = specialButtonFontSizeList[selected];
            selected = DefaultFileTypeList.getSelectedIndex();
            switch (selected) {
                case 0:
                    defaultFileTypeString = ".txt";
                    break;
                case 1:
                    defaultFileTypeString = ".rtf";
                    break;
                case 2:
                    defaultFileTypeString = ".csv";
                    break;
            }
            if (error == 0) {
                SetAll();
                Main.GUI.SetConfigs();
                this.dispose();
            }
        } else if (str.equals("Reset")) {
            GetAll();
            SetControls();
        } else if (str.equals("Save Location")) {
            Main.CFG.SetDefaultSaveLocation();
        } else if (str.equals("Font Color")) {
            switch (tabs.getSelectedIndex()) {
                case 0:
                    memoryFontColor = JColorChooser.showDialog(this,
                            "Choose Memory Font Color", Main.CFG.GetMemoryFontColor());
                    if (Main.CFG.GetMemoryFontColor() != null) {
                        break;
                    }
                case 1:
                    editFontColor = JColorChooser.showDialog(this,
                            "Choose Edit Font Color", Main.CFG.GetEditFontColor());
                    if (Main.CFG.GetEditFontColor() != null) {
                        break;
                    }
                case 2:
                    accountingFontColor = JColorChooser.showDialog(this,
                            "Choose Accounting Font Color", Main.CFG.GetAccountingFontColor());
                    if (Main.CFG.GetAccountingFontColor() != null) {
                        break;
                    }
                case 3:
                    financialFontColor = JColorChooser.showDialog(this,
                            "Choose Financial Font Color", Main.CFG.GetFinancialFontColor());
                    if (Main.CFG.GetFinancialFontColor() != null) {
                        break;
                    }
                case 4:
                    algebraFontColor = JColorChooser.showDialog(this,
                            "Choose Algebra Font Color", Main.CFG.GetAlgebraFontColor());
                    if (Main.CFG.GetAlgebraFontColor() != null) {
                        break;
                    }
                case 5:
                    trigFontColor = JColorChooser.showDialog(this,
                            "Choose Trigonometry Font Color", Main.CFG.GetTrigFontColor());
                    if (Main.CFG.GetTrigFontColor() != null) {
                        break;
                    }
            }
        } else if (str.equals("Button Color")) {
            switch (tabs.getSelectedIndex()) {
                case 0:
                    memoryButtonColor = JColorChooser.showDialog(this,
                            "Choose Memory Button Color", Main.CFG.GetMemoryButtonColor());
                    if (Main.CFG.GetMemoryButtonColor() != null) {
                        break;
                    }
                case 1:
                    editButtonColor = JColorChooser.showDialog(this,
                            "Choose Edit Button Color", Main.CFG.GetEditButtonColor());
                    if (Main.CFG.GetEditButtonColor() != null) {
                        break;
                    }
                case 2:
                    accountingButtonColor = JColorChooser.showDialog(this,
                            "Choose Accounting Button Color", Main.CFG.GetAccountingButtonColor());
                    if (Main.CFG.GetAccountingButtonColor() != null) {
                        break;
                    }
                case 3:
                    financialButtonColor = JColorChooser.showDialog(this,
                            "Choose Memory Button Color", Main.CFG.GetFinancialButtonColor());
                    if (Main.CFG.GetFinancialButtonColor() != null) {
                        break;
                    }
                case 4:
                    algebraButtonColor = JColorChooser.showDialog(this,
                            "Choose Algebra Button Color", Main.CFG.GetAlgebraButtonColor());
                    if (Main.CFG.GetAlgebraButtonColor() != null) {
                        break;
                    }
                case 5:
                    trigButtonColor = JColorChooser.showDialog(this,
                            "Choose Trigonometry Button Color", Main.CFG.GetTrigButtonColor());
                    if (Main.CFG.GetTrigButtonColor() != null) {
                        break;
                    }
            }
        }
    }
}