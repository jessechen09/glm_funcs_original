package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;

import kotlin.jvm.internal.Intrinsics;


public class Function4224 {
    private static final String STRING_CHARSET_NAME = null; // JC

    public final String encode(String encode) {
        Intrinsics.checkNotNullParameter(encode, "$this$encode");
        // Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
        Charset forName = Charset.forName(STRING_CHARSET_NAME); // JC
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        byte[] bytes = encode.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(th…UTF-8\")), Base64.DEFAULT)");
        return encodeToString;
    }
}