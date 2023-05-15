
package com.example.glm_funcs_original;

import java.io.BufferedInputStream;
import java.security.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
public class Function16836 {

    private final Certificate m19579a(int i) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f34137b.getResources().openRawResource(i));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(null); // JC
        try {
            Certificate generateCertificate = (Certificate) certificateFactory.generateCertificate(bufferedInputStream);
            Unit unit = Unit.f44613a;
            CloseableKt.m10316a(bufferedInputStream, null);
            return generateCertificate;
        } finally {
        }
    }
}