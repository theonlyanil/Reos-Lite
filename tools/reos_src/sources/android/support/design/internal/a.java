package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class a extends f {
    public a(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.f, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        c cVar = new c(e(), this, hVar);
        hVar.a(cVar);
        return cVar;
    }
}
