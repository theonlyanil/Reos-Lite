package com.github.mikephil.charting.d;

import com.github.mikephil.charting.data.Entry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecimalFormat f4941a;

    public b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f4941a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.d.f
    public String a(float f2, Entry entry, int i, com.github.mikephil.charting.i.g gVar) {
        return this.f4941a.format(f2);
    }
}
