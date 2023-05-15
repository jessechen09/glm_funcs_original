
package com.example.glm_funcs_original;

import android.util.Base64;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import kotlin.jvm.internal.Intrinsics;
public class Function4214 {
    private Object context;
    private SomeClass changePasswordReqModel;

    public final void getPassword() {
        LoginResponseModel.Data data;
        List split$default;
        List split$default2;
        LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
        if ((loginDetail != null ? loginDetail.getData() : null) == null || !(!SharedPrefs.INSTANCE.getEmailPass(this.context).isEmpty())) {
            return;
        }
        ArrayList<HashMap<String, String>> emailPass = SharedPrefs.INSTANCE.getEmailPass(this.context);
        int size = emailPass.size();
        for (int i = 0; i < size; i++) {
            String str = emailPass.get(i).get(HintConstants.AUTOFILL_HINT_PASSWORD);
            Integer valueOf = (str == null || (split$default2 = StringsKt.split$default((CharSequence) str, new String[]{"`"}, false, 0, 6, (Object) null)) == null) ? null : Integer.valueOf(split$default2.size());
            if (valueOf != null && valueOf.intValue() > 1) {
                String str2 = emailPass.get(i).get(HintConstants.AUTOFILL_HINT_PASSWORD);
                String str3 = (str2 == null || (split$default = StringsKt.split$default((CharSequence) str2, new String[]{"`"}, false, 0, 6, (Object) null)) == null) ? null : (String) split$default.get(1);
                byte[] decode = Base64.decode(str3, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "android.util.Base64.deco…                        )");
                SecretKeySpec secretKeySpec = new SecretKeySpec(decode, 0, decode.length, "AES");
                String decrypt = Utils.INSTANCE.decrypt(emailPass.get(i).get("email"), secretKeySpec.toString());
                if (decrypt != null) {
                    LoginResponseModel loginDetail2 = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
                    if (StringsKt.equals(decrypt, (loginDetail2 == null || (data = loginDetail2.getData()) == null) ? null : data.getEmail(), false)) {
                        HashMap<String, String> hashMap = emailPass.get(i);
                        Intrinsics.checkNotNullExpressionValue(hashMap, "arrayList[i]");
                        HashMap<String, String> hashMap2 = hashMap;
                        String newPassword = this.changePasswordReqModel.getNewPassword();
                        hashMap2.put(HintConstants.AUTOFILL_HINT_PASSWORD, newPassword != null ? Intrinsics.stringPlus(Utils.INSTANCE.encrypt(newPassword, secretKeySpec.toString()), "`") + str3 : null);
                        SharedPrefs.INSTANCE.storeEmailPass(this.context, emailPass);
                    }
                }
            }
        }
    }
}