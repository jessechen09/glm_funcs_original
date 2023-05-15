package com.example.glm_funcs_original;

import android.content.Context;
import android.util.Base64;

import java.nio.charset.Charset;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Function2623 {
    public String encode(Context context, String str, String str2, boolean z) throws PFSecurityException {
        byte[] $r5;
        Log_OC.getArray(String.valueOf(context), "context");
        Log_OC.getArray(str, "alias");
        // Log_OC.getArray(str2, MetricTracker.Object.INPUT); // JC
        try {
            Cipher $r4 = getEncodeCipher(context, str, z);
            if ($r4 == null) {
                $r5 = null;
            } else {
                Charset $r6 = C13254d.f29413a;
                byte[] $r52 = str2.getBytes($r6);
                Log_OC.loadImage($r52, "(this as java.lang.String).getBytes(charset)");
                $r5 = $r4.doFinal($r52);
            }
            String $r2 = Base64.encodeToString($r5, 2);
            Log_OC.loadImage($r2, "encodeToString(bytes, Base64.NO_WRAP)");
            return $r2;
        } catch (BadPaddingException $r7) {
            $r7.printStackTrace();
            String $r22 = $r7.getMessage();
            String $r23 = Log_OC.m10359a("Error while encoding : ", (Object) $r22);
            PFSecurityUtilsErrorCodes $r9 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r9.getERROR_ENCODING();
            Integer $r10 = Integer.valueOf($i0);
            PFSecurityException $r8 = new PFSecurityException($r23, $r10);
            throw $r8;
        } catch (IllegalBlockSizeException $r11) {
            $r11.printStackTrace();
            String $r24 = $r11.getMessage();
            String $r25 = Log_OC.m10359a("Error while encoding : ", (Object) $r24);
            PFSecurityUtilsErrorCodes $r92 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r92.getERROR_ENCODING();
            Integer $r102 = Integer.valueOf($i02);
            PFSecurityException $r82 = new PFSecurityException($r25, $r102);
            throw $r82;
        }
    }

    private Cipher getEncodeCipher(Context context, String str, boolean z) {
        return null;
    }
}