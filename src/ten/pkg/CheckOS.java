/*
 ==============================================================
 == Date:          7/11/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    CheckOS
 == Purpose:       This class contains methods for performing mathematical operations.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;

//Import necessary packages
import javax.swing.JOptionPane;

public class CheckOS {

    private static int OS;

    public static void Initialize() {
        if (isWindows()) {
            OS = 0;
        } else if (isMac()) {
            OS = 1;
        } else if (isUnix()) {
            OS = 2;
        } else {
            JOptionPane.showMessageDialog(null, "This OS is not supported."
                    + "\n" + "OS: "
                    + System.getProperty("os.name").toString(), null,
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static boolean isWindows() {

        String os = System.getProperty("os.name").toLowerCase();
        //windows
        return (os.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        String os = System.getProperty("os.name").toLowerCase();
        //Mac
        return (os.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        String os = System.getProperty("os.name").toLowerCase();
        //linux or unix
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }

    public int GetOS() {
        return OS;
    }

    public void SetOS(int inputInt) {
        OS = inputInt;
    }
}
