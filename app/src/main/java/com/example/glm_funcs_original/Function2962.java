package com.example.glm_funcs_original;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;


public class Function2962 {
          public InputStream doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(strArr[0]).openConnection()));
                if (httpURLConnection.getResponseCode() == 200) {
                    return new BufferedInputStream(httpURLConnection.getInputStream());
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
}