package com.a.a.h.a;

/* JADX INFO: loaded from: classes.dex */
public class e<R> implements c<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e<?> f2425a = new e<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d<?> f2426b = new a();

    public static class a<R> implements d<R> {
        @Override // com.a.a.h.a.d
        public c<R> a(boolean z, boolean z2) {
            return e.f2425a;
        }
    }

    public static <R> d<R> a() {
        return (d<R>) f2426b;
    }

    public static <R> c<R> b() {
        return f2425a;
    }

    @Override // com.a.a.h.a.c
    public boolean a(Object obj, c.a aVar) {
        return false;
    }
}
