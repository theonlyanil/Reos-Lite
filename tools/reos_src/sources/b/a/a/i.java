package b.a.a;

/* JADX INFO: loaded from: classes.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1920b;

    i() {
    }

    synchronized h a() {
        h hVar;
        hVar = this.f1919a;
        if (this.f1919a != null) {
            this.f1919a = this.f1919a.f1918c;
            if (this.f1919a == null) {
                this.f1920b = null;
            }
        }
        return hVar;
    }

    synchronized h a(int i) throws InterruptedException {
        if (this.f1919a == null) {
            wait(i);
        }
        return a();
    }

    synchronized void a(h hVar) {
        try {
            if (hVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f1920b != null) {
                this.f1920b.f1918c = hVar;
                this.f1920b = hVar;
            } else {
                if (this.f1919a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f1920b = hVar;
                this.f1919a = hVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }
}
