package com.cube26.iota.smartlite.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.cube26.iota.smartlite.R;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3460a = {R.drawable.vevo, R.drawable.times_music, R.drawable.t_series, R.drawable.tips_music, R.drawable.music_today, R.drawable.saregama_geny, R.drawable.sony_music, R.drawable.sony_music_vevo, R.drawable.bluefrog, R.drawable.eros_now};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f3461b = {R.drawable.rainy_dummy, R.drawable.sunny_dummy, R.drawable.cloudy_dummy, R.drawable.foggy_dummy, R.drawable.thunderstorm_dummy, R.drawable.flurries_dummy, R.drawable.snowy_dummy, R.drawable.windy_dummy};

    public static Drawable a(int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(i2, -16777216);
        gradientDrawable.setShape(i3);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
