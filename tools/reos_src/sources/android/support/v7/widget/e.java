package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class e implements z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<b> f1783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f1785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Runnable f1786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f1787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final z f1788f;
    private android.support.v4.h.h.a<b> g;
    private int h;

    interface a {
        RecyclerView.u a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f1791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1792d;

        b(int i, int i2, int i3, Object obj) {
            this.f1789a = i;
            this.f1790b = i2;
            this.f1792d = i3;
            this.f1791c = obj;
        }

        String a() {
            switch (this.f1789a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    return "??";
                case 4:
                    return "up";
                case 8:
                    return "mv";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1789a != bVar.f1789a) {
                return false;
            }
            if (this.f1789a == 8 && Math.abs(this.f1792d - this.f1790b) == 1 && this.f1792d == bVar.f1790b && this.f1790b == bVar.f1792d) {
                return true;
            }
            if (this.f1792d == bVar.f1792d && this.f1790b == bVar.f1790b) {
                if (this.f1791c != null) {
                    return this.f1791c.equals(bVar.f1791c);
                }
                return bVar.f1791c == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f1789a * 31) + this.f1790b) * 31) + this.f1792d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1790b + "c:" + this.f1792d + ",p:" + this.f1791c + "]";
        }
    }

    e(a aVar) {
        this(aVar, false);
    }

    e(a aVar, boolean z) {
        this.g = new android.support.v4.h.h.b(30);
        this.f1783a = new ArrayList<>();
        this.f1784b = new ArrayList<>();
        this.h = 0;
        this.f1785c = aVar;
        this.f1787e = z;
        this.f1788f = new z(this);
    }

    private int b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.f1784b.size() - 1; size >= 0; size--) {
            b bVar = this.f1784b.get(size);
            if (bVar.f1789a == 8) {
                if (bVar.f1790b < bVar.f1792d) {
                    i3 = bVar.f1790b;
                    i4 = bVar.f1792d;
                } else {
                    i3 = bVar.f1792d;
                    i4 = bVar.f1790b;
                }
                if (i6 < i3 || i6 > i4) {
                    if (i6 >= bVar.f1790b) {
                        i5 = i6;
                    } else if (i2 == 1) {
                        bVar.f1790b++;
                        bVar.f1792d++;
                        i5 = i6;
                    } else {
                        if (i2 == 2) {
                            bVar.f1790b--;
                            bVar.f1792d--;
                        }
                        i5 = i6;
                    }
                } else if (i3 == bVar.f1790b) {
                    if (i2 == 1) {
                        bVar.f1792d++;
                    } else if (i2 == 2) {
                        bVar.f1792d--;
                    }
                    i5 = i6 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.f1790b++;
                    } else if (i2 == 2) {
                        bVar.f1790b--;
                    }
                    i5 = i6 - 1;
                }
                i6 = i5;
            } else if (bVar.f1790b <= i6) {
                if (bVar.f1789a == 1) {
                    i6 -= bVar.f1792d;
                } else if (bVar.f1789a == 2) {
                    i6 += bVar.f1792d;
                }
            } else if (i2 == 1) {
                bVar.f1790b++;
            } else if (i2 == 2) {
                bVar.f1790b--;
            }
        }
        for (int size2 = this.f1784b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1784b.get(size2);
            if (bVar2.f1789a == 8) {
                if (bVar2.f1792d == bVar2.f1790b || bVar2.f1792d < 0) {
                    this.f1784b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1792d <= 0) {
                this.f1784b.remove(size2);
                a(bVar2);
            }
        }
        return i6;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = bVar.f1790b;
        int i5 = bVar.f1790b + bVar.f1792d;
        byte b2 = -1;
        int i6 = bVar.f1790b;
        int i7 = 0;
        while (i6 < i5) {
            if (this.f1785c.a(i6) != null || d(i6)) {
                if (b2 == 0) {
                    e(a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    g(a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i3 = i6 - i7;
                i = i5 - i7;
                i2 = 1;
            } else {
                int i8 = i6;
                i = i5;
                i2 = i7 + 1;
                i3 = i8;
            }
            i7 = i2;
            i5 = i;
            i6 = i3 + 1;
        }
        if (i7 != bVar.f1792d) {
            a(bVar);
            bVar = a(2, i4, i7, null);
        }
        if (b2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i;
        int i2;
        byte b2;
        int i3 = bVar.f1790b;
        int i4 = bVar.f1790b + bVar.f1792d;
        int i5 = bVar.f1790b;
        byte b3 = -1;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f1785c.a(i5) != null || d(i5)) {
                if (b3 == 0) {
                    e(a(4, i3, i6, bVar.f1791c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                b2 = 1;
            } else {
                if (b3 == 1) {
                    g(a(4, i3, i6, bVar.f1791c));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                b2 = 0;
            }
            i5++;
            byte b4 = b2;
            i6 = i2 + 1;
            i3 = i;
            b3 = b4;
        }
        if (i6 != bVar.f1792d) {
            Object obj = bVar.f1791c;
            a(bVar);
            bVar = a(4, i3, i6, obj);
        }
        if (b3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i) {
        int size = this.f1784b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1784b.get(i2);
            if (bVar.f1789a == 8) {
                if (a(bVar.f1792d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f1789a == 1) {
                int i3 = bVar.f1790b + bVar.f1792d;
                for (int i4 = bVar.f1790b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        int i;
        boolean z;
        if (bVar.f1789a == 1 || bVar.f1789a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iB = b(bVar.f1790b, bVar.f1789a);
        int i2 = bVar.f1790b;
        switch (bVar.f1789a) {
            case 2:
                i = 0;
                break;
            case 3:
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            case 4:
                i = 1;
                break;
        }
        int i3 = 1;
        int i4 = iB;
        int i5 = i2;
        for (int i6 = 1; i6 < bVar.f1792d; i6++) {
            int iB2 = b(bVar.f1790b + (i * i6), bVar.f1789a);
            switch (bVar.f1789a) {
                case 2:
                    z = iB2 == i4;
                    break;
                case 3:
                default:
                    z = false;
                    break;
                case 4:
                    z = iB2 == i4 + 1;
                    break;
            }
            if (z) {
                i3++;
            } else {
                b bVarA = a(bVar.f1789a, i4, i3, bVar.f1791c);
                a(bVarA, i5);
                a(bVarA);
                if (bVar.f1789a == 4) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = iB2;
            }
        }
        Object obj = bVar.f1791c;
        a(bVar);
        if (i3 > 0) {
            b bVarA2 = a(bVar.f1789a, i4, i3, obj);
            a(bVarA2, i5);
            a(bVarA2);
        }
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f1784b.add(bVar);
        switch (bVar.f1789a) {
            case 1:
                this.f1785c.c(bVar.f1790b, bVar.f1792d);
                return;
            case 2:
                this.f1785c.b(bVar.f1790b, bVar.f1792d);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
            case 4:
                this.f1785c.a(bVar.f1790b, bVar.f1792d, bVar.f1791c);
                return;
            case 8:
                this.f1785c.d(bVar.f1790b, bVar.f1792d);
                return;
        }
    }

    int a(int i, int i2) {
        int size = this.f1784b.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = this.f1784b.get(i2);
            if (bVar.f1789a == 8) {
                if (bVar.f1790b == i3) {
                    i3 = bVar.f1792d;
                } else {
                    if (bVar.f1790b < i3) {
                        i3--;
                    }
                    if (bVar.f1792d <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.f1790b > i3) {
                continue;
            } else if (bVar.f1789a == 2) {
                if (i3 < bVar.f1790b + bVar.f1792d) {
                    return -1;
                }
                i3 -= bVar.f1792d;
            } else if (bVar.f1789a == 1) {
                i3 += bVar.f1792d;
            }
            i2++;
        }
        return i3;
    }

    @Override // android.support.v7.widget.z.a
    public b a(int i, int i2, int i3, Object obj) {
        b bVarA = this.g.a();
        if (bVarA == null) {
            return new b(i, i2, i3, obj);
        }
        bVarA.f1789a = i;
        bVarA.f1790b = i2;
        bVarA.f1792d = i3;
        bVarA.f1791c = obj;
        return bVarA;
    }

    void a() {
        a(this.f1783a);
        a(this.f1784b);
        this.h = 0;
    }

    @Override // android.support.v7.widget.z.a
    public void a(b bVar) {
        if (this.f1787e) {
            return;
        }
        bVar.f1791c = null;
        this.g.a(bVar);
    }

    void a(b bVar, int i) {
        this.f1785c.a(bVar);
        switch (bVar.f1789a) {
            case 2:
                this.f1785c.a(i, bVar.f1792d);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.f1785c.a(i, bVar.f1792d, bVar.f1791c);
                return;
        }
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }

    boolean a(int i) {
        return (this.h & i) != 0;
    }

    int b(int i) {
        return a(i, 0);
    }

    void b() {
        this.f1788f.a(this.f1783a);
        int size = this.f1783a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1783a.get(i);
            switch (bVar.f1789a) {
                case 1:
                    f(bVar);
                    break;
                case 2:
                    c(bVar);
                    break;
                case 4:
                    d(bVar);
                    break;
                case 8:
                    b(bVar);
                    break;
            }
            if (this.f1786d != null) {
                this.f1786d.run();
            }
        }
        this.f1783a.clear();
    }

    public int c(int i) {
        int size = this.f1783a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1783a.get(i3);
            switch (bVar.f1789a) {
                case 1:
                    if (bVar.f1790b <= i2) {
                        i2 += bVar.f1792d;
                    }
                    break;
                case 2:
                    if (bVar.f1790b > i2) {
                        continue;
                    } else {
                        if (bVar.f1790b + bVar.f1792d > i2) {
                            return -1;
                        }
                        i2 -= bVar.f1792d;
                    }
                    break;
                case 8:
                    if (bVar.f1790b == i2) {
                        i2 = bVar.f1792d;
                    } else {
                        if (bVar.f1790b < i2) {
                            i2--;
                        }
                        if (bVar.f1792d <= i2) {
                            i2++;
                        }
                    }
                    break;
            }
        }
        return i2;
    }

    void c() {
        int size = this.f1784b.size();
        for (int i = 0; i < size; i++) {
            this.f1785c.b(this.f1784b.get(i));
        }
        a(this.f1784b);
        this.h = 0;
    }

    boolean d() {
        return this.f1783a.size() > 0;
    }

    void e() {
        c();
        int size = this.f1783a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1783a.get(i);
            switch (bVar.f1789a) {
                case 1:
                    this.f1785c.b(bVar);
                    this.f1785c.c(bVar.f1790b, bVar.f1792d);
                    break;
                case 2:
                    this.f1785c.b(bVar);
                    this.f1785c.a(bVar.f1790b, bVar.f1792d);
                    break;
                case 4:
                    this.f1785c.b(bVar);
                    this.f1785c.a(bVar.f1790b, bVar.f1792d, bVar.f1791c);
                    break;
                case 8:
                    this.f1785c.b(bVar);
                    this.f1785c.d(bVar.f1790b, bVar.f1792d);
                    break;
            }
            if (this.f1786d != null) {
                this.f1786d.run();
            }
        }
        a(this.f1783a);
        this.h = 0;
    }

    boolean f() {
        return (this.f1784b.isEmpty() || this.f1783a.isEmpty()) ? false : true;
    }
}
