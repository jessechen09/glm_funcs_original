public class Function14049 {
          private String getTitleFromUrl(String str) {
            URL url;
            String host;
            String file;
            try {
                url = new URL(str);
                host = url.getHost();
            } catch (Exception unused) {
            }
            if (host == null || host.isEmpty()) {
                return (!str.startsWith("file:") || (file = url.getFile()) == null || file.isEmpty()) ? str : file;
            }
            return url.getProtocol() + "://" + host;
        }
}