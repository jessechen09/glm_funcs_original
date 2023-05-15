public class Function15223 {
      private byte[] encryptCipherText(Cipher cipher, byte[] bArr) throws GeneralSecurityException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}