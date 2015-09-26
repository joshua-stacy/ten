/*
 ==============================================================
 == Date:          12/30/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    License
 == Purpose:       This class contains variables and methods for
 ==                getting and checking license key.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class License {

    private static String LicenseKey;// = "65406K524R65540P981H06533";
    private static String encrypted = "";
    private static String compare = "";
    private static String encryptedNumber = "";
    private static String encryptedDateStr = "";
    private static String decrypted = "";
    private static String decryptedNumber = "";
    private static boolean LicenseSaved = false;
    private int LicenseType = 0;
    private int opens = 0;
    private int daysLeft = 0;
    private int trialPeriod = 45;
    private static int todayYear, startYear, todayMonth, startMonth, todayDay, startDay;
    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date todayDate = new Date();
    String startDate;

    public void Initialize() {
        try {
            String file = Main.filePath + "LicenseKey.cfg";
            //Test Code
            System.out.println("Opening License File: " + Main.filePath + "LicenseKey.cfg");
            //End Test
            Scanner inFile = new Scanner(new FileReader(file));
            
            if (inFile.hasNext()) {
                encryptedNumber = inFile.nextLine().trim();
            } else {
                NoOpens();
            }
            
            if (inFile.hasNext()) {
                encrypted = inFile.nextLine().trim();
            } else {
                NoKey();
            }
            
            if (inFile.hasNext()) {
                encryptedDateStr = inFile.nextLine().trim();
                System.out.println("encryption of Date String: " + encryptedDateStr);
            } else {
                NoStartDate();
            }
            inFile.close();
        } catch (FileNotFoundException ex) {
            NoStartDate();
            NoOpens();
            NoLicense();
        }

        DecryptAll();

        GetLicenseType(LicenseKey, false);

        //Test Code
        //LicenseKey = "100325kjd8100254tif910013"; //Full
        //LicenseKey = "10032G654F10025R515G10013"; //Limited
        //LicenseKey = "65406K524R65540P981H06508"; //Trial
        //LicenseKey = "Empty";  //Trial
        //End Test
    }
    
    //Removing Mac Dependency
    /*
    public boolean CheckMac(String inputStr) {
        boolean validMac = false;
        compare = Main.MAC.GetMacStr();
        if (inputStr.equals(compare)) {
            validMac = true;
        } else {
            System.out.println("Invalid Mac: " + inputStr);
        }
        return validMac;
    }
    */

    public void GetLicenseType(String CheckKey, boolean save) {
        LicenseType = 0;
        String mac = "";
        String License = "";
        //Test Code
        License = CheckKey;
        //End Test
        //Re-Insert
        /*
         * if (CheckKey.length() >= 25) { mac = CheckKey.substring(25); License
         * = CheckKey.substring(0, 25); }
         */


        boolean ValidFullLicense = false;
        boolean ValidLimitedLicense = false;
        boolean ValidTrialLicense = false;
        ValidFullLicense = ValidFullLicense(License);
        if (ValidFullLicense == true) {
            SaveLicenseKey();
            LicenseType = 99;
            
            //Re-Insert
            /*
            if (CheckMac(mac)) {
                LicenseKey = CheckKey;
                SaveLicenseKey();
                LicenseType = 99;
            } else {
                LicenseType = 0;
            }
            * 
            */
        } else {
            LicenseType = 0;
        }

        if (LicenseType == 0) {
            ValidLimitedLicense = ValidLimitedLicense(License);
            if (ValidLimitedLicense == true) {
                LicenseType = 66;
                SaveLicenseKey();
                //Re_Insert
                /*
                 * if (CheckMac(mac)) { LicenseKey = CheckKey; SaveLicenseKey();
                 * LicenseType = 66; } else { LicenseType = 0; }
                 *
                 */
            } else {
                LicenseType = 0;
            }
        }

        if (LicenseType == 0) {
            ValidTrialLicense = ValidTrialLicense(License);
            if (ValidTrialLicense == true) {
                LicenseType = 33;
            }
            
            
             daysLeft = GetDaysLeft(); //if (opens < 3) { if (daysLeft >= 0) {
             if (ValidTrialLicense == true) {
                 InformationMessages.TrialLeft(Integer.toString(daysLeft));
                 LicenseType = 33; 
             } 
             
            if (LicenseType == 0) {
                //Re-Insert ?
                //ErrorMessages.InvalidLicenseKey(CheckKey);
                //NoLicense();
                //Test Code
                //LicenseKey = "65406K524R65540P981H06533";
                SaveLicenseKey();
                DecryptAll();
            }
        }

    }

    public int GetDaysLeft() {
        if (opens == 0){
            startDate = dateFormat.format(todayDate);
        }
        String todayStr = dateFormat.format(todayDate);
        String yearStr = todayStr.substring(0, 4);
        String monthStr = todayStr.substring(5, 7);
        String dayStr = todayStr.substring(8);
        String startYearStr = startDate.substring(0, 4);
        String startMonthStr = startDate.substring(5, 7);
        String startDayStr = startDate.substring(8);
        int years, months, days, daysPassed, daysRemaining, monthScale;
        todayYear = Integer.parseInt(yearStr);
        startYear = Integer.parseInt(startYearStr);
        todayMonth = Integer.parseInt(monthStr);
        startMonth = Integer.parseInt(startMonthStr);
        todayDay = Integer.parseInt(dayStr);
        startDay = Integer.parseInt(startDayStr);
        years = todayYear - startYear;
        months = todayMonth - startMonth;
        days = todayDay - startDay;
        monthScale = 0;
        switch (startMonth) {
            case 2:
                monthScale = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthScale = 30;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthScale = 31;
                break;
        }

        daysPassed = (years * 365) + (months * monthScale) + (days);
        daysRemaining = trialPeriod - daysPassed;
        //System.out.println("Start Date: " + startDate);
        //System.out.println("Today's Date: " + todayDate);
        //System.out.println("Days Remaining: " + daysRemaining);
        
        //Code to limit Beta Testing Period
        Integer betaYear = 2013;
        Integer betaMonth = 12;
        Integer betaDay = 31;
        if ((betaYear - todayYear) == 0){
            if ((betaMonth - todayMonth) == 0){
                if ((betaDay - todayDay) <= 0){
                    daysRemaining = 0;
                }
            }
            else if ((betaMonth - todayMonth) < 0){
                daysRemaining = 0;
            }
        }
        else if ((betaYear - todayYear) <= 0){
            daysRemaining = 0;
        }
        //End Beta Code
        return daysRemaining;

    }

    public static boolean ValidFullLicense(String inputString) {
        boolean IsValid = false;
        String first, second, third, fourth, fifth;
        int firstNum, thirdNum, fifthNum;
        String[] alphanumeric = {"4suf7", "4tif9", "7csh5", "2jgw1", "7jhc3", "3xks1",
            "9xks8", "5eht1", "4khk6", "8ajd4", "1oks9", "0rcs4", "3alu6", "1fdg0",
            "3wpu2", "4fqo3", "9saj7", "5kjd8"};
        if (inputString.isEmpty()) {
            IsValid = false;
            return IsValid;
        } else if (inputString.length() == 25) {
            first = inputString.substring(0, 5);
            second = inputString.substring(5, 10);
            third = inputString.substring(10, 15);
            fourth = inputString.substring(15, 20);
            fifth = inputString.substring(20, 25);
            try {
                firstNum = Integer.parseInt(first);
                thirdNum = Integer.parseInt(third);
                fifthNum = Integer.parseInt(fifth);
            } catch (Exception e) {
                return IsValid;
            }
            if (firstNum > 10000 && (firstNum % 33) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == true) {
                for (int i = 0; i < alphanumeric.length; i++) {
                    if (second.equalsIgnoreCase(alphanumeric[i])) {
                        IsValid = true;
                        i = alphanumeric.length;
                    } else {
                        IsValid = false;
                    }
                }
            } else {
                IsValid = false;
            }
            if (IsValid == true && thirdNum > 10000 && (thirdNum % 25) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == true) {
                for (int i = 0; i < alphanumeric.length; i++) {
                    if (fourth.equalsIgnoreCase(alphanumeric[i])) {
                        IsValid = true;
                        i = alphanumeric.length;
                    } else {
                        IsValid = false;
                    }
                }
            } else {
                IsValid = false;
            }
            if (IsValid == true && fifthNum > 10000 && (fifthNum % 17) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == false) {
                return IsValid;
            } else {
                return IsValid;
            }
        } else {
            IsValid = false;
        }
        return IsValid;
    }

    public static boolean ValidLimitedLicense(String inputString) {
        boolean IsValid = false;
        String first, second, third, fourth, fifth;
        int firstNum, thirdNum, fifthNum;
        String[] alphanumeric = {"G654F", "R515G", "N231W", "L654Z", "J024D", "F123L",
            "S661U", "A325O", "F540M", "Z618K", "D910Q", "W468O", "I401A", "M354C",
            "X985I", "V416O", "P652Z", "R870A"};



        if (inputString.isEmpty()) {
            IsValid = false;
            return IsValid;
        } else if (inputString.length() == 25) {
            first = inputString.substring(0, 5);
            second = inputString.substring(5, 10);
            third = inputString.substring(10, 15);
            fourth = inputString.substring(15, 20);
            fifth = inputString.substring(20, 25);
            try {
                firstNum = Integer.parseInt(first);
                thirdNum = Integer.parseInt(third);
                fifthNum = Integer.parseInt(fifth);
            } catch (Exception e) {
                return IsValid;
            }
            if (firstNum > 10000 && (firstNum % 33) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == true) {
                for (int i = 0; i < alphanumeric.length; i++) {
                    if (second.equalsIgnoreCase(alphanumeric[i])) {
                        IsValid = true;
                        i = alphanumeric.length;
                    } else {
                        IsValid = false;
                    }
                }
            } else {
                IsValid = false;
            }
            if (IsValid == true && thirdNum > 10000 && (thirdNum % 25) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == true) {
                for (int i = 0; i < alphanumeric.length; i++) {
                    if (fourth.equalsIgnoreCase(alphanumeric[i])) {
                        IsValid = true;
                        i = alphanumeric.length;
                    } else {
                        IsValid = false;
                    }
                }
            } else {
                IsValid = false;
            }
            if (IsValid == true && fifthNum > 10000 && (fifthNum % 17) == 0) {
                IsValid = true;
            } else {
                IsValid = false;
            }
            if (IsValid == false) {
                return IsValid;
            } else {
                return IsValid;
            }
        } else {
            IsValid = false;
        }
        return IsValid;
    }

    public static boolean ValidTrialLicense(String inputString) {
        boolean IsValid = false;
        String alphanumeric = "65406K524R65540P981H06508";

        if (inputString.equals(alphanumeric)) {
            IsValid = true;
            return IsValid;
        }
        return IsValid;
    }

    public void NoLicense() {
        int option;
        option = JOptionPane.showOptionDialog(null, "No License Key Has Been Saved"
                + "\n" + "Input License Key?", "No License Key",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        switch (option) {
            case JOptionPane.YES_OPTION:
                InputLicense();
                break;
            case JOptionPane.NO_OPTION:
                NoKey();
                break;
        }
    }

    public void NoKey() {
        try {
            encrypted = Encryption.encrypt("65406K524R65540P981H06533");
        } catch (Exception e) {
        }
    }
    public void NoOpens() {
        try {
            encryptedNumber = Encryption.encrypt("0");
        } catch (Exception e) {
        }
    }

    public void NoStartDate() {
        try {
            encryptedDateStr = Encryption.encrypt(dateFormat.format(todayDate));
        } catch (Exception e) {
        }
    }

    public void DecryptAll() {
        try {
            decrypted = Encryption.decrypt(encrypted);
            LicenseKey = decrypted;
            if (LicenseKey.isEmpty()) {
                System.out.println("No License Key");
                //LicenseKey = "65406K524R65540P981H06533";
            }
        } catch (Exception e) {
            System.out.println("Unable to decrypt Key.");
        }


        try {
            decryptedNumber = Encryption.decrypt(encryptedNumber);
            opens = Integer.parseInt(decryptedNumber);
            if (LicenseKey.isEmpty()) {
                System.out.println("No License Key");
                //LicenseKey = "65406K524R65540P981H06533";
            }
        } catch (Exception e) {
            System.out.println("Unable to decrypt Number.");
        }


        try {
            //System.out.println("Encrypted Start Date: " + encryptedDateStr);
            startDate = Encryption.decrypt(encryptedDateStr);
            //System.out.println("Start Date: " + startDate);
        } catch (Exception e) {
            System.out.println("Unable to decrypt Date.");
        }
        //Test Code
        //System.out.println("License Key: " + LicenseKey);
        //System.out.println("Number: " + decryptedNumber);
        //System.out.println("Start Date : " + startDate);
        //End Test
    }

    public void InputLicense() {
        LicenseKey = JOptionPane.showInputDialog(null, "Enter Product License Key: ", Main.LIS.GetLicenseKey());
        if (LicenseKey != null) {
            GetLicenseType(LicenseKey, true);
        }
        if (LicenseSaved) {
            InformationMessages.LicenseKeySaved();
        }
    }

    public void SaveLicenseKey() {
        opens += 1;
        try {
            encrypted = Encryption.encrypt(LicenseKey);
        } catch (Exception e) {
            System.out.println("Unable to encrypt License Key.");
        }
        try {
            encryptedNumber = Encryption.encrypt(Integer.toString(opens));
        } catch (Exception e) {
            System.out.println("Unable to encrypt Opens.");
        }
        try {
            encryptedDateStr = Encryption.encrypt(startDate);
        } catch (Exception e) {
            System.out.println("Unable to encrypt Start Date.");
        }
        try {
            String file = Main.filePath + "LicenseKey.cfg";
            PrintWriter outFile = new PrintWriter(file);
            outFile.println(encryptedNumber);
            outFile.println(encrypted);
            outFile.println(encryptedDateStr);
            outFile.close();
            LicenseSaved = true;
        } catch (Exception E) {
            System.out.println("Unable to save License Key.");
        }
        try {
            decrypted = Encryption.decrypt(encrypted);
            decryptedNumber = Encryption.decrypt(encryptedNumber);
        } catch (Exception E) {
            System.out.println("Unable to Decrypt.");
        }
    }

    public String GetLicenseKey() {
        return LicenseKey;
    }

    public void SetLicenseKey(String inputString) {
        LicenseKey = inputString;
    }

    public int GetLicenseType() {
        //System.out.println("License Type: " + LicenseType);
        return LicenseType;
    }

    public void SetLicenseType(int inputInt) {
        LicenseType = inputInt;
    }
}
