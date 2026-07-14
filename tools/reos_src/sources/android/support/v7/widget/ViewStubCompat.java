package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<View> f1676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f1677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f1678e;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1674a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ViewStubCompat, i, 0);
        this.f1675b = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.ViewStubCompat_android_inflatedId, -1);
        this.f1674a = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f1674a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        View viewInflate = (this.f1677d != null ? this.f1677d : LayoutInflater.from(getContext())).inflate(this.f1674a, viewGroup, false);
        if (this.f1675b != -1) {
            viewInflate.setId(this.f1675b);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f1676c = new WeakReference<>(viewInflate);
        if (this.f1678e != null) {
            this.f1678e.a(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1675b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1677d;
    }

    public int getLayoutResource() {
        return this.f1674a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1675b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1677d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1674a = i;
    }

    public void setOnInflateListener(a aVar) {
        this.f1678e = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f1676c != null) {
            View view = this.f1676c.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }
}
