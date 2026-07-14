package com.android.library.userprofile.model;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "TITLE")
    String f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "ARTIST")
    String f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = "ALBUM")
    String f2805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.c(a = "PATH")
    String f2806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.c(a = "DURATION")
    long f2807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.c(a = "ALBUM_ID")
    long f2808f;

    @com.google.a.a.c(a = "COMPOSER")
    String g;

    @com.google.a.a.c(a = "ID")
    String h;

    @com.google.a.a.c(a = "ALBUMARTURL")
    String i;

    @com.google.a.a.c(a = "SEEK_BAR_POSITION")
    String j;

    @com.google.a.a.c(a = "BITMAP_URI")
    String k;

    @com.google.a.a.c(a = "GENRE")
    String l;

    @com.google.a.a.c(a = "IsLocal")
    boolean m;

    public void a(long j) {
        this.f2807e = j;
    }

    public void a(String str) {
        this.f2803a = str;
    }

    public void b(long j) {
        this.f2808f = j;
    }

    public void b(String str) {
        this.f2804b = str;
    }

    public void c(String str) {
        this.f2805c = str;
    }

    public void d(String str) {
        this.f2806d = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public void f(String str) {
        this.k = str;
    }

    public void g(String str) {
        this.l = str;
    }

    public String toString() {
        return "Song [TITLE=" + this.f2803a + ", ARTIST=" + this.f2804b + ", ALBUM=" + this.f2805c + ", PATH=" + this.f2806d + ", DURATION=" + this.f2807e + ", ALBUM_ID=" + this.f2808f + ", COMPOSER=" + this.g + ", ID=" + this.h + ", ALBUMARTURL=" + this.i + ", SEEK_BAR_POSITION=" + this.j + ", BITMAP_URI=" + this.k + ", GENRE=" + this.l + ", IsLocal=" + this.m + "]";
    }
}
