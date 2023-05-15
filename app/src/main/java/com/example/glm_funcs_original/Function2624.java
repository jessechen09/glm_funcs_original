package com.example.glm_funcs_original;
import java.security.*;

public class Function2624 {
    private C5325g firebase;

    public boolean isKeystoreContainAlias(String str) throws PFSecurityException {
        Log_OC.getArray(str, "alias");
        KeyStore $r2 = loadKeyStore();
        if ($r2 == null) {
            return false;
        }
        try {
            boolean $z0 = $r2.containsAlias(str);
            return $z0;
        } catch (KeyStoreException $r3) {
            String $r1 = $r3.getMessage();
            String $r12 = Log_OC.m10359a("Can not initialize Encode Cipher:", (Object) $r1);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_KEY_STORE();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r4 = new PFSecurityException($r12, $r6);
            Timber.reorder($r4);
            C5325g $r7 = this.firebase;
            $r7.m25120d($r4);
            return false;
        }
    }

    private KeyStore loadKeyStore() {
          return null;
    }
}