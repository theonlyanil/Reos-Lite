package com.getbase.floatingactionbutton;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f4784a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<TouchDelegate> f4785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TouchDelegate f4786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4787d;

    public b(View view) {
        super(f4784a, view);
        this.f4785b = new ArrayList<>();
    }

    public void a() {
        this.f4785b.clear();
        this.f4786c = null;
    }

    public void a(TouchDelegate touchDelegate) {
        this.f4785b.add(touchDelegate);
    }

    public void a(boolean z) {
        this.f4787d = z;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate;
        if (!this.f4787d) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                for (int i = 0; i < this.f4785b.size(); i++) {
                    TouchDelegate touchDelegate2 = this.f4785b.get(i);
                    if (touchDelegate2.onTouchEvent(motionEvent)) {
                        this.f4786c = touchDelegate2;
                        return true;
                    }
                }
                touchDelegate = null;
                break;
            case 1:
            case 3:
                touchDelegate = this.f4786c;
                this.f4786c = null;
                break;
            case 2:
                touchDelegate = this.f4786c;
                break;
            default:
                touchDelegate = null;
                break;
        }
        return touchDelegate != null && touchDelegate.onTouchEvent(motionEvent);
    }
}
