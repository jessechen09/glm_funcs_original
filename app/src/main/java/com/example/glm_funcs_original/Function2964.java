package com.example.glm_funcs_original;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import io.reactivex.MaybeEmitter;
import kotlin.jvm.internal.Intrinsics;


public class Function2964 {
      public static final void m18831asyncWork$lambda8(String pdfUrl, MaybeEmitter emitter) {
        Intrinsics.checkNotNullParameter(pdfUrl, "$pdfUrl");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(pdfUrl).openConnection());
            if (uRLConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                if (httpURLConnection.getResponseCode() == 200) {
                    emitter.onSuccess(new BufferedInputStream(httpURLConnection.getInputStream()));
                    return;
                } else {
                    emitter.onError(new Throwable());
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (Exception e) {
            emitter.onError(e);
        }
    }
}