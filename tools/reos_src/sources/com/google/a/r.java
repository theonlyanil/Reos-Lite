package com.google.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class r extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f5274a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f5275b;

    public r(Boolean bool) {
        a(bool);
    }

    public r(Number number) {
        a(number);
    }

    public r(String str) {
        a(str);
    }

    private static boolean a(r rVar) {
        if (!(rVar.f5275b instanceof Number)) {
            return false;
        }
        Number number = (Number) rVar.f5275b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f5274a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.a.l
    public Number a() {
        return this.f5275b instanceof String ? new com.google.a.b.f((String) this.f5275b) : (Number) this.f5275b;
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.f5275b = String.valueOf(((Character) obj).charValue());
        } else {
            com.google.a.b.a.a((obj instanceof Number) || b(obj));
            this.f5275b = obj;
        }
    }

    @Override // com.google.a.l
    public String b() {
        if (p()) {
            return a().toString();
        }
        return o() ? n().toString() : (String) this.f5275b;
    }

    @Override // com.google.a.l
    public double c() {
        return p() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.google.a.l
    public long d() {
        return p() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.google.a.l
    public int e() {
        return p() ? a().intValue() : Integer.parseInt(b());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f5275b == null) {
            return rVar.f5275b == null;
        }
        if (a(this) && a(rVar)) {
            return a().longValue() == rVar.a().longValue();
        }
        if (!(this.f5275b instanceof Number) || !(rVar.f5275b instanceof Number)) {
            return this.f5275b.equals(rVar.f5275b);
        }
        double dDoubleValue = a().doubleValue();
        double dDoubleValue2 = rVar.a().doubleValue();
        if (dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2))) {
            z = true;
        }
        return z;
    }

    @Override // com.google.a.l
    public boolean f() {
        return o() ? n().booleanValue() : Boolean.parseBoolean(b());
    }

    public int hashCode() {
        if (this.f5275b == null) {
            return 31;
        }
        if (a(this)) {
            long jLongValue = a().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (!(this.f5275b instanceof Number)) {
            return this.f5275b.hashCode();
        }
        long jDoubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    @Override // com.google.a.l
    Boolean n() {
        return (Boolean) this.f5275b;
    }

    public boolean o() {
        return this.f5275b instanceof Boolean;
    }

    public boolean p() {
        return this.f5275b instanceof Number;
    }

    public boolean q() {
        return this.f5275b instanceof String;
    }
}
