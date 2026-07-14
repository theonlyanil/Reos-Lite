package com.google.b;

/* JADX INFO: loaded from: classes.dex */
public final class j extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f5771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5775e;

    public j(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f5771a = bArr;
        this.f5772b = i;
        this.f5773c = i2;
        this.f5774d = i3;
        this.f5775e = i4;
        if (z) {
            a(i5, i6);
        }
    }

    private void a(int i, int i2) {
        byte[] bArr = this.f5771a;
        int i3 = this.f5774d + (this.f5775e * this.f5772b);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (i / 2);
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b2 = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b2;
                i7++;
                i6--;
            }
            i3 += this.f5772b;
        }
    }

    @Override // com.google.b.g
    public byte[] a() {
        int iB = b();
        int iC = c();
        if (iB == this.f5772b && iC == this.f5773c) {
            return this.f5771a;
        }
        int i = iB * iC;
        byte[] bArr = new byte[i];
        int i2 = (this.f5775e * this.f5772b) + this.f5774d;
        if (iB == this.f5772b) {
            System.arraycopy(this.f5771a, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f5771a;
        for (int i3 = 0; i3 < iC; i3++) {
            System.arraycopy(bArr2, i2, bArr, i3 * iB, iB);
            i2 += this.f5772b;
        }
        return bArr;
    }

    @Override // com.google.b.g
    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int iB = b();
        if (bArr == null || bArr.length < iB) {
            bArr = new byte[iB];
        }
        System.arraycopy(this.f5771a, ((this.f5775e + i) * this.f5772b) + this.f5774d, bArr, 0, iB);
        return bArr;
    }
}
