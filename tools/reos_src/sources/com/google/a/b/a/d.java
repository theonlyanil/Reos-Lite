package com.google.a.b.a;

import com.google.a.x;
import com.google.a.y;

/* JADX INFO: loaded from: classes.dex */
public final class d implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.a.b.c f5093a;

    public d(com.google.a.b.c cVar) {
        this.f5093a = cVar;
    }

    static x<?> a(com.google.a.b.c cVar, com.google.a.f fVar, com.google.a.c.a<?> aVar, com.google.a.a.b bVar) {
        x xVarA;
        Class<?> clsA = bVar.a();
        if (x.class.isAssignableFrom(clsA)) {
            xVarA = (x) cVar.a(com.google.a.c.a.get((Class) clsA)).a();
        } else {
            if (!y.class.isAssignableFrom(clsA)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
            }
            xVarA = ((y) cVar.a(com.google.a.c.a.get((Class) clsA)).a()).a(fVar, aVar);
        }
        return xVarA.a();
    }

    @Override // com.google.a.y
    public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
        com.google.a.a.b bVar = (com.google.a.a.b) aVar.getRawType().getAnnotation(com.google.a.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) a(this.f5093a, fVar, aVar, bVar);
    }
}
