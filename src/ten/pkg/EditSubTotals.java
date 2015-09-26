/*
 ==============================================================
 == Date:          1/19/2012
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    EditSubTotals
 == Purpose: This class contains methods for editing Sub Totals.
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
import java.awt.event.*;

public class EditSubTotals extends JFrame implements ActionListener {

    private Integer x, y, MainWidth, MainHeight, ScrollWidth, ScrollHeight, ButtonWidth, ButtonHeight,
            ListWidth, ListHeight, TextWidth, TextHeight, LabelHeight, NumberLabelWidth, OpLabelWidth,
            NumberAreaWidth, NumberAreaHeight,
            Padding, j, LastNumber, LastOp;
    private char op;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel[] numberLabels = new JLabel[Main.VAR.iLimit];
    private JLabel[] opLabels = new JLabel[Main.VAR.oLimit];
    private JTextField[] numberList = new JTextField[Main.VAR.iLimit];
    private JComboBox[] opList = new JComboBox[Main.VAR.oLimit];
    private JButton OKButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JButton AddNumberButton = new JButton("Add Number");
    private JButton RemoveNumberButton = new JButton("Remove Number");
    private JButton AddOperationButton = new JButton("Add Operation");
    private JButton RemoveOperationButton = new JButton("Remove Operation");
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private JPanel numbersPanel = new JPanel();

    public void ChooseSubTotal(int J, int T) {
        Container editPane = getContentPane();

        //InformationMessages.NotAvailable();
        Padding = Main.GUI.getPadding();
        MainWidth = Padding * 180;
        ListHeight = Padding * 5;
        ListWidth = Padding * 40;
        ListHeight = Padding * 5;
        ListWidth = Padding * 20;
        LabelHeight = Padding * 5;
        TextWidth = Padding * 20;
        TextHeight = Padding * 5;
        OpLabelWidth = Padding * 20;
        NumberLabelWidth = Padding * 20;
        MainHeight = Padding * 110;
        ButtonHeight = Padding * 6;
        ButtonWidth = Padding * 28;
        ScrollHeight = (MainHeight - ButtonHeight - (Padding * 20));
        ScrollWidth = (MainWidth - (Padding * 6));
        NumberAreaHeight = ((LabelHeight + Padding * 2) * Main.VAR.iLimit);
        NumberAreaWidth = (ScrollWidth - (Padding * 18));
        Dimension scrollSize = new Dimension(NumberAreaWidth, NumberAreaHeight);
        setSize(MainWidth, MainHeight);
        String[] ops = {"+", "-", "*", "/", " "};

        setLayout(null);
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        numbersPanel.setLayout(null);
        numbersPanel.setSize(NumberAreaWidth, NumberAreaHeight);
        numbersPanel.setPreferredSize(scrollSize);

        x = Padding;
        y = Padding;

        for (int i = 0; i < numberLabels.length - 1; i++) {
            numberLabels[i] = new JLabel("Number " + (i + 1));
            numberLabels[i].setSize(NumberLabelWidth, LabelHeight);
            numberLabels[i].setLocation(x, y);
            numbersPanel.add(numberLabels[i]);
            x += (NumberLabelWidth + Padding * 2);
            numberList[i] = new JTextField();
            numberList[i].setSize(TextWidth, TextHeight);
            numberList[i].setLocation(x, y);
            numberList[i].setText(Main.VAR.GetNumbers(i, J, T).toString());
            numbersPanel.add(numberList[i]);
            x += TextWidth + Padding * 2;
            opLabels[i] = new JLabel("Operation " + (i + 1));
            opLabels[i].setSize(OpLabelWidth, LabelHeight);
            opLabels[i].setLocation(x, y);
            numbersPanel.add(opLabels[i]);
            x += OpLabelWidth + Padding * 2;
            opList[i] = new JComboBox();
            opList[i].setSize(ListWidth, ListHeight);
            op = Main.VAR.GetOpArray(i, J, T);
            for (int j = 0; j < ops.length; j++) {
                opList[i].addItem(ops[j]);
            }
            switch (op) {
                case '+':
                    opList[i].setSelectedIndex(0);
                    break;
                case '-':
                    opList[i].setSelectedIndex(1);
                    break;
                case '*':
                    opList[i].setSelectedIndex(2);
                    break;
                case '/':
                    opList[i].setSelectedIndex(3);
                    break;
                case ' ':
                    opList[i].setSelectedIndex(4);
                    break;
            }
            opList[i].setLocation(x, y);
            numbersPanel.add(opList[i]);
            x = Padding;
            y += (LabelHeight + Padding * 2);
        }

        numberLabels[Main.VAR.iLimit - 1] = new JLabel("Number " + (Main.VAR.iLimit));
        numberLabels[Main.VAR.iLimit - 1].setSize(NumberLabelWidth, LabelHeight);
        numberLabels[Main.VAR.iLimit - 1].setLocation(x, y);
        numbersPanel.add(numberLabels[Main.VAR.iLimit - 1]);
        x += (NumberLabelWidth + Padding * 2);
        numberList[Main.VAR.iLimit - 1] = new JTextField();
        numberList[Main.VAR.iLimit - 1].setSize(TextWidth, TextHeight);
        numberList[Main.VAR.iLimit - 1].setLocation(x, y);
        numberList[Main.VAR.iLimit - 1].setText(Main.VAR.GetNumbers(Main.VAR.iLimit - 1, J, T).toString());
        numbersPanel.add(numberList[Main.VAR.iLimit - 1]);

        LastNumber = LastNumber();
        LastOp = LastOp();
        Main.VAR.SetIndex(LastNumber, J, LastOp, T);

        JScrollPane window = new JScrollPane(numbersPanel);
        window.setSize(ScrollWidth, ScrollHeight);
        window.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        window.setViewportView(numbersPanel);
        window.repaint();

        x = Padding;
        y = Padding;

        window.setLocation(x, y);
        editPane.add(window);

        x = ((MainWidth - (ButtonWidth * 6) - (Padding * 8)) / 2);
        y = (ScrollHeight + Padding + ((MainHeight - ScrollHeight + Padding) / 2) - ButtonHeight);

        AddNumberButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            AddNumberButton.setFont(SmallButtonFont);
        }
        AddNumberButton.setLocation(x, y);
        editPane.add(AddNumberButton);
        AddNumberButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        RemoveNumberButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            RemoveNumberButton.setFont(SmallButtonFont);
        }
        RemoveNumberButton.setLocation(x, y);
        editPane.add(RemoveNumberButton);
        RemoveNumberButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        AddOperationButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            AddOperationButton.setFont(SmallButtonFont);
        }
        AddOperationButton.setLocation(x, y);
        editPane.add(AddOperationButton);
        AddOperationButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        RemoveOperationButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            RemoveOperationButton.setFont(SmallButtonFont);
        }
        RemoveOperationButton.setLocation(x, y);
        editPane.add(RemoveOperationButton);
        RemoveOperationButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        OKButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            OKButton.setFont(SmallButtonFont);
        }
        OKButton.setLocation(x, y);
        editPane.add(OKButton);
        OKButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        CancelButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            CancelButton.setFont(SmallButtonFont);
        }
        CancelButton.setLocation(x, y);
        editPane.add(CancelButton);
        CancelButton.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        int error = 0;
        if (str.equals("Cancel")) {
            super.dispose();
        } else if (str.equals("OK")) {
            LastNumber = LastNumber();
            LastOp = LastOp();
            if (LastNumber - LastOp == 1) {
                error = 0;
            } else {
                error = -99;
            }
            if (error == 0) {
                for (int x = 0; x < numberList.length; x++) {
                    try {
                        BigDecimal number = new BigDecimal(Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(0), numberList[x].getText()), Main.CFG.GetDefaultMath());
                        Main.VAR.SetNumbers(number, x, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                    } catch (Exception ex) {
                        ErrorMessages.InvalidNumber();
                        numberList[x].setText("");
                        numberList[x].requestFocus();
                        x = numberList.length;
                        error = -99;
                    }
                }
                for (int y = 0; y < opList.length - 1; y++) {
                    int selection = opList[y].getSelectedIndex();
                    switch (selection) {
                        case 0:
                            Main.VAR.SetOpArray('+', y, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                            break;
                        case 1:
                            Main.VAR.SetOpArray('-', y, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                            break;
                        case 2:
                            Main.VAR.SetOpArray('*', y, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                            break;
                        case 3:
                            Main.VAR.SetOpArray('/', y, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                            break;
                        case 4:
                            if (y <= LastOp) {
                                error = -99;
                                ErrorMessages.MissingOperation();
                                opList[y].requestFocus();
                            } else {
                                Main.VAR.SetOpArray(' ', y, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
                            }
                            break;
                    }
                }
            } else if (LastNumber > LastOp + 1) {
                ErrorMessages.MissingOperation();
            } else if (LastOp >= LastNumber) {
                ErrorMessages.MissingNumber();
            }
            if (error == 0) {
                Main.VAR.SetIndex(LastNumber + 1, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), LastOp + 1, Main.VAR.GetIndexT());
                Main.VAR.SetLogicState(Main.VAR.GetIndexT(), 4);
                super.dispose();
            }
        } else if (str.equals("Add Number")) {
            if (LastNumber < Main.VAR.iLimit - 1) {
                numberList[LastNumber + 1].setVisible(true);
                numberLabels[LastNumber + 1].setVisible(true);
                LastNumber++;
                Main.VAR.SetIndex(LastNumber, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), LastOp, Main.VAR.GetIndexT());
            } else {
                InformationMessages.SubTotalNumberLimit();
            }
        } else if (str.equals("Remove Number")) {
            numberList[LastNumber].setText("0");
            numberList[LastNumber].setVisible(false);
            numberLabels[LastNumber].setVisible(false);
            LastNumber--;
            Main.VAR.SetIndex(LastNumber, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), LastOp, Main.VAR.GetIndexT());
        } else if (str.equals("Add Operation")) {
            if (LastNumber < Main.VAR.oLimit - 1) {
                opList[LastOp + 1].setVisible(true);
                opLabels[LastOp + 1].setVisible(true);
                LastOp++;
                Main.VAR.SetIndex(LastNumber, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), LastOp, Main.VAR.GetIndexT());
            } else {
                InformationMessages.SubTotalOperationLimit();
            }
        } else if (str.equals("Remove Operation")) {
            opList[LastOp].setVisible(false);
            opList[LastOp].setSelectedIndex(4);
            opLabels[LastOp].setVisible(false);
            LastOp--;
            Main.VAR.SetIndex(LastNumber, Main.VAR.GetIndexJ(Main.VAR.GetIndexT()), LastOp, Main.VAR.GetIndexT());
        }
    }

    private int LastNumber() {
        int lastNumber = 0;
        String number;

        for (int i = numberList.length - 1; i >= 0; i--) {
            number = numberList[i].getText();
            if (number.equals("0") == false) {
                lastNumber = i;
                i = -1;
            } else if (i > 0) {
                numberList[i].setVisible(false);
                numberLabels[i].setVisible(false);
            }
        }
        return lastNumber;
    }

    private int LastOp() {
        int lastOp = 0;

        for (int i = opList.length - 1; i >= 0; i--) {
            int selection = opList[i].getSelectedIndex();
            if (selection == 4 && i > 0) {
                opList[i].setVisible(false);
                opLabels[i].setVisible(false);
            } else {
                lastOp = i;
                i = -1;
            }
        }
        return lastOp;
    }
}
