package com.google.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f5246a = new String[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f5247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Writer f5248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f5249d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5250e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5251f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            f5246a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        f5246a[34] = "\\\"";
        f5246a[92] = "\\\\";
        f5246a[9] = "\\t";
        f5246a[8] = "\\b";
        f5246a[10] = "\\n";
        f5246a[13] = "\\r";
        f5246a[12] = "\\f";
        f5247b = (String[]) f5246a.clone();
        f5247b[60] = "\\u003c";
        f5247b[62] = "\\u003e";
        f5247b[38] = "\\u0026";
        f5247b[61] = "\\u003d";
        f5247b[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f5248c = writer;
    }

    private int a() {
        if (this.f5250e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.f5249d[this.f5250e - 1];
    }

    private c a(int i, int i2, String str) throws IOException {
        int iA = a();
        if (iA != i2 && iA != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.f5250e--;
        if (iA == i2) {
            k();
        }
        this.f5248c.write(str);
        return this;
    }

    private c a(int i, String str) throws IOException {
        m();
        a(i);
        this.f5248c.write(str);
        return this;
    }

    private void a(int i) {
        if (this.f5250e == this.f5249d.length) {
            int[] iArr = new int[this.f5250e * 2];
            System.arraycopy(this.f5249d, 0, iArr, 0, this.f5250e);
            this.f5249d = iArr;
        }
        int[] iArr2 = this.f5249d;
        int i2 = this.f5250e;
        this.f5250e = i2 + 1;
        iArr2[i2] = i;
    }

    private void b(int i) {
        this.f5249d[this.f5250e - 1] = i;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    private void d(String str) throws IOException {
        String str2;
        int i = 0;
        String[] strArr = this.i ? f5247b : f5246a;
        this.f5248c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.f5248c.write(str, i, i2 - i);
                    }
                    this.f5248c.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f5248c.write(str, i, i2 - i);
                }
                this.f5248c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f5248c.write(str, i, length - i);
        }
        this.f5248c.write("\"");
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    private void k() throws IOException {
        if (this.f5251f == null) {
            return;
        }
        this.f5248c.write("\n");
        int i = this.f5250e;
        for (int i2 = 1; i2 < i; i2++) {
            this.f5248c.write(this.f5251f);
        }
    }

    private void l() throws IOException {
        int iA = a();
        if (iA == 5) {
            this.f5248c.write(44);
        } else if (iA != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        switch (a()) {
            case 1:
                b(2);
                k();
                return;
            case 2:
                this.f5248c.append(',');
                k();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.f5248c.append((CharSequence) this.g);
                b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        b(7);
    }

    public c a(long j) throws IOException {
        j();
        m();
        this.f5248c.write(Long.toString(j));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String string = number.toString();
        if (!this.h && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m();
        this.f5248c.append((CharSequence) string);
        return this;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.f5250e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = str;
        return this;
    }

    public c a(boolean z) throws IOException {
        j();
        m();
        this.f5248c.write(z ? "true" : "false");
        return this;
    }

    public c b() throws IOException {
        j();
        return a(1, "[");
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        m();
        d(str);
        return this;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public c c() throws IOException {
        return a(1, 2, "]");
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f5251f = null;
            this.g = ":";
        } else {
            this.f5251f = str;
            this.g = ": ";
        }
    }

    public final void c(boolean z) {
        this.i = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5248c.close();
        int i = this.f5250e;
        if (i > 1 || (i == 1 && this.f5249d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5250e = 0;
    }

    public c d() throws IOException {
        j();
        return a(3, "{");
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public c e() throws IOException {
        return a(3, 5, "}");
    }

    public c f() throws IOException {
        if (this.j == null) {
            m();
            this.f5248c.write("null");
        } else if (this.k) {
            j();
            m();
            this.f5248c.write("null");
        } else {
            this.j = null;
        }
        return this;
    }

    public void flush() throws IOException {
        if (this.f5250e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f5248c.flush();
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}
