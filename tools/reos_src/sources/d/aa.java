package d;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class aa {
    public static aa a(final u uVar, final e.f fVar) {
        return new aa() { // from class: d.aa.1
            @Override // d.aa
            public u a() {
                return uVar;
            }

            @Override // d.aa
            public void a(e.d dVar) throws IOException {
                dVar.b(fVar);
            }

            @Override // d.aa
            public long b() throws IOException {
                return fVar.f();
            }
        };
    }

    public static aa a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static aa a(final u uVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        d.a.j.a(bArr.length, i, i2);
        return new aa() { // from class: d.aa.2
            @Override // d.aa
            public u a() {
                return uVar;
            }

            @Override // d.aa
            public void a(e.d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }

            @Override // d.aa
            public long b() {
                return i2;
            }
        };
    }

    public abstract u a();

    public abstract void a(e.d dVar) throws IOException;

    public long b() throws IOException {
        return -1L;
    }
}
