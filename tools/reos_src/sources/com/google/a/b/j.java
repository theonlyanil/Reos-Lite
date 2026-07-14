package com.google.a.b;

import com.google.a.b.a.m;
import com.google.a.l;
import com.google.a.n;
import com.google.a.p;
import com.google.a.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    private static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f5219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0085a f5220b = new C0085a();

        /* JADX INFO: renamed from: com.google.a.b.j$a$a, reason: collision with other inner class name */
        static class C0085a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            char[] f5221a;

            C0085a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f5221a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5221a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f5221a, i, i2 - i);
            }
        }

        a(Appendable appendable) {
            this.f5219a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f5219a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.f5220b.f5221a = cArr;
            this.f5219a.append(this.f5220b, i, i + i2);
        }
    }

    public static l a(com.google.a.d.a aVar) throws p {
        boolean z = true;
        try {
            aVar.f();
            z = false;
            return m.X.b(aVar);
        } catch (com.google.a.d.d e2) {
            throw new u(e2);
        } catch (EOFException e3) {
            if (z) {
                return n.f5272a;
            }
            throw new u(e3);
        } catch (IOException e4) {
            throw new com.google.a.m(e4);
        } catch (NumberFormatException e5) {
            throw new u(e5);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    public static void a(l lVar, com.google.a.d.c cVar) throws IOException {
        m.X.a(cVar, lVar);
    }
}
