package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f930a;

    static class a implements d {
        a() {
        }

        private static int a(int i, int i2, int i3, int i4, int i5) {
            boolean z = (i2 & i3) != 0;
            int i6 = i4 | i5;
            boolean z2 = (i2 & i6) != 0;
            if (!z) {
                return z2 ? i & (i3 ^ (-1)) : i;
            }
            if (z2) {
                throw new IllegalArgumentException("bad arguments");
            }
            return i & (i6 ^ (-1));
        }

        public int a(int i) {
            int i2 = (i & 192) != 0 ? i | 1 : i;
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        @Override // android.support.v4.view.g.d
        public void a(KeyEvent keyEvent) {
        }

        @Override // android.support.v4.view.g.d
        public boolean a(int i, int i2) {
            return a(a(a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
        }

        @Override // android.support.v4.view.g.d
        public boolean b(int i) {
            return (a(i) & 247) == 0;
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.view.g.a, android.support.v4.view.g.d
        public void a(KeyEvent keyEvent) {
            h.a(keyEvent);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.g.a
        public int a(int i) {
            return i.a(i);
        }

        @Override // android.support.v4.view.g.a, android.support.v4.view.g.d
        public boolean a(int i, int i2) {
            return i.a(i, i2);
        }

        @Override // android.support.v4.view.g.a, android.support.v4.view.g.d
        public boolean b(int i) {
            return i.b(i);
        }
    }

    interface d {
        void a(KeyEvent keyEvent);

        boolean a(int i, int i2);

        boolean b(int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f930a = new c();
        } else {
            f930a = new a();
        }
    }

    public static boolean a(KeyEvent keyEvent) {
        return f930a.b(keyEvent.getMetaState());
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f930a.a(keyEvent.getMetaState(), i);
    }

    public static void b(KeyEvent keyEvent) {
        f930a.a(keyEvent);
    }
}
