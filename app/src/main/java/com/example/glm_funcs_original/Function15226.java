package com.example.glm_funcs_original;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import javax.crypto.Cipher;

public class Function15226 {
      private byte[] decryptRsaCipherText(PrivateKey privateKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(2, privateKey);
        return decryptCipherText(cipher, bArr);
    }

    private byte[] decryptCipherText(Cipher cipher, byte[] bArr) { return null; // JC
    }
}