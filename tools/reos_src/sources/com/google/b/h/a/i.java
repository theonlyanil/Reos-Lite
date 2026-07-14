package com.google.b.h.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[][] f5699a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, com.google.b.h.a.f5652a.length, 8);

    static {
        for (int i = 0; i < com.google.b.h.a.f5652a.length; i++) {
            int i2 = com.google.b.h.a.f5652a[i];
            int i3 = i2 & 1;
            for (int i4 = 0; i4 < 8; i4++) {
                float f2 = BitmapDescriptorFactory.HUE_RED;
                while ((i2 & 1) == i3) {
                    f2 += 1.0f;
                    i2 >>= 1;
                }
                i3 = i2 & 1;
                f5699a[i][(8 - i4) - 1] = f2 / 17.0f;
            }
        }
    }

    static int a(int[] iArr) {
        int iC = c(b(iArr));
        return iC != -1 ? iC : e(iArr);
    }

    private static int[] b(int[] iArr) {
        int i = 0;
        float fA = com.google.b.h.a.a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (iArr[i2] + i <= (fA / 34.0f) + ((i3 * fA) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int c(int[] iArr) {
        int iD = d(iArr);
        if (com.google.b.h.a.a(iD) == -1) {
            return -1;
        }
        return iD;
    }

    private static int d(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (i2 < iArr[i]) {
                i2++;
                j = (j << 1) | ((long) (i % 2 == 0 ? 1 : 0));
            }
        }
        return (int) j;
    }

    private static int e(int[] iArr) {
        int iA = com.google.b.h.a.a(iArr);
        float[] fArr = new float[8];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = iArr[i] / iA;
        }
        float f2 = Float.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < f5699a.length; i3++) {
            float f3 = BitmapDescriptorFactory.HUE_RED;
            float[] fArr2 = f5699a[i3];
            for (int i4 = 0; i4 < 8; i4++) {
                float f4 = fArr2[i4] - fArr[i4];
                f3 += f4 * f4;
                if (f3 >= f2) {
                    break;
                }
            }
            if (f3 < f2) {
                i2 = com.google.b.h.a.f5652a[i3];
                f2 = f3;
            }
        }
        return i2;
    }
}
