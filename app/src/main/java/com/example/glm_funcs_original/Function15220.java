public class Function15220 {
      private byte[] encryptRsaPlainText(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(1, publicKey);
        return encryptCipherText(cipher, bArr);
    }
}