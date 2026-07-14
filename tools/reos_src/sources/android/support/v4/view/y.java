package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f941d;

    public y(View view) {
        this.f938a = view;
    }

    public void a(boolean z) {
        if (this.f940c) {
            ah.C(this.f938a);
        }
        this.f940c = z;
    }

    public boolean a() {
        return this.f940c;
    }

    public boolean a(float f2, float f3) {
        if (!a() || this.f939b == null) {
            return false;
        }
        return ay.a(this.f939b, this.f938a, f2, f3);
    }

    public boolean a(float f2, float f3, boolean z) {
        if (!a() || this.f939b == null) {
            return false;
        }
        return ay.a(this.f939b, this.f938a, f2, f3, z);
    }

    public boolean a(int i) {
        if (b()) {
            return true;
        }
        if (a()) {
            View view = this.f938a;
            for (ViewParent parent = this.f938a.getParent(); parent != null; parent = parent.getParent()) {
                if (ay.a(parent, view, this.f938a, i)) {
                    this.f939b = parent;
                    ay.b(parent, view, this.f938a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        if (!a() || this.f939b == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr == null) {
                return false;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        if (iArr != null) {
            this.f938a.getLocationInWindow(iArr);
            int i7 = iArr[0];
            i5 = iArr[1];
            i6 = i7;
        } else {
            i5 = 0;
            i6 = 0;
        }
        ay.a(this.f939b, this.f938a, i, i2, i3, i4);
        if (iArr != null) {
            this.f938a.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i5;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        int i3;
        int i4;
        if (!a() || this.f939b == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f938a.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i3 = iArr2[1];
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.f941d == null) {
                this.f941d = new int[2];
            }
            iArr = this.f941d;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ay.a(this.f939b, this.f938a, i, i2, iArr);
        if (iArr2 != null) {
            this.f938a.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i3;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean b() {
        return this.f939b != null;
    }

    public void c() {
        if (this.f939b != null) {
            ay.a(this.f939b, this.f938a);
            this.f939b = null;
        }
    }
}
