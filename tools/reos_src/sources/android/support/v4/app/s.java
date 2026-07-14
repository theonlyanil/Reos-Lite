package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class s<E> extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Context f669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final u f671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.support.v4.h.i<String, z> f673f;
    private boolean g;
    private aa h;
    private boolean i;
    private boolean j;

    s(Activity activity, Context context, Handler handler, int i) {
        this.f671d = new u();
        this.f668a = activity;
        this.f669b = context;
        this.f672e = handler;
        this.f670c = i;
    }

    s(p pVar) {
        this(pVar, pVar, pVar.mHandler, 0);
    }

    aa a(String str, boolean z, boolean z2) {
        if (this.f673f == null) {
            this.f673f = new android.support.v4.h.i<>();
        }
        aa aaVar = (aa) this.f673f.get(str);
        if (aaVar != null) {
            aaVar.a(this);
            return aaVar;
        }
        if (!z2) {
            return aaVar;
        }
        aa aaVar2 = new aa(str, this, z);
        this.f673f.put(str, aaVar2);
        return aaVar2;
    }

    @Override // android.support.v4.app.q
    public View a(int i) {
        return null;
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f669b.startActivity(intent);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    void a(android.support.v4.h.i<String, z> iVar) {
        this.f673f = iVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void a(boolean z) {
        this.g = z;
        if (this.h != null && this.j) {
            this.j = false;
            if (z) {
                this.h.d();
            } else {
                this.h.c();
            }
        }
    }

    @Override // android.support.v4.app.q
    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.f669b.getSystemService("layout_inflater");
    }

    void b(Fragment fragment) {
    }

    void b(String str) {
        aa aaVar;
        if (this.f673f == null || (aaVar = (aa) this.f673f.get(str)) == null || aaVar.f548f) {
            return;
        }
        aaVar.h();
        this.f673f.remove(str);
    }

    void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            this.h.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return this.f670c;
    }

    public abstract E g();

    Activity h() {
        return this.f668a;
    }

    Context i() {
        return this.f669b;
    }

    Handler j() {
        return this.f672e;
    }

    u k() {
        return this.f671d;
    }

    aa l() {
        if (this.h != null) {
            return this.h;
        }
        this.i = true;
        this.h = a("(root)", this.j, true);
        return this.h;
    }

    boolean m() {
        return this.g;
    }

    void n() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.h != null) {
            this.h.b();
        } else if (!this.i) {
            this.h = a("(root)", this.j, false);
            if (this.h != null && !this.h.f547e) {
                this.h.b();
            }
        }
        this.i = true;
    }

    void o() {
        if (this.h == null) {
            return;
        }
        this.h.h();
    }

    void p() {
        if (this.f673f != null) {
            int size = this.f673f.size();
            aa[] aaVarArr = new aa[size];
            for (int i = size - 1; i >= 0; i--) {
                aaVarArr[i] = (aa) this.f673f.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                aa aaVar = aaVarArr[i2];
                aaVar.e();
                aaVar.g();
            }
        }
    }

    android.support.v4.h.i<String, z> q() {
        boolean z;
        if (this.f673f != null) {
            int size = this.f673f.size();
            aa[] aaVarArr = new aa[size];
            for (int i = size - 1; i >= 0; i--) {
                aaVarArr[i] = (aa) this.f673f.c(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                aa aaVar = aaVarArr[i2];
                if (aaVar.f548f) {
                    z = true;
                } else {
                    aaVar.h();
                    this.f673f.remove(aaVar.f546d);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.f673f;
        }
        return null;
    }
}
