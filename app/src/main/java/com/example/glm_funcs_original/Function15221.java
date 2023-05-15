public class Function15221 {
      private byte[] encryptAesPlainText(SecretKey secretKey, String str) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.AES_ALGORITHM);
        cipher.init(1, secretKey);
        return encryptCipherText(cipher, str);
    }
}