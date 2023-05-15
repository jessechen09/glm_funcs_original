package com.example.glm_funcs_original;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

import android.annotation.SuppressLint;
import android.security.keystore.*;

public class Function2614 {
      private final boolean generateKey(String str, boolean z) {
        try {
            KeyPairGenerator $r2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            KeyGenParameterSpec.Builder r9 = new KeyGenParameterSpec.Builder(str, 3);
            String[] $r4 = {"SHA-256", "SHA-512"};
            @SuppressLint("WrongConstant") KeyGenParameterSpec.Builder $r3 = r9.setDigests($r4);
            String[] $r42 = {"OAEPPadding"};
            @SuppressLint("WrongConstant") AlgorithmParameterSpec $r5 = $r3.setEncryptionPaddings($r42).setUserAuthenticationRequired(z).build();
            AlgorithmParameterSpec r10 = $r5;
            $r2.initialize(r10);
            $r2.generateKeyPair();
            return true;
        } catch (InvalidAlgorithmParameterException $r6) {
            $r6.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException $r8) {
            $r8.printStackTrace();
            return false;
        } catch (NoSuchProviderException $r7) {
            $r7.printStackTrace();
            return false;
        }
    }
}