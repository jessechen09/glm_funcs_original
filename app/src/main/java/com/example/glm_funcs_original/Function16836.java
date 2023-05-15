public class Function16836 {
      private final Certificate m19579a(int i) {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f34137b.getResources().openRawResource(i));
        try {
            Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            Unit unit = Unit.f44613a;
            CloseableKt.m10316a(bufferedInputStream, null);
            return generateCertificate;
        } finally {
        }
    }
}