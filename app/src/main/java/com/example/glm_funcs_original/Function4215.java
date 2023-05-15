
package com.example.glm_funcs_original;

import android.util.Log;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Objects;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Function4215 {
    public final void getStripeKeyData(final String str) {
        //        Call<ResponseBody> stripeKey = ((APICall) Retrofit.Singleton.getRetrofitStripe().create(APICall.class)).getStripeKey();
        Call<ResponseBody> stripeKey = null; // JC
        if (stripeKey != null) {
            stripeKey.enqueue(new Callback<ResponseBody>() { // from class: com.app.jeeves.homeScreen.cards.EditPinActivty$getStripeKeyData$1
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
                        KeyPairGenerator keyPairGenerator = null; // JC
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
                        try { // JC
                            generatePrivate = keyFactory.generatePrivate(rSAPrivateKeySpec);
                        } catch (InvalidKeySpecException e) {
                            throw new RuntimeException(e);
                        }
                        Objects.requireNonNull(generatePrivate, "null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
                        Log.e("publicRSAKey", "Is " + rSAPublicKey + "   privateRSAKey== " + ((RSAPrivateKey) generatePrivate));
                        JWEObject jWEObject = new JWEObject(new JWEHeader.Builder(new JWEHeader(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128CBC_HS256)).keyID(obj.toString()).build(), new Payload(str));
                        try {
                            jWEObject.encrypt(new RSAEncrypter(rSAPublicKey));
                        } catch (JOSEException e) {
                            throw new RuntimeException(e);
                        }
                        EditPinActivty.getEditPinRequestModel().setId(EditPinActivty.getId());
                        EditPinRequestModel editPinRequestModel = EditPinActivty.getEditPinRequestModel();
                        String serialize = jWEObject.serialize();
                        Intrinsics.checkNotNullExpressionValue(serialize, "jweObj.serialize()");
                        editPinRequestModel.setPin(serialize);
                        EditPinActivty.getEditPinVM().cardPinSetup(EditPinActivty.getEditPinRequestModel());
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
}