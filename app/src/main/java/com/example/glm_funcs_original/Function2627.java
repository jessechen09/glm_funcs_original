package com.example.glm_funcs_original;
import android.content.Context;
import android.icu.util.Calendar;
import android.security.KeyPairGeneratorSpec;

import java.math.BigInteger;
import java.security.*;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

public class Function2627 {
      private final boolean generateKeyOld(Context context, String str, boolean z) {
        try {
            Calendar $r3 = Calendar.getInstance();
            Calendar $r4 = Calendar.getInstance();
            $r4.add(1, 25);
            KeyPairGenerator $r5 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            KeyPairGeneratorSpec.Builder $r6 = new KeyPairGeneratorSpec.Builder(context);
            KeyPairGeneratorSpec.Builder $r62 = $r6.setAlias(str);
            String $r8 = Log_OC.m10359a("CN=", (Object) str);
            X500Principal $r7 = new X500Principal($r8);
            KeyPairGeneratorSpec.Builder $r63 = $r62.setSubject($r7);
            int $i0 = str.hashCode();
            long $l1 = Math.abs($i0);
            BigInteger $r9 = BigInteger.valueOf($l1);
            KeyPairGeneratorSpec.Builder $r64 = $r63.setSerialNumber($r9);
            Date $r10 = $r4.getTime();
            KeyPairGeneratorSpec.Builder $r65 = $r64.setEndDate($r10);
            Date $r102 = $r3.getTime();
            KeyPairGeneratorSpec.Builder $r66 = $r65.setStartDate($r102);
            BigInteger $r92 = BigInteger.ONE;
            KeyPairGeneratorSpec.Builder $r67 = $r66.setSerialNumber($r92);
            X500Principal $r72 = new X500Principal("CN = Secured Preference Store, O = Devliving Online");
            KeyPairGeneratorSpec $r11 = $r67.setSubject($r72).build();
            Log_OC.loadImage($r11, "Builder(context)\n                    .setAlias(keystoreAlias)\n                    .setSubject(X500Principal(\"CN=$keystoreAlias\"))\n                    .setSerialNumber(\n                            BigInteger.valueOf(Math.abs(keystoreAlias.hashCode()).toLong()))\n                    .setEndDate(end.time)\n                    .setStartDate(start.time)\n                    .setSerialNumber(BigInteger.ONE)\n                    .setSubject(X500Principal(\n                            \"CN = Secured Preference Store, O = Devliving Online\")\n                    )\n                    .build()");
            $r5.initialize($r11);
            $r5.generateKeyPair();
            return true;
        } catch (InvalidAlgorithmParameterException $r12) {
            $r12.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException $r14) {
            $r14.printStackTrace();
            return false;
        } catch (NoSuchProviderException $r13) {
            $r13.printStackTrace();
            return false;
        }
    }
}