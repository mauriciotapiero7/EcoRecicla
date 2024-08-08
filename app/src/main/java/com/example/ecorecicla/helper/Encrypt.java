package com.example.ecorecicla.helper;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public static String encryptPassword(String password) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Hash the data

            byte[] hashBytes = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                    }
                hexString.append(hex);
                }
                return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean checkPassword(String password, String hashedPassword) {
        String encryptedPassword =encryptPassword(password); //Contraseña

        Log.e("msg", "contraseña ingresada y encriptada:" + encryptedPassword);
        Log.e("msg", "contraseña de la base de datos:" + hashedPassword);

        boolean result = encryptedPassword.equals(hashedPassword);
        Log.e("msg", "Contraseña incorrecta:" + result);
        return result;
    }

}
