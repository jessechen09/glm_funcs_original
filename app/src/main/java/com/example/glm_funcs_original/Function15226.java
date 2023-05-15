public class Function15226 {
      private byte[] decryptRsaCipherText(PrivateKey privateKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(2, privateKey);
        return decryptCipherText(cipher, bArr);
    }
}