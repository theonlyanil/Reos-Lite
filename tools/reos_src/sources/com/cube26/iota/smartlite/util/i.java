package com.cube26.iota.smartlite.util;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static float a(Resources resources, float f2) {
        return (resources.getDisplayMetrics().density * f2) + 0.5f;
    }

    public static float b(Resources resources, float f2) {
        return resources.getDisplayMetrics().scaledDensity * f2;
    }
}
