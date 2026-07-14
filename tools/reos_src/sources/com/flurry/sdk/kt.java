package com.flurry.sdk;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class kt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f4628a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    kv f4630c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Set<String> f4629b = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f4631d = "defaultDataKey_";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private kb<jk> f4632e = new kb<jk>() { // from class: com.flurry.sdk.kt.1
        @Override // com.flurry.sdk.kb
        public void a(jk jkVar) {
            kg.a(4, kt.this.f4628a, "onNetworkStateChanged : isNetworkEnable = " + jkVar.f4479a);
            if (jkVar.f4479a) {
                kt.this.e();
            }
        }
    };

    public interface a {
        void a();
    }

    public kt(String str, String str2) {
        this.f4628a = str2;
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", this.f4632e);
        a(str);
    }

    public String a(String str, String str2) {
        return this.f4631d + str + "_" + str2;
    }

    protected void a(final a aVar) {
        a(new ly() { // from class: com.flurry.sdk.kt.4
            @Override // com.flurry.sdk.ly
            public void a() {
                kt.this.g();
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    protected void a(ly lyVar) {
        js.a().b(lyVar);
    }

    protected void a(final String str) {
        a(new ly() { // from class: com.flurry.sdk.kt.2
            @Override // com.flurry.sdk.ly
            public void a() {
                kt.this.f4630c = new kv(str);
            }
        });
    }

    protected void a(final String str, final String str2, int i) {
        a(new ly() { // from class: com.flurry.sdk.kt.7
            @Override // com.flurry.sdk.ly
            public void a() {
                if (!kt.this.f4630c.a(str, str2)) {
                    kg.a(6, kt.this.f4628a, "Internal error. Block wasn't deleted with id = " + str);
                }
                if (kt.this.f4629b.remove(str)) {
                    return;
                }
                kg.a(6, kt.this.f4628a, "Internal error. Block with id = " + str + " was not in progress state");
            }
        });
    }

    protected abstract void a(byte[] bArr, String str, String str2);

    public void a(byte[] bArr, String str, String str2, a aVar) {
        if (bArr == null || bArr.length == 0) {
            kg.a(6, this.f4628a, "Report that has to be sent is EMPTY or NULL");
        } else {
            c(bArr, str, str2);
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final String str, String str2) {
        a(new ly() { // from class: com.flurry.sdk.kt.8
            @Override // com.flurry.sdk.ly
            public void a() {
                if (kt.this.f4629b.remove(str)) {
                    return;
                }
                kg.a(6, kt.this.f4628a, "Internal error. Block with id = " + str + " was not in progress state");
            }
        });
    }

    public void b(byte[] bArr, String str, String str2) {
        a(bArr, str, str2, null);
    }

    protected void c(String str, String str2) {
        if (!this.f4630c.a(str, str2)) {
            kg.a(6, this.f4628a, "Internal error. Block wasn't deleted with id = " + str);
        }
        if (this.f4629b.remove(str)) {
            return;
        }
        kg.a(6, this.f4628a, "Internal error. Block with id = " + str + " was not in progress state");
    }

    protected void c(final byte[] bArr, final String str, final String str2) {
        a(new ly() { // from class: com.flurry.sdk.kt.3
            @Override // com.flurry.sdk.ly
            public void a() throws Throwable {
                kt.this.d(bArr, str, str2);
            }
        });
    }

    public int d() {
        return this.f4629b.size();
    }

    protected void d(byte[] bArr, String str, String str2) throws Throwable {
        String strA = a(str, str2);
        ku kuVar = new ku(bArr);
        String strA2 = kuVar.a();
        new jz(js.a().c().getFileStreamPath(ku.a(strA2)), ".yflurrydatasenderblock.", 1, new le<ku>() { // from class: com.flurry.sdk.kt.5
            @Override // com.flurry.sdk.le
            public lb<ku> a(int i) {
                return new ku.a();
            }
        }).a(kuVar);
        kg.a(5, this.f4628a, "Saving Block File " + strA2 + " at " + js.a().c().getFileStreamPath(ku.a(strA2)));
        this.f4630c.a(kuVar, strA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        a((a) null);
    }

    protected boolean f() {
        return d() <= 5;
    }

    protected void g() {
        if (!jl.a().c()) {
            kg.a(5, this.f4628a, "Reports were not sent! No Internet connection!");
            return;
        }
        List<String> listA = this.f4630c.a();
        if (listA == null || listA.isEmpty()) {
            kg.a(4, this.f4628a, "No more reports to send.");
            return;
        }
        for (String str : listA) {
            if (!f()) {
                return;
            }
            List<String> listC = this.f4630c.c(str);
            kg.a(4, this.f4628a, "Number of not sent blocks = " + listC.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listC.size()) {
                    break;
                }
                String str2 = listC.get(i2);
                if (!this.f4629b.contains(str2)) {
                    if (!f()) {
                        break;
                    }
                    ku kuVar = (ku) new jz(js.a().c().getFileStreamPath(ku.a(str2)), ".yflurrydatasenderblock.", 1, new le<ku>() { // from class: com.flurry.sdk.kt.6
                        @Override // com.flurry.sdk.le
                        public lb<ku> a(int i3) {
                            return new ku.a();
                        }
                    }).a();
                    if (kuVar == null) {
                        kg.a(6, this.f4628a, "Internal ERROR! Cannot read!");
                        this.f4630c.a(str2, str);
                    } else {
                        byte[] bArrB = kuVar.b();
                        if (bArrB == null || bArrB.length == 0) {
                            kg.a(6, this.f4628a, "Internal ERROR! Report is empty!");
                            this.f4630c.a(str2, str);
                        } else {
                            kg.a(5, this.f4628a, "Reading block info " + str2);
                            this.f4629b.add(str2);
                            a(bArrB, str2, str);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
    }
}
