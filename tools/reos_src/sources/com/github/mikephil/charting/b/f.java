package com.github.mikephil.charting.b;

import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public f(int i, float f2, int i2, boolean z) {
        super(i, f2, i2, z);
    }

    @Override // com.github.mikephil.charting.b.b
    public void a(List<BarEntry> list) {
        float f2;
        float fAbs;
        float f3;
        float f4;
        float size = list.size() * this.f4850c;
        int i = this.j - 1;
        float f5 = this.g / 2.0f;
        float f6 = this.h / 2.0f;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                a();
                return;
            }
            BarEntry barEntry = list.get(i3);
            float f7 = barEntry.f() + (barEntry.f() * i) + this.i + (this.h * barEntry.f()) + f6;
            float fB = barEntry.b();
            float[] fArrA = barEntry.a();
            if (!this.k || fArrA == null) {
                float f8 = (f7 - 0.5f) + f5;
                float f9 = (f7 + 0.5f) - f5;
                if (this.l) {
                    float f10 = fB >= BitmapDescriptorFactory.HUE_RED ? fB : BitmapDescriptorFactory.HUE_RED;
                    f2 = fB <= BitmapDescriptorFactory.HUE_RED ? fB : BitmapDescriptorFactory.HUE_RED;
                    fB = f10;
                } else {
                    f2 = fB >= BitmapDescriptorFactory.HUE_RED ? fB : BitmapDescriptorFactory.HUE_RED;
                    if (fB > BitmapDescriptorFactory.HUE_RED) {
                        fB = BitmapDescriptorFactory.HUE_RED;
                    }
                }
                if (f2 > BitmapDescriptorFactory.HUE_RED) {
                    f2 *= this.f4851d;
                } else {
                    fB *= this.f4851d;
                }
                a(fB, f9, f2, f8);
            } else {
                float f11 = BitmapDescriptorFactory.HUE_RED;
                float f12 = -barEntry.d();
                for (float f13 : fArrA) {
                    if (f13 >= BitmapDescriptorFactory.HUE_RED) {
                        fAbs = f11 + f13;
                        f3 = f11;
                        f11 = fAbs;
                    } else {
                        fAbs = Math.abs(f13) + f12;
                        float fAbs2 = Math.abs(f13) + f12;
                        f3 = f12;
                        f12 = fAbs2;
                    }
                    float f14 = (f7 - 0.5f) + f5;
                    float f15 = (f7 + 0.5f) - f5;
                    if (this.l) {
                        float f16 = f3 >= fAbs ? f3 : fAbs;
                        if (f3 > fAbs) {
                            f3 = fAbs;
                        }
                        f4 = f16;
                    } else {
                        float f17 = f3 >= fAbs ? f3 : fAbs;
                        if (f3 > fAbs) {
                            f3 = fAbs;
                        }
                        f4 = f3;
                        f3 = f17;
                    }
                    a(f4 * this.f4851d, f15, f3 * this.f4851d, f14);
                }
            }
            i2 = i3 + 1;
        }
    }
}
