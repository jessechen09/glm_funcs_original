public class Function15218 {
      private String decrypt(String str) {
        if (str == null) {
            return str;
        }
        byte[] decode = Base64.decode(str, 2);
        byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
        byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, copyOfRange);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(NotificationKeyManager.getKey(Constants.NOTIFICATION_KEY_NAME), 2), SECRET_ALG);
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_TYPE);
            cipher.init(2, secretKeySpec, gCMParameterSpec);
            cipher.updateAAD(this.AAD);
            return new String(cipher.doFinal(copyOfRange2), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }
}