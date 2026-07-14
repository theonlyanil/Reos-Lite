package com.google.a.b;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5196a;

    public f(String str) {
        this.f5196a = str;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f5196a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f5196a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f5196a == fVar.f5196a || this.f5196a.equals(fVar.f5196a);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f5196a);
    }

    public int hashCode() {
        return this.f5196a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f5196a);
        } catch (NumberFormatException e2) {
            try {
                return (int) Long.parseLong(this.f5196a);
            } catch (NumberFormatException e3) {
                return new BigDecimal(this.f5196a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f5196a);
        } catch (NumberFormatException e2) {
            return new BigDecimal(this.f5196a).longValue();
        }
    }

    public String toString() {
        return this.f5196a;
    }
}
