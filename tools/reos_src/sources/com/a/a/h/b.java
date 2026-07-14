package com.a.a.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.a.a.d.b.k;
import com.a.a.h.b.i;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class b<A, T, Z, R> implements i, c, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Queue<b<?, ?, ?, ?>> f2430a = com.a.a.j.h.a(0);
    private k<?> A;
    private com.a.a.d.b.c.C0041c B;
    private long C;
    private a D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2431b = String.valueOf(hashCode());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.c f2432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f2433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2435f;
    private int g;
    private Context h;
    private com.a.a.d.g<Z> i;
    private com.a.a.g.f<A, T, Z, R> j;
    private d k;
    private A l;
    private Class<R> m;
    private boolean n;
    private com.a.a.i o;
    private com.a.a.h.b.k<R> p;
    private f<? super A, R> q;
    private float r;
    private com.a.a.d.b.c s;
    private com.a.a.h.a.d<R> t;
    private int u;
    private int v;
    private com.a.a.d.b.b w;
    private Drawable x;
    private Drawable y;
    private boolean z;

    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private b() {
    }

    public static <A, T, Z, R> b<A, T, Z, R> a(com.a.a.g.f<A, T, Z, R> fVar, A a2, com.a.a.d.c cVar, Context context, com.a.a.i iVar, com.a.a.h.b.k<R> kVar, float f2, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, f<? super A, R> fVar2, d dVar, com.a.a.d.b.c cVar2, com.a.a.d.g<Z> gVar, Class<R> cls, boolean z, com.a.a.h.a.d<R> dVar2, int i4, int i5, com.a.a.d.b.b bVar) {
        b<A, T, Z, R> bVar2 = (b) f2430a.poll();
        if (bVar2 == null) {
            bVar2 = new b<>();
        }
        bVar2.b(fVar, a2, cVar, context, iVar, kVar, f2, drawable, i, drawable2, i2, drawable3, i3, fVar2, dVar, cVar2, gVar, cls, z, dVar2, i4, i5, bVar);
        return bVar2;
    }

    private void a(k<?> kVar, R r) {
        boolean zP = p();
        this.D = a.COMPLETE;
        this.A = kVar;
        if (this.q == null || !this.q.a(r, this.l, this.p, this.z, zP)) {
            this.p.a(r, this.t.a(this.z, zP));
        }
        q();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Resource ready in " + com.a.a.j.d.a(this.C) + " size: " + (((double) kVar.c()) * 9.5367431640625E-7d) + " fromCache: " + this.z);
        }
    }

    private void a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f2431b);
    }

    private static void a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private void b(k kVar) {
        this.s.a(kVar);
        this.A = null;
    }

    private void b(com.a.a.g.f<A, T, Z, R> fVar, A a2, com.a.a.d.c cVar, Context context, com.a.a.i iVar, com.a.a.h.b.k<R> kVar, float f2, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, f<? super A, R> fVar2, d dVar, com.a.a.d.b.c cVar2, com.a.a.d.g<Z> gVar, Class<R> cls, boolean z, com.a.a.h.a.d<R> dVar2, int i4, int i5, com.a.a.d.b.b bVar) {
        this.j = fVar;
        this.l = a2;
        this.f2432c = cVar;
        this.f2433d = drawable3;
        this.f2434e = i3;
        this.h = context.getApplicationContext();
        this.o = iVar;
        this.p = kVar;
        this.r = f2;
        this.x = drawable;
        this.f2435f = i;
        this.y = drawable2;
        this.g = i2;
        this.q = fVar2;
        this.k = dVar;
        this.s = cVar2;
        this.i = gVar;
        this.m = cls;
        this.n = z;
        this.t = dVar2;
        this.u = i4;
        this.v = i5;
        this.w = bVar;
        this.D = a.PENDING;
        if (a2 != null) {
            a("ModelLoader", fVar.e(), "try .using(ModelLoader)");
            a("Transcoder", fVar.f(), "try .as*(Class).transcode(ResourceTranscoder)");
            a("Transformation", gVar, "try .transform(UnitTransformation.get())");
            if (bVar.a()) {
                a("SourceEncoder", fVar.c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                a("SourceDecoder", fVar.b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (bVar.a() || bVar.b()) {
                a("CacheDecoder", fVar.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (bVar.b()) {
                a("Encoder", fVar.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private void b(Exception exc) {
        if (o()) {
            Drawable drawableK = this.l == null ? k() : null;
            if (drawableK == null) {
                drawableK = l();
            }
            if (drawableK == null) {
                drawableK = m();
            }
            this.p.a(exc, drawableK);
        }
    }

    private Drawable k() {
        if (this.f2433d == null && this.f2434e > 0) {
            this.f2433d = this.h.getResources().getDrawable(this.f2434e);
        }
        return this.f2433d;
    }

    private Drawable l() {
        if (this.y == null && this.g > 0) {
            this.y = this.h.getResources().getDrawable(this.g);
        }
        return this.y;
    }

    private Drawable m() {
        if (this.x == null && this.f2435f > 0) {
            this.x = this.h.getResources().getDrawable(this.f2435f);
        }
        return this.x;
    }

    private boolean n() {
        return this.k == null || this.k.a(this);
    }

    private boolean o() {
        return this.k == null || this.k.b(this);
    }

    private boolean p() {
        return this.k == null || !this.k.c();
    }

    private void q() {
        if (this.k != null) {
            this.k.c(this);
        }
    }

    @Override // com.a.a.h.c
    public void a() {
        this.j = null;
        this.l = null;
        this.h = null;
        this.p = null;
        this.x = null;
        this.y = null;
        this.f2433d = null;
        this.q = null;
        this.k = null;
        this.i = null;
        this.t = null;
        this.z = false;
        this.B = null;
        f2430a.offer(this);
    }

    @Override // com.a.a.h.b.i
    public void a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Got onSizeReady in " + com.a.a.j.d.a(this.C));
        }
        if (this.D != a.WAITING_FOR_SIZE) {
            return;
        }
        this.D = a.RUNNING;
        int iRound = Math.round(this.r * i);
        int iRound2 = Math.round(this.r * i2);
        com.a.a.d.a.c<T> cVarA = this.j.e().a(this.l, iRound, iRound2);
        if (cVarA == null) {
            a(new Exception("Failed to load model: '" + this.l + "'"));
            return;
        }
        com.a.a.d.d.f.c<Z, R> cVarF = this.j.f();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished setup for calling load in " + com.a.a.j.d.a(this.C));
        }
        this.z = true;
        this.B = this.s.a(this.f2432c, iRound, iRound2, cVarA, this.j, this.i, cVarF, this.o, this.n, this.w, this);
        this.z = this.A != null;
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished onSizeReady in " + com.a.a.j.d.a(this.C));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.h.g
    public void a(k<?> kVar) {
        if (kVar == null) {
            a(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
            return;
        }
        Object objB = kVar.b();
        if (objB == null || !this.m.isAssignableFrom(objB.getClass())) {
            b(kVar);
            a(new Exception("Expected to receive an object of " + this.m + " but instead got " + (objB != null ? objB.getClass() : "") + "{" + objB + "} inside Resource{" + kVar + "}." + (objB != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (n()) {
            a(kVar, objB);
        } else {
            b(kVar);
            this.D = a.COMPLETE;
        }
    }

    @Override // com.a.a.h.g
    public void a(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.D = a.FAILED;
        if (this.q == null || !this.q.a(exc, this.l, this.p, p())) {
            b(exc);
        }
    }

    @Override // com.a.a.h.c
    public void b() {
        this.C = com.a.a.j.d.a();
        if (this.l == null) {
            a((Exception) null);
            return;
        }
        this.D = a.WAITING_FOR_SIZE;
        if (com.a.a.j.h.a(this.u, this.v)) {
            a(this.u, this.v);
        } else {
            this.p.a((i) this);
        }
        if (!g() && !j() && o()) {
            this.p.b(m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished run method in " + com.a.a.j.d.a(this.C));
        }
    }

    void c() {
        this.D = a.CANCELLED;
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
    }

    @Override // com.a.a.h.c
    public void d() {
        com.a.a.j.h.a();
        if (this.D == a.CLEARED) {
            return;
        }
        c();
        if (this.A != null) {
            b(this.A);
        }
        if (o()) {
            this.p.a(m());
        }
        this.D = a.CLEARED;
    }

    @Override // com.a.a.h.c
    public void e() {
        d();
        this.D = a.PAUSED;
    }

    @Override // com.a.a.h.c
    public boolean f() {
        return this.D == a.RUNNING || this.D == a.WAITING_FOR_SIZE;
    }

    @Override // com.a.a.h.c
    public boolean g() {
        return this.D == a.COMPLETE;
    }

    @Override // com.a.a.h.c
    public boolean h() {
        return g();
    }

    @Override // com.a.a.h.c
    public boolean i() {
        return this.D == a.CANCELLED || this.D == a.CLEARED;
    }

    public boolean j() {
        return this.D == a.FAILED;
    }
}
