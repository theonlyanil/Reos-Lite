package com.google.android.youtube.player.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.google.android.youtube.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.youtube.player.e.a f5303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5304b;

    protected boolean a() {
        return !this.f5304b;
    }

    public final void b() {
        if (a()) {
            this.f5304b = true;
            this.f5303a = null;
            d();
        }
    }

    public final void c() {
        if (a()) {
            aa.a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            b();
        }
    }

    public abstract void d();
}
