package d.a.a;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f6054a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6055b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6056c = -1;

    l() {
    }

    void a() {
        if (this.f6055b != -1) {
            throw new IllegalStateException();
        }
        this.f6055b = System.nanoTime();
    }

    void b() {
        if (this.f6056c != -1 || this.f6055b == -1) {
            throw new IllegalStateException();
        }
        this.f6056c = System.nanoTime();
        this.f6054a.countDown();
    }

    void c() {
        if (this.f6056c != -1 || this.f6055b == -1) {
            throw new IllegalStateException();
        }
        this.f6056c = this.f6055b - 1;
        this.f6054a.countDown();
    }
}
