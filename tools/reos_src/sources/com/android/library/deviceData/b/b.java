package com.android.library.deviceData.b;

import com.google.a.a.c;
import com.google.a.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "eventTime")
    private long f2619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "boardName")
    private String f2620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "model")
    private String f2621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "brand")
    private String f2622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "manufacturer")
    private String f2623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "androidVersion")
    private String f2624f;

    @com.google.a.a.a
    @c(a = "imeis")
    private List<String> g = new ArrayList();

    @com.google.a.a.a
    @c(a = "phoneType")
    private int h;

    @com.google.a.a.a
    @c(a = "displayWidth")
    private int i;

    @com.google.a.a.a
    @c(a = "displayHeight")
    private int j;

    @com.google.a.a.a
    @c(a = "ram")
    private float k;

    @com.google.a.a.a
    @c(a = "internalSpace")
    private float l;

    @com.google.a.a.a
    @c(a = "xdpi")
    private float m;

    @com.google.a.a.a
    @c(a = "ydpi")
    private float n;

    @com.google.a.a.a
    @c(a = "gaid")
    private String o;

    @com.google.a.a.a
    @c(a = "simCountry")
    private String p;

    @com.google.a.a.a
    @c(a = "networkCountry")
    private String q;

    @com.google.a.a.a
    @c(a = "locale")
    private String r;

    @com.google.a.a.a
    @c(a = "timezone")
    private String s;

    @com.google.a.a.a
    @c(a = "autoTimeZone")
    private Boolean t;

    @c(a = "gmsVersion")
    private String u;

    public void a(float f2) {
        this.n = f2;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.f2619a = j;
    }

    public void a(Boolean bool) {
        this.t = bool;
    }

    public void a(String str) {
        this.u = str;
    }

    public void a(List<String> list) {
        this.g = list;
    }

    public void b(float f2) {
        this.m = f2;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.o = str;
    }

    public void c(float f2) {
        this.l = f2;
    }

    public void c(int i) {
        this.h = i;
    }

    public void c(String str) {
        this.f2624f = str;
    }

    public void d(float f2) {
        this.k = f2;
    }

    public void d(String str) {
        this.f2623e = str;
    }

    public void e(String str) {
        this.f2622d = str;
    }

    public void f(String str) {
        this.f2621c = str;
    }

    public void g(String str) {
        this.f2620b = str;
    }

    public void h(String str) {
        this.p = str;
    }

    public void i(String str) {
        this.q = str;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(String str) {
        this.s = str;
    }

    public String toString() {
        return new g().c().a(this);
    }
}
