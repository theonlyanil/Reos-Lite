package android.support.v4.view.b;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f905b;

    public d(float[] fArr) {
        this.f904a = fArr;
        this.f905b = 1.0f / (this.f904a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int iMin = Math.min((int) ((this.f904a.length - 1) * f2), this.f904a.length - 2);
        return ((this.f904a[iMin + 1] - this.f904a[iMin]) * ((f2 - (iMin * this.f905b)) / this.f905b)) + this.f904a[iMin];
    }
}
