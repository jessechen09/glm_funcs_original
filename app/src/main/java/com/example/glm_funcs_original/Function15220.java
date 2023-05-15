package com.example.glm_funcs_original;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;

import javax.crypto.Cipher;
public class Function15220 {
      private byte[] encryptRsaPlainText(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(1, publicKey);
        return encryptCipherText(cipher, bArr);
    }

    private byte[] encryptCipherText(Cipher cipher, byte[] bArr) { return null;
    }
}