package com.a.a.d.c;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l f2170c = new l() { // from class: com.a.a.d.c.c.1
        @Override // com.a.a.d.c.l
        public com.a.a.d.a.c a(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class, Map<Class, m>> f2171a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class, Map<Class, l>> f2172b = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f2173d;

    public c(Context context) {
        this.f2173d = context.getApplicationContext();
    }

    private <T, Y> void a(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.f2172b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f2172b.put(cls, map);
        }
        map.put(cls2, lVar);
    }

    private <T, Y> void b(Class<T> cls, Class<Y> cls2) {
        a(cls, cls2, f2170c);
    }

    private <T, Y> l<T, Y> c(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.f2172b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> m<T, Y> d(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        Map<Class, m> map2 = this.f2171a.get(cls);
        m mVar = map2 != null ? map2.get(cls2) : null;
        if (mVar != null) {
            return mVar;
        }
        Iterator<Class> it = this.f2171a.keySet().iterator();
        while (true) {
            m<T, Y> mVar2 = mVar;
            if (!it.hasNext()) {
                return mVar2;
            }
            Class next = it.next();
            if (!next.isAssignableFrom(cls) || (map = this.f2171a.get(next)) == null) {
                mVar = mVar2;
            } else {
                mVar = map.get(cls2);
                if (mVar != null) {
                    return mVar;
                }
            }
        }
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> lVarC;
        lVarC = c(cls, cls2);
        if (lVarC == null) {
            m<T, Y> mVarD = d(cls, cls2);
            if (mVarD != null) {
                lVarC = mVarD.a(this.f2173d, this);
                a(cls, cls2, lVarC);
            } else {
                b(cls, cls2);
            }
        } else if (f2170c.equals(lVarC)) {
            lVarC = null;
        }
        return lVarC;
    }

    public synchronized <T, Y> m<T, Y> a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> mVarPut;
        this.f2172b.clear();
        Map<Class, m> map = this.f2171a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f2171a.put(cls, map);
        }
        mVarPut = map.put(cls2, mVar);
        if (mVarPut != null) {
            Iterator<Map<Class, m>> it = this.f2171a.values().iterator();
            while (it.hasNext()) {
                if (it.next().containsValue(mVarPut)) {
                    mVarPut = null;
                    break;
                }
            }
        }
        return mVarPut;
    }
}
