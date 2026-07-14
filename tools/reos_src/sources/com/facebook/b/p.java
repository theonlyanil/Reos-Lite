package com.facebook.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f3776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ag f3777b = new ag(8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ag f3778c = new ag(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<d, c> f3779d = new HashMap();

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f3786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3787c;

        a(Context context, d dVar, boolean z) {
            this.f3785a = context;
            this.f3786b = dVar;
            this.f3787c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.b(this.f3786b, this.f3785a, this.f3787c);
        }
    }

    private static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f3789b;

        b(Context context, d dVar) {
            this.f3788a = context;
            this.f3789b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            p.b(this.f3789b, this.f3788a);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ag.a f3790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        q f3791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3792c;

        private c() {
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Uri f3793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f3794b;

        d(Uri uri, Object obj) {
            this.f3793a = uri;
            this.f3794b = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.f3793a == this.f3793a && dVar.f3794b == this.f3794b;
        }

        public int hashCode() {
            return ((this.f3793a.hashCode() + 1073) * 37) + this.f3794b.hashCode();
        }
    }

    private static synchronized Handler a() {
        if (f3776a == null) {
            f3776a = new Handler(Looper.getMainLooper());
        }
        return f3776a;
    }

    private static c a(d dVar) {
        c cVarRemove;
        synchronized (f3779d) {
            cVarRemove = f3779d.remove(dVar);
        }
        return cVarRemove;
    }

    private static void a(d dVar, final Exception exc, final Bitmap bitmap, final boolean z) {
        final q qVar;
        final q.b bVarC;
        c cVarA = a(dVar);
        if (cVarA == null || cVarA.f3792c || (bVarC = (qVar = cVarA.f3791b).c()) == null) {
            return;
        }
        a().post(new Runnable() { // from class: com.facebook.b.p.1
            @Override // java.lang.Runnable
            public void run() {
                bVarC.a(new r(qVar, exc, z, bitmap));
            }
        });
    }

    public static void a(q qVar) {
        if (qVar == null) {
            return;
        }
        d dVar = new d(qVar.b(), qVar.e());
        synchronized (f3779d) {
            c cVar = f3779d.get(dVar);
            if (cVar != null) {
                cVar.f3791b = qVar;
                cVar.f3792c = false;
                cVar.f3790a.b();
            } else {
                a(qVar, dVar, qVar.d());
            }
        }
    }

    private static void a(q qVar, d dVar) {
        a(qVar, dVar, f3777b, new b(qVar.a(), dVar));
    }

    private static void a(q qVar, d dVar, ag agVar, Runnable runnable) {
        synchronized (f3779d) {
            c cVar = new c();
            cVar.f3791b = qVar;
            f3779d.put(dVar, cVar);
            cVar.f3790a = agVar.a(runnable);
        }
    }

    private static void a(q qVar, d dVar, boolean z) {
        a(qVar, dVar, f3778c, new a(qVar.a(), dVar, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001c. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a1: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:36:0x00a1 */
    public static void b(d dVar, Context context) throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Exception kVar;
        Closeable closeable;
        InputStream inputStreamA;
        Closeable closeable2 = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        closeable2 = null;
        Bitmap bitmapDecodeStream = null;
        boolean z = true;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(dVar.f3793a.toString()).openConnection();
            try {
                try {
                    httpURLConnection3.setInstanceFollowRedirects(false);
                    try {
                        switch (httpURLConnection3.getResponseCode()) {
                            case 200:
                                inputStreamA = s.a(context, httpURLConnection3);
                                kVar = null;
                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamA);
                                ad.a((Closeable) inputStreamA);
                                ad.a(httpURLConnection3);
                                break;
                            case 301:
                            case 302:
                                try {
                                    String headerField = httpURLConnection3.getHeaderField("location");
                                    if (ad.a(headerField)) {
                                        z = false;
                                        kVar = null;
                                        inputStreamA = null;
                                    } else {
                                        Uri uri = Uri.parse(headerField);
                                        ac.a(dVar.f3793a, uri);
                                        c cVarA = a(dVar);
                                        if (cVarA != null && !cVarA.f3792c) {
                                            a(cVarA.f3791b, new d(uri, dVar.f3794b), false);
                                        }
                                        z = false;
                                        kVar = null;
                                        inputStreamA = null;
                                    }
                                    ad.a((Closeable) inputStreamA);
                                    ad.a(httpURLConnection3);
                                } catch (IOException e2) {
                                    httpURLConnection2 = httpURLConnection3;
                                    e = e2;
                                    z = false;
                                    ad.a((Closeable) 0);
                                    ad.a(httpURLConnection2);
                                    kVar = e;
                                }
                                break;
                            default:
                                inputStreamA = httpURLConnection3.getErrorStream();
                                StringBuilder sb = new StringBuilder();
                                if (inputStreamA != null) {
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStreamA);
                                    char[] cArr = new char[128];
                                    while (true) {
                                        int i = inputStreamReader.read(cArr, 0, cArr.length);
                                        if (i > 0) {
                                            sb.append(cArr, 0, i);
                                        } else {
                                            ad.a(inputStreamReader);
                                        }
                                    }
                                } else {
                                    sb.append(context.getString(com.facebook.aa.f.com_facebook_image_download_unknown_error));
                                }
                                kVar = new com.facebook.k(sb.toString());
                                ad.a((Closeable) inputStreamA);
                                ad.a(httpURLConnection3);
                                break;
                        }
                    } catch (IOException e3) {
                        httpURLConnection2 = httpURLConnection3;
                        e = e3;
                    } catch (Throwable th) {
                        closeable2 = closeable;
                        httpURLConnection = httpURLConnection3;
                        th = th;
                        ad.a(closeable2);
                        ad.a(httpURLConnection);
                        throw th;
                    }
                } catch (IOException e4) {
                    httpURLConnection2 = httpURLConnection3;
                    e = e4;
                }
            } catch (Throwable th2) {
                httpURLConnection = httpURLConnection3;
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        if (z) {
            a(dVar, kVar, bitmapDecodeStream, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(d dVar, Context context, boolean z) {
        boolean z2;
        InputStream inputStreamA;
        Uri uriA;
        if (!z || (uriA = ac.a(dVar.f3793a)) == null) {
            z2 = false;
            inputStreamA = null;
        } else {
            InputStream inputStreamA2 = s.a(uriA, context);
            inputStreamA = inputStreamA2;
            z2 = inputStreamA2 != null;
        }
        if (!z2) {
            inputStreamA = s.a(dVar.f3793a, context);
        }
        if (inputStreamA != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamA);
            ad.a((Closeable) inputStreamA);
            a(dVar, (Exception) null, bitmapDecodeStream, z2);
        } else {
            c cVarA = a(dVar);
            if (cVarA == null || cVarA.f3792c) {
                return;
            }
            a(cVarA.f3791b, dVar);
        }
    }

    public static boolean b(q qVar) {
        boolean z;
        d dVar = new d(qVar.b(), qVar.e());
        synchronized (f3779d) {
            c cVar = f3779d.get(dVar);
            if (cVar == null) {
                z = false;
            } else if (cVar.f3790a.a()) {
                f3779d.remove(dVar);
                z = true;
            } else {
                cVar.f3792c = true;
                z = true;
            }
        }
        return z;
    }
}
