package android.support.v7.a;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static q f1154d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1157c;

    q() {
    }

    static q a() {
        if (f1154d == null) {
            f1154d = new q();
        }
        return f1154d;
    }

    public void a(long j, double d2, double d3) {
        float f2 = (j - 946728000000L) / 8.64E7f;
        float f3 = 6.24006f + (0.01720197f * f2);
        double dSin = ((double) f3) + (0.03341960161924362d * Math.sin(f3)) + (3.4906598739326E-4d * Math.sin(2.0f * f3)) + (5.236000106378924E-6d * Math.sin(3.0f * f3)) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d3) / 360.0d;
        double dSin2 = (Math.sin(f3) * 0.0053d) + d4 + ((double) (Math.round(((double) (f2 - 9.0E-4f)) - d4) + 9.0E-4f)) + ((-0.0069d) * Math.sin(2.0d * dSin));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(dAsin))) / (Math.cos(dAsin) * Math.cos(d5));
        if (dSin3 >= 1.0d) {
            this.f1157c = 1;
            this.f1155a = -1L;
            this.f1156b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f1157c = 0;
                this.f1155a = -1L;
                this.f1156b = -1L;
                return;
            }
            float fAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f1155a = Math.round((((double) fAcos) + dSin2) * 8.64E7d) + 946728000000L;
            this.f1156b = Math.round((dSin2 - ((double) fAcos)) * 8.64E7d) + 946728000000L;
            if (this.f1156b >= j || this.f1155a <= j) {
                this.f1157c = 1;
            } else {
                this.f1157c = 0;
            }
        }
    }
}
