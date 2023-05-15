public class Function23053 {
      public static final String m40439a(String str) {
        String m18540i0;
        C25938n.m13482h(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(C23904d.f64615b);
        C25938n.m13483g(bytes, "(this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        C25938n.m13483g(bigInteger, "BigInteger(1, md.digest(toByteArray())).toString(16)");
        m18540i0 = C23933v.m18540i0(bigInteger, 32, '0');
        return m18540i0;
    }
}