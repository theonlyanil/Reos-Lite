package a.a.a;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f0a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f1b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a.a.a.a.c f2c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f3d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f4e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c> f5f = new CopyOnWriteArrayList();
    private final a.a.a.a.a g;
    private final a.a.a.a.b h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private long n;
    private b o;
    private boolean p;
    private boolean q;
    private boolean r;

    static {
        f0a = !a.class.desiredAssertionStatus();
        f1b = Logger.getLogger(a.class.getName());
    }

    public a(a.a.a.a.c cVar, int i, int i2) {
        this.f2c = cVar;
        this.h = this.f2c.b();
        a(i, i2);
        this.o = new b(this.h);
        this.o.a(this.f3d);
        this.o.a(i2);
        this.g = a.a.a.a.a.a(this.h);
        this.p = false;
        this.m = 0L;
        this.r = true;
    }

    private void b() {
        try {
            if (this.f2c.a(this.m) != this.m) {
                throw new IOException();
            }
            this.n += this.m;
        } catch (IOException e2) {
            String str = String.format("Did not skip the expected amount of bytes,  %d skipped, %d expected!", 0L, Long.valueOf(this.m));
            f1b.warning(str);
            throw new Error(str);
        }
    }

    private int c() throws IOException {
        int i;
        int i2;
        int length;
        int iA;
        if (!f0a && this.i >= this.f3d.length) {
            throw new AssertionError();
        }
        boolean z = this.n == 0 || this.n == this.m;
        if (!z || this.q) {
            int i3 = this.l;
            i = this.k;
            i2 = this.i;
            length = i3;
        } else {
            length = this.f4e.length;
            i2 = 0;
            i = 0;
        }
        if (!z && this.f3d.length == this.i + this.j) {
            System.arraycopy(this.f3d, this.j, this.f3d, 0, this.i);
        }
        boolean z2 = false;
        int i4 = 0;
        while (!this.p && !z2 && i4 < length) {
            try {
                iA = this.f2c.a(this.f4e, i + i4, length - i4);
            } catch (IndexOutOfBoundsException e2) {
                iA = -1;
            }
            if (iA == -1) {
                z2 = true;
            } else {
                i4 = iA + i4;
            }
        }
        if (z2) {
            if (this.r) {
                for (int i5 = i + i4; i5 < this.f4e.length; i5++) {
                    this.f4e[i5] = 0;
                }
                this.g.a(this.f4e, i, this.f3d, i2, this.j);
            } else {
                this.f4e = new byte[i + i4];
                int iE = i4 / this.h.e();
                this.f3d = new float[(i4 / this.h.e()) + i2];
                this.g.a(this.f4e, i, this.f3d, i2, iE);
            }
        } else if (length == i4) {
            if (!z || this.q) {
                this.g.a(this.f4e, i, this.f3d, i2, this.j);
            } else {
                this.g.a(this.f4e, 0, this.f3d, 0, this.f3d.length);
            }
        } else if (!this.p) {
            throw new IOException(String.format("The end of the audio stream has not been reached and the number of bytes read (%d) is not equal to the expected amount of bytes(%d).", Integer.valueOf(i4), Integer.valueOf(length)));
        }
        this.o.a(this.f3d);
        this.o.a(i2);
        return i4;
    }

    public void a() {
        this.p = true;
        Iterator<c> it = this.f5f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        try {
            this.f2c.a();
        } catch (IOException e2) {
            f1b.log(Level.SEVERE, "Closing audio stream error.", (Throwable) e2);
        }
    }

    public void a(int i, int i2) {
        this.f3d = new float[i];
        this.i = i2;
        this.j = this.f3d.length - this.i;
        this.f4e = new byte[this.f3d.length * this.h.e()];
        this.k = this.i * this.h.e();
        this.l = this.j * this.h.e();
    }

    public void a(c cVar) {
        this.f5f.add(cVar);
        f1b.fine("Added an audioprocessor to the list of processors: " + cVar.toString());
    }

    public void b(c cVar) {
        this.f5f.remove(cVar);
        cVar.a();
        f1b.fine("Remove an audioprocessor to the list of processors: " + cVar.toString());
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        if (this.m != 0) {
            b();
        }
        try {
            int iC = c();
            while (iC != 0 && !this.p) {
                Iterator<c> it = this.f5f.iterator();
                while (it.hasNext() && it.next().a(this.o)) {
                }
                if (!this.p) {
                    this.n = ((long) iC) + this.n;
                    this.o.a(this.n);
                    try {
                        int iC2 = c();
                        this.o.a(this.i);
                        iC = iC2;
                    } catch (IOException e2) {
                        String str = "Error while reading audio input stream: " + e2.getMessage();
                        f1b.warning(str);
                        throw new Error(str);
                    }
                }
            }
            if (this.p) {
                return;
            }
            a();
        } catch (IOException e3) {
            String str2 = "Error while reading audio input stream: " + e3.getMessage();
            f1b.warning(str2);
            throw new Error(str2);
        }
    }
}
