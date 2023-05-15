package com.example.glm_funcs_original;
import android.content.Context;

import java.security.*;
public class Function2626 {
      private final boolean generateKeyIfNecessary(Context context, KeyStore keyStore, String str, boolean z) {
        try {
            boolean $z1 = keyStore.containsAlias(str);
            if ($z1) {
                return true;
            }
            boolean $z0 = generateKey(context, str, z);
            return $z0;
        } catch (KeyStoreException $r4) {
            $r4.printStackTrace();
            return false;
        }
    }

    private boolean generateKey(Context context, String str, boolean z) {
          return true;
    }
}