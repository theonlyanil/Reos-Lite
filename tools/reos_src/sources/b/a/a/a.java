package b.a.a;

/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f1884a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f1885b;

    a(c cVar) {
        this.f1885b = cVar;
    }

    public void a(m mVar, Object obj) {
        this.f1884a.a(h.a(mVar, obj));
        this.f1885b.b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVarA = this.f1884a.a();
        if (hVarA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f1885b.a(hVarA);
    }
}
