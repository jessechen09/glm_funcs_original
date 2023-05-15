package com.example.glm_funcs_original;
import java.io.ByteArrayInputStream;
import java.security.*;
import java.util.ArrayList;

import javax.crypto.*;
public class Function2629 {
    private static final String RSA_MODE = "";
    private static final String PROVIDER = "";

    private final byte[] rsaDecrypt(byte[] bArr, String str) throws Exception {
        KeyStore $r3 = loadKeyStore();
        KeyStore.Entry $r4 = $r3.getEntry(str, null);
        if ($r4 == null) {
            NullPointerException $r17 = new NullPointerException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
            throw $r17;
        }
        KeyStore.PrivateKeyEntry $r5 = (KeyStore.PrivateKeyEntry) $r4;
        String $r2 = RSA_MODE;
        String $r6 = PROVIDER;
        Cipher $r7 = Cipher.getInstance($r2, $r6);
        PrivateKey $r8 = $r5.getPrivateKey();
        $r7.init(2, $r8);
        ByteArrayInputStream $r10 = new ByteArrayInputStream(bArr);
        CipherInputStream $r9 = new CipherInputStream($r10, $r7);
        ArrayList $r11 = new ArrayList();
        C11811v $r12 = new C11811v();
        $r12.f26498c = -1;
        while (true) {
            PFSecurityUtilsOld$rsaDecrypt$1 $r13 = new PFSecurityUtilsOld$rsaDecrypt$1($r12, $r9);
            Number $r15 = (Number) $r13.invoke();
            int $i0 = $r15.intValue();
            if ($i0 == -1) {
                break;
            }
            int $i02 = $r12.f26498c;
            byte $b1 = (byte) $i02;
            Byte $r16 = Byte.valueOf($b1);
            $r11.add($r16);
        }
        int $i2 = $r11.size();
        byte[] $r1 = new byte[$i2];
        int $i03 = 0;
        int $i22 = $i2 - 1;
        if ($i22 < 0) {
            return $r1;
        }
        while (true) {
            int $i3 = $i03 + 1;
            Object $r14 = $r11.get($i03);
            Log_OC.loadImage($r14, "values[i]");
            Number $r152 = (Number) $r14;
            byte $b12 = $r152.byteValue();
            $r1[$i03] = $b12;
            if ($i3 > $i22) {
                return $r1;
            }
            $i03 = $i3;
        }
    }

    private KeyStore loadKeyStore() {
        return null;
    }
}