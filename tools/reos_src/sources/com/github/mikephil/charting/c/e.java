package com.github.mikephil.charting.c;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends RelativeLayout {
    private void setupLayoutResource(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    public abstract int a(float f2);

    public void a(Canvas canvas, float f2, float f3) {
        float fA = a(f2) + f2;
        float fB = b(f3) + f3;
        canvas.translate(fA, fB);
        draw(canvas);
        canvas.translate(-fA, -fB);
    }

    public abstract void a(Entry entry, com.github.mikephil.charting.e.d dVar);

    public abstract int b(float f2);
}
