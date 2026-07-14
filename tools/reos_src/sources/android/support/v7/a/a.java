package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: android.support.v7.a.a$a, reason: collision with other inner class name */
    public static class C0026a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1038a;

        public C0026a(int i, int i2) {
            super(i, i2);
            this.f1038a = 0;
            this.f1038a = 8388627;
        }

        public C0026a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1038a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ActionBarLayout);
            this.f1038a = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0026a(C0026a c0026a) {
            super((ViewGroup.MarginLayoutParams) c0026a);
            this.f1038a = 0;
            this.f1038a = c0026a.f1038a;
        }

        public C0026a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1038a = 0;
        }
    }

    public interface b {
        void a(boolean z);
    }

    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

    public abstract int a();

    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        return null;
    }

    public void a(float f2) {
        if (f2 != BitmapDescriptorFactory.HUE_RED) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void a(int i) {
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(Drawable drawable);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public abstract void b();

    public void b(Drawable drawable) {
    }

    public void b(CharSequence charSequence) {
    }

    public abstract void b(boolean z);

    public void c(boolean z) {
    }

    public abstract boolean c();

    public Context d() {
        return null;
    }

    public void d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int e() {
        return 0;
    }

    public void e(boolean z) {
    }

    public void f(boolean z) {
    }

    public boolean f() {
        return false;
    }

    public void g(boolean z) {
    }

    public boolean g() {
        return false;
    }

    boolean h() {
        return false;
    }

    void i() {
    }
}
