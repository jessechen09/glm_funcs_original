package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Function2613 {
    private C5325g firebase;

    private final String decode(String str, Cipher cipher) throws PFSecurityException {
        try {
            byte[] $r3 = cipher.doFinal(Base64.decode(str, 2));
            Log_OC.loadImage($r3, "cipher.doFinal(bytes)");
            Charset $r4 = C13254d.f29413a;
            String $r1 = new String($r3, $r4);
            return $r1;
        } catch (BadPaddingException $r5) {
            String $r12 = $r5.getMessage();
            String $r13 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r12);
            PFSecurityUtilsErrorCodes $r7 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r7.getERROR_DEENCODING();
            Integer $r8 = Integer.valueOf($i0);
            PFSecurityException $r6 = new PFSecurityException($r13, $r8);
            Timber.reorder($r6);
            C5325g $r9 = this.firebase;
            $r9.m25120d($r6);
            return "";
        } catch (IllegalBlockSizeException $r10) {
            String $r14 = $r10.getMessage();
            String $r15 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r14);
            PFSecurityUtilsErrorCodes $r72 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r72.getERROR_DEENCODING();
            Integer $r82 = Integer.valueOf($i02);
            PFSecurityException $r62 = new PFSecurityException($r15, $r82);
            Timber.reorder($r62);
            C5325g $r92 = this.firebase;
            $r92.m25120d($r62);
            return "";
        }
    }
}