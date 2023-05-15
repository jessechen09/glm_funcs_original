public class Function16835 {
      public static final String m20725c(@NotNull String str) {
        Intrinsics.m10255e(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.f49291b);
        Intrinsics.m10256d(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = messageDigest.digest(bytes);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f45012a;
        String format = String.format("%032x", Arrays.copyOf(new Object[]{new BigInteger(1, digest)}, 1));
        Intrinsics.m10256d(format, "format(format, *args)");
        return format;
    }
}