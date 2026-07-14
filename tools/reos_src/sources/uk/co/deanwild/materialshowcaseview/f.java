package uk.co.deanwild.materialshowcaseview;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6632a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6633b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f6635d;

    public f(Context context, String str) {
        this.f6634c = null;
        this.f6635d = context;
        this.f6634c = str;
    }

    static void a(Context context, String str) {
        context.getSharedPreferences("material_showcaseview_prefs", 0).edit().putInt("status_" + str, f6632a).apply();
    }

    void a(int i) {
        this.f6635d.getSharedPreferences("material_showcaseview_prefs", 0).edit().putInt("status_" + this.f6634c, i).apply();
    }

    boolean a() {
        return c() == f6633b;
    }

    void b() {
        a(f6633b);
    }

    int c() {
        return this.f6635d.getSharedPreferences("material_showcaseview_prefs", 0).getInt("status_" + this.f6634c, f6632a);
    }

    public void d() {
        a(this.f6635d, this.f6634c);
    }

    public void e() {
        this.f6635d = null;
    }
}
