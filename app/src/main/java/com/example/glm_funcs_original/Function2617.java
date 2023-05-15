package com.example.glm_funcs_original;


import android.content.Context;
import java.security.*;
import javax.crypto.Cipher;

public class Function2617 {
      private final Cipher getEncodeCipher(Context context, String str, boolean z) throws PFSecurityException {
        Cipher $r3 = getCipherInstance();
        KeyStore $r4 = loadKeyStore();
        generateKeyIfNecessary(context, $r4, str, z);
        initEncodeCipher($r3, str, $r4);
        return $r3;
    }

    private void initEncodeCipher(Cipher $r3, String str, KeyStore $r4) {
    }

    private void generateKeyIfNecessary(Context context, KeyStore $r4, String str, boolean z) {
    }

    private KeyStore loadKeyStore() {
    }

    private Cipher getCipherInstance() {
    }
}