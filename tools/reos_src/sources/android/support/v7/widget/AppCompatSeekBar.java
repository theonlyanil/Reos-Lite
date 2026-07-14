package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSeekBar extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f1401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1402b;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1402b = h.a();
        this.f1401a = new k(this, this.f1402b);
        this.f1401a.a(attributeSet, i);
    }
}
