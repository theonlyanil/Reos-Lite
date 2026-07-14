package com.google.b.i.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.b.i;
import com.google.b.o;
import com.google.b.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5761a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5763c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p f5765e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f5762b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f5764d = new int[5];

    private static final class a implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f5766a;

        private a(float f2) {
            this.f5766a = f2;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar2.d() != dVar.d()) {
                return dVar2.d() - dVar.d();
            }
            float fAbs = Math.abs(dVar2.c() - this.f5766a);
            float fAbs2 = Math.abs(dVar.c() - this.f5766a);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }
    }

    private static final class b implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f5767a;

        private b(float f2) {
            this.f5767a = f2;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            float fAbs = Math.abs(dVar2.c() - this.f5767a);
            float fAbs2 = Math.abs(dVar.c() - this.f5767a);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
    }

    public e(com.google.b.c.b bVar, p pVar) {
        this.f5761a = bVar;
        this.f5765e = pVar;
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int[] iArrA = a();
        int i5 = 0;
        while (i >= i5 && i2 >= i5 && this.f5761a.a(i2 - i5, i - i5)) {
            iArrA[2] = iArrA[2] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && !this.f5761a.a(i2 - i5, i - i5) && iArrA[1] <= i3) {
            iArrA[1] = iArrA[1] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5 || iArrA[1] > i3) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && this.f5761a.a(i2 - i5, i - i5) && iArrA[0] <= i3) {
            iArrA[0] = iArrA[0] + 1;
            i5++;
        }
        if (iArrA[0] > i3) {
            return false;
        }
        int iF = this.f5761a.f();
        int iE = this.f5761a.e();
        int i6 = 1;
        while (i + i6 < iF && i2 + i6 < iE && this.f5761a.a(i2 + i6, i + i6)) {
            iArrA[2] = iArrA[2] + 1;
            i6++;
        }
        if (i + i6 >= iF || i2 + i6 >= iE) {
            return false;
        }
        while (i + i6 < iF && i2 + i6 < iE && !this.f5761a.a(i2 + i6, i + i6) && iArrA[3] < i3) {
            iArrA[3] = iArrA[3] + 1;
            i6++;
        }
        if (i + i6 >= iF || i2 + i6 >= iE || iArrA[3] >= i3) {
            return false;
        }
        while (i + i6 < iF && i2 + i6 < iE && this.f5761a.a(i2 + i6, i + i6) && iArrA[4] < i3) {
            iArrA[4] = iArrA[4] + 1;
            i6++;
        }
        return iArrA[4] < i3 && Math.abs(((((iArrA[0] + iArrA[1]) + iArrA[2]) + iArrA[3]) + iArrA[4]) - i4) < i4 * 2 && a(iArrA);
    }

    protected static boolean a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = i / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((3.0f * f2) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] a() {
        this.f5764d[0] = 0;
        this.f5764d[1] = 0;
        this.f5764d[2] = 0;
        this.f5764d[3] = 0;
        this.f5764d[4] = 0;
        return this.f5764d;
    }

    private float b(int i, int i2, int i3, int i4) {
        com.google.b.c.b bVar = this.f5761a;
        int iF = bVar.f();
        int[] iArrA = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5)) {
            iArrA[2] = iArrA[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && iArrA[1] <= i3) {
            iArrA[1] = iArrA[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArrA[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i2, i5) && iArrA[0] <= i3) {
            iArrA[0] = iArrA[0] + 1;
            i5--;
        }
        if (iArrA[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < iF && bVar.a(i2, i6)) {
            iArrA[2] = iArrA[2] + 1;
            i6++;
        }
        if (i6 == iF) {
            return Float.NaN;
        }
        while (i6 < iF && !bVar.a(i2, i6) && iArrA[3] < i3) {
            iArrA[3] = iArrA[3] + 1;
            i6++;
        }
        if (i6 == iF || iArrA[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < iF && bVar.a(i2, i6) && iArrA[4] < i3) {
            iArrA[4] = iArrA[4] + 1;
            i6++;
        }
        if (iArrA[4] >= i3 || Math.abs(((((iArrA[0] + iArrA[1]) + iArrA[2]) + iArrA[3]) + iArrA[4]) - i4) * 5 >= i4 * 2 || !a(iArrA)) {
            return Float.NaN;
        }
        return a(iArrA, i6);
    }

    private int b() {
        if (this.f5762b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f5762b) {
            if (dVar2.d() < 2) {
                dVar2 = dVar;
            } else if (dVar != null) {
                this.f5763c = true;
                return ((int) (Math.abs(dVar.a() - dVar2.a()) - Math.abs(dVar.b() - dVar2.b()))) / 2;
            }
            dVar = dVar2;
        }
        return 0;
    }

    private float c(int i, int i2, int i3, int i4) {
        com.google.b.c.b bVar = this.f5761a;
        int iE = bVar.e();
        int[] iArrA = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i5, i2)) {
            iArrA[2] = iArrA[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i5, i2) && iArrA[1] <= i3) {
            iArrA[1] = iArrA[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArrA[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i5, i2) && iArrA[0] <= i3) {
            iArrA[0] = iArrA[0] + 1;
            i5--;
        }
        if (iArrA[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < iE && bVar.a(i6, i2)) {
            iArrA[2] = iArrA[2] + 1;
            i6++;
        }
        if (i6 == iE) {
            return Float.NaN;
        }
        while (i6 < iE && !bVar.a(i6, i2) && iArrA[3] < i3) {
            iArrA[3] = iArrA[3] + 1;
            i6++;
        }
        if (i6 == iE || iArrA[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < iE && bVar.a(i6, i2) && iArrA[4] < i3) {
            iArrA[4] = iArrA[4] + 1;
            i6++;
        }
        if (iArrA[4] >= i3 || Math.abs(((((iArrA[0] + iArrA[1]) + iArrA[2]) + iArrA[3]) + iArrA[4]) - i4) * 5 >= i4 || !a(iArrA)) {
            return Float.NaN;
        }
        return a(iArrA, i6);
    }

    private boolean c() {
        float fC;
        float fAbs = BitmapDescriptorFactory.HUE_RED;
        int size = this.f5762b.size();
        float f2 = 0.0f;
        int i = 0;
        for (d dVar : this.f5762b) {
            if (dVar.d() >= 2) {
                i++;
                fC = dVar.c() + f2;
            } else {
                fC = f2;
            }
            i = i;
            f2 = fC;
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        Iterator<d> it = this.f5762b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().c() - f3);
        }
        return fAbs <= 0.05f * f2;
    }

    private d[] d() throws i {
        float fC = BitmapDescriptorFactory.HUE_RED;
        int size = this.f5762b.size();
        if (size < 3) {
            throw i.a();
        }
        if (size > 3) {
            Iterator<d> it = this.f5762b.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float fC2 = it.next().c();
                f3 += fC2;
                f2 = (fC2 * fC2) + f2;
            }
            float f4 = f3 / size;
            float fSqrt = (float) Math.sqrt((f2 / size) - (f4 * f4));
            Collections.sort(this.f5762b, new b(f4));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i = 0;
            while (i < this.f5762b.size() && this.f5762b.size() > 3) {
                if (Math.abs(this.f5762b.get(i).c() - f4) > fMax) {
                    this.f5762b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.f5762b.size() > 3) {
            Iterator<d> it2 = this.f5762b.iterator();
            while (it2.hasNext()) {
                fC += it2.next().c();
            }
            Collections.sort(this.f5762b, new a(fC / this.f5762b.size()));
            this.f5762b.subList(3, this.f5762b.size()).clear();
        }
        return new d[]{this.f5762b.get(0), this.f5762b.get(1), this.f5762b.get(2)};
    }

    final f a(Map<com.google.b.e, ?> map) throws i {
        int i;
        int i2;
        boolean zC;
        boolean z = map != null && map.containsKey(com.google.b.e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(com.google.b.e.PURE_BARCODE);
        int iF = this.f5761a.f();
        int iE = this.f5761a.e();
        int i3 = (iF * 3) / 228;
        if (i3 < 3 || z) {
            i3 = 3;
        }
        boolean zC2 = false;
        int[] iArr = new int[5];
        int i4 = i3 - 1;
        int i5 = i3;
        while (i4 < iF && !zC2) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < iE) {
                if (this.f5761a.a(i7, i4)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 != 4) {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                } else if (!a(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i6 = 3;
                } else if (a(iArr, i4, i7, z2)) {
                    i5 = 2;
                    if (this.f5763c) {
                        zC = c();
                    } else {
                        int iB = b();
                        if (iB > iArr[2]) {
                            i2 = i4 + ((iB - iArr[2]) - 2);
                            i = iE - 1;
                        } else {
                            i = i7;
                            i2 = i4;
                        }
                        i4 = i2;
                        i7 = i;
                        zC = zC2;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    zC2 = zC;
                    i6 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i6 = 3;
                }
                i7++;
            }
            if (a(iArr) && a(iArr, i4, iE, z2)) {
                i5 = iArr[0];
                if (this.f5763c) {
                    zC2 = c();
                }
            }
            i4 += i5;
        }
        d[] dVarArrD = d();
        o.a(dVarArrD);
        return new f(dVarArrD);
    }

    protected final boolean a(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float fA = a(iArr, i2);
        float fB = b(i, (int) fA, iArr[2], i3);
        if (Float.isNaN(fB)) {
            return false;
        }
        float fC = c((int) fA, (int) fB, iArr[2], i3);
        if (Float.isNaN(fC)) {
            return false;
        }
        if (z && !a((int) fB, (int) fC, iArr[2], i3)) {
            return false;
        }
        float f2 = i3 / 7.0f;
        for (int i4 = 0; i4 < this.f5762b.size(); i4++) {
            d dVar = this.f5762b.get(i4);
            if (dVar.a(f2, fB, fC)) {
                this.f5762b.set(i4, dVar.b(fB, fC, f2));
                z2 = true;
                break;
            }
        }
        if (!z2) {
            d dVar2 = new d(fC, fB, f2);
            this.f5762b.add(dVar2);
            if (this.f5765e != null) {
                this.f5765e.a(dVar2);
            }
        }
        return true;
    }
}
