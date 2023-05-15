package com.example.glm_funcs_original;

import android.util.Base64;

import java.io.PrintStream;
import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Function4220 {
    private static final Charset STRING_CHARSET_NAME = null; // JC

    public static String decrypt(String str, String str2, String str3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(hexStringToByteArray(str2));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(STRING_CHARSET_NAME), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(str3.getBytes());
            PrintStream printStream = System.out;
            printStream.println("decrypted string: " + Base64.encodeToString(doFinal, 0));
            return Base64.encodeToString(doFinal, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] hexStringToByteArray(String str2) {
        return null;
    }
}