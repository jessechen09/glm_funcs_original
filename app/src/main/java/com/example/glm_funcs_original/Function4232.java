package com.example.glm_funcs_original;

import android.content.Intent;
import android.os.Build;
import android.util.Base64;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import android.util.Base64;

import org.jetbrains.annotations.NotNull;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.MaybeEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.google.android.gms.security.ProviderInstaller;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.HeaderParameterNames;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.nimbusds.jose.util.Base64URL;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Objects;

import android.security.keystore.KeyGenParameterSpec;

import android.security.KeyPairGeneratorSpec;
import android.icu.util.Calendar;
import android.util.Log;


public class Function4232 {
    private LoginVM loginVM;

    public final void getPassword(boolean z) {
        List split$default;
        List split$default2;
        LoginResponseModel loginDetail = SharedPrefs.INSTANCE.getLoginDetail(MyApplication.Singleton.getInstance());
        String str = null;
        if ((loginDetail != null ? loginDetail.getData() : null) != null) {
//            LoginActivity loginActivity = this;
            LoginActivity loginActivity = null; // JC
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
//                                LoginRequestModel loginReqModel = loginVM2.getLoginReqModel();
                                LoginResponseModel.Data loginReqModel =
                                        loginVM2.getLoginReqModel(); // JC
//                                Utils utils = Utils.INSTANCE;
                                SomeClass utils = Utils.INSTANCE; // JC
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

    private void showUpdateDialog() {
    }

    private void doBiometricAuth() {
    }

    public String getPassword() {
        return "";
    }
}