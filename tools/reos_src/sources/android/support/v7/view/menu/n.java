package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static Menu a(Context context, android.support.v4.d.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new o(context, aVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem a(Context context, android.support.v4.d.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new j(context, bVar);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new i(context, bVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu a(Context context, android.support.v4.d.a.c cVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new q(context, cVar);
        }
        throw new UnsupportedOperationException();
    }
}
