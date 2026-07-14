package android.support.v4.h;

/* JADX INFO: loaded from: classes.dex */
public class e<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f794a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f798e;

    public e() {
        this(10);
    }

    public e(int i) {
        this.f795b = false;
        if (i == 0) {
            this.f796c = b.f790b;
            this.f797d = b.f791c;
        } else {
            int iB = b.b(i);
            this.f796c = new long[iB];
            this.f797d = new Object[iB];
        }
        this.f798e = 0;
    }

    private void d() {
        int i = this.f798e;
        long[] jArr = this.f796c;
        Object[] objArr = this.f797d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f794a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f795b = false;
        this.f798e = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.f796c = (long[]) this.f796c.clone();
                eVar.f797d = (Object[]) this.f797d.clone();
                return eVar;
            } catch (CloneNotSupportedException e2) {
                return eVar;
            }
        } catch (CloneNotSupportedException e3) {
            return null;
        }
    }

    public E a(long j) {
        return a(j, null);
    }

    public E a(long j, E e2) {
        int iA = b.a(this.f796c, this.f798e, j);
        return (iA < 0 || this.f797d[iA] == f794a) ? e2 : (E) this.f797d[iA];
    }

    public void a(int i) {
        if (this.f797d[i] != f794a) {
            this.f797d[i] = f794a;
            this.f795b = true;
        }
    }

    public int b() {
        if (this.f795b) {
            d();
        }
        return this.f798e;
    }

    public long b(int i) {
        if (this.f795b) {
            d();
        }
        return this.f796c[i];
    }

    public void b(long j) {
        int iA = b.a(this.f796c, this.f798e, j);
        if (iA < 0 || this.f797d[iA] == f794a) {
            return;
        }
        this.f797d[iA] = f794a;
        this.f795b = true;
    }

    public void b(long j, E e2) {
        int iA = b.a(this.f796c, this.f798e, j);
        if (iA >= 0) {
            this.f797d[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.f798e && this.f797d[iA2] == f794a) {
            this.f796c[iA2] = j;
            this.f797d[iA2] = e2;
            return;
        }
        if (this.f795b && this.f798e >= this.f796c.length) {
            d();
            iA2 = b.a(this.f796c, this.f798e, j) ^ (-1);
        }
        if (this.f798e >= this.f796c.length) {
            int iB = b.b(this.f798e + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.f796c, 0, jArr, 0, this.f796c.length);
            System.arraycopy(this.f797d, 0, objArr, 0, this.f797d.length);
            this.f796c = jArr;
            this.f797d = objArr;
        }
        if (this.f798e - iA2 != 0) {
            System.arraycopy(this.f796c, iA2, this.f796c, iA2 + 1, this.f798e - iA2);
            System.arraycopy(this.f797d, iA2, this.f797d, iA2 + 1, this.f798e - iA2);
        }
        this.f796c[iA2] = j;
        this.f797d[iA2] = e2;
        this.f798e++;
    }

    public E c(int i) {
        if (this.f795b) {
            d();
        }
        return (E) this.f797d[i];
    }

    public void c() {
        int i = this.f798e;
        Object[] objArr = this.f797d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f798e = 0;
        this.f795b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f798e * 28);
        sb.append('{');
        for (int i = 0; i < this.f798e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            E eC = c(i);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
