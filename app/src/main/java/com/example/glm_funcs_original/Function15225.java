public class Function15225 {
      private PrivateKey getPrivateKey(String str) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance(getKeyStore());
        keyStore.load(null);
        return (PrivateKey) keyStore.getKey(str, null);
    }
}