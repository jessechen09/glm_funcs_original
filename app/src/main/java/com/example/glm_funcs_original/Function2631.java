
package com.example.glm_funcs_original;
import java.security.*;

public class Function2631 {
      public void deleteKey(String str) throws PFSecurityException {
        Log_OC.getArray(str, "alias");
        KeyStore $r2 = loadKeyStore();
        try {
            $r2.deleteEntry(str);
        } catch (KeyStoreException $r3) {
            $r3.printStackTrace();
            String $r1 = $r3.getMessage();
            String $r12 = Log_OC.m10359a("Can not delete key: ", (Object) $r1);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_DELETE_KEY();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r4 = new PFSecurityException($r12, $r6);
            throw $r4;
        }
    }

    private KeyStore loadKeyStore() {
          return null;
    }
}