public class Function15229 {
      private SecretKey getSymmetricKey(String str) throws GeneralSecurityException, IOException {
        Context context = getContext();
        return new SecretKeySpec(decryptRsaCipherText(getPrivateKey(str), Storage.readValues(context, Constants.SKS_KEY_FILENAME + str)), Constants.AES_ALGORITHM);
    }
}