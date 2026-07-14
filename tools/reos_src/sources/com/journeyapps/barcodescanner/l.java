package com.journeyapps.barcodescanner;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f5915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f5920f;

    public l(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f5915a = bArr;
        this.f5916b = i;
        this.f5917c = i2;
        this.f5919e = i4;
        this.f5918d = i3;
    }

    public static byte[] a(int i, byte[] bArr, int i2, int i3) {
        switch (i) {
            case 0:
            default:
                return bArr;
            case 90:
                return a(bArr, i2, i3);
            case 180:
                return b(bArr, i2, i3);
            case 270:
                return c(bArr, i2, i3);
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public void a(Rect rect) {
        this.f5920f = rect;
    }

    public boolean a() {
        return this.f5919e % 180 != 0;
    }

    public com.google.b.j b() {
        byte[] bArrA = a(this.f5919e, this.f5915a, this.f5916b, this.f5917c);
        return a() ? new com.google.b.j(bArrA, this.f5917c, this.f5916b, this.f5920f.left, this.f5920f.top, this.f5920f.width(), this.f5920f.height(), false) : new com.google.b.j(bArrA, this.f5916b, this.f5917c, this.f5920f.left, this.f5920f.top, this.f5920f.width(), this.f5920f.height(), false);
    }
}
