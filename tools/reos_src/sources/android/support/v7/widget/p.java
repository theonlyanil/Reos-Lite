package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
class p implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f1827a = new RectF();

    p() {
    }

    private ae a(Context context, int i, float f2, float f3, float f4) {
        return new ae(context.getResources(), i, f2, f3, f4);
    }

    private ae i(o oVar) {
        return (ae) oVar.c();
    }

    @Override // android.support.v7.widget.q
    public float a(o oVar) {
        return i(oVar).c();
    }

    @Override // android.support.v7.widget.q
    public void a() {
        ae.f1701c = new ae.a() { // from class: android.support.v7.widget.p.1
            @Override // android.support.v7.widget.ae.a
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                float f3 = 2.0f * f2;
                float fWidth = (rectF.width() - f3) - 1.0f;
                float fHeight = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    p.this.f1827a.set(-f4, -f4, f4, f4);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f4, rectF.top + f4);
                    canvas.drawArc(p.this.f1827a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, BitmapDescriptorFactory.HUE_RED);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.f1827a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, BitmapDescriptorFactory.HUE_RED);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.f1827a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, BitmapDescriptorFactory.HUE_RED);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.f1827a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f4) - 1.0f, rectF.top, 1.0f + (rectF.right - f4), rectF.top + f4, paint);
                    canvas.drawRect((rectF.left + f4) - 1.0f, 1.0f + (rectF.bottom - f4), 1.0f + (rectF.right - f4), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, Math.max(BitmapDescriptorFactory.HUE_RED, f2 - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f2), paint);
            }
        };
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, float f2) {
        i(oVar).a(f2);
        f(oVar);
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, int i) {
        i(oVar).a(i);
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, Context context, int i, float f2, float f3, float f4) {
        ae aeVarA = a(context, i, f2, f3, f4);
        aeVarA.a(oVar.b());
        oVar.a(aeVarA);
        f(oVar);
    }

    @Override // android.support.v7.widget.q
    public float b(o oVar) {
        return i(oVar).d();
    }

    @Override // android.support.v7.widget.q
    public void b(o oVar, float f2) {
        i(oVar).c(f2);
        f(oVar);
    }

    @Override // android.support.v7.widget.q
    public float c(o oVar) {
        return i(oVar).e();
    }

    @Override // android.support.v7.widget.q
    public void c(o oVar, float f2) {
        i(oVar).b(f2);
    }

    @Override // android.support.v7.widget.q
    public float d(o oVar) {
        return i(oVar).a();
    }

    @Override // android.support.v7.widget.q
    public float e(o oVar) {
        return i(oVar).b();
    }

    public void f(o oVar) {
        Rect rect = new Rect();
        i(oVar).a(rect);
        oVar.a((int) Math.ceil(b(oVar)), (int) Math.ceil(c(oVar)));
        oVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.support.v7.widget.q
    public void g(o oVar) {
    }

    @Override // android.support.v7.widget.q
    public void h(o oVar) {
        i(oVar).a(oVar.b());
        f(oVar);
    }
}
