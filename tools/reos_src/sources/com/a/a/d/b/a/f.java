package com.a.a.d.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config f2062a = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Bitmap.Config> f2064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f2066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2067f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static class b implements a {
        private b() {
        }

        @Override // com.a.a.d.b.a.f.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.a.a.d.b.a.f.a
        public void b(Bitmap bitmap) {
        }
    }

    public f(int i) {
        this(i, e(), f());
    }

    f(int i, g gVar, Set<Bitmap.Config> set) {
        this.f2065d = i;
        this.f2067f = i;
        this.f2063b = gVar;
        this.f2064c = set;
        this.f2066e = new b();
    }

    private void b() {
        b(this.f2067f);
    }

    private synchronized void b(int i) {
        while (this.g > i) {
            Bitmap bitmapA = this.f2063b.a();
            if (bitmapA == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.g = 0;
                break;
            }
            this.f2066e.b(bitmapA);
            this.g -= this.f2063b.c(bitmapA);
            bitmapA.recycle();
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f2063b.b(bitmapA));
            }
            c();
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f2067f + "\nStrategy=" + this.f2063b);
    }

    private static g e() {
        return Build.VERSION.SDK_INT >= 19 ? new i() : new com.a.a.d.b.a.a();
    }

    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.a.a.d.b.a.c
    public synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapB;
        bitmapB = b(i, i2, config);
        if (bitmapB != null) {
            bitmapB.eraseColor(0);
        }
        return bitmapB;
    }

    @Override // com.a.a.d.b.a.c
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @Override // com.a.a.d.b.a.c
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(this.f2067f / 2);
        }
    }

    @Override // com.a.a.d.b.a.c
    public synchronized boolean a(Bitmap bitmap) {
        boolean z;
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isMutable() && this.f2063b.c(bitmap) <= this.f2067f && this.f2064c.contains(bitmap.getConfig())) {
                int iC = this.f2063b.c(bitmap);
                this.f2063b.a(bitmap);
                this.f2066e.a(bitmap);
                this.j++;
                this.g = iC + this.g;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f2063b.b(bitmap));
                }
                c();
                b();
                z = true;
            } else {
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f2063b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2064c.contains(bitmap.getConfig()));
                }
                z = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    @Override // com.a.a.d.b.a.c
    @TargetApi(12)
    public synchronized Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA;
        bitmapA = this.f2063b.a(i, i2, config != null ? config : f2062a);
        if (bitmapA == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f2063b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.f2063b.c(bitmapA);
            this.f2066e.b(bitmapA);
            if (Build.VERSION.SDK_INT >= 12) {
                bitmapA.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f2063b.b(i, i2, config));
        }
        c();
        return bitmapA;
    }
}
