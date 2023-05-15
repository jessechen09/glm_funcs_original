package com.example.glm_funcs_original;
import java.io.IOException;

import javax.crypto.*;
public class Function2625 {
    private CipherInputStream $cipherInputStream;
    private C11811v $nextByte;

    public final int invoke2() throws IOException {
        C11811v $r1 = this.$nextByte;
        CipherInputStream $r2 = this.$cipherInputStream;
        int $i0 = $r2.read();
        $r1.f26498c = $i0;
        C11811v $r12 = this.$nextByte;
        int $i02 = $r12.f26498c;
        return $i02;
    }
}