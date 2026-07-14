package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
abstract class h extends j {
    h(com.google.b.c.a aVar) {
        super(aVar);
    }

    private static void a(StringBuilder sb, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3 + i) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
    }

    protected final void a(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iA = c().a((i3 * 10) + i, 10);
            if (iA / 100 == 0) {
                sb.append('0');
            }
            if (iA / 10 == 0) {
                sb.append('0');
            }
            sb.append(iA);
        }
        a(sb, i2);
    }

    protected final void b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        a(sb, i, length);
    }
}
