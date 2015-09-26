/*
 ==============================================================
 == Date:          1/23/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    Main
 == Purpose:       This class loads the User Interface.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import Necessary Packages
import java.net.URLDecoder;

public class Main {

    public static String filePath;
    public static CheckOS OS = new CheckOS();
    public static License LIS = new License();
    public static Configuration CFG = new Configuration();
    public static Variables VAR = new Variables();
    public static Tape_Calculator GUI = new Tape_Calculator();
    //public static GetMac MAC = new GetMac();

    public static void main(String[] args) {
        OS.Initialize();
        filePath = GetPath();
        //MAC.Initialize();
        LIS.Initialize();
        CFG.Initialize();
        VAR.Initialize();
        GUI.Tape_Calculator();
    }

    public static String GetPath() {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = "";
        try {
            decodedPath = URLDecoder.decode(path, "UTF-8");
        } catch (Exception e) {
            System.out.println("unable to decode");
        }
        try {
            decodedPath = decodedPath.substring(0, decodedPath.lastIndexOf("Ten.jar"));
        } catch (Exception e) {
            System.out.println("Unable to strip file name from path.");
        }
        switch (Main.OS.GetOS()) {
            case 0:
                decodedPath = decodedPath.substring(1);
                decodedPath += "Files/";
                break;
            case 1:
            case 2:
                decodedPath += "Files/";
                break;
        }
        //System.out.println("FilePath: " + decodedPath);
        return decodedPath;
    }
}