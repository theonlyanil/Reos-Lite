package a.a.a.a;

import com.flurry.android.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.a.a.a.b.a f6a = new a.a.a.a.b.a("PCM_FLOAT");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a.a.a.a.b f7b;

    /* JADX INFO: renamed from: a.a.a.a.a$a, reason: collision with other inner class name */
    private static class C0000a extends a {
        private C0000a() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = bArr[i] << 8;
                i = i5 + 1;
                fArr[i2] = ((short) ((bArr[i5] & Constants.UNKNOWN) | i6)) * 3.051851E-5f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class b extends a {
        private b() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = i2 + i3;
            while (i2 < i4) {
                int i5 = i + 1;
                int i6 = bArr[i] & Constants.UNKNOWN;
                i = i5 + 1;
                fArr[i2] = ((short) ((bArr[i5] << 8) | i6)) * 3.051851E-5f;
                i2++;
            }
            return fArr;
        }
    }

    private static class c extends a {
        private c() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = (bArr[i] & Constants.UNKNOWN) << 8;
                i = i5 + 1;
                fArr[i2] = ((i6 | (bArr[i5] & Constants.UNKNOWN)) - 32767) * 3.051851E-5f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class d extends a {
        private d() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = bArr[i] & Constants.UNKNOWN;
                i = i5 + 1;
                fArr[i2] = ((i6 | ((bArr[i5] & Constants.UNKNOWN) << 8)) - 32767) * 3.051851E-5f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class e extends a {
        private e() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = (bArr[i] & Constants.UNKNOWN) << 16;
                int i7 = i5 + 1;
                i = i7 + 1;
                int i8 = ((bArr[i5] & Constants.UNKNOWN) << 8) | i6 | (bArr[i7] & Constants.UNKNOWN);
                if (i8 > 8388607) {
                    i8 -= 16777216;
                }
                fArr[i2] = i8 * 1.192093E-7f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class f extends a {
        private f() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = bArr[i] & Constants.UNKNOWN;
                int i7 = i5 + 1;
                i = i7 + 1;
                int i8 = ((bArr[i5] & Constants.UNKNOWN) << 8) | i6 | ((bArr[i7] & Constants.UNKNOWN) << 16);
                if (i8 > 8388607) {
                    i8 -= 16777216;
                }
                fArr[i2] = i8 * 1.192093E-7f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class g extends a {
        private g() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = (bArr[i] & Constants.UNKNOWN) << 16;
                int i7 = i5 + 1;
                i = i7 + 1;
                fArr[i2] = (((((bArr[i5] & Constants.UNKNOWN) << 8) | i6) | (bArr[i7] & Constants.UNKNOWN)) - 8388607) * 1.192093E-7f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class h extends a {
        private h() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = bArr[i] & Constants.UNKNOWN;
                int i7 = i5 + 1;
                i = i7 + 1;
                fArr[i2] = (((((bArr[i5] & Constants.UNKNOWN) << 8) | i6) | ((bArr[i7] & Constants.UNKNOWN) << 16)) - 8388607) * 1.192093E-7f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class i extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ByteBuffer f8b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        FloatBuffer f9c;

        private i() {
            this.f8b = null;
            this.f9c = null;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = i3 * 4;
            if (this.f8b == null || this.f8b.capacity() < i4) {
                this.f8b = ByteBuffer.allocate(i4).order(ByteOrder.BIG_ENDIAN);
                this.f9c = this.f8b.asFloatBuffer();
            }
            this.f8b.position(0);
            this.f9c.position(0);
            this.f8b.put(bArr, i, i4);
            this.f9c.get(fArr, i2, i3);
            return fArr;
        }
    }

    private static class j extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ByteBuffer f10b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        FloatBuffer f11c;

        private j() {
            this.f10b = null;
            this.f11c = null;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = i3 * 4;
            if (this.f10b == null || this.f10b.capacity() < i4) {
                this.f10b = ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
                this.f11c = this.f10b.asFloatBuffer();
            }
            this.f10b.position(0);
            this.f11c.position(0);
            this.f10b.put(bArr, i, i4);
            this.f11c.get(fArr, i2, i3);
            return fArr;
        }
    }

    private static class k extends a {
        private k() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = ((bArr[i5] & Constants.UNKNOWN) << 16) | ((bArr[i] & Constants.UNKNOWN) << 24);
                int i8 = i6 + 1;
                i = i8 + 1;
                fArr[i2] = ((bArr[i8] & Constants.UNKNOWN) | i7 | ((bArr[i6] & Constants.UNKNOWN) << 8)) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class l extends a {
        private l() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = ((bArr[i5] & Constants.UNKNOWN) << 8) | (bArr[i] & Constants.UNKNOWN);
                int i8 = i6 + 1;
                i = i8 + 1;
                fArr[i2] = (((bArr[i8] & Constants.UNKNOWN) << 24) | i7 | ((bArr[i6] & Constants.UNKNOWN) << 16)) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class m extends a {
        private m() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = ((bArr[i5] & Constants.UNKNOWN) << 16) | ((bArr[i] & Constants.UNKNOWN) << 24);
                int i8 = i6 + 1;
                i = i8 + 1;
                fArr[i2] = (((i7 | ((bArr[i6] & Constants.UNKNOWN) << 8)) | (bArr[i8] & Constants.UNKNOWN)) - Integer.MAX_VALUE) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class n extends a {
        private n() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = ((bArr[i5] & Constants.UNKNOWN) << 8) | (bArr[i] & Constants.UNKNOWN);
                int i8 = i6 + 1;
                i = i8 + 1;
                fArr[i2] = (((i7 | ((bArr[i6] & Constants.UNKNOWN) << 16)) | ((bArr[i8] & Constants.UNKNOWN) << 24)) - Integer.MAX_VALUE) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class o extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f12b;

        public o(int i) {
            this.f12b = i;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((bArr[i5] & Constants.UNKNOWN) << 16) | ((bArr[i] & Constants.UNKNOWN) << 24) | ((bArr[i6] & Constants.UNKNOWN) << 8);
                int i9 = i7 + 1;
                int i10 = (bArr[i7] & Constants.UNKNOWN) | i8;
                i = i9 + this.f12b;
                fArr[i2] = i10 * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class p extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f13b;

        public p(int i) {
            this.f13b = i;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = this.f13b + i;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = (bArr[i5] & Constants.UNKNOWN) | ((bArr[i6] & Constants.UNKNOWN) << 8);
                int i9 = i7 + 1;
                i = i9 + 1;
                fArr[i2] = (((bArr[i9] & Constants.UNKNOWN) << 24) | i8 | ((bArr[i7] & Constants.UNKNOWN) << 16)) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class q extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f14b;

        public q(int i) {
            this.f14b = i;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((bArr[i5] & Constants.UNKNOWN) << 16) | ((bArr[i] & Constants.UNKNOWN) << 24) | ((bArr[i6] & Constants.UNKNOWN) << 8) | (bArr[i7] & Constants.UNKNOWN);
                i = i7 + 1 + this.f14b;
                fArr[i2] = (i8 - Integer.MAX_VALUE) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class r extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f15b;

        public r(int i) {
            this.f15b = i;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = this.f15b + i;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = (bArr[i5] & Constants.UNKNOWN) | ((bArr[i6] & Constants.UNKNOWN) << 8);
                int i9 = i7 + 1;
                i = i9 + 1;
                fArr[i2] = (((i8 | ((bArr[i7] & Constants.UNKNOWN) << 16)) | ((bArr[i9] & Constants.UNKNOWN) << 24)) - Integer.MAX_VALUE) * 4.656613E-10f;
                i4++;
                i2++;
            }
            return fArr;
        }
    }

    private static class s extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ByteBuffer f16b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        DoubleBuffer f17c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double[] f18d;

        private s() {
            this.f16b = null;
            this.f17c = null;
            this.f18d = null;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = i3 * 8;
            if (this.f16b == null || this.f16b.capacity() < i4) {
                this.f16b = ByteBuffer.allocate(i4).order(ByteOrder.BIG_ENDIAN);
                this.f17c = this.f16b.asDoubleBuffer();
            }
            this.f16b.position(0);
            this.f17c.position(0);
            this.f16b.put(bArr, i, i4);
            if (this.f18d == null || this.f18d.length < i3 + i2) {
                this.f18d = new double[i3 + i2];
            }
            this.f17c.get(this.f18d, i2, i3);
            int i5 = i2 + i3;
            while (i2 < i5) {
                fArr[i2] = (float) this.f18d[i2];
                i2++;
            }
            return fArr;
        }
    }

    private static class t extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ByteBuffer f19b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        DoubleBuffer f20c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double[] f21d;

        private t() {
            this.f19b = null;
            this.f20c = null;
            this.f21d = null;
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = i3 * 8;
            if (this.f19b == null || this.f19b.capacity() < i4) {
                this.f19b = ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
                this.f20c = this.f19b.asDoubleBuffer();
            }
            this.f19b.position(0);
            this.f20c.position(0);
            this.f19b.put(bArr, i, i4);
            if (this.f21d == null || this.f21d.length < i3 + i2) {
                this.f21d = new double[i3 + i2];
            }
            this.f20c.get(this.f21d, i2, i3);
            int i5 = i2 + i3;
            while (i2 < i5) {
                fArr[i2] = (float) this.f21d[i2];
                i2++;
            }
            return fArr;
        }
    }

    private static class u extends a {
        private u() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                fArr[i2] = bArr[i] * 0.007874016f;
                i4++;
                i2++;
                i++;
            }
            return fArr;
        }
    }

    private static class v extends a {
        private v() {
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            int i4 = 0;
            while (i4 < i3) {
                fArr[i2] = ((bArr[i] & Constants.UNKNOWN) - 127) * 0.007874016f;
                i4++;
                i2++;
                i++;
            }
            return fArr;
        }
    }

    private static class w extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f22b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f23c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f24d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte f25e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f26f;

        public w(a aVar, a.a.a.a.b bVar) {
            int iC = bVar.c();
            boolean zG = bVar.g();
            this.f22b = aVar;
            this.f24d = (iC + 7) / 8;
            this.f23c = zG ? this.f24d - 1 : 0;
            int i = iC % 8;
            if (i == 0) {
                this.f25e = (byte) 0;
                return;
            }
            if (i == 1) {
                this.f25e = (byte) -128;
                return;
            }
            if (i == 2) {
                this.f25e = (byte) -64;
                return;
            }
            if (i == 3) {
                this.f25e = (byte) -32;
                return;
            }
            if (i == 4) {
                this.f25e = (byte) -16;
                return;
            }
            if (i == 5) {
                this.f25e = (byte) -8;
                return;
            }
            if (i == 6) {
                this.f25e = (byte) -4;
            } else if (i == 7) {
                this.f25e = (byte) -2;
            } else {
                this.f25e = (byte) -1;
            }
        }

        @Override // a.a.a.a.a
        public float[] a(byte[] bArr, int i, float[] fArr, int i2, int i3) {
            if (this.f26f == null || this.f26f.length < bArr.length) {
                this.f26f = new byte[bArr.length];
            }
            System.arraycopy(bArr, 0, this.f26f, 0, bArr.length);
            int i4 = i3 * this.f24d;
            int i5 = this.f23c + i;
            while (i5 < i4) {
                this.f26f[i5] = (byte) (this.f26f[i5] & this.f25e);
                i5 += this.f24d;
            }
            return this.f22b.a(this.f26f, i, fArr, i2, i3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0224  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a.a.a.a.a$1] */
    /* JADX WARN: Type inference failed for: r1v14, types: [a.a.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v26, types: [a.a.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    public static a a(a.a.a.a.b bVar) {
        a sVar;
        w wVar;
        ?? r1 = 0;
        r1 = 0;
        if (bVar.e() != 0 && bVar.e() == ((bVar.c() + 7) / 8) * bVar.d()) {
            if (bVar.a().equals(a.a.a.a.b.a.f35a)) {
                if (bVar.g()) {
                    if (bVar.c() <= 8) {
                        sVar = new u();
                    } else if (bVar.c() > 8 && bVar.c() <= 16) {
                        sVar = new C0000a();
                    } else if (bVar.c() > 16 && bVar.c() <= 24) {
                        sVar = new e();
                    } else if (bVar.c() > 24 && bVar.c() <= 32) {
                        sVar = new k();
                    } else if (bVar.c() > 32) {
                        sVar = new o(((bVar.c() + 7) / 8) - 4);
                    } else {
                        sVar = null;
                    }
                } else if (bVar.c() <= 8) {
                    sVar = new u();
                } else if (bVar.c() > 8 && bVar.c() <= 16) {
                    sVar = new b();
                } else if (bVar.c() > 16 && bVar.c() <= 24) {
                    sVar = new f();
                } else if (bVar.c() > 24 && bVar.c() <= 32) {
                    sVar = new l();
                } else if (bVar.c() > 32) {
                    sVar = new p(((bVar.c() + 7) / 8) - 4);
                } else {
                    sVar = null;
                }
            } else if (bVar.a().equals(a.a.a.a.b.a.f36b)) {
                if (bVar.g()) {
                    if (bVar.c() <= 8) {
                        sVar = new v();
                    } else if (bVar.c() > 8 && bVar.c() <= 16) {
                        sVar = new c();
                    } else if (bVar.c() > 16 && bVar.c() <= 24) {
                        sVar = new g();
                    } else if (bVar.c() > 24 && bVar.c() <= 32) {
                        sVar = new m();
                    } else if (bVar.c() > 32) {
                        sVar = new q(((bVar.c() + 7) / 8) - 4);
                    } else {
                        sVar = null;
                    }
                } else if (bVar.c() <= 8) {
                    sVar = new v();
                } else if (bVar.c() > 8 && bVar.c() <= 16) {
                    sVar = new d();
                } else if (bVar.c() > 16 && bVar.c() <= 24) {
                    sVar = new h();
                } else if (bVar.c() > 24 && bVar.c() <= 32) {
                    sVar = new n();
                } else if (bVar.c() > 32) {
                    sVar = new r(((bVar.c() + 7) / 8) - 4);
                } else {
                    sVar = null;
                }
            } else if (!bVar.a().equals(f6a)) {
                sVar = null;
            } else if (bVar.c() == 32) {
                sVar = bVar.g() ? new i() : new j();
            } else if (bVar.c() == 64) {
                sVar = bVar.g() ? new s() : new t();
            } else {
                sVar = null;
            }
            if ((bVar.a().equals(a.a.a.a.b.a.f35a) || bVar.a().equals(a.a.a.a.b.a.f36b)) && bVar.c() % 8 != 0) {
                wVar = new w(sVar, bVar);
            } else {
                r1 = sVar;
            }
            if (r1 != 0) {
                r1 = wVar;
                ((a) r1).f7b = bVar;
            }
        }
        r1 = wVar;
        return r1;
    }

    public abstract float[] a(byte[] bArr, int i2, float[] fArr, int i3, int i4);
}
