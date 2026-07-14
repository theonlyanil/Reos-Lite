package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f556a;

    public static class a extends aj.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final aj.a.InterfaceC0011a f557d = new aj.a.InterfaceC0011a() { // from class: android.support.v4.app.ag.a.1
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PendingIntent f560c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f561e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ar[] f562f;

        @Override // android.support.v4.app.aj.a
        public int a() {
            return this.f558a;
        }

        @Override // android.support.v4.app.aj.a
        public CharSequence b() {
            return this.f559b;
        }

        @Override // android.support.v4.app.aj.a
        public PendingIntent c() {
            return this.f560c;
        }

        @Override // android.support.v4.app.aj.a
        public Bundle d() {
            return this.f561e;
        }

        @Override // android.support.v4.app.aj.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ar[] f() {
            return this.f562f;
        }
    }

    public static class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Bitmap f563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Bitmap f564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f565c;
    }

    public static class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CharSequence f566a;
    }

    public static class d {
        Notification A;
        public ArrayList<String> C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PendingIntent f570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        PendingIntent f571e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        RemoteViews f572f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        public boolean l;
        public p m;
        public CharSequence n;
        int o;
        int p;
        boolean q;
        String r;
        boolean s;
        String t;
        String w;
        Bundle x;
        boolean k = true;
        public ArrayList<a> u = new ArrayList<>();
        boolean v = false;
        int y = 0;
        int z = 0;
        public Notification B = new Notification();

        public d(Context context) {
            this.f567a = context;
            this.B.when = System.currentTimeMillis();
            this.B.audioStreamType = -1;
            this.j = 0;
            this.C = new ArrayList<>();
        }

        private void a(int i, boolean z) {
            if (z) {
                this.B.flags |= i;
            } else {
                this.B.flags &= i ^ (-1);
            }
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Notification a() {
            return ag.f556a.a(this, b());
        }

        public d a(int i) {
            this.B.icon = i;
            return this;
        }

        public d a(int i, int i2, boolean z) {
            this.o = i;
            this.p = i2;
            this.q = z;
            return this;
        }

        public d a(long j) {
            this.B.when = j;
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f570d = pendingIntent;
            return this;
        }

        public d a(Bitmap bitmap) {
            this.g = bitmap;
            return this;
        }

        public d a(Uri uri) {
            this.B.sound = uri;
            this.B.audioStreamType = -1;
            return this;
        }

        public d a(CharSequence charSequence) {
            this.f568b = d(charSequence);
            return this;
        }

        public d a(boolean z) {
            a(2, z);
            return this;
        }

        public d b(int i) {
            this.B.defaults = i;
            if ((i & 4) != 0) {
                this.B.flags |= 1;
            }
            return this;
        }

        public d b(PendingIntent pendingIntent) {
            this.B.deleteIntent = pendingIntent;
            return this;
        }

        public d b(CharSequence charSequence) {
            this.f569c = d(charSequence);
            return this;
        }

        public d b(boolean z) {
            a(8, z);
            return this;
        }

        protected e b() {
            return new e();
        }

        public d c(int i) {
            this.y = i;
            return this;
        }

        public d c(CharSequence charSequence) {
            this.B.tickerText = d(charSequence);
            return this;
        }

        public d c(boolean z) {
            a(16, z);
            return this;
        }
    }

    protected static class e {
        protected e() {
        }

        public Notification a(d dVar, af afVar) {
            return afVar.b();
        }
    }

    public static class f extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<CharSequence> f573a = new ArrayList<>();
    }

    interface g {
        Notification a(d dVar, e eVar);

        Bundle a(Notification notification);
    }

    static class h extends o {
        h() {
        }

        @Override // android.support.v4.app.ag.o, android.support.v4.app.ag.n, android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            ah.a aVar = new ah.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            ag.b(aVar, dVar.u);
            ag.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    static class i extends h {
        i() {
        }

        @Override // android.support.v4.app.ag.h, android.support.v4.app.ag.o, android.support.v4.app.ag.n, android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            ai.a aVar = new ai.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.w, dVar.C, dVar.x, dVar.y, dVar.z, dVar.A, dVar.r, dVar.s, dVar.t);
            ag.b(aVar, dVar.u);
            ag.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    static class j implements g {
        j() {
        }

        @Override // android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            Notification notificationA = aj.a(dVar.B, dVar.f567a, dVar.f568b, dVar.f569c, dVar.f570d);
            if (dVar.j > 0) {
                notificationA.flags |= 128;
            }
            return notificationA;
        }

        @Override // android.support.v4.app.ag.g
        public Bundle a(Notification notification) {
            return null;
        }
    }

    static class k extends j {
        k() {
        }

        @Override // android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            Notification notificationA = ak.a(dVar.B, dVar.f567a, dVar.f568b, dVar.f569c, dVar.f570d, dVar.f571e);
            if (dVar.j > 0) {
                notificationA.flags |= 128;
            }
            return notificationA;
        }
    }

    static class l extends j {
        l() {
        }

        @Override // android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            return al.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g);
        }
    }

    static class m extends j {
        m() {
        }

        @Override // android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            return eVar.a(dVar, new am.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g, dVar.o, dVar.p, dVar.q));
        }
    }

    static class n extends j {
        n() {
        }

        @Override // android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            an.a aVar = new an.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.l, dVar.j, dVar.n, dVar.v, dVar.x, dVar.r, dVar.s, dVar.t);
            ag.b(aVar, dVar.u);
            ag.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }

        @Override // android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Bundle a(Notification notification) {
            return an.a(notification);
        }
    }

    static class o extends n {
        o() {
        }

        @Override // android.support.v4.app.ag.n, android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Notification a(d dVar, e eVar) {
            ao.a aVar = new ao.a(dVar.f567a, dVar.B, dVar.f568b, dVar.f569c, dVar.h, dVar.f572f, dVar.i, dVar.f570d, dVar.f571e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            ag.b(aVar, dVar.u);
            ag.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }

        @Override // android.support.v4.app.ag.n, android.support.v4.app.ag.j, android.support.v4.app.ag.g
        public Bundle a(Notification notification) {
            return ao.a(notification);
        }
    }

    public static abstract class p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CharSequence f574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f575e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f576f = false;
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f556a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            f556a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            f556a = new o();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            f556a = new n();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            f556a = new m();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            f556a = new l();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f556a = new k();
        } else {
            f556a = new j();
        }
    }

    public static Bundle a(Notification notification) {
        return f556a.a(notification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ae aeVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            aeVar.a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(af afVar, p pVar) {
        if (pVar != null) {
            if (pVar instanceof c) {
                c cVar = (c) pVar;
                an.a(afVar, cVar.f574d, cVar.f576f, cVar.f575e, cVar.f566a);
            } else if (pVar instanceof f) {
                f fVar = (f) pVar;
                an.a(afVar, fVar.f574d, fVar.f576f, fVar.f575e, fVar.f573a);
            } else if (pVar instanceof b) {
                b bVar = (b) pVar;
                an.a(afVar, bVar.f574d, bVar.f576f, bVar.f575e, bVar.f563a, bVar.f564b, bVar.f565c);
            }
        }
    }
}
