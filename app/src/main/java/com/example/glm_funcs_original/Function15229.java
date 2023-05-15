package com.example.glm_funcs_original;

import android.content.Context;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Function15229 {
      private SecretKey getSymmetricKey(String str) throws GeneralSecurityException, IOException {
        Context context = getContext();
        return new SecretKeySpec(decryptRsaCipherText(getPrivateKey(str), Storage.readValues(context, Constants.SKS_KEY_FILENAME + str)), Constants.AES_ALGORITHM);
    }

    private byte[] decryptRsaCipherText(Object privateKey, Object readValues) { return null; // JC
    }

    private Object getPrivateKey(String str) { return null; // JC
    }

    private Context getContext() { return null; // JC
    }
}