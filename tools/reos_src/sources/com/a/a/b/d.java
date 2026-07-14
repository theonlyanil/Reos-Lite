package com.a.a.b;

import android.util.Log;
import com.flurry.android.Constants;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f2000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f2001c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f1999a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2002d = 0;

    private int[] a(int i) {
        int[] iArr;
        BufferUnderflowException e2;
        int i2 = 0;
        byte[] bArr = new byte[i * 3];
        try {
            this.f2000b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & Constants.UNKNOWN;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & Constants.UNKNOWN;
                    i3 = i6 + 1;
                    int i8 = i2 + 1;
                    iArr[i2] = (i5 << 16) | (-16777216) | (i7 << 8) | (bArr[i6] & Constants.UNKNOWN);
                    i2 = i8;
                } catch (BufferUnderflowException e3) {
                    e2 = e3;
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
                    }
                    this.f2001c.f1994b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException e4) {
            iArr = null;
            e2 = e4;
        }
        return iArr;
    }

    private void c() {
        this.f2000b = null;
        Arrays.fill(this.f1999a, (byte) 0);
        this.f2001c = new c();
        this.f2002d = 0;
    }

    private void d() {
        boolean z = false;
        while (!z && !o()) {
            switch (m()) {
                case 33:
                    switch (m()) {
                        case 1:
                            k();
                            break;
                        case 249:
                            this.f2001c.f1996d = new b();
                            e();
                            break;
                        case 254:
                            k();
                            break;
                        case 255:
                            l();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.f1999a[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                g();
                            } else {
                                k();
                            }
                            break;
                        default:
                            k();
                            break;
                    }
                    break;
                case 44:
                    if (this.f2001c.f1996d == null) {
                        this.f2001c.f1996d = new b();
                    }
                    f();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.f2001c.f1994b = 1;
                    break;
            }
        }
    }

    private void e() {
        m();
        int iM = m();
        this.f2001c.f1996d.g = (iM & 28) >> 2;
        if (this.f2001c.f1996d.g == 0) {
            this.f2001c.f1996d.g = 1;
        }
        this.f2001c.f1996d.f1992f = (iM & 1) != 0;
        int iN = n();
        if (iN < 3) {
            iN = 10;
        }
        this.f2001c.f1996d.i = iN * 10;
        this.f2001c.f1996d.h = m();
        m();
    }

    private void f() {
        this.f2001c.f1996d.f1987a = n();
        this.f2001c.f1996d.f1988b = n();
        this.f2001c.f1996d.f1989c = n();
        this.f2001c.f1996d.f1990d = n();
        int iM = m();
        boolean z = (iM & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iM & 7) + 1);
        this.f2001c.f1996d.f1991e = (iM & 64) != 0;
        if (z) {
            this.f2001c.f1996d.k = a(iPow);
        } else {
            this.f2001c.f1996d.k = null;
        }
        this.f2001c.f1996d.j = this.f2000b.position();
        j();
        if (o()) {
            return;
        }
        this.f2001c.f1995c++;
        this.f2001c.f1997e.add(this.f2001c.f1996d);
    }

    private void g() {
        do {
            l();
            if (this.f1999a[0] == 1) {
                this.f2001c.m = (this.f1999a[1] & Constants.UNKNOWN) | ((this.f1999a[2] & Constants.UNKNOWN) << 8);
            }
            if (this.f2002d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m());
        }
        if (!str.startsWith("GIF")) {
            this.f2001c.f1994b = 1;
            return;
        }
        i();
        if (!this.f2001c.h || o()) {
            return;
        }
        this.f2001c.f1993a = a(this.f2001c.i);
        this.f2001c.l = this.f2001c.f1993a[this.f2001c.j];
    }

    private void i() {
        this.f2001c.f1998f = n();
        this.f2001c.g = n();
        int iM = m();
        this.f2001c.h = (iM & 128) != 0;
        this.f2001c.i = 2 << (iM & 7);
        this.f2001c.j = m();
        this.f2001c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int iM;
        do {
            iM = m();
            this.f2000b.position(this.f2000b.position() + iM);
        } while (iM > 0);
    }

    private int l() {
        int i = 0;
        this.f2002d = m();
        if (this.f2002d > 0) {
            int i2 = 0;
            while (i < this.f2002d) {
                try {
                    i2 = this.f2002d - i;
                    this.f2000b.get(this.f1999a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f2002d, e2);
                    }
                    this.f2001c.f1994b = 1;
                }
            }
        }
        return i;
    }

    private int m() {
        try {
            return this.f2000b.get() & Constants.UNKNOWN;
        } catch (Exception e2) {
            this.f2001c.f1994b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f2000b.getShort();
    }

    private boolean o() {
        return this.f2001c.f1994b != 0;
    }

    public d a(byte[] bArr) {
        c();
        if (bArr != null) {
            this.f2000b = ByteBuffer.wrap(bArr);
            this.f2000b.rewind();
            this.f2000b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f2000b = null;
            this.f2001c.f1994b = 2;
        }
        return this;
    }

    public void a() {
        this.f2000b = null;
        this.f2001c = null;
    }

    public c b() {
        if (this.f2000b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (o()) {
            return this.f2001c;
        }
        h();
        if (!o()) {
            d();
            if (this.f2001c.f1995c < 0) {
                this.f2001c.f1994b = 1;
            }
        }
        return this.f2001c;
    }
}
