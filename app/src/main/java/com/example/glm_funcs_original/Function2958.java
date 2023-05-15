package com.example.glm_funcs_original;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;

import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function2958 {
    private static String ANDROID_KEY_STORE;

    public static final String aesEncrypt(@NotNull String keyAlias, @NotNull String stringToEncrypt) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(stringToEncrypt, "stringToEncrypt");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", ANDROID_KEY_STORE);
            keyGenerator.init(new KeyGenParameterSpec.Builder(keyAlias, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, keyGenerator.generateKey());
            byte[] iv = cipher.getIV();
            byte[] bytes = stringToEncrypt.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(cipher.doFinal(bytes), 0);
            String encodeToString2 = Base64.encodeToString(iv, 0);
            return encodeToString + "_" + encodeToString2;
        } catch (Throwable th) {
            Timber.m48e(th, "Failed AES data encryption", new Object[0]);
            return null;
        }
    }
}