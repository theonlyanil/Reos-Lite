package android.support.v4.h;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Object[] f817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static int f818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Object[] f819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f821f;
    Object[] g;
    int h;

    public i() {
        this.f821f = b.f789a;
        this.g = b.f791c;
        this.h = 0;
    }

    public i(int i) {
        if (i == 0) {
            this.f821f = b.f789a;
            this.g = b.f791c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (f820e < 10) {
                    objArr[0] = f819d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f819d = objArr;
                    f820e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (a.class) {
                if (f818c < 10) {
                    objArr[0] = f817b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f817b = objArr;
                    f818c++;
                }
            }
        }
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (f819d != null) {
                    Object[] objArr = f819d;
                    this.g = objArr;
                    f819d = (Object[]) objArr[0];
                    this.f821f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f820e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (f817b != null) {
                    Object[] objArr2 = f817b;
                    this.g = objArr2;
                    f817b = (Object[]) objArr2[0];
                    this.f821f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f818c--;
                    return;
                }
            }
        }
        this.f821f = new int[i];
        this.g = new Object[i << 1];
    }

    int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int iA = b.a(this.f821f, i, 0);
        if (iA < 0 || this.g[iA << 1] == null) {
            return iA;
        }
        int i2 = iA + 1;
        while (i2 < i && this.f821f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iA - 1; i3 >= 0 && this.f821f[i3] == 0; i3--) {
            if (this.g[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int iA = b.a(this.f821f, i2, i);
        if (iA < 0 || obj.equals(this.g[iA << 1])) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f821f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f821f[i4] == i; i4--) {
            if (obj.equals(this.g[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.g[i2];
        this.g[i2] = v;
        return v2;
    }

    public void a(int i) {
        if (this.f821f.length < i) {
            int[] iArr = this.f821f;
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f821f, 0, this.h);
                System.arraycopy(objArr, 0, this.g, 0, this.h << 1);
            }
            a(iArr, objArr, this.h);
        }
    }

    public void a(i<? extends K, ? extends V> iVar) {
        int i = iVar.h;
        a(this.h + i);
        if (this.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(iVar.b(i2), iVar.c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(iVar.f821f, 0, this.f821f, 0, i);
            System.arraycopy(iVar.g, 0, this.g, 0, i << 1);
            this.h = i;
        }
    }

    int b(Object obj) {
        int i = 1;
        int i2 = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K b(int i) {
        return (K) this.g[i << 1];
    }

    public V c(int i) {
        return (V) this.g[(i << 1) + 1];
    }

    public void clear() {
        if (this.h != 0) {
            a(this.f821f, this.g, this.h);
            this.f821f = b.f789a;
            this.g = b.f791c;
            this.h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        V v = (V) this.g[(i << 1) + 1];
        if (this.h <= 1) {
            a(this.f821f, this.g, this.h);
            this.f821f = b.f789a;
            this.g = b.f791c;
            this.h = 0;
        } else if (this.f821f.length <= 8 || this.h >= this.f821f.length / 3) {
            this.h--;
            if (i < this.h) {
                System.arraycopy(this.f821f, i + 1, this.f821f, i, this.h - i);
                System.arraycopy(this.g, (i + 1) << 1, this.g, i << 1, (this.h - i) << 1);
            }
            this.g[this.h << 1] = null;
            this.g[(this.h << 1) + 1] = null;
        } else {
            int i2 = this.h > 8 ? this.h + (this.h >> 1) : 8;
            int[] iArr = this.f821f;
            Object[] objArr = this.g;
            e(i2);
            this.h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f821f, 0, i);
                System.arraycopy(objArr, 0, this.g, 0, i << 1);
            }
            if (i < this.h) {
                System.arraycopy(iArr, i + 1, this.f821f, i, this.h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.g, i << 1, (this.h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i = 0; i < this.h; i++) {
            try {
                K kB = b(i);
                V vC = c(i);
                Object obj2 = map.get(kB);
                if (vC == null) {
                    if (obj2 != null || !map.containsKey(kB)) {
                        return false;
                    }
                } else if (!vC.equals(obj2)) {
                    return false;
                }
            } catch (ClassCastException e2) {
                return false;
            } catch (NullPointerException e3) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int iA = a(obj);
        if (iA >= 0) {
            return (V) this.g[(iA << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f821f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int iHashCode;
        int iA;
        int i = 8;
        if (k == null) {
            iA = a();
            iHashCode = 0;
        } else {
            iHashCode = k.hashCode();
            iA = a(k, iHashCode);
        }
        if (iA >= 0) {
            int i2 = (iA << 1) + 1;
            V v2 = (V) this.g[i2];
            this.g[i2] = v;
            return v2;
        }
        int i3 = iA ^ (-1);
        if (this.h >= this.f821f.length) {
            if (this.h >= 8) {
                i = this.h + (this.h >> 1);
            } else if (this.h < 4) {
                i = 4;
            }
            int[] iArr = this.f821f;
            Object[] objArr = this.g;
            e(i);
            if (this.f821f.length > 0) {
                System.arraycopy(iArr, 0, this.f821f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            a(iArr, objArr, this.h);
        }
        if (i3 < this.h) {
            System.arraycopy(this.f821f, i3, this.f821f, i3 + 1, this.h - i3);
            System.arraycopy(this.g, i3 << 1, this.g, (i3 + 1) << 1, (this.h - i3) << 1);
        }
        this.f821f[i3] = iHashCode;
        this.g[i3 << 1] = k;
        this.g[(i3 << 1) + 1] = v;
        this.h++;
        return null;
    }

    public V remove(Object obj) {
        int iA = a(obj);
        if (iA >= 0) {
            return d(iA);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kB = b(i);
            if (kB != this) {
                sb.append(kB);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vC = c(i);
            if (vC != this) {
                sb.append(vC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
