package d;

import com.flurry.android.Constants;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f6352a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6357f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* JADX INFO: renamed from: d.s$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6358a = new int[a.EnumC0208a.values().length];

        static {
            try {
                f6358a[a.EnumC0208a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6358a[a.EnumC0208a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6358a[a.EnumC0208a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6358a[a.EnumC0208a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6358a[a.EnumC0208a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6359a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f6362d;
        List<String> g;
        String h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6360b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f6361c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f6363e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f6364f = new ArrayList();

        /* JADX INFO: renamed from: d.s$a$a, reason: collision with other inner class name */
        enum EnumC0208a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f6364f.add("");
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            e.c cVar = new e.c();
            while (i < bArr.length) {
                if (i == i3) {
                    cVar.j(58);
                    i += i2;
                    if (i == 16) {
                        cVar.j(58);
                    }
                } else {
                    if (i > 0) {
                        cVar.j(58);
                    }
                    cVar.j(((bArr[i] & Constants.UNKNOWN) << 8) | (bArr[i + 1] & Constants.UNKNOWN));
                    i += 2;
                }
            }
            return cVar.r();
        }

        private void a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f6364f.clear();
                this.f6364f.add("");
                i++;
            } else {
                this.f6364f.set(this.f6364f.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int iA = d.a.j.a(str, i3, i2, "/\\");
                boolean z = iA < i2;
                a(str, i3, iA, z, true);
                if (z) {
                    iA++;
                }
                i3 = iA;
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (d(strA)) {
                return;
            }
            if (e(strA)) {
                d();
                return;
            }
            if (this.f6364f.get(this.f6364f.size() - 1).isEmpty()) {
                this.f6364f.set(this.f6364f.size() - 1, strA);
            } else {
                this.f6364f.add(strA);
            }
            if (z) {
                this.f6364f.add("");
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i6 != 0 || i4 == i7) && (i6 = ((i6 * 10) + cCharAt) - 48) <= 255) {
                        i7++;
                    }
                    return false;
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            return i5 == i3 + 4;
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char cCharAt2 = str.charAt(i3);
                if ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '-' || cCharAt2 == '.'))) {
                    if (cCharAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        break;
                    default:
                        continue;
                        i3++;
                        break;
                }
                do {
                    i3++;
                    if (i3 >= i2) {
                        break;
                    }
                } while (str.charAt(i3) != ']');
                i3++;
            }
            return i2;
        }

        private void d() {
            if (!this.f6364f.remove(this.f6364f.size() - 1).isEmpty() || this.f6364f.isEmpty()) {
                this.f6364f.add("");
            } else {
                this.f6364f.set(this.f6364f.size() - 1, "");
            }
        }

        private boolean d(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static String e(String str, int i, int i2) {
            String strA = s.a(str, i, i2, false);
            if (!strA.contains(":")) {
                return d.a.j.b(strA);
            }
            InetAddress inetAddressF = (strA.startsWith("[") && strA.endsWith("]")) ? f(strA, 1, strA.length() - 1) : f(strA, 0, strA.length());
            if (inetAddressF == null) {
                return null;
            }
            byte[] address = inetAddressF.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError();
        }

        private boolean e(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0042  */
        /* JADX WARN: Code duplicated, block: B:41:0x006c A[LOOP:1: B:26:0x0040->B:41:0x006c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:60:0x004c A[EDGE_INSN: B:60:0x004c->B:29:0x004c BREAK  A[LOOP:1: B:26:0x0040->B:41:0x006c], SYNTHETIC] */
        private static InetAddress f(String str, int i, int i2) {
            int i3;
            int i4;
            int i5;
            int iA;
            byte[] bArr = new byte[16];
            int i6 = i;
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            while (i6 < i2) {
                if (i9 == bArr.length) {
                    return null;
                }
                if (i6 + 2 <= i2 && str.regionMatches(i6, "::", 0, 2)) {
                    if (i8 != -1) {
                        return null;
                    }
                    i6 += 2;
                    i8 = i9 + 2;
                    if (i6 == i2) {
                        i9 = i8;
                        break;
                    }
                    i9 = i8;
                    i3 = 0;
                    i4 = i6;
                    while (i4 < i2) {
                        iA = s.a(str.charAt(i4));
                        if (iA == -1) {
                            break;
                            break;
                        }
                        i3 = (i3 << 4) + iA;
                        i4++;
                    }
                    i5 = i4 - i6;
                    if (i5 != 0) {
                    }
                    return null;
                }
                if (i9 != 0) {
                    if (!str.regionMatches(i6, ":", 0, 1)) {
                        if (str.regionMatches(i6, ".", 0, 1) && a(str, i7, i2, bArr, i9 - 2)) {
                            i9 += 2;
                            break;
                        }
                        return null;
                    }
                    i6++;
                }
                i3 = 0;
                i4 = i6;
                while (i4 < i2) {
                    iA = s.a(str.charAt(i4));
                    if (iA == -1) {
                        break;
                    }
                    i3 = (i3 << 4) + iA;
                    i4++;
                }
                i5 = i4 - i6;
                if (i5 != 0 || i5 > 4) {
                    return null;
                }
                int i10 = i9 + 1;
                bArr[i9] = (byte) ((i3 >>> 8) & 255);
                i9 = i10 + 1;
                bArr[i10] = (byte) (i3 & 255);
                i7 = i6;
                i6 = i4;
            }
            if (i9 != bArr.length) {
                if (i8 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i8, bArr, bArr.length - (i9 - i8), i9 - i8);
                Arrays.fill(bArr, i8, (bArr.length - i9) + i8, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e2) {
                throw new AssertionError();
            }
        }

        private static int g(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException e2) {
                return -1;
            }
        }

        int a() {
            return this.f6363e != -1 ? this.f6363e : s.a(this.f6359a);
        }

        EnumC0208a a(s sVar, String str) {
            int iA;
            int iA2 = d.a.j.a(str, 0, str.length());
            int iB = d.a.j.b(str, iA2, str.length());
            if (b(str, iA2, iB) == -1) {
                if (sVar == null) {
                    return EnumC0208a.MISSING_SCHEME;
                }
                this.f6359a = sVar.f6353b;
            } else if (str.regionMatches(true, iA2, "https:", 0, 6)) {
                this.f6359a = "https";
                iA2 += "https:".length();
            } else {
                if (!str.regionMatches(true, iA2, "http:", 0, 5)) {
                    return EnumC0208a.UNSUPPORTED_SCHEME;
                }
                this.f6359a = "http";
                iA2 += "http:".length();
            }
            boolean z = false;
            boolean z2 = false;
            int iC = c(str, iA2, iB);
            if (iC >= 2 || sVar == null || !sVar.f6353b.equals(this.f6359a)) {
                int i = iA2 + iC;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i2 = i;
                    int iA3 = d.a.j.a(str, i2, iB, "@/\\?#");
                    switch (iA3 != iB ? str.charAt(iA3) : (byte) -1) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int iD = d(str, i2, iA3);
                            if (iD + 1 < iA3) {
                                this.f6362d = e(str, i2, iD);
                                this.f6363e = g(str, iD + 1, iA3);
                                if (this.f6363e == -1) {
                                    return EnumC0208a.INVALID_PORT;
                                }
                            } else {
                                this.f6362d = e(str, i2, iD);
                                this.f6363e = s.a(this.f6359a);
                            }
                            if (this.f6362d == null) {
                                return EnumC0208a.INVALID_HOST;
                            }
                            iA2 = iA3;
                            break;
                        case 64:
                            if (z3) {
                                this.f6361c += "%40" + s.a(str, i2, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            } else {
                                int iA4 = d.a.j.a(str, i2, iA3, ':');
                                String strA = s.a(str, i2, iA4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z4) {
                                    strA = this.f6360b + "%40" + strA;
                                }
                                this.f6360b = strA;
                                if (iA4 != iA3) {
                                    z3 = true;
                                    this.f6361c = s.a(str, iA4 + 1, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                z4 = true;
                            }
                            i = iA3 + 1;
                            z2 = z3;
                            continue;
                            z = z4;
                            break;
                        default:
                            z2 = z3;
                            i = i2;
                            continue;
                            z = z4;
                            break;
                    }
                }
            } else {
                this.f6360b = sVar.d();
                this.f6361c = sVar.e();
                this.f6362d = sVar.f6356e;
                this.f6363e = sVar.f6357f;
                this.f6364f.clear();
                this.f6364f.addAll(sVar.i());
                if (iA2 == iB || str.charAt(iA2) == '#') {
                    c(sVar.k());
                }
            }
            int iA5 = d.a.j.a(str, iA2, iB, "?#");
            a(str, iA2, iA5);
            if (iA5 >= iB || str.charAt(iA5) != '?') {
                iA = iA5;
            } else {
                iA = d.a.j.a(str, iA5, iB, '#');
                this.g = s.b(s.a(str, iA5 + 1, iA, " \"'<>#", true, false, true, true));
            }
            if (iA < iB && str.charAt(iA) == '#') {
                this.h = s.a(str, iA + 1, iB, "", true, false, false, false);
            }
            return EnumC0208a.SUCCESS;
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f6363e = i;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f6359a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f6359a = "https";
            }
            return this;
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(s.a(str, " \"'<>#&=", false, false, true, true));
            this.g.add(str2 != null ? s.a(str2, " \"'<>#&=", false, false, true, true) : null);
            return this;
        }

        a b() {
            int size = this.f6364f.size();
            for (int i = 0; i < size; i++) {
                this.f6364f.set(i, s.a(this.f6364f.get(i), "[]", true, true, false, true));
            }
            if (this.g != null) {
                int size2 = this.g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.h != null) {
                this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strE = e(str, 0, str.length());
            if (strE == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f6362d = strE;
            return this;
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(s.a(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? s.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public a c(String str) {
            this.g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public s c() {
            if (this.f6359a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f6362d == null) {
                throw new IllegalStateException("host == null");
            }
            return new s(this, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6359a);
            sb.append("://");
            if (!this.f6360b.isEmpty() || !this.f6361c.isEmpty()) {
                sb.append(this.f6360b);
                if (!this.f6361c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f6361c);
                }
                sb.append('@');
            }
            if (this.f6362d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f6362d);
                sb.append(']');
            } else {
                sb.append(this.f6362d);
            }
            int iA = a();
            if (iA != s.a(this.f6359a)) {
                sb.append(':');
                sb.append(iA);
            }
            s.a(sb, this.f6364f);
            if (this.g != null) {
                sb.append('?');
                s.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private s(a aVar) {
        this.f6353b = aVar.f6359a;
        this.f6354c = a(aVar.f6360b, false);
        this.f6355d = a(aVar.f6361c, false);
        this.f6356e = aVar.f6362d;
        this.f6357f = aVar.a();
        this.g = a(aVar.f6364f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    /* synthetic */ s(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return (c2 - 'A') + 10;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !a(str, iCharCount, i2)))) || (iCodePointAt == 43 && z3)))) {
                e.c cVar = new e.c();
                cVar.a(str, i, iCharCount);
                a(cVar, str, iCharCount, i2, str2, z, z2, z3, z4);
                return cVar.r();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                e.c cVar = new e.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.r();
            }
        }
        return str.substring(i, i2);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(e.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        e.c cVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new e.c();
                    }
                    cVar2.a(iCodePointAt);
                    while (!cVar2.g()) {
                        int iJ = cVar2.j() & Constants.UNKNOWN;
                        cVar.j(37);
                        cVar.j((int) f6352a[(iJ >> 4) & 15]);
                        cVar.j((int) f6352a[iJ & 15]);
                    }
                } else {
                    cVar.a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    static void a(e.c cVar, String str, int i, int i2, boolean z) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt == 37 && iCharCount + 2 < i2) {
                int iA = a(str.charAt(iCharCount + 1));
                int iA2 = a(str.charAt(iCharCount + 2));
                if (iA == -1 || iA2 == -1) {
                    cVar.a(iCodePointAt);
                } else {
                    cVar.j((iA << 4) + iA2);
                    iCharCount += 2;
                }
            } else if (iCodePointAt == 43 && z) {
                cVar.j(32);
            } else {
                cVar.a(iCodePointAt);
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static boolean a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && a(str.charAt(i + 1)) != -1 && a(str.charAt(i + 2)) != -1;
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static s e(String str) {
        a aVar = new a();
        if (aVar.a((s) null, str) == a.EnumC0208a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    public URI a() {
        String string = n().b().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e3) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f6353b;
    }

    public s c(String str) {
        a aVarD = d(str);
        if (aVarD != null) {
            return aVarD.c();
        }
        return null;
    }

    public boolean c() {
        return this.f6353b.equals("https");
    }

    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0208a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String d() {
        if (this.f6354c.isEmpty()) {
            return "";
        }
        int length = this.f6353b.length() + 3;
        return this.j.substring(length, d.a.j.a(this.j, length, this.j.length(), ":@"));
    }

    public String e() {
        if (this.f6355d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f6353b.length() + 3) + 1, this.j.indexOf(64));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public String f() {
        return this.f6356e;
    }

    public int g() {
        return this.f6357f;
    }

    public String h() {
        int iIndexOf = this.j.indexOf(47, this.f6353b.length() + 3);
        return this.j.substring(iIndexOf, d.a.j.a(this.j, iIndexOf, this.j.length(), "?#"));
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int iIndexOf = this.j.indexOf(47, this.f6353b.length() + 3);
        int iA = d.a.j.a(this.j, iIndexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i = iIndexOf + 1;
            iIndexOf = d.a.j.a(this.j, i, iA, '/');
            arrayList.add(this.j.substring(i, iIndexOf));
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        int iIndexOf = this.j.indexOf(63) + 1;
        return this.j.substring(iIndexOf, d.a.j.a(this.j, iIndexOf + 1, this.j.length(), '#'));
    }

    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String m() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public a n() {
        a aVar = new a();
        aVar.f6359a = this.f6353b;
        aVar.f6360b = d();
        aVar.f6361c = e();
        aVar.f6362d = this.f6356e;
        aVar.f6363e = this.f6357f != a(this.f6353b) ? this.f6357f : -1;
        aVar.f6364f.clear();
        aVar.f6364f.addAll(i());
        aVar.c(k());
        aVar.h = m();
        return aVar;
    }

    public String toString() {
        return this.j;
    }
}
