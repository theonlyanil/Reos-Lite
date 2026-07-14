package com.android.library.http.d;

import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.http.models.AbstractFileUploadDownload;
import com.google.android.gms.location.places.Place;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f2699a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f2700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OutputStream f2701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PrintWriter f2702d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private URL f2704f;
    private int h;
    private final HTTPLibrary.a i;
    private final long g = System.currentTimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2703e = "---------------------------" + System.currentTimeMillis();

    public b(HTTPLibrary.a aVar, int i, String str, int i2) throws IOException {
        this.i = aVar;
        this.h = i;
        this.f2704f = new URL(str);
        this.f2700b = (HttpURLConnection) this.f2704f.openConnection();
        this.f2700b.setConnectTimeout(i2 * 1000);
        this.f2700b.setReadTimeout(i2 * 1000);
        this.f2700b.setRequestMethod("POST");
        this.f2700b.setRequestProperty("Accept-Charset", "UTF-8");
        this.f2700b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f2703e);
        this.f2700b.setUseCaches(false);
        this.f2700b.setDoInput(true);
        this.f2700b.setDoOutput(true);
        this.f2700b.setChunkedStreamingMode(Place.TYPE_SUBLOCALITY_LEVEL_2);
        this.f2701c = this.f2700b.getOutputStream();
        this.f2702d = new PrintWriter((Writer) new OutputStreamWriter(this.f2701c, "UTF-8"), true);
    }

    public void a() throws IOException {
        if (this.f2700b == null) {
            CLog.d("HTTPLibrary", "IO Exception uploading the file");
            this.i.c(this.h, "IO Exception uploading the file", 600);
            return;
        }
        StringBuilder sb = new StringBuilder();
        this.f2702d.append((CharSequence) "\r\n").append((CharSequence) "--").append((CharSequence) this.f2703e).append((CharSequence) "--").append((CharSequence) "\r\n");
        this.f2702d.close();
        int responseCode = this.f2700b.getResponseCode();
        try {
            if (responseCode != 200) {
                this.i.b(this.h, this.f2700b.getResponseMessage(), responseCode);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f2700b.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    this.i.a(this.h, sb.toString(), responseCode);
                    f2699a.log(Level.INFO, MessageFormat.format("{0} took {4} ms", this.f2704f, Long.valueOf(System.currentTimeMillis() - this.g)));
                    return;
                }
                sb.append(line);
            }
        } catch (SocketTimeoutException e2) {
            CLog.d("HTTPLibrary", "In the Socket Timeout exception");
            CLog.d("HTTPLibrary", e2.getMessage());
            this.i.c(this.h, e2.getLocalizedMessage(), 408);
        } catch (Exception e3) {
            CLog.d("HTTPLibrary", "In the catch exception");
            CLog.d("HTTPLibrary", e3.getMessage());
            this.i.b(this.h, e3.getLocalizedMessage(), 400);
        } finally {
            CLog.d("HTTPLibrary", "In the finally block");
            this.f2701c.flush();
            this.f2701c.close();
            System.gc();
            this.f2700b.disconnect();
        }
    }

    public void a(String str, File file) throws IOException {
        int i = 0;
        String name = file.getName();
        this.f2702d.append((CharSequence) "--").append((CharSequence) this.f2703e).append((CharSequence) "\r\n").append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) str).append((CharSequence) "\"; filename=\"").append((CharSequence) name).append((CharSequence) "\"").append((CharSequence) "\r\n").append((CharSequence) "Content-Type: ").append((CharSequence) URLConnection.guessContentTypeFromName(name)).append((CharSequence) "\r\n").append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n").append((CharSequence) "\r\n");
        this.f2702d.flush();
        this.f2701c.flush();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                this.f2701c.write(bArr, 0, i2);
                AbstractFileUploadDownload abstractFileUploadDownload = new AbstractFileUploadDownload();
                abstractFileUploadDownload.b((int) (file.length() / Math.pow(1024.0d, 2.0d)));
                abstractFileUploadDownload.a((int) (((long) (i * 100)) / file.length()));
                abstractFileUploadDownload.a(i);
                this.i.a(this.h, abstractFileUploadDownload);
                i += i2;
            }
            this.f2701c.flush();
        } catch (IOException e2) {
            CLog.d("HTTPLibrary", e2.getMessage());
            CLog.d("HTTPLibrary", "IO Exception in addFilePart");
            this.f2700b.disconnect();
            this.f2700b = null;
        } catch (Exception e3) {
            CLog.d("HTTPLibrary", e3.getMessage());
            CLog.d("HTTPLibrary", "Exception in addFilePart");
            this.i.b(this.h, e3.getLocalizedMessage(), 400);
            e3.printStackTrace();
        }
        this.f2702d.append((CharSequence) "\r\n");
    }

    public void a(String str, String str2) {
        this.f2702d.append((CharSequence) "--").append((CharSequence) this.f2703e).append((CharSequence) "\r\n").append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) str).append((CharSequence) "\"").append((CharSequence) "\r\n").append((CharSequence) "Content-Type: text/plain; charset=").append((CharSequence) "UTF-8").append((CharSequence) "\r\n").append((CharSequence) "\r\n").append((CharSequence) str2).append((CharSequence) "\r\n");
    }
}
