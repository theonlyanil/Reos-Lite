package com.journeyapps.barcodescanner;

/* JADX INFO: loaded from: classes.dex */
public class k implements Comparable<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5914b;

    public k(int i, int i2) {
        this.f5913a = i;
        this.f5914b = i2;
    }

    public k a() {
        return new k(this.f5914b, this.f5913a);
    }

    public k a(int i, int i2) {
        return new k((this.f5913a * i) / i2, (this.f5914b * i) / i2);
    }

    public boolean a(k kVar) {
        return this.f5913a <= kVar.f5913a && this.f5914b <= kVar.f5914b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        int i = this.f5914b * this.f5913a;
        int i2 = kVar.f5914b * kVar.f5913a;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5913a == kVar.f5913a && this.f5914b == kVar.f5914b;
    }

    public int hashCode() {
        return (this.f5913a * 31) + this.f5914b;
    }

    public String toString() {
        return this.f5913a + "x" + this.f5914b;
    }
}
