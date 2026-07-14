package a.a.a.b;

/* JADX INFO: loaded from: classes.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f45a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f46b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f47c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f48d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f49e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f50f;
    private final g g;

    public a(float f2, int i) {
        this(f2, i, 82.0d, 1000.0d);
    }

    public a(float f2, int i, double d2, double d3) {
        this.f45a = f2;
        this.f46b = new double[i];
        this.f49e = 5.0d;
        this.f50f = 0.1d;
        this.f47c = Math.round((((double) f2) / d2) + 0.5d);
        this.f48d = Math.round((((double) f2) / d3) + 0.5d);
        this.g = new g();
    }

    @Override // a.a.a.b.h
    public g a(float[] fArr) {
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        double[] dArr = new double[0];
        double[] dArr2 = new double[0];
        double[] dArr3 = new double[0];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            double[] dArr4 = new double[(length - i) + 1];
            double[] dArr5 = new double[(length - i) + 1];
            int i2 = 0;
            for (int i3 = 0; i3 < length - i; i3++) {
                i2++;
                dArr4[i2] = fArr[i3];
            }
            int i4 = 0;
            for (int i5 = i; i5 < length; i5++) {
                i4++;
                dArr5[i4] = fArr[i5];
            }
            int length2 = dArr4.length;
            double[] dArr6 = new double[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                dArr6[i6] = dArr4[i6] - dArr5[i6];
            }
            double dAbs = 0.0d;
            for (int i7 = 0; i7 < length2; i7++) {
                dAbs += Math.abs(dArr6[i7]);
            }
            this.f46b[i] = dAbs;
        }
        for (int i8 = (int) this.f48d; i8 < ((int) this.f47c); i8++) {
            if (this.f46b[i8] < d2) {
                d2 = this.f46b[i8];
            }
            if (this.f46b[i8] > d3) {
                d3 = this.f46b[i8];
            }
        }
        int iRound = (int) Math.round(d2 + (this.f50f * (d3 - d2)));
        int i9 = (int) this.f48d;
        while (i9 <= ((int) this.f47c) && this.f46b[i9] > iRound) {
            i9++;
        }
        double d4 = this.f48d / 2;
        double d5 = this.f46b[i9];
        int i10 = i9;
        int i11 = i9;
        while (i11 < ((double) i9) + d4 && i11 <= this.f47c) {
            i11++;
            if (this.f46b[i11] < d5) {
                d5 = this.f46b[i11];
                i10 = i11;
            }
        }
        float f2 = ((double) Math.round(this.f46b[i10] * this.f49e)) < d3 ? this.f45a / i10 : -1.0f;
        this.g.a(f2);
        this.g.a(-1.0f != f2);
        this.g.b(-1.0f);
        return this.g;
    }
}
