package com.example.glm_funcs_original;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class Function2622 {
    private C5325g firebase;

    public void deleteKey(String str) throws PFSecurityException {
        Log_OC.getArray(str, "alias");
        KeyStore $r2 = loadKeyStore();
        if ($r2 == null) {
            return;
        }
        try {
            $r2.deleteEntry(str);
        } catch (KeyStoreException $r3) {
            String $r1 = $r3.getMessage();
            String $r12 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r1);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_DELETE_KEY();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r4 = new PFSecurityException($r12, $r6);
            Timber.reorder($r4);
            C5325g $r7 = this.firebase;
            $r7.m25120d($r4);
            PFSecurityUtilsErrorCodes $r52 = PFSecurityUtilsErrorCodes.INSTANCE;
            $r52.getERROR_DELETE_KEY();
        }
    }

    private KeyStore loadKeyStore() {
          return null;
    }
}