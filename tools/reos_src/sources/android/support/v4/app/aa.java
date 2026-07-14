package android.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class aa extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f543a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.support.v4.h.j<a> f544b = new android.support.v4.h.j<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final android.support.v4.h.j<a> f545c = new android.support.v4.h.j<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f548f;
    boolean g;
    private s h;

    final class a implements android.support.v4.b.i.a<Object>, android.support.v4.b.i.b<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        z.a<Object> f551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        android.support.v4.b.i<Object> f552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f554f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;

        public a(int i, Bundle bundle, z.a<Object> aVar) {
            this.f549a = i;
            this.f550b = bundle;
            this.f551c = aVar;
        }

        void a() {
            if (this.i && this.j) {
                this.h = true;
                return;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            if (aa.f543a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f552d == null && this.f551c != null) {
                this.f552d = this.f551c.onCreateLoader(this.f549a, this.f550b);
            }
            if (this.f552d != null) {
                if (this.f552d.getClass().isMemberClass() && !Modifier.isStatic(this.f552d.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f552d);
                }
                if (!this.m) {
                    this.f552d.registerListener(this.f549a, this);
                    this.f552d.registerOnLoadCanceledListener(this);
                    this.m = true;
                }
                this.f552d.startLoading();
            }
        }

        @Override // android.support.v4.b.i.a
        public void a(android.support.v4.b.i<Object> iVar) {
            if (aa.f543a) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.l) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else {
                if (aa.this.f544b.a(this.f549a) != this) {
                    if (aa.f543a) {
                        Log.v("LoaderManager", "  Ignoring load canceled -- not active");
                        return;
                    }
                    return;
                }
                a aVar = this.n;
                if (aVar != null) {
                    if (aa.f543a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                    }
                    this.n = null;
                    aa.this.f544b.b(this.f549a, null);
                    f();
                    aa.this.a(aVar);
                }
            }
        }

        @Override // android.support.v4.b.i.b
        public void a(android.support.v4.b.i<Object> iVar, Object obj) {
            if (aa.f543a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.l) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                    return;
                }
                return;
            }
            if (aa.this.f544b.a(this.f549a) != this) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- not active");
                    return;
                }
                return;
            }
            a aVar = this.n;
            if (aVar != null) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                }
                this.n = null;
                aa.this.f544b.b(this.f549a, null);
                f();
                aa.this.a(aVar);
                return;
            }
            if (this.g != obj || !this.f553e) {
                this.g = obj;
                this.f553e = true;
                if (this.h) {
                    b(iVar, obj);
                }
            }
            a aVarA = aa.this.f545c.a(this.f549a);
            if (aVarA != null && aVarA != this) {
                aVarA.f554f = false;
                aVarA.f();
                aa.this.f545c.c(this.f549a);
            }
            if (aa.this.h == null || aa.this.a()) {
                return;
            }
            aa.this.h.f671d.f();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f549a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f550b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f551c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f552d);
            if (this.f552d != null) {
                this.f552d.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f553e || this.f554f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f553e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f554f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void b() {
            if (aa.f543a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.f551c = null;
        }

        void b(android.support.v4.b.i<Object> iVar, Object obj) {
            String str;
            if (this.f551c != null) {
                if (aa.this.h != null) {
                    String str2 = aa.this.h.f671d.v;
                    aa.this.h.f671d.v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (aa.f543a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + iVar + ": " + iVar.dataToString(obj));
                    }
                    this.f551c.onLoadFinished(iVar, obj);
                    if (aa.this.h != null) {
                        aa.this.h.f671d.v = str;
                    }
                    this.f554f = true;
                } catch (Throwable th) {
                    if (aa.this.h != null) {
                        aa.this.h.f671d.v = str;
                    }
                    throw th;
                }
            }
        }

        void c() {
            if (this.i) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                if (this.h != this.j && !this.h) {
                    e();
                }
            }
            if (this.h && this.f553e && !this.k) {
                b(this.f552d, this.g);
            }
        }

        void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.f553e) {
                    b(this.f552d, this.g);
                }
            }
        }

        void e() {
            if (aa.f543a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (this.i || this.f552d == null || !this.m) {
                return;
            }
            this.m = false;
            this.f552d.unregisterListener(this);
            this.f552d.unregisterOnLoadCanceledListener(this);
            this.f552d.stopLoading();
        }

        void f() {
            String str;
            if (aa.f543a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f554f;
            this.f554f = false;
            if (this.f551c != null && this.f552d != null && this.f553e && z) {
                if (aa.f543a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (aa.this.h != null) {
                    String str2 = aa.this.h.f671d.v;
                    aa.this.h.f671d.v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f551c.onLoaderReset(this.f552d);
                    if (aa.this.h != null) {
                        aa.this.h.f671d.v = str;
                    }
                } catch (Throwable th) {
                    if (aa.this.h != null) {
                        aa.this.h.f671d.v = str;
                    }
                    throw th;
                }
            }
            this.f551c = null;
            this.g = null;
            this.f553e = false;
            if (this.f552d != null) {
                if (this.m) {
                    this.m = false;
                    this.f552d.unregisterListener(this);
                    this.f552d.unregisterOnLoadCanceledListener(this);
                }
                this.f552d.reset();
            }
            if (this.n != null) {
                this.n.f();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f549a);
            sb.append(" : ");
            android.support.v4.h.c.a(this.f552d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    aa(String str, s sVar, boolean z) {
        this.f546d = str;
        this.h = sVar;
        this.f547e = z;
    }

    private a b(int i, Bundle bundle, z.a<Object> aVar) {
        a aVar2 = new a(i, bundle, aVar);
        aVar2.f552d = aVar.onCreateLoader(i, bundle);
        return aVar2;
    }

    private a c(int i, Bundle bundle, z.a<Object> aVar) {
        try {
            this.g = true;
            a aVarB = b(i, bundle, aVar);
            a(aVarB);
            return aVarB;
        } finally {
            this.g = false;
        }
    }

    @Override // android.support.v4.app.z
    public <D> android.support.v4.b.i<D> a(int i, Bundle bundle, z.a<D> aVar) {
        if (this.g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVarA = this.f544b.a(i);
        if (f543a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarA == null) {
            aVarA = c(i, bundle, aVar);
            if (f543a) {
                Log.v("LoaderManager", "  Created new loader " + aVarA);
            }
        } else {
            if (f543a) {
                Log.v("LoaderManager", "  Re-using existing loader " + aVarA);
            }
            aVarA.f551c = aVar;
        }
        if (aVarA.f553e && this.f547e) {
            aVarA.b(aVarA.f552d, aVarA.g);
        }
        return (android.support.v4.b.i<D>) aVarA.f552d;
    }

    void a(a aVar) {
        this.f544b.b(aVar.f549a, aVar);
        if (this.f547e) {
            aVar.a();
        }
    }

    void a(s sVar) {
        this.h = sVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f544b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f544b.b(); i++) {
                a aVarE = this.f544b.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f544b.d(i));
                printWriter.print(": ");
                printWriter.println(aVarE.toString());
                aVarE.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f545c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f545c.b(); i2++) {
                a aVarE2 = this.f545c.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f545c.d(i2));
                printWriter.print(": ");
                printWriter.println(aVarE2.toString());
                aVarE2.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.support.v4.app.z
    public boolean a() {
        int iB = this.f544b.b();
        boolean z = false;
        for (int i = 0; i < iB; i++) {
            a aVarE = this.f544b.e(i);
            z |= aVarE.h && !aVarE.f554f;
        }
        return z;
    }

    void b() {
        if (f543a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f547e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.f547e = true;
            for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
                this.f544b.e(iB).a();
            }
        }
    }

    void c() {
        if (f543a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f547e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
                this.f544b.e(iB).e();
            }
            this.f547e = false;
        }
    }

    void d() {
        if (f543a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f547e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
        } else {
            this.f548f = true;
            this.f547e = false;
            for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
                this.f544b.e(iB).b();
            }
        }
    }

    void e() {
        if (this.f548f) {
            if (f543a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f548f = false;
            for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
                this.f544b.e(iB).c();
            }
        }
    }

    void f() {
        for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
            this.f544b.e(iB).k = true;
        }
    }

    void g() {
        for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
            this.f544b.e(iB).d();
        }
    }

    void h() {
        if (!this.f548f) {
            if (f543a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int iB = this.f544b.b() - 1; iB >= 0; iB--) {
                this.f544b.e(iB).f();
            }
            this.f544b.c();
        }
        if (f543a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int iB2 = this.f545c.b() - 1; iB2 >= 0; iB2--) {
            this.f545c.e(iB2).f();
        }
        this.f545c.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.h.c.a(this.h, sb);
        sb.append("}}");
        return sb.toString();
    }
}
