public class Function4220 {
      public static String decrypt(String str, String str2, String str3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(hexStringToByteArray(str2));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(Key.STRING_CHARSET_NAME), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(str3.getBytes());
            PrintStream printStream = System.out;
            printStream.println("decrypted string: " + Base64.encodeToString(doFinal, 0));
            return Base64.encodeToString(doFinal, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}