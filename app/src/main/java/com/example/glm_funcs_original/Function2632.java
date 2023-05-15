package com.example.glm_funcs_original;
import java.security.*;

public class Function2632 {
      public boolean isKeystoreContainAlias(String str) throws PFSecurityException {
        Log_OC.getArray(str, "alias");
        KeyStore $r2 = loadKeyStore();
        try {
            boolean $z0 = $r2.containsAlias(str);
            return $z0;
        } catch (KeyStoreException $r3) {
            $r3.printStackTrace();
            String $r1 = $r3.getMessage();
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_KEY_STORE();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r4 = new PFSecurityException($r1, $r6);
            throw $r4;
        }
    }

    private KeyStore loadKeyStore() {
          return null;
    }
}