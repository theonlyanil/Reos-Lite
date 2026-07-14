package android.support.v4.a;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f520a;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f520a = new d();
        } else {
            f520a = new c();
        }
    }

    public static void a(View view) {
        f520a.a(view);
    }
}
