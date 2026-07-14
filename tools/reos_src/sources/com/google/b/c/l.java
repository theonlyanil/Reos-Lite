package com.google.b.c;

import com.flurry.android.Constants;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5478a = Charset.defaultCharset().name();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f5479b;

    static {
        f5479b = "SJIS".equalsIgnoreCase(f5478a) || "EUC_JP".equalsIgnoreCase(f5478a);
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01f1  */
    public static String a(byte[] bArr, Map<com.google.b.e, ?> map) {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        String str;
        if (map != null && (str = (String) map.get(com.google.b.e.CHARACTER_SET)) != null) {
            return str;
        }
        int length = bArr.length;
        boolean z3 = true;
        boolean z4 = true;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        boolean z5 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z6 = true;
        while (i15 < length && (z3 || z4 || z6)) {
            int i18 = bArr[i15] & Constants.UNKNOWN;
            if (!z6) {
                z = z6;
            } else if (i6 > 0) {
                if ((i18 & 128) == 0) {
                    z = false;
                } else {
                    i6--;
                    z = z6;
                }
            } else if ((i18 & 128) == 0) {
                z = z6;
            } else if ((i18 & 64) == 0) {
                z = false;
            } else {
                i6++;
                if ((i18 & 32) == 0) {
                    i7++;
                    z = z6;
                } else {
                    i6++;
                    if ((i18 & 16) == 0) {
                        i8++;
                        z = z6;
                    } else {
                        i6++;
                        if ((i18 & 8) == 0) {
                            i9++;
                            z = z6;
                        } else {
                            z = false;
                        }
                    }
                }
            }
            if (z3) {
                if (i18 > 127 && i18 < 160) {
                    z3 = false;
                } else if (i18 > 159 && (i18 < 192 || i18 == 215 || i18 == 247)) {
                    i14++;
                }
            }
            if (!z4) {
                i = i12;
                i2 = i11;
                i3 = i10;
                z2 = z4;
                int i19 = i13;
                i4 = i17;
                i5 = i19;
            } else if (i10 > 0) {
                if (i18 < 64 || i18 == 127 || i18 > 252) {
                    int i20 = i13;
                    i4 = i17;
                    i5 = i20;
                    int i21 = i12;
                    i2 = i11;
                    i3 = i10;
                    z2 = false;
                    i = i21;
                } else {
                    int i22 = i10 - 1;
                    z2 = z4;
                    int i23 = i17;
                    i5 = i13;
                    i4 = i23;
                    int i24 = i11;
                    i3 = i22;
                    i = i12;
                    i2 = i24;
                }
            } else if (i18 == 128 || i18 == 160 || i18 > 239) {
                int i25 = i13;
                i4 = i17;
                i5 = i25;
                int i26 = i12;
                i2 = i11;
                i3 = i10;
                z2 = false;
                i = i26;
            } else if (i18 > 160 && i18 < 224) {
                int i27 = i11 + 1;
                i5 = i12 + 1;
                if (i5 > i13) {
                    i4 = 0;
                    i2 = i27;
                    i = i5;
                    i3 = i10;
                    z2 = z4;
                } else {
                    i2 = i27;
                    i3 = i10;
                    z2 = z4;
                    int i28 = i13;
                    i4 = 0;
                    i = i5;
                    i5 = i28;
                }
            } else if (i18 > 127) {
                int i29 = i10 + 1;
                i = 0;
                int i30 = i17 + 1;
                if (i30 > i16) {
                    i16 = i30;
                    z2 = z4;
                    i5 = i13;
                    i4 = i30;
                    i2 = i11;
                    i3 = i29;
                } else {
                    z2 = z4;
                    i5 = i13;
                    i4 = i30;
                    i2 = i11;
                    i3 = i29;
                }
            } else {
                i = 0;
                i2 = i11;
                i3 = i10;
                z2 = z4;
                i5 = i13;
                i4 = 0;
            }
            i15++;
            z4 = z2;
            i10 = i3;
            i11 = i2;
            i12 = i;
            z6 = z;
            int i31 = i4;
            i13 = i5;
            i17 = i31;
        }
        boolean z7 = (!z6 || i6 <= 0) ? z6 : false;
        if (z4 && i10 > 0) {
            z4 = false;
        }
        if (z7 && (z5 || i7 + i8 + i9 > 0)) {
            return "UTF8";
        }
        if (z4 && (f5479b || i13 >= 3 || i16 >= 3)) {
            return "SJIS";
        }
        if (z3 && z4) {
            return (!(i13 == 2 && i11 == 2) && i14 * 10 < length) ? "ISO8859_1" : "SJIS";
        }
        if (z3) {
            return "ISO8859_1";
        }
        if (z4) {
            return "SJIS";
        }
        return z7 ? "UTF8" : f5478a;
    }
}
