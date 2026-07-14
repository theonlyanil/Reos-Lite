package com.cube26.iota.smartlite.neonmusic.visualizer.a;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float[] f3386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float[] f3387b;

    public abstract void a(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.a aVar, Rect rect);

    public abstract void a(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.b bVar, Rect rect);

    public final void b(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.a aVar, Rect rect) {
        if (this.f3386a == null || this.f3386a.length < aVar.f3381a.length * 4) {
            this.f3386a = new float[aVar.f3381a.length * 4];
        }
        a(canvas, aVar, rect);
    }

    public final void b(Canvas canvas, com.cube26.iota.smartlite.neonmusic.visualizer.b bVar, Rect rect) {
        if (this.f3387b == null || this.f3387b.length < bVar.f3388a.length * 4) {
            this.f3387b = new float[bVar.f3388a.length * 4];
        }
        a(canvas, bVar, rect);
    }
}
