package com.github.mikephil.charting.data;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a extends c<b> {
    private float k = 0.8f;

    public float a() {
        return this.j.size() <= 1 ? BitmapDescriptorFactory.HUE_RED : this.k;
    }

    public boolean b() {
        return this.j.size() > 1;
    }
}
