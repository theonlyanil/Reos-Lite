package com.github.mikephil.charting.h;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.i.d f5017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f5018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f5019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f5020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Paint f5021e;

    public a(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.i.d dVar) {
        super(gVar);
        this.f5017a = dVar;
        this.f5019c = new Paint(1);
        this.f5018b = new Paint();
        this.f5018b.setColor(-7829368);
        this.f5018b.setStrokeWidth(1.0f);
        this.f5018b.setStyle(Paint.Style.STROKE);
        this.f5018b.setAlpha(90);
        this.f5020d = new Paint();
        this.f5020d.setColor(-16777216);
        this.f5020d.setStrokeWidth(1.0f);
        this.f5020d.setStyle(Paint.Style.STROKE);
        this.f5021e = new Paint(1);
        this.f5021e.setStyle(Paint.Style.STROKE);
    }

    public Paint a() {
        return this.f5019c;
    }
}
