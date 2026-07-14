package com.facebook.b;

import android.app.Activity;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<CONTENT, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Object f3734a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f3735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f3736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<j<CONTENT, RESULT>.a> f3737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3738e;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract class a {
        protected a() {
        }

        public abstract com.facebook.b.a a(CONTENT content);

        public Object a() {
            return j.f3734a;
        }

        public abstract boolean a(CONTENT content, boolean z);
    }

    protected j(Activity activity, int i) {
        ae.a(activity, "activity");
        this.f3735b = activity;
        this.f3736c = null;
        this.f3738e = i;
    }

    protected j(o oVar, int i) {
        ae.a(oVar, "fragmentWrapper");
        this.f3736c = oVar;
        this.f3735b = null;
        this.f3738e = i;
        if (oVar.c() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    private com.facebook.b.a c(CONTENT content, Object obj) {
        com.facebook.b.a aVarD;
        boolean z = obj == f3734a;
        Iterator<j<CONTENT, RESULT>.a> it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                aVarD = null;
                break;
            }
            j<CONTENT, RESULT>.a next = it.next();
            if (z || ad.a(next.a(), obj)) {
                if (next.a(content, true)) {
                    try {
                        aVarD = next.a(content);
                        break;
                    } catch (com.facebook.k e2) {
                        aVarD = d();
                        i.a(aVarD, e2);
                    }
                }
            }
        }
        if (aVarD != null) {
            return aVarD;
        }
        com.facebook.b.a aVarD2 = d();
        i.a(aVarD2);
        return aVarD2;
    }

    private List<j<CONTENT, RESULT>.a> e() {
        if (this.f3737d == null) {
            this.f3737d = c();
        }
        return this.f3737d;
    }

    public int a() {
        return this.f3738e;
    }

    public boolean a(CONTENT content) {
        return a(content, f3734a);
    }

    protected boolean a(CONTENT content, Object obj) {
        boolean z = obj == f3734a;
        for (j<CONTENT, RESULT>.a aVar : e()) {
            if (z || ad.a(aVar.a(), obj)) {
                if (aVar.a(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected Activity b() {
        if (this.f3735b != null) {
            return this.f3735b;
        }
        if (this.f3736c != null) {
            return this.f3736c.c();
        }
        return null;
    }

    public void b(CONTENT content) {
        b(content, f3734a);
    }

    protected void b(CONTENT content, Object obj) {
        com.facebook.b.a aVarC = c(content, obj);
        if (aVarC == null) {
            Log.e("FacebookDialog", "No code path should ever result in a null appCall");
            if (com.facebook.m.b()) {
                throw new IllegalStateException("No code path should ever result in a null appCall");
            }
        } else if (this.f3736c != null) {
            i.a(aVarC, this.f3736c);
        } else {
            i.a(aVarC, this.f3735b);
        }
    }

    protected abstract List<j<CONTENT, RESULT>.a> c();

    protected abstract com.facebook.b.a d();
}
