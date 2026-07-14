package com.cube26.iota.smartlite.b;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Date f3238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3241f;
    private int g;
    private int h;
    private String i;
    private int j;

    public e(int i, int i2, String str, Date date, String str2, int i3, int i4, int i5, String str3, int i6) {
        this.f3236a = i;
        this.h = i2;
        this.f3237b = str;
        this.f3238c = date;
        this.f3239d = str2;
        this.f3240e = i3;
        this.f3241f = i4;
        this.g = i5;
        this.i = str3;
        this.j = i6;
    }

    public int a() {
        return this.j;
    }

    public void a(int i) {
        this.f3241f = i;
    }

    public int b() {
        return this.h;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.f3237b;
    }

    public String e() {
        int i;
        String str;
        int hours = this.f3238c.getHours();
        int minutes = this.f3238c.getMinutes();
        String str2 = hours == 12 ? "PM" : "AM";
        if (hours > 12) {
            i = hours - 12;
            str = "PM";
        } else {
            String str3 = str2;
            i = hours;
            str = str3;
        }
        String str4 = i < 10 ? "0" + i + ":" : "" + i + ":";
        return minutes < 10 ? str4 + "0" + minutes + " " + str : str4 + minutes + " " + str;
    }

    public boolean equals(Object obj) {
        g gVar = (g) obj;
        return (gVar instanceof e) && this.h == ((e) gVar).h;
    }

    public int f() {
        return this.f3236a;
    }

    public int g() {
        return this.f3238c.getHours();
    }

    public int h() {
        return this.f3238c.getMinutes();
    }

    public String i() {
        return this.f3239d;
    }

    public int j() {
        return this.f3240e;
    }

    public boolean k() {
        return this.f3241f == 1;
    }

    public int l() {
        return this.g;
    }

    @Override // com.cube26.iota.smartlite.b.g
    public boolean m() {
        return false;
    }
}
