/*
 ==============================================================
 == Date:          7/07/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    FileChooser
 == Purpose:       This class Creates a GUI Which Allows the User
 ==                to Select a File.
 ==
 ==
 ==               This Class is Now Obselete 
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import javax.swing.*;

public class FileChooser {

    private static JFileChooser chooser;
    private static String choosertitle;

    public static void FileChooser() {
        JFrame frame = new JFrame("");
        frame.setVisible(true);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // disable the "All files" option.
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }
}
