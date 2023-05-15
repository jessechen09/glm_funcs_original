package com.example.glm_funcs_original;

import android.util.Base64;

import java.nio.charset.Charset;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Function2621 {
    private C5325g firebase;

    public String decode(String str, String str2) throws PFSecurityException {
        byte[] $r4;
        Log_OC.getArray(str, "alias");
        Log_OC.getArray(str2, "encodedString");
        try {
            Cipher $r3 = getCipherInstance();
            initDecodeCipher($r3, str);
            byte[] $r42 = Base64.decode(str2, 2);
            if ($r3 == null || ($r4 = $r3.doFinal($r42)) == null) {
                return null;
            }
            Charset $r5 = C13254d.f29413a;
            String $r1 = new String($r4, $r5);
            return $r1;
        } catch (IllegalStateException $r6) {
            String $r12 = $r6.getMessage();
            String $r13 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r12);
            PFSecurityUtilsErrorCodes $r8 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r8.getERROR_DEENCODING();
            Integer $r9 = Integer.valueOf($i0);
            PFSecurityException $r7 = new PFSecurityException($r13, $r9);
            Timber.reorder($r7);
            C5325g $r10 = this.firebase;
            $r10.m25120d($r7);
            return null;
        } catch (BadPaddingException $r11) {
            String $r14 = $r11.getMessage();
            String $r15 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r14);
            PFSecurityUtilsErrorCodes $r82 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r82.getERROR_DEENCODING();
            Integer $r92 = Integer.valueOf($i02);
            PFSecurityException $r72 = new PFSecurityException($r15, $r92);
            Timber.reorder($r72);
            C5325g $r102 = this.firebase;
            $r102.m25120d($r72);
            return null;
        } catch (IllegalBlockSizeException $r122) {
            String $r16 = $r122.getMessage();
            String $r17 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r16);
            PFSecurityUtilsErrorCodes $r83 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i03 = $r83.getERROR_DEENCODING();
            Integer $r93 = Integer.valueOf($i03);
            PFSecurityException $r73 = new PFSecurityException($r17, $r93);
            Timber.reorder($r73);
            C5325g $r103 = this.firebase;
            $r103.m25120d($r73);
            return null;
        }
    }

    private Cipher getCipherInstance() {
        return null;
    }

    private void initDecodeCipher(Cipher $r3, String str) {
    }
}