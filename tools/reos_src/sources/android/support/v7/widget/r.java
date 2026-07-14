package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class r extends p {
    r() {
    }

    @Override // android.support.v7.widget.p, android.support.v7.widget.q
    public void a() {
        ae.f1701c = new ae.a() { // from class: android.support.v7.widget.r.1
            @Override // android.support.v7.widget.ae.a
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                canvas.drawRoundRect(rectF, f2, f2, paint);
            }
        };
    }
}
