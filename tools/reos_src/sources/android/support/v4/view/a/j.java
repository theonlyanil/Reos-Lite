package android.support.v4.view.a;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f873b;

    interface a {
        Object a(j jVar);
    }

    static class b extends d {
        b() {
        }

        @Override // android.support.v4.view.a.j.d, android.support.v4.view.a.j.a
        public Object a(final j jVar) {
            return k.a(new k.a() { // from class: android.support.v4.view.a.j.b.1
                @Override // android.support.v4.view.a.k.a
                public Object a(int i) {
                    android.support.v4.view.a.c cVarA = jVar.a(i);
                    if (cVarA == null) {
                        return null;
                    }
                    return cVarA.a();
                }

                @Override // android.support.v4.view.a.k.a
                public List<Object> a(String str, int i) {
                    List<android.support.v4.view.a.c> listA = jVar.a(str, i);
                    ArrayList arrayList = new ArrayList();
                    int size = listA.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listA.get(i2).a());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.a.k.a
                public boolean a(int i, int i2, Bundle bundle) {
                    return jVar.a(i, i2, bundle);
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        @Override // android.support.v4.view.a.j.d, android.support.v4.view.a.j.a
        public Object a(final j jVar) {
            return l.a(new l.a() { // from class: android.support.v4.view.a.j.c.1
                @Override // android.support.v4.view.a.l.a
                public Object a(int i) {
                    android.support.v4.view.a.c cVarA = jVar.a(i);
                    if (cVarA == null) {
                        return null;
                    }
                    return cVarA.a();
                }

                @Override // android.support.v4.view.a.l.a
                public List<Object> a(String str, int i) {
                    List<android.support.v4.view.a.c> listA = jVar.a(str, i);
                    ArrayList arrayList = new ArrayList();
                    int size = listA.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listA.get(i2).a());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.a.l.a
                public boolean a(int i, int i2, Bundle bundle) {
                    return jVar.a(i, i2, bundle);
                }

                @Override // android.support.v4.view.a.l.a
                public Object b(int i) {
                    android.support.v4.view.a.c cVarB = jVar.b(i);
                    if (cVarB == null) {
                        return null;
                    }
                    return cVarB.a();
                }
            });
        }
    }

    static class d implements a {
        d() {
        }

        @Override // android.support.v4.view.a.j.a
        public Object a(j jVar) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f872a = new c();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f872a = new b();
        } else {
            f872a = new d();
        }
    }

    public j() {
        this.f873b = f872a.a(this);
    }

    public j(Object obj) {
        this.f873b = obj;
    }

    public android.support.v4.view.a.c a(int i) {
        return null;
    }

    public Object a() {
        return this.f873b;
    }

    public List<android.support.v4.view.a.c> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public android.support.v4.view.a.c b(int i) {
        return null;
    }
}
