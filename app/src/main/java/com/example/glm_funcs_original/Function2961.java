
package com.example.glm_funcs_original;

import android.util.Base64;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function2961 {
    private static String ANDROID_KEY_STORE;

    public static final String rsaEncrypt(@NotNull String keyAlias, @NotNull String stringToEncrypt) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(stringToEncrypt, "stringToEncrypt");
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            PublicKey publicKey = keyStore.getCertificate(keyAlias).getPublicKey();
            Intrinsics.checkNotNullExpressionValue(publicKey, "getCertificate(keyAlias).publicKey");
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
            byte[] bytes = stringToEncrypt.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            cipherOutputStream.write(bytes);
            cipherOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Throwable th) {
            Timber.m48e(th, "Failed RSA data encryption", new Object[0]);
            return null;
        }
    }
}