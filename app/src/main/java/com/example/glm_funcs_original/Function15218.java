package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Function15218 {
    private static final String CIPHER_INSTANCE_TYPE = null; // JC
    private static final byte[] AAD = null; // JC
    private static final String SECRET_ALG = ""; // JC

    private String decrypt(String str) {
        if (str == null) {
            return str;
        }
        byte[] decode = Base64.decode(str, 2);
        byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
        byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, copyOfRange);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(NotificationKeyManager.getKey(Constants.NOTIFICATION_KEY_NAME), 2), SECRET_ALG);
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_TYPE);
            cipher.init(2, secretKeySpec, gCMParameterSpec);
            cipher.updateAAD(this.AAD);
            return new String(cipher.doFinal(copyOfRange2), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }
}