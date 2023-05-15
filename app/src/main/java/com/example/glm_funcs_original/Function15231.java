package com.example.glm_funcs_original;

import java.security.KeyStore;
import java.security.KeyStoreException;
public class Function15231 {
      private String getKeyStore() throws KeyStoreException {
        try {
            try {
                KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_1);
                return Constants.KEYSTORE_PROVIDER_1;
            } catch (Exception unused) {
                return Constants.KEYSTORE_PROVIDER_3;
            }
        } catch (Exception unused2) {
            KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_2);
            return Constants.KEYSTORE_PROVIDER_2;
        }
    }
}