public class Function15222 {
      private byte[] encryptCipherText(Cipher cipher, String str) throws GeneralSecurityException, IOException {
        return encryptCipherText(cipher, str.getBytes("UTF-8"));
    }
}