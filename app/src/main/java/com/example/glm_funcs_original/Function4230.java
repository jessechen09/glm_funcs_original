package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;
import java.security.Key;

import javax.crypto.Cipher;

import kotlin.jvm.internal.Intrinsics;

public class Function4230 {
    private static final String STRING_CHARSET_NAME = null;

    public final String encrypt(String strToEncrypt, String secret) {
        Intrinsics.checkNotNullParameter(strToEncrypt, "strToEncrypt");
        Intrinsics.checkNotNullParameter(secret, "secret");
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Key secretKey = null; // JC
            cipher.init(1, secretKey);
//            Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
            Charset forName = Charset.forName(STRING_CHARSET_NAME); // JC
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = strToEncrypt.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (Exception e) {
            System.out.println((Object) ("Error while encrypting: " + e));
            return null;
        }
    }

    private void setKey(String secret) {

    }
}