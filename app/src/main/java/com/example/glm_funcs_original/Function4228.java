package com.example.glm_funcs_original;

import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;


public class Function4228 {
      public final String decrypt(String str, String secret) {
        Intrinsics.checkNotNullParameter(secret, "secret");
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            Key secretKey = null; // JC
            cipher.init(2, secretKey);
            byte[] doFinal = cipher.doFinal(Base64.decode(str, 0));
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(\n        …      )\n                )");
            return new String(doFinal, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("Error while decrypting: " + e));
            return null;
        }
    }

    private void setKey(String secret) {

    }
}