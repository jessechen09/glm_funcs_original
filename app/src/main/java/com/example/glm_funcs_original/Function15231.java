public class Function15231 {
      private String getKeyStore() {
        try {
            try {
                KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_1);
                return Constants.KEYSTORE_PROVIDER_1;
            } catch (Exception unused) {
                return Constants.KEYSTORE_PROVIDER_3;
            }
        } catch (Exception unused2) {
            KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_2);
            return Constants.KEYSTORE_PROVIDER_2;
        }
    }
}