public class Function23054 {
              public final String m24077b(String str) {
                String str2;
                IOException e;
                int i = 302;
                int i2 = 0;
                while (i == 302 && i2 < 15) {
                    try {
                        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
                        if (uRLConnection != null) {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && httpURLConnection.getHeaderFields().containsKey("Location")) {
                                C23942a.m18497g(C25938n.m13474p("[PodcastDownloadService] getLastRedirectUrl() -> Next location: ", str), new Object[0]);
                                str2 = httpURLConnection.getHeaderField("Location");
                                C25938n.m13483g(str2, "con.getHeaderField(\"Location\")");
                                try {
                                    httpURLConnection.disconnect();
                                    i2++;
                                    i = responseCode;
                                    str = str2;
                                } catch (IOException e2) {
                                    e = e2;
                                    C10273o0.m40433a(e);
                                    return str2;
                                }
                            }
                            httpURLConnection.disconnect();
                            C23942a.m18497g(C25938n.m13474p("[PodcastDownloadService] getLastRedirectUrl() -> Final location: ", str), new Object[0]);
                            return str;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    } catch (IOException e3) {
                        str2 = str;
                        e = e3;
                    }
                }
                return str;
            }
}