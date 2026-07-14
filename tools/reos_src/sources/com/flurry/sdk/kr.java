package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public abstract class kr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4613f;

    protected kr() {
    }

    public void a(long j) {
        this.f4608a = j;
    }

    public void a(String str) {
        this.f4611d = str;
        this.f4612e = str;
    }

    public void a_() {
        this.f4610c++;
    }

    public void b(int i) {
        this.f4610c = i;
    }

    public void b(String str) {
        this.f4611d = str;
    }

    public void b(boolean z) {
        this.f4609b = z;
    }

    public void c(int i) {
        this.f4613f = i;
    }

    public void c(String str) {
        this.f4612e = str;
    }

    public int d() {
        return this.f4613f;
    }

    public long p() {
        return this.f4608a;
    }

    public boolean q() {
        return this.f4609b;
    }

    public int r() {
        return this.f4610c;
    }

    public String s() {
        return this.f4611d;
    }

    public String t() {
        return this.f4612e;
    }
}
