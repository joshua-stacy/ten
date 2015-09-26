/*
 ==============================================================
 == Date:          7/21/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    ReOpenTape
 == Purpose: This class contains methods for re-opening a closed tape.
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

public class ReOpenTape extends JFrame implements ActionListener {

    private Integer x, y, MainWidth, MainHeight, ButtonWidth, ButtonHeight,
            ListWidth, ListHeight, Padding;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton OKButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JComboBox tapeList = new JComboBox();
    private Font ButtonFont = new Font("Dialog", Font.BOLD, 10);
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);

    public ReOpenTape() {
        int tapeCount = Main.VAR.GetClosedTabs();

        Container reOpenPane = getContentPane();
        Padding = Main.GUI.getPadding();
        MainWidth = Padding * 55;
        ListHeight = Padding * 5;
        ListWidth = Padding * 40;
        MainHeight = Padding * 27;
        ButtonHeight = Padding * 6;
        ButtonWidth = Padding * 15;
        setSize(MainWidth, MainHeight);
        String tapes[] = new String[tapeCount];

        for (int i = 0; i < tapes.length; i++) {
            tapes[i] = Main.VAR.GetClosedFileName(i);
            tapeList.addItem(tapes[i]);
        }

        reOpenPane.setLayout(null);

        //Set window to open center of screen
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);

        tapeList.setSize(ListWidth, ListHeight);

        x = ((MainWidth - ListWidth) / 2);
        y = Padding * 3;
        tapeList.setLocation(x, y);

        reOpenPane.add(tapeList);

        OKButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            OKButton.setFont(SmallButtonFont);
        } else {
            OKButton.setFont(ButtonFont);
        }
        x = ((MainWidth - (ButtonWidth * 2 + Padding)) / 2);
        y = (Padding * 11);

        OKButton.setLocation(x, y);

        reOpenPane.add(OKButton);
        OKButton.addActionListener(this);

        CancelButton.setSize(ButtonWidth, ButtonHeight);
        if (Main.CFG.GetSize() == 4) {
            CancelButton.setFont(SmallButtonFont);
        } else {
            CancelButton.setFont(ButtonFont);
        }
        x += (Padding + ButtonWidth);

        CancelButton.setLocation(x, y);

        reOpenPane.add(CancelButton);
        CancelButton.addActionListener(this);

        reOpenPane.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str = String.valueOf(e.getActionCommand());
        if (str.equals("Cancel")) {
            super.dispose();
        } else if (str.equals("OK")) {
            int index = (tapeList.getSelectedIndex());
            int openTapes = Main.VAR.GetTabs();
            int loadIndex = Main.VAR.GetClosedTapeTabIndex(index);

            //This is for placeholder greater than number of tapes open
            if (loadIndex >= openTapes) {
                MenuOperations.NewTape(false);
                loadIndex = openTapes;
            } else {
                MenuOperations.NewTape(false);
                for (int i = openTapes; i > loadIndex; i--) {
                    Main.VAR.SetFilePath(i, Main.VAR.GetFilePath(i - 1));
                    Main.VAR.SetFileName(i, Main.VAR.GetFileName(i - 1));
                    Main.VAR.SetFileExtension(i, Main.VAR.GetFileExtension(i - 1));
                    Main.VAR.SetTapeStr(i, Main.VAR.GetTapeStr(i - 1));
                    Main.VAR.SetTabTitle(i, Main.VAR.GetFileName(i - 1));
                    Main.VAR.SetTapeChanged(i, Main.VAR.GetTapeChanged(i - 1));
                    Main.VAR.SetOpLogic(i, Main.VAR.GetOpLogic(i - 1));
                }
            }
            Main.VAR.SetFilePath(loadIndex, Main.VAR.GetClosedFilePath(index));
            Main.VAR.SetFileName(loadIndex, Main.VAR.GetClosedFileName(index));
            Main.VAR.SetFileExtension(loadIndex, Main.VAR.GetClosedFileExtension(index));
            Main.VAR.SetTapeStr(loadIndex, Main.VAR.GetClosedTapeStr(index));
            Main.VAR.SetTapeChanged(loadIndex, Main.VAR.GetClosedTapeChanged(index));
            Main.VAR.SetTabTitle(loadIndex, Main.VAR.GetFileName(loadIndex));
            Main.GUI.setActiveTape(loadIndex);
            Main.GUI.setTape(loadIndex, Main.VAR.GetClosedTapeStr(index));
            //Main.VAR.SetOpLogic(loadIndex, Main.VAR.GetClosedOpLogic(index));
            Main.VAR.SetIndex(Main.VAR.GetClosedIndexI(index), Main.VAR.GetClosedIndexJ(index), Main.VAR.GetClosedIndexO(index), loadIndex);
            for (int y = 0; y <= Main.VAR.GetClosedIndexJ(index); y++) {
                for (int x = 0; x <= Main.VAR.GetClosedIndexI(index); x++) {
                    Main.VAR.SetNumbers(Main.VAR.GetClosedNumbers(x, y, index), x, y, loadIndex);
                }
                for (int a = 1; a <= Main.VAR.GetClosedIndexO(index); a++) {
                    Main.VAR.SetClosedOpArray(Main.VAR.GetClosedOpArray(a, y, index), a, y, loadIndex);
                }
            }
            //Remove Tape Data From Closed Tape Arrays Below
            for (int i = index; i < 4; i++) {
                Main.VAR.SetClosedTapeStr(i, Main.VAR.GetClosedTapeStr(i + 1));
                Main.VAR.SetClosedFilePath(i, Main.VAR.GetClosedFilePath(i + 1));
                Main.VAR.SetClosedFileName(i, Main.VAR.GetClosedFileName(i + 1));
                Main.VAR.SetClosedFileExtension(i, Main.VAR.GetClosedFileExtension(i + 1));
                Main.VAR.SetClosedTapeTabIndex(i, Main.VAR.GetClosedTapeTabIndex(i + 1));
                Main.VAR.SetClosedTapeChanged(i, Main.VAR.GetClosedTapeChanged(i + 1));
                Main.VAR.SetOpLogic(loadIndex, Main.VAR.GetClosedOpLogic(index));
                Main.VAR.SetIndex(Main.VAR.GetClosedIndexI(index), Main.VAR.GetClosedIndexJ(index), Main.VAR.GetClosedIndexO(index), loadIndex);
                for (int y = 0; y <= Main.VAR.GetClosedIndexJ(index); y++) {
                    for (int x = 0; x <= Main.VAR.GetClosedIndexI(index); x++) {
                        Main.VAR.SetNumbers(Main.VAR.GetClosedNumbers(x, y, index), x, y, loadIndex);
                    }
                    for (int a = 1; a <= Main.VAR.GetClosedIndexO(index); a++) {
                        Main.VAR.SetClosedOpArray(Main.VAR.GetClosedOpArray(a, y, index), a, y, loadIndex);
                    }
                }
            }
            Main.VAR.InitializeClosedTape(4);
            Main.GUI.SetOpLogic(Main.VAR.GetOpLogic(Main.VAR.GetIndexT()), Main.VAR.GetIndexT());
            Main.VAR.SetClosedTabs((Main.VAR.GetClosedTabs() - 1));
            super.dispose();
        }
    }
}
