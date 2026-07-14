package d;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f6336c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6334a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6335b = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Deque<y.b> f6337d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<y.b> f6338e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<y> f6339f = new ArrayDeque();

    private void b() {
        if (this.f6338e.size() < this.f6334a && !this.f6337d.isEmpty()) {
            Iterator<y.b> it = this.f6337d.iterator();
            while (it.hasNext()) {
                y.b next = it.next();
                if (c(next) < this.f6335b) {
                    it.remove();
                    this.f6338e.add(next);
                    a().execute(next);
                }
                if (this.f6338e.size() >= this.f6334a) {
                    return;
                }
            }
        }
    }

    private int c(y.b bVar) {
        int i = 0;
        Iterator<y.b> it = this.f6338e.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().a().equals(bVar.a()) ? i2 + 1 : i2;
        }
    }

    public synchronized ExecutorService a() {
        if (this.f6336c == null) {
            this.f6336c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.a.j.a("OkHttp Dispatcher", false));
        }
        return this.f6336c;
    }

    synchronized void a(y.b bVar) {
        if (this.f6338e.size() >= this.f6334a || c(bVar) >= this.f6335b) {
            this.f6337d.add(bVar);
        } else {
            this.f6338e.add(bVar);
            a().execute(bVar);
        }
    }

    synchronized void b(y.b bVar) {
        if (!this.f6338e.remove(bVar)) {
            throw new AssertionError("AsyncCall wasn't running!");
        }
        b();
    }
}
