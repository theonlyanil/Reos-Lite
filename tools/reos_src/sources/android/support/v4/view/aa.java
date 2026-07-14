package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f883b;

    public aa(ViewGroup viewGroup) {
        this.f882a = viewGroup;
    }

    public int a() {
        return this.f883b;
    }

    public void a(View view) {
        this.f883b = 0;
    }

    public void a(View view, View view2, int i) {
        this.f883b = i;
    }
}
