package android.support.v4.h;

/* JADX INFO: loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f822a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f826e;

    public j() {
        this(10);
    }

    public j(int i) {
        this.f823b = false;
        if (i == 0) {
            this.f824c = b.f789a;
            this.f825d = b.f791c;
        } else {
            int iA = b.a(i);
            this.f824c = new int[iA];
            this.f825d = new Object[iA];
        }
        this.f826e = 0;
    }

    private void d() {
        int i = this.f826e;
        int[] iArr = this.f824c;
        Object[] objArr = this.f825d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f822a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f823b = false;
        this.f826e = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            try {
                jVar.f824c = (int[]) this.f824c.clone();
                jVar.f825d = (Object[]) this.f825d.clone();
                return jVar;
            } catch (CloneNotSupportedException e2) {
                return jVar;
            }
        } catch (CloneNotSupportedException e3) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e2) {
        int iA = b.a(this.f824c, this.f826e, i);
        return (iA < 0 || this.f825d[iA] == f822a) ? e2 : (E) this.f825d[iA];
    }

    public int b() {
        if (this.f823b) {
            d();
        }
        return this.f826e;
    }

    public void b(int i) {
        int iA = b.a(this.f824c, this.f826e, i);
        if (iA < 0 || this.f825d[iA] == f822a) {
            return;
        }
        this.f825d[iA] = f822a;
        this.f823b = true;
    }

    public void b(int i, E e2) {
        int iA = b.a(this.f824c, this.f826e, i);
        if (iA >= 0) {
            this.f825d[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.f826e && this.f825d[iA2] == f822a) {
            this.f824c[iA2] = i;
            this.f825d[iA2] = e2;
            return;
        }
        if (this.f823b && this.f826e >= this.f824c.length) {
            d();
            iA2 = b.a(this.f824c, this.f826e, i) ^ (-1);
        }
        if (this.f826e >= this.f824c.length) {
            int iA3 = b.a(this.f826e + 1);
            int[] iArr = new int[iA3];
            Object[] objArr = new Object[iA3];
            System.arraycopy(this.f824c, 0, iArr, 0, this.f824c.length);
            System.arraycopy(this.f825d, 0, objArr, 0, this.f825d.length);
            this.f824c = iArr;
            this.f825d = objArr;
        }
        if (this.f826e - iA2 != 0) {
            System.arraycopy(this.f824c, iA2, this.f824c, iA2 + 1, this.f826e - iA2);
            System.arraycopy(this.f825d, iA2, this.f825d, iA2 + 1, this.f826e - iA2);
        }
        this.f824c[iA2] = i;
        this.f825d[iA2] = e2;
        this.f826e++;
    }

    public void c() {
        int i = this.f826e;
        Object[] objArr = this.f825d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f826e = 0;
        this.f823b = false;
    }

    public void c(int i) {
        b(i);
    }

    public int d(int i) {
        if (this.f823b) {
            d();
        }
        return this.f824c[i];
    }

    public E e(int i) {
        if (this.f823b) {
            d();
        }
        return (E) this.f825d[i];
    }

    public int f(int i) {
        if (this.f823b) {
            d();
        }
        return b.a(this.f824c, this.f826e, i);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f826e * 28);
        sb.append('{');
        for (int i = 0; i < this.f826e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(d(i));
            sb.append('=');
            E e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
