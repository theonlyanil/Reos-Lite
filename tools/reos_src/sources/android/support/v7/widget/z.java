package android.support.v7.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f1883a;

    interface a {
        e.b a(int i, int i2, int i3, Object obj);

        void a(e.b bVar);
    }

    public z(a aVar) {
        this.f1883a = aVar;
    }

    private void a(List<e.b> list, int i, int i2) {
        e.b bVar = list.get(i);
        e.b bVar2 = list.get(i2);
        switch (bVar2.f1789a) {
            case 1:
                c(list, i, bVar, i2, bVar2);
                break;
            case 2:
                a(list, i, bVar, i2, bVar2);
                break;
            case 4:
                b(list, i, bVar, i2, bVar2);
                break;
        }
    }

    private int b(List<e.b> list) {
        boolean z;
        boolean z2 = false;
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).f1789a != 8) {
                z = true;
            } else {
                if (z2) {
                    return size;
                }
                z = z2;
            }
            size--;
            z2 = z;
        }
        return -1;
    }

    private void c(List<e.b> list, int i, e.b bVar, int i2, e.b bVar2) {
        int i3 = bVar.f1792d < bVar2.f1790b ? -1 : 0;
        if (bVar.f1790b < bVar2.f1790b) {
            i3++;
        }
        if (bVar2.f1790b <= bVar.f1790b) {
            bVar.f1790b += bVar2.f1792d;
        }
        if (bVar2.f1790b <= bVar.f1792d) {
            bVar.f1792d += bVar2.f1792d;
        }
        bVar2.f1790b = i3 + bVar2.f1790b;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void a(List<e.b> list) {
        while (true) {
            int iB = b(list);
            if (iB == -1) {
                return;
            } else {
                a(list, iB, iB + 1);
            }
        }
    }

    void a(List<e.b> list, int i, e.b bVar, int i2, e.b bVar2) {
        boolean z;
        e.b bVarA;
        boolean z2 = false;
        if (bVar.f1790b < bVar.f1792d) {
            z = bVar2.f1790b == bVar.f1790b && bVar2.f1792d == bVar.f1792d - bVar.f1790b;
        } else if (bVar2.f1790b == bVar.f1792d + 1 && bVar2.f1792d == bVar.f1790b - bVar.f1792d) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (bVar.f1792d < bVar2.f1790b) {
            bVar2.f1790b--;
        } else if (bVar.f1792d < bVar2.f1790b + bVar2.f1792d) {
            bVar2.f1792d--;
            bVar.f1789a = 2;
            bVar.f1792d = 1;
            if (bVar2.f1792d == 0) {
                list.remove(i2);
                this.f1883a.a(bVar2);
                return;
            }
            return;
        }
        if (bVar.f1790b <= bVar2.f1790b) {
            bVar2.f1790b++;
            bVarA = null;
        } else if (bVar.f1790b < bVar2.f1790b + bVar2.f1792d) {
            bVarA = this.f1883a.a(2, bVar.f1790b + 1, (bVar2.f1790b + bVar2.f1792d) - bVar.f1790b, null);
            bVar2.f1792d = bVar.f1790b - bVar2.f1790b;
        } else {
            bVarA = null;
        }
        if (z) {
            list.set(i, bVar2);
            list.remove(i2);
            this.f1883a.a(bVar);
            return;
        }
        if (z2) {
            if (bVarA != null) {
                if (bVar.f1790b > bVarA.f1790b) {
                    bVar.f1790b -= bVarA.f1792d;
                }
                if (bVar.f1792d > bVarA.f1790b) {
                    bVar.f1792d -= bVarA.f1792d;
                }
            }
            if (bVar.f1790b > bVar2.f1790b) {
                bVar.f1790b -= bVar2.f1792d;
            }
            if (bVar.f1792d > bVar2.f1790b) {
                bVar.f1792d -= bVar2.f1792d;
            }
        } else {
            if (bVarA != null) {
                if (bVar.f1790b >= bVarA.f1790b) {
                    bVar.f1790b -= bVarA.f1792d;
                }
                if (bVar.f1792d >= bVarA.f1790b) {
                    bVar.f1792d -= bVarA.f1792d;
                }
            }
            if (bVar.f1790b >= bVar2.f1790b) {
                bVar.f1790b -= bVar2.f1792d;
            }
            if (bVar.f1792d >= bVar2.f1790b) {
                bVar.f1792d -= bVar2.f1792d;
            }
        }
        list.set(i, bVar2);
        if (bVar.f1790b != bVar.f1792d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    void b(List<e.b> list, int i, e.b bVar, int i2, e.b bVar2) {
        e.b bVarA;
        e.b bVarA2 = null;
        if (bVar.f1792d < bVar2.f1790b) {
            bVar2.f1790b--;
            bVarA = null;
        } else if (bVar.f1792d < bVar2.f1790b + bVar2.f1792d) {
            bVar2.f1792d--;
            bVarA = this.f1883a.a(4, bVar.f1790b, 1, bVar2.f1791c);
        } else {
            bVarA = null;
        }
        if (bVar.f1790b <= bVar2.f1790b) {
            bVar2.f1790b++;
        } else if (bVar.f1790b < bVar2.f1790b + bVar2.f1792d) {
            int i3 = (bVar2.f1790b + bVar2.f1792d) - bVar.f1790b;
            bVarA2 = this.f1883a.a(4, bVar.f1790b + 1, i3, bVar2.f1791c);
            bVar2.f1792d -= i3;
        }
        list.set(i2, bVar);
        if (bVar2.f1792d > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.f1883a.a(bVar2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
        if (bVarA2 != null) {
            list.add(i, bVarA2);
        }
    }
}
