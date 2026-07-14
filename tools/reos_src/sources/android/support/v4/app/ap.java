package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f591a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f593c;
    private static h h;
    private static final b i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NotificationManager f596f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f592b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Set<String> f594d = new HashSet();
    private static final Object g = new Object();

    private static class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f600d = false;

        public a(String str, int i, String str2) {
            this.f597a = str;
            this.f598b = i;
            this.f599c = str2;
        }

        @Override // android.support.v4.app.ap.i
        public void a(y yVar) throws RemoteException {
            if (this.f600d) {
                yVar.a(this.f597a);
            } else {
                yVar.a(this.f597a, this.f598b, this.f599c);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:").append(this.f597a);
            sb.append(", id:").append(this.f598b);
            sb.append(", tag:").append(this.f599c);
            sb.append(", all:").append(this.f600d);
            sb.append("]");
            return sb.toString();
        }
    }

    interface b {
        int a();

        void a(NotificationManager notificationManager, String str, int i);

        void a(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    static class c implements b {
        c() {
        }

        @Override // android.support.v4.app.ap.b
        public int a() {
            return 1;
        }

        @Override // android.support.v4.app.ap.b
        public void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        @Override // android.support.v4.app.ap.b
        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.app.ap.c, android.support.v4.app.ap.b
        public void a(NotificationManager notificationManager, String str, int i) {
            aq.a(notificationManager, str, i);
        }

        @Override // android.support.v4.app.ap.c, android.support.v4.app.ap.b
        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            aq.a(notificationManager, str, i, notification);
        }
    }

    static class e extends d {
        e() {
        }

        @Override // android.support.v4.app.ap.c, android.support.v4.app.ap.b
        public int a() {
            return 33;
        }
    }

    private static class f implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Notification f604d;

        public f(String str, int i, String str2, Notification notification) {
            this.f601a = str;
            this.f602b = i;
            this.f603c = str2;
            this.f604d = notification;
        }

        @Override // android.support.v4.app.ap.i
        public void a(y yVar) throws RemoteException {
            yVar.a(this.f601a, this.f602b, this.f603c, this.f604d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(this.f601a);
            sb.append(", id:").append(this.f602b);
            sb.append(", tag:").append(this.f603c);
            sb.append("]");
            return sb.toString();
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f606b;

        public g(ComponentName componentName, IBinder iBinder) {
            this.f605a = componentName;
            this.f606b = iBinder;
        }
    }

    private static class h implements ServiceConnection, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f607a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<ComponentName, a> f610d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Set<String> f611e = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HandlerThread f608b = new HandlerThread("NotificationManagerCompat");

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f612a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public y f614c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f613b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public LinkedList<i> f615d = new LinkedList<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f616e = 0;

            public a(ComponentName componentName) {
                this.f612a = componentName;
            }
        }

        public h(Context context) {
            this.f607a = context;
            this.f608b.start();
            this.f609c = new Handler(this.f608b.getLooper(), this);
        }

        private void a() {
            Set<String> setB = ap.b(this.f607a);
            if (setB.equals(this.f611e)) {
                return;
            }
            this.f611e = setB;
            List<ResolveInfo> listQueryIntentServices = this.f607a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setB.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f610d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f610d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f610d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        private void a(ComponentName componentName) {
            a aVar = this.f610d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f610d.get(componentName);
            if (aVar != null) {
                aVar.f614c = y.a.a(iBinder);
                aVar.f616e = 0;
                d(aVar);
            }
        }

        private boolean a(a aVar) {
            if (aVar.f613b) {
                return true;
            }
            aVar.f613b = this.f607a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f612a), this, ap.f591a);
            if (aVar.f613b) {
                aVar.f616e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f612a);
                this.f607a.unbindService(this);
            }
            return aVar.f613b;
        }

        private void b(ComponentName componentName) {
            a aVar = this.f610d.get(componentName);
            if (aVar != null) {
                d(aVar);
            }
        }

        private void b(a aVar) {
            if (aVar.f613b) {
                this.f607a.unbindService(this);
                aVar.f613b = false;
            }
            aVar.f614c = null;
        }

        private void b(i iVar) {
            a();
            for (a aVar : this.f610d.values()) {
                aVar.f615d.add(iVar);
                d(aVar);
            }
        }

        private void c(a aVar) {
            if (this.f609c.hasMessages(3, aVar.f612a)) {
                return;
            }
            aVar.f616e++;
            if (aVar.f616e > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.f615d.size() + " tasks to " + aVar.f612a + " after " + aVar.f616e + " retries");
                aVar.f615d.clear();
                return;
            }
            int i = (1 << (aVar.f616e - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
            }
            this.f609c.sendMessageDelayed(this.f609c.obtainMessage(3, aVar.f612a), i);
        }

        private void d(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f612a + ", " + aVar.f615d.size() + " queued tasks");
            }
            if (aVar.f615d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f614c == null) {
                c(aVar);
                return;
            }
            while (true) {
                i iVarPeek = aVar.f615d.peek();
                if (iVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + iVarPeek);
                    }
                    iVarPeek.a(aVar.f614c);
                    aVar.f615d.remove();
                } catch (DeadObjectException e2) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f612a);
                    }
                } catch (RemoteException e3) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f612a, e3);
                }
            }
            if (aVar.f615d.isEmpty()) {
                return;
            }
            c(aVar);
        }

        public void a(i iVar) {
            this.f609c.obtainMessage(0, iVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    b((i) message.obj);
                    return true;
                case 1:
                    g gVar = (g) message.obj;
                    a(gVar.f605a, gVar.f606b);
                    return true;
                case 2:
                    a((ComponentName) message.obj);
                    return true;
                case 3:
                    b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f609c.obtainMessage(1, new g(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f609c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface i {
        void a(y yVar) throws RemoteException;
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            i = new e();
        } else if (Build.VERSION.SDK_INT >= 5) {
            i = new d();
        } else {
            i = new c();
        }
        f591a = i.a();
    }

    private ap(Context context) {
        this.f595e = context;
        this.f596f = (NotificationManager) this.f595e.getSystemService("notification");
    }

    public static ap a(Context context) {
        return new ap(context);
    }

    private void a(i iVar) {
        synchronized (g) {
            if (h == null) {
                h = new h(this.f595e.getApplicationContext());
            }
        }
        h.a(iVar);
    }

    private static boolean a(Notification notification) {
        Bundle bundleA = ag.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public static Set<String> b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (string != null && !string.equals(f593c)) {
            String[] strArrSplit = string.split(":");
            HashSet hashSet = new HashSet(strArrSplit.length);
            for (String str : strArrSplit) {
                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                if (componentNameUnflattenFromString != null) {
                    hashSet.add(componentNameUnflattenFromString.getPackageName());
                }
            }
            synchronized (f592b) {
                f594d = hashSet;
                f593c = string;
            }
        }
        return f594d;
    }

    public void a(int i2) {
        a((String) null, i2);
    }

    public void a(int i2, Notification notification) {
        a(null, i2, notification);
    }

    public void a(String str, int i2) {
        i.a(this.f596f, str, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new a(this.f595e.getPackageName(), i2, str));
        }
    }

    public void a(String str, int i2, Notification notification) {
        if (!a(notification)) {
            i.a(this.f596f, str, i2, notification);
        } else {
            a(new f(this.f595e.getPackageName(), i2, str, notification));
            i.a(this.f596f, str, i2);
        }
    }
}
