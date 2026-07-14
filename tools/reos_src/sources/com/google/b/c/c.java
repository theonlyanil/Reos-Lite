package com.google.b.c;

import com.flurry.android.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f5450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5452c;

    public c(byte[] bArr) {
        this.f5450a = bArr;
    }

    public int a() {
        return this.f5452c;
    }

    public int a(int i) {
        int i2;
        int i3;
        if (i < 1 || i > 32 || i > c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.f5452c > 0) {
            int i4 = 8 - this.f5452c;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            int i7 = (((255 >> (8 - i5)) << i6) & this.f5450a[this.f5451b]) >> i6;
            int i8 = i - i5;
            this.f5452c = i5 + this.f5452c;
            if (this.f5452c == 8) {
                this.f5452c = 0;
                this.f5451b++;
            }
            i2 = i7;
            i3 = i8;
        } else {
            i2 = 0;
            i3 = i;
        }
        if (i3 <= 0) {
            return i2;
        }
        while (i3 >= 8) {
            i2 = (i2 << 8) | (this.f5450a[this.f5451b] & Constants.UNKNOWN);
            this.f5451b++;
            i3 -= 8;
        }
        if (i3 <= 0) {
            return i2;
        }
        int i9 = 8 - i3;
        int i10 = (i2 << i3) | ((((255 >> i9) << i9) & this.f5450a[this.f5451b]) >> i9);
        this.f5452c = i3 + this.f5452c;
        return i10;
    }

    public int b() {
        return this.f5451b;
    }

    public int c() {
        return ((this.f5450a.length - this.f5451b) * 8) - this.f5452c;
    }
}
