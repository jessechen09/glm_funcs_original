package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function4221 {
  private static final String ENCRYPTION_KEY = ""; // JC
  private static final String ENCRYPTION_IV = ""; // JC

  public final String encryptText(String plainText) throws Exception {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        byte[] bytes = plainText.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String str = ENCRYPTION_KEY;
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes2 = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
        String str2 = ENCRYPTION_IV;
        Charset charset2 = Charsets.UTF_8;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes3 = str2.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        Intrinsics.checkNotNullExpressionValue(cipher, "Cipher.getInstance(\"DESede/CBC/PKCS5Padding\")");
        cipher.init(1, new SecretKeySpec(bytes2, "DESede"), new IvParameterSpec(bytes3));
        byte[] doFinal = cipher.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(doFinal, "c3des.doFinal(plaintext)");
        return Base64.encodeToString(doFinal, 0);
    }
}