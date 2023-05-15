package com.example.glm_funcs_original;

import android.os.Build;

import com.google.android.gms.security.ProviderInstaller;

import java.security.SecureRandom;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

public class Function2968 {
      public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 22) {
            try {
                ProviderInstaller.installIfNeeded(UpKeepApplication.getInstance());
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                TrustManager[] trustManagerArr = {new TrustManagerManipulator()};
                sSLContext.init(null, trustManagerArr, new SecureRandom());
                sSLContext.createSSLEngine();
                builder.sslSocketFactory(new Tls12SocketFactory(sSLContext.getSocketFactory()), (X509TrustManager) trustManagerArr[0]);
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e) {
                Timber.m49e(e);
            }
        }
        return builder;
    }
}