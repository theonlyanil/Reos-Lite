package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class YouTubeThumbnailView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.youtube.player.a.a f5301a;

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void finalize() throws Throwable {
        if (this.f5301a != null) {
            this.f5301a.c();
            this.f5301a = null;
        }
        super.finalize();
    }
}
