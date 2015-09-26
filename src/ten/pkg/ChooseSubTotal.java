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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseSubTotal extends JFrame implements ActionListener {

    private Integer x, y, MainWidth, MainHeight, ButtonWidth, ButtonHeight,
            ListWidth, ListHeight, Padding, j;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton OKButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JComboBox subTotalList = new JComboBox();
    private Font ButtonFont = new Font("Dialog", Font.BOLD, 10);
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);

    public void ChooseSubTotal() {
        Container editPane = getContentPane();

        //InformationMessages.NotAvailable();
        Padding = Main.GUI.getPadding();
        MainWidth = Padding * 55;
        ListHeight = Padding * 5;
        ListWidth = Padding * 40;
        MainHeight = Padding * 27;
        ButtonHeight = Padding * 6;
        ButtonWidth = Padding * 15;
        setSize(MainWidth, MainHeight);
        j = Main.VAR.GetIndexJ(Main.VAR.GetIndexT());
        String subTotals[] = new String[j + 1];

        for (int i = 0; i < subTotals.length; i++) {
            subTotals[i] = "SubTotal " + (i + 1);
            subTotalList.addItem(subTotals[i]);
        }

        subTotalList.setSelectedIndex(j);

        setLayout(null);
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        subTotalList.setSize(ListWidth, ListHeight);

        x = ((MainWidth - ListWidth) / 2);
        y = Padding * 3;
        subTotalList.setLocation(x, y);

        editPane.add(subTotalList);

        OKButton.setSize(ButtonWidth, ButtonHeight);
        x = ((MainWidth - (ButtonWidth * 2 + Padding)) / 2);
        y = (Padding * 11);

        OKButton.setLocation(x, y);
        if (Main.CFG.GetSize() == 4) {
            OKButton.setFont(SmallButtonFont);
        } else {
            OKButton.setFont(ButtonFont);
        }

        editPane.add(OKButton);
        OKButton.addActionListener(this);

        CancelButton.setSize(ButtonWidth, ButtonHeight);
        x += (Padding + ButtonWidth);

        CancelButton.setLocation(x, y);
        if (Main.CFG.GetSize() == 4) {
            CancelButton.setFont(SmallButtonFont);
        } else {
            CancelButton.setFont(ButtonFont);
        }

        editPane.add(CancelButton);
        CancelButton.addActionListener(this);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        if (str.equals("Cancel")) {
            super.dispose();
        } else if (str.equals("OK")) {
            super.dispose();
            EditSubTotals edit = new EditSubTotals();
            edit.setVisible(true);
            edit.ChooseSubTotal(subTotalList.getSelectedIndex(), Main.VAR.GetIndexT());
        }
    }
}
