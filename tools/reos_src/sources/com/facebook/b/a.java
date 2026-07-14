package com.facebook.b;

import android.content.Intent;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UUID f3644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f3645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3646d;

    public a(int i) {
        this(i, UUID.randomUUID());
    }

    public a(int i, UUID uuid) {
        this.f3644b = uuid;
        this.f3646d = i;
    }

    public static a a() {
        return f3643a;
    }

    public static synchronized a a(UUID uuid, int i) {
        a aVarA;
        aVarA = a();
        if (aVarA != null && aVarA.c().equals(uuid) && aVarA.d() == i) {
            a((a) null);
        } else {
            aVarA = null;
        }
        return aVarA;
    }

    private static synchronized boolean a(a aVar) {
        a aVarA;
        aVarA = a();
        f3643a = aVar;
        return aVarA != null;
    }

    public void a(Intent intent) {
        this.f3645c = intent;
    }

    public Intent b() {
        return this.f3645c;
    }

    public UUID c() {
        return this.f3644b;
    }

    public int d() {
        return this.f3646d;
    }

    public boolean e() {
        return a(this);
    }
}
