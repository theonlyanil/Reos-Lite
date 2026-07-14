package d;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f6310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f6311d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d.a.i f6312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6313b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f6315f;
    private final Runnable g;
    private final Deque<d.a.c.b> h;

    static {
        f6310c = !j.class.desiredAssertionStatus();
        f6311d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.a.j.a("OkHttp ConnectionPool", true));
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: d.j.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jA = j.this.a(System.nanoTime());
                    if (jA == -1) {
                        return;
                    }
                    if (jA > 0) {
                        long j2 = jA / 1000000;
                        long j3 = jA - (j2 * 1000000);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j2, (int) j3);
                            } catch (InterruptedException e2) {
                            }
                        }
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.f6312a = new d.a.i();
        this.f6314e = i;
        this.f6315f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    private int a(d.a.c.b bVar, long j) {
        List<Reference<d.a.b.r>> list = bVar.h;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).get() != null) {
                i++;
            } else {
                d.a.d.f6186a.warning("A connection to " + bVar.a().a().a() + " was leaked. Did you forget to close a response body?");
                list.remove(i);
                bVar.i = true;
                if (list.isEmpty()) {
                    bVar.j = j - this.f6315f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j) {
        d.a.c.b bVar;
        long j2;
        d.a.c.b bVar2 = null;
        long j3 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (d.a.c.b bVar3 : this.h) {
                if (a(bVar3, j) > 0) {
                    i2++;
                } else {
                    int i3 = i + 1;
                    long j4 = j - bVar3.j;
                    if (j4 > j3) {
                        bVar = bVar3;
                        j2 = j4;
                    } else {
                        bVar = bVar2;
                        j2 = j3;
                    }
                    j3 = j2;
                    bVar2 = bVar;
                    i = i3;
                }
            }
            if (j3 >= this.f6315f || i > this.f6314e) {
                this.h.remove(bVar2);
                d.a.j.a(bVar2.c());
                return 0L;
            }
            if (i > 0) {
                return this.f6315f - j3;
            }
            if (i2 > 0) {
                return this.f6315f;
            }
            this.f6313b = false;
            return -1L;
        }
    }

    d.a.c.b a(a aVar, d.a.b.r rVar) {
        if (!f6310c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (d.a.c.b bVar : this.h) {
            if (bVar.h.size() < bVar.g && aVar.equals(bVar.a().f6247a) && !bVar.i) {
                rVar.a(bVar);
                return bVar;
            }
        }
        return null;
    }

    void a(d.a.c.b bVar) {
        if (!f6310c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f6313b) {
            this.f6313b = true;
            f6311d.execute(this.g);
        }
        this.h.add(bVar);
    }

    boolean b(d.a.c.b bVar) {
        if (!f6310c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (bVar.i || this.f6314e == 0) {
            this.h.remove(bVar);
            return true;
        }
        notifyAll();
        return false;
    }
}
