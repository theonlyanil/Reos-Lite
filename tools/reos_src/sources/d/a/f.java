package d.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class f implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f6199b;

    public f(String str, Object... objArr) {
        this.f6199b = String.format(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f6199b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
