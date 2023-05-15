public class Function4223 {
      public final String decode(String decode) {
        Intrinsics.checkNotNullParameter(decode, "$this$decode");
        byte[] decode2 = Base64.decode(decode, 0);
        Intrinsics.checkNotNullExpressionValue(decode2, "Base64.decode(this, Base64.DEFAULT)");
        Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        return new String(decode2, forName);
    }
}