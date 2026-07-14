package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.a f5558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f5559b;

    j(com.google.b.c.a aVar) {
        this.f5558a = aVar;
        this.f5559b = new s(aVar);
    }

    public static j a(com.google.b.c.a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        switch (s.a(aVar, 1, 4)) {
            case 4:
                return new a(aVar);
            case 5:
                return new b(aVar);
            default:
                switch (s.a(aVar, 1, 5)) {
                    case 12:
                        return new c(aVar);
                    case 13:
                        return new d(aVar);
                    default:
                        switch (s.a(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", "11");
                            case 57:
                                return new e(aVar, "320", "11");
                            case 58:
                                return new e(aVar, "310", "13");
                            case 59:
                                return new e(aVar, "320", "13");
                            case 60:
                                return new e(aVar, "310", "15");
                            case 61:
                                return new e(aVar, "320", "15");
                            case 62:
                                return new e(aVar, "310", "17");
                            case 63:
                                return new e(aVar, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + aVar);
                        }
                }
        }
    }

    public abstract String a() throws com.google.b.i, com.google.b.f;

    protected final com.google.b.c.a b() {
        return this.f5558a;
    }

    protected final s c() {
        return this.f5559b;
    }
}
