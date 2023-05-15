public class Function4234 {
      public final void setPassword() {
        LoginResponseModel.Data data;
        List split$default;
        LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
        String str = null;
        if ((loginDetail != null ? loginDetail.getData() : null) == null || !(!SharedPrefs.INSTANCE.getEmailPass(this.context).isEmpty())) {
            return;
        }
        ArrayList<HashMap<String, String>> emailPass = SharedPrefs.INSTANCE.getEmailPass(this.context);
        if (emailPass.size() > 0) {
            String str2 = emailPass.get(0).get(HintConstants.AUTOFILL_HINT_PASSWORD);
            String str3 = (str2 == null || (split$default = StringsKt.split$default((CharSequence) str2, new String[]{"`"}, false, 0, 6, (Object) null)) == null) ? null : (String) split$default.get(1);
            byte[] decode = Base64.decode(str3, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "android.util.Base64.deco…roid.util.Base64.DEFAULT)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(decode, 0, decode.length, "AES");
            String decrypt = Utils.INSTANCE.decrypt(emailPass.get(0).get("email"), secretKeySpec.toString());
            if (decrypt != null) {
                LoginResponseModel loginDetail2 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                if (decrypt.equals((loginDetail2 == null || (data = loginDetail2.getData()) == null) ? null : data.getEmail())) {
                    HashMap<String, String> hashMap = emailPass.get(0);
                    Intrinsics.checkNotNullExpressionValue(hashMap, "arrayList[i]");
                    HashMap<String, String> hashMap2 = hashMap;
                    String password = this.loginReqModel.getPassword();
                    if (password != null) {
                        str = Intrinsics.stringPlus(Utils.INSTANCE.encrypt(password, secretKeySpec.toString()), "`") + str3;
                    }
                    hashMap2.put(HintConstants.AUTOFILL_HINT_PASSWORD, str);
                    SharedPrefs.INSTANCE.storeEmailPass(this.context, emailPass);
                }
            }
        }
    }
}