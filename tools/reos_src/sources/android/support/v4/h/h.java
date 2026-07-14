package android.support.v4.h;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    public interface a<T> {
        T a();

        boolean a(T t);
    }

    public static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f815b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f814a = new Object[i];
        }

        private boolean b(T t) {
            for (int i = 0; i < this.f815b; i++) {
                if (this.f814a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.support.v4.h.h.a
        public T a() {
            if (this.f815b <= 0) {
                return null;
            }
            int i = this.f815b - 1;
            T t = (T) this.f814a[i];
            this.f814a[i] = null;
            this.f815b--;
            return t;
        }

        @Override // android.support.v4.h.h.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.f815b >= this.f814a.length) {
                return false;
            }
            this.f814a[this.f815b] = t;
            this.f815b++;
            return true;
        }
    }

    public static class c<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f816a;

        public c(int i) {
            super(i);
            this.f816a = new Object();
        }

        @Override // android.support.v4.h.h.b, android.support.v4.h.h.a
        public T a() {
            T t;
            synchronized (this.f816a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // android.support.v4.h.h.b, android.support.v4.h.h.a
        public boolean a(T t) {
            boolean zA;
            synchronized (this.f816a) {
                zA = super.a(t);
            }
            return zA;
        }
    }
}
