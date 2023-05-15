public class Function4231 {
      public final void onChanged2(Event<String> event) {
        String contentIfNotHandled;
        LoginResponseModel.Data data;
        LoginResponseModel.Data data2;
        LoginResponseModel.Data data3;
        LoginResponseModel.Data data4;
        LoginResponseModel.Data data5;
        LoginResponseModel.Data data6;
        if (event == null || (contentIfNotHandled = event.getContentIfNotHandled()) == null) {
            return;
        }
        Log.e("Message", "Is " + contentIfNotHandled);
        if (Intrinsics.areEqual(contentIfNotHandled, Constants.INSTANCE.getVISIBLE())) {
            this.this$0.showDialog();
        } else if (Intrinsics.areEqual(contentIfNotHandled, Constants.INSTANCE.getHIDE())) {
            this.this$0.hideDialog();
        } else if (Intrinsics.areEqual(contentIfNotHandled, Constants.INSTANCE.getBIOMETRICSDIALOG())) {
            if (this.this$0.isBiometricsEnabled()) {
                this.this$0.biometricsDialog();
                return;
            }
            this.this$0.getLoginVM().setBiometric(true);
            this.this$0.getLoginVM().callLoginApi();
        } else if (Intrinsics.areEqual(contentIfNotHandled, Constants.INSTANCE.getFINGERPRINTDIALOG())) {
            this.this$0.doBiometricAuth();
        } else if (Intrinsics.areEqual(contentIfNotHandled, Constants.INSTANCE.getNAVIGATE())) {
            LinearLayout lilLogin = (LinearLayout) this.this$0._$_findCachedViewById(C1372R.C1376id.lilLogin);
            Intrinsics.checkNotNullExpressionValue(lilLogin, "lilLogin");
            lilLogin.setEnabled(false);
            if (this.this$0.getLoginVM().isBiometric()) {
                if (this.this$0.isBiometricsEnabled()) {
                    this.this$0.hideDialog();
                    LoginActivity loginActivity = this.this$0;
                    String string = loginActivity.getString(C1372R.string.biometrics_enabled);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.biometrics_enabled)");
                    LoginActivity loginActivity2 = this.this$0;
                    LoginActivity loginActivity3 = loginActivity2;
                    FrameLayout frame1 = (FrameLayout) loginActivity2._$_findCachedViewById(C1372R.C1376id.frame1);
                    Intrinsics.checkNotNullExpressionValue(frame1, "frame1");
                    loginActivity.showMessage(string, loginActivity3, frame1);
                    SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
                    Intrinsics.checkNotNullExpressionValue(secretKey, "secretKey");
                    String encodeToString = Base64.encodeToString(secretKey.getEncoded(), 0);
                    Intrinsics.checkNotNullExpressionValue(encodeToString, "android.util.Base64.enco…                        )");
                    HashMap<String, String> hashMap = new HashMap<>();
                    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                    HashMap<String, String> hashMap2 = hashMap;
                    Utils utils = Utils.INSTANCE;
                    AppCompatEditText edtEmail = (AppCompatEditText) this.this$0._$_findCachedViewById(C1372R.C1376id.edtEmail);
                    Intrinsics.checkNotNullExpressionValue(edtEmail, "edtEmail");
                    hashMap2.put("email", utils.encrypt(String.valueOf(edtEmail.getText()), secretKey.toString()));
                    Utils utils2 = Utils.INSTANCE;
                    AppCompatEditText edtPassword = (AppCompatEditText) this.this$0._$_findCachedViewById(C1372R.C1376id.edtPassword);
                    Intrinsics.checkNotNullExpressionValue(edtPassword, "edtPassword");
                    String stringPlus = Intrinsics.stringPlus(utils2.encrypt(String.valueOf(edtPassword.getText()), secretKey.toString()), "`");
                    hashMap2.put(HintConstants.AUTOFILL_HINT_PASSWORD, stringPlus + encodeToString);
                    if (!SharedPrefs.INSTANCE.getEmailPass(this.this$0).isEmpty()) {
                        arrayList.addAll(SharedPrefs.INSTANCE.getEmailPass(this.this$0));
                    }
                    arrayList.add(hashMap);
                    SharedPrefs.INSTANCE.storeEmailPass(this.this$0, arrayList);
                    this.this$0.setTimer(new CountDownTimer(1000L, 500L) { // from class: com.app.jeeves.authScreens.LoginActivity$observer$3$$special$$inlined$let$lambda$1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            LoginResponseModel.Data data7;
                            LoginResponseModel.Data data8;
                            LoginResponseModel.Data data9;
                            LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                            if ((loginDetail != null ? loginDetail.getData() : null) != null) {
                                LoginResponseModel loginDetail2 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                if (Intrinsics.areEqual((Object) ((loginDetail2 == null || (data9 = loginDetail2.getData()) == null) ? null : data9.isTwoFactorAuth()), (Object) true)) {
                                    LoginResponseModel loginDetail3 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                    String secretToken = (loginDetail3 == null || (data8 = loginDetail3.getData()) == null) ? null : data8.getSecretToken();
                                    if (!(secretToken == null || StringsKt.isBlank(secretToken))) {
                                        LoginResponseModel loginDetail4 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                        if (StringsKt.equals$default((loginDetail4 == null || (data7 = loginDetail4.getData()) == null) ? null : data7.getRole(), this.this$0.getString(C1372R.string.bookkeeper), false, 2, null)) {
                                            Intent intent = new Intent(this.this$0, HomeActivity.class);
                                            LoginResponseModel loginDetail5 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                            intent.putExtra("WELCOME", loginDetail5 != null ? loginDetail5.getMsg() : null);
                                            this.this$0.startActivity(intent);
                                            this.this$0.finish();
                                        } else {
                                            Intent intent2 = new Intent(this.this$0, HomeActivity.class);
                                            LoginResponseModel loginDetail6 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                            intent2.putExtra("WELCOME", loginDetail6 != null ? loginDetail6.getMsg() : null);
                                            this.this$0.startActivity(intent2);
                                            this.this$0.finish();
                                        }
                                    } else {
                                        this.this$0.startActivity(VerifyTwoFactorAuthActivity.class);
                                    }
                                } else {
                                    this.this$0.startActivity(TwoFAAuthenticationActivity.class);
                                }
                            }
                            LinearLayout lilLogin2 = (LinearLayout) this.this$0._$_findCachedViewById(C1372R.C1376id.lilLogin);
                            Intrinsics.checkNotNullExpressionValue(lilLogin2, "lilLogin");
                            lilLogin2.setEnabled(true);
                        }
                    }.start());
                } else {
                    this.this$0.hideDialog();
                    LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                    if ((loginDetail != null ? loginDetail.getData() : null) != null) {
                        LoginResponseModel loginDetail2 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                        if (Intrinsics.areEqual((Object) ((loginDetail2 == null || (data6 = loginDetail2.getData()) == null) ? null : data6.isTwoFactorAuth()), (Object) true)) {
                            LoginResponseModel loginDetail3 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                            String secretToken = (loginDetail3 == null || (data5 = loginDetail3.getData()) == null) ? null : data5.getSecretToken();
                            if (!(secretToken == null || StringsKt.isBlank(secretToken))) {
                                LoginResponseModel loginDetail4 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                if (StringsKt.equals$default((loginDetail4 == null || (data4 = loginDetail4.getData()) == null) ? null : data4.getRole(), this.this$0.getString(C1372R.string.bookkeeper), false, 2, null)) {
                                    Intent intent = new Intent(this.this$0, HomeActivity.class);
                                    LoginResponseModel loginDetail5 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                    intent.putExtra("WELCOME", loginDetail5 != null ? loginDetail5.getMsg() : null);
                                    this.this$0.startActivity(intent);
                                    this.this$0.finish();
                                } else {
                                    Intent intent2 = new Intent(this.this$0, HomeActivity.class);
                                    LoginResponseModel loginDetail6 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                    intent2.putExtra("WELCOME", loginDetail6 != null ? loginDetail6.getMsg() : null);
                                    this.this$0.startActivity(intent2);
                                    this.this$0.finish();
                                }
                            } else {
                                this.this$0.startActivity(VerifyTwoFactorAuthActivity.class);
                            }
                        } else {
                            this.this$0.startActivity(TwoFAAuthenticationActivity.class);
                        }
                    }
                    LinearLayout lilLogin2 = (LinearLayout) this.this$0._$_findCachedViewById(C1372R.C1376id.lilLogin);
                    Intrinsics.checkNotNullExpressionValue(lilLogin2, "lilLogin");
                    lilLogin2.setEnabled(true);
                }
            } else {
                this.this$0.hideDialog();
                LoginResponseModel loginDetail7 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                if ((loginDetail7 != null ? loginDetail7.getData() : null) != null) {
                    LoginResponseModel loginDetail8 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                    if (Intrinsics.areEqual((Object) ((loginDetail8 == null || (data3 = loginDetail8.getData()) == null) ? null : data3.isTwoFactorAuth()), (Object) true)) {
                        LoginResponseModel loginDetail9 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                        String secretToken2 = (loginDetail9 == null || (data2 = loginDetail9.getData()) == null) ? null : data2.getSecretToken();
                        if (!(secretToken2 == null || StringsKt.isBlank(secretToken2))) {
                            LoginResponseModel loginDetail10 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                            if (StringsKt.equals$default((loginDetail10 == null || (data = loginDetail10.getData()) == null) ? null : data.getRole(), this.this$0.getString(C1372R.string.bookkeeper), false, 2, null)) {
                                Intent intent3 = new Intent(this.this$0, HomeActivity.class);
                                LoginResponseModel loginDetail11 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                intent3.putExtra("WELCOME", loginDetail11 != null ? loginDetail11.getMsg() : null);
                                this.this$0.startActivity(intent3);
                                this.this$0.finish();
                            } else {
                                Intent intent4 = new Intent(this.this$0, HomeActivity.class);
                                LoginResponseModel loginDetail12 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                                intent4.putExtra("WELCOME", loginDetail12 != null ? loginDetail12.getMsg() : null);
                                this.this$0.startActivity(intent4);
                                this.this$0.finish();
                            }
                        } else {
                            this.this$0.startActivity(VerifyTwoFactorAuthActivity.class);
                        }
                    } else {
                        this.this$0.startActivity(TwoFAAuthenticationActivity.class);
                    }
                }
            }
            LinearLayout lilLogin3 = (LinearLayout) this.this$0._$_findCachedViewById(C1372R.C1376id.lilLogin);
            Intrinsics.checkNotNullExpressionValue(lilLogin3, "lilLogin");
            lilLogin3.setEnabled(true);
        } else {
            LoginActivity loginActivity4 = this.this$0;
            FrameLayout frame12 = (FrameLayout) loginActivity4._$_findCachedViewById(C1372R.C1376id.frame1);
            Intrinsics.checkNotNullExpressionValue(frame12, "frame1");
            loginActivity4.showMessage(contentIfNotHandled, loginActivity4, frame12);
        }
    }
}