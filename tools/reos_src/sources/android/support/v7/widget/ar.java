package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ar extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f1761a;

    public ar(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1761a = new WeakReference<>(context);
    }

    public static boolean a() {
        return android.support.v7.a.h.k() && Build.VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.f1761a.get();
        return context != null ? h.a().a(context, this, i) : super.getDrawable(i);
    }
}
