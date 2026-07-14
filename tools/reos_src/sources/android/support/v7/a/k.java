package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
class k extends j {
    private static r r;
    private int s;
    private boolean t;
    private boolean u;

    class a extends i.b {
        a(Window.Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            android.support.v7.view.f.a aVar = new android.support.v7.view.f.a(k.this.f1105a, callback);
            android.support.v7.view.b bVarB = k.this.b(aVar);
            if (bVarB != null) {
                return aVar.b(bVarB);
            }
            return null;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return k.this.o() ? a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    k(Context context, Window window, g gVar) {
        super(context, window, gVar);
        this.s = -100;
        this.u = true;
    }

    private boolean e(int i) {
        Resources resources = this.f1105a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private r t() {
        if (r == null) {
            r = new r(this.f1105a.getApplicationContext());
        }
        return r;
    }

    @Override // android.support.v7.a.i
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // android.support.v7.a.m, android.support.v7.a.h
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null || this.s != -100) {
            return;
        }
        this.s = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // android.support.v7.a.i, android.support.v7.a.h
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.s);
        }
    }

    int d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return t().a() ? 2 : 1;
            default:
                return i;
        }
    }

    @Override // android.support.v7.a.i, android.support.v7.a.h
    public boolean i() {
        this.t = true;
        int iD = d(this.s == -100 ? j() : this.s);
        if (iD != -1) {
            return e(iD);
        }
        return false;
    }

    @Override // android.support.v7.a.i
    public boolean o() {
        return this.u;
    }
}
