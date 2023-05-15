
package com.example.glm_funcs_original;

import android.util.Base64;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function2960 {
    private static String ANDROID_KEY_STORE;

    public static final String rsaDecrypt(@NotNull String keyAlias, @NotNull String encryptedString) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(encryptedString, "encryptedString");
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            Key key = keyStore.getKey(keyAlias, null);
            if (key != null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, (PrivateKey) key);
                byte[] readBytes = ByteStreamsKt.readBytes(new CipherInputStream(new ByteArrayInputStream(Base64.decode(encryptedString, 0)), cipher));
                return new String(readBytes, 0, readBytes.length, Charsets.UTF_8);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.PrivateKey");
        } catch (Throwable th) {
            Timber.m48e(th, "Failed RSA data decryption", new Object[0]);
            return null;
        }
    }
}