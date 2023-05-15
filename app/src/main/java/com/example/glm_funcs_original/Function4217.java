
package com.example.glm_funcs_original;

import android.content.Intent;
import android.os.Build;
import android.util.Base64;

import java.io.BufferedInputStream;
import java.io.IOException;
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
import com.google.gson.Gson;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.HeaderParameterNames;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
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

public class Function4217 {
    public final void getStripeKeyData(final String str) {
//        Call<ResponseBody> stripeKey = ((APICall) Retrofit.Singleton.getRetrofitStripe().create(APICall.class)).getStripeKey();
        Call<ResponseBody> stripeKey = null; // JC
        Intrinsics.checkNotNull(stripeKey);
        stripeKey.enqueue(new Callback<ResponseBody>() { // from class: com.app.jeeves.homeScreen.cards.physicalCardPopup.PhysicalCardConfirmPINActivity$getStripeKeyData$1
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.code() == 200) {
                    ResponseBody body = response.body();
                    JSONObject jSONObject = null; // JC
                    try {
                        jSONObject = new JSONObject(body != null ? body.string() : null);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Object obj = null; // JC
                    try {
                        obj = jSONObject.get("key_id");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Log.e("stripeKeyResponseModel", "Is " + jSONObject.get("key_id"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    BigInteger bigInteger = null; // JC
                    try {
                        bigInteger = new BigInteger(1, new Base64URL(jSONObject.getJSONObject(HeaderParameterNames.JWK).getString(JWKParameterNames.RSA_MODULUS)).decode());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    BigInteger bigInteger2 = null; // JC
                    try {
                        bigInteger2 = new BigInteger(1, new Base64URL(jSONObject.getJSONObject(HeaderParameterNames.JWK).getString(JWKParameterNames.RSA_EXPONENT)).decode());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    KeyPairGenerator keyPairGenerator = null;
                    try {
                        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    keyPairGenerator.initialize(2048);
                    keyPairGenerator.genKeyPair();
                    KeyFactory keyFactory = null; // JC
                    try {
                        keyFactory = KeyFactory.getInstance("RSA");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(bigInteger, bigInteger2);
                    RSAPrivateKeySpec rSAPrivateKeySpec = new RSAPrivateKeySpec(bigInteger, bigInteger2);
                    PublicKey generatePublic = null; // JC
                    try {
                        generatePublic = keyFactory.generatePublic(rSAPublicKeySpec);
                    } catch (InvalidKeySpecException e) {
                        throw new RuntimeException(e);
                    }
                    Objects.requireNonNull(generatePublic, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
                    RSAPublicKey rSAPublicKey = (RSAPublicKey) generatePublic;
                    PrivateKey generatePrivate = null; // JC
                    try {
                        generatePrivate = keyFactory.generatePrivate(rSAPrivateKeySpec);
                    } catch (InvalidKeySpecException e) {
                        throw new RuntimeException(e);
                    }
                    Objects.requireNonNull(generatePrivate, "null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
                    Log.e("publicRSAKey", "Is " + rSAPublicKey + "   privateRSAKey== " + ((RSAPrivateKey) generatePrivate));
                    JWEObject jWEObject = new JWEObject(new JWEHeader.Builder(new JWEHeader(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128CBC_HS256)).keyID(obj.toString()).build(), new Payload(str));
                    // JC
                    try {
                        jWEObject.encrypt(new RSAEncrypter(rSAPublicKey));
                    } catch (JOSEException e) {
                        throw new RuntimeException(e);
                    }
                    PhysicalCardConfirmPINActivity.getEditPinRequestModel().setId(PhysicalCardConfirmPINActivity.getId());
                    EditPinRequestModel editPinRequestModel = PhysicalCardConfirmPINActivity.getEditPinRequestModel();
                    String serialize = jWEObject.serialize();
                    Intrinsics.checkNotNullExpressionValue(serialize, "jweObj.serialize()");
                    editPinRequestModel.setPin(serialize);
                    PhysicalCardConfirmPINActivity.setPinEncrypted(jWEObject.serialize());
                    SaveAddressRequestModel saveAddressRequestModelGloble = Constants.INSTANCE.getSaveAddressRequestModelGloble();
                    if (saveAddressRequestModelGloble != null) {
                        saveAddressRequestModelGloble.setPin(jWEObject.serialize());
                    }
                    Log.e("Final Object", "Confirm PIN " + new Gson().toJson(Constants.INSTANCE.getSaveAddressRequestModelGloble()));
                    PhysicalCardConfirmPINActivity.startActivity(PhysicalCardReviewOrderActivity.class);
                    PhysicalCardConfirmPINActivity.finish();
                    Log.e("FINAL", "DATA=====  " + jWEObject.serialize());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e("stripeKeyResponseModel", "Is Failure");
            }
        });
    }
}