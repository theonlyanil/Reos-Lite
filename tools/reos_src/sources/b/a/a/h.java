package b.a.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<h> f1915d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f1916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    m f1917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h f1918c;

    private h(Object obj, m mVar) {
        this.f1916a = obj;
        this.f1917b = mVar;
    }

    static h a(m mVar, Object obj) {
        synchronized (f1915d) {
            int size = f1915d.size();
            if (size <= 0) {
                return new h(obj, mVar);
            }
            h hVarRemove = f1915d.remove(size - 1);
            hVarRemove.f1916a = obj;
            hVarRemove.f1917b = mVar;
            hVarRemove.f1918c = null;
            return hVarRemove;
        }
    }

    static void a(h hVar) {
        hVar.f1916a = null;
        hVar.f1917b = null;
        hVar.f1918c = null;
        synchronized (f1915d) {
            if (f1915d.size() < 10000) {
                f1915d.add(hVar);
            }
        }
    }
}
