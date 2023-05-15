package com.example.glm_funcs_original;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class Function2628 {
      private final KeyStore loadKeyStore() throws PFSecurityException {
        try {
            KeyStore $r1 = KeyStore.getInstance("AndroidKeyStore");
            $r1.load(null);
            Log_OC.loadImage($r1, "keyStore");
            return $r1;
        } catch (IOException $r2) {
            $r2.printStackTrace();
            String $r4 = $r2.getMessage();
            String $r42 = Log_OC.m10359a("Can not load keystore:", (Object) $r4);
            PFSecurityUtilsErrorCodes $r5 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i0 = $r5.getERROR_LOAD_KEY_STORE();
            Integer $r6 = Integer.valueOf($i0);
            PFSecurityException $r3 = new PFSecurityException($r42, $r6);
            throw $r3;
        } catch (KeyStoreException $r9) {
            $r9.printStackTrace();
            String $r43 = $r9.getMessage();
            String $r44 = Log_OC.m10359a("Can not load keystore:", (Object) $r43);
            PFSecurityUtilsErrorCodes $r52 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i02 = $r52.getERROR_LOAD_KEY_STORE();
            Integer $r62 = Integer.valueOf($i02);
            PFSecurityException $r32 = new PFSecurityException($r44, $r62);
            throw $r32;
        } catch (NoSuchAlgorithmException $r8) {
            $r8.printStackTrace();
            String $r45 = $r8.getMessage();
            String $r46 = Log_OC.m10359a("Can not load keystore:", (Object) $r45);
            PFSecurityUtilsErrorCodes $r53 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i03 = $r53.getERROR_LOAD_KEY_STORE();
            Integer $r63 = Integer.valueOf($i03);
            PFSecurityException $r33 = new PFSecurityException($r46, $r63);
            throw $r33;
        } catch (CertificateException $r7) {
            $r7.printStackTrace();
            String $r47 = $r7.getMessage();
            String $r48 = Log_OC.m10359a("Can not load keystore:", (Object) $r47);
            PFSecurityUtilsErrorCodes $r54 = PFSecurityUtilsErrorCodes.INSTANCE;
            int $i04 = $r54.getERROR_LOAD_KEY_STORE();
            Integer $r64 = Integer.valueOf($i04);
            PFSecurityException $r34 = new PFSecurityException($r48, $r64);
            throw $r34;
        }
    }
}