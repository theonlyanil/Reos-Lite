package com.cube26.iota.smartlite.util;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f3463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f3464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f3465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double[] f3466d;

    public f(double d2, int i, double d3) {
        this.f3463a = d2;
        this.f3464b = (this.f3463a * 1.0d) / ((double) (i - 1));
        this.f3465c = 1.0d / this.f3464b;
        if (d2 >= 0.0d) {
            b.a("IOTA", "MeterTable inMinDecibels must be negative");
        }
        this.f3466d = new double[i];
        double dB = b(d2);
        double d4 = 1.0d / (1.0d - dB);
        double d5 = 1.0d / d3;
        for (int i2 = 0; i2 < i; i2++) {
            this.f3466d[i2] = Math.pow((b((((double) i2) * 1.0d) * this.f3464b) - dB) * d4 * 1.0d, d5);
        }
    }

    private static double b(double d2) {
        return Math.pow(10.0d, 0.05d * d2);
    }

    public double a(double d2) {
        if (d2 < this.f3463a) {
            return 0.0d;
        }
        if (d2 >= 0.0d) {
            return 1.0d;
        }
        return this.f3466d[(int) (this.f3465c * d2)];
    }
}
