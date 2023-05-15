public class Function4228 {
      public final String decrypt(String str, String secret) {
        Intrinsics.checkNotNullParameter(secret, "secret");
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(2, secretKey);
            byte[] doFinal = cipher.doFinal(Base64.decode(str, 0));
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(\n        …      )\n                )");
            return new String(doFinal, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("Error while decrypting: " + e));
            return null;
        }
    }
}