package com.google.b.c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f5476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f5477f;
    private final float g;
    private final float h;
    private final float i;

    private k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f5472a = f2;
        this.f5473b = f5;
        this.f5474c = f8;
        this.f5475d = f3;
        this.f5476e = f6;
        this.f5477f = f9;
        this.g = f4;
        this.h = f7;
        this.i = f10;
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == BitmapDescriptorFactory.HUE_RED && f11 == BitmapDescriptorFactory.HUE_RED) {
            return new k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f11 * f12) - (f10 * f14)) / f16;
        return new k((f4 - f2) + (f17 * f4), (f8 - f2) + (f18 * f8), f2, (f17 * f5) + (f5 - f3), (f18 * f9) + (f9 - f3), f3, f17, f18, 1.0f);
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return a(f10, f11, f12, f13, f14, f15, f16, f17).a(b(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static k b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return a(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    k a() {
        return new k((this.f5476e * this.i) - (this.f5477f * this.h), (this.f5477f * this.g) - (this.f5475d * this.i), (this.f5475d * this.h) - (this.f5476e * this.g), (this.f5474c * this.h) - (this.f5473b * this.i), (this.f5472a * this.i) - (this.f5474c * this.g), (this.f5473b * this.g) - (this.f5472a * this.h), (this.f5473b * this.f5477f) - (this.f5474c * this.f5476e), (this.f5474c * this.f5475d) - (this.f5472a * this.f5477f), (this.f5472a * this.f5476e) - (this.f5473b * this.f5475d));
    }

    k a(k kVar) {
        return new k((this.f5472a * kVar.f5472a) + (this.f5475d * kVar.f5473b) + (this.g * kVar.f5474c), (this.f5472a * kVar.f5475d) + (this.f5475d * kVar.f5476e) + (this.g * kVar.f5477f), (this.f5472a * kVar.g) + (this.f5475d * kVar.h) + (this.g * kVar.i), (this.f5473b * kVar.f5472a) + (this.f5476e * kVar.f5473b) + (this.h * kVar.f5474c), (this.f5473b * kVar.f5475d) + (this.f5476e * kVar.f5476e) + (this.h * kVar.f5477f), (this.f5473b * kVar.g) + (this.f5476e * kVar.h) + (this.h * kVar.i), (this.f5474c * kVar.f5472a) + (this.f5477f * kVar.f5473b) + (this.i * kVar.f5474c), (this.f5474c * kVar.f5475d) + (this.f5477f * kVar.f5476e) + (this.i * kVar.f5477f), (this.f5474c * kVar.g) + (this.f5477f * kVar.h) + (this.i * kVar.i));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f2 = this.f5472a;
        float f3 = this.f5473b;
        float f4 = this.f5474c;
        float f5 = this.f5475d;
        float f6 = this.f5476e;
        float f7 = this.f5477f;
        float f8 = this.g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i = 0; i < length; i += 2) {
            float f11 = fArr[i];
            float f12 = fArr[i + 1];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr[i] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr[i + 1] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }
}
