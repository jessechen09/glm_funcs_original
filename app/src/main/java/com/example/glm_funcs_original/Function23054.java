
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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import io.jsonwebtoken.UnsupportedJwtException;
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
public class Function23054 {
              public final String m24077b(String str) {
                String str2;
                IOException e;
                int i = 302;
                int i2 = 0;
                while (i == 302 && i2 < 15) {
                    try {
                        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
                        if (uRLConnection != null) {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && httpURLConnection.getHeaderFields().containsKey("Location")) {
                                C23942a.m18497g(C25938n.m13474p("[PodcastDownloadService] getLastRedirectUrl() -> Next location: ", str), new Object[0]);
                                str2 = httpURLConnection.getHeaderField("Location");
                                C25938n.m13483g(str2, "con.getHeaderField(\"Location\")");

                                // JC, IOException not thrown
                                httpURLConnection.disconnect();
                                i2++;
                                i = responseCode;
                                str = str2;

                                // JC
//                                try {
//                                    httpURLConnection.disconnect();
//                                    i2++;
//                                    i = responseCode;
//                                    str = str2;
//                                } catch (IOException e2) {
//                                    e = e2;
//                                    C10273o0.m40433a(e);
//                                    return str2;
//                                }
                            }
                            httpURLConnection.disconnect();
                            C23942a.m18497g(C25938n.m13474p("[PodcastDownloadService] getLastRedirectUrl() -> Final location: ", str), new Object[0]);
                            return str;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    } catch (IOException e3) {
                        str2 = str;
                        e = e3;
                    }
                }
                return str;
            }
}