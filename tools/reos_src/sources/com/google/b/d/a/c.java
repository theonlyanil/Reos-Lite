package com.google.b.d.a;

import com.google.b.f;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5488a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5489b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f5490c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f5491d = f5489b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f5492e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    private enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    static com.google.b.c.e a(byte[] bArr) throws f {
        ArrayList arrayList;
        com.google.b.c.c cVar = new com.google.b.c.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList2 = new ArrayList(1);
        a aVarA = a.ASCII_ENCODE;
        do {
            if (aVarA == a.ASCII_ENCODE) {
                aVarA = a(cVar, sb, sb2);
            } else {
                switch (aVarA) {
                    case C40_ENCODE:
                        a(cVar, sb);
                        break;
                    case TEXT_ENCODE:
                        b(cVar, sb);
                        break;
                    case ANSIX12_ENCODE:
                        c(cVar, sb);
                        break;
                    case EDIFACT_ENCODE:
                        d(cVar, sb);
                        break;
                    case BASE256_ENCODE:
                        a(cVar, sb, arrayList2);
                        break;
                    default:
                        throw f.a();
                }
                aVarA = a.ASCII_ENCODE;
            }
            if (aVarA != a.PAD_ENCODE) {
            }
            if (sb2.length() > 0) {
                sb.append((CharSequence) sb2);
            }
            String string = sb.toString();
            if (arrayList2.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
            }
            return new com.google.b.c.e(bArr, string, arrayList, null);
        } while (cVar.c() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string2 = sb.toString();
        if (arrayList2.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = arrayList2;
        }
        return new com.google.b.c.e(bArr, string2, arrayList, null);
    }

    private static a a(com.google.b.c.c cVar, StringBuilder sb, StringBuilder sb2) throws f {
        boolean z = false;
        do {
            int iA = cVar.a(8);
            if (iA == 0) {
                throw f.a();
            }
            if (iA <= 128) {
                sb.append((char) ((z ? iA + 128 : iA) - 1));
                return a.ASCII_ENCODE;
            }
            if (iA == 129) {
                return a.PAD_ENCODE;
            }
            if (iA <= 229) {
                int i = iA - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                if (iA == 230) {
                    return a.C40_ENCODE;
                }
                if (iA == 231) {
                    return a.BASE256_ENCODE;
                }
                if (iA == 232) {
                    sb.append((char) 29);
                } else if (iA != 233 && iA != 234) {
                    if (iA == 235) {
                        z = true;
                    } else if (iA == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (iA == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (iA == 238) {
                            return a.ANSIX12_ENCODE;
                        }
                        if (iA == 239) {
                            return a.TEXT_ENCODE;
                        }
                        if (iA == 240) {
                            return a.EDIFACT_ENCODE;
                        }
                        if (iA != 241 && iA >= 242 && (iA != 254 || cVar.c() != 0)) {
                            throw f.a();
                        }
                    }
                }
            }
        } while (cVar.c() > 0);
        return a.ASCII_ENCODE;
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void a(com.google.b.c.c cVar, StringBuilder sb) throws f {
        int iA;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (cVar.c() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 >= 3) {
                            if (i3 >= f5488a.length) {
                                throw f.a();
                            }
                            char c2 = f5488a[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                            } else {
                                sb.append(c2);
                            }
                        } else {
                            i = i3 + 1;
                        }
                        break;
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < f5489b.length) {
                            char c3 = f5489b[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else {
                            if (i3 != 30) {
                                throw f.a();
                            }
                            z = true;
                        }
                        i = 0;
                        break;
                    case 3:
                        if (z) {
                            sb.append((char) (i3 + 224));
                            z = false;
                        } else {
                            sb.append((char) (i3 + 96));
                        }
                        i = 0;
                        break;
                    default:
                        throw f.a();
                }
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }

    private static void a(com.google.b.c.c cVar, StringBuilder sb, Collection<byte[]> collection) throws f {
        int iA;
        int iB = cVar.b() + 1;
        int i = iB + 1;
        int iA2 = a(cVar.a(8), iB);
        if (iA2 == 0) {
            iA = cVar.c() / 8;
        } else if (iA2 < 250) {
            iA = iA2;
        } else {
            iA = ((iA2 - 249) * 250) + a(cVar.a(8), i);
            i++;
        }
        if (iA < 0) {
            throw f.a();
        }
        byte[] bArr = new byte[iA];
        int i2 = 0;
        while (i2 < iA) {
            if (cVar.c() < 8) {
                throw f.a();
            }
            bArr[i2] = (byte) a(cVar.a(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: " + e2);
        }
    }

    private static void b(com.google.b.c.c cVar, StringBuilder sb) throws f {
        int iA;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (cVar.c() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 >= 3) {
                            if (i3 >= f5490c.length) {
                                throw f.a();
                            }
                            char c2 = f5490c[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                            } else {
                                sb.append(c2);
                            }
                        } else {
                            i = i3 + 1;
                        }
                        break;
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < f5491d.length) {
                            char c3 = f5491d[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else {
                            if (i3 != 30) {
                                throw f.a();
                            }
                            z = true;
                        }
                        i = 0;
                        break;
                    case 3:
                        if (i3 >= f5492e.length) {
                            throw f.a();
                        }
                        char c4 = f5492e[i3];
                        if (z) {
                            sb.append((char) (c4 + 128));
                            z = false;
                        } else {
                            sb.append(c4);
                        }
                        i = 0;
                        break;
                        break;
                    default:
                        throw f.a();
                }
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }

    private static void c(com.google.b.c.c cVar, StringBuilder sb) throws f {
        int iA;
        int[] iArr = new int[3];
        while (cVar.c() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw f.a();
                    }
                    sb.append((char) (i2 + 51));
                }
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }

    private static void d(com.google.b.c.c cVar, StringBuilder sb) {
        while (cVar.c() > 16) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 4) {
                    int iA = cVar.a(6);
                    if (iA == 31) {
                        int iA2 = 8 - cVar.a();
                        if (iA2 != 8) {
                            cVar.a(iA2);
                            return;
                        }
                        return;
                    }
                    if ((iA & 32) == 0) {
                        iA |= 64;
                    }
                    sb.append((char) iA);
                    i = i2 + 1;
                }
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }
}
