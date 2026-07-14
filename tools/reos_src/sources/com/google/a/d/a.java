package com.google.a.d;

import com.google.a.b.e;
import com.google.android.gms.location.places.Place;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5234b = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Reader f5236c;
    private long j;
    private int k;
    private String l;
    private int n;
    private String[] o;
    private int[] p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5237d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final char[] f5238e = new char[Place.TYPE_SUBLOCALITY_LEVEL_2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5239f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5235a = 0;
    private int[] m = new int[32];

    static {
        e.f5195a = new e() { // from class: com.google.a.d.a.1
            @Override // com.google.a.b.e
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.a.b.a.e) {
                    ((com.google.a.b.a.e) aVar).o();
                    return;
                }
                int iQ = aVar.f5235a;
                if (iQ == 0) {
                    iQ = aVar.q();
                }
                if (iQ == 13) {
                    aVar.f5235a = 9;
                } else if (iQ == 12) {
                    aVar.f5235a = 8;
                } else {
                    if (iQ != 14) {
                        throw new IllegalStateException("Expected a name but was " + aVar.f() + "  at line " + aVar.r() + " column " + aVar.s() + " path " + aVar.t());
                    }
                    aVar.f5235a = 10;
                }
            }
        };
    }

    public a(Reader reader) {
        this.n = 0;
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f5236c = reader;
    }

    private void A() throws IOException {
        b(true);
        this.f5239f--;
        if (this.f5239f + f5234b.length <= this.g || b(f5234b.length)) {
            for (int i = 0; i < f5234b.length; i++) {
                if (this.f5238e[this.f5239f + i] != f5234b[i]) {
                    return;
                }
            }
            this.f5239f += f5234b.length;
        }
    }

    private void a(int i) {
        if (this.n == this.m.length) {
            int[] iArr = new int[this.n * 2];
            int[] iArr2 = new int[this.n * 2];
            String[] strArr = new String[this.n * 2];
            System.arraycopy(this.m, 0, iArr, 0, this.n);
            System.arraycopy(this.p, 0, iArr2, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr;
            this.p = iArr2;
            this.o = strArr;
        }
        int[] iArr3 = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean a(char c2) throws IOException {
        switch (c2) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                x();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            default:
                return true;
        }
    }

    private boolean a(String str) throws IOException {
        while (true) {
            if (this.f5239f + str.length() > this.g && !b(str.length())) {
                return false;
            }
            if (this.f5238e[this.f5239f] != '\n') {
                for (int i = 0; i < str.length(); i++) {
                    if (this.f5238e[this.f5239f + i] == str.charAt(i)) {
                    }
                }
                return true;
            }
            this.h++;
            this.i = this.f5239f + 1;
            this.f5239f++;
        }
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.f5238e;
        int i = this.f5239f;
        int i2 = this.g;
        while (true) {
            if (i == i2) {
                this.f5239f = i;
                if (!b(1)) {
                    if (z) {
                        throw new EOFException("End of input at line " + r() + " column " + s());
                    }
                    return -1;
                }
                i = this.f5239f;
                i2 = this.g;
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.h++;
                this.i = i3;
                i = i3;
            } else if (c2 == ' ' || c2 == '\r') {
                i = i3;
            } else if (c2 == '\t') {
                i = i3;
            } else if (c2 == '/') {
                this.f5239f = i3;
                if (i3 == i2) {
                    this.f5239f--;
                    boolean zB = b(2);
                    this.f5239f++;
                    if (!zB) {
                        return c2;
                    }
                }
                x();
                switch (cArr[this.f5239f]) {
                    case '*':
                        this.f5239f++;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i = this.f5239f + 2;
                        i2 = this.g;
                        break;
                        break;
                    case '/':
                        this.f5239f++;
                        y();
                        i = this.f5239f;
                        i2 = this.g;
                        break;
                    default:
                        return c2;
                }
            } else {
                if (c2 != '#') {
                    this.f5239f = i3;
                    return c2;
                }
                this.f5239f = i3;
                x();
                y();
                i = this.f5239f;
                i2 = this.g;
            }
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + " at line " + r() + " column " + s() + " path " + t());
    }

    private String b(char c2) throws IOException {
        char[] cArr = this.f5238e;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f5239f;
            int i2 = this.g;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c3 = cArr[i3];
                if (c3 == c2) {
                    this.f5239f = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c3 == '\\') {
                    this.f5239f = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(z());
                    i = this.f5239f;
                    i2 = this.g;
                    i4 = i;
                } else if (c3 == '\n') {
                    this.h++;
                    this.i = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.f5239f = i3;
        } while (b(1));
        throw b("Unterminated string");
    }

    private boolean b(int i) throws IOException {
        char[] cArr = this.f5238e;
        this.i -= this.f5239f;
        if (this.g != this.f5239f) {
            this.g -= this.f5239f;
            System.arraycopy(cArr, this.f5239f, cArr, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f5239f = 0;
        do {
            int i2 = this.f5236c.read(cArr, this.g, cArr.length - this.g);
            if (i2 == -1) {
                return false;
            }
            this.g = i2 + this.g;
            if (this.h == 0 && this.i == 0 && this.g > 0 && cArr[0] == 65279) {
                this.f5239f++;
                this.i++;
                i++;
            }
        } while (this.g < i);
        return true;
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f5238e;
        do {
            int i = this.f5239f;
            int i2 = this.g;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c3 = cArr[i3];
                if (c3 == c2) {
                    this.f5239f = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f5239f = i4;
                    z();
                    i4 = this.f5239f;
                    i2 = this.g;
                } else if (c3 == '\n') {
                    this.h++;
                    this.i = i4;
                }
                i3 = i4;
            }
            this.f5239f = i3;
        } while (b(1));
        throw b("Unterminated string");
    }

    private int o() throws IOException {
        String str;
        String str2;
        int i;
        char c2 = this.f5238e[this.f5239f];
        if (c2 == 't' || c2 == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f5239f + i2 >= this.g && !b(i2 + 1)) {
                return 0;
            }
            char c3 = this.f5238e[this.f5239f + i2];
            if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f5239f + length < this.g || b(length + 1)) && a(this.f5238e[this.f5239f + length])) {
            return 0;
        }
        this.f5239f += length;
        this.f5235a = i;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:90:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0089 A[SYNTHETIC] */
    private int u() throws IOException {
        char c2;
        char c3;
        boolean z;
        boolean z2;
        char[] cArr = this.f5238e;
        int i = this.f5239f;
        long j = 0;
        boolean z3 = false;
        boolean z4 = true;
        char c4 = 0;
        int i2 = 0;
        int i3 = this.g;
        int i4 = i;
        while (true) {
            if (i4 + i2 != i3) {
                c2 = cArr[i4 + i2];
                switch (c2) {
                    case '+':
                        if (c4 == 5) {
                            return 0;
                        }
                        c3 = 6;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c4 = c3;
                        break;
                        break;
                    case '-':
                        if (c4 == 0) {
                            c3 = 1;
                            boolean z5 = z4;
                            z2 = true;
                            z = z5;
                            continue;
                            continue;
                        } else {
                            if (c4 == 5) {
                                return 0;
                            }
                            c3 = 6;
                            z = z4;
                            z2 = z3;
                        }
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c4 = c3;
                        break;
                    case '.':
                        if (c4 == 2) {
                            return 0;
                        }
                        c3 = 3;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c4 = c3;
                        break;
                        break;
                    case 'E':
                    case 'e':
                        if (c4 == 2 && c4 != 4) {
                            return 0;
                        }
                        c3 = 5;
                        z = z4;
                        z2 = z3;
                        continue;
                        continue;
                        i2++;
                        z3 = z2;
                        z4 = z;
                        c4 = c3;
                        break;
                        break;
                    default:
                        if (c2 < '0' && c2 <= '9') {
                            if (c4 == 1 || c4 == 0) {
                                j = -(c2 - '0');
                                c3 = 2;
                                z = z4;
                                z2 = z3;
                            } else if (c4 == 2) {
                                if (j == 0) {
                                    return 0;
                                }
                                long j2 = (10 * j) - ((long) (c2 - '0'));
                                boolean z6 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z4;
                                z2 = z3;
                                j = j2;
                                char c5 = c4;
                                z = z6;
                                c3 = c5;
                            } else if (c4 == 3) {
                                c3 = 4;
                                z = z4;
                                z2 = z3;
                            } else if (c4 == 5 || c4 == 6) {
                                c3 = 7;
                                z = z4;
                                z2 = z3;
                            } else {
                                c3 = c4;
                                z = z4;
                                z2 = z3;
                            }
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c4 = c3;
                        } else if (a(c2)) {
                            return 0;
                        }
                        break;
                }
            } else {
                if (i2 == cArr.length) {
                    return 0;
                }
                if (b(i2 + 1)) {
                    i4 = this.f5239f;
                    i3 = this.g;
                    c2 = cArr[i4 + i2];
                    switch (c2) {
                        case '+':
                            if (c4 == 5) {
                                return 0;
                            }
                            c3 = 6;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c4 = c3;
                            break;
                            break;
                        case '-':
                            if (c4 == 0) {
                                c3 = 1;
                                boolean z7 = z4;
                                z2 = true;
                                z = z7;
                                continue;
                                continue;
                            } else {
                                if (c4 == 5) {
                                    return 0;
                                }
                                c3 = 6;
                                z = z4;
                                z2 = z3;
                            }
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c4 = c3;
                            break;
                        case '.':
                            if (c4 == 2) {
                                return 0;
                            }
                            c3 = 3;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c4 = c3;
                            break;
                            break;
                        case 'E':
                        case 'e':
                            if (c4 == 2) {
                            }
                            c3 = 5;
                            z = z4;
                            z2 = z3;
                            continue;
                            continue;
                            i2++;
                            z3 = z2;
                            z4 = z;
                            c4 = c3;
                            break;
                        default:
                            if (c2 < '0') {
                            }
                            if (a(c2)) {
                                return 0;
                            }
                            break;
                    }
                }
            }
        }
        if (c4 == 2 && z4 && (j != Long.MIN_VALUE || z3)) {
            if (!z3) {
                j = -j;
            }
            this.j = j;
            this.f5239f += i2;
            this.f5235a = 15;
            return 15;
        }
        if (c4 != 2 && c4 != 4 && c4 != 7) {
            return 0;
        }
        this.k = i2;
        this.f5235a = 16;
        return 16;
    }

    private String v() throws IOException {
        String string;
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.f5239f + i < this.g) {
                switch (this.f5238e[this.f5239f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f5238e.length) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f5238e, this.f5239f, i);
                this.f5239f = i + this.f5239f;
                if (b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (b(i + 1)) {
            }
        }
        if (sb == null) {
            string = new String(this.f5238e, this.f5239f, i);
        } else {
            sb.append(this.f5238e, this.f5239f, i);
            string = sb.toString();
        }
        this.f5239f = i + this.f5239f;
        return string;
    }

    private void w() throws IOException {
        do {
            int i = 0;
            while (this.f5239f + i < this.g) {
                switch (this.f5238e[this.f5239f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        x();
                        break;
                    default:
                        i++;
                        break;
                }
                this.f5239f = i + this.f5239f;
                return;
            }
            this.f5239f = i + this.f5239f;
        } while (b(1));
    }

    private void x() throws IOException {
        if (!this.f5237d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void y() throws IOException {
        char c2;
        do {
            if (this.f5239f >= this.g && !b(1)) {
                return;
            }
            char[] cArr = this.f5238e;
            int i = this.f5239f;
            this.f5239f = i + 1;
            c2 = cArr[i];
            if (c2 == '\n') {
                this.h++;
                this.i = this.f5239f;
                return;
            }
        } while (c2 != '\r');
    }

    private char z() throws IOException {
        int i;
        if (this.f5239f == this.g && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f5238e;
        int i2 = this.f5239f;
        this.f5239f = i2 + 1;
        char c2 = cArr[i2];
        switch (c2) {
            case '\n':
                this.h++;
                this.i = this.f5239f;
                return c2;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.f5239f + 4 > this.g && !b(4)) {
                    throw b("Unterminated escape sequence");
                }
                int i3 = this.f5239f;
                int i4 = i3 + 4;
                char c3 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c4 = this.f5238e[i5];
                    char c5 = (char) (c3 << 4);
                    if (c4 >= '0' && c4 <= '9') {
                        i = c4 - '0';
                    } else if (c4 >= 'a' && c4 <= 'f') {
                        i = (c4 - 'a') + 10;
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f5238e, this.f5239f, 4));
                        }
                        i = (c4 - 'A') + 10;
                    }
                    c3 = (char) (c5 + i);
                }
                this.f5239f += 4;
                return c3;
            default:
                return c2;
        }
    }

    public void a() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 3) {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        a(1);
        this.p[this.n - 1] = 0;
        this.f5235a = 0;
    }

    public final void a(boolean z) {
        this.f5237d = z;
    }

    public void b() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.n--;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        this.f5235a = 0;
    }

    public void c() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 1) {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        a(3);
        this.f5235a = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5235a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f5236c.close();
    }

    public void d() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.n--;
        this.o[this.n] = null;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        this.f5235a = 0;
    }

    public boolean e() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        return (iQ == 2 || iQ == 4) ? false : true;
    }

    public b f() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        switch (iQ) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        String strB;
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            strB = v();
        } else if (iQ == 12) {
            strB = b('\'');
        } else {
            if (iQ != 13) {
                throw new IllegalStateException("Expected a name but was " + f() + " at line " + r() + " column " + s() + " path " + t());
            }
            strB = b('\"');
        }
        this.f5235a = 0;
        this.o[this.n - 1] = strB;
        return strB;
    }

    public String h() throws IOException {
        String str;
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 10) {
            str = v();
        } else if (iQ == 8) {
            str = b('\'');
        } else if (iQ == 9) {
            str = b('\"');
        } else if (iQ == 11) {
            str = this.l;
            this.l = null;
        } else if (iQ == 15) {
            str = Long.toString(this.j);
        } else {
            if (iQ != 16) {
                throw new IllegalStateException("Expected a string but was " + f() + " at line " + r() + " column " + s() + " path " + t());
            }
            str = new String(this.f5238e, this.f5239f, this.k);
            this.f5239f += this.k;
        }
        this.f5235a = 0;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 5) {
            this.f5235a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iQ != 6) {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.f5235a = 0;
        int[] iArr2 = this.p;
        int i2 = this.n - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public void j() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 7) {
            throw new IllegalStateException("Expected null but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.f5235a = 0;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
    }

    public double k() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            this.f5235a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iQ == 16) {
            this.l = new String(this.f5238e, this.f5239f, this.k);
            this.f5239f += this.k;
        } else if (iQ == 8 || iQ == 9) {
            this.l = b(iQ == 8 ? '\'' : '\"');
        } else if (iQ == 10) {
            this.l = v();
        } else if (iQ != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.f5235a = 11;
        double d2 = Double.parseDouble(this.l);
        if (!this.f5237d && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new d("JSON forbids NaN and infinities: " + d2 + " at line " + r() + " column " + s() + " path " + t());
        }
        this.l = null;
        this.f5235a = 0;
        int[] iArr2 = this.p;
        int i2 = this.n - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d2;
    }

    public long l() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            this.f5235a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iQ == 16) {
            this.l = new String(this.f5238e, this.f5239f, this.k);
            this.f5239f += this.k;
        } else {
            if (iQ != 8 && iQ != 9) {
                throw new IllegalStateException("Expected a long but was " + f() + " at line " + r() + " column " + s() + " path " + t());
            }
            this.l = b(iQ == 8 ? '\'' : '\"');
            try {
                long j = Long.parseLong(this.l);
                this.f5235a = 0;
                int[] iArr2 = this.p;
                int i2 = this.n - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException e2) {
            }
        }
        this.f5235a = 11;
        double d2 = Double.parseDouble(this.l);
        long j2 = (long) d2;
        if (j2 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + r() + " column " + s() + " path " + t());
        }
        this.l = null;
        this.f5235a = 0;
        int[] iArr3 = this.p;
        int i3 = this.n - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public int m() throws IOException {
        int iQ = this.f5235a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            int i = (int) this.j;
            if (this.j != i) {
                throw new NumberFormatException("Expected an int but was " + this.j + " at line " + r() + " column " + s() + " path " + t());
            }
            this.f5235a = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iQ == 16) {
            this.l = new String(this.f5238e, this.f5239f, this.k);
            this.f5239f += this.k;
        } else {
            if (iQ != 8 && iQ != 9) {
                throw new IllegalStateException("Expected an int but was " + f() + " at line " + r() + " column " + s() + " path " + t());
            }
            this.l = b(iQ == 8 ? '\'' : '\"');
            try {
                int i3 = Integer.parseInt(this.l);
                this.f5235a = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException e2) {
            }
        }
        this.f5235a = 11;
        double d2 = Double.parseDouble(this.l);
        int i5 = (int) d2;
        if (i5 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + r() + " column " + s() + " path " + t());
        }
        this.l = null;
        this.f5235a = 0;
        int[] iArr3 = this.p;
        int i6 = this.n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public void n() throws IOException {
        int i = 0;
        do {
            int iQ = this.f5235a;
            if (iQ == 0) {
                iQ = q();
            }
            if (iQ == 3) {
                a(1);
                i++;
            } else if (iQ == 1) {
                a(3);
                i++;
            } else if (iQ == 4 || iQ == 2) {
                this.n--;
                i--;
            } else if (iQ == 14 || iQ == 10) {
                w();
            } else if (iQ == 8 || iQ == 12) {
                c('\'');
            } else if (iQ == 9 || iQ == 13) {
                c('\"');
            } else if (iQ == 16) {
                this.f5239f += this.k;
            }
            this.f5235a = 0;
        } while (i != 0);
        int[] iArr = this.p;
        int i2 = this.n - 1;
        iArr[i2] = iArr[i2] + 1;
        this.o[this.n - 1] = "null";
    }

    public final boolean p() {
        return this.f5237d;
    }

    int q() throws IOException {
        int i = this.m[this.n - 1];
        if (i == 1) {
            this.m[this.n - 1] = 2;
        } else if (i == 2) {
            switch (b(true)) {
                case 44:
                    break;
                case 59:
                    x();
                    break;
                case 93:
                    this.f5235a = 4;
                    return 4;
                default:
                    throw b("Unterminated array");
            }
        } else {
            if (i == 3 || i == 5) {
                this.m[this.n - 1] = 4;
                if (i == 5) {
                    switch (b(true)) {
                        case 44:
                            break;
                        case 59:
                            x();
                            break;
                        case 125:
                            this.f5235a = 2;
                            return 2;
                        default:
                            throw b("Unterminated object");
                    }
                }
                int iB = b(true);
                switch (iB) {
                    case 34:
                        this.f5235a = 13;
                        return 13;
                    case 39:
                        x();
                        this.f5235a = 12;
                        return 12;
                    case 125:
                        if (i == 5) {
                            throw b("Expected name");
                        }
                        this.f5235a = 2;
                        return 2;
                    default:
                        x();
                        this.f5239f--;
                        if (!a((char) iB)) {
                            throw b("Expected name");
                        }
                        this.f5235a = 14;
                        return 14;
                }
            }
            if (i == 4) {
                this.m[this.n - 1] = 5;
                switch (b(true)) {
                    case 58:
                        break;
                    case 59:
                    case 60:
                    default:
                        throw b("Expected ':'");
                    case 61:
                        x();
                        if ((this.f5239f < this.g || b(1)) && this.f5238e[this.f5239f] == '>') {
                            this.f5239f++;
                        }
                        break;
                }
            } else if (i == 6) {
                if (this.f5237d) {
                    A();
                }
                this.m[this.n - 1] = 7;
            } else if (i == 7) {
                if (b(false) == -1) {
                    this.f5235a = 17;
                    return 17;
                }
                x();
                this.f5239f--;
            } else if (i == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (b(true)) {
            case 34:
                this.f5235a = 9;
                return 9;
            case 39:
                x();
                this.f5235a = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f5235a = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f5235a = 4;
                    return 4;
                }
                break;
            case 123:
                this.f5235a = 1;
                return 1;
            default:
                this.f5239f--;
                int iO = o();
                if (iO != 0) {
                    return iO;
                }
                int iU = u();
                if (iU != 0) {
                    return iU;
                }
                if (!a(this.f5238e[this.f5239f])) {
                    throw b("Expected value");
                }
                x();
                this.f5235a = 10;
                return 10;
        }
        if (i != 1 && i != 2) {
            throw b("Unexpected value");
        }
        x();
        this.f5239f--;
        this.f5235a = 7;
        return 7;
    }

    int r() {
        return this.h + 1;
    }

    int s() {
        return (this.f5239f - this.i) + 1;
    }

    public String t() {
        StringBuilder sbAppend = new StringBuilder().append('$');
        int i = this.n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.m[i2]) {
                case 1:
                case 2:
                    sbAppend.append('[').append(this.p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sbAppend.append('.');
                    if (this.o[i2] != null) {
                        sbAppend.append(this.o[i2]);
                    }
                    break;
            }
        }
        return sbAppend.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + r() + " column " + s();
    }
}
