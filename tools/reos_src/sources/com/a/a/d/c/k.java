package com.a.a.d.c;

import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class k<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.j.e<a<A>, B> f2199a;

    static final class a<A> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Queue<a<?>> f2201a = com.a.a.j.h.a(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private A f2204d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar = (a) f2201a.poll();
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.f2204d = a2;
            this.f2203c = i;
            this.f2202b = i2;
        }

        public void a() {
            f2201a.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2203c == aVar.f2203c && this.f2202b == aVar.f2202b && this.f2204d.equals(aVar.f2204d);
        }

        public int hashCode() {
            return (((this.f2202b * 31) + this.f2203c) * 31) + this.f2204d.hashCode();
        }
    }

    public k() {
        this(250);
    }

    public k(int i) {
        this.f2199a = new com.a.a.j.e<a<A>, B>(i) { // from class: com.a.a.d.c.k.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.a.a.j.e
            public void a(a<A> aVar, B b2) {
                aVar.a();
            }
        };
    }

    public B a(A a2, int i, int i2) {
        a<A> aVarA = a.a(a2, i, i2);
        B b2 = this.f2199a.b(aVarA);
        aVarA.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f2199a.b(a.a(a2, i, i2), b2);
    }
}
