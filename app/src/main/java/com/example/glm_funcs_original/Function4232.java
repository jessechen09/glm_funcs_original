public class Function4232 {
      public final void getPassword(boolean z) {
        List split$default;
        List split$default2;
        LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
        String str = null;
        if ((loginDetail != null ? loginDetail.getData() : null) != null) {
            LoginActivity loginActivity = this;
            if (!SharedPrefs.INSTANCE.getEmailPass(loginActivity).isEmpty()) {
                ArrayList<HashMap<String, String>> emailPass = SharedPrefs.INSTANCE.getEmailPass(loginActivity);
                int size = emailPass.size();
                for (int i = 0; i < size; i++) {
                    String str2 = emailPass.get(i).get(HintConstants.AUTOFILL_HINT_PASSWORD);
                    byte[] decode = Base64.decode((str2 == null || (split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"`"}, false, 0, 6, (Object) null)) == null) ? null : (String) split$default2.get(1), 0);
                    Intrinsics.checkNotNullExpressionValue(decode, "android.util.Base64.deco…roid.util.Base64.DEFAULT)");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(decode, 0, decode.length, "AES");
                    String decrypt = Utils.INSTANCE.decrypt(emailPass.get(i).get("email"), secretKeySpec.toString());
                    if (decrypt != null) {
                        LoginVM loginVM = this.loginVM;
                        if (loginVM == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loginVM");
                        }
                        if (decrypt.equals(loginVM.getLoginReqModel().getEmail())) {
                            if (z) {
                                LoginVM loginVM2 = this.loginVM;
                                if (loginVM2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("loginVM");
                                }
                                LoginRequestModel loginReqModel = loginVM2.getLoginReqModel();
                                Utils utils = Utils.INSTANCE;
                                String str3 = emailPass.get(i).get(HintConstants.AUTOFILL_HINT_PASSWORD);
                                if (str3 != null && (split$default = StringsKt.split$default((CharSequence) str3, new String[]{"`"}, false, 0, 6, (Object) null)) != null) {
                                    str = (String) split$default.get(0);
                                }
                                String decrypt2 = utils.decrypt(str, secretKeySpec.toString());
                                if (decrypt2 == null) {
                                    decrypt2 = "";
                                }
                                loginReqModel.setPassword(decrypt2);
                                return;
                            } else if (!Intrinsics.areEqual(Constants.INSTANCE.getUPDATE_STATUS(), "force-update")) {
                                LoginVM loginVM3 = this.loginVM;
                                if (loginVM3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("loginVM");
                                }
                                loginVM3.setFingerPrint(true);
                                doBiometricAuth();
                                return;
                            } else if (Intrinsics.areEqual(Constants.INSTANCE.getUPDATE_STATUS(), "force-update")) {
                                showUpdateDialog();
                                return;
                            } else {
                                LoginVM loginVM4 = this.loginVM;
                                if (loginVM4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("loginVM");
                                }
                                loginVM4.setFingerPrint(true);
                                doBiometricAuth();
                                return;
                            }
                        }
                    }
                }
            } else if (Intrinsics.areEqual(Constants.INSTANCE.getUPDATE_STATUS(), "force-update")) {
                showUpdateDialog();
            }
        } else if (Intrinsics.areEqual(Constants.INSTANCE.getUPDATE_STATUS(), "force-update")) {
            showUpdateDialog();
        }
}