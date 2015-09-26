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

public class PresentValue extends JFrame implements ActionListener {

    private Integer x, y, MainWidth, MainHeight, ButtonWidth, ButtonHeight,
            TextBoxWidth, TextBoxHeight, LabelWidth, LabelHeight, Padding;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton CalculateButton = new JButton("Calculate");
    private JButton ClearButton = new JButton("Clear");
    private JButton ExitButton = new JButton("Exit");
    private JLabel FutureLabel = new JLabel("Future Value:");
    private JLabel InterestLabel = new JLabel("Annual Interest Rate:");
    private JLabel PaymentsLabel = new JLabel("Length of Time:");
    private JLabel FrequencyLabel = new JLabel("Interest Frequency:");
    private JLabel TimeLabel = new JLabel("Time Measurement:");
    private JLabel PresentValueLabel = new JLabel("Present Value:");
    private JTextField FutureText = new JTextField();
    private JTextField InterestText = new JTextField();
    private JTextField PaymentsText = new JTextField();
    private JTextField PresentValueText = new JTextField();
    private String[] FrequencyOptions = {"Monthly", "Quarterly", "Semiannually", "Annually"};
    private String[] TimeOptions = {"Months", "Quarters", "Biannuals", "Years"};
    private JComboBox FrequencyList = new JComboBox(FrequencyOptions);
    private JComboBox TimeList = new JComboBox(TimeOptions);
    private Font ButtonFont;
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font LargeButtonFont = new Font("Dialog", Font.BOLD, 10);
    private Font LabelFont;
    private Font LargeLabelFont = new Font("Monospaced", Font.BOLD, 12);
    private Font SmallLabelFont = new Font("Monospaced", Font.BOLD, 9);

    public PresentValue() {
        Container presentPane = getContentPane();
        setTitle("Present Value Calculator");
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
        MainHeight = Padding * 65;
        MainWidth = TextBoxWidth + TextBoxWidth + Padding * 11;
        setSize(MainWidth, MainHeight);

        presentPane.setLayout(null);

        //Set window to open center of screen
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        x = Padding * 10;
        y = Padding * 3;
        FutureLabel.setSize(LabelWidth, LabelHeight);
        FutureLabel.setFont(LabelFont);
        FutureLabel.setLocation(x, y);
        presentPane.add(FutureLabel);

        x += LabelWidth;

        FutureText.setSize(TextBoxWidth, TextBoxHeight);
        FutureText.setLocation(x, y);
        presentPane.add(FutureText);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        InterestLabel.setSize(LabelWidth, LabelHeight);
        InterestLabel.setFont(LabelFont);
        InterestLabel.setLocation(x, y);
        presentPane.add(InterestLabel);

        x += LabelWidth;

        InterestText.setSize(TextBoxWidth, TextBoxHeight);
        InterestText.setLocation(x, y);
        presentPane.add(InterestText);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        FrequencyLabel.setSize(LabelWidth, LabelHeight);
        FrequencyLabel.setFont(LabelFont);
        FrequencyLabel.setLocation(x, y);
        presentPane.add(FrequencyLabel);

        x += LabelWidth;

        FrequencyList.setSize(TextBoxWidth, TextBoxHeight);
        FrequencyList.setLocation(x, y);
        FrequencyList.setSelectedIndex(0);
        presentPane.add(FrequencyList);

        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        PaymentsLabel.setSize(LabelWidth, LabelHeight);
        PaymentsLabel.setFont(LabelFont);
        PaymentsLabel.setLocation(x, y);
        presentPane.add(PaymentsLabel);

        x += LabelWidth;

        PaymentsText.setSize(TextBoxWidth, TextBoxHeight);
        PaymentsText.setLocation(x, y);
        presentPane.add(PaymentsText);
        
        x = Padding * 10;
        y += TextBoxHeight + Padding * 2;

        TimeLabel.setSize(LabelWidth, LabelHeight);
        TimeLabel.setFont(LabelFont);
        TimeLabel.setLocation(x, y);
        presentPane.add(TimeLabel);

        x += LabelWidth;

        TimeList.setSize(TextBoxWidth, TextBoxHeight);
        TimeList.setLocation(x, y);
        TimeList.setSelectedIndex(0);
        presentPane.add(TimeList);

        x = Padding * 10;
        y += (TextBoxHeight + Padding * 2) * 2;

        PresentValueLabel.setSize(LabelWidth, LabelHeight);
        PresentValueLabel.setFont(LabelFont);
        PresentValueLabel.setLocation(x, y);
        presentPane.add(PresentValueLabel);

        x += LabelWidth;

        PresentValueText.setSize(TextBoxWidth, TextBoxHeight);
        PresentValueText.setLocation(x, y);
        PresentValueText.setEditable(false);
        presentPane.add(PresentValueText);


        //Add Main Control Buttons
        x = ((MainWidth - (ButtonWidth * 3 + Padding * 2)) / 2);
        y = MainHeight - ButtonHeight * 2 - Padding * 5;

        CalculateButton.setSize(ButtonWidth, ButtonHeight);
        CalculateButton.setFont(ButtonFont);
        CalculateButton.setLocation(x, y);
        presentPane.add(CalculateButton);
        CalculateButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        ClearButton.setSize(ButtonWidth, ButtonHeight);
        ClearButton.setFont(ButtonFont);
        ClearButton.setLocation(x, y);
        presentPane.add(ClearButton);
        ClearButton.addActionListener(this);

        x += (Padding + ButtonWidth);

        ExitButton.setSize(ButtonWidth, ButtonHeight);
        ExitButton.setFont(ButtonFont);
        ExitButton.setLocation(x, y);
        presentPane.add(ExitButton);
        ExitButton.addActionListener(this);


        presentPane.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        if (str.equals("Exit")) {
            super.dispose();
        } else if (str.equals("Calculate")) {
            PresentValueText.setText(Calculate());
        } else if (str.equals("Clear")) {
            FutureText.setText("");
            InterestText.setText("");
            PaymentsText.setText("");
            PresentValueText.setText("");
            FrequencyList.setSelectedIndex(0);
            TimeList.setSelectedIndex(0);
        }
    }

