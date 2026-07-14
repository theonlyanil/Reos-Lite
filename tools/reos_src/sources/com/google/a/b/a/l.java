package com.google.a.b.a;

import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class l<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.a.f f5126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f5127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f5128c;

    l(com.google.a.f fVar, x<T> xVar, Type type) {
        this.f5126a = fVar;
        this.f5127b = xVar;
        this.f5128c = type;
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // com.google.a.x
    public void a(com.google.a.d.c cVar, T t) throws IOException {
        x<T> xVarA = this.f5127b;
        Type typeA = a(this.f5128c, t);
        if (typeA != this.f5128c) {
            xVarA = this.f5126a.a((com.google.a.c.a) com.google.a.c.a.get(typeA));
            if ((xVarA instanceof i.a) && !(this.f5127b instanceof i.a)) {
                xVarA = this.f5127b;
            }
        }
        xVarA.a(cVar, t);
    }

    @Override // com.google.a.x
    public T b(com.google.a.d.a aVar) throws IOException {
        return this.f5127b.b(aVar);
    }
}
