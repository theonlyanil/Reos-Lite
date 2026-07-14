package com.google.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5790b;

    public o(float f2, float f3) {
        this.f5789a = f2;
        this.f5790b = f3;
    }

    public static float a(o oVar, o oVar2) {
        return com.google.b.c.a.a.a(oVar.f5789a, oVar.f5790b, oVar2.f5789a, oVar2.f5790b);
    }

    private static float a(o oVar, o oVar2, o oVar3) {
        float f2 = oVar2.f5789a;
        float f3 = oVar2.f5790b;
        return ((oVar3.f5789a - f2) * (oVar.f5790b - f3)) - ((oVar.f5789a - f2) * (oVar3.f5790b - f3));
    }

    public static void a(o[] oVarArr) {
        o oVar;
        o oVar2;
        o oVar3;
        float fA = a(oVarArr[0], oVarArr[1]);
        float fA2 = a(oVarArr[1], oVarArr[2]);
        float fA3 = a(oVarArr[0], oVarArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            oVar = oVarArr[0];
            oVar2 = oVarArr[1];
            oVar3 = oVarArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            oVar = oVarArr[2];
            oVar2 = oVarArr[0];
            oVar3 = oVarArr[1];
        } else {
            oVar = oVarArr[1];
            oVar2 = oVarArr[0];
            oVar3 = oVarArr[2];
        }
        if (a(oVar2, oVar, oVar3) >= BitmapDescriptorFactory.HUE_RED) {
            o oVar4 = oVar3;
            oVar3 = oVar2;
            oVar2 = oVar4;
        }
        oVarArr[0] = oVar3;
        oVarArr[1] = oVar;
        oVarArr[2] = oVar2;
    }

    public final float a() {
        return this.f5789a;
    }

    public final float b() {
        return this.f5790b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f5789a == oVar.f5789a && this.f5790b == oVar.f5790b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f5789a) * 31) + Float.floatToIntBits(this.f5790b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f5789a);
        sb.append(',');
        sb.append(this.f5790b);
        sb.append(')');
        return sb.toString();
    }
}
