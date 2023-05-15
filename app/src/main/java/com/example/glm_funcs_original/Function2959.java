package com.example.glm_funcs_original;

import android.icu.util.Calendar;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;

import androidx.arch.core.executor.ArchTaskExecutor;

import org.jetbrains.annotations.NotNull;

import java.security.KeyPairGenerator;
import java.security.KeyStore;

import javax.security.auth.x500.X500Principal;

import kotlin.jvm.internal.Intrinsics;

public class Function2959 {
      public static final void generateKeyPairIfNeeded(@NotNull String keyAlias) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        if (Build.VERSION.SDK_INT >= 23) {
            return;
        }
        try {
            String ANDROID_KEY_STORE="";
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            if (keyStore.containsAlias(keyAlias)) {
                return;
            }
            KeyPairGeneratorSpec.Builder startDate = new KeyPairGeneratorSpec.Builder(UpKeepApplication.getInstance()).setAlias(keyAlias).setSubject(new X500Principal("CN=Upkeep")).setSerialNumber(KtUtilsKt.getRandomBigInteger()).setStartDate(Calendar.getInstance().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(1, 25);
            KeyPairGeneratorSpec build = startDate.setEndDate(calendar.getTime()).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(UpKeepApplicatio…                 .build()");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", ANDROID_KEY_STORE);
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            Timber.m48e(e, "Failed to create RSA secret key pair", new Object[0]);
        }
    }
}