/*
 ==============================================================
 == Date:          6/20/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    InformaitonMessages
 == Purpose:       This class contains methods which display 
 ==                informational messages to user. .
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;

public class InformationMessages {

    public static void NotAvailable() {
        JOptionPane.showMessageDialog(null, "This Feature is Planned for the Beta 2.0 Release."
                + "\n" + "It is Not Available in the Beta 1.0 Version.",
                null, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void PurchaseLicense() {
        JOptionPane.showMessageDialog(null, "This Feature is Not Available in the Free Version."
                + "\n" + "To Purchase a Valid License Key, Visit:\n\n"
                + "                  http://www.crumbcake.com", null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void TrialLeft(String left) {
        JOptionPane.showMessageDialog(null, "You have " + left + " Days Remaining In Your "
                + "Trial Period.\nTo Purchase a Valid License Key, Visit:\n\n"
                + "                  http://www.crumbcake.com",
                null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void ConfigurationSaved() {
        JOptionPane.showMessageDialog(null, "User Configuration Successfully"
                + " Saved.", null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void LicenseKeySaved() {
        JOptionPane.showMessageDialog(null, "Product License Key Successfully"
                + " Saved.", null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void SubTotalLimit() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Maximum Number of " + "\n"
                + "Entries For a Single SubTotal." + "\n" + "To Continue Operating, Press SubTotal.",
                null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void SubTotalNumberLimit() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Maximum Number of " + "\n"
                + "Numbers For a Single SubTotal." + "\n" + "You Cannot Add Any More Numbers.",
                null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void SubTotalOperationLimit() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Maximum Number of " + "\n"
                + "Operations For a Single SubTotal." + "\n" + "You Cannot Add Any More Operations.",
                null, JOptionPane.PLAIN_MESSAGE);
    }

    public static int ClearSubTotal() {
        int option;
        option = JOptionPane.showOptionDialog(null, "Clear SubTotal?" + "\n"
                + "All Work in This SubTotal Will Be Lost.",
                "Clear SubTotal?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        return option;
    }

    public static void TotalLimit() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Maximum Number of SubTotals " + "\n"
                + "For a Single Tape." + "\n" + "In Order To Continue Operating," + "\n"
                + "You Must Begin A New Tape" + "\n" + "Or Perform an Edit SubTotals.",
                null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void About() {
        String os = "Win10 Beta 1.0";
        switch (Main.OS.GetOS()) {
            case 0:
                os = "Win10 Beta 1.0";
                break;
            case 1:
                os = "Mac10 Beta 1.0";
                break;
            case 2:
                os = "Lin10 Beta 1.0";
                break;
        }
        JOptionPane.showMessageDialog(null, os + " is Copywrighted by CrumbCake, Inc.",
                null, JOptionPane.PLAIN_MESSAGE);
    }
}
