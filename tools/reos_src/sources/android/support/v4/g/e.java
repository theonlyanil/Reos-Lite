package android.support.v4.g;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final android.support.v4.g.d f770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final android.support.v4.g.d f771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final android.support.v4.g.d f772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final android.support.v4.g.d f773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final android.support.v4.g.d f774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final android.support.v4.g.d f775f = f.f782a;

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f776a = new a(true);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f777b = new a(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f778c;

        private a(boolean z) {
            this.f778c = z;
        }

        @Override // android.support.v4.g.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (e.c(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.f778c) {
                            return 0;
                        }
                        z = true;
                        break;
                    case 1:
                        if (!this.f778c) {
                            return 1;
                        }
                        z = true;
                        break;
                        break;
                }
                i++;
            }
            if (z) {
                return !this.f778c ? 0 : 1;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f779a = new b();

        private b() {
        }

        @Override // android.support.v4.g.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int iD = 2;
            while (i < i3 && iD == 2) {
                iD = e.d(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iD;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static abstract class d implements android.support.v4.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f780a;

        public d(c cVar) {
            this.f780a = cVar;
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.f780a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }

        protected abstract boolean a();

        @Override // android.support.v4.g.d
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f780a == null ? a() : b(charSequence, i, i2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.e$e, reason: collision with other inner class name */
    private static class C0019e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f781a;

        private C0019e(c cVar, boolean z) {
            super(cVar);
            this.f781a = z;
        }

        @Override // android.support.v4.g.e.d
        protected boolean a() {
            return this.f781a;
        }
    }

    private static class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f782a = new f();

        public f() {
            super(null);
        }

        @Override // android.support.v4.g.e.d
        protected boolean a() {
            return android.support.v4.g.f.a(Locale.getDefault()) == 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z = true;
        boolean z2 = false;
        f770a = new C0019e(null, z2);
        f771b = new C0019e(0 == true ? 1 : 0, z);
        f772c = new C0019e(b.f779a, z2);
        f773d = new C0019e(b.f779a, z);
        f774e = new C0019e(a.f776a, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
