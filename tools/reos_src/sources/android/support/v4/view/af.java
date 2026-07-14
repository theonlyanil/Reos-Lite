package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c f886a;

    static class a implements c {
        a() {
        }

        @Override // android.support.v4.view.af.c
        public float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        @Override // android.support.v4.view.af.c
        public float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b implements c {
        b() {
        }

        @Override // android.support.v4.view.af.c
        public float a(VelocityTracker velocityTracker, int i) {
            return ag.a(velocityTracker, i);
        }

        @Override // android.support.v4.view.af.c
        public float b(VelocityTracker velocityTracker, int i) {
            return ag.b(velocityTracker, i);
        }
    }

    interface c {
        float a(VelocityTracker velocityTracker, int i);

        float b(VelocityTracker velocityTracker, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f886a = new b();
        } else {
            f886a = new a();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return f886a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return f886a.b(velocityTracker, i);
    }
}
