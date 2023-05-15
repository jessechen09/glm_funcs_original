package com.example.glm_funcs_original;

import android.util.Base64;

import org.jetbrains.annotations.NotNull;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function2957 {
    private static final String ANDROID_KEY_STORE = ""; // JC

    public static final String aesDecrypt(@NotNull String keyAlias, @NotNull String stringToDecrypt) {
        List split$default;
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(stringToDecrypt, "stringToDecrypt");
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            Key key = keyStore.getKey(keyAlias, null);
            if (key != null) {
                SecretKey secretKey = (SecretKey) key;
                split$default = StringsKt__StringsKt.split$default((CharSequence) stringToDecrypt, new String[]{"_"}, false, 0, 6, (Object) null);
                if (split$default.size() != 2) {
                    return null;
                }
                byte[] decode = Base64.decode((String) split$default.get(0), 0);
                byte[] decode2 = Base64.decode((String) split$default.get(1), 0);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, secretKey, new GCMParameterSpec(128, decode2));
                byte[] doFinal = cipher.doFinal(decode);
                Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(dataBytes)");
                return new String(doFinal, Charsets.UTF_8);
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.crypto.SecretKey");
        } catch (Throwable th) {
            Timber.m48e(th, "Failed AES data decryption", new Object[0]);
            return null;
        }
    }
}