package com.example.glm_funcs_original;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import kotlin.jvm.internal.Intrinsics;

public class Function2956 {
      public static final void downloadFile(@NotNull String fileURL, @NotNull File directory) {
        Intrinsics.checkNotNullParameter(fileURL, "fileURL");
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(directory);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(fileURL).openConnection());
            if (uRLConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        return;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        } catch (Exception e) {
            Timber.m49e(e);
        }
    }
}