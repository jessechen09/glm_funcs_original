package com.example.glm_funcs_original;

import android.util.Base64;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import kotlin.jvm.internal.Intrinsics;

public class Function4233 {
    private Object context; // JC
    private LoginResponseModel.Data loginReqModel; // JC
    private boolean isRejectFromDialog; // JC
    private boolean isBiometric; // JC
    private boolean isLoginAPI; // JC
    private boolean isFingerPrint; // JC

    public final void checkBioMetricEnable() {
        List split$default;
        LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
        if ((loginDetail != null ? loginDetail.getData() : null) == null || !(!SharedPrefs.INSTANCE.getEmailPass(this.context).isEmpty())) {
            return;
        }
        ArrayList<HashMap<String, String>> emailPass = SharedPrefs.INSTANCE.getEmailPass(this.context);
        int size = emailPass.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            String str = emailPass.get(i).get(HintConstants.AUTOFILL_HINT_PASSWORD);
            byte[] decode = Base64.decode((str == null || (split$default = StringsKt.split$default((CharSequence) str, new String[]{"`"}, false, 0, 6, (Object) null)) == null) ? null : (String) split$default.get(1), 0);
            Intrinsics.checkNotNullExpressionValue(decode, "android.util.Base64.deco…roid.util.Base64.DEFAULT)");
            String decrypt = Utils.INSTANCE.decrypt(emailPass.get(i).get("email"), new SecretKeySpec(decode, 0, decode.length, "AES").toString());
            if (decrypt != null && decrypt.equals(this.loginReqModel.getEmail())) {
                z = true;
            }
        }
        if (!z && !this.isRejectFromDialog) {
            this.isBiometric = true;
            this.isLoginAPI = false;
            return;
        }
        this.isFingerPrint = false;
    }
}