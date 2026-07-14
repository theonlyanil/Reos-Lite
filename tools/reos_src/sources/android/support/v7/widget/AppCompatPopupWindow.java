package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f1392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1393b;

    static {
        f1392a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap apVarA = ap.a(context, attributeSet, android.support.v7.b.a.k.PopupWindow, i, 0);
        if (apVarA.f(android.support.v7.b.a.k.PopupWindow_overlapAnchor)) {
            a(apVarA.a(android.support.v7.b.a.k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(apVarA.a(android.support.v7.b.a.k.PopupWindow_android_popupBackground));
        apVarA.a();
        if (Build.VERSION.SDK_INT < 14) {
            a(this);
        }
    }

    private static void a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new ViewTreeObserver.OnScrollChangedListener() { // from class: android.support.v7.widget.AppCompatPopupWindow.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        onScrollChangedListener.onScrollChanged();
                    } catch (IllegalAccessException e2) {
                    }
                }
            });
        } catch (Exception e2) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e2);
        }
    }

    public void a(boolean z) {
        if (f1392a) {
            this.f1393b = z;
        } else {
            android.support.v4.widget.q.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f1392a && this.f1393b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1392a && this.f1393b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (f1392a && this.f1393b) ? i2 - view.getHeight() : i2, i3, i4);
    }
}
