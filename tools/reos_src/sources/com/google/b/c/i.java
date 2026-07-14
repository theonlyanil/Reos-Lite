package com.google.b.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f5470a = new f();

    public static i a() {
        return f5470a;
    }

    protected static void a(b bVar, float[] fArr) throws com.google.b.i {
        int iE = bVar.e();
        int iF = bVar.f();
        boolean z = true;
        for (int i = 0; i < fArr.length && z; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > iE || i3 < -1 || i3 > iF) {
                throw com.google.b.i.a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                z = true;
            } else if (i2 == iE) {
                fArr[i] = iE - 1;
                z = true;
            } else {
                z = false;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                z = true;
            } else if (i3 == iF) {
                fArr[i + 1] = iF - 1;
                z = true;
            }
        }
        boolean z2 = true;
        for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
            int i4 = (int) fArr[length];
            int i5 = (int) fArr[length + 1];
            if (i4 < -1 || i4 > iE || i5 < -1 || i5 > iF) {
                throw com.google.b.i.a();
            }
            if (i4 == -1) {
                fArr[length] = 0.0f;
                z2 = true;
            } else if (i4 == iE) {
                fArr[length] = iE - 1;
                z2 = true;
            } else {
                z2 = false;
            }
            if (i5 == -1) {
                fArr[length + 1] = 0.0f;
                z2 = true;
            } else if (i5 == iF) {
                fArr[length + 1] = iF - 1;
                z2 = true;
            }
        }
    }

    public abstract b a(b bVar, int i, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws com.google.b.i;

    public abstract b a(b bVar, int i, int i2, k kVar) throws com.google.b.i;
}
