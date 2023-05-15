public class Function15228 {
      private byte[] decryptCipherText(Cipher cipher, byte[] bArr) throws IOException {
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), cipher);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[256];
        for (int read = cipherInputStream.read(bArr2); read != -1; read = cipherInputStream.read(bArr2)) {
            byteArrayOutputStream.write(bArr2, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }
}