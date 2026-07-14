package com.cube26.iota.smartlite.b;

import com.android.apps.config.util.CLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<com.cube26.iota.smartlite.d.a> f3223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3224b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3225c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3226d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3228f;

    public a(String str, int i, ArrayList<com.cube26.iota.smartlite.d.a> arrayList) {
        this.f3227e = -1;
        this.f3228f = null;
        this.f3223a = arrayList;
        this.f3228f = str;
        this.f3227e = i;
    }

    public void a(com.cube26.iota.smartlite.d.a aVar) {
        this.f3223a.remove(aVar);
    }

    public void a(String str) {
        this.f3228f = str;
    }

    public void a(ArrayList<com.cube26.iota.smartlite.d.a> arrayList) {
        this.f3223a = arrayList;
    }

    public void a(boolean z) {
        this.f3226d = z;
    }

    public boolean a() {
        return this.f3226d;
    }

    public String b() {
        return this.f3228f;
    }

    public void b(boolean z) {
        this.f3225c = z;
    }

    public int c() {
        return this.f3227e;
    }

    public void c(boolean z) {
        this.f3224b = z;
    }

    public ArrayList<com.cube26.iota.smartlite.d.a> d() {
        return this.f3223a;
    }

    public boolean e() {
        return this.f3225c;
    }

    public boolean equals(Object obj) {
        CLog.a("IOTA", "group equals");
        c cVar = (c) obj;
        return (cVar instanceof a) && ((a) cVar).b().equals(b().trim());
    }

    public boolean f() {
        return this.f3224b;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean g() {
        return false;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean h() {
        return true;
    }

    public String i() {
        StringBuilder sb = new StringBuilder();
        Iterator<com.cube26.iota.smartlite.d.a> it = this.f3223a.iterator();
        while (it.hasNext()) {
            sb.append(it.next().q()).append(";");
        }
        return sb.toString();
    }

    public String toString() {
        return " group name - " + this.f3228f + " group id - " + this.f3227e + " selected - " + this.f3224b + " available - " + this.f3225c + " connected - " + this.f3226d + " lites - " + this.f3223a;
    }
}
