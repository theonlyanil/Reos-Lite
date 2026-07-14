package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f4711a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, List<a>> f4712b = new HashMap();

    public interface a {
        void a(String str, Object obj);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void b(String str, Object obj) {
        if (this.f4712b.get(str) != null) {
            Iterator<a> it = this.f4712b.get(str).iterator();
            while (it.hasNext()) {
                it.next().a(str, obj);
            }
        }
    }

    public synchronized Object a(String str) {
        return this.f4711a.get(str);
    }

    public synchronized void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            List<a> linkedList = this.f4712b.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(aVar);
            this.f4712b.put(str, linkedList);
        }
    }

    public synchronized void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && !a(obj, this.f4711a.get(str))) {
            if (obj == null) {
                this.f4711a.remove(str);
            } else {
                this.f4711a.put(str, obj);
            }
            b(str, obj);
        }
    }

    public synchronized boolean b(String str, a aVar) {
        List<a> list;
        boolean zRemove;
        zRemove = (TextUtils.isEmpty(str) || aVar == null || (list = this.f4712b.get(str)) == null) ? false : list.remove(aVar);
        return zRemove;
    }

    public synchronized void d() {
        this.f4712b.clear();
    }
}
