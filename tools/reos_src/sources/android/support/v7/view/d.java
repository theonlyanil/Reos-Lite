package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f1193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f1194c;

    public d(Context context, int i) {
        super(context);
        this.f1192a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1193b = theme;
    }

    private void b() {
        boolean z = this.f1193b == null;
        if (z) {
            this.f1193b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1193b.setTo(theme);
            }
        }
        a(this.f1193b, this.f1192a, z);
    }

    public int a() {
        return this.f1192a;
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1194c == null) {
            this.f1194c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1194c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.f1193b != null) {
            return this.f1193b;
        }
        if (this.f1192a == 0) {
            this.f1192a = android.support.v7.b.a.j.Theme_AppCompat_Light;
        }
        b();
        return this.f1193b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1192a != i) {
            this.f1192a = i;
            b();
        }
    }
}
