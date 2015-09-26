/*
 ==============================================================
 == Date:          8/07/2012
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    FutureValue
 == Purpose:       This class contains methods for calculating Future Values.
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
import java.math.*;

public class MortgageCalculator extends JFrame implements ActionListener {

    private Integer x, y, MainWidth, MainHeight, ButtonWidth, ButtonHeight,
            TextBoxWidth, TextBoxHeight, LabelWidth, LabelHeight, Padding;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton CalculateButton = new JButton("Calculate");
    private JButton ClearButton = new JButton("Clear");
    private JButton ExitButton = new JButton("Exit");
    private JLabel ValueLabel = new JLabel("Home Value:");
    private JLabel DownLabel = new JLabel("Down Payment:");
    private JLabel InterestLabel = new JLabel("Annual Interest Rate:");
    private JLabel TermLabel = new JLabel("Term Length:");
    private JLabel PaymentLabel = new JLabel("Monthly Payment");
    private JTextField ValueText = new JTextField();
    private JTextField DownText = new JTextField();
    private JTextField InterestText = new JTextField();
    private JTextField PaymentText = new JTextField();
    private String[] TermOptions = {"30 Year", "15 Year", "10 Year"};
    private JComboBox TermList = new JComboBox(TermOptions);
    private Font ButtonFont;
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font LargeButtonFont = new Font("Dialog", Font.BOLD, 10);
    private Font LabelFont;
    private Font LargeLabelFont = new Font("Monospaced", Font.BOLD, 12);
    private Font SmallLabelFont = new Font("Monospaced", Font.BOLD, 9);

    public MortgageCalculator() {
        Container mortgagePane = getContentPane();
        setTitle("Mortgage Calculator");
        Padding = Main.GUI.getPadding();
        if (Padding == 4) {
            LabelFont = SmallLabelFont;
            ButtonFont = SmallButtonFont;
        } else {
            LabelFont = LargeLabelFont;
            ButtonFont = LargeButtonFont;
        }
        TextBoxHeight = Padding * 4;
        TextBoxWidth = Padding * 42;
        ButtonHeight = Padding * 6;
        ButtonWidth = Padding * 20;
        LabelHeight = Padding * 4;
        LabelWidth = Padding * 30;
        MainHeight = Padding * 60;
        MainWidth = TextBoxWidth + TextBoxWidth + Padding * 11;
        setSize(MainWidth, MainHeight);

        mortgagePane.setLayout(null);

        //Set window to open center of screen
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        x = Padding * 10;
        y = Padding * 3;
        ValueLabel.setSize(LabelWidth, LabelHeight);
        ValueLabel.setFont(LabelFont);
        ValueLabel.setLocation(x, y);
        mortgagePane.add(ValueLabel);

        x += LabelWidth;

        ValueText.setSize(TextBoxWidth, TextBoxHeight);
        ValueText.setLocation(x, y);
        mortgagePane.add(ValueText);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        DownLabel.setSize(LabelWidth, LabelHeight);
        DownLabel.setFont(LabelFont);
        DownLabel.setLocation(x, y);
        mortgagePane.add(DownLabel);

        x += LabelWidth;

        DownText.setSize(TextBoxWidth, TextBoxHeight);
        DownText.setLocation(x, y);
        mortgagePane.add(DownText);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        InterestLabel.setSize(LabelWidth, LabelHeight);
        InterestLabel.setFont(LabelFont);
        InterestLabel.setLocation(x, y);
        mortgagePane.add(InterestLabel);

        x += LabelWidth;

        InterestText.setSize(TextBoxWidth, TextBoxHeight);
        InterestText.setLocation(x, y);
        mortgagePane.add(InterestText);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        TermLabel.setSize(LabelWidth, LabelHeight);
        TermLabel.setFont(LabelFont);
        TermLabel.setLocation(x, y);
        mortgagePane.add(TermLabel);

        x += LabelWidth;

        TermList.setSize(TextBoxWidth, TextBoxHeight);
        TermList.setLocation(x, y);
        mortgagePane.add(TermList);

        x = Padding * 10;
        y += (TextBoxHeight + Padding * 2) * 2;

        PaymentLabel.setSize(LabelWidth, LabelHeight);
        PaymentLabel.setFont(LabelFont);
        PaymentLabel.setLocation(x, y);
        mortgagePane.add(PaymentLabel);

        x += LabelWidth;

        PaymentText.setSize(TextBoxWidth, TextBoxHeight);
        PaymentText.setLocation(x, y);
        PaymentText.setEditable(false);
        mortgagePane.add(PaymentText);


        //Add Main Control Buttons
        x = ((MainWidth - (ButtonWidth * 3 + Padding * 2)) / 2);
        y = MainHeight - ButtonHeight * 2 - Padding * 5;

        CalculateButton.setSize(ButtonWidth, ButtonHeight);
        CalculateButton.setFont(ButtonFont);
        CalculateButton.setLocation(x, y);
        mortgagePane.add(CalculateButton);
        CalculateButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        ClearButton.setSize(ButtonWidth, ButtonHeight);
        ClearButton.setFont(ButtonFont);
        ClearButton.setLocation(x, y);
        mortgagePane.add(ClearButton);
        ClearButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        ExitButton.setSize(ButtonWidth, ButtonHeight);
        ExitButton.setFont(ButtonFont);
        ExitButton.setLocation(x, y);
        mortgagePane.add(ExitButton);
        ExitButton.addActionListener(this);


        mortgagePane.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        if (str.equals("Exit")) {
            super.dispose();
        } else if (str.equals("Calculate")) {
            PaymentText.setText(Calculate());
        } else if (str.equals("Clear")) {
            ValueText.setText("");
            DownText.setText("");
            InterestText.setText("");
            PaymentText.setText("");
            TermList.setSelectedIndex(0);
        }
    }

    private String Calculate() {
        System.out.println("Beginning Calculation....");
            
        String resultStr, valueStr, downStr, interestStr;
        BigDecimal value, down, interest, balance, result, months;
        valueStr = ValueText.getText();
        downStr = DownText.getText();
        months = new BigDecimal("0");
        interestStr = InterestText.getText();
        int term = TermList.getSelectedIndex();
        int error = 0;

        
        System.out.println("Getting Value....");
        try {
            value = new BigDecimal(valueStr, Main.CFG.GetDefaultMath());
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Home Value");
            ValueText.setText("");
            ValueText.requestFocus();
            value = new BigDecimal("0");
            error = 99;
        }
        
        
        System.out.println("Getting Down Payment....");
        try {
            down = new BigDecimal(downStr, Main.CFG.GetDefaultMath());
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Down Payment");
            DownText.setText("");
            DownText.requestFocus();
            down = new BigDecimal("0");
            error = 99;
        }
        
        
        System.out.println("Getting Interest Rate....");
        try {
            interest = new BigDecimal(interestStr, Main.CFG.GetDefaultMath());
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Interest Rate");
            InterestText.setText("");
            InterestText.requestFocus();
            interest = new BigDecimal("0");
            error = 99;
        }
        
        if (error == 0) {
            interest = interest.divide(new BigDecimal("100"));
            
            switch (term) {
                case 0:
                    months = new BigDecimal("360", Main.CFG.GetDefaultMath());
                    break;
                case 1:
                    months = new BigDecimal("180", Main.CFG.GetDefaultMath());
                    break;
                case 2:
                    months = new BigDecimal("120", Main.CFG.GetDefaultMath());
                    break;
            }
            
            balance = value.subtract(down, Main.CFG.GetDefaultMath());
            
            interest = interest.divide(new BigDecimal("12"), Main.CFG.GetDefaultMath());
            
            result = interest.add(BigDecimal.ONE);
            
            resultStr = result.toString();
            months = months.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
            System.out.println("performing power operation....");
            System.out.println("Power: " + months.toString() + "Number: " + resultStr);
            resultStr = Evaluate.xyPower(months.toString(), resultStr);
            
            System.out.println("Power operation complete.");
            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
            System.out.println("Result: " + result.toString());
            result = BigDecimal.ONE.subtract(result, Main.CFG.GetDefaultMath());
            System.out.println("Subtracting From 1.");
            System.out.println("Result: " + result.toString());
            
            
            System.out.println("Dividing: " + interest.toString() + " by: " + result.toString());
            result = interest.divide(result, Main.CFG.GetDefaultMath());
            
            System.out.println("Result: " + result.toString());
            
            result = balance.multiply(result, Main.CFG.GetDefaultMath());
            resultStr = Evaluate.Trim(2,result.toString());
        } else {
            resultStr = "";
        }
        return resultStr;
    }
}