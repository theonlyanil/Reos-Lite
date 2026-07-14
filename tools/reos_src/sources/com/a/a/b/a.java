package com.a.a.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.flurry.android.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1981a = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config f1982b = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f1983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f1984d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f1986f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private byte[] l;
    private InterfaceC0037a n;
    private Bitmap o;
    private boolean p;
    private int q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f1985e = new byte[256];
    private c m = new c();

    /* JADX INFO: renamed from: com.a.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0037a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);
    }

    public a(InterfaceC0037a interfaceC0037a) {
        this.n = interfaceC0037a;
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2 = this.m.f1998f;
        int i3 = this.m.g;
        int[] iArr = this.j;
        if (bVar2 != null && bVar2.g > 0) {
            if (bVar2.g == 2) {
                Arrays.fill(iArr, bVar.f1992f ? 0 : this.m.l);
            } else if (bVar2.g == 3 && this.o != null) {
                this.o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        a(bVar);
        int i4 = 1;
        int i5 = 8;
        int i6 = 0;
        for (int i7 = 0; i7 < bVar.f1990d; i7++) {
            if (bVar.f1991e) {
                if (i6 >= bVar.f1990d) {
                    i4++;
                    switch (i4) {
                        case 2:
                            i6 = 4;
                            break;
                        case 3:
                            i6 = 2;
                            i5 = 4;
                            break;
                        case 4:
                            i6 = 1;
                            i5 = 2;
                            break;
                    }
                }
                int i8 = i6;
                i6 += i5;
                i = i8;
            } else {
                i = i7;
            }
            int i9 = i + bVar.f1988b;
            if (i9 < this.m.g) {
                int i10 = this.m.f1998f * i9;
                int i11 = i10 + bVar.f1987a;
                int i12 = bVar.f1989c + i11;
                if (this.m.f1998f + i10 < i12) {
                    i12 = this.m.f1998f + i10;
                }
                int i13 = bVar.f1989c * i7;
                int i14 = i11;
                while (i14 < i12) {
                    int i15 = i13 + 1;
                    int i16 = this.f1983c[this.i[i13] & Constants.UNKNOWN];
                    if (i16 != 0) {
                        iArr[i14] = i16;
                    }
                    i14++;
                    i13 = i15;
                }
            }
        }
        if (this.p && (bVar.g == 0 || bVar.g == 1)) {
            if (this.o == null) {
                this.o = j();
            }
            this.o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap bitmapJ = j();
        bitmapJ.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return bitmapJ;
    }

    @TargetApi(12)
    private static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    private void a(b bVar) {
        int i;
        if (bVar != null) {
            this.f1984d.position(bVar.j);
        }
        int i2 = bVar == null ? this.m.f1998f * this.m.g : bVar.f1989c * bVar.f1990d;
        if (this.i == null || this.i.length < i2) {
            this.i = new byte[i2];
        }
        if (this.f1986f == null) {
            this.f1986f = new short[4096];
        }
        if (this.g == null) {
            this.g = new byte[4096];
        }
        if (this.h == null) {
            this.h = new byte[4097];
        }
        int iH = h();
        int i3 = 1 << iH;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = -1;
        int i7 = iH + 1;
        int i8 = (1 << i7) - 1;
        for (int i9 = 0; i9 < i3; i9++) {
            this.f1986f[i9] = 0;
            this.g[i9] = (byte) i9;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = i7;
        int i16 = i8;
        int i17 = i5;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i11 < i2) {
            if (i19 == 0) {
                i19 = i();
                if (i19 <= 0) {
                    this.q = 3;
                    break;
                }
                i18 = 0;
            }
            int i21 = i10 + ((this.f1985e[i18] & Constants.UNKNOWN) << i14);
            int i22 = i14 + 8;
            i18++;
            i19--;
            i15 = i15;
            i16 = i16;
            i13 = i13;
            int i23 = i21;
            i20 = i20;
            i17 = i17;
            int i24 = i22;
            while (true) {
                if (i24 < i15) {
                    i10 = i23;
                    i14 = i24;
                    break;
                }
                int i25 = i23 & i16;
                i23 >>= i15;
                i24 -= i15;
                if (i25 == i3) {
                    i15 = iH + 1;
                    i16 = (1 << i15) - 1;
                    i17 = i3 + 2;
                    i6 = -1;
                } else {
                    if (i25 > i17) {
                        this.q = 3;
                        i14 = i24;
                        i10 = i23;
                        break;
                    }
                    if (i25 == i4) {
                        i14 = i24;
                        i10 = i23;
                        break;
                    }
                    if (i6 == -1) {
                        this.h[i12] = this.g[i25];
                        i12++;
                        i13 = i25;
                        i6 = i25;
                    } else {
                        if (i25 >= i17) {
                            this.h[i12] = (byte) i13;
                            i12++;
                            i = i6;
                        } else {
                            i = i25;
                        }
                        while (i >= i3) {
                            this.h[i12] = this.g[i];
                            i = this.f1986f[i];
                            i12++;
                        }
                        i13 = this.g[i] & Constants.UNKNOWN;
                        int i26 = i12 + 1;
                        this.h[i12] = (byte) i13;
                        if (i17 < 4096) {
                            this.f1986f[i17] = (short) i6;
                            this.g[i17] = (byte) i13;
                            i17++;
                            if ((i17 & i16) == 0 && i17 < 4096) {
                                i15++;
                                i16 += i17;
                            }
                        }
                        int i27 = i11;
                        while (i26 > 0) {
                            int i28 = i26 - 1;
                            this.i[i20] = this.h[i28];
                            i27++;
                            i20++;
                            i26 = i28;
                        }
                        i11 = i27;
                        i6 = i25;
                        i12 = i26;
                    }
                }
            }
        }
        for (int i29 = i20; i29 < i2; i29++) {
            this.i[i29] = 0;
        }
    }

    private int h() {
        try {
            return this.f1984d.get() & Constants.UNKNOWN;
        } catch (Exception e2) {
            this.q = 1;
            return 0;
        }
    }

    private int i() {
        int iH = h();
        int i = 0;
        if (iH > 0) {
            while (i < iH) {
                int i2 = iH - i;
                try {
                    this.f1984d.get(this.f1985e, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    Log.w(f1981a, "Error Reading Block", e2);
                    this.q = 1;
                }
            }
        }
        return i;
    }

    private Bitmap j() {
        Bitmap bitmapA = this.n.a(this.m.f1998f, this.m.g, f1982b);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(this.m.f1998f, this.m.g, f1982b);
        }
        a(bitmapA);
        return bitmapA;
    }

    public int a(int i) {
        if (i < 0 || i >= this.m.f1995c) {
            return -1;
        }
        return this.m.f1997e.get(i).i;
    }

    public void a() {
        this.k = (this.k + 1) % this.m.f1995c;
    }

    public void a(c cVar, byte[] bArr) {
        this.m = cVar;
        this.l = bArr;
        this.q = 0;
        this.k = -1;
        this.f1984d = ByteBuffer.wrap(bArr);
        this.f1984d.rewind();
        this.f1984d.order(ByteOrder.LITTLE_ENDIAN);
        this.p = false;
        Iterator<b> it = cVar.f1997e.iterator();
        while (it.hasNext()) {
            if (it.next().g == 3) {
                this.p = true;
                break;
            }
        }
        this.i = new byte[cVar.f1998f * cVar.g];
        this.j = new int[cVar.f1998f * cVar.g];
    }

    public int b() {
        if (this.m.f1995c <= 0 || this.k < 0) {
            return -1;
        }
        return a(this.k);
    }

    public int c() {
        return this.m.f1995c;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.m.m;
    }

    public synchronized Bitmap f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.m.f1995c <= 0 || this.k < 0) {
                if (Log.isLoggable(f1981a, 3)) {
                    Log.d(f1981a, "unable to decode frame, frameCount=" + this.m.f1995c + " framePointer=" + this.k);
                }
                this.q = 1;
            }
            if (this.q == 1 || this.q == 2) {
                if (Log.isLoggable(f1981a, 3)) {
                    Log.d(f1981a, "Unable to decode frame, status=" + this.q);
                }
                bitmap = null;
            } else {
                this.q = 0;
                b bVar = this.m.f1997e.get(this.k);
                int i2 = this.k - 1;
                b bVar2 = i2 >= 0 ? this.m.f1997e.get(i2) : null;
                if (bVar.k == null) {
                    this.f1983c = this.m.f1993a;
                } else {
                    this.f1983c = bVar.k;
                    if (this.m.j == bVar.h) {
                        this.m.l = 0;
                    }
                }
                if (bVar.f1992f) {
                    int i3 = this.f1983c[bVar.h];
                    this.f1983c[bVar.h] = 0;
                    i = i3;
                }
                if (this.f1983c == null) {
                    if (Log.isLoggable(f1981a, 3)) {
                        Log.d(f1981a, "No Valid Color Table");
                    }
                    this.q = 1;
                    bitmap = null;
                } else {
                    Bitmap bitmapA = a(bVar, bVar2);
                    if (bVar.f1992f) {
                        this.f1983c[bVar.h] = i;
                    }
                    bitmap = bitmapA;
                }
            }
        }
        return bitmap;
    }

    public void g() {
        this.m = null;
        this.l = null;
        this.i = null;
        this.j = null;
        if (this.o != null) {
            this.n.a(this.o);
        }
        this.o = null;
    }
}
