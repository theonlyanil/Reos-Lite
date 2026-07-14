package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
class g implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f1278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f1279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.support.v7.a.e f1280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l.a f1281d;

    public g(f fVar) {
        this.f1279b = fVar;
    }

    public void a() {
        if (this.f1280c != null) {
            this.f1280c.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        f fVar = this.f1279b;
        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(fVar.e());
        this.f1278a = new e(aVar.a(), android.support.v7.b.a.h.abc_list_menu_item_layout);
        this.f1278a.a(this);
        this.f1279b.a(this.f1278a);
        aVar.a(this.f1278a.d(), this);
        View viewO = fVar.o();
        if (viewO != null) {
            aVar.a(viewO);
        } else {
            aVar.a(fVar.n()).a(fVar.m());
        }
        aVar.a(this);
        this.f1280c = aVar.b();
        this.f1280c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1280c.getWindow().getAttributes();
        attributes.type = Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1280c.show();
    }

    @Override // android.support.v7.view.menu.l.a
    public void a(f fVar, boolean z) {
        if (z || fVar == this.f1279b) {
            a();
        }
        if (this.f1281d != null) {
            this.f1281d.a(fVar, z);
        }
    }

    @Override // android.support.v7.view.menu.l.a
    public boolean a(f fVar) {
        if (this.f1281d != null) {
            return this.f1281d.a(fVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1279b.a((h) this.f1278a.d().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1278a.a(this.f1279b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1280c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1280c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1279b.b(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1279b.performShortcut(i, keyEvent, 0);
    }
}
