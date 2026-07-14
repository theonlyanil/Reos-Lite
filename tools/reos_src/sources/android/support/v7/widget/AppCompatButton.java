package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f1373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f1374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f1375c;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1373a = h.a();
        this.f1374b = new f(this, this.f1373a);
        this.f1374b.a(attributeSet, i);
        this.f1375c = l.a(this);
        this.f1375c.a(attributeSet, i);
        this.f1375c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1374b != null) {
            this.f1374b.c();
        }
        if (this.f1375c != null) {
            this.f1375c.a();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1374b != null) {
            return this.f1374b.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1374b != null) {
            return this.f1374b.b();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1374b != null) {
            this.f1374b.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1374b != null) {
            this.f1374b.a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1375c != null) {
            this.f1375c.a(z);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1374b != null) {
            this.f1374b.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1374b != null) {
            this.f1374b.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1375c != null) {
            this.f1375c.a(context, i);
        }
    }
}
