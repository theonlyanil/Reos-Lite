package android.support.v7.a;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
class l extends k {
    private final UiModeManager r;

    class a extends k.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.a.k.a, android.support.v7.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (l.this.o()) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    l(Context context, Window window, g gVar) {
        super(context, window, gVar);
        this.r = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // android.support.v7.a.k, android.support.v7.a.i
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // android.support.v7.a.k
    int d(int i) {
        if (i == 0 && this.r.getNightMode() == 0) {
            return -1;
        }
        return super.d(i);
    }
}
