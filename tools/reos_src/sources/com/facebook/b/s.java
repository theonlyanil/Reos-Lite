package com.facebook.b;

import android.content.Context;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f3809a = s.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile n f3810b;

    private static class a extends BufferedInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        HttpURLConnection f3811a;

        a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.f3811a = httpURLConnection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            ad.a(this.f3811a);
        }
    }

    s() {
    }

    static synchronized n a(Context context) throws IOException {
        if (f3810b == null) {
            f3810b = new n(f3809a, new n.d());
        }
        return f3810b;
    }

    static InputStream a(Context context, HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri uri = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            return a(uri) ? a(context).a(uri.toString(), new a(inputStream, httpURLConnection)) : inputStream;
        } catch (IOException e2) {
            return inputStream;
        }
    }

    static InputStream a(Uri uri, Context context) {
        if (uri == null || !a(uri)) {
            return null;
        }
        try {
            return a(context).a(uri.toString());
        } catch (IOException e2) {
            v.a(com.facebook.u.CACHE, 5, f3809a, e2.toString());
            return null;
        }
    }

    private static boolean a(Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                return true;
            }
            if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }
}
