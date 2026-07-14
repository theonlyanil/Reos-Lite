package com.flurry.sdk;

import android.widget.Toast;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class iy extends kt implements ll.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4394e = iy.class.getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f4395f = "http://data.flurry.com/aap.do";
    private static String g = "https://data.flurry.com/aap.do";
    private String h;
    private boolean i;

    public iy() {
        this(null);
    }

    public iy(kt.a aVar) {
        super("Analytics", iy.class.getSimpleName());
        this.f4631d = "AnalyticsData_";
        h();
        a(aVar);
    }

    private void b(String str) {
        if (str != null && !str.endsWith(".do")) {
            kg.a(5, f4394e, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.h = str;
    }

    private void h() {
        lk lkVarA = lk.a();
        this.i = ((Boolean) lkVarA.a("UseHttps")).booleanValue();
        lkVarA.a("UseHttps", (ll.a) this);
        kg.a(4, f4394e, "initSettings, UseHttps = " + this.i);
        String str = (String) lkVarA.a("ReportUrl");
        lkVarA.a("ReportUrl", (ll.a) this);
        b(str);
        kg.a(4, f4394e, "initSettings, ReportUrl = " + str);
    }

    public void a() {
        lk.a().b("UseHttps", (ll.a) this);
        lk.a().b("ReportUrl", (ll.a) this);
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        switch (str) {
            case "UseHttps":
                this.i = ((Boolean) obj).booleanValue();
                kg.a(4, f4394e, "onSettingUpdate, UseHttps = " + this.i);
                break;
            case "ReportUrl":
                String str2 = (String) obj;
                b(str2);
                kg.a(4, f4394e, "onSettingUpdate, ReportUrl = " + str2);
                break;
            default:
                kg.a(6, f4394e, "onSettingUpdate internal error!");
                break;
        }
    }

    @Override // com.flurry.sdk.kt
    protected void a(String str, String str2, final int i) {
        a(new ly() { // from class: com.flurry.sdk.iy.2
            @Override // com.flurry.sdk.ly
            public void a() {
                if (i == 200) {
                    hl.a().f();
                }
            }
        });
        super.a(str, str2, i);
    }

    @Override // com.flurry.sdk.kt
    protected void a(byte[] bArr, final String str, final String str2) {
        String strB = b();
        kg.a(4, f4394e, "FlurryDataSender: start upload data " + Arrays.toString(bArr) + " with id = " + str + " to " + strB);
        kn knVar = new kn();
        knVar.a(strB);
        knVar.d(100000);
        knVar.a(kp.a.kPost);
        knVar.a("Content-Type", "application/octet-stream");
        knVar.a((lb) new kx());
        knVar.a(bArr);
        knVar.a((kn.a) new kn.a<byte[], Void>() { // from class: com.flurry.sdk.iy.1
            @Override // com.flurry.sdk.kn.a
            public void a(kn<byte[], Void> knVar2, Void r7) {
                final int iH = knVar2.h();
                if (iH <= 0) {
                    iy.this.b(str, str2);
                    return;
                }
                kg.e(iy.f4394e, "Analytics report sent.");
                kg.a(3, iy.f4394e, "FlurryDataSender: report " + str + " sent. HTTP response: " + iH);
                if (kg.c() <= 3 && kg.d()) {
                    js.a().a(new Runnable() { // from class: com.flurry.sdk.iy.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(js.a().c(), "SD HTTP Response Code: " + iH, 0).show();
                        }
                    });
                }
                iy.this.a(str, str2, iH);
                iy.this.e();
            }
        });
        jq.a().a(this, knVar);
    }

    String b() {
        if (this.h != null) {
            return this.h;
        }
        return this.i ? g : f4395f;
    }
}
