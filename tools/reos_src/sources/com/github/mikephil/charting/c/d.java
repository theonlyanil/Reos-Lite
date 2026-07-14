package com.github.mikephil.charting.c;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint.Style f4881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4882e;
    private DashPathEffect l;
    private a m;

    public enum a {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public float a() {
        return this.f4878a;
    }

    public float b() {
        return this.f4879b;
    }

    public int c() {
        return this.f4880c;
    }

    public DashPathEffect d() {
        return this.l;
    }

    public Paint.Style e() {
        return this.f4881d;
    }

    public a f() {
        return this.m;
    }

    public String g() {
        return this.f4882e;
    }
}
