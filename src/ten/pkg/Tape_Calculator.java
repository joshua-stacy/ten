/*
 ==============================================================
 == Date:          1/23/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator_Copy
 == Class Name:    Tape_Calculator_Copy
 == Purpose:       This class generates the User Interface.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;

public class Tape_Calculator extends JFrame {

    private String title = "";
    private String version = "Beta 1.0";
    //Create Sizing Variables
    public Integer x, y, Padding, UserScreenHeight, MainWidth, MainHeight, NumButtonWidth,
            NumButtonHeight, SpecialButtonWidth, SpecialButtonHeight,
            TestButtonWidth, TestButtonHeight, OpButtonWidth,
            OpButtonHeight, TapeWidth, TapeHeight, ScrollWidth, ScrollHeight,
            TabWidth, TabHeight, InputWidth, InputHeight, RadioButtonHeight, RadioButtonWidth,
            MaxUserInput, ActiveTape, TapeTabWidth;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //Create Menu Bar
    private JMenuBar MenuBar = new JMenuBar();
    private JMenu FileMenu = new JMenu("File");
    private JMenu EditMenu = new JMenu("Edit");
    private JMenu SettingsMenu = new JMenu("Settings");
    private JMenu HelpMenu = new JMenu("Help");
    //Create menu items for File Menu
    private JMenuItem NewAction = new JMenuItem("New Tape");
    private JMenuItem OpenAction = new JMenuItem("Open File");
    private JMenuItem OpenInTabAction = new JMenuItem("Open File in New Tab");
    private JMenuItem SaveAction = new JMenuItem("Save Tape");
    private JMenuItem SaveAsAction = new JMenuItem("Save Tape As");
    private JMenuItem CloseAction = new JMenuItem("Close Tape");
    private JMenuItem ReOpenAction = new JMenuItem("Re-Open Closed Tape");
    private JMenuItem ExitAction = new JMenuItem("Exit");
    //Create menu items for Edit Menu
    private JMenuItem EditSubTotalsAction = new JMenuItem("Edit SubTotal");
    //Create menu items for Settings Menu
    private JMenuItem PreferencesAction = new JMenuItem("Edit Preferences");
    private JMenuItem LoadDefaultPreferencesAction = new JMenuItem("Load Default Preferences");
    private JMenuItem LoadUserPreferencesAction = new JMenuItem("Load User Preferences");
    private JMenuItem SavePreferencesAction = new JMenuItem("Save Preferences");
    private JMenuItem DefaultSaveToAction = new JMenuItem("Set Default Save Folder");
    private JMenuItem DefaultFileExtensionAction = new JMenuItem("Set Default File Extension");
    //Create menu items for Help Menu
    private JMenuItem AboutAction = new JMenuItem("About");
    private JMenuItem HelpAction = new JMenuItem("Help");
    private JMenuItem LicenseAction = new JMenuItem("Input Product License");
    //Create Tabbed Pane
    private JTabbedPane tabs = new JTabbedPane();
    //Create Panels for Tabbed Pane
    private JPanel AccountingPanel = new JPanel();
    private JPanel FinancialPanel = new JPanel();
    private JPanel AlgebraPanel = new JPanel();
    private JPanel TrigPanel = new JPanel();
    //Create Tabbed Pane For MultipleTapes
    public JTabbedPane TapeTabs = new JTabbedPane();
    //Create Change Listener for TapeTabs
    private TapeChangeListener TapeChange = new TapeChangeListener();
    private LogicActionListener LogicChange = new LogicActionListener();
    //Create Text Field for user entries
    public JTextField DisplayText = new JTextField();
    //Create Text Area for "Tape"
    private JTextArea[] TapeArray;
    public JScrollPane[] ScrollingTapeArray;
    //Create Buttons
    private JButton ZeroB = new JButton("0");
    private JButton OneB = new JButton("1");
    private JButton TwoB = new JButton("2");
    private JButton ThreeB = new JButton("3");
    private JButton FourB = new JButton("4");
    private JButton FiveB = new JButton("5");
    private JButton SixB = new JButton("6");
    private JButton SevenB = new JButton("7");
    private JButton EightB = new JButton("8");
    private JButton NineB = new JButton("9");
    private JButton TwoZeroesB = new JButton("00");
    private JButton ThreeZeroesB = new JButton("000");
    private JButton DecimalB = new JButton(".");
    private JButton AddB = new JButton("+");
    private JButton SubtractB = new JButton("-");
    private JButton MultiplyB = new JButton("X");
    private JButton DivideB = new JButton("/");
    private JButton EqualsB = new JButton("=");
    private JButton BackSpaceB = new JButton("Backspace");
    private JButton ClearEntryB = new JButton("Clear Entry");
    private JButton ClearSubTotalB = new JButton("Clear Sub");
    private JButton ClearAllB = new JButton("Clear All");
    private JButton SignChangeB = new JButton("+/-");
    private JButton SquaredB = new JButton("x" + "\u00B2");
    private JButton SquareRootB = new JButton("\u221A");
    private JButton PercentB = new JButton("%");
    public JButton Mem1B = new JButton("M1");
    private JButton Mem1AddB = new JButton("M1+");
    private JButton Mem1SubtractB = new JButton("M1-");
    private JButton Mem1ClearB = new JButton("M1C");
    private JButton Mem2B = new JButton("M2");
    private JButton Mem2AddB = new JButton("M2+");
    private JButton Mem2SubtractB = new JButton("M2-");
    private JButton Mem2ClearB = new JButton("M2C");
    //Test Code
    private JButton TestB4 = new JButton("Test Data");
    private JButton TestB5 = new JButton("Cfg Data");
    private JButton TestB6 = new JButton("Array Data");
    private JButton TestB7 = new JButton("Clsd Data");
    private JButton TestB8 = new JButton("String Data");
    //End Test
    //Accounting Buttons
    private JButton SubTotalB = new JButton("Subtotal");
    private JButton TotalB = new JButton("Total");
    private JButton TaxPlusB = new JButton("Tax +");
    private JButton TaxMinusB = new JButton("Tax -");
    private JButton SetTaxPlusB = new JButton("Set Tax +");
    private JButton SetTaxMinusB = new JButton("Set Tax -");
    //Financial Buttons
    private JButton PresentValueB = new JButton("Present Value");
    private JButton FutureValueB = new JButton("Future Value");
    private JButton MortgageCalcB = new JButton("Mortgage Calculator");
    //Algebra Buttons
    private JButton XYPowerB = new JButton("x" + "\u02B8");
    private JButton XYRootB = new JButton("\u02B8" + "\u221A" + "x");
    private JButton EXPowerB = new JButton("e" + "\u02E3");
    private JButton NaturalLogB = new JButton("ln");
    private JButton TenXPowerB = new JButton("10" + "\u02E3");
    private JButton LogarithmB = new JButton("log");
    //Trigonometry Buttons
    private JButton SineB = new JButton("sin");
    private JButton CosineB = new JButton("cos");
    private JButton TangentB = new JButton("tan");
    private JButton ArcSineB = new JButton("asin");
    private JButton ArcCosineB = new JButton("acos");
    private JButton ArcTangentB = new JButton("atan");
    //Create Radio Buttons
    private JRadioButton AddingMachineRB = new JRadioButton("Adding Machine Logic");
    private JRadioButton StandardCalcRB = new JRadioButton("Standard Calculator Logic");
    private ButtonGroup LogicGroup = new ButtonGroup();
    //Create Button Font
    private Font LargeButtonFont = new Font("Dialog", Font.BOLD, 12);
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font LargeTapeTabFont = new Font("Monospaced", Font.BOLD, 9);
    private Font SmallTapeTabFont = new Font("Monospaced", Font.BOLD, 7);
    private Font LargeTabFont = new Font("Dialog", Font.BOLD, 10);
    private Font SmallTabFont = new Font("Dialog", Font.BOLD, 7);
    private Font LargeSpecialButtonFont = new Font("Dialog", Font.BOLD, 9);
    private Font SmallSpecialButtonFont = new Font("Dialog", Font.BOLD, 6);
    private Font LargeDisplayFont = new Font("Monospaced", Font.BOLD, 12);
    private Font SmallDisplayFont = new Font("Monospaced", Font.BOLD, 10);
    private Font ButtonFont;
    private Font SpecialButtonFont;
    private Font TabFont;
    private Font NewFont;
    private Font TapeTabFont;
    private Font DisplayFont;
    private KeyboardListener listener = new KeyboardListener();
    private WindowListener wListener = new WinListener();
    //Create Action Handlers for Menu Items
    private NewActionHandler NewActHandler = new NewActionHandler();
    private OpenActionHandler OpenActHandler = new OpenActionHandler();
    private OpenInTabActionHandler OpenInTabActHandler = new OpenInTabActionHandler();
    private SaveActionHandler SaveActHandler = new SaveActionHandler();
    private SaveAsActionHandler SaveAsActHandler = new SaveAsActionHandler();
    private CloseActionHandler CloseActHandler = new CloseActionHandler();
    private ReOpenActionHandler ReOpenActHandler = new ReOpenActionHandler();
    private ExitActionHandler ExitActHandler = new ExitActionHandler();
    private EditSubTotalsActionHandler EditSubTotalsActHandler = new EditSubTotalsActionHandler();
    private PreferencesActionHandler PreferencesActHandler = new PreferencesActionHandler();
    private LoadDefaultPreferencesActionHandler LoadDefaultPreferencesActHandler = new LoadDefaultPreferencesActionHandler();
    private LoadUserPreferencesActionHandler LoadUserPreferencesActHandler = new LoadUserPreferencesActionHandler();
    private SavePreferencesActionHandler SavePreferencesActHandler = new SavePreferencesActionHandler();
    private DefaultSaveToActionHandler DefaultSaveToActHandler = new DefaultSaveToActionHandler();
    private DefaultFileExtensionActionHandler DefaultFileExtensionActHandler = new DefaultFileExtensionActionHandler();
    private AboutActionHandler AboutActHandler = new AboutActionHandler();
    private HelpActionHandler HelpActHandler = new HelpActionHandler();
    private LicenseActionHandler LicenseActHandler = new LicenseActionHandler();
    //Create Action Handlers for Buttons
    private ZeroButtonHandler ZeroBHandler = new ZeroButtonHandler();
    private OneButtonHandler OneBHandler = new OneButtonHandler();
    private TwoButtonHandler TwoBHandler = new TwoButtonHandler();
    private ThreeButtonHandler ThreeBHandler = new ThreeButtonHandler();
    private FourButtonHandler FourBHandler = new FourButtonHandler();
    private FiveButtonHandler FiveBHandler = new FiveButtonHandler();
    private SixButtonHandler SixBHandler = new SixButtonHandler();
    private SevenButtonHandler SevenBHandler = new SevenButtonHandler();
    private EightButtonHandler EightBHandler = new EightButtonHandler();
    private NineButtonHandler NineBHandler = new NineButtonHandler();
    private TwoZeroesButtonHandler TwoZeroesBHandler = new TwoZeroesButtonHandler();
    private ThreeZeroesButtonHandler ThreeZeroesBHandler = new ThreeZeroesButtonHandler();
    private DecimalButtonHandler DecimalBHandler = new DecimalButtonHandler();
    private AddButtonHandler AddBHandler = new AddButtonHandler();
    private SubtractButtonHandler SubtractBHandler = new SubtractButtonHandler();
    private MultiplyButtonHandler MultiplyBHandler = new MultiplyButtonHandler();
    private DivideButtonHandler DivideBHandler = new DivideButtonHandler();
    private EqualsButtonHandler EqualsBHandler = new EqualsButtonHandler();
    private BackSpaceButtonHandler BackSpaceBHandler = new BackSpaceButtonHandler();
    private ClearEntryButtonHandler ClearEntryBHandler = new ClearEntryButtonHandler();
    private ClearSubTotalButtonHandler ClearSubTotalBHandler = new ClearSubTotalButtonHandler();
    private ClearAllButtonHandler ClearAllBHandler = new ClearAllButtonHandler();
    private SignChangeButtonHandler SignChangeBHandler = new SignChangeButtonHandler();
    private SquaredButtonHandler SquaredBHandler = new SquaredButtonHandler();
    private SquareRootButtonHandler SquareRootBHandler = new SquareRootButtonHandler();
    private PercentButtonHandler PercentBHandler = new PercentButtonHandler();
    private Mem1ButtonHandler Mem1BHandler = new Mem1ButtonHandler();
    private Mem1AddButtonHandler Mem1AddBHandler = new Mem1AddButtonHandler();
    private Mem1SubtractButtonHandler Mem1SubtractBHandler = new Mem1SubtractButtonHandler();
    private Mem1ClearButtonHandler Mem1ClearBHandler = new Mem1ClearButtonHandler();
    private Mem2ButtonHandler Mem2BHandler = new Mem2ButtonHandler();
    private Mem2AddButtonHandler Mem2AddBHandler = new Mem2AddButtonHandler();
    private Mem2SubtractButtonHandler Mem2SubtractBHandler = new Mem2SubtractButtonHandler();
    private Mem2ClearButtonHandler Mem2ClearBHandler = new Mem2ClearButtonHandler();
    //Create Generic Action Handler For Unavailable Features
    private UnavailableActionHandler UnavailableHandler = new UnavailableActionHandler();
    //Test Code
    private Test1ButtonHandler Test1BHandler = new Test1ButtonHandler();
    private Test2ButtonHandler Test2BHandler = new Test2ButtonHandler();
    private Test3ButtonHandler Test3BHandler = new Test3ButtonHandler();
    private Test4ButtonHandler Test4BHandler = new Test4ButtonHandler();
    private Test5ButtonHandler Test5BHandler = new Test5ButtonHandler();
    private Test6ButtonHandler Test6BHandler = new Test6ButtonHandler();
    private Test7ButtonHandler Test7BHandler = new Test7ButtonHandler();
    private Test8ButtonHandler Test8BHandler = new Test8ButtonHandler();
    //End Test
    //Accounting Action Handlers
    private SubTotalButtonHandler SubTotalBHandler = new SubTotalButtonHandler();
    private TotalButtonHandler TotalBHandler = new TotalButtonHandler();
    private TaxPlusButtonHandler TaxPlusBHandler = new TaxPlusButtonHandler();
    private TaxMinusButtonHandler TaxMinusBHandler = new TaxMinusButtonHandler();
    private SetTaxPlusButtonHandler SetTaxPlusBHandler = new SetTaxPlusButtonHandler();
    private SetTaxMinusButtonHandler SetTaxMinusBHandler = new SetTaxMinusButtonHandler();
    //Financial Action Handlers
    private PresentValueButtonHandler PresentValueBHandler = new PresentValueButtonHandler();
    private FutureValueButtonHandler FutureValueBHandler = new FutureValueButtonHandler();
    private MortgageCalcButtonHandler MortgageCalcBHandler = new MortgageCalcButtonHandler();
    //Algebra Action Handlers
    private XYPowerButtonHandler XYPowerBHandler = new XYPowerButtonHandler();
    private XYRootButtonHandler XYRootBHandler = new XYRootButtonHandler();
    private EXPowerButtonHandler EXPowerBHandler = new EXPowerButtonHandler();
    private NaturalLogButtonHandler NaturalLogBHandler = new NaturalLogButtonHandler();
    private TenXPowerButtonHandler TenXPowerBHandler = new TenXPowerButtonHandler();
    private LogarithmButtonHandler LogarithmBHandler = new LogarithmButtonHandler();
    //Trigonometry Action Handlers
    private SineButtonHandler SineBHandler = new SineButtonHandler();
    private CosineButtonHandler CosineBHandler = new CosineButtonHandler();
    private TangentButtonHandler TangentBHandler = new TangentButtonHandler();
    private ArcSineButtonHandler ArcSineBHandler = new ArcSineButtonHandler();
    private ArcCosineButtonHandler ArcCosineBHandler = new ArcCosineButtonHandler();
    private ArcTangentButtonHandler ArcTangentBHandler = new ArcTangentButtonHandler();

    public void Tape_Calculator() {
        SetSize();
        AddActionListeners();
        SetButtonSizes();
        SetButtonFonts();
        SetConfigs();
        BuildMenu();
        BuildScrollingTape();
        BuildTabbedPane();
        BuildTextArea();

        //Build Main GUI
        Main.GUI.setTitle();

        setSize(MainWidth, MainHeight);
        Container pane = getContentPane();

        pane.setLayout(null);

        //Set window to open in center of screen
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        //Add the menubar to GUI
        setJMenuBar(MenuBar);

        y = (Padding * 2);
        x = (Padding * 33);
        
        TapeTabs.setLocation(x, y);
        TapeTabs.setSize(TapeTabWidth, ScrollHeight);
        pane.add(TapeTabs);
        TapeTabs.addChangeListener(TapeChange);

        switch (Main.LIS.GetLicenseType()) {
            //case 66:
                //break;
            case 0:
            case 33:
            case 66:
            case 99:
                x = (Padding * 2);
                y += (Padding + ScrollHeight);

                LogicGroup.add(AddingMachineRB);
                LogicGroup.add(StandardCalcRB);

                AddingMachineRB.setSize(RadioButtonWidth, RadioButtonHeight);
                AddingMachineRB.setFont(TabFont);
                AddingMachineRB.setLocation(x, y);
                pane.add(AddingMachineRB);

                y += ( RadioButtonHeight);

                StandardCalcRB.setSize(RadioButtonWidth, RadioButtonHeight);
                StandardCalcRB.setFont(TabFont);
                StandardCalcRB.setLocation(x, y);
                pane.add(StandardCalcRB);
                break;
        }
        //Test Code

        
        //y += ((Padding * 2) + RadioButtonHeight);

        TestB4.setLocation(x, y);
        //pane.add(TestB4);

        //y += ((Padding * 2) + SpecialButtonHeight);

        TestB5.setLocation(x, y);
        //pane.add(TestB5);

        //y += ((Padding * 2) + SpecialButtonHeight);

        TestB6.setLocation(x, y);
        //pane.add(TestB6);

        //y += ((Padding * 2) + SpecialButtonHeight);

        TestB7.setLocation(x, y);
        //pane.add(TestB7);

        //y += ((Padding * 2) + SpecialButtonHeight);

        TestB8.setLocation(x, y);
        //pane.add(TestB8);
        //End Test


        //Add Text Area to GUI
        //y = (ScrollHeight + (Padding * 3));
        //x = ((MainWidth - InputWidth) / 2);
        y-=(RadioButtonHeight - (Padding));
        x+=((Padding * 2) + RadioButtonWidth);
        DisplayText.setLocation(x, y);
        DisplayText.setFocusable(false);
        DisplayText.setEditable(true);
        pane.add(DisplayText);

        //Add Tabbed Pane to GUI
        x = Padding;
        y += (InputHeight + (2 * OpButtonHeight) + (Padding * 4));
        //y = (ScrollHeight + InputHeight + 2 * OpButtonHeight + (6 * Padding));
        tabs.setLocation(x, y);
        tabs.setSize(TabWidth, TabHeight);
        pane.add(tabs);

        //Add Buttons to GUI
        x = Padding * 2;
        y = (ScrollHeight + InputHeight + Padding * 6);

        BackSpaceB.setLocation(x, y);
        pane.add(BackSpaceB);

        NewSpecialColumn(1);

        ClearEntryB.setLocation(x, y);
        pane.add(ClearEntryB);


        x = Padding * 2;
        y = (ScrollHeight + InputHeight + Padding * 6);
        NewSpecialButton();

        ClearAllB.setLocation(x, y);
        pane.add(ClearAllB);

        NewSpecialColumn(1);

        ClearSubTotalB.setLocation(x, y);
        pane.add(ClearSubTotalB);


        x = (SpecialButtonWidth * 2 + Padding * 6);
        y = (ScrollHeight + InputHeight + Padding * 6);

        Mem1B.setLocation(x, y);
        pane.add(Mem1B);

        NewOpButton();

        Mem2B.setLocation(x, y);
        pane.add(Mem2B);

        NewOpButton();

        SevenB.setLocation(x, y);
        pane.add(SevenB);

        NewNumButton();

        FourB.setLocation(x, y);
        pane.add(FourB);

        NewNumButton();

        OneB.setLocation(x, y);
        pane.add(OneB);

        NewNumButton();

        ZeroB.setLocation(x, y);
        pane.add(ZeroB);

        NewOpColumn(6);

        Mem1AddB.setLocation(x, y);
        pane.add(Mem1AddB);

        NewOpButton();

        Mem2AddB.setLocation(x, y);
        pane.add(Mem2AddB);

        NewOpButton();

        EightB.setLocation(x, y);
        pane.add(EightB);

        NewNumButton();

        FiveB.setLocation(x, y);
        pane.add(FiveB);

        NewNumButton();

        TwoB.setLocation(x, y);
        pane.add(TwoB);

        NewNumButton();

        TwoZeroesB.setLocation(x, y);
        pane.add(TwoZeroesB);

        NewOpColumn(6);

        Mem1SubtractB.setLocation(x, y);
        pane.add(Mem1SubtractB);

        NewOpButton();

        Mem2SubtractB.setLocation(x, y);
        pane.add(Mem2SubtractB);

        NewOpButton();

        NineB.setLocation(x, y);
        pane.add(NineB);

        NewNumButton();

        SixB.setLocation(x, y);
        pane.add(SixB);

        NewNumButton();

        ThreeB.setLocation(x, y);
        pane.add(ThreeB);

        NewNumButton();

        DecimalB.setLocation(x, y);
        pane.add(DecimalB);

        NewOpColumn(6);

        Mem1ClearB.setLocation(x, y);
        pane.add(Mem1ClearB);

        NewOpButton();

        Mem2ClearB.setLocation(x, y);
        pane.add(Mem2ClearB);

        NewNumButton();

        SubtractB.setLocation(x, y);
        pane.add(SubtractB);

        NewNumButton();

        AddB.setLocation(x, y);
        pane.add(AddB);

        NewOpButton();
        NewOpButton();

        ThreeZeroesB.setLocation(x, y);
        pane.add(ThreeZeroesB);

        NewOpColumn(6);

        SquareRootB.setLocation(x, y);
        pane.add(SquareRootB);

        NewOpButton();

        SquaredB.setLocation(x, y);
        pane.add(SquaredB);

        NewOpButton();

        SignChangeB.setLocation(x, y);
        pane.add(SignChangeB);
        PercentB.setLocation(x, y);
        pane.add(PercentB);

        switch (Main.VAR.GetOpLogic(0)) {
            case 0:
                PercentB.setVisible(true);
                PercentB.setEnabled(true);
                ClearSubTotalB.setVisible(true);
                ClearSubTotalB.setEnabled(true);
                SignChangeB.setVisible(false);
                SignChangeB.setEnabled(false);
                break;
            case 1:
                PercentB.setVisible(false);
                PercentB.setEnabled(false);
                ClearSubTotalB.setVisible(false);
                ClearSubTotalB.setEnabled(false);
                SignChangeB.setVisible(true);
                SignChangeB.setEnabled(true);
                break;
        }

        NewOpButton();

        DivideB.setLocation(x, y);
        pane.add(DivideB);

        NewOpButton();

        MultiplyB.setLocation(x, y);
        pane.add(MultiplyB);

        NewOpButton();

        EqualsB.setLocation(x, y);
        pane.add(EqualsB);

        pane.addKeyListener(listener);

        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(wListener);

    }

    public void SetSize() {
        UserScreenHeight = (int) screenSize.getHeight();
        if (UserScreenHeight < 750) {
            Padding = 4;
        } else {
            Padding = 5;
        }
        MainHeight = Padding * 138;
        MainWidth = Padding * 108;
        OpButtonWidth = Padding * 12;
        OpButtonHeight = Padding * 6;
        NumButtonWidth = Padding * 12;
        NumButtonHeight = Padding * 6;
        SpecialButtonWidth = Padding * 17;
        SpecialButtonHeight = Padding * 6;
        TestButtonWidth = Padding * 21;
        TestButtonHeight = Padding * 6;
        TabWidth = Padding * 38;
        TabHeight = Padding * 28;
        TapeWidth = Padding * 60;
        TapeHeight = Padding * 50;
        ScrollWidth = Padding * 60;//60;
        TapeTabWidth = Padding * 70;//70;
        ScrollHeight = Padding * 70;
        MaxUserInput = Padding * 6;
        InputHeight = Padding * 6;
        InputWidth = Padding * 63;//84;
        RadioButtonHeight = Padding * 4;
        RadioButtonWidth = Padding * 37;
    }

    public void AddActionListeners() {

        //Add Action Listeners for Menu Items
        NewAction.addActionListener(NewActHandler);
        AboutAction.addActionListener(AboutActHandler);
        HelpAction.addActionListener(HelpActHandler);
        LicenseAction.addActionListener(LicenseActHandler);
        switch (Main.LIS.GetLicenseType()) {
            case 0:
                OpenAction.addActionListener(UnavailableHandler);
                OpenInTabAction.addActionListener(UnavailableHandler);
                SaveAction.addActionListener(UnavailableHandler);
                SaveAsAction.addActionListener(UnavailableHandler);
                ReOpenAction.addActionListener(UnavailableHandler);
                EditSubTotalsAction.addActionListener(UnavailableHandler);
                PreferencesAction.addActionListener(UnavailableHandler);
                LoadDefaultPreferencesAction.addActionListener(UnavailableHandler);
                LoadUserPreferencesAction.addActionListener(UnavailableHandler);
                SavePreferencesAction.addActionListener(UnavailableHandler);
                DefaultSaveToAction.addActionListener(UnavailableHandler);
                DefaultFileExtensionAction.addActionListener(UnavailableHandler);
                break;
            case 66:
            case 33:
            case 99:
                OpenAction.addActionListener(OpenActHandler);
                OpenInTabAction.addActionListener(OpenInTabActHandler);
                SaveAction.addActionListener(SaveActHandler);
                SaveAsAction.addActionListener(SaveAsActHandler);
                ReOpenAction.addActionListener(ReOpenActHandler);
                EditSubTotalsAction.addActionListener(EditSubTotalsActHandler);
                PreferencesAction.addActionListener(PreferencesActHandler);
                LoadDefaultPreferencesAction.addActionListener(LoadDefaultPreferencesActHandler);
                LoadUserPreferencesAction.addActionListener(LoadUserPreferencesActHandler);
                SavePreferencesAction.addActionListener(SavePreferencesActHandler);
                DefaultSaveToAction.addActionListener(DefaultSaveToActHandler);
                DefaultFileExtensionAction.addActionListener(DefaultFileExtensionActHandler);
                break;
        }

        NewAction.addKeyListener(listener);
        OpenAction.addKeyListener(listener);
        OpenInTabAction.addKeyListener(listener);
        SaveAction.addKeyListener(listener);
        SaveAsAction.addKeyListener(listener);
        CloseAction.addActionListener(CloseActHandler);
        CloseAction.addKeyListener(listener);
        ReOpenAction.addKeyListener(listener);
        ExitAction.addActionListener(ExitActHandler);
        ExitAction.addKeyListener(listener);
        EditSubTotalsAction.addKeyListener(listener);
        PreferencesAction.addKeyListener(listener);
        LoadDefaultPreferencesAction.addKeyListener(listener);
        LoadUserPreferencesAction.addKeyListener(listener);
        SavePreferencesAction.addKeyListener(listener);
        DefaultSaveToAction.addKeyListener(listener);
        DefaultFileExtensionAction.addKeyListener(listener);
        AboutAction.addKeyListener(listener);
        HelpAction.addKeyListener(listener);
        LicenseAction.addKeyListener(listener);

        //Add Action Listeners for Button Click Events
        ZeroB.addActionListener(ZeroBHandler);
        ZeroB.addKeyListener(listener);
        OneB.addActionListener(OneBHandler);
        OneB.addKeyListener(listener);
        TwoB.addActionListener(TwoBHandler);
        TwoB.addKeyListener(listener);
        ThreeB.addActionListener(ThreeBHandler);
        ThreeB.addKeyListener(listener);
        FourB.addActionListener(FourBHandler);
        FourB.addKeyListener(listener);
        FiveB.addActionListener(FiveBHandler);
        FiveB.addKeyListener(listener);
        SixB.addActionListener(SixBHandler);
        SixB.addKeyListener(listener);
        SevenB.addActionListener(SevenBHandler);
        SevenB.addKeyListener(listener);
        EightB.addActionListener(EightBHandler);
        EightB.addKeyListener(listener);
        NineB.addActionListener(NineBHandler);
        NineB.addKeyListener(listener);
        TwoZeroesB.addActionListener(TwoZeroesBHandler);
        TwoZeroesB.addKeyListener(listener);
        ThreeZeroesB.addActionListener(ThreeZeroesBHandler);
        ThreeZeroesB.addKeyListener(listener);
        DecimalB.addActionListener(DecimalBHandler);
        DecimalB.addKeyListener(listener);
        AddB.addActionListener(AddBHandler);
        AddB.addKeyListener(listener);
        SubtractB.addActionListener(SubtractBHandler);
        SubtractB.addKeyListener(listener);
        MultiplyB.addActionListener(MultiplyBHandler);
        MultiplyB.addKeyListener(listener);
        DivideB.addActionListener(DivideBHandler);
        DivideB.addKeyListener(listener);
        EqualsB.addActionListener(EqualsBHandler);
        EqualsB.addKeyListener(listener);
        BackSpaceB.addActionListener(BackSpaceBHandler);
        BackSpaceB.addKeyListener(listener);
        ClearEntryB.addActionListener(ClearEntryBHandler);
        ClearEntryB.addKeyListener(listener);
        ClearSubTotalB.addActionListener(ClearSubTotalBHandler);
        ClearSubTotalB.addKeyListener(listener);
        ClearAllB.addActionListener(ClearAllBHandler);
        ClearAllB.addKeyListener(listener);
        SignChangeB.addActionListener(SignChangeBHandler);
        SignChangeB.addKeyListener(listener);
        SquaredB.addActionListener(SquaredBHandler);
        SquaredB.addKeyListener(listener);
        SquareRootB.addActionListener(SquareRootBHandler);
        SquareRootB.addKeyListener(listener);
        PercentB.addActionListener(PercentBHandler);
        PercentB.addKeyListener(listener);
        Mem1B.addActionListener(Mem1BHandler);
        Mem1B.addKeyListener(listener);
        Mem1AddB.addActionListener(Mem1AddBHandler);
        Mem1AddB.addKeyListener(listener);
        Mem1SubtractB.addActionListener(Mem1SubtractBHandler);
        Mem1SubtractB.addKeyListener(listener);
        Mem1ClearB.addActionListener(Mem1ClearBHandler);
        Mem1ClearB.addKeyListener(listener);
        Mem2B.addActionListener(Mem2BHandler);
        Mem2B.addKeyListener(listener);
        Mem2AddB.addActionListener(Mem2AddBHandler);
        Mem2AddB.addKeyListener(listener);
        Mem2SubtractB.addActionListener(Mem2SubtractBHandler);
        Mem2SubtractB.addKeyListener(listener);
        Mem2ClearB.addActionListener(Mem2ClearBHandler);
        Mem2ClearB.addKeyListener(listener);
        SubTotalB.addActionListener(SubTotalBHandler);
        SubTotalB.addKeyListener(listener);
        TotalB.addActionListener(TotalBHandler);
        TotalB.addKeyListener(listener);
        TaxPlusB.addActionListener(TaxPlusBHandler);
        TaxPlusB.addKeyListener(listener);
        TaxMinusB.addActionListener(TaxMinusBHandler);
        TaxMinusB.addKeyListener(listener);

        switch (Main.LIS.GetLicenseType()) {
            case 0:
                SetTaxPlusB.addActionListener(UnavailableHandler);
                SetTaxMinusB.addActionListener(UnavailableHandler);
                break;
            case 66:
            case 33:
            case 99:
                SetTaxPlusB.addActionListener(SetTaxPlusBHandler);
                SetTaxMinusB.addActionListener(SetTaxMinusBHandler);
                break;
        }

        SetTaxPlusB.addKeyListener(listener);
        SetTaxMinusB.addKeyListener(listener);
        //TestCode
        TestB4.addActionListener(Test4BHandler);
        TestB4.addKeyListener(listener);
        TestB5.addActionListener(Test5BHandler);
        TestB5.addKeyListener(listener);
        TestB6.addActionListener(Test6BHandler);
        TestB6.addKeyListener(listener);
        TestB7.addActionListener(Test7BHandler);
        TestB7.addKeyListener(listener);
        TestB8.addActionListener(Test8BHandler);
        TestB8.addKeyListener(listener);

        switch (Main.LIS.GetLicenseType()) {
            case 0:
                PresentValueB.addActionListener(UnavailableHandler);
                FutureValueB.addActionListener(UnavailableHandler);
                MortgageCalcB.addActionListener(UnavailableHandler);
                XYPowerB.addActionListener(UnavailableHandler);
                XYRootB.addActionListener(UnavailableHandler);
                EXPowerB.addActionListener(UnavailableHandler);
                NaturalLogB.addActionListener(UnavailableHandler);
                TenXPowerB.addActionListener(UnavailableHandler);
                LogarithmB.addActionListener(UnavailableHandler);
                SineB.addActionListener(UnavailableHandler);
                CosineB.addActionListener(UnavailableHandler);
                TangentB.addActionListener(UnavailableHandler);
                ArcSineB.addActionListener(UnavailableHandler);
                ArcCosineB.addActionListener(UnavailableHandler);
                ArcTangentB.addActionListener(UnavailableHandler);
                break;
            case 66:
            case 33:
            case 99:
                PresentValueB.addActionListener(PresentValueBHandler);
                FutureValueB.addActionListener(FutureValueBHandler);
                MortgageCalcB.addActionListener(MortgageCalcBHandler);
                XYPowerB.addActionListener(XYPowerBHandler);
                XYRootB.addActionListener(XYRootBHandler);
                EXPowerB.addActionListener(EXPowerBHandler);
                NaturalLogB.addActionListener(NaturalLogBHandler);
                TenXPowerB.addActionListener(TenXPowerBHandler);
                LogarithmB.addActionListener(LogarithmBHandler);
                SineB.addActionListener(SineBHandler);
                CosineB.addActionListener(CosineBHandler);
                TangentB.addActionListener(TangentBHandler);
                ArcSineB.addActionListener(ArcSineBHandler);
                ArcCosineB.addActionListener(ArcCosineBHandler);
                ArcTangentB.addActionListener(ArcTangentBHandler);
                break;
        }
        PresentValueB.addKeyListener(listener);
        FutureValueB.addKeyListener(listener);
        MortgageCalcB.addKeyListener(listener);
        XYPowerB.addKeyListener(listener);
        XYRootB.addKeyListener(listener);
        EXPowerB.addKeyListener(listener);
        NaturalLogB.addKeyListener(listener);
        TenXPowerB.addKeyListener(listener);
        LogarithmB.addKeyListener(listener);
        SineB.addKeyListener(listener);
        CosineB.addKeyListener(listener);
        TangentB.addKeyListener(listener);
        ArcSineB.addKeyListener(listener);
        ArcCosineB.addKeyListener(listener);
        ArcTangentB.addKeyListener(listener);
        //End Test
        tabs.addKeyListener(listener);
        TapeTabs.addKeyListener(listener);
        AddingMachineRB.addActionListener(LogicChange);
        AddingMachineRB.addKeyListener(listener);
        StandardCalcRB.addActionListener(LogicChange);
        StandardCalcRB.addKeyListener(listener);
    }

    public void SetButtonSizes() {
        //Set Button Sizes
        ZeroB.setSize(NumButtonWidth, NumButtonHeight);
        OneB.setSize(NumButtonWidth, NumButtonHeight);
        TwoB.setSize(NumButtonWidth, NumButtonHeight);
        ThreeB.setSize(NumButtonWidth, NumButtonHeight);
        FourB.setSize(NumButtonWidth, NumButtonHeight);
        FiveB.setSize(NumButtonWidth, NumButtonHeight);
        SixB.setSize(NumButtonWidth, NumButtonHeight);
        SevenB.setSize(NumButtonWidth, NumButtonHeight);
        EightB.setSize(NumButtonWidth, NumButtonHeight);
        NineB.setSize(NumButtonWidth, NumButtonHeight);
        TwoZeroesB.setSize(NumButtonWidth, NumButtonHeight);
        ThreeZeroesB.setSize(NumButtonWidth, NumButtonHeight);
        DecimalB.setSize(OpButtonWidth, OpButtonHeight);
        AddB.setSize(OpButtonWidth, OpButtonHeight * 2 + Padding);
        SubtractB.setSize(OpButtonWidth, OpButtonHeight);
        MultiplyB.setSize(OpButtonWidth, OpButtonHeight);
        DivideB.setSize(OpButtonWidth, OpButtonHeight);
        EqualsB.setSize(OpButtonWidth, OpButtonHeight);
        BackSpaceB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ClearEntryB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ClearSubTotalB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ClearAllB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        SignChangeB.setSize(OpButtonWidth, OpButtonHeight);
        PercentB.setSize(OpButtonWidth, OpButtonHeight);
        SquaredB.setSize(OpButtonWidth, OpButtonHeight);
        SquareRootB.setSize(OpButtonWidth, OpButtonHeight);
        Mem1B.setSize(OpButtonWidth, OpButtonHeight);
        Mem1AddB.setSize(OpButtonWidth, OpButtonHeight);
        Mem1SubtractB.setSize(OpButtonWidth, OpButtonHeight);
        Mem1ClearB.setSize(OpButtonWidth, OpButtonHeight);
        Mem2B.setSize(OpButtonWidth, OpButtonHeight);
        Mem2AddB.setSize(OpButtonWidth, OpButtonHeight);
        Mem2SubtractB.setSize(OpButtonWidth, OpButtonHeight);
        Mem2ClearB.setSize(OpButtonWidth, OpButtonHeight);
        SubTotalB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        TotalB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        TaxPlusB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        TaxMinusB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        SetTaxPlusB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        SetTaxMinusB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        //Test Code
        TestB4.setSize(TestButtonWidth, TestButtonHeight);
        TestB5.setSize(TestButtonWidth, TestButtonHeight);
        TestB6.setSize(TestButtonWidth, TestButtonHeight);
        TestB7.setSize(TestButtonWidth, TestButtonHeight);
        TestB8.setSize(TestButtonWidth, TestButtonHeight);
        //End Test
        PresentValueB.setSize((SpecialButtonWidth * 2 + Padding), SpecialButtonHeight);
        FutureValueB.setSize((SpecialButtonWidth * 2 + Padding), SpecialButtonHeight);
        MortgageCalcB.setSize((SpecialButtonWidth * 2 + Padding), SpecialButtonHeight);
        XYPowerB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        XYRootB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        EXPowerB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        NaturalLogB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        TenXPowerB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        LogarithmB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        SineB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        CosineB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        TangentB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ArcSineB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ArcCosineB.setSize(SpecialButtonWidth, SpecialButtonHeight);
        ArcTangentB.setSize(SpecialButtonWidth, SpecialButtonHeight);
    }

    public void SetButtonFonts() {
        UserScreenHeight = (int) screenSize.getHeight();
        if (Padding == 4) {
            ButtonFont = SmallButtonFont;
            SpecialButtonFont = SmallSpecialButtonFont;
            TabFont = SmallTabFont;
            TapeTabFont = SmallTapeTabFont;
            DisplayFont = SmallDisplayFont;
        } else {
            ButtonFont = LargeButtonFont;
            SpecialButtonFont = LargeSpecialButtonFont;
            TabFont = LargeTabFont;
            TapeTabFont = LargeTapeTabFont;
            DisplayFont = LargeDisplayFont;
        }
    }

    public void BuildMenu() {
        //Build Menu
        //Add drop down menus to the menubar
        MenuBar.add(FileMenu);
        MenuBar.add(EditMenu);
        MenuBar.add(SettingsMenu);
        MenuBar.add(HelpMenu);

        //Add Items to File menu, Edit menu, and Help menu
        FileMenu.add(NewAction);
        FileMenu.add(OpenAction);
        FileMenu.add(OpenInTabAction);
        FileMenu.add(SaveAction);
        FileMenu.add(SaveAsAction);
        FileMenu.addSeparator();
        FileMenu.add(CloseAction);
        FileMenu.add(ReOpenAction);
        FileMenu.addSeparator();
        FileMenu.add(ExitAction);
        EditMenu.add(EditSubTotalsAction);
        SettingsMenu.add(PreferencesAction);
        SettingsMenu.add(SavePreferencesAction);
        SettingsMenu.add(LoadUserPreferencesAction);
        SettingsMenu.add(LoadDefaultPreferencesAction);
        SettingsMenu.addSeparator();
        SettingsMenu.add(DefaultSaveToAction);
        SettingsMenu.add(DefaultFileExtensionAction);
        HelpMenu.add(HelpAction);
        HelpMenu.add(LicenseAction);
        HelpMenu.addSeparator();
        HelpMenu.add(AboutAction);
    }

    public void BuildScrollingTape() {
        //Build Scrolling Pane
        TapeTabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TapeTabs.setFont(TapeTabFont);
        TapeArray = new JTextArea[20];
        ScrollingTapeArray = new JScrollPane[20];

        for (int i = 0; i < 20; i++) {
            TapeArray[i] = new JTextArea();
            TapeArray[i].setSize(TapeWidth, TapeHeight);
            ScrollingTapeArray[i] = new JScrollPane(TapeArray[i]);
            ScrollingTapeArray[i].setSize(ScrollWidth, ScrollHeight);
            ScrollingTapeArray[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            TapeArray[i].setEditable(false);
            TapeArray[i].setLineWrap(true);
            TapeArray[i].setFont(DisplayFont);
            TapeArray[i].setAlignmentX(RIGHT_ALIGNMENT);
            TapeArray[i].addKeyListener(listener);
            ScrollingTapeArray[i].addKeyListener(listener);
            if (i == 0) {
                TapeTabs.addTab("    Untitled", ScrollingTapeArray[i]);
            }
        }
        Main.VAR.SetTabTitle(0, Main.VAR.FormatTabTitle(Main.VAR.GetFileName(0)));
        setTape(0, Main.VAR.GetTapeStr(0));
    }

    public void BuildTabbedPane() {
        //Build Tabbed Pane
        tabs.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabs.setFont(TabFont);

        //Build AccountingPanel  (Accounting Buttons)
        AccountingPanel.setLayout(null);
        x = Padding;
        y = Padding;

        SubTotalB.setLocation(x, y);
        AccountingPanel.add(SubTotalB);

        NewSpecialButton();

        TaxPlusB.setLocation(x, y);
        AccountingPanel.add(TaxPlusB);

        NewSpecialButton();

        SetTaxPlusB.setLocation(x, y);
        AccountingPanel.add(SetTaxPlusB);

        NewSpecialColumn(3);

        TotalB.setLocation(x, y);
        AccountingPanel.add(TotalB);

        NewSpecialButton();

        TaxMinusB.setLocation(x, y);
        AccountingPanel.add(TaxMinusB);

        NewSpecialButton();

        SetTaxMinusB.setLocation(x, y);
        AccountingPanel.add(SetTaxMinusB);

        //Build FinancialPanel (Financial Buttons)
        FinancialPanel.setLayout(null);
        x = Padding;
        y = Padding;

        PresentValueB.setLocation(x, y);
        FinancialPanel.add(PresentValueB);

        NewSpecialButton();

        FutureValueB.setLocation(x, y);
        FinancialPanel.add(FutureValueB);

        NewSpecialButton();

        MortgageCalcB.setLocation(x, y);
        FinancialPanel.add(MortgageCalcB);


        //Build AlgebraPanel (Algebra Buttons)
        AlgebraPanel.setLayout(null);
        x = Padding;
        y = Padding;

        XYPowerB.setLocation(x, y);
        AlgebraPanel.add(XYPowerB);

        NewSpecialButton();

        TenXPowerB.setLocation(x, y);
        AlgebraPanel.add(TenXPowerB);

        NewSpecialButton();

        EXPowerB.setLocation(x, y);
        AlgebraPanel.add(EXPowerB);

        NewSpecialColumn(3);

        XYRootB.setLocation(x, y);
        AlgebraPanel.add(XYRootB);

        NewSpecialButton();

        LogarithmB.setLocation(x, y);
        AlgebraPanel.add(LogarithmB);

        NewSpecialButton();

        NaturalLogB.setLocation(x, y);
        AlgebraPanel.add(NaturalLogB);


        //Build TrigPanel (Trigonometry Buttons)
        TrigPanel.setLayout(null);
        x = Padding;
        y = Padding;

        SineB.setLocation(x, y);
        TrigPanel.add(SineB);

        NewSpecialButton();

        CosineB.setLocation(x, y);
        TrigPanel.add(CosineB);

        NewSpecialButton();

        TangentB.setLocation(x, y);
        TrigPanel.add(TangentB);

        NewSpecialColumn(3);

        ArcSineB.setLocation(x, y);
        TrigPanel.add(ArcSineB);

        NewSpecialButton();

        ArcCosineB.setLocation(x, y);
        TrigPanel.add(ArcCosineB);

        NewSpecialButton();

        ArcTangentB.setLocation(x, y);
        TrigPanel.add(ArcTangentB);

        //Add Panels to Tab
        int activeTape = getActiveTape();
        switch (Main.VAR.GetOpLogic(activeTape)) {
            case 0:
                tabs.removeAll();
                tabs.addTab("Accounting", AccountingPanel);
                tabs.addTab("Financial", FinancialPanel);
                break;
            case 1:
                tabs.removeAll();
                tabs.addTab("Algebra", AlgebraPanel);
                tabs.addTab("Trig", TrigPanel);
                tabs.addTab("Financial", FinancialPanel);
        }
    }

    public void BuildTextArea() {
        //Build Text Area
        DisplayText.setSize(InputWidth, InputHeight);
        DisplayText.setColumns(MaxUserInput);
        DisplayText.setHorizontalAlignment(DisplayText.RIGHT);
        DisplayText.setFont(DisplayFont);
        DisplayText.setEditable(false);
        DisplayText.addKeyListener(listener);
    }

    public void NewNumButton() {
        y += (NumButtonHeight + Padding);
    }

    public void NewNumColumn(int Count) {
        x += (NumButtonWidth + Padding);
        y -= ((NumButtonHeight + Padding) * (Count - 1));
    }

    public void NewOpButton() {
        y += (OpButtonHeight + Padding);
    }

    public void NewOpColumn(int Count) {
        x += (OpButtonWidth + Padding);
        y -= ((OpButtonHeight + Padding) * (Count - 1));
    }

    public void NewSpecialButton() {
        y += (SpecialButtonHeight + Padding);
    }

    public void NewSpecialColumn(int Count) {
        x += (SpecialButtonWidth + Padding);
        y -= ((SpecialButtonHeight + Padding) * (Count - 1));


    }

    public void SetConfigs() {

        //Set Logic Selection
        switch (Main.VAR.GetOpLogic(0)) {
            case 0:
                AddingMachineRB.setSelected(true);
                break;
            case 1:
                StandardCalcRB.setSelected(true);
                break;
        }

        NewFont = new Font(Main.CFG.GetDisplayFontString(), Font.BOLD, 12);
        DisplayText.setFont(NewFont);

        //Set Scrolling Tape

        //Set Standard Buttons Fonts
        ZeroB.setFont(ButtonFont);
        OneB.setFont(ButtonFont);
        TwoB.setFont(ButtonFont);
        ThreeB.setFont(ButtonFont);
        FourB.setFont(ButtonFont);
        FiveB.setFont(ButtonFont);
        SixB.setFont(ButtonFont);
        SevenB.setFont(ButtonFont);
        EightB.setFont(ButtonFont);
        NineB.setFont(ButtonFont);
        TwoZeroesB.setFont(ButtonFont);
        ThreeZeroesB.setFont(ButtonFont);
        DecimalB.setFont(ButtonFont);
        AddB.setFont(ButtonFont);
        SubtractB.setFont(ButtonFont);
        MultiplyB.setFont(ButtonFont);
        DivideB.setFont(ButtonFont);
        EqualsB.setFont(ButtonFont);
        SignChangeB.setFont(ButtonFont);
        SquaredB.setFont(ButtonFont);
        SquareRootB.setFont(ButtonFont);
        PercentB.setFont(ButtonFont);
        //Test Code
        Font TestFont = new Font(Main.CFG.GetMemoryFontString(), Font.BOLD, 10);
        TestB4.setFont(TestFont);
        TestB5.setFont(TestFont);
        TestB6.setFont(TestFont);
        TestB7.setFont(TestFont);
        TestB8.setFont(TestFont);
        //End Test

        //Set Memory Buttons
        NewFont = new Font(Main.CFG.GetMemoryFontString(), Font.BOLD, Main.CFG.GetMemoryFontSize());
        Mem1B.setFont(NewFont);
        Mem1AddB.setFont(NewFont);
        Mem1SubtractB.setFont(NewFont);
        Mem1ClearB.setFont(NewFont);
        Mem2B.setFont(NewFont);
        Mem2AddB.setFont(NewFont);
        Mem2SubtractB.setFont(NewFont);
        Mem2ClearB.setFont(NewFont);;
        Mem1B.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem1AddB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem1SubtractB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem1ClearB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem2B.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem2AddB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem2SubtractB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem2ClearB.setBackground(Main.CFG.GetMemoryButtonColor());
        Mem1B.setForeground(Main.CFG.GetMemoryFontColor());
        Mem1AddB.setForeground(Main.CFG.GetMemoryFontColor());
        Mem1SubtractB.setForeground(Main.CFG.GetMemoryFontColor());
        Mem1ClearB.setForeground(Main.CFG.GetMemoryFontColor());
        Mem2B.setForeground(Main.CFG.GetMemoryFontColor());
        Mem2AddB.setForeground(Main.CFG.GetMemoryFontColor());
        Mem2SubtractB.setForeground(Main.CFG.GetMemoryFontColor());
        Mem2ClearB.setForeground(Main.CFG.GetMemoryFontColor());

        //Set Edit Buttons
        NewFont = new Font(Main.CFG.GetEditFontString(), Font.BOLD, Main.CFG.GetEditFontSize());
        BackSpaceB.setFont(NewFont);
        ClearEntryB.setFont(NewFont);
        ClearSubTotalB.setFont(NewFont);
        ClearAllB.setFont(NewFont);
        BackSpaceB.setBackground(Main.CFG.GetEditButtonColor());
        ClearEntryB.setBackground(Main.CFG.GetEditButtonColor());
        ClearSubTotalB.setBackground(Main.CFG.GetEditButtonColor());
        ClearAllB.setBackground(Main.CFG.GetEditButtonColor());
        BackSpaceB.setForeground(Main.CFG.GetEditFontColor());
        ClearEntryB.setForeground(Main.CFG.GetEditFontColor());
        ClearSubTotalB.setForeground(Main.CFG.GetEditFontColor());
        ClearAllB.setForeground(Main.CFG.GetEditFontColor());

        //Set Accounting Buttons
        NewFont = new Font(Main.CFG.GetAccountingFontString(), Font.BOLD, Main.CFG.GetAccountingFontSize());
        SubTotalB.setFont(NewFont);
        TotalB.setFont(NewFont);
        TaxPlusB.setFont(NewFont);
        TaxMinusB.setFont(NewFont);
        SetTaxPlusB.setFont(NewFont);
        SetTaxMinusB.setFont(NewFont);

        SubTotalB.setForeground(Main.CFG.GetAccountingFontColor());
        TotalB.setForeground(Main.CFG.GetAccountingFontColor());
        TaxPlusB.setForeground(Main.CFG.GetAccountingFontColor());
        TaxMinusB.setForeground(Main.CFG.GetAccountingFontColor());
        SetTaxPlusB.setForeground(Main.CFG.GetAccountingFontColor());
        SetTaxMinusB.setForeground(Main.CFG.GetAccountingFontColor());

        SubTotalB.setBackground(Main.CFG.GetAccountingButtonColor());
        TotalB.setBackground(Main.CFG.GetAccountingButtonColor());
        TaxPlusB.setBackground(Main.CFG.GetAccountingButtonColor());
        TaxMinusB.setBackground(Main.CFG.GetAccountingButtonColor());
        SetTaxPlusB.setBackground(Main.CFG.GetAccountingButtonColor());
        SetTaxMinusB.setBackground(Main.CFG.GetAccountingButtonColor());

        //Set Financial Buttons
        NewFont = new Font(Main.CFG.GetFinancialFontString(), Font.BOLD, Main.CFG.GetFinancialFontSize());
        PresentValueB.setFont(NewFont);
        FutureValueB.setFont(NewFont);
        MortgageCalcB.setFont(NewFont);
        PresentValueB.setForeground(Main.CFG.GetFinancialFontColor());
        FutureValueB.setForeground(Main.CFG.GetFinancialFontColor());
        MortgageCalcB.setForeground(Main.CFG.GetFinancialFontColor());
        PresentValueB.setBackground(Main.CFG.GetFinancialButtonColor());
        FutureValueB.setBackground(Main.CFG.GetFinancialButtonColor());
        MortgageCalcB.setBackground(Main.CFG.GetFinancialButtonColor());

        //Set Algebra Buttons
        NewFont = new Font(Main.CFG.GetAlgebraFontString(), Font.BOLD, Main.CFG.GetAlgebraFontSize());
        XYPowerB.setFont(NewFont);
        XYRootB.setFont(NewFont);
        EXPowerB.setFont(NewFont);
        NaturalLogB.setFont(NewFont);
        TenXPowerB.setFont(NewFont);
        LogarithmB.setFont(NewFont);
        XYPowerB.setForeground(Main.CFG.GetAlgebraFontColor());
        XYRootB.setForeground(Main.CFG.GetAlgebraFontColor());
        EXPowerB.setForeground(Main.CFG.GetAlgebraFontColor());
        NaturalLogB.setForeground(Main.CFG.GetAlgebraFontColor());
        TenXPowerB.setForeground(Main.CFG.GetAlgebraFontColor());
        LogarithmB.setForeground(Main.CFG.GetAlgebraFontColor());
        XYPowerB.setBackground(Main.CFG.GetAlgebraButtonColor());
        XYRootB.setBackground(Main.CFG.GetAlgebraButtonColor());
        EXPowerB.setBackground(Main.CFG.GetAlgebraButtonColor());
        NaturalLogB.setBackground(Main.CFG.GetAlgebraButtonColor());
        TenXPowerB.setBackground(Main.CFG.GetAlgebraButtonColor());
        LogarithmB.setBackground(Main.CFG.GetAlgebraButtonColor());

        //Set Trig Buttons
        NewFont = new Font(Main.CFG.GetTrigFontString(), Font.BOLD, Main.CFG.GetTrigFontSize());
        SineB.setFont(NewFont);
        CosineB.setFont(NewFont);
        TangentB.setFont(NewFont);
        ArcSineB.setFont(NewFont);
        ArcCosineB.setFont(NewFont);
        ArcTangentB.setFont(NewFont);
        SineB.setForeground(Main.CFG.GetTrigFontColor());
        CosineB.setForeground(Main.CFG.GetTrigFontColor());
        TangentB.setForeground(Main.CFG.GetTrigFontColor());
        ArcSineB.setForeground(Main.CFG.GetTrigFontColor());
        ArcCosineB.setForeground(Main.CFG.GetTrigFontColor());
        ArcTangentB.setForeground(Main.CFG.GetTrigFontColor());
        SineB.setBackground(Main.CFG.GetTrigButtonColor());
        CosineB.setBackground(Main.CFG.GetTrigButtonColor());
        TangentB.setBackground(Main.CFG.GetTrigButtonColor());
        ArcSineB.setBackground(Main.CFG.GetTrigButtonColor());
        ArcCosineB.setBackground(Main.CFG.GetTrigButtonColor());
        ArcTangentB.setBackground(Main.CFG.GetTrigButtonColor());
    }

    public void setTitle() {
        switch (Main.OS.GetOS()) {
            case 0:
                title = "Win10 - ";
                break;
            case 1:
                title = "Mac10 - ";
                break;
            case 2:
                title = "Lin10 - ";
                break;
        }

        switch (Main.LIS.GetLicenseType()) {
            case 0:
                title = title + "Free Version";
                break;
            case 33:
                title = title + "Trial Version";
                break;
            case 66:
                title = title + "Adding Machine Version";
                break;
            case 99:
                title = title + "Full Version";
                break;
        }

        setTitle(title);
    }
    //Action Event Handlers for Menu Items

    public class NewActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.NewTape(true);
        }
    }

    public class OpenActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.OpenTape();
        }
    }

    public class OpenInTabActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.OpenTapeInTab();
        }
    }

    public class SaveActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            int activeTape = getActiveTape();
            try {
                MenuOperations.SaveTape(activeTape);
            } catch (java.io.FileNotFoundException aeRef) {
                ErrorMessages.FileNotFound(Main.VAR.GetFullFileName(activeTape));
            }
        }
    }

    public class SaveAsActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.SaveAs();
        }
    }

    public class CloseActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.CloseTape();
        }
    }

    public class ReOpenActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            int openTapes = Main.VAR.GetTabs();
            int closedTapes = Main.VAR.GetClosedTabs();
            if (closedTapes == 0) {
                ErrorMessages.NoClosedTabs();
            } else {
                if (openTapes == 20) {
                    ErrorMessages.MaximumTabs();
                } else {
                    ReOpenTape reOpen = new ReOpenTape();
                    reOpen.setVisible(true);
                }
            }
        }
    }

    public class ExitActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            MenuOperations.Close();
        }
    }

    public class EditSubTotalsActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            int subTotals = Main.VAR.GetIndexJ(getActiveTape());
            ChooseSubTotal edit = new ChooseSubTotal();
            edit.setVisible(true);
            edit.ChooseSubTotal();
            /*
             * int closedTapes = Main.VAR.GetClosedTabs(); if (closedTapes == 0)
             * { ErrorMessages.NoClosedTabs(); } else { if (openTapes == 20) {
             * ErrorMessages.MaximumTabs(); } else { ReOpenTape reOpen = new
             * ReOpenTape(); reOpen.setVisible(true); } }
             *
             */
        }
    }

    public class PreferencesActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            ConfigurationGUI config = new ConfigurationGUI();
            config.setVisible(true);
        }
    }

    public class LoadDefaultPreferencesActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            String savePath = Main.filePath.substring(0, Main.filePath.indexOf("Files"));
            if (UserScreenHeight < 750) {
                Main.CFG.SetDefaultFileType(".txt");
                Main.CFG.SetDefaultSaveLocation(savePath + "SavedData/");
                MenuOperations.LoadSmallDefaultConfiguration();
                SetConfigs();
            } else {
                Main.CFG.SetDefaultFileType(".txt");
                Main.CFG.SetDefaultSaveLocation(savePath + "SavedData/");
                MenuOperations.LoadDefaultConfiguration();
                SetConfigs();
            }
        }
    }

    public class LoadUserPreferencesActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            try {
                MenuOperations.LoadUserConfiguration();
            } catch (java.io.FileNotFoundException aeRef) {
            }
            SetConfigs();
        }
    }

    public class SavePreferencesActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            try {
                MenuOperations.SaveUserConfiguration();
                InformationMessages.ConfigurationSaved();
            } catch (java.io.FileNotFoundException aeRef) {
                ErrorMessages.FileNotFound("UserConfiguration.cfg");
            }
        }
    }

    public class DefaultSaveToActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            Main.CFG.SetDefaultSaveLocation();
        }
    }

    public class DefaultFileExtensionActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            String option = "No Selection";
            String selection = "No Default";
            String[] FileTypes = new String[]{"Text File", "Rich Text Format", "Excel Spreadsheet"};


            if (Main.CFG.GetDefaultFileType().equalsIgnoreCase(".txt")) {
                selection = "Text File";
            } else if (Main.CFG.GetDefaultFileType().equalsIgnoreCase(".rtf")) {
                selection = "Rich Text Format";
            } else if (Main.CFG.GetDefaultFileType().equalsIgnoreCase(".csv")) {
                selection = "Excel Spreadsheet";
            }


            option = (String) JOptionPane.showInputDialog(null, "Select Default File Type",
                    "Default File Type", JOptionPane.PLAIN_MESSAGE, null, FileTypes, selection);

            try {
                if (option.equalsIgnoreCase("Text File")) {
                    Main.CFG.SetDefaultFileType(".txt");
                } else if (option.equalsIgnoreCase("Rich Text Format")) {
                    Main.CFG.SetDefaultFileType(".rtf");
                } else if (option.equalsIgnoreCase("Excel Spreadsheet")) {
                    Main.CFG.SetDefaultFileType(".csv");
                }

            } catch (NullPointerException nx) {
                option = "No Selection";
            }
        }
    }

    public class AboutActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            InformationMessages.About();
        }
    }

    public class HelpActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            String[] browsers = {"google-chrome", "firefox", "opera", "epiphany", "konqueror", "conkeror", "midori", "kazehakase", "mozilla"};
            String url = Main.filePath + "Help.html";
            //TestMessages.VoidMessage(url);
            switch (Main.OS.GetOS()) {
                case 0:
                    try {
                        url = url.replace("/", "\\");
                        url = "\"" + url;
                        String strCommand = "C:\\Program Files\\Internet Explorer\\iexplore.exe " + url.toString() + "\"";
                        System.err.println(strCommand);
                        Runtime.getRuntime().exec(strCommand);

                    } catch (Exception e) {
                        ErrorMessages.FileNotFound(url);
                    }
                    break;
                case 1:
                    try {
                        Class.forName("com.apple.eio.FileManager").getDeclaredMethod("openURL", new Class[]{String.class}).invoke(null, new Object[]{url});
                    } catch (Exception e) {
                        ErrorMessages.FileNotFound(url);
                    }
                    break;
                case 2:
                    try {
                        String browser = null;
                        for (String b : browsers) {
                            if (browser == null && Runtime.getRuntime().exec(new String[]{"which", b}).getInputStream().read() != -1) {
                                Runtime.getRuntime().exec(new String[]{browser = b, url});
                            }
                        }
                    } catch (Exception e) {
                        ErrorMessages.FileNotFound(url);
                    }
                    break;
            }


        }
    }

    public class LicenseActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            Main.LIS.InputLicense();
            Main.GUI.setTitle();
        }
    }

