package e;

/* JADX INFO: loaded from: classes.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static q f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static long f6489b;

    private r() {
    }

    static q a() {
        synchronized (r.class) {
            if (f6488a == null) {
                return new q();
            }
            q qVar = f6488a;
            f6488a = qVar.f6487f;
            qVar.f6487f = null;
            f6489b -= 2048;
            return qVar;
        }
    }

    static void a(q qVar) {
        if (qVar.f6487f != null || qVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (qVar.f6485d) {
            return;
        }
        synchronized (r.class) {
            if (f6489b + 2048 <= 65536) {
                f6489b += 2048;
                qVar.f6487f = f6488a;
                qVar.f6484c = 0;
                qVar.f6483b = 0;
                f6488a = qVar;
            }
        }
    }
}
