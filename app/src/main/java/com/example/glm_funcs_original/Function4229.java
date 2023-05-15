package com.example.glm_funcs_original;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import kotlin.jvm.internal.Intrinsics;


public class Function4229 {
    private static final String STRING_CHARSET_NAME = null; // JC

    public final void setKey(String myKey) {
        Intrinsics.checkNotNullParameter(myKey, "myKey");
        try {
            // Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
            Charset forName = Charset.forName(STRING_CHARSET_NAME); // JC
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = myKey.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] key = bytes; // JC
            MessageDigest messageDigest = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1);
            byte[] bArr = key;
            if (bArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            byte[] digest = messageDigest.digest(bArr);
            Intrinsics.checkNotNullExpressionValue(digest, "sha.digest(key)");
            key = digest;
            if (digest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            byte[] copyOf = Arrays.copyOf(digest, 16);
            Intrinsics.checkNotNullExpressionValue(copyOf, "Arrays.copyOf(key, 16)");
            key = copyOf;
            byte[] bArr2 = key;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            SecretKeySpec secretKey = new SecretKeySpec(bArr2, "AES");
        }

        // JC
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }
}