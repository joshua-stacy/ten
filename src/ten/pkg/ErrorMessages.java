/*
 ==============================================================
 == Date:          6/20/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    ErrorMessages
 == Purpose:       This class contains methods which display 
 ==                error messages to user.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import javax.swing.*;

public class ErrorMessages {

    public static void DivideByZero() {
        JOptionPane.showMessageDialog(null, "Error: Cannot Divide by Zero!",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void RootOfNegativeNumber() {
        JOptionPane.showMessageDialog(null, "Error: Cannot Take Even Root of a "
                + "Negative Number!",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void MaximumPower() {
        JOptionPane.showMessageDialog(null, "Error: Exponent Too Large!"
                + "\n" + "Enter a Number Between -9999 and 9999.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void InvalidFileFormat() {
        JOptionPane.showMessageDialog(null, "Error: Invalid File Format!" + "\n"
                + "Check to See if the File May Have Changed or Has Become Corrupted" + "\n\n"
                + "Unable to Load Your Work.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void InvalidNumber() {
        JOptionPane.showMessageDialog(null, "Error: Invalid Number.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void InvalidNumber(String number) {
        JOptionPane.showMessageDialog(null, "Error: Invalid Number for " + number + ".",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void InvalidNumber(String number, String min, String max) {
        JOptionPane.showMessageDialog(null, "Error: Invalid Number for " + number + ".\n"
                + "Value Must be Between " + min + " and " + max,
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void InvalidLicenseKey(String license) {
        JOptionPane.showMessageDialog(null, "Invalid License: " + license,
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void GeneralFileError() {
        JOptionPane.showMessageDialog(null, "Error: General Error Saving File."
                + "\n" + "Unable to Save.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void GeneralFileErrorOpen() {
        JOptionPane.showMessageDialog(null, "Error: Invalid File Content."
                + "\n" + "Unable to Open File.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void GeneralError() {
        JOptionPane.showMessageDialog(null, "Error: General Mathematical Error.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void NonNumericError() {
        JOptionPane.showMessageDialog(null, "Error: Entry Must be Numeric.",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void DecimalPlacesError() {
        JOptionPane.showMessageDialog(null, "Error: Decimal Places Must be a Numeric Entry"
                + "\n" + "Between 0 and 20",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void TaxRateError() {
        JOptionPane.showMessageDialog(null, "Error: Tax Rate Must be a Numeric Entry"
                + "\n" + "Between 0 and 100",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public static void FileNotFound(String Filename) {
        JOptionPane.showMessageDialog(null, Filename, "File Not Found!",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void UserPreferencesNotSet() {
        JOptionPane.showMessageDialog(null, "No User Preferences Saved" + "\n"
                + "Loading Default Configuration", null,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void MaximumTabs() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Maximum Number"
                + "of Open Tapes."
                + "\n" + "Please Close One or More Tapes to Continue.",
                null,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void MinimumTabs() {
        JOptionPane.showMessageDialog(null, "You Have Reached the Minimum Number"
                + "of Open Tapes."
                + "\n" + "You Cannot Close Any More Tapes.",
                null,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void NoClosedTabs() {
        JOptionPane.showMessageDialog(null, "You Have Not Closed Any Tapes."
                + "\n" + "There Are No Tapes to Re-Open.",
                null,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void MissingOperation() {
        JOptionPane.showMessageDialog(null, "You Have Too Few Operations.",
                null,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void MissingNumber() {
        JOptionPane.showMessageDialog(null, "You Have Too Few Numbers.",
                null,
                JOptionPane.PLAIN_MESSAGE);
    }
}
