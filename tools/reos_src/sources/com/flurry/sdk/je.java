package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class je implements kj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4451a = je.class.getSimpleName();

    public static synchronized je a() {
        return (je) js.a().a(je.class);
    }

    private jr a(lf lfVar) {
        if (lfVar == null) {
            return null;
        }
        return (jr) lfVar.c(jr.class);
    }

    private jr m() {
        return a(lh.a().e());
    }

    @Override // com.flurry.sdk.kj
    public void a(Context context) {
        lf.a(jr.class);
        kc.a();
        lo.a();
        lk.a();
        ju.a();
        jl.a();
        jf.a();
        jm.a();
        jj.a();
        jf.a();
        jo.a();
        ji.a();
        jq.a();
    }

    public void a(String str) {
        jr jrVarM = m();
        if (jrVarM != null) {
            jrVarM.a(str);
        }
    }

    public void a(String str, String str2) {
        jr jrVarM = m();
        if (jrVarM != null) {
            jrVarM.a(str, str2);
        }
    }

    @Override // com.flurry.sdk.kj
    public void b() {
        jq.b();
        ji.b();
        jo.b();
        jf.b();
        jj.b();
        jm.b();
        jf.b();
        jl.b();
        ju.b();
        lk.b();
        lo.b();
        kc.b();
        lf.b(jr.class);
    }

    public void b(String str) {
        jr jrVarM = m();
        if (jrVarM != null) {
            jrVarM.b(str);
        }
    }

    public String c() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.b();
        }
        return null;
    }

    public long d() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.c();
        }
        return 0L;
    }

    public long e() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.d();
        }
        return 0L;
    }

    public long f() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.e();
        }
        return -1L;
    }

    public long g() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.g();
        }
        return 0L;
    }

    public long h() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.f();
        }
        return 0L;
    }

    public String i() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.h();
        }
        return null;
    }

    public String j() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.i();
        }
        return null;
    }

    public Map<String, String> k() {
        jr jrVarM = m();
        if (jrVarM != null) {
            return jrVarM.j();
        }
        return null;
    }

    public jl.a l() {
        return jl.a().d();
    }
}
