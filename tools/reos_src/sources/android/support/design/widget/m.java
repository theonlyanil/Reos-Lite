package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class m extends z<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f469d;

    public m() {
        this.f466a = new Rect();
        this.f467b = new Rect();
        this.f468c = 0;
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f466a = new Rect();
        this.f467b = new Rect();
        this.f468c = 0;
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    float a(View view) {
        return 1.0f;
    }

    final int a() {
        return this.f468c;
    }

    abstract View a(List<View> list);

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewA;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (viewA = a(coordinatorLayout.d(view))) != null) {
            if (ah.w(viewA) && !ah.w(view)) {
                ah.a(view, true);
                if (ah.w(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            if (ah.D(viewA)) {
                int size = View.MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec(b(viewA) + (size - viewA.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    public final void b(int i) {
        this.f469d = i;
    }

    @Override // android.support.design.widget.z
    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewA = a(coordinatorLayout.d(view));
        if (viewA == null) {
            super.b(coordinatorLayout, view, i);
            this.f468c = 0;
            return;
        }
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
        Rect rect = this.f466a;
        rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, viewA.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + viewA.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
        Rect rect2 = this.f467b;
        android.support.v4.view.e.a(c(eVar.f287c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int iC = c(viewA);
        view.layout(rect2.left, rect2.top - iC, rect2.right, rect2.bottom - iC);
        this.f468c = rect2.top - viewA.getBottom();
    }

    final int c(View view) {
        if (this.f469d == 0) {
            return 0;
        }
        return n.a(Math.round(a(view) * this.f469d), 0, this.f469d);
    }
}
