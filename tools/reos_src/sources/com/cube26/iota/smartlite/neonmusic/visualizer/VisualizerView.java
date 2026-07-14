package com.cube26.iota.smartlite.neonmusic.visualizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class VisualizerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Bitmap f3376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Canvas f3377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f3378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f3379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f3380f;
    private Set<com.cube26.iota.smartlite.neonmusic.visualizer.a.b> g;
    private final Paint h;
    private final Paint i;

    public VisualizerView(Context context) {
        this(context, null, 0);
    }

    public VisualizerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisualizerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f3380f = new Rect();
        this.h = new Paint();
        this.i = new Paint();
        this.f3375a = false;
        a();
    }

    private void a() {
        this.f3378d = null;
        this.f3379e = null;
        this.h.setColor(Color.argb(122, 255, 255, 255));
        this.i.setColor(Color.argb(238, 255, 255, 255));
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        this.g = new HashSet();
    }

    public void a(com.cube26.iota.smartlite.neonmusic.visualizer.a.b bVar) {
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    public void a(byte[] bArr) {
        this.f3379e = bArr;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3380f.set(0, 0, getWidth(), getHeight());
        if (this.f3376b == null) {
            this.f3376b = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        }
        if (this.f3377c == null) {
            this.f3377c = new Canvas(this.f3376b);
        }
        if (this.f3378d != null) {
            a aVar = new a(this.f3378d);
            Iterator<com.cube26.iota.smartlite.neonmusic.visualizer.a.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().b(this.f3377c, aVar, this.f3380f);
            }
        }
        if (this.f3379e != null) {
            b bVar = new b(this.f3379e);
            Iterator<com.cube26.iota.smartlite.neonmusic.visualizer.a.b> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().b(this.f3377c, bVar, this.f3380f);
            }
        }
        this.f3377c.drawPaint(this.i);
        if (this.f3375a) {
            this.f3375a = false;
            this.f3377c.drawPaint(this.h);
        }
        canvas.drawBitmap(this.f3376b, new Matrix(), null);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }
}
