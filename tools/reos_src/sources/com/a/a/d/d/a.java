package com.a.a.d.d;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a<T> implements com.a.a.d.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a<?> f2213a = new a<>();

    public static <T> com.a.a.d.b<T> b() {
        return f2213a;
    }

    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(T t, OutputStream outputStream) {
        return false;
    }
}
