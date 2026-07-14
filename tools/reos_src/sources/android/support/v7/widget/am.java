package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class am extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<WeakReference<am>> f1740a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources f1741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources.Theme f1742c;

    private am(Context context) {
        super(context);
        if (!ar.a()) {
            this.f1742c = null;
        } else {
            this.f1742c = getResources().newTheme();
            this.f1742c.setTo(context.getTheme());
        }
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        int size = f1740a.size();
        for (int i = 0; i < size; i++) {
            WeakReference<am> weakReference = f1740a.get(i);
            am amVar = weakReference != null ? weakReference.get() : null;
            if (amVar != null && amVar.getBaseContext() == context) {
                return amVar;
            }
        }
        am amVar2 = new am(context);
        f1740a.add(new WeakReference<>(amVar2));
        return amVar2;
    }

    private static boolean b(Context context) {
        if ((context instanceof am) || (context.getResources() instanceof ao) || (context.getResources() instanceof ar)) {
            return false;
        }
        return !android.support.v7.a.h.k() || Build.VERSION.SDK_INT <= 20;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1741b == null) {
            this.f1741b = this.f1742c == null ? new ao(this, super.getResources()) : new ar(this, super.getResources());
        }
        return this.f1741b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.f1742c == null ? super.getTheme() : this.f1742c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1742c == null) {
            super.setTheme(i);
        } else {
            this.f1742c.applyStyle(i, true);
        }
    }
}
