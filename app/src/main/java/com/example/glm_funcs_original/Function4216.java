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
import retrofit2.Response;

public class Function4216 {
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) throws IOException, JSONException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 200) {
            ResponseBody body = response.body();
            JSONObject jSONObject = new JSONObject(body != null ? body.string() : null);
            Object obj = jSONObject.get("key_id");
            Log.e("stripeKeyResponseModel", "Is " + jSONObject.get("key_id"));
            BigInteger bigInteger = new BigInteger(1, new Base64URL(jSONObject.getJSONObject(HeaderParameterNames.JWK).getString(JWKParameterNames.RSA_MODULUS)).decode());
            BigInteger bigInteger2 = new BigInteger(1, new Base64URL(jSONObject.getJSONObject(HeaderParameterNames.JWK).getString(JWKParameterNames.RSA_EXPONENT)).decode());
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPairGenerator.genKeyPair();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(bigInteger, bigInteger2);
            RSAPrivateKeySpec rSAPrivateKeySpec = new RSAPrivateKeySpec(bigInteger, bigInteger2);
            PublicKey generatePublic = keyFactory.generatePublic(rSAPublicKeySpec);
            Objects.requireNonNull(generatePublic, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generatePublic;
            PrivateKey generatePrivate = keyFactory.generatePrivate(rSAPrivateKeySpec);
            Objects.requireNonNull(generatePrivate, "null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
            Log.e("publicRSAKey", "Is " + rSAPublicKey + "   privateRSAKey== " + ((RSAPrivateKey) generatePrivate));
            byte[] str = null; // JC
            JWEObject jWEObject = new JWEObject(new JWEHeader.Builder(new JWEHeader(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128CBC_HS256)).keyID(obj.toString()).build(), new Payload(str));
            jWEObject.encrypt(new RSAEncrypter(rSAPublicKey));
            EditPinActivty.getEditPinRequestModel().setId(EditPinActivty.getId());
            EditPinRequestModel editPinRequestModel = EditPinActivty.getEditPinRequestModel();
            String serialize = jWEObject.serialize();
            Intrinsics.checkNotNullExpressionValue(serialize, "jweObj.serialize()");
            editPinRequestModel.setPin(serialize);
            EditPinActivty.getEditPinVM().cardPinSetup(EditPinActivty.getEditPinRequestModel());
            Log.e("FINAL", "DATA=====  " + jWEObject.serialize());
        }
    }
}