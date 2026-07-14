package android.support.v7.widget;

/* JADX INFO: loaded from: classes.dex */
class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.support.v4.h.a<RecyclerView.u, a> f1762a = new android.support.v4.h.a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.support.v4.h.e<RecyclerView.u> f1763b = new android.support.v4.h.e<>();

    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static android.support.v4.h.h.a<a> f1764d = new android.support.v4.h.h.b(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.e.c f1766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.e.c f1767c;

        private a() {
        }

        static a a() {
            a aVarA = f1764d.a();
            return aVarA == null ? new a() : aVarA;
        }

        static void a(a aVar) {
            aVar.f1765a = 0;
            aVar.f1766b = null;
            aVar.f1767c = null;
            f1764d.a(aVar);
        }

        static void b() {
            while (f1764d.a() != null) {
            }
        }
    }

    interface b {
        void a(RecyclerView.u uVar);

        void a(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void b(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void c(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);
    }

    as() {
    }

    private RecyclerView.e.c a(RecyclerView.u uVar, int i) {
        a aVarC;
        RecyclerView.e.c cVar = null;
        int iA = this.f1762a.a(uVar);
        if (iA >= 0 && (aVarC = this.f1762a.c(iA)) != null && (aVarC.f1765a & i) != 0) {
            aVarC.f1765a &= i ^ (-1);
            if (i == 4) {
                cVar = aVarC.f1766b;
            } else {
                if (i != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                cVar = aVarC.f1767c;
            }
            if ((aVarC.f1765a & 12) == 0) {
                this.f1762a.d(iA);
                a.a(aVarC);
            }
        }
        return cVar;
    }

    RecyclerView.u a(long j) {
        return this.f1763b.a(j);
    }

    void a() {
        this.f1762a.clear();
        this.f1763b.c();
    }

    void a(long j, RecyclerView.u uVar) {
        this.f1763b.b(j, uVar);
    }

    void a(RecyclerView.u uVar, RecyclerView.e.c cVar) {
        a aVarA = this.f1762a.get(uVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1762a.put(uVar, aVarA);
        }
        aVarA.f1766b = cVar;
        aVarA.f1765a |= 4;
    }

    void a(b bVar) {
        for (int size = this.f1762a.size() - 1; size >= 0; size--) {
            RecyclerView.u uVarB = this.f1762a.b(size);
            a aVarD = this.f1762a.d(size);
            if ((aVarD.f1765a & 3) == 3) {
                bVar.a(uVarB);
            } else if ((aVarD.f1765a & 1) != 0) {
                if (aVarD.f1766b == null) {
                    bVar.a(uVarB);
                } else {
                    bVar.a(uVarB, aVarD.f1766b, aVarD.f1767c);
                }
            } else if ((aVarD.f1765a & 14) == 14) {
                bVar.b(uVarB, aVarD.f1766b, aVarD.f1767c);
            } else if ((aVarD.f1765a & 12) == 12) {
                bVar.c(uVarB, aVarD.f1766b, aVarD.f1767c);
            } else if ((aVarD.f1765a & 4) != 0) {
                bVar.a(uVarB, aVarD.f1766b, null);
            } else if ((aVarD.f1765a & 8) != 0) {
                bVar.b(uVarB, aVarD.f1766b, aVarD.f1767c);
            } else if ((aVarD.f1765a & 2) != 0) {
            }
            a.a(aVarD);
        }
    }

    boolean a(RecyclerView.u uVar) {
        a aVar = this.f1762a.get(uVar);
        return (aVar == null || (aVar.f1765a & 1) == 0) ? false : true;
    }

    RecyclerView.e.c b(RecyclerView.u uVar) {
        return a(uVar, 4);
    }

    void b() {
        a.b();
    }

    void b(RecyclerView.u uVar, RecyclerView.e.c cVar) {
        a aVarA = this.f1762a.get(uVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1762a.put(uVar, aVarA);
        }
        aVarA.f1765a |= 2;
        aVarA.f1766b = cVar;
    }

    RecyclerView.e.c c(RecyclerView.u uVar) {
        return a(uVar, 8);
    }

    void c(RecyclerView.u uVar, RecyclerView.e.c cVar) {
        a aVarA = this.f1762a.get(uVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1762a.put(uVar, aVarA);
        }
        aVarA.f1767c = cVar;
        aVarA.f1765a |= 8;
    }

    boolean d(RecyclerView.u uVar) {
        a aVar = this.f1762a.get(uVar);
        return (aVar == null || (aVar.f1765a & 4) == 0) ? false : true;
    }

    void e(RecyclerView.u uVar) {
        a aVarA = this.f1762a.get(uVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1762a.put(uVar, aVarA);
        }
        aVarA.f1765a |= 1;
    }

    void f(RecyclerView.u uVar) {
        a aVar = this.f1762a.get(uVar);
        if (aVar == null) {
            return;
        }
        aVar.f1765a &= -2;
    }

    void g(RecyclerView.u uVar) {
        for (int iB = this.f1763b.b() - 1; iB >= 0; iB--) {
            if (uVar == this.f1763b.c(iB)) {
                this.f1763b.a(iB);
                break;
            }
        }
        a aVarRemove = this.f1762a.remove(uVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    public void h(RecyclerView.u uVar) {
        f(uVar);
    }
}
