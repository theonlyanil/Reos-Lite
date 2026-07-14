package com.journeyapps.barcodescanner.a;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5872a = f.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f5873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5875d = false;

    public f(int i, k kVar) {
        this.f5874c = i;
        this.f5873b = kVar;
    }

    public static k a(k kVar, k kVar2) {
        k kVarA;
        if (kVar2.a(kVar)) {
            while (true) {
                kVarA = kVar.a(2, 3);
                k kVarA2 = kVar.a(1, 2);
                if (!kVar2.a(kVarA2)) {
                    break;
                }
                kVar = kVarA2;
            }
            return kVar2.a(kVarA) ? kVarA : kVar;
        }
        do {
            k kVarA3 = kVar.a(3, 2);
            kVar = kVar.a(2, 1);
            if (kVar2.a(kVarA3)) {
                return kVarA3;
            }
        } while (!kVar2.a(kVar));
        return kVar;
    }

    public int a() {
        return this.f5874c;
    }

    public Rect a(k kVar) {
        k kVarA = a(kVar, this.f5873b);
        Log.i(f5872a, "Preview: " + kVar + "; Scaled: " + kVarA + "; Want: " + this.f5873b);
        int i = (kVarA.f5913a - this.f5873b.f5913a) / 2;
        int i2 = (kVarA.f5914b - this.f5873b.f5914b) / 2;
        return new Rect(-i, -i2, kVarA.f5913a - i, kVarA.f5914b - i2);
    }

    public k a(List<k> list, boolean z) {
        final k kVarA = a(z);
        if (kVarA == null) {
            return list.get(0);
        }
        Collections.sort(list, new Comparator<k>() { // from class: com.journeyapps.barcodescanner.a.f.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                int i = f.a(kVar, kVarA).f5913a - kVar.f5913a;
                int i2 = f.a(kVar2, kVarA).f5913a - kVar2.f5913a;
                if (i == 0 && i2 == 0) {
                    return kVar.compareTo(kVar2);
                }
                if (i == 0) {
                    return -1;
                }
                if (i2 == 0) {
                    return 1;
                }
                if (i < 0 && i2 < 0) {
                    return kVar.compareTo(kVar2);
                }
                if (i <= 0 || i2 <= 0) {
                    return i >= 0 ? 1 : -1;
                }
                return -kVar.compareTo(kVar2);
            }
        });
        Log.i(f5872a, "Viewfinder size: " + kVarA);
        Log.i(f5872a, "Preview in order of preference: " + list);
        return list.get(0);
    }

    public k a(boolean z) {
        if (this.f5873b == null) {
            return null;
        }
        return z ? this.f5873b.a() : this.f5873b;
    }
}
