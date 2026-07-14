package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ab;
import android.support.v4.view.ah;
import android.support.v4.view.bh;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f216c;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f216c = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.ScrimInsetsFrameLayout, i, android.support.design.a.h.Widget_Design_ScrimInsetsFrameLayout);
        this.f214a = typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.ScrimInsetsFrameLayout_insetForeground);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ah.a(this, new ab() { // from class: android.support.design.internal.ScrimInsetsFrameLayout.1
            @Override // android.support.v4.view.ab
            public bh a(View view, bh bhVar) {
                if (ScrimInsetsFrameLayout.this.f215b == null) {
                    ScrimInsetsFrameLayout.this.f215b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f215b.set(bhVar.a(), bhVar.b(), bhVar.c(), bhVar.d());
                ScrimInsetsFrameLayout.this.a(ScrimInsetsFrameLayout.this.f215b);
                ScrimInsetsFrameLayout.this.setWillNotDraw(ScrimInsetsFrameLayout.this.f215b.isEmpty() || ScrimInsetsFrameLayout.this.f214a == null);
                ah.d(ScrimInsetsFrameLayout.this);
                return bhVar.f();
            }
        });
    }

    protected void a(Rect rect) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f215b == null || this.f214a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.f216c.set(0, 0, width, this.f215b.top);
        this.f214a.setBounds(this.f216c);
        this.f214a.draw(canvas);
        this.f216c.set(0, height - this.f215b.bottom, width, height);
        this.f214a.setBounds(this.f216c);
        this.f214a.draw(canvas);
        this.f216c.set(0, this.f215b.top, this.f215b.left, height - this.f215b.bottom);
        this.f214a.setBounds(this.f216c);
        this.f214a.draw(canvas);
        this.f216c.set(width - this.f215b.right, this.f215b.top, width, height - this.f215b.bottom);
        this.f214a.setBounds(this.f216c);
        this.f214a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f214a != null) {
            this.f214a.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f214a != null) {
            this.f214a.setCallback(null);
        }
    }
}
