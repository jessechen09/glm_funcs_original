public class Function4224 {
      public final String encode(String encode) {
        Intrinsics.checkNotNullParameter(encode, "$this$encode");
        Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        byte[] bytes = encode.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(th…UTF-8\")), Base64.DEFAULT)");
        return encodeToString;
    }
}