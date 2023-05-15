package com.example.glm_funcs_original;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function14035 {
      public static final String getMd5(String str) throws NoSuchAlgorithmException {
        C8998j.m10435f(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(C17391a.f46814b);
        C8998j.m10436e(bytes, "this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        C8998j.m10436e(bigInteger, "BigInteger(1, md.digest(…yteArray())).toString(16)");
        return C17413u.m1569g0(bigInteger, 32);
    }
}