package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzmw extends ImageView {
    private Uri zzaiJ;
    private int zzaiK;
    private int zzaiL;
    private zza zzaiM;
    private int zzaiN;
    private float zzaiO;

    public interface zza {
        Path zzl(int i, int i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.zzaiM != null) {
            canvas.clipPath(this.zzaiM.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzaiL != 0) {
            canvas.drawColor(this.zzaiL);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        super.onMeasure(i, i2);
        switch (this.zzaiN) {
            case 1:
                measuredHeight = getMeasuredHeight();
                measuredWidth = (int) (measuredHeight * this.zzaiO);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                measuredHeight = (int) (measuredWidth / this.zzaiO);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void zzbP(int i) {
        this.zzaiK = i;
    }

    public void zzm(Uri uri) {
        this.zzaiJ = uri;
    }

    public int zzpX() {
        return this.zzaiK;
    }
}
