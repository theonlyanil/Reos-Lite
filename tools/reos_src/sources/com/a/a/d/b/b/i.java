package com.a.a.d.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f2102c;

    private static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f2103a;

        public a(DisplayMetrics displayMetrics) {
            this.f2103a = displayMetrics;
        }

        @Override // com.a.a.d.b.b.i.b
        public int a() {
            return this.f2103a.widthPixels;
        }

        @Override // com.a.a.d.b.b.i.b
        public int b() {
            return this.f2103a.heightPixels;
        }
    }

    interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    i(Context context, ActivityManager activityManager, b bVar) {
        this.f2102c = context;
        int iA = a(activityManager);
        int iA2 = bVar.a() * bVar.b() * 4;
        int i = iA2 * 4;
        int i2 = iA2 * 2;
        if (i2 + i <= iA) {
            this.f2101b = i2;
            this.f2100a = i;
        } else {
            int iRound = Math.round(iA / 6.0f);
            this.f2101b = iRound * 2;
            this.f2100a = iRound * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + a(this.f2101b) + " pool size: " + a(this.f2100a) + " memory class limited? " + (i2 + i > iA) + " max size: " + a(iA) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + b(activityManager));
        }
    }

    private static int a(ActivityManager activityManager) {
        return Math.round((b(activityManager) ? 0.33f : 0.4f) * activityManager.getMemoryClass() * Place.TYPE_SUBLOCALITY_LEVEL_2 * Place.TYPE_SUBLOCALITY_LEVEL_2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f2102c, i);
    }

    @TargetApi(19)
    private static boolean b(ActivityManager activityManager) {
        int i = Build.VERSION.SDK_INT;
        return i < 11 || (i >= 19 && activityManager.isLowRamDevice());
    }

    public int a() {
        return this.f2101b;
    }

    public int b() {
        return this.f2100a;
    }
}
