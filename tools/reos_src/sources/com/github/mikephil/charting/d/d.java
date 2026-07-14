package com.github.mikephil.charting.d;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecimalFormat f4942a;

    public d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f4942a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.d.h
    public String a(float f2, com.github.mikephil.charting.c.g gVar) {
        return this.f4942a.format(f2);
    }
}
