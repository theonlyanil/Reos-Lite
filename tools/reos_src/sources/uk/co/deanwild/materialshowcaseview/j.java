package uk.co.deanwild.materialshowcaseview;

import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class j implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f6642b;

    public j(View view) {
        this.f6642b = view;
    }

    @Override // uk.co.deanwild.materialshowcaseview.i
    public Point a() {
        int[] iArr = new int[2];
        this.f6642b.getLocationInWindow(iArr);
        return new Point(iArr[0] + (this.f6642b.getWidth() / 2), iArr[1] + (this.f6642b.getHeight() / 2));
    }

    @Override // uk.co.deanwild.materialshowcaseview.i
    public int b() {
        if (this.f6642b != null) {
            return (this.f6642b.getMeasuredHeight() > this.f6642b.getMeasuredWidth() ? this.f6642b.getMeasuredHeight() / 2 : this.f6642b.getMeasuredWidth() / 2) + 10;
        }
        return 200;
    }
}
