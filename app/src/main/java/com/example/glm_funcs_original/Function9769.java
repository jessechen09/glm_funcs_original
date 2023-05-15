package com.example.glm_funcs_original;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public class Function9769 {
      private final String sha256(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(1, md.digest(…yteArray())).toString(16)");
        return StringsKt.padStart(bigInteger, 32, '0');
    }
}