//Action Event Handlers for Button Clicks
    public class ZeroButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("0");
        }
    }

    public class OneButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("1");
        }
    }

    public class TwoButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("2");
        }
    }

    public class ThreeButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("3");
        }
    }

    public class FourButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("4");
        }
    }

    public class FiveButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("5");
        }
    }

    public class SixButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("6");
        }
    }

    public class SevenButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("7");
        }
    }

    public class EightButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("8");
        }
    }

    public class NineButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("9");
        }
    }

    public class TwoZeroesButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("00");
        }
    }

    public class ThreeZeroesButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.NumberButton("000");
        }
    }

    public class DecimalButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.DecimalButton();
        }
    }

    public class AddButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.OpButton("+");
        }
    }

    public class SubtractButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.OpButton("-");
        }
    }

    public class MultiplyButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.OpButton("*");
        }
    }

    public class DivideButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.OpButton("/");
        }
    }

    public class EqualsButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.EqualsButton();
        }
    }

    public class BackSpaceButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.BackSpaceButton();
        }
    }

    public class ClearEntryButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.ClearEntryButton();
        }
    }

    public class ClearSubTotalButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.ClearSubTotalButton();
        }
    }

    public class ClearAllButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.ClearAllButton();

        }
    }

    public class SignChangeButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.SignChangeButton();
        }
    }

    public class SquaredButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.SquaredButton();
        }
    }

    public class SquareRootButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.SquareRootButton();
        }
    }

    public class PercentButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Operations.PercentButton();
        }
    }

    public class SubTotalButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.SubTotalButton();
        }
    }

    public class TotalButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.TotalButton();
        }
    }

    public class TaxPlusButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.TaxPlusButton();
        }
    }

    public class TaxMinusButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.TaxMinusButton();
        }
    }

    public class SetTaxPlusButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.SetTaxPlus();
        }
    }

    public class SetTaxMinusButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AccountingOperations.SetTaxMinus();
        }
    }

    public class PresentValueButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            PresentValue present = new PresentValue();
            present.setVisible(true);
        }
    }

    public class FutureValueButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            FutureValue future = new FutureValue();
            future.setVisible(true);
        }
    }

    public class MortgageCalcButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MortgageCalculator mortgage = new MortgageCalculator();
            mortgage.setVisible(true);
        }
    }

    public class XYPowerButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.XYPowerButton();
        }
    }

    public class XYRootButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.XYRootButton();
        }
    }

    public class EXPowerButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.EXPowerButton();
        }
    }

    public class NaturalLogButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.NaturalLogarithmButton();
        }
    }

    public class TenXPowerButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.TenXPowerButton();
        }
    }

    public class LogarithmButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.LogarithmButton();
        }
    }

    public class SineButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.SineButton();
        }
    }

    public class CosineButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.CosineButton();
        }
    }

    public class TangentButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.TangentButton();
        }
    }

    public class ArcSineButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.ArcSineButton();
        }
    }

    public class ArcCosineButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.ArcCosineButton();
        }
    }

    public class ArcTangentButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            AlgebraOperations.ArcTangentButton();
        }
    }

    public class Mem1ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem1Button();
        }
    }

    public class Mem1AddButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem1AddButton();
        }
    }

    public class Mem1SubtractButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem1Subtract();
        }
    }

    public class Mem1ClearButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem1ClearButton();
        }
    }

    public class Mem2ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem2Button();
        }
    }

    public class Mem2AddButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem2AddButton();
        }
    }

    public class Mem2SubtractButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem2SubtractButton();
        }
    }

    public class Mem2ClearButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            MemoryOperations.Mem2ClearButton();
        }
    }

    public class UnavailableActionHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            InformationMessages.PurchaseLicense();
        }
    }

    public class TapeChangeListener implements javax.swing.event.ChangeListener {

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            Main.GUI.getTape();
            ActiveTape = TapeTabs.getSelectedIndex();
            Main.VAR.SetIndex(Main.VAR.GetIndexI(ActiveTape), Main.VAR.GetIndexJ(ActiveTape), Main.VAR.GetIndexO(ActiveTape), ActiveTape);
            if (Main.VAR.GetOpLogic(ActiveTape) == 0) {
                AddingMachineRB.setSelected(true);
                BuildTabbedPane();
                PercentB.setVisible(true);
                PercentB.setEnabled(true);
                ClearSubTotalB.setVisible(true);
                ClearSubTotalB.setEnabled(true);
                SignChangeB.setVisible(false);
                SignChangeB.setEnabled(false);
                Main.GUI.setDisplayText(null);
            } else {
                StandardCalcRB.setSelected(true);
                BuildTabbedPane();
                PercentB.setVisible(false);
                PercentB.setEnabled(false);
                ClearSubTotalB.setVisible(false);
                ClearSubTotalB.setEnabled(false);
                SignChangeB.setVisible(true);
                SignChangeB.setEnabled(true);
                Main.GUI.setDisplayText(null);
            }
        }
    }

    public class LogicActionListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            LogicGroup.getSelection();
            int activeTape = getActiveTape();
            activeTape++;
            if (AddingMachineRB.isSelected()) {
                Main.VAR.SetOpLogic(activeTape, 0);
                Main.VAR.SetLogicState(activeTape, 0);
                MenuOperations.NewTape(false);
                BuildTabbedPane();
                PercentB.setVisible(true);
                PercentB.setEnabled(true);
                ClearSubTotalB.setVisible(true);
                ClearSubTotalB.setEnabled(true);
                SignChangeB.setVisible(false);
                SignChangeB.setEnabled(false);
            } else if (StandardCalcRB.isSelected()) {
                Main.VAR.SetOpLogic(activeTape, 1);
                MenuOperations.NewTape(false);
                BuildTabbedPane();
                PercentB.setVisible(false);
                PercentB.setEnabled(false);
                ClearSubTotalB.setVisible(false);
                ClearSubTotalB.setEnabled(false);
                SignChangeB.setVisible(true);
                SignChangeB.setEnabled(true);
            }
        }
    }

