package com.google.b.c;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f5459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f5461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f5463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f5464f;
    private Object g;
    private final int h;
    private final int i;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f5459a = bArr;
        this.f5460b = str;
        this.f5461c = list;
        this.f5462d = str2;
        this.h = i2;
        this.i = i;
    }

    public void a(Integer num) {
        this.f5463e = num;
    }

    public void a(Object obj) {
        this.g = obj;
    }

    public byte[] a() {
        return this.f5459a;
    }

    public String b() {
        return this.f5460b;
    }

    public void b(Integer num) {
        this.f5464f = num;
    }

    public List<byte[]> c() {
        return this.f5461c;
    }

    public String d() {
        return this.f5462d;
    }

    public Object e() {
        return this.g;
    }

    public boolean f() {
        return this.h >= 0 && this.i >= 0;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }
}
