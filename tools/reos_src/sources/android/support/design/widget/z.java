package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class z<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aa f517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f519c;

    public z() {
        this.f518b = 0;
        this.f519c = 0;
    }

    public z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f518b = 0;
        this.f519c = 0;
    }

    public boolean a(int i) {
        if (this.f517a != null) {
            return this.f517a.a(i);
        }
        this.f518b = i;
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.f517a == null) {
            this.f517a = new aa(v);
        }
        this.f517a.a();
        if (this.f518b != 0) {
            this.f517a.a(this.f518b);
            this.f518b = 0;
        }
        if (this.f519c == 0) {
            return true;
        }
        this.f517a.b(this.f519c);
        this.f519c = 0;
        return true;
    }

    public int b() {
        if (this.f517a != null) {
            return this.f517a.b();
        }
        return 0;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.a(v, i);
    }
}
