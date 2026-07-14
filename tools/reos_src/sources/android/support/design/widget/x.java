package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f513a;

    private interface a {
        void a(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class b implements a {
        private b() {
        }

        @Override // android.support.design.widget.x.a
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class c implements a {
        private c() {
        }

        @Override // android.support.design.widget.x.a
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            y.a(viewGroup, view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f513a = new c();
        } else {
            f513a = new b();
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        f513a.a(viewGroup, view, rect);
    }

    static void b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a(viewGroup, view, rect);
    }
}
