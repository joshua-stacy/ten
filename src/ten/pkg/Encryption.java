/*
 ==============================================================
 == Date:          8/15/2012
 == Programmer:    Joshua Stacy
 == Program:       Tape_Calculator
 == Class Name:    Encryption
 == Purpose:       This class contains methods for encrypting and
 ==                 decrypting strings.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//Import necessary packages
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher; 
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class Encryption {

    private static final String Algorithm = "AES";
    private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
    private static Key key;
    private static Cipher c;
    
    public static String encrypt(String Data) throws Exception {
        key = generateKey();
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(Data.getBytes("UTF-8"));
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        
        //System.out.println("Decrypting");
        String decryptedValue = "Empty Decrypt";
        key = generateKey();
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decodedValue);
        //System.out.println("Still OK");
        decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        c = Cipher.getInstance(Algorithm);
        Key generatedKey = new SecretKeySpec(keyValue, Algorithm);
        return generatedKey;
    }
}
