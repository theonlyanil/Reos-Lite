package b.a.a;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile c f1890b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<m>> f1893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f1894f;
    private final Map<Class<?>, Object> g;
    private final ThreadLocal<a> h;
    private final f i;
    private final b j;
    private final b.a.a.a k;
    private final l l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1889a = "Event";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f1891c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f1892d = new HashMap();

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<Object> f1897a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        m f1900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f1901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1902f;

        a() {
        }
    }

    public c() {
        this(f1891c);
    }

    c(d dVar) {
        this.h = new ThreadLocal<a>() { // from class: b.a.a.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a initialValue() {
                return new a();
            }
        };
        this.f1893e = new HashMap();
        this.f1894f = new HashMap();
        this.g = new ConcurrentHashMap();
        this.i = new f(this, Looper.getMainLooper(), 10);
        this.j = new b(this);
        this.k = new b.a.a.a(this);
        this.l = new l(dVar.h);
        this.o = dVar.f1903a;
        this.p = dVar.f1904b;
        this.q = dVar.f1905c;
        this.r = dVar.f1906d;
        this.n = dVar.f1907e;
        this.s = dVar.f1908f;
        this.m = dVar.g;
    }

    public static c a() {
        if (f1890b == null) {
            synchronized (c.class) {
                if (f1890b == null) {
                    f1890b = new c();
                }
            }
        }
        return f1890b;
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (f1892d) {
            arrayList = f1892d.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                f1892d.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    private void a(m mVar, Object obj, Throwable th) {
        if (obj instanceof j) {
            if (this.o) {
                Log.e(f1889a, "SubscriberExceptionEvent subscriber " + mVar.f1931a.getClass() + " threw an exception", th);
                j jVar = (j) obj;
                Log.e(f1889a, "Initial event " + jVar.f1923c + " caused exception in " + jVar.f1924d, jVar.f1922b);
                return;
            }
            return;
        }
        if (this.n) {
            throw new e("Invoking subscriber failed", th);
        }
        if (this.o) {
            Log.e(f1889a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + mVar.f1931a.getClass(), th);
        }
        if (this.q) {
            b(new j(this, th, obj, mVar.f1931a));
        }
    }

    private void a(m mVar, Object obj, boolean z) {
        switch (mVar.f1932b.f1926b) {
            case PostThread:
                a(mVar, obj);
                return;
            case MainThread:
                if (z) {
                    a(mVar, obj);
                    return;
                } else {
                    this.i.a(mVar, obj);
                    return;
                }
            case BackgroundThread:
                if (z) {
                    this.j.a(mVar, obj);
                    return;
                } else {
                    a(mVar, obj);
                    return;
                }
            case Async:
                this.k.a(mVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + mVar.f1932b.f1926b);
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean zA;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> listA = a(cls);
            int size = listA.size();
            boolean zA2 = false;
            for (int i = 0; i < size; i++) {
                zA2 |= a(obj, aVar, listA.get(i));
            }
            zA = zA2;
        } else {
            zA = a(obj, aVar, cls);
        }
        if (zA) {
            return;
        }
        if (this.p) {
            Log.d(f1889a, "No subscribers registered for event " + cls);
        }
        if (!this.r || cls == g.class || cls == j.class) {
            return;
        }
        b(new g(this, obj));
    }

    private void a(Object obj, k kVar, boolean z, int i) {
        CopyOnWriteArrayList<m> copyOnWriteArrayList;
        Object obj2;
        Class<?> cls = kVar.f1927c;
        CopyOnWriteArrayList<m> copyOnWriteArrayList2 = this.f1893e.get(cls);
        m mVar = new m(obj, kVar, i);
        if (copyOnWriteArrayList2 == null) {
            CopyOnWriteArrayList<m> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
            this.f1893e.put(cls, copyOnWriteArrayList3);
            copyOnWriteArrayList = copyOnWriteArrayList3;
        } else {
            if (copyOnWriteArrayList2.contains(mVar)) {
                throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
            }
            copyOnWriteArrayList = copyOnWriteArrayList2;
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || mVar.f1933c > copyOnWriteArrayList.get(i2).f1933c) {
                copyOnWriteArrayList.add(i2, mVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f1894f.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f1894f.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (z) {
            synchronized (this.g) {
                obj2 = this.g.get(cls);
            }
            if (obj2 != null) {
                a(mVar, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private synchronized void a(Object obj, boolean z, int i) {
        Iterator<k> it = this.l.a(obj.getClass()).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z, i);
        }
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList<m> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f1893e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (m mVar : copyOnWriteArrayList) {
            aVar.f1901e = obj;
            aVar.f1900d = mVar;
            try {
                a(mVar, obj, aVar.f1899c);
                boolean z = aVar.f1902f;
                aVar.f1901e = null;
                aVar.f1900d = null;
                aVar.f1902f = false;
                if (z) {
                    break;
                }
            } catch (Throwable th) {
                aVar.f1901e = null;
                aVar.f1900d = null;
                aVar.f1902f = false;
                throw th;
            }
        }
        return true;
    }

    void a(h hVar) {
        Object obj = hVar.f1916a;
        m mVar = hVar.f1917b;
        h.a(hVar);
        if (mVar.f1934d) {
            a(mVar, obj);
        }
    }

    void a(m mVar, Object obj) {
        try {
            mVar.f1932b.f1925a.invoke(mVar.f1931a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(mVar, obj, e3.getCause());
        }
    }

    public void a(Object obj) {
        a(obj, false, 0);
    }

    ExecutorService b() {
        return this.m;
    }

    public void b(Object obj) {
        a aVar = this.h.get();
        List<Object> list = aVar.f1897a;
        list.add(obj);
        if (aVar.f1898b) {
            return;
        }
        aVar.f1899c = Looper.getMainLooper() == Looper.myLooper();
        aVar.f1898b = true;
        if (aVar.f1902f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                a(list.remove(0), aVar);
            } catch (Throwable th) {
                aVar.f1898b = false;
                aVar.f1899c = false;
                throw th;
            }
        }
        aVar.f1898b = false;
        aVar.f1899c = false;
    }
}
