package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.at;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1189a;

    private a(Context context) {
        this.f1189a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int a() {
        return this.f1189a.getResources().getInteger(android.support.v7.b.a.g.abc_max_action_buttons);
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 19 || !at.b(ViewConfiguration.get(this.f1189a));
    }

    public int c() {
        return this.f1189a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.f1189a.getApplicationInfo().targetSdkVersion >= 16 ? this.f1189a.getResources().getBoolean(android.support.v7.b.a.b.abc_action_bar_embed_tabs) : this.f1189a.getResources().getBoolean(android.support.v7.b.a.b.abc_action_bar_embed_tabs_pre_jb);
    }

    public int e() {
        TypedArray typedArrayObtainStyledAttributes = this.f1189a.obtainStyledAttributes(null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.C0029a.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(android.support.v7.b.a.k.ActionBar_height, 0);
        Resources resources = this.f1189a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f1189a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.f1189a.getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_action_bar_stacked_tab_max_width);
    }
}
