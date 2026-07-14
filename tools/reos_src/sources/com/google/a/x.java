package com.google.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class x<T> {
    public final l a(T t) {
        try {
            com.google.a.b.a.f fVar = new com.google.a.b.a.f();
            a(fVar, t);
            return fVar.a();
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public final x<T> a() {
        return new x<T>() { // from class: com.google.a.x.1
            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    x.this.a(cVar, t);
                }
            }

            @Override // com.google.a.x
            public T b(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return (T) x.this.b(aVar);
                }
                aVar.j();
                return null;
            }
        };
    }

    public abstract void a(com.google.a.d.c cVar, T t) throws IOException;

    public abstract T b(com.google.a.d.a aVar) throws IOException;
}
