package com.github.mikephil.charting.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5059b;

    public a(float f2, float f3) {
        this.f5058a = f2;
        this.f5059b = f3;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5058a == aVar.f5058a && this.f5059b == aVar.f5059b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f5058a) ^ Float.floatToIntBits(this.f5059b);
    }

    public String toString() {
        return String.valueOf(this.f5058a) + "x" + this.f5059b;
    }
}