//Test Code
    public class Test1ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            InformationMessages.NotAvailable();
        }
    }

    public class Test2ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            InformationMessages.NotAvailable();
        }
    }

    public class Test3ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            InformationMessages.NotAvailable();
        }
    }

    public class Test4ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            TestMessages.TestData();
            //TestMessages.FilePathData();
        }
    }

    public class Test5ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            int activeTape = Main.GUI.getActiveTape();
            //TestMessages.FileData(activeTape);
            TestMessages.ShowConfigurations();
        }
    }

    public class Test6ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            //InformationMessages.TapeArrayData();
            TestMessages.AddingMachineArrayData();
        }
    }

    public class Test7ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            TestMessages.ClosedTapeArrayData();
        }
    }

    public class Test8ButtonHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            //TestMessages.TapeStringData();
            TestMessages.TapeLogicData();
        }
    }
//End Test

    public String getDisplayText() {
        return DisplayText.getText();
    }

    public void setDisplayText(String inputStr) {
        DisplayText.setText(inputStr);
    }

    public Integer getPadding() {
        return Padding;
    }

    public Integer getActiveTape() {
        return TapeTabs.getSelectedIndex();
    }

    public void setActiveTape(Integer inputNum) {
        int OpenTapes = Main.VAR.GetTabs() - 1;
        if ((inputNum >= 0) & (inputNum <= OpenTapes)) {
            ActiveTape = inputNum;
            TapeTabs.setSelectedIndex(inputNum);
        }
    }

    public String getTape() {
        ActiveTape = Main.GUI.getActiveTape();
        return TapeArray[ActiveTape].getText();
    }

    public void setTape(int index, String inputStr) {
        TapeArray[index].setText(inputStr);
    }

    public Integer getUserScreenHeight() {
        return UserScreenHeight;
    }

    public void setUserScreenHeight(Integer inputInt) {
        UserScreenHeight = inputInt;
    }

    public void SetOpLogic(int opLogic, int activeTape) {
        switch (opLogic) {
            case 0:
                Main.VAR.SetOpLogic(activeTape, 0);
                Main.VAR.SetLogicState(activeTape, 0);
                AddingMachineRB.setSelected(true);
                StandardCalcRB.setSelected(false);
                BuildTabbedPane();
                PercentB.setVisible(true);
                PercentB.setEnabled(true);
                ClearSubTotalB.setVisible(true);
                ClearSubTotalB.setEnabled(true);
                SignChangeB.setVisible(false);
                SignChangeB.setEnabled(false);
                break;
            case 1:
                Main.VAR.SetOpLogic(activeTape, 1);
                Main.VAR.SetLogicState(activeTape, 0);
                AddingMachineRB.setSelected(false);
                StandardCalcRB.setSelected(true);
                BuildTabbedPane();
                PercentB.setVisible(false);
                PercentB.setEnabled(false);
                ClearSubTotalB.setVisible(false);
                ClearSubTotalB.setEnabled(false);
                SignChangeB.setVisible(true);
                SignChangeB.setEnabled(true);
                break;
        }
    }

    public Integer getRBSelection() {
        int selection;
        if (StandardCalcRB.isSelected()) {
            selection = 1;
        } else {
            selection = 0;
        }
        return selection;
    }

    class WinListener implements WindowListener {

        @Override
        public void windowClosing(WindowEvent e) {
            MenuOperations.Close();
        }

        @Override
        public void windowOpened(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    class KeyboardListener extends java.awt.event.KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                Operations.EqualsButton();
            }
            char keyCode = e.getKeyChar();
            switch (keyCode) {
                case '0':
                    Operations.NumberButton("0");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '1':
                    Operations.NumberButton("1");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '2':
                    Operations.NumberButton("2");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '3':
                    Operations.NumberButton("3");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '4':
                    Operations.NumberButton("4");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '5':
                    Operations.NumberButton("5");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '6':
                    Operations.NumberButton("6");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '7':
                    Operations.NumberButton("7");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '8':
                    Operations.NumberButton("8");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '9':
                    Operations.NumberButton("9");
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '.':
                    Operations.DecimalButton();
                    DisplayText.setText(Main.VAR.GetDisplayStr());
                    break;
                case '+':
                    Operations.OpButton("+");
                    break;
                case '-':
                    Operations.OpButton("-");
                    break;
                case '*':
                    Operations.OpButton("*");
                    break;
                case '/':
                    Operations.OpButton("/");
                    break;
            }
        }
    }
}
