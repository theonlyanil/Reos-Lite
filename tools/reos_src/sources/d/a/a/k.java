package d.a.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.m f6049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e f6051c;

    public k(e.e eVar) {
        this.f6049a = new e.m(new e.i(eVar) { // from class: d.a.a.k.1
            @Override // e.i, e.t
            public long a(e.c cVar, long j) throws IOException {
                if (k.this.f6050b == 0) {
                    return -1L;
                }
                long jA = super.a(cVar, Math.min(j, k.this.f6050b));
                if (jA == -1) {
                    return -1L;
                }
                k.this.f6050b = (int) (((long) k.this.f6050b) - jA);
                return jA;
            }
        }, new Inflater() { // from class: d.a.a.k.2
            @Override // java.util.zip.Inflater
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int iInflate = super.inflate(bArr, i, i2);
                if (iInflate != 0 || !needsDictionary()) {
                    return iInflate;
                }
                setDictionary(o.f6062a);
                return super.inflate(bArr, i, i2);
            }
        });
        this.f6051c = e.n.a(this.f6049a);
    }

    private e.f b() throws IOException {
        return this.f6051c.c(this.f6051c.l());
    }

    private void c() throws IOException {
        if (this.f6050b > 0) {
            this.f6049a.b();
            if (this.f6050b != 0) {
                throw new IOException("compressedLimit > 0: " + this.f6050b);
            }
        }
    }

    public List<f> a(int i) throws IOException {
        this.f6050b += i;
        int iL = this.f6051c.l();
        if (iL < 0) {
            throw new IOException("numberOfPairs < 0: " + iL);
        }
        if (iL > 1024) {
            throw new IOException("numberOfPairs > 1024: " + iL);
        }
        ArrayList arrayList = new ArrayList(iL);
        for (int i2 = 0; i2 < iL; i2++) {
            e.f fVarE = b().e();
            e.f fVarB = b();
            if (fVarE.f() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new f(fVarE, fVarB));
        }
        c();
        return arrayList;
    }

    public void a() throws IOException {
        this.f6051c.close();
    }
}
