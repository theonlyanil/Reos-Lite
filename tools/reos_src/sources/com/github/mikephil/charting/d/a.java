package com.github.mikephil.charting.d;

import com.github.mikephil.charting.data.l;
import com.github.mikephil.charting.data.m;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a implements e {
    @Override // com.github.mikephil.charting.d.e
    public float a(m mVar, com.github.mikephil.charting.f.f fVar) {
        float yChartMax = fVar.getYChartMax();
        float yChartMin = fVar.getYChartMin();
        l lineData = fVar.getLineData();
        if ((mVar.n() > BitmapDescriptorFactory.HUE_RED && mVar.m() < BitmapDescriptorFactory.HUE_RED) || fVar.b(mVar.s()).y()) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (lineData.h() > BitmapDescriptorFactory.HUE_RED) {
            yChartMax = 0.0f;
        }
        if (lineData.g() < BitmapDescriptorFactory.HUE_RED) {
            yChartMin = 0.0f;
        }
        if (mVar.m() < BitmapDescriptorFactory.HUE_RED) {
            yChartMin = yChartMax;
        }
        return yChartMin;
    }
}
