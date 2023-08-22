/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author Nue Houjuu
 */
public class hash {
    public static String md5hashing(String text)
    {   String hashtext = null;
        try 
        {
            String plaintext = text;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(plaintext.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
            while(hashtext.length() < 32 ){
              hashtext = "0"+hashtext;   
            }
        } catch (Exception e1) 
        {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null,e1.getClass().getName() + ": " + e1.getMessage());   
        }
        return hashtext;     
    }
}
