package c.a.a.a;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/* JADX INFO: loaded from: classes.dex */
public class a extends RadioGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources f1941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0035a f1944e;

    /* JADX INFO: renamed from: c.a.a.a.a$a, reason: collision with other inner class name */
    private class C0035a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1948d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1949e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f1950f;
        private final float[] g;
        private final float[] h;
        private final float[] i;
        private final float[] j;
        private final float[] k;
        private float[] l;

        private void a(int i, int i2) {
            if (this.f1946b == i && this.f1947c == i2) {
                return;
            }
            this.f1946b = i;
            this.f1947c = i2;
            if (this.f1946b == 1) {
                this.l = this.i;
                return;
            }
            if (this.f1947c == 0) {
                this.l = this.f1945a.getOrientation() == 0 ? this.f1950f : this.j;
            } else if (this.f1947c == this.f1946b - 1) {
                this.l = this.f1945a.getOrientation() == 0 ? this.g : this.k;
            } else {
                this.l = this.h;
            }
        }

        private int b(View view) {
            return this.f1945a.indexOfChild(view);
        }

        private int c() {
            return this.f1945a.getChildCount();
        }

        public int a() {
            return this.f1948d;
        }

        public float[] a(View view) {
            a(c(), b(view));
            return this.l;
        }

        public int b() {
            return this.f1949e;
        }
    }

    private void a(View view) {
        int iA = this.f1944e.a();
        int iB = this.f1944e.b();
        ((Button) view).setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842919, -16842912}, new int[]{-16842919, R.attr.state_checked}}, new int[]{-7829368, this.f1942c, this.f1943d}));
        Drawable drawableMutate = this.f1941b.getDrawable(iA).mutate();
        Drawable drawableMutate2 = this.f1941b.getDrawable(iB).mutate();
        ((GradientDrawable) drawableMutate).setColor(this.f1942c);
        ((GradientDrawable) drawableMutate).setStroke(this.f1940a, this.f1942c);
        ((GradientDrawable) drawableMutate2).setStroke(this.f1940a, this.f1942c);
        ((GradientDrawable) drawableMutate).setCornerRadii(this.f1944e.a(view));
        ((GradientDrawable) drawableMutate2).setCornerRadii(this.f1944e.a(view));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842912}, drawableMutate2);
        stateListDrawable.addState(new int[]{R.attr.state_checked}, drawableMutate);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(stateListDrawable);
        } else {
            view.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void a() {
        int childCount = super.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a(childAt);
            if (i == childCount - 1) {
                return;
            }
            RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) childAt.getLayoutParams();
            RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(layoutParams.width, layoutParams.height, layoutParams.weight);
            if (getOrientation() == 0) {
                layoutParams2.setMargins(0, 0, -this.f1940a, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, -this.f1940a);
            }
            childAt.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.widget.RadioGroup, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void setTintColor(int i) {
        this.f1942c = i;
        a();
    }
}
