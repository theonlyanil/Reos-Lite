package com.google.b.i.a;

import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5739a;

    i(boolean z) {
        this.f5739a = z;
    }

    public void a(o[] oVarArr) {
        if (!this.f5739a || oVarArr == null || oVarArr.length < 3) {
            return;
        }
        o oVar = oVarArr[0];
        oVarArr[0] = oVarArr[2];
        oVarArr[2] = oVar;
    }
}
