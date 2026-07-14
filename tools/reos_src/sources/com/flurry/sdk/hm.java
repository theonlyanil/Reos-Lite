package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class hm {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4212b = hm.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4213a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final hn f4214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f4215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4216e;

    public hm() {
        this(js.a().c());
    }

    public hm(Context context) {
        this.f4214c = new hn();
        this.f4215d = context.getFileStreamPath(".flurryinstallreceiver.");
        kg.a(3, f4212b, "Referrer file name if it exists:  " + this.f4215d);
    }

    private void b(String str) {
        if (str == null) {
            return;
        }
        this.f4216e = str;
    }

    private void c() throws Throwable {
        if (this.f4213a) {
            return;
        }
        this.f4213a = true;
        kg.a(4, f4212b, "Loading referrer info from file: " + this.f4215d.getAbsolutePath());
        String strC = ls.c(this.f4215d);
        kg.a(f4212b, "Referrer file contents: " + strC);
        b(strC);
    }

    private void d() throws Throwable {
        ls.a(this.f4215d, this.f4216e);
    }

    public synchronized Map<String, List<String>> a(boolean z) {
        Map<String, List<String>> mapA;
        c();
        mapA = this.f4214c.a(this.f4216e);
        if (z) {
            a();
        }
        return mapA;
    }

    public synchronized void a() {
        this.f4215d.delete();
        this.f4216e = null;
        this.f4213a = true;
    }

    public synchronized void a(String str) {
        this.f4213a = true;
        b(str);
        d();
    }

    public synchronized String b() {
        c();
        return this.f4216e;
    }
}
