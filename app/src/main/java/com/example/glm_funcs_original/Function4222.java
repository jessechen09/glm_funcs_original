package com.example.glm_funcs_original;

import android.content.Context;
import android.util.Base64;

import java.security.*;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

import android.util.Log;


public class Function4222 {
      public final void printHashKey(Context pContext) {
        Signature[] signatureArr;
        Intrinsics.checkNotNullParameter(pContext, "pContext");
        try {
            for (android.content.pm.Signature signature : pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), 64).signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                byte[] encode = Base64.encode(messageDigest.digest(), 0);
                Intrinsics.checkNotNullExpressionValue(encode, "android.util.Base64.encode(md.digest(), 0)");
                Log.e("", "printHashKey() Hash Key: " + new String(encode, Charsets.UTF_8));
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("", "printHashKey()", e);
        } catch (Exception e2) {
            Log.e("", "printHashKey()", e2);
        }
    }
}