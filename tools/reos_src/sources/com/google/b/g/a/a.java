package com.google.b.g.a;

import com.google.b.g.k;
import com.google.b.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f5550a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5551b = new int[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f5552c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f5553d = new float[4];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f5554e = new int[this.f5551b.length / 2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f5555f = new int[this.f5551b.length / 2];

    protected a() {
    }

    protected static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws i {
        for (int i = 0; i < iArr2.length; i++) {
            if (a(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw i.a();
    }

    protected static void a(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void b(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean b(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = i / ((iArr[2] + i) + iArr[3]);
        if (f2 < 0.7916667f || f2 > 0.89285713f) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = iArr[i4];
            if (i5 > i3) {
                i3 = i5;
            }
            if (i5 >= i2) {
                i5 = i2;
            }
            i4++;
            i2 = i5;
        }
        return i3 < i2 * 10;
    }

    protected final int[] b() {
        return this.f5550a;
    }

    protected final int[] c() {
        return this.f5551b;
    }

    protected final float[] d() {
        return this.f5552c;
    }

    protected final float[] e() {
        return this.f5553d;
    }

    protected final int[] f() {
        return this.f5554e;
    }

    protected final int[] g() {
        return this.f5555f;
    }
}
