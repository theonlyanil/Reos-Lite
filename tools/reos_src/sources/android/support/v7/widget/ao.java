package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class ao extends ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f1747a;

    public ao(Context context, Resources resources) {
        super(resources);
        this.f1747a = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.ac, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f1747a.get();
        if (drawable != null && context != null) {
            h.a();
            h.a(context, i, drawable);
        }
        return drawable;
    }
}
