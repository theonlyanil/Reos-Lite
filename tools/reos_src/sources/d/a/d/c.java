package d.a.d;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6196f;
    private char[] g;

    public c(X500Principal x500Principal) {
        this.f6191a = x500Principal.getName("RFC2253");
        this.f6192b = this.f6191a.length();
    }

    private int a(int i) {
        int i2;
        int i3;
        if (i + 1 >= this.f6192b) {
            throw new IllegalStateException("Malformed DN: " + this.f6191a);
        }
        char c2 = this.g[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f6191a);
            }
            i2 = c2 - '7';
        }
        char c3 = this.g[i + 1];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else {
            if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f6191a);
            }
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String a() {
        while (this.f6193c < this.f6192b && this.g[this.f6193c] == ' ') {
            this.f6193c++;
        }
        if (this.f6193c == this.f6192b) {
            return null;
        }
        this.f6194d = this.f6193c;
        this.f6193c++;
        while (this.f6193c < this.f6192b && this.g[this.f6193c] != '=' && this.g[this.f6193c] != ' ') {
            this.f6193c++;
        }
        if (this.f6193c >= this.f6192b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
        }
        this.f6195e = this.f6193c;
        if (this.g[this.f6193c] == ' ') {
            while (this.f6193c < this.f6192b && this.g[this.f6193c] != '=' && this.g[this.f6193c] == ' ') {
                this.f6193c++;
            }
            if (this.g[this.f6193c] != '=' || this.f6193c == this.f6192b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
            }
        }
        this.f6193c++;
        while (this.f6193c < this.f6192b && this.g[this.f6193c] == ' ') {
            this.f6193c++;
        }
        if (this.f6195e - this.f6194d > 4 && this.g[this.f6194d + 3] == '.' && ((this.g[this.f6194d] == 'O' || this.g[this.f6194d] == 'o') && ((this.g[this.f6194d + 1] == 'I' || this.g[this.f6194d + 1] == 'i') && (this.g[this.f6194d + 2] == 'D' || this.g[this.f6194d + 2] == 'd')))) {
            this.f6194d += 4;
        }
        return new String(this.g, this.f6194d, this.f6195e - this.f6194d);
    }

    private String b() {
        this.f6193c++;
        this.f6194d = this.f6193c;
        this.f6195e = this.f6194d;
        while (this.f6193c != this.f6192b) {
            if (this.g[this.f6193c] == '\"') {
                this.f6193c++;
                while (this.f6193c < this.f6192b && this.g[this.f6193c] == ' ') {
                    this.f6193c++;
                }
                return new String(this.g, this.f6194d, this.f6195e - this.f6194d);
            }
            if (this.g[this.f6193c] == '\\') {
                this.g[this.f6195e] = e();
            } else {
                this.g[this.f6195e] = this.g[this.f6193c];
            }
            this.f6193c++;
            this.f6195e++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
    }

    private String c() {
        if (this.f6193c + 4 >= this.f6192b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
        }
        this.f6194d = this.f6193c;
        this.f6193c++;
        while (true) {
            if (this.f6193c == this.f6192b || this.g[this.f6193c] == '+' || this.g[this.f6193c] == ',' || this.g[this.f6193c] == ';') {
                this.f6195e = this.f6193c;
                break;
            }
            if (this.g[this.f6193c] == ' ') {
                this.f6195e = this.f6193c;
                this.f6193c++;
                while (this.f6193c < this.f6192b && this.g[this.f6193c] == ' ') {
                    this.f6193c++;
                }
                break;
            }
            if (this.g[this.f6193c] >= 'A' && this.g[this.f6193c] <= 'F') {
                char[] cArr = this.g;
                int i = this.f6193c;
                cArr[i] = (char) (cArr[i] + ' ');
            }
            this.f6193c++;
        }
        int i2 = this.f6195e - this.f6194d;
        if (i2 < 5 || (i2 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
        }
        byte[] bArr = new byte[i2 / 2];
        int i3 = this.f6194d + 1;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = (byte) a(i3);
            i3 += 2;
        }
        return new String(this.g, this.f6194d, i2);
    }

    private String d() {
        this.f6194d = this.f6193c;
        this.f6195e = this.f6193c;
        while (this.f6193c < this.f6192b) {
            switch (this.g[this.f6193c]) {
                case ' ':
                    this.f6196f = this.f6195e;
                    this.f6193c++;
                    char[] cArr = this.g;
                    int i = this.f6195e;
                    this.f6195e = i + 1;
                    cArr[i] = ' ';
                    while (this.f6193c < this.f6192b && this.g[this.f6193c] == ' ') {
                        char[] cArr2 = this.g;
                        int i2 = this.f6195e;
                        this.f6195e = i2 + 1;
                        cArr2[i2] = ' ';
                        this.f6193c++;
                    }
                    if (this.f6193c == this.f6192b || this.g[this.f6193c] == ',' || this.g[this.f6193c] == '+' || this.g[this.f6193c] == ';') {
                        return new String(this.g, this.f6194d, this.f6196f - this.f6194d);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.g, this.f6194d, this.f6195e - this.f6194d);
                case '\\':
                    char[] cArr3 = this.g;
                    int i3 = this.f6195e;
                    this.f6195e = i3 + 1;
                    cArr3[i3] = e();
                    this.f6193c++;
                    break;
                default:
                    char[] cArr4 = this.g;
                    int i4 = this.f6195e;
                    this.f6195e = i4 + 1;
                    cArr4[i4] = this.g[this.f6193c];
                    this.f6193c++;
                    break;
            }
        }
        return new String(this.g, this.f6194d, this.f6195e - this.f6194d);
    }

    private char e() {
        this.f6193c++;
        if (this.f6193c == this.f6192b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6191a);
        }
        switch (this.g[this.f6193c]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.g[this.f6193c];
            default:
                return f();
        }
    }

    private char f() {
        int i;
        int i2;
        int iA = a(this.f6193c);
        this.f6193c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i = 1;
            i2 = iA & 31;
        } else if (iA <= 239) {
            i = 2;
            i2 = iA & 15;
        } else {
            i = 3;
            i2 = iA & 7;
        }
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            this.f6193c++;
            if (this.f6193c == this.f6192b || this.g[this.f6193c] != '\\') {
                return '?';
            }
            this.f6193c++;
            int iA2 = a(this.f6193c);
            this.f6193c++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iA2 & 63);
        }
        return (char) i3;
    }

    public String a(String str) {
        this.f6193c = 0;
        this.f6194d = 0;
        this.f6195e = 0;
        this.f6196f = 0;
        this.g = this.f6191a.toCharArray();
        String strA = a();
        if (strA == null) {
            return null;
        }
        do {
            String strC = "";
            if (this.f6193c == this.f6192b) {
                return null;
            }
            switch (this.g[this.f6193c]) {
                case '\"':
                    strC = b();
                    break;
                case '#':
                    strC = c();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    strC = d();
                    break;
            }
            if (str.equalsIgnoreCase(strA)) {
                return strC;
            }
            if (this.f6193c >= this.f6192b) {
                return null;
            }
            if (this.g[this.f6193c] != ',' && this.g[this.f6193c] != ';' && this.g[this.f6193c] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f6191a);
            }
            this.f6193c++;
            strA = a();
        } while (strA != null);
        throw new IllegalStateException("Malformed DN: " + this.f6191a);
    }
}
