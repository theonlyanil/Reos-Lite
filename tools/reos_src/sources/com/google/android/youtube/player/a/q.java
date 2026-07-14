package com.google.android.youtube.player.a;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class q extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProgressBar f5324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f5325b;

    public q(Context context) {
        super(context, null, ab.c(context));
        p pVar = new p(context);
        setBackgroundColor(-16777216);
        this.f5324a = new ProgressBar(context);
        this.f5324a.setVisibility(8);
        addView(this.f5324a, new FrameLayout.LayoutParams(-2, -2, 17));
        int i = (int) ((10.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f5325b = new TextView(context);
        this.f5325b.setTextAppearance(context, R.style.TextAppearance.Small);
        this.f5325b.setTextColor(-1);
        this.f5325b.setVisibility(8);
        this.f5325b.setPadding(i, i, i, i);
        this.f5325b.setGravity(17);
        this.f5325b.setText(pVar.f5318a);
        addView(this.f5325b, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void a() {
        this.f5324a.setVisibility(8);
        this.f5325b.setVisibility(8);
    }

    public final void b() {
        this.f5324a.setVisibility(0);
        this.f5325b.setVisibility(8);
    }

    public final void c() {
        this.f5324a.setVisibility(8);
        this.f5325b.setVisibility(0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            i3 = size;
        } else if (mode == 1073741824 || (mode == Integer.MIN_VALUE && mode2 == 0)) {
            size2 = (int) (size / 1.777f);
            i3 = size;
        } else if (mode2 == 1073741824 || (mode2 == Integer.MIN_VALUE && mode == 0)) {
            i3 = (int) (size2 * 1.777f);
        } else if (mode != Integer.MIN_VALUE || mode2 != Integer.MIN_VALUE) {
            size2 = 0;
        } else if (size2 < size / 1.777f) {
            i3 = (int) (size2 * 1.777f);
        } else {
            size2 = (int) (size / 1.777f);
            i3 = size;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(resolveSize(i3, i), 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize(size2, i2), 1073741824));
    }
}
