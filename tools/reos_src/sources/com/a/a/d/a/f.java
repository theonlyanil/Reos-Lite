package com.a.a.d.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements c<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2031a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.c.d f2032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f2034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f2035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f2036f;

    private static class a implements b {
        private a() {
        }

        @Override // com.a.a.d.a.f.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public f(com.a.a.d.c.d dVar) {
        this(dVar, f2031a);
    }

    f(com.a.a.d.c.d dVar, b bVar) {
        this.f2032b = dVar;
        this.f2033c = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f2035e = com.a.a.j.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f2035e = httpURLConnection.getInputStream();
        }
        return this.f2035e;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e2) {
            }
        }
        this.f2034d = this.f2033c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f2034d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f2034d.setConnectTimeout(2500);
        this.f2034d.setReadTimeout(2500);
        this.f2034d.setUseCaches(false);
        this.f2034d.setDoInput(true);
        this.f2034d.connect();
        if (this.f2036f) {
            return null;
        }
        int responseCode = this.f2034d.getResponseCode();
        if (responseCode / 100 == 2) {
            return a(this.f2034d);
        }
        if (responseCode / 100 != 3) {
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.f2034d.getResponseMessage());
        }
        String headerField = this.f2034d.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new IOException("Received empty or null redirect url");
        }
        return a(new URL(url, headerField), i + 1, url, map);
    }

    @Override // com.a.a.d.a.c
    public void a() {
        if (this.f2035e != null) {
            try {
                this.f2035e.close();
            } catch (IOException e2) {
            }
        }
        if (this.f2034d != null) {
            this.f2034d.disconnect();
        }
    }

    @Override // com.a.a.d.a.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(com.a.a.i iVar) throws Exception {
        return a(this.f2032b.a(), 0, null, this.f2032b.b());
    }

    @Override // com.a.a.d.a.c
    public String b() {
        return this.f2032b.c();
    }

    @Override // com.a.a.d.a.c
    public void c() {
        this.f2036f = true;
    }
}
