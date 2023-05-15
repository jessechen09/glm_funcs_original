package com.example.glm_funcs_original;

import android.content.Context;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class Function15224 {
      private SecretKey getOrCreateSecretKey(String str) throws GeneralSecurityException, IOException {
        try {
            return getSymmetricKey(str);
        }
        catch (FileNotFoundException unused) {
            Log.i(Constants.TAG, "no existing symmetric key for alias");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey generateKey = keyGenerator.generateKey();
            PublicKey orCreatePublicKey = getOrCreatePublicKey(str);
            Context context = getContext();
            Storage.writeValues(context, Constants.SKS_KEY_FILENAME + str, encryptRsaPlainText(orCreatePublicKey, generateKey.getEncoded()));
            Log.i(Constants.TAG, "created new symmetric keys for alias");
            return generateKey;
        }
    }

    private SecretKey getSymmetricKey(String str) throws FileNotFoundException {
        return null;
    }

    private Object encryptRsaPlainText(PublicKey orCreatePublicKey, byte[] encoded) {
        return null;
    }

    private Context getContext() {
        return null;
    }

    private PublicKey getOrCreatePublicKey(String str) {
        return null;
    }
}