package com.a.a.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f2304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.b.a f2305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f2306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.a.a.e<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> f2309f;
    private a g;
    private boolean h;

    static class a extends com.a.a.h.b.h<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f2310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f2312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap f2313d;

        public a(Handler handler, int i, long j) {
            this.f2310a = handler;
            this.f2311b = i;
            this.f2312c = j;
        }

        public void a(Bitmap bitmap, com.a.a.h.a.c<? super Bitmap> cVar) {
            this.f2313d = bitmap;
            this.f2310a.sendMessageAtTime(this.f2310a.obtainMessage(1, this), this.f2312c);
        }

        @Override // com.a.a.h.b.k
        public /* bridge */ /* synthetic */ void a(Object obj, com.a.a.h.a.c cVar) {
            a((Bitmap) obj, (com.a.a.h.a.c<? super Bitmap>) cVar);
        }

        public Bitmap b_() {
            return this.f2313d;
        }
    }

    public interface b {
        void b(int i);
    }

    private class c implements Handler.Callback {
        private c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                f.this.a((a) message.obj);
                return true;
            }
            if (message.what == 2) {
                com.a.a.g.a((a) message.obj);
            }
            return false;
        }
    }

    static class d implements com.a.a.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f2315a;

        public d() {
            this(UUID.randomUUID());
        }

        d(UUID uuid) {
            this.f2315a = uuid;
        }

        @Override // com.a.a.d.c
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.a.a.d.c
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return ((d) obj).f2315a.equals(this.f2315a);
            }
            return false;
        }

        @Override // com.a.a.d.c
        public int hashCode() {
            return this.f2315a.hashCode();
        }
    }

    public f(Context context, b bVar, com.a.a.b.a aVar, int i, int i2) {
        this(bVar, aVar, null, a(context, aVar, i, i2, com.a.a.g.a(context).a()));
    }

    f(b bVar, com.a.a.b.a aVar, Handler handler, com.a.a.e<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> eVar) {
        this.f2307d = false;
        this.f2308e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f2304a = bVar;
        this.f2305b = aVar;
        this.f2306c = handler;
        this.f2309f = eVar;
    }

    private static com.a.a.e<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> a(Context context, com.a.a.b.a aVar, int i, int i2, com.a.a.d.b.a.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        return com.a.a.g.b(context).a(gVar, com.a.a.b.a.class).a(aVar).a(Bitmap.class).b(com.a.a.d.d.a.b()).b((com.a.a.d.e) hVar).b(true).b(com.a.a.d.b.b.NONE).b(i, i2);
    }

    private void e() {
        if (!this.f2307d || this.f2308e) {
            return;
        }
        this.f2308e = true;
        this.f2305b.a();
        this.f2309f.b(new d()).a(new a(this.f2306c, this.f2305b.d(), SystemClock.uptimeMillis() + ((long) this.f2305b.b())));
    }

    public void a() {
        if (this.f2307d) {
            return;
        }
        this.f2307d = true;
        this.h = false;
        e();
    }

    void a(a aVar) {
        if (this.h) {
            this.f2306c.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        a aVar2 = this.g;
        this.g = aVar;
        this.f2304a.b(aVar.f2311b);
        if (aVar2 != null) {
            this.f2306c.obtainMessage(2, aVar2).sendToTarget();
        }
        this.f2308e = false;
        e();
    }

    public void a(com.a.a.d.g<Bitmap> gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f2309f = this.f2309f.b(gVar);
    }

    public void b() {
        this.f2307d = false;
    }

    public void c() {
        b();
        if (this.g != null) {
            com.a.a.g.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        if (this.g != null) {
            return this.g.b_();
        }
        return null;
    }
}
