package e;

/* JADX INFO: loaded from: classes.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f6482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f6486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    q f6487f;
    q g;

    q() {
        this.f6482a = new byte[2048];
        this.f6486e = true;
        this.f6485d = false;
    }

    q(q qVar) {
        this(qVar.f6482a, qVar.f6483b, qVar.f6484c);
        qVar.f6485d = true;
    }

    q(byte[] bArr, int i, int i2) {
        this.f6482a = bArr;
        this.f6483b = i;
        this.f6484c = i2;
        this.f6486e = false;
        this.f6485d = true;
    }

    public q a() {
        q qVar = this.f6487f != this ? this.f6487f : null;
        this.g.f6487f = this.f6487f;
        this.f6487f.g = this.g;
        this.f6487f = null;
        this.g = null;
        return qVar;
    }

    public q a(int i) {
        if (i <= 0 || i > this.f6484c - this.f6483b) {
            throw new IllegalArgumentException();
        }
        q qVar = new q(this);
        qVar.f6484c = qVar.f6483b + i;
        this.f6483b += i;
        this.g.a(qVar);
        return qVar;
    }

    public q a(q qVar) {
        qVar.g = this;
        qVar.f6487f = this.f6487f;
        this.f6487f.g = qVar;
        this.f6487f = qVar;
        return qVar;
    }

    public void a(q qVar, int i) {
        if (!qVar.f6486e) {
            throw new IllegalArgumentException();
        }
        if (qVar.f6484c + i > 2048) {
            if (qVar.f6485d) {
                throw new IllegalArgumentException();
            }
            if ((qVar.f6484c + i) - qVar.f6483b > 2048) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(qVar.f6482a, qVar.f6483b, qVar.f6482a, 0, qVar.f6484c - qVar.f6483b);
            qVar.f6484c -= qVar.f6483b;
            qVar.f6483b = 0;
        }
        System.arraycopy(this.f6482a, this.f6483b, qVar.f6482a, qVar.f6484c, i);
        qVar.f6484c += i;
        this.f6483b += i;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.f6486e) {
            int i = this.f6484c - this.f6483b;
            if (i <= (this.g.f6485d ? 0 : this.g.f6483b) + (2048 - this.g.f6484c)) {
                a(this.g, i);
                a();
                r.a(this);
            }
        }
    }
}
