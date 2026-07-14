package android.support.v7.widget;

import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v extends ai {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<RecyclerView.u> f1835b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<RecyclerView.u> f1836c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<b> f1837d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<a> f1838e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<ArrayList<RecyclerView.u>> f1839f = new ArrayList<>();
    private ArrayList<ArrayList<b>> g = new ArrayList<>();
    private ArrayList<ArrayList<a>> h = new ArrayList<>();
    private ArrayList<RecyclerView.u> i = new ArrayList<>();
    private ArrayList<RecyclerView.u> j = new ArrayList<>();
    private ArrayList<RecyclerView.u> k = new ArrayList<>();
    private ArrayList<RecyclerView.u> l = new ArrayList<>();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.u f1864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.u f1865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1869f;

        private a(RecyclerView.u uVar, RecyclerView.u uVar2) {
            this.f1864a = uVar;
            this.f1865b = uVar2;
        }

        private a(RecyclerView.u uVar, RecyclerView.u uVar2, int i, int i2, int i3, int i4) {
            this(uVar, uVar2);
            this.f1866c = i;
            this.f1867d = i2;
            this.f1868e = i3;
            this.f1869f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1864a + ", newHolder=" + this.f1865b + ", fromX=" + this.f1866c + ", fromY=" + this.f1867d + ", toX=" + this.f1868e + ", toY=" + this.f1869f + '}';
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.u f1870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1874e;

        private b(RecyclerView.u uVar, int i, int i2, int i3, int i4) {
            this.f1870a = uVar;
            this.f1871b = i;
            this.f1872c = i2;
            this.f1873d = i3;
            this.f1874e = i4;
        }
    }

    private static class c implements be {
        private c() {
        }

        @Override // android.support.v4.view.be
        public void a(View view) {
        }

        @Override // android.support.v4.view.be
        public void b(View view) {
        }

        @Override // android.support.v4.view.be
        public void c(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        RecyclerView.u uVar = aVar.f1864a;
        View view = uVar == null ? null : uVar.f1584a;
        RecyclerView.u uVar2 = aVar.f1865b;
        final View view2 = uVar2 != null ? uVar2.f1584a : null;
        if (view != null) {
            final ba baVarA = android.support.v4.view.ah.s(view).a(g());
            this.l.add(aVar.f1864a);
            baVarA.b(aVar.f1868e - aVar.f1866c);
            baVarA.c(aVar.f1869f - aVar.f1867d);
            baVarA.a(BitmapDescriptorFactory.HUE_RED).a(new c() { // from class: android.support.v7.widget.v.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.support.v7.widget.v.c, android.support.v4.view.be
                public void a(View view3) {
                    v.this.b(aVar.f1864a, true);
                }

                @Override // android.support.v7.widget.v.c, android.support.v4.view.be
                public void b(View view3) {
                    baVarA.a((be) null);
                    android.support.v4.view.ah.c(view3, 1.0f);
                    android.support.v4.view.ah.a(view3, BitmapDescriptorFactory.HUE_RED);
                    android.support.v4.view.ah.b(view3, BitmapDescriptorFactory.HUE_RED);
                    v.this.a(aVar.f1864a, true);
                    v.this.l.remove(aVar.f1864a);
                    v.this.j();
                }
            }).c();
        }
        if (view2 != null) {
            final ba baVarS = android.support.v4.view.ah.s(view2);
            this.l.add(aVar.f1865b);
            baVarS.b(BitmapDescriptorFactory.HUE_RED).c(BitmapDescriptorFactory.HUE_RED).a(g()).a(1.0f).a(new c() { // from class: android.support.v7.widget.v.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.support.v7.widget.v.c, android.support.v4.view.be
                public void a(View view3) {
                    v.this.b(aVar.f1865b, false);
                }

                @Override // android.support.v7.widget.v.c, android.support.v4.view.be
                public void b(View view3) {
                    baVarS.a((be) null);
                    android.support.v4.view.ah.c(view2, 1.0f);
                    android.support.v4.view.ah.a(view2, BitmapDescriptorFactory.HUE_RED);
                    android.support.v4.view.ah.b(view2, BitmapDescriptorFactory.HUE_RED);
                    v.this.a(aVar.f1865b, false);
                    v.this.l.remove(aVar.f1865b);
                    v.this.j();
                }
            }).c();
        }
    }

    private void a(List<a> list, RecyclerView.u uVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, uVar) && aVar.f1864a == null && aVar.f1865b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, RecyclerView.u uVar) {
        boolean z = false;
        if (aVar.f1865b == uVar) {
            aVar.f1865b = null;
        } else {
            if (aVar.f1864a != uVar) {
                return false;
            }
            aVar.f1864a = null;
            z = true;
        }
        android.support.v4.view.ah.c(uVar.f1584a, 1.0f);
        android.support.v4.view.ah.a(uVar.f1584a, BitmapDescriptorFactory.HUE_RED);
        android.support.v4.view.ah.b(uVar.f1584a, BitmapDescriptorFactory.HUE_RED);
        a(uVar, z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final RecyclerView.u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.f1584a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            android.support.v4.view.ah.s(view).b(BitmapDescriptorFactory.HUE_RED);
        }
        if (i6 != 0) {
            android.support.v4.view.ah.s(view).c(BitmapDescriptorFactory.HUE_RED);
        }
        final ba baVarS = android.support.v4.view.ah.s(view);
        this.j.add(uVar);
        baVarS.a(d()).a(new c() { // from class: android.support.v7.widget.v.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void a(View view2) {
                v.this.l(uVar);
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void b(View view2) {
                baVarS.a((be) null);
                v.this.i(uVar);
                v.this.j.remove(uVar);
                v.this.j();
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void c(View view2) {
                if (i5 != 0) {
                    android.support.v4.view.ah.a(view2, BitmapDescriptorFactory.HUE_RED);
                }
                if (i6 != 0) {
                    android.support.v4.view.ah.b(view2, BitmapDescriptorFactory.HUE_RED);
                }
            }
        }).c();
    }

    private void b(a aVar) {
        if (aVar.f1864a != null) {
            a(aVar, aVar.f1864a);
        }
        if (aVar.f1865b != null) {
            a(aVar, aVar.f1865b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (b()) {
            return;
        }
        h();
    }

    private void t(final RecyclerView.u uVar) {
        final ba baVarS = android.support.v4.view.ah.s(uVar.f1584a);
        this.k.add(uVar);
        baVarS.a(f()).a(BitmapDescriptorFactory.HUE_RED).a(new c() { // from class: android.support.v7.widget.v.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void a(View view) {
                v.this.k(uVar);
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void b(View view) {
                baVarS.a((be) null);
                android.support.v4.view.ah.c(view, 1.0f);
                v.this.h(uVar);
                v.this.k.remove(uVar);
                v.this.j();
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final RecyclerView.u uVar) {
        final ba baVarS = android.support.v4.view.ah.s(uVar.f1584a);
        this.i.add(uVar);
        baVarS.a(1.0f).a(e()).a(new c() { // from class: android.support.v7.widget.v.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void a(View view) {
                v.this.m(uVar);
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void b(View view) {
                baVarS.a((be) null);
                v.this.j(uVar);
                v.this.i.remove(uVar);
                v.this.j();
            }

            @Override // android.support.v7.widget.v.c, android.support.v4.view.be
            public void c(View view) {
                android.support.v4.view.ah.c(view, 1.0f);
            }
        }).c();
    }

    private void v(RecyclerView.u uVar) {
        android.support.v4.a.a.a(uVar.f1584a);
        c(uVar);
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void a() {
        boolean z = !this.f1835b.isEmpty();
        boolean z2 = !this.f1837d.isEmpty();
        boolean z3 = !this.f1838e.isEmpty();
        boolean z4 = !this.f1836c.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.u> it = this.f1835b.iterator();
            while (it.hasNext()) {
                t(it.next());
            }
            this.f1835b.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1837d);
                this.g.add(arrayList);
                this.f1837d.clear();
                Runnable runnable = new Runnable() { // from class: android.support.v7.widget.v.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (b bVar : arrayList) {
                            v.this.b(bVar.f1870a, bVar.f1871b, bVar.f1872c, bVar.f1873d, bVar.f1874e);
                        }
                        arrayList.clear();
                        v.this.g.remove(arrayList);
                    }
                };
                if (z) {
                    android.support.v4.view.ah.a(arrayList.get(0).f1870a.f1584a, runnable, f());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1838e);
                this.h.add(arrayList2);
                this.f1838e.clear();
                Runnable runnable2 = new Runnable() { // from class: android.support.v7.widget.v.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            v.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        v.this.h.remove(arrayList2);
                    }
                };
                if (z) {
                    android.support.v4.view.ah.a(arrayList2.get(0).f1864a.f1584a, runnable2, f());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.u> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1836c);
                this.f1839f.add(arrayList3);
                this.f1836c.clear();
                Runnable runnable3 = new Runnable() { // from class: android.support.v7.widget.v.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            v.this.u((RecyclerView.u) it2.next());
                        }
                        arrayList3.clear();
                        v.this.f1839f.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    android.support.v4.view.ah.a(arrayList3.get(0).f1584a, runnable3, (z ? f() : 0L) + Math.max(z2 ? d() : 0L, z3 ? g() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    void a(List<RecyclerView.u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            android.support.v4.view.ah.s(list.get(size).f1584a).b();
        }
    }

    @Override // android.support.v7.widget.ai
    public boolean a(RecyclerView.u uVar) {
        v(uVar);
        this.f1835b.add(uVar);
        return true;
    }

    @Override // android.support.v7.widget.ai
    public boolean a(RecyclerView.u uVar, int i, int i2, int i3, int i4) {
        View view = uVar.f1584a;
        int iO = (int) (i + android.support.v4.view.ah.o(uVar.f1584a));
        int iP = (int) (i2 + android.support.v4.view.ah.p(uVar.f1584a));
        v(uVar);
        int i5 = i3 - iO;
        int i6 = i4 - iP;
        if (i5 == 0 && i6 == 0) {
            i(uVar);
            return false;
        }
        if (i5 != 0) {
            android.support.v4.view.ah.a(view, -i5);
        }
        if (i6 != 0) {
            android.support.v4.view.ah.b(view, -i6);
        }
        this.f1837d.add(new b(uVar, iO, iP, i3, i4));
        return true;
    }

    @Override // android.support.v7.widget.ai
    public boolean a(RecyclerView.u uVar, RecyclerView.u uVar2, int i, int i2, int i3, int i4) {
        if (uVar == uVar2) {
            return a(uVar, i, i2, i3, i4);
        }
        float fO = android.support.v4.view.ah.o(uVar.f1584a);
        float fP = android.support.v4.view.ah.p(uVar.f1584a);
        float f2 = android.support.v4.view.ah.f(uVar.f1584a);
        v(uVar);
        int i5 = (int) ((i3 - i) - fO);
        int i6 = (int) ((i4 - i2) - fP);
        android.support.v4.view.ah.a(uVar.f1584a, fO);
        android.support.v4.view.ah.b(uVar.f1584a, fP);
        android.support.v4.view.ah.c(uVar.f1584a, f2);
        if (uVar2 != null) {
            v(uVar2);
            android.support.v4.view.ah.a(uVar2.f1584a, -i5);
            android.support.v4.view.ah.b(uVar2.f1584a, -i6);
            android.support.v4.view.ah.c(uVar2.f1584a, BitmapDescriptorFactory.HUE_RED);
        }
        this.f1838e.add(new a(uVar, uVar2, i, i2, i3, i4));
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.u uVar, List<Object> list) {
        return !list.isEmpty() || super.a(uVar, list);
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean b() {
        return (this.f1836c.isEmpty() && this.f1838e.isEmpty() && this.f1837d.isEmpty() && this.f1835b.isEmpty() && this.j.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.l.isEmpty() && this.g.isEmpty() && this.f1839f.isEmpty() && this.h.isEmpty()) ? false : true;
    }

    @Override // android.support.v7.widget.ai
    public boolean b(RecyclerView.u uVar) {
        v(uVar);
        android.support.v4.view.ah.c(uVar.f1584a, BitmapDescriptorFactory.HUE_RED);
        this.f1836c.add(uVar);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void c() {
        for (int size = this.f1837d.size() - 1; size >= 0; size--) {
            b bVar = this.f1837d.get(size);
            View view = bVar.f1870a.f1584a;
            android.support.v4.view.ah.b(view, BitmapDescriptorFactory.HUE_RED);
            android.support.v4.view.ah.a(view, BitmapDescriptorFactory.HUE_RED);
            i(bVar.f1870a);
            this.f1837d.remove(size);
        }
        for (int size2 = this.f1835b.size() - 1; size2 >= 0; size2--) {
            h(this.f1835b.get(size2));
            this.f1835b.remove(size2);
        }
        for (int size3 = this.f1836c.size() - 1; size3 >= 0; size3--) {
            RecyclerView.u uVar = this.f1836c.get(size3);
            android.support.v4.view.ah.c(uVar.f1584a, 1.0f);
            j(uVar);
            this.f1836c.remove(size3);
        }
        for (int size4 = this.f1838e.size() - 1; size4 >= 0; size4--) {
            b(this.f1838e.get(size4));
        }
        this.f1838e.clear();
        if (b()) {
            for (int size5 = this.g.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.g.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f1870a.f1584a;
                    android.support.v4.view.ah.b(view2, BitmapDescriptorFactory.HUE_RED);
                    android.support.v4.view.ah.a(view2, BitmapDescriptorFactory.HUE_RED);
                    i(bVar2.f1870a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1839f.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.u> arrayList2 = this.f1839f.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.u uVar2 = arrayList2.get(size8);
                    android.support.v4.view.ah.c(uVar2.f1584a, 1.0f);
                    j(uVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1839f.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.h.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.h.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.h.remove(arrayList3);
                    }
                }
            }
            a(this.k);
            a(this.j);
            a(this.i);
            a(this.l);
            h();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void c(RecyclerView.u uVar) {
        View view = uVar.f1584a;
        android.support.v4.view.ah.s(view).b();
        for (int size = this.f1837d.size() - 1; size >= 0; size--) {
            if (this.f1837d.get(size).f1870a == uVar) {
                android.support.v4.view.ah.b(view, BitmapDescriptorFactory.HUE_RED);
                android.support.v4.view.ah.a(view, BitmapDescriptorFactory.HUE_RED);
                i(uVar);
                this.f1837d.remove(size);
            }
        }
        a(this.f1838e, uVar);
        if (this.f1835b.remove(uVar)) {
            android.support.v4.view.ah.c(view, 1.0f);
            h(uVar);
        }
        if (this.f1836c.remove(uVar)) {
            android.support.v4.view.ah.c(view, 1.0f);
            j(uVar);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.h.get(size2);
            a(arrayList, uVar);
            if (arrayList.isEmpty()) {
                this.h.remove(size2);
            }
        }
        for (int size3 = this.g.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.g.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f1870a == uVar) {
                    android.support.v4.view.ah.b(view, BitmapDescriptorFactory.HUE_RED);
                    android.support.v4.view.ah.a(view, BitmapDescriptorFactory.HUE_RED);
                    i(uVar);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.g.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f1839f.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.u> arrayList3 = this.f1839f.get(size5);
            if (arrayList3.remove(uVar)) {
                android.support.v4.view.ah.c(view, 1.0f);
                j(uVar);
                if (arrayList3.isEmpty()) {
                    this.f1839f.remove(size5);
                }
            }
        }
        if (this.k.remove(uVar)) {
        }
        if (this.i.remove(uVar)) {
        }
        if (this.l.remove(uVar)) {
        }
        if (this.j.remove(uVar)) {
        }
        j();
    }
}
