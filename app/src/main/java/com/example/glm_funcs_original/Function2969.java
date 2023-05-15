package com.example.glm_funcs_original;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class Function2969 {
      public static void allowAllSSL() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.onupkeep.data.network.ssl.TrustManagerManipulator.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
          TrustManager[] trustManagers;
          trustManagers = new TrustManager[0];
          if (trustManagers == null) {
            trustManagers = new TrustManager[]{new TrustManagerManipulator()};
        }
        try {
            sSLContext = SSLContext.getInstance("TLS");
        }
        //        catch (KeyManagementException e3) {
//            sSLContext = null;
//            e2 = e3;
//        }
        catch (NoSuchAlgorithmException e4) {
            sSLContext = null;
            e = e4;
        }
        try {
            sSLContext.init(null, trustManagers, new SecureRandom());
        } catch (KeyManagementException e5) {
            e2 = e5;
            e2.printStackTrace();
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        }
//        catch (NoSuchAlgorithmException e6) {
//            e = e6;
//            e.printStackTrace();
//            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
//        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }
}