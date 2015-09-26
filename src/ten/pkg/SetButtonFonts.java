/*
 ==============================================================
 == Date:          8/1/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    SetButtonFonts
 == Purpose: This class contains methods for changing the settings of buttons.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;

public class SetButtonFonts {

    private Font LargeButtonFont = new Font("Dialog", Font.BOLD, 14);
    private Font SmallButtonFont = new Font("Dialog", Font.BOLD, 8);
    private Font LargeTabFont = new Font("Dialog", Font.BOLD, 10);
    private Font SmallTabFont = new Font("Dialog", Font.BOLD, 7);
    private Font LargeSpecialButtonFont = new Font("Dialog", Font.BOLD, 9);
    private Font SmallSpecialButtonFont = new Font("Dialog", Font.BOLD, 6);
    private Font LargeDisplayFont = new Font("Monospaced", Font.BOLD, 12);
    private Font SmallDisplayFont = new Font("Monospaced", Font.BOLD, 10);
    private Font ButtonFont;
    private Font SpecialButtonFont;
    private Font TabFont;
    private Font DisplayFont;
}
