package com.example.glm_funcs_original;

import java.net.URL;
public class Function14049 {
          private String getTitleFromUrl(String str) {
            URL url = null;
            String host = null; // JC
            String file;
            try {
                url = new URL(str);
                host = url.getHost();
            } catch (Exception unused) {
            }
            if (host == null || host.isEmpty()) {
                return (!str.startsWith("file:") || (file = url.getFile()) == null || file.isEmpty()) ? str : file;
            }
            return url.getProtocol() + "://" + host;
        }
}