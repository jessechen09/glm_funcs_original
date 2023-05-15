public class Function4230 {
      public final String encrypt(String strToEncrypt, String secret) {
        Intrinsics.checkNotNullParameter(strToEncrypt, "strToEncrypt");
        Intrinsics.checkNotNullParameter(secret, "secret");
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKey);
            Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = strToEncrypt.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (Exception e) {
            System.out.println((Object) ("Error while encrypting: " + e));
            return null;
        }
    }
}