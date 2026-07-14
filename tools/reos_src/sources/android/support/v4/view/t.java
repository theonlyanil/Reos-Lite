package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f937a;

    static class a implements e {
        a() {
        }

        @Override // android.support.v4.view.t.e
        public int a(MotionEvent motionEvent) {
            return 1;
        }

        @Override // android.support.v4.view.t.e
        public int a(MotionEvent motionEvent, int i) {
            return i == 0 ? 0 : -1;
        }

        @Override // android.support.v4.view.t.e
        public int b(MotionEvent motionEvent) {
            return 0;
        }

        @Override // android.support.v4.view.t.e
        public int b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.t.e
        public float c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.t.e
        public float d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // android.support.v4.view.t.e
        public float e(MotionEvent motionEvent, int i) {
            return BitmapDescriptorFactory.HUE_RED;
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public int a(MotionEvent motionEvent) {
            return u.a(motionEvent);
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public int a(MotionEvent motionEvent, int i) {
            return u.a(motionEvent, i);
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public int b(MotionEvent motionEvent, int i) {
            return u.b(motionEvent, i);
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public float c(MotionEvent motionEvent, int i) {
            return u.c(motionEvent, i);
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public float d(MotionEvent motionEvent, int i) {
            return u.d(motionEvent, i);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public int b(MotionEvent motionEvent) {
            return v.a(motionEvent);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.view.t.a, android.support.v4.view.t.e
        public float e(MotionEvent motionEvent, int i) {
            return w.a(motionEvent, i);
        }
    }

    interface e {
        int a(MotionEvent motionEvent);

        int a(MotionEvent motionEvent, int i);

        int b(MotionEvent motionEvent);

        int b(MotionEvent motionEvent, int i);

        float c(MotionEvent motionEvent, int i);

        float d(MotionEvent motionEvent, int i);

        float e(MotionEvent motionEvent, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f937a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            f937a = new c();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f937a = new b();
        } else {
            f937a = new a();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return f937a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int b(MotionEvent motionEvent, int i) {
        return f937a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return f937a.c(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return f937a.a(motionEvent);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return f937a.d(motionEvent, i);
    }

    public static int d(MotionEvent motionEvent) {
        return f937a.b(motionEvent);
    }

    public static float e(MotionEvent motionEvent, int i) {
        return f937a.e(motionEvent, i);
    }
}
