package d.a.a;

import com.flurry.android.Constants;
import com.google.android.gms.location.places.Place;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6042a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, Place.TYPE_POSTAL_CODE_PREFIX, Place.TYPE_POSTAL_TOWN, 4090, 8185, 21, 248, 2042, Place.TYPE_PREMISE, Place.TYPE_ROOM, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, Place.TYPE_ROUTE, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f6043b = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final j f6044c = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f6045d = new a();

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a[] f6046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6048c;

        a() {
            this.f6046a = new a[256];
            this.f6047b = 0;
            this.f6048c = 0;
        }

        a(int i, int i2) {
            this.f6046a = null;
            this.f6047b = i;
            int i3 = i2 & 7;
            this.f6048c = i3 == 0 ? 8 : i3;
        }
    }

    private j() {
        b();
    }

    public static j a() {
        return f6044c;
    }

    private void a(int i, int i2, byte b2) {
        a aVar = new a(i, b2);
        a aVar2 = this.f6045d;
        while (true) {
            a aVar3 = aVar2;
            if (b2 <= 8) {
                int i3 = 8 - b2;
                int i4 = (i2 << i3) & 255;
                int i5 = 1 << i3;
                for (int i6 = i4; i6 < i4 + i5; i6++) {
                    aVar3.f6046a[i6] = aVar;
                }
                return;
            }
            b2 = (byte) (b2 - 8);
            int i7 = (i2 >>> b2) & 255;
            if (aVar3.f6046a == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (aVar3.f6046a[i7] == null) {
                aVar3.f6046a[i7] = new a();
            }
            aVar2 = aVar3.f6046a[i7];
        }
    }

    private void b() {
        for (int i = 0; i < f6043b.length; i++) {
            a(i, f6042a[i], f6043b[i]);
        }
    }

    byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        a aVar = this.f6045d;
        int i2 = 0;
        for (byte b2 : bArr) {
            i = (i << 8) | (b2 & Constants.UNKNOWN);
            i2 += 8;
            while (i2 >= 8) {
                aVar = aVar.f6046a[(i >>> (i2 - 8)) & 255];
                if (aVar.f6046a == null) {
                    byteArrayOutputStream.write(aVar.f6047b);
                    i2 -= aVar.f6048c;
                    aVar = this.f6045d;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            a aVar2 = aVar.f6046a[(i << (8 - i2)) & 255];
            if (aVar2.f6046a != null || aVar2.f6048c > i2) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f6047b);
            i2 -= aVar2.f6048c;
            aVar = this.f6045d;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
