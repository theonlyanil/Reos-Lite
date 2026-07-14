package com.google.b;

import com.flurry.android.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5543b;

    protected g(int i, int i2) {
        this.f5542a = i;
        this.f5543b = i2;
    }

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    public final int b() {
        return this.f5542a;
    }

    public final int c() {
        return this.f5543b;
    }

    public boolean d() {
        return false;
    }

    public g e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c2;
        byte[] bArr = new byte[this.f5542a];
        StringBuilder sb = new StringBuilder(this.f5543b * (this.f5542a + 1));
        byte[] bArrA = bArr;
        for (int i = 0; i < this.f5543b; i++) {
            bArrA = a(i, bArrA);
            for (int i2 = 0; i2 < this.f5542a; i2++) {
                int i3 = bArrA[i2] & Constants.UNKNOWN;
                if (i3 < 64) {
                    c2 = '#';
                } else if (i3 < 128) {
                    c2 = '+';
                } else {
                    c2 = i3 < 192 ? '.' : ' ';
                }
                sb.append(c2);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
