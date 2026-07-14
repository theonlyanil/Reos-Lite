package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class kp extends lz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4594a = kp.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4596c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4599f;
    private int g;
    private c l;
    private HttpURLConnection m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Exception s;
    private boolean w;
    private boolean z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4597d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4598e = 15000;
    private boolean j = true;
    private final jx<String, String> k = new jx<>();
    private long q = -1;
    private long r = -1;
    private int t = -1;
    private final jx<String, String> u = new jx<>();
    private final Object v = new Object();
    private int x = 25000;
    private ko y = new ko(this);

    public enum a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        @Override // java.lang.Enum
        public String toString() {
            switch (this) {
                case kPost:
                    return "POST";
                case kPut:
                    return "PUT";
                case kDelete:
                    return "DELETE";
                case kHead:
                    return "HEAD";
                case kGet:
                    return "GET";
                default:
                    return null;
            }
        }
    }

    public static class b implements c {
        @Override // com.flurry.sdk.kp.c
        public void a(kp kpVar) {
        }

        @Override // com.flurry.sdk.kp.c
        public void a(kp kpVar, InputStream inputStream) throws Exception {
        }

        @Override // com.flurry.sdk.kp.c
        public void a(kp kpVar, OutputStream outputStream) throws Exception {
        }
    }

    public interface c {
        void a(kp kpVar);

        void a(kp kpVar, InputStream inputStream) throws Exception;

        void a(kp kpVar, OutputStream outputStream) throws Exception;
    }

    private void a(InputStream inputStream) throws Exception {
        if (this.l == null || e() || inputStream == null) {
            return;
        }
        this.l.a(this, inputStream);
    }

    private void a(OutputStream outputStream) throws Exception {
        if (this.l == null || e() || outputStream == null) {
            return;
        }
        this.l.a(this, outputStream);
    }

    private void r() throws Exception {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream;
        Closeable closeable = null;
        if (this.o) {
            return;
        }
        this.f4595b = lt.a(this.f4595b);
        try {
            this.m = (HttpURLConnection) new URL(this.f4595b).openConnection();
            this.m.setConnectTimeout(this.f4597d);
            this.m.setReadTimeout(this.f4598e);
            this.m.setRequestMethod(this.f4596c.toString());
            this.m.setInstanceFollowRedirects(this.j);
            this.m.setDoOutput(a.kPost.equals(this.f4596c));
            this.m.setDoInput(true);
            for (Map.Entry<String, String> entry : this.k.b()) {
                this.m.addRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!a.kGet.equals(this.f4596c) && !a.kPost.equals(this.f4596c)) {
                this.m.setRequestProperty("Accept-Encoding", "");
            }
            if (this.o) {
                t();
                return;
            }
            if (a.kPost.equals(this.f4596c)) {
                try {
                    OutputStream outputStream = this.m.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                        try {
                            a(bufferedOutputStream);
                            lt.a(bufferedOutputStream);
                            lt.a(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            closeable = outputStream;
                            lt.a(bufferedOutputStream);
                            lt.a(closeable);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                        closeable = outputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            }
            if (this.p) {
                this.q = System.currentTimeMillis();
            }
            if (this.w) {
                this.y.a(this.x);
            }
            this.t = this.m.getResponseCode();
            if (this.p && this.q != -1) {
                this.r = System.currentTimeMillis() - this.q;
            }
            this.y.a();
            for (Map.Entry<String, List<String>> entry2 : this.m.getHeaderFields().entrySet()) {
                Iterator<String> it = entry2.getValue().iterator();
                while (it.hasNext()) {
                    this.u.a(entry2.getKey(), it.next());
                }
            }
            if (!a.kGet.equals(this.f4596c) && !a.kPost.equals(this.f4596c)) {
                t();
                return;
            }
            if (this.o) {
                t();
                return;
            }
            try {
                InputStream inputStream2 = this.m.getInputStream();
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
                    try {
                        a(bufferedInputStream);
                        lt.a((Closeable) bufferedInputStream);
                        lt.a((Closeable) inputStream2);
                        t();
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = bufferedInputStream;
                        inputStream = inputStream2;
                        lt.a(closeable);
                        lt.a((Closeable) inputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = inputStream2;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        } catch (Throwable th7) {
            t();
            throw th7;
        }
    }

    private void s() {
        if (this.l == null || e()) {
            return;
        }
        this.l.a(this);
    }

    private void t() {
        if (this.n) {
            return;
        }
        this.n = true;
        if (this.m != null) {
            this.m.disconnect();
        }
    }

    private void u() {
        if (this.n) {
            return;
        }
        this.n = true;
        if (this.m != null) {
            new Thread() { // from class: com.flurry.sdk.kp.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        if (kp.this.m != null) {
                            kp.this.m.disconnect();
                        }
                    } catch (Throwable th) {
                    }
                }
            }.start();
        }
    }

    @Override // com.flurry.sdk.ly
    public void a() {
        try {
            if (this.f4595b == null) {
                return;
            }
            if (!jl.a().c()) {
                kg.a(3, f4594a, "Network not available, aborting http request: " + this.f4595b);
                return;
            }
            if (this.f4596c == null || a.kUnknown.equals(this.f4596c)) {
                this.f4596c = a.kGet;
            }
            r();
            kg.a(4, f4594a, "HTTP status: " + this.t + " for url: " + this.f4595b);
        } catch (Exception e2) {
            kg.a(4, f4594a, "HTTP status: " + this.t + " for url: " + this.f4595b);
            kg.a(3, f4594a, "Exception during http request: " + this.f4595b, e2);
            this.g = this.m.getReadTimeout();
            this.f4599f = this.m.getConnectTimeout();
            this.s = e2;
        } finally {
            this.y.a();
            s();
        }
    }

    public void a(int i) {
        this.f4597d = i;
    }

    public void a(a aVar) {
        this.f4596c = aVar;
    }

    public void a(c cVar) {
        this.l = cVar;
    }

    public void a(String str) {
        this.f4595b = str;
    }

    public void a(String str, String str2) {
        this.k.a(str, str2);
    }

    public void a(boolean z) {
        this.w = z;
    }

    public String b() {
        return this.f4595b;
    }

    public List<String> b(String str) {
        if (str == null) {
            return null;
        }
        return this.u.a(str);
    }

    public void b(int i) {
        this.f4598e = i;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public long c() {
        return this.r;
    }

    public void c(int i) {
        this.x = i;
    }

    public void c(String str) {
        if (this.u == null || !this.u.c(str)) {
            return;
        }
        this.u.b(str);
    }

    public void c(boolean z) {
        this.p = z;
    }

    public boolean d() {
        return this.z || (this.s != null && (this.s instanceof SocketTimeoutException));
    }

    public boolean e() {
        boolean z;
        synchronized (this.v) {
            z = this.o;
        }
        return z;
    }

    public boolean f() {
        return !i() && g();
    }

    public boolean g() {
        return this.t >= 200 && this.t < 400 && !this.z;
    }

    public int h() {
        return this.t;
    }

    public boolean i() {
        return this.s != null;
    }

    public Exception j() {
        return this.s;
    }

    public void k() {
        kg.a(3, f4594a, "Timeout (" + (System.currentTimeMillis() - this.q) + "MS) for url: " + this.f4595b);
        this.t = 629;
        this.z = true;
        s();
        l();
    }

    public void l() {
        kg.a(3, f4594a, "Cancelling http request: " + this.f4595b);
        synchronized (this.v) {
            this.o = true;
        }
        u();
    }

    @Override // com.flurry.sdk.lz
    public void m() {
        l();
    }
}
