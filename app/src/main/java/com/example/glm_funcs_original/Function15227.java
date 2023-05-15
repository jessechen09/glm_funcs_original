public class Function15227 {
      private byte[] decryptAesCipherText(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.AES_ALGORITHM);
        cipher.init(2, secretKey);
        return decryptCipherText(cipher, bArr);
    }
}