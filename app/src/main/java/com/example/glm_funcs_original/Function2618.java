package com.example.glm_funcs_original;

import java.security.*;
import javax.crypto.*;

public class Function2618 {
    private C5325g firebase;

    private final void initDecodeCipher(Cipher cipher, String str) throws PFSecurityException {
        try {
            KeyStore $r3 = loadKeyStore();
            Key $r5 = $r3 == null ? null : $r3.getKey(str, null);
            boolean $z0 = $r5 instanceof PrivateKey;
            PrivateKey $r4 = $z0 ? (PrivateKey) $r5 : null;
            if (cipher == null) {
                return;
            }
            cipher.init(2, $r4);
        } catch (InvalidKeyException $r6) {
            String $r2 = $r6.getMessage();
            String $r22 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r2);
            PFSecurityUtilsErrorCodes $r8 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r8.getERROR_INIT_DECODE_CIPHER();
            Integer $r9 = Integer.valueOf($i0);
            PFSecurityException $r7 = new PFSecurityException($r22, $r9);
            Timber.reorder($r7);
            C5325g $r10 = this.firebase;
            $r10.m25120d($r7);
        } catch (KeyStoreException $r13) {
            String $r23 = $r13.getMessage();
            String $r24 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r23);
            PFSecurityUtilsErrorCodes $r82 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r82.getERROR_INIT_DECODE_CIPHER();
            Integer $r92 = Integer.valueOf($i02);
            PFSecurityException $r72 = new PFSecurityException($r24, $r92);
            Timber.reorder($r72);
            C5325g $r102 = this.firebase;
            $r102.m25120d($r72);
        } catch (NoSuchAlgorithmException $r12) {
            String $r25 = $r12.getMessage();
            String $r26 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r25);
            PFSecurityUtilsErrorCodes $r83 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i03 = $r83.getERROR_INIT_DECODE_CIPHER();
            Integer $r93 = Integer.valueOf($i03);
            PFSecurityException $r73 = new PFSecurityException($r26, $r93);
            Timber.reorder($r73);
            C5325g $r103 = this.firebase;
            $r103.m25120d($r73);
        } catch (UnrecoverableKeyException $r11) {
            String $r27 = $r11.getMessage();
            String $r28 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r27);
            PFSecurityUtilsErrorCodes $r84 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i04 = $r84.getERROR_INIT_DECODE_CIPHER();
            Integer $r94 = Integer.valueOf($i04);
            PFSecurityException $r74 = new PFSecurityException($r28, $r94);
            Timber.reorder($r74);
            C5325g $r104 = this.firebase;
            $r104.m25120d($r74);
        }
    }

    private KeyStore loadKeyStore() {
        return null;
    }
}