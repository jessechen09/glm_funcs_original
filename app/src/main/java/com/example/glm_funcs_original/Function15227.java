package com.example.glm_funcs_original;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Function15227 {
      private byte[] decryptAesCipherText(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.AES_ALGORITHM);
        cipher.init(2, secretKey);
        return decryptCipherText(cipher, bArr);
    }

    private byte[] decryptCipherText(Cipher cipher, byte[] bArr) { return null;
    }
}