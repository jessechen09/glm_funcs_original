package com.example.glm_funcs_original;

import java.security.*;
import javax.crypto.*;


public class Function2616 {
    private C5325g firebase;

    private final Cipher getCipherInstance() throws PFSecurityException {
        try {
            Cipher $r1 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            return $r1;
        } catch (NoSuchAlgorithmException $r8) {
            String $r4 = $r8.getMessage();
            String $r42 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r4);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_GET_CIPHER_INSTANCE();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r3 = new PFSecurityException($r42, $r6);
            Timber.reorder($r3);
            C5325g $r7 = this.firebase;
            $r7.m25120d($r3);
            return null;
        } catch (NoSuchPaddingException $r2) {
            String $r43 = $r2.getMessage();
            String $r44 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r43);
            PFSecurityUtilsErrorCodes $r52 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r52.getERROR_GET_CIPHER_INSTANCE();
            Integer $r62 = Integer.valueOf($i02);
            PFSecurityException $r32 = new PFSecurityException($r44, $r62);
            Timber.reorder($r32);
            C5325g $r72 = this.firebase;
            $r72.m25120d($r32);
            return null;
        }
    }
}