package a.a.a.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f64a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f65b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f66c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f67d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f68e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f69f;
    private final List<Integer> g;
    private final List<Float> h;
    private final List<Float> i;
    private final g j;

    static {
        f64a = !e.class.desiredAssertionStatus();
    }

    public e(float f2, int i) {
        this(f2, i, 0.97d);
    }

    public e(float f2, int i, double d2) {
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.f66c = f2;
        this.f67d = new float[i];
        this.f65b = d2;
        this.j = new g();
    }

    private void a() {
        int i = 0;
        int i2 = 0;
        while (i2 < (this.f67d.length - 1) / 3 && this.f67d[i2] > BitmapDescriptorFactory.HUE_RED) {
            i2++;
        }
        while (i2 < this.f67d.length - 1 && this.f67d[i2] <= 0.0d) {
            i2++;
        }
        int i3 = i2 == 0 ? 1 : i2;
        while (i3 < this.f67d.length - 1) {
            if (!f64a && this.f67d[i3] < BitmapDescriptorFactory.HUE_RED) {
                throw new AssertionError();
            }
            if (this.f67d[i3] > this.f67d[i3 - 1] && this.f67d[i3] >= this.f67d[i3 + 1] && (i == 0 || this.f67d[i3] > this.f67d[i])) {
                i = i3;
            }
            i3++;
            if (i3 < this.f67d.length - 1 && this.f67d[i3] <= BitmapDescriptorFactory.HUE_RED) {
                if (i > 0) {
                    this.g.add(Integer.valueOf(i));
                    i = 0;
                }
                while (i3 < this.f67d.length - 1 && this.f67d[i3] <= BitmapDescriptorFactory.HUE_RED) {
                    i3++;
                }
            }
        }
        if (i > 0) {
            this.g.add(Integer.valueOf(i));
        }
    }

    private void a(int i) {
        float f2 = this.f67d[i - 1];
        float f3 = this.f67d[i];
        float f4 = this.f67d[i + 1];
        float f5 = i;
        float f6 = (f4 + f2) - (2.0f * f3);
        if (f6 == 0.0d) {
            this.f68e = f5;
            this.f69f = f3;
        } else {
            float f7 = f2 - f4;
            this.f68e = (f7 / (2.0f * f6)) + f5;
            this.f69f = f3 - ((f7 * f7) / (8.0f * f6));
        }
    }

    private void b(float[] fArr) {
        for (int i = 0; i < fArr.length; i++) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i2 < fArr.length - i; i2++) {
                f3 += fArr[i2] * fArr[i2 + i];
                f2 += (fArr[i2] * fArr[i2]) + (fArr[i2 + i] * fArr[i2 + i]);
            }
            this.f67d[i] = (f3 * 2.0f) / f2;
        }
    }

    @Override // a.a.a.b.h
    public g a(float[] fArr) {
        double d2;
        float fFloatValue;
        this.g.clear();
        this.h.clear();
        this.i.clear();
        b(fArr);
        a();
        double dMax = Double.NEGATIVE_INFINITY;
        Iterator<Integer> it = this.g.iterator();
        while (true) {
            d2 = dMax;
            if (!it.hasNext()) {
                break;
            }
            Integer next = it.next();
            double dMax2 = Math.max(d2, this.f67d[next.intValue()]);
            if (this.f67d[next.intValue()] > 0.5d) {
                a(next.intValue());
                this.i.add(Float.valueOf(this.f69f));
                this.h.add(Float.valueOf(this.f68e));
                dMax = Math.max(dMax2, this.f69f);
            } else {
                dMax = dMax2;
            }
        }
        if (this.h.isEmpty()) {
            fFloatValue = -1.0f;
        } else {
            double d3 = this.f65b * d2;
            int i = 0;
            while (true) {
                if (i >= this.i.size()) {
                    i = 0;
                    break;
                }
                if (this.i.get(i).floatValue() >= d3) {
                    break;
                }
                i++;
            }
            fFloatValue = (float) (((double) this.f66c) / ((double) this.h.get(i).floatValue()));
            if (fFloatValue <= 80.0d) {
                fFloatValue = -1.0f;
            }
        }
        this.j.b((float) d2);
        this.j.a(fFloatValue);
        this.j.a(fFloatValue != -1.0f);
        return this.j;
    }
}
