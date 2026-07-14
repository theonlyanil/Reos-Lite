package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f854a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f855c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f856b = f854a.a(this);

    /* JADX INFO: renamed from: android.support.v4.view.a$a, reason: collision with other inner class name */
    static class C0020a extends d {
        C0020a() {
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public Object a() {
            return android.support.v4.view.b.a();
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public Object a(final a aVar) {
            return android.support.v4.view.b.a(new android.support.v4.view.b.a() { // from class: android.support.v4.view.a.a.1
                @Override // android.support.v4.view.b.a
                public void a(View view, int i) {
                    aVar.a(view, i);
                }

                @Override // android.support.v4.view.b.a
                public void a(View view, Object obj) {
                    aVar.a(view, new android.support.v4.view.a.c(obj));
                }

                @Override // android.support.v4.view.b.a
                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.d(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.b.a
                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.support.v4.view.b.a
                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.a(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.b.a
                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.b(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.b.a
                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.c(view, accessibilityEvent);
                }
            });
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public void a(Object obj, View view, int i) {
            android.support.v4.view.b.a(obj, view, i);
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public void a(Object obj, View view, android.support.v4.view.a.c cVar) {
            android.support.v4.view.b.a(obj, view, cVar.a());
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return android.support.v4.view.b.a(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return android.support.v4.view.b.a(obj, viewGroup, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            android.support.v4.view.b.b(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            android.support.v4.view.b.c(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            android.support.v4.view.b.d(obj, view, accessibilityEvent);
        }
    }

    interface b {
        android.support.v4.view.a.j a(Object obj, View view);

        Object a();

        Object a(a aVar);

        void a(Object obj, View view, int i);

        void a(Object obj, View view, android.support.v4.view.a.c cVar);

        boolean a(Object obj, View view, int i, Bundle bundle);

        boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class c extends C0020a {
        c() {
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public android.support.v4.view.a.j a(Object obj, View view) {
            Object objA = android.support.v4.view.c.a(obj, view);
            if (objA != null) {
                return new android.support.v4.view.a.j(objA);
            }
            return null;
        }

        @Override // android.support.v4.view.a.C0020a, android.support.v4.view.a.d, android.support.v4.view.a.b
        public Object a(final a aVar) {
            return android.support.v4.view.c.a(new android.support.v4.view.c.a() { // from class: android.support.v4.view.a.c.1
                @Override // android.support.v4.view.c.a
                public Object a(View view) {
                    android.support.v4.view.a.j jVarA = aVar.a(view);
                    if (jVarA != null) {
                        return jVarA.a();
                    }
                    return null;
                }

                @Override // android.support.v4.view.c.a
                public void a(View view, int i) {
                    aVar.a(view, i);
                }

                @Override // android.support.v4.view.c.a
                public void a(View view, Object obj) {
                    aVar.a(view, new android.support.v4.view.a.c(obj));
                }

                @Override // android.support.v4.view.c.a
                public boolean a(View view, int i, Bundle bundle) {
                    return aVar.a(view, i, bundle);
                }

                @Override // android.support.v4.view.c.a
                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.d(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.c.a
                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.support.v4.view.c.a
                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.a(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.c.a
                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.b(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.c.a
                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.c(view, accessibilityEvent);
                }
            });
        }

        @Override // android.support.v4.view.a.d, android.support.v4.view.a.b
        public boolean a(Object obj, View view, int i, Bundle bundle) {
            return android.support.v4.view.c.a(obj, view, i, bundle);
        }
    }

    static class d implements b {
        d() {
        }

        @Override // android.support.v4.view.a.b
        public android.support.v4.view.a.j a(Object obj, View view) {
            return null;
        }

        @Override // android.support.v4.view.a.b
        public Object a() {
            return null;
        }

        @Override // android.support.v4.view.a.b
        public Object a(a aVar) {
            return null;
        }

        @Override // android.support.v4.view.a.b
        public void a(Object obj, View view, int i) {
        }

        @Override // android.support.v4.view.a.b
        public void a(Object obj, View view, android.support.v4.view.a.c cVar) {
        }

        @Override // android.support.v4.view.a.b
        public boolean a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }

        @Override // android.support.v4.view.a.b
        public boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        @Override // android.support.v4.view.a.b
        public boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        @Override // android.support.v4.view.a.b
        public void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.a.b
        public void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.a.b
        public void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f854a = new c();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f854a = new C0020a();
        } else {
            f854a = new d();
        }
        f855c = f854a.a();
    }

    public android.support.v4.view.a.j a(View view) {
        return f854a.a(f855c, view);
    }

    Object a() {
        return this.f856b;
    }

    public void a(View view, int i) {
        f854a.a(f855c, view, i);
    }

    public void a(View view, android.support.v4.view.a.c cVar) {
        f854a.a(f855c, view, cVar);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        f854a.b(f855c, view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return f854a.a(f855c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f854a.a(f855c, viewGroup, view, accessibilityEvent);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        f854a.c(f855c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        f854a.d(f855c, view, accessibilityEvent);
    }

    public boolean d(View view, AccessibilityEvent accessibilityEvent) {
        return f854a.a(f855c, view, accessibilityEvent);
    }
}
