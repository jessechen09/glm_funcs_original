public class Function15224 {
      private SecretKey getOrCreateSecretKey(String str) throws GeneralSecurityException, IOException {
        try {
            return getSymmetricKey(str);
        } catch (FileNotFoundException unused) {
            Log.i(Constants.TAG, "no existing symmetric key for alias");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey generateKey = keyGenerator.generateKey();
            PublicKey orCreatePublicKey = getOrCreatePublicKey(str);
            Context context = getContext();
            Storage.writeValues(context, Constants.SKS_KEY_FILENAME + str, encryptRsaPlainText(orCreatePublicKey, generateKey.getEncoded()));
            Log.i(Constants.TAG, "created new symmetric keys for alias");
            return generateKey;
        }
    }
}