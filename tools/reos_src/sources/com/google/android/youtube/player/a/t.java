package com.google.android.youtube.player.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class t<T extends IInterface> implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Handler f5330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f5332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<v.a> f5333d;
    private ArrayList<v.b> g;
    private ServiceConnection j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<v.a> f5334e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5335f = false;
    private boolean h = false;
    private final ArrayList<b<?>> i = new ArrayList<>();
    private boolean k = false;

    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 3) {
                t.this.a((com.google.android.youtube.player.c) message.obj);
                return;
            }
            if (message.what == 4) {
                synchronized (t.this.f5333d) {
                    if (t.this.k && t.this.f() && t.this.f5333d.contains(message.obj)) {
                        ((v.a) message.obj).a();
                    }
                }
                return;
            }
            if (message.what != 2 || t.this.f()) {
                if (message.what == 2 || message.what == 1) {
                    ((b) message.obj).a();
                }
            }
        }
    }

    protected abstract class b<TListener> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TListener f5339b;

        public b(TListener tlistener) {
            this.f5339b = tlistener;
            synchronized (t.this.i) {
                t.this.i.add(this);
            }
        }

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f5339b;
            }
            a(tlistener);
        }

        protected abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.f5339b = null;
            }
        }
    }

    protected final class c extends b<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.youtube.player.c f5340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IBinder f5341c;

        public c(String str, IBinder iBinder) {
            super(true);
            this.f5340b = t.b(str);
            this.f5341c = iBinder;
        }

        @Override // com.google.android.youtube.player.a.t.b
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                switch (this.f5340b) {
                    case SUCCESS:
                        try {
                            if (t.this.b().equals(this.f5341c.getInterfaceDescriptor())) {
                                t.this.f5332c = t.this.a(this.f5341c);
                                if (t.this.f5332c != null) {
                                    t.this.g();
                                }
                            }
                            break;
                        } catch (RemoteException e2) {
                        }
                        t.this.a();
                        t.this.a(com.google.android.youtube.player.c.INTERNAL_ERROR);
                        break;
                    default:
                        t.this.a(this.f5340b);
                        break;
                }
            }
        }
    }

    protected final class d extends f.a {
        protected d() {
        }

        @Override // com.google.android.youtube.player.a.f
        public final void a(String str, IBinder iBinder) {
            t.this.f5330a.sendMessage(t.this.f5330a.obtainMessage(1, new c(str, iBinder)));
        }
    }

    final class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            t.this.b(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            t.this.f5332c = null;
            t.this.h();
        }
    }

    protected t(Context context, v.a aVar, v.b bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.f5331b = (Context) com.google.android.youtube.player.a.c.a(context);
        this.f5333d = new ArrayList<>();
        this.f5333d.add((v.a) com.google.android.youtube.player.a.c.a(aVar));
        this.g = new ArrayList<>();
        this.g.add((v.b) com.google.android.youtube.player.a.c.a(bVar));
        this.f5330a = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.j != null) {
            try {
                this.f5331b.unbindService(this.j);
            } catch (IllegalArgumentException e2) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e2);
            }
        }
        this.f5332c = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.android.youtube.player.c b(String str) {
        try {
            return com.google.android.youtube.player.c.valueOf(str);
        } catch (IllegalArgumentException e2) {
            return com.google.android.youtube.player.c.UNKNOWN_ERROR;
        } catch (NullPointerException e3) {
            return com.google.android.youtube.player.c.UNKNOWN_ERROR;
        }
    }

    protected abstract T a(IBinder iBinder);

    protected abstract void a(l lVar, d dVar) throws RemoteException;

    protected final void a(com.google.android.youtube.player.c cVar) {
        this.f5330a.removeMessages(4);
        synchronized (this.g) {
            this.h = true;
            ArrayList<v.b> arrayList = this.g;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!this.k) {
                    return;
                }
                if (this.g.contains(arrayList.get(i))) {
                    arrayList.get(i).a(cVar);
                }
            }
            this.h = false;
        }
    }

    protected abstract String b();

    protected final void b(IBinder iBinder) {
        try {
            a(l.a.a(iBinder), new d());
        } catch (RemoteException e2) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract String c();

    @Override // com.google.android.youtube.player.a.v
    public void d() {
        h();
        this.k = false;
        synchronized (this.i) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                this.i.get(i).b();
            }
            this.i.clear();
        }
        a();
    }

    @Override // com.google.android.youtube.player.a.v
    public final void e() {
        this.k = true;
        com.google.android.youtube.player.c cVarA = com.google.android.youtube.player.a.a(this.f5331b);
        if (cVarA != com.google.android.youtube.player.c.SUCCESS) {
            this.f5330a.sendMessage(this.f5330a.obtainMessage(3, cVarA));
            return;
        }
        Intent intent = new Intent(c()).setPackage(ab.a(this.f5331b));
        if (this.j != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            a();
        }
        this.j = new e();
        if (this.f5331b.bindService(intent, this.j, 129)) {
            return;
        }
        this.f5330a.sendMessage(this.f5330a.obtainMessage(3, com.google.android.youtube.player.c.ERROR_CONNECTING_TO_SERVICE));
    }

    public final boolean f() {
        return this.f5332c != null;
    }

    protected final void g() {
        synchronized (this.f5333d) {
            com.google.android.youtube.player.a.c.a(!this.f5335f);
            this.f5330a.removeMessages(4);
            this.f5335f = true;
            com.google.android.youtube.player.a.c.a(this.f5334e.size() == 0);
            ArrayList<v.a> arrayList = this.f5333d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k && f(); i++) {
                if (!this.f5334e.contains(arrayList.get(i))) {
                    arrayList.get(i).a();
                }
            }
            this.f5334e.clear();
            this.f5335f = false;
        }
    }

    protected final void h() {
        this.f5330a.removeMessages(4);
        synchronized (this.f5333d) {
            this.f5335f = true;
            ArrayList<v.a> arrayList = this.f5333d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k; i++) {
                if (this.f5333d.contains(arrayList.get(i))) {
                    arrayList.get(i).b();
                }
            }
            this.f5335f = false;
        }
    }

    protected final void i() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T j() {
        i();
        return this.f5332c;
    }
}
