package com.example.glm_funcs_original;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.security.*;
import javax.crypto.*;

public class Function2630 {
  private static final String RSA_MODE = "";
  private static final String PROVIDER = "";

  private final byte[] rsaEncrypt(Context context, byte[] bArr, String str) throws Exception {
        KeyStore $r4 = loadKeyStore();
        generateKeyIfNecessary(context, $r4, str, false);
        KeyStore.Entry $r5 = $r4.getEntry(str, null);
        if ($r5 == null) {
            NullPointerException $r13 = new NullPointerException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
            throw $r13;
        }
        KeyStore.PrivateKeyEntry $r6 = (KeyStore.PrivateKeyEntry) $r5;
        String $r3 = RSA_MODE;
        String $r7 = PROVIDER;
        Cipher $r8 = Cipher.getInstance($r3, $r7);
        Certificate $r9 = (Certificate) $r6.getCertificate();
        PublicKey $r10 = $r9.getPublicKey();
        $r8.init(1, $r10);
        ByteArrayOutputStream $r11 = new ByteArrayOutputStream();
        CipherOutputStream $r12 = new CipherOutputStream($r11, $r8);
        $r12.write(bArr);
        $r12.close();
        byte[] $r2 = $r11.toByteArray();
        Log_OC.loadImage($r2, "outputStream.toByteArray()");
        return $r2;
    }

  private void generateKeyIfNecessary(Context context, KeyStore $r4, String str, boolean b) {
  }

  private KeyStore loadKeyStore() {
        return null;
  }
}