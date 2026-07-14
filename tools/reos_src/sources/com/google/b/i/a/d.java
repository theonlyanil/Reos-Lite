package com.google.b.i.a;

import com.google.b.c.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5721a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    private static char a(int i) throws com.google.b.f {
        if (i >= f5721a.length) {
            throw com.google.b.f.a();
        }
        return f5721a[i];
    }

    private static int a(com.google.b.c.c cVar) throws com.google.b.f {
        int iA = cVar.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return ((iA & 63) << 8) | cVar.a(8);
        }
        if ((iA & 224) != 192) {
            throw com.google.b.f.a();
        }
        return ((iA & 31) << 16) | cVar.a(16);
    }

    static com.google.b.c.e a(byte[] bArr, j jVar, f fVar, Map<com.google.b.e, ?> map) throws com.google.b.f {
        h hVarA;
        com.google.b.c.c cVar = new com.google.b.c.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iA = -1;
        int iA2 = -1;
        com.google.b.c.d dVarA = null;
        boolean z = false;
        do {
            try {
                int i = iA2;
                int i2 = iA;
                boolean z2 = z;
                hVarA = cVar.c() < 4 ? h.TERMINATOR : h.a(cVar.a(4));
                if (hVarA == h.TERMINATOR) {
                    z = z2;
                    iA = i2;
                    iA2 = i;
                } else if (hVarA == h.FNC1_FIRST_POSITION || hVarA == h.FNC1_SECOND_POSITION) {
                    z = true;
                    iA = i2;
                    iA2 = i;
                } else if (hVarA == h.STRUCTURED_APPEND) {
                    if (cVar.c() < 16) {
                        throw com.google.b.f.a();
                    }
                    z = z2;
                    iA = cVar.a(8);
                    iA2 = cVar.a(8);
                } else if (hVarA == h.ECI) {
                    dVarA = com.google.b.c.d.a(a(cVar));
                    if (dVarA == null) {
                        throw com.google.b.f.a();
                    }
                    z = z2;
                    iA = i2;
                    iA2 = i;
                } else if (hVarA == h.HANZI) {
                    int iA3 = cVar.a(4);
                    int iA4 = cVar.a(hVarA.a(jVar));
                    if (iA3 == 1) {
                        a(cVar, sb, iA4);
                    }
                    z = z2;
                    iA = i2;
                    iA2 = i;
                } else {
                    int iA5 = cVar.a(hVarA.a(jVar));
                    if (hVarA == h.NUMERIC) {
                        c(cVar, sb, iA5);
                        z = z2;
                        iA = i2;
                        iA2 = i;
                    } else if (hVarA == h.ALPHANUMERIC) {
                        a(cVar, sb, iA5, z2);
                        z = z2;
                        iA = i2;
                        iA2 = i;
                    } else if (hVarA == h.BYTE) {
                        a(cVar, sb, iA5, dVarA, arrayList, map);
                        z = z2;
                        iA = i2;
                        iA2 = i;
                    } else {
                        if (hVarA != h.KANJI) {
                            throw com.google.b.f.a();
                        }
                        b(cVar, sb, iA5);
                        z = z2;
                        iA = i2;
                        iA2 = i;
                    }
                }
            } catch (IllegalArgumentException e2) {
                throw com.google.b.f.a();
            }
        } while (hVarA != h.TERMINATOR);
        return new com.google.b.c.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), iA, iA2);
    }

    private static void a(com.google.b.c.c cVar, StringBuilder sb, int i) throws com.google.b.f {
        if (i * 13 > cVar.c()) {
            throw com.google.b.f.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iA = cVar.a(13);
            int i3 = (iA % 96) | ((iA / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) ((i4 >> 8) & 255);
            bArr[i2 + 1] = (byte) (i4 & 255);
            i--;
            i2 += 2;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e2) {
            throw com.google.b.f.a();
        }
    }

    private static void a(com.google.b.c.c cVar, StringBuilder sb, int i, com.google.b.c.d dVar, Collection<byte[]> collection, Map<com.google.b.e, ?> map) throws com.google.b.f {
        if (i * 8 > cVar.c()) {
            throw com.google.b.f.a();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) cVar.a(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException e2) {
            throw com.google.b.f.a();
        }
    }

    private static void a(com.google.b.c.c cVar, StringBuilder sb, int i, boolean z) throws com.google.b.f {
        while (i > 1) {
            if (cVar.c() < 11) {
                throw com.google.b.f.a();
            }
            int iA = cVar.a(11);
            sb.append(a(iA / 45));
            sb.append(a(iA % 45));
            i -= 2;
        }
        if (i == 1) {
            if (cVar.c() < 6) {
                throw com.google.b.f.a();
            }
            sb.append(a(cVar.a(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length >= sb.length() - 1 || sb.charAt(length + 1) != '%') {
                        sb.setCharAt(length, (char) 29);
                    } else {
                        sb.deleteCharAt(length + 1);
                    }
                }
            }
        }
    }

    private static void b(com.google.b.c.c cVar, StringBuilder sb, int i) throws com.google.b.f {
        if (i * 13 > cVar.c()) {
            throw com.google.b.f.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iA = cVar.a(13);
            int i3 = (iA % 192) | ((iA / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i--;
            i2 += 2;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e2) {
            throw com.google.b.f.a();
        }
    }

    private static void c(com.google.b.c.c cVar, StringBuilder sb, int i) throws com.google.b.f {
        while (i >= 3) {
            if (cVar.c() < 10) {
                throw com.google.b.f.a();
            }
            int iA = cVar.a(10);
            if (iA >= 1000) {
                throw com.google.b.f.a();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i -= 3;
        }
        if (i == 2) {
            if (cVar.c() < 7) {
                throw com.google.b.f.a();
            }
            int iA2 = cVar.a(7);
            if (iA2 >= 100) {
                throw com.google.b.f.a();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i == 1) {
            if (cVar.c() < 4) {
                throw com.google.b.f.a();
            }
            int iA3 = cVar.a(4);
            if (iA3 >= 10) {
                throw com.google.b.f.a();
            }
            sb.append(a(iA3));
        }
    }
}
