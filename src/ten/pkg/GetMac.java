/*
 ==============================================================
 == Date:          12/30/2011
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    GetMac
 == Purpose:       This class contains variables and methods for
 ==                obtaining system Mac Address.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMac {

    static private Pattern macPattern = Pattern.compile(".*((:?[0-9a-f]{2}[-:]){5}[0-9a-f]{2}).*",
            Pattern.CASE_INSENSITIVE);
    static final String[] windowsCommand = {"ipconfig", "/all"};
    static final String[] linuxCommand = {"/sbin/ifconfig", "-a"};
    static final String[] macCommand = {"ifconfig", "-a"};
    public static String Mac;

    public final static List getMacAddresses() throws IOException {
        final List macAddressList = new ArrayList();

        BufferedReader reader = getMacAddressesReader();
        for (String line = null; (line = reader.readLine()) != null;) {
            Matcher matcher = macPattern.matcher(line);
            if (matcher.matches()) {
                macAddressList.add(matcher.group(1).replaceAll("[-:]", ""));
            }
        }
        reader.close();

        return macAddressList;
    }

    public final static String getMacAddress() throws IOException {
        return getMacAddress(0);
    }

    public final static String getMacAddress(int nicIndex) throws IOException {
        BufferedReader reader = getMacAddressesReader();
        int nicCount = 0;
        for (String line = null; (line = reader.readLine()) != null;) {
            Matcher matcher = macPattern.matcher(line);
            if (matcher.matches()) {
                if (nicCount == nicIndex) {
                    reader.close();
                    return matcher.group(1).replaceAll("[-:]", "");
                }
                nicCount++;
            }
        }
        reader.close();
        return null;
    }

    private static BufferedReader getMacAddressesReader() throws IOException {
        String[] command;
        final String os = System.getProperty("os.name");

        command = windowsCommand;

        switch (Main.OS.GetOS()) {
            case 0:
                command = windowsCommand;
                break;
            case 1:
                command = macCommand;
            case 2:
                command = linuxCommand;
                break;
        }

        final Process process = Runtime.getRuntime().exec(command);


        new Thread() {

            public void run() {
                try {
                    InputStream errorStream = process.getErrorStream();
                    while (errorStream.read() != -1) {
                    }

                    errorStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    public static void Initialize() {
        try {
            Mac = getMacAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GetMacStr() {
        return Mac.trim();
    }
}
