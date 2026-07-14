package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.d.a.n;
import com.a.a.d.d.a.p;
import com.a.a.h.b.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f2394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.c.c f2395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.b.c f2396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.a.d.b.b.h f2398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.a.a.d.a f2399f;
    private final com.a.a.d.d.a.e j;
    private final com.a.a.d.d.e.f k;
    private final com.a.a.d.d.a.i l;
    private final com.a.a.d.d.e.f m;
    private final com.a.a.d.b.d.a o;
    private final com.a.a.h.b.f g = new com.a.a.h.b.f();
    private final com.a.a.d.d.f.d h = new com.a.a.d.d.f.d();
    private final Handler n = new Handler(Looper.getMainLooper());
    private final com.a.a.g.c i = new com.a.a.g.c();

    g(com.a.a.d.b.c cVar, com.a.a.d.b.b.h hVar, com.a.a.d.b.a.c cVar2, Context context, com.a.a.d.a aVar) {
        this.f2396c = cVar;
        this.f2397d = cVar2;
        this.f2398e = hVar;
        this.f2399f = aVar;
        this.f2395b = new com.a.a.d.c.c(context);
        this.o = new com.a.a.d.b.d.a(hVar, cVar2, aVar);
        p pVar = new p(cVar2, aVar);
        this.i.a(InputStream.class, Bitmap.class, pVar);
        com.a.a.d.d.a.g gVar = new com.a.a.d.d.a.g(cVar2, aVar);
        this.i.a(ParcelFileDescriptor.class, Bitmap.class, gVar);
        n nVar = new n(pVar, gVar);
        this.i.a(com.a.a.d.c.g.class, Bitmap.class, nVar);
        com.a.a.d.d.d.c cVar3 = new com.a.a.d.d.d.c(context, cVar2);
        this.i.a(InputStream.class, com.a.a.d.d.d.b.class, cVar3);
        this.i.a(com.a.a.d.c.g.class, com.a.a.d.d.e.a.class, new com.a.a.d.d.e.g(nVar, cVar3, cVar2));
        this.i.a(InputStream.class, File.class, new com.a.a.d.d.c.d());
        a(File.class, ParcelFileDescriptor.class, new com.a.a.d.c.a.a.C0043a());
        a(File.class, InputStream.class, new com.a.a.d.c.b.c.a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new com.a.a.d.c.a.c.a());
        a(Integer.TYPE, InputStream.class, new com.a.a.d.c.b.e.a());
        a(Integer.class, ParcelFileDescriptor.class, new com.a.a.d.c.a.c.a());
        a(Integer.class, InputStream.class, new com.a.a.d.c.b.e.a());
        a(String.class, ParcelFileDescriptor.class, new com.a.a.d.c.a.d.a());
        a(String.class, InputStream.class, new com.a.a.d.c.b.f.a());
        a(Uri.class, ParcelFileDescriptor.class, new com.a.a.d.c.a.e.a());
        a(Uri.class, InputStream.class, new com.a.a.d.c.b.g.a());
        a(URL.class, InputStream.class, new com.a.a.d.c.b.h.a());
        a(com.a.a.d.c.d.class, InputStream.class, new com.a.a.d.c.b.a.C0044a());
        a(byte[].class, InputStream.class, new com.a.a.d.c.b.b.a());
        this.h.a(Bitmap.class, com.a.a.d.d.a.j.class, new com.a.a.d.d.f.b(context.getResources(), cVar2));
        this.h.a(com.a.a.d.d.e.a.class, com.a.a.d.d.b.b.class, new com.a.a.d.d.f.a(new com.a.a.d.d.f.b(context.getResources(), cVar2)));
        this.j = new com.a.a.d.d.a.e(cVar2);
        this.k = new com.a.a.d.d.e.f(cVar2, this.j);
        this.l = new com.a.a.d.d.a.i(cVar2);
        this.m = new com.a.a.d.d.e.f(cVar2, this.l);
    }

    public static <T> l<T, InputStream> a(Class<T> cls, Context context) {
        return a(cls, InputStream.class, context);
    }

    public static <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return a(context).j().a(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static g a(Context context) {
        if (f2394a == null) {
            synchronized (g.class) {
                if (f2394a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<com.a.a.f.a> listA = new com.a.a.f.b(applicationContext).a();
                    h hVar = new h(applicationContext);
                    Iterator<com.a.a.f.a> it = listA.iterator();
                    while (it.hasNext()) {
                        it.next().a(applicationContext, hVar);
                    }
                    f2394a = hVar.a();
                    Iterator<com.a.a.f.a> it2 = listA.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(applicationContext, f2394a);
                    }
                }
            }
        }
        return f2394a;
    }

    public static void a(k<?> kVar) {
        com.a.a.j.h.a();
        com.a.a.h.c cVarA = kVar.a();
        if (cVarA != null) {
            cVarA.d();
            kVar.a((com.a.a.h.c) null);
        }
    }

    public static <T> l<T, ParcelFileDescriptor> b(Class<T> cls, Context context) {
        return a(cls, ParcelFileDescriptor.class, context);
    }

    public static j b(Context context) {
        return com.a.a.e.k.a().a(context);
    }

    private com.a.a.d.c.c j() {
        return this.f2395b;
    }

    public com.a.a.d.b.a.c a() {
        return this.f2397d;
    }

    <Z, R> com.a.a.d.d.f.c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        return this.h.a(cls, cls2);
    }

    <R> k<R> a(ImageView imageView, Class<R> cls) {
        return this.g.a(imageView, cls);
    }

    public void a(int i) {
        this.f2397d.a(i);
        this.f2398e.a(i);
    }

    public <T, Y> void a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> mVarA = this.f2395b.a(cls, cls2, mVar);
        if (mVarA != null) {
            mVarA.a();
        }
    }

    com.a.a.d.b.c b() {
        return this.f2396c;
    }

    <T, Z> com.a.a.g.b<T, Z> b(Class<T> cls, Class<Z> cls2) {
        return this.i.a(cls, cls2);
    }

    com.a.a.d.d.a.e c() {
        return this.j;
    }

    com.a.a.d.d.a.i d() {
        return this.l;
    }

    com.a.a.d.d.e.f e() {
        return this.k;
    }

    com.a.a.d.d.e.f f() {
        return this.m;
    }

    Handler g() {
        return this.n;
    }

    com.a.a.d.a h() {
        return this.f2399f;
    }

    public void i() {
        this.f2397d.a();
        this.f2398e.a();
    }
}
