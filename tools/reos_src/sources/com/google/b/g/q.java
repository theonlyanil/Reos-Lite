package com.google.b.g;

/* JADX INFO: loaded from: classes.dex */
public final class q extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5648a = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[][] f5649f = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] g = new int[4];

    private static void a(StringBuilder sb, int i) throws com.google.b.i {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f5649f[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw com.google.b.i.a();
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }

    @Override // com.google.b.g.p
    protected int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        int[] iArr2 = this.g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iA = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < iA) {
            int iA2 = a(aVar, iArr2, i, f5645e);
            sb.append((char) ((iA2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA2 >= 10) {
                i3 |= 1 << (5 - i2);
            }
            i2++;
            i = i4;
        }
        a(sb, i3);
        return i;
    }

    @Override // com.google.b.g.p
    protected boolean a(String str) throws com.google.b.f {
        return super.a(b(str));
    }

    @Override // com.google.b.g.p
    protected int[] a(com.google.b.c.a aVar, int i) throws com.google.b.i {
        return a(aVar, i, true, f5648a);
    }

    @Override // com.google.b.g.p
    com.google.b.a b() {
        return com.google.b.a.UPC_E;
    }
}
