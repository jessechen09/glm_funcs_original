package com.example.glm_funcs_original;

import android.content.Context;
import android.icu.util.Calendar;
import android.security.KeyPairGeneratorSpec;
import android.util.Log;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;

import javax.security.auth.x500.X500Principal;
public class Function15219 {
      private PublicKey getOrCreatePublicKey(String str) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance(getKeyStore());
        keyStore.load(null);
        if (!keyStore.containsAlias(str) || keyStore.getCertificate(str) == null) {
            Log.i(Constants.TAG, "no existing asymmetric keys for alias");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 50);
            KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(getContext()).setAlias(str);
            KeyPairGeneratorSpec build = alias.setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", getKeyStore());
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
            Log.i(Constants.TAG, "created new asymmetric keys for alias");
        }
        return keyStore.getCertificate(str).getPublicKey();
    }

    private Context getContext() { // JC
        return null;
    }

    private String getKeyStore() { // JC
        return null;
    }
}