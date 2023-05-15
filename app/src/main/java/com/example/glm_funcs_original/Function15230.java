public class Function15230 {
      public String getPlainText(String str) throws GeneralSecurityException, IOException {
        SecretKey symmetricKey = getSymmetricKey(str);
        Context context = getContext();
        return new String(decryptAesCipherText(symmetricKey, Storage.readValues(context, Constants.SKS_DATA_FILENAME + str)), "UTF-8");
    }
}