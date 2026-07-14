package com.google.b;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f5778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o[] f5779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f5780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<n, Object> f5781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f5782f;

    public m(String str, byte[] bArr, o[] oVarArr, a aVar) {
        this(str, bArr, oVarArr, aVar, System.currentTimeMillis());
    }

    public m(String str, byte[] bArr, o[] oVarArr, a aVar, long j) {
        this.f5777a = str;
        this.f5778b = bArr;
        this.f5779c = oVarArr;
        this.f5780d = aVar;
        this.f5781e = null;
        this.f5782f = j;
    }

    public String a() {
        return this.f5777a;
    }

    public void a(n nVar, Object obj) {
        if (this.f5781e == null) {
            this.f5781e = new EnumMap(n.class);
        }
        this.f5781e.put(nVar, obj);
    }

    public void a(Map<n, Object> map) {
        if (map != null) {
            if (this.f5781e == null) {
                this.f5781e = map;
            } else {
                this.f5781e.putAll(map);
            }
        }
    }

    public void a(o[] oVarArr) {
        o[] oVarArr2 = this.f5779c;
        if (oVarArr2 == null) {
            this.f5779c = oVarArr;
            return;
        }
        if (oVarArr == null || oVarArr.length <= 0) {
            return;
        }
        o[] oVarArr3 = new o[oVarArr2.length + oVarArr.length];
        System.arraycopy(oVarArr2, 0, oVarArr3, 0, oVarArr2.length);
        System.arraycopy(oVarArr, 0, oVarArr3, oVarArr2.length, oVarArr.length);
        this.f5779c = oVarArr3;
    }

    public byte[] b() {
        return this.f5778b;
    }

    public o[] c() {
        return this.f5779c;
    }

    public a d() {
        return this.f5780d;
    }

    public Map<n, Object> e() {
        return this.f5781e;
    }

    public String toString() {
        return this.f5777a;
    }
}
