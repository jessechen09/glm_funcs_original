public class Function4229 {
      public final void setKey(String myKey) {
        Intrinsics.checkNotNullParameter(myKey, "myKey");
        try {
            Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = myKey.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            key = bytes;
            MessageDigest messageDigest = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1);
            byte[] bArr = key;
            if (bArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            byte[] digest = messageDigest.digest(bArr);
            Intrinsics.checkNotNullExpressionValue(digest, "sha.digest(key)");
            key = digest;
            if (digest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            byte[] copyOf = Arrays.copyOf(digest, 16);
            Intrinsics.checkNotNullExpressionValue(copyOf, "Arrays.copyOf(key, 16)");
            key = copyOf;
            byte[] bArr2 = key;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            secretKey = new SecretKeySpec(bArr2, "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }
}