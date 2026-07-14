package com.android.library.deviceData.b;

import com.google.a.a.c;
import com.google.a.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "category")
    private String f2613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "subCategory")
    private String f2614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "identifier")
    private String f2615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "version")
    private String f2616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "actionId")
    private String f2617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.a
    @c(a = "values")
    private List<b> f2618f = new ArrayList();

    public void a(String str) {
        this.f2613a = str;
    }

    public void a(List<b> list) {
        this.f2618f = list;
    }

    public void b(String str) {
        this.f2614b = str;
    }

    public void c(String str) {
        this.f2615c = str;
    }

    public void d(String str) {
        this.f2616d = str;
    }

    public void e(String str) {
        this.f2617e = str;
    }

    public String toString() {
        return new g().c().a(this);
    }
}
