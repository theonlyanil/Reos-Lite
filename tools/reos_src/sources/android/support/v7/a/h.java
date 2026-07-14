package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1103a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1104b = false;

    h() {
    }

    public static h a(Activity activity, g gVar) {
        return a(activity, activity.getWindow(), gVar);
    }

    public static h a(Dialog dialog, g gVar) {
        return a(dialog.getContext(), dialog.getWindow(), gVar);
    }

    private static h a(Context context, Window window, g gVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return new l(context, window, gVar);
        }
        if (i >= 14) {
            return new k(context, window, gVar);
        }
        return i >= 11 ? new j(context, window, gVar) : new m(context, window, gVar);
    }

    public static void a(boolean z) {
        f1104b = z;
    }

    public static int j() {
        return f1103a;
    }

    public static boolean k() {
        return f1104b;
    }

    public abstract a a();

    public abstract View a(int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(Bundle bundle);

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract b.a g();

    public abstract void h();

    public abstract boolean i();
}
