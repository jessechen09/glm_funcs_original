package com.example.glm_funcs_original;

import android.util.Log;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class Function2620 {
      private final KeyStore loadKeyStore() throws PFSecurityException {
        try {
            KeyStore $r1 = KeyStore.getInstance("AndroidKeyStore");
            $r1.load(null);
            return $r1;
        } catch (IOException $r2) {
            String $r4 = $r2.getMessage();
            String $r42 = Log_OC.m10359a("Can not load keystore:", (Object) $r4);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_LOAD_KEY_STORE();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r3 = new PFSecurityException($r42, $r6);
            Timber.reorder($r3);
            C5325g $r7 = this.firebase;
            $r7.m25120d($r3);
            return null;
        } catch (KeyStoreException $r10) {
            String $r43 = $r10.getMessage();
            String $r44 = Log_OC.m10359a("Can not load keystore:", (Object) $r43);
            PFSecurityUtilsErrorCodes $r52 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r52.getERROR_LOAD_KEY_STORE();
            Integer $r62 = Integer.valueOf($i02);
            PFSecurityException $r32 = new PFSecurityException($r44, $r62);
            Timber.reorder($r32);
            C5325g $r72 = this.firebase;
            $r72.m25120d($r32);
            return null;
        } catch (NoSuchAlgorithmException $r9) {
            String $r45 = $r9.getMessage();
            String $r46 = Log_OC.m10359a("Can not load keystore:", (Object) $r45);
            PFSecurityUtilsErrorCodes $r53 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i03 = $r53.getERROR_LOAD_KEY_STORE();
            Integer $r63 = Integer.valueOf($i03);
            PFSecurityException $r33 = new PFSecurityException($r46, $r63);
            Timber.reorder($r33);
            C5325g $r73 = this.firebase;
            $r73.m25120d($r33);
            return null;
        } catch (CertificateException $r8) {
            String $r47 = $r8.getMessage();
            String $r48 = Log_OC.m10359a("Can not load keystore:", (Object) $r47);
            PFSecurityUtilsErrorCodes $r54 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i04 = $r54.getERROR_LOAD_KEY_STORE();
            Integer $r64 = Integer.valueOf($i04);
            PFSecurityException $r34 = new PFSecurityException($r48, $r64);
            Timber.reorder($r34);
            C5325g $r74 = this.firebase;
            $r74.m25120d($r34);
            return null;
        }
    }
}