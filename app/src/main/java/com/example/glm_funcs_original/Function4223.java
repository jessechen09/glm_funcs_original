package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;

import kotlin.jvm.internal.Intrinsics;


public class Function4223 {
    private static final String STRING_CHARSET_NAME = null; // JC

    public final String decode(String decode) {
        Intrinsics.checkNotNullParameter(decode, "$this$decode");
        byte[] decode2 = Base64.decode(decode, 0);
        Intrinsics.checkNotNullExpressionValue(decode2, "Base64.decode(this, Base64.DEFAULT)");
        // Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
        Charset forName = Charset.forName(STRING_CHARSET_NAME); // JC
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        return new String(decode2, forName);
    }
}