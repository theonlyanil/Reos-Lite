package com.google.b.g;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class k implements com.google.b.k {
    protected static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += iArr[i3];
            i += iArr2[i3];
        }
        if (i2 < i) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2 / i;
        float f4 = f2 * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = ((float) i5) > f6 ? i5 - f6 : f6 - i5;
            if (f7 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f7;
        }
        return f5 / i2;
    }

    protected static void a(com.google.b.c.a aVar, int i, int[] iArr) throws com.google.b.i {
        int i2;
        boolean z;
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int iA = aVar.a();
        if (i >= iA) {
            throw com.google.b.i.a();
        }
        boolean z2 = !aVar.a(i);
        int i3 = 0;
        while (true) {
            if (i >= iA) {
                i2 = i3;
                break;
            }
            if (aVar.a(i) ^ z2) {
                iArr[i3] = iArr[i3] + 1;
                z = z2;
            } else {
                i2 = i3 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z2;
                i3 = i2;
            }
            i++;
            z2 = z;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iA) {
                throw com.google.b.i.a();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00e3  */
    private com.google.b.m b(com.google.b.c cVar, Map<com.google.b.e, ?> map) throws com.google.b.i {
        Map<com.google.b.e, ?> enumMap;
        int iA = cVar.a();
        int iB = cVar.b();
        com.google.b.c.a aVar = new com.google.b.c.a(iA);
        int i = iB >> 1;
        boolean z = map != null && map.containsKey(com.google.b.e.TRY_HARDER);
        int iMax = Math.max(1, iB >> (z ? 8 : 5));
        int i2 = z ? iB : 15;
        com.google.b.c.a aVarA = aVar;
        Map<com.google.b.e, ?> map2 = map;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i3 + 1) / 2;
            if (!((i3 & 1) == 0)) {
                i4 = -i4;
            }
            int i5 = i + (i4 * iMax);
            if (i5 < 0 || i5 >= iB) {
                break;
            }
            try {
                aVarA = cVar.a(i5, aVarA);
                int i6 = 0;
                while (i6 < 2) {
                    if (i6 == 1) {
                        aVarA.d();
                        if (map2 == null || !map2.containsKey(com.google.b.e.NEED_RESULT_POINT_CALLBACK)) {
                            enumMap = map2;
                        } else {
                            enumMap = new EnumMap<>(com.google.b.e.class);
                            enumMap.putAll(map2);
                            enumMap.remove(com.google.b.e.NEED_RESULT_POINT_CALLBACK);
                        }
                    } else {
                        enumMap = map2;
                    }
                    try {
                        com.google.b.m mVarA = a(i5, aVarA, enumMap);
                        if (i6 == 1) {
                            mVarA.a(com.google.b.n.ORIENTATION, 180);
                            com.google.b.o[] oVarArrC = mVarA.c();
                            if (oVarArrC != null) {
                                oVarArrC[0] = new com.google.b.o((iA - oVarArrC[0].a()) - 1.0f, oVarArrC[0].b());
                                oVarArrC[1] = new com.google.b.o((iA - oVarArrC[1].a()) - 1.0f, oVarArrC[1].b());
                            }
                        }
                        return mVarA;
                    } catch (com.google.b.l e2) {
                        i6++;
                        map2 = enumMap;
                    }
                }
            } catch (com.google.b.i e3) {
            }
        }
        throw com.google.b.i.a();
    }

    protected static void b(com.google.b.c.a aVar, int i, int[] iArr) throws com.google.b.i {
        int length = iArr.length;
        boolean zA = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != zA) {
                length--;
                zA = !zA;
            }
        }
        if (length >= 0) {
            throw com.google.b.i.a();
        }
        a(aVar, i + 1, iArr);
    }

    public abstract com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d;

    @Override // com.google.b.k
    public com.google.b.m a(com.google.b.c cVar) throws com.google.b.i, com.google.b.f {
        return a(cVar, null);
    }

    @Override // com.google.b.k
    public com.google.b.m a(com.google.b.c cVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f {
        try {
            return b(cVar, map);
        } catch (com.google.b.i e2) {
            if (!(map != null && map.containsKey(com.google.b.e.TRY_HARDER)) || !cVar.d()) {
                throw e2;
            }
            com.google.b.c cVarE = cVar.e();
            com.google.b.m mVarB = b(cVarE, map);
            Map<com.google.b.n, Object> mapE = mVarB.e();
            mVarB.a(com.google.b.n.ORIENTATION, Integer.valueOf((mapE == null || !mapE.containsKey(com.google.b.n.ORIENTATION)) ? 270 : (((Integer) mapE.get(com.google.b.n.ORIENTATION)).intValue() + 270) % 360));
            com.google.b.o[] oVarArrC = mVarB.c();
            if (oVarArrC != null) {
                int iB = cVarE.b();
                for (int i = 0; i < oVarArrC.length; i++) {
                    oVarArrC[i] = new com.google.b.o((iB - oVarArrC[i].b()) - 1.0f, oVarArrC[i].a());
                }
            }
            return mVarB;
        }
    }

    @Override // com.google.b.k
    public void a() {
    }
}
