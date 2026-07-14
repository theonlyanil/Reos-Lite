package com.github.mikephil.charting.a;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f4845a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f4846b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f4847c;

    public a() {
    }

    public a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f4847c = animatorUpdateListener;
    }

    public float a() {
        return this.f4845a;
    }

    public float b() {
        return this.f4846b;
    }
}