    private String Calculate() {
        String resultStr;
        BigDecimal future, interest, result;
        int payments;
        int number = 1;
        int interestFactor = 1;
        int timeFactor = 1;
        String futureStr = FutureText.getText();
        String interestStr = InterestText.getText();
        String paymentsStr = PaymentsText.getText();
        int frequency = FrequencyList.getSelectedIndex();
        int time = TimeList.getSelectedIndex();
        int error = 0;

        try {
            future = new BigDecimal(futureStr, Main.CFG.GetDefaultMath());
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Future Value");
            FutureText.setText("");
            FutureText.requestFocus();
            future = new BigDecimal("0");
            error = 99;
        }
        
        try {
            interest = new BigDecimal(interestStr, Main.CFG.GetDefaultMath());
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Interest Rate");
            InterestText.setText("");
            InterestText.requestFocus();
            interest = new BigDecimal("0");
            error = 99;
        }
        
        try {
            number = Integer.parseInt(paymentsStr);
        } catch (Exception e) {
            ErrorMessages.InvalidNumber("Number of Payments");
            PaymentsText.setText("");
            PaymentsText.requestFocus();
            payments = 0;
            error = 99;
        }
        
        if (error == 0) {
            interest = interest.divide(new BigDecimal("100"), Main.CFG.GetDefaultMath());
            
            switch (frequency) {
                case 0:
                    interest = interest.divide(BigDecimal.valueOf(12), Main.CFG.GetDefaultMath());
                    interestFactor = 1;
                    break;
                case 1:
                    interest = interest.divide(BigDecimal.valueOf(4), Main.CFG.GetDefaultMath());
                    interestFactor = 3;
                    break;
                case 2:
                    interest = interest.divide(BigDecimal.valueOf(2), Main.CFG.GetDefaultMath());
                    interestFactor = 6;
                    break;
                case 3:
                    interestFactor = 12;
                    break;
            }
            
            switch (time) {
                case 0:
                    timeFactor = 1;
                    break;
                case 1:
                    timeFactor = 3;
                    break;
                case 2:
                    timeFactor = 6;
                    break;
                case 3:
                    timeFactor = 12;
                    break;
            }
            
            payments = ((number * timeFactor)/interestFactor);
            interest = interest.add(BigDecimal.ONE, Main.CFG.GetDefaultMath());
            payments = (payments * -1);
            interestStr = interest.toString();
            
            paymentsStr = Integer.toString(payments);
            resultStr = Evaluate.xyPower(paymentsStr, interestStr);
            result = new BigDecimal(resultStr, Main.CFG.GetDefaultMath());
            result = future.multiply(result, Main.CFG.GetDefaultMath());
            resultStr = Evaluate.Trim(2,result.toString());
        } else {
            resultStr = "";
        }
        return resultStr;
    }
}
