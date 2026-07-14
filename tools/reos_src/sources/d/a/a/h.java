package d.a.a;

import com.android.library.userprofile.util.Constants;
import e.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f[] f6012a = {new f(f.f6005e, ""), new f(f.f6002b, "GET"), new f(f.f6002b, "POST"), new f(f.f6003c, "/"), new f(f.f6003c, "/index.html"), new f(f.f6004d, "http"), new f(f.f6004d, "https"), new f(f.f6001a, "200"), new f(f.f6001a, "204"), new f(f.f6001a, "206"), new f(f.f6001a, "304"), new f(f.f6001a, "400"), new f(f.f6001a, "404"), new f(f.f6001a, "500"), new f("accept-charset", ""), new f("accept-encoding", "gzip, deflate"), new f("accept-language", ""), new f("accept-ranges", ""), new f("accept", ""), new f("access-control-allow-origin", ""), new f("age", ""), new f("allow", ""), new f("authorization", ""), new f("cache-control", ""), new f("content-disposition", ""), new f("content-encoding", ""), new f("content-language", ""), new f("content-length", ""), new f("content-location", ""), new f("content-range", ""), new f("content-type", ""), new f("cookie", ""), new f(Constants.SMS_COLUMN_DATE, ""), new f("etag", ""), new f("expect", ""), new f("expires", ""), new f("from", ""), new f("host", ""), new f("if-match", ""), new f("if-modified-since", ""), new f("if-none-match", ""), new f("if-range", ""), new f("if-unmodified-since", ""), new f("last-modified", ""), new f("link", ""), new f("location", ""), new f("max-forwards", ""), new f("proxy-authenticate", ""), new f("proxy-authorization", ""), new f("range", ""), new f("referer", ""), new f("refresh", ""), new f("retry-after", ""), new f("server", ""), new f("set-cookie", ""), new f("strict-transport-security", ""), new f("transfer-encoding", ""), new f("user-agent", ""), new f("vary", ""), new f("via", ""), new f("www-authenticate", "")};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<e.f, Integer> f6013b = c();

    static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e.e f6019f;
        private int g;
        private int h;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<f> f6018e = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f[] f6014a = new f[8];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6015b = this.f6014a.length - 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6016c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6017d = 0;

        a(int i, t tVar) {
            this.g = i;
            this.h = i;
            this.f6019f = e.n.a(tVar);
        }

        private void a(int i, f fVar) {
            this.f6018e.add(fVar);
            int i2 = fVar.j;
            if (i != -1) {
                i2 -= this.f6014a[d(i)].j;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int iB = b((this.f6017d + i2) - this.h);
            if (i == -1) {
                if (this.f6016c + 1 > this.f6014a.length) {
                    f[] fVarArr = new f[this.f6014a.length * 2];
                    System.arraycopy(this.f6014a, 0, fVarArr, this.f6014a.length, this.f6014a.length);
                    this.f6015b = this.f6014a.length - 1;
                    this.f6014a = fVarArr;
                }
                int i3 = this.f6015b;
                this.f6015b = i3 - 1;
                this.f6014a[i3] = fVar;
                this.f6016c++;
            } else {
                this.f6014a[iB + d(i) + i] = fVar;
            }
            this.f6017d = i2 + this.f6017d;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f6014a.length;
                while (true) {
                    length--;
                    if (length < this.f6015b || i <= 0) {
                        break;
                    }
                    i -= this.f6014a[length].j;
                    this.f6017d -= this.f6014a[length].j;
                    this.f6016c--;
                    i2++;
                }
                System.arraycopy(this.f6014a, this.f6015b + 1, this.f6014a, this.f6015b + 1 + i2, this.f6016c);
                this.f6015b += i2;
            }
            return i2;
        }

        private void c(int i) throws IOException {
            if (h(i)) {
                this.f6018e.add(h.f6012a[i]);
                return;
            }
            int iD = d(i - h.f6012a.length);
            if (iD < 0 || iD > this.f6014a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f6018e.add(this.f6014a[iD]);
        }

        private int d(int i) {
            return this.f6015b + 1 + i;
        }

        private void d() {
            if (this.h < this.f6017d) {
                if (this.h == 0) {
                    e();
                } else {
                    b(this.f6017d - this.h);
                }
            }
        }

        private void e() {
            this.f6018e.clear();
            Arrays.fill(this.f6014a, (Object) null);
            this.f6015b = this.f6014a.length - 1;
            this.f6016c = 0;
            this.f6017d = 0;
        }

        private void e(int i) throws IOException {
            this.f6018e.add(new f(g(i), c()));
        }

        private void f() throws IOException {
            this.f6018e.add(new f(h.b(c()), c()));
        }

        private void f(int i) throws IOException {
            a(-1, new f(g(i), c()));
        }

        private e.f g(int i) {
            return h(i) ? h.f6012a[i].h : this.f6014a[d(i - h.f6012a.length)].h;
        }

        private void g() throws IOException {
            a(-1, new f(h.b(c()), c()));
        }

        private int h() throws IOException {
            return this.f6019f.j() & com.flurry.android.Constants.UNKNOWN;
        }

        private boolean h(int i) {
            return i >= 0 && i <= h.f6012a.length + (-1);
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iH = h();
                if ((iH & 128) == 0) {
                    return (iH << i4) + i2;
                }
                i2 += (iH & 127) << i4;
                i4 += 7;
            }
        }

        void a() throws IOException {
            while (!this.f6019f.g()) {
                int iJ = this.f6019f.j() & com.flurry.android.Constants.UNKNOWN;
                if (iJ == 128) {
                    throw new IOException("index == 0");
                }
                if ((iJ & 128) == 128) {
                    c(a(iJ, 127) - 1);
                } else if (iJ == 64) {
                    g();
                } else if ((iJ & 64) == 64) {
                    f(a(iJ, 63) - 1);
                } else if ((iJ & 32) == 32) {
                    this.h = a(iJ, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (iJ == 16 || iJ == 0) {
                    f();
                } else {
                    e(a(iJ, 15) - 1);
                }
            }
        }

        void a(int i) {
            this.g = i;
            this.h = i;
            d();
        }

        public List<f> b() {
            ArrayList arrayList = new ArrayList(this.f6018e);
            this.f6018e.clear();
            return arrayList;
        }

        e.f c() throws IOException {
            int iH = h();
            boolean z = (iH & 128) == 128;
            int iA = a(iH, 127);
            return z ? e.f.a(j.a().a(this.f6019f.f(iA))) : this.f6019f.c(iA);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.c f6020a;

        b(e.c cVar) {
            this.f6020a = cVar;
        }

        void a(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.f6020a.j(i3 | i);
                return;
            }
            this.f6020a.j(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f6020a.j((i4 & 127) | 128);
                i4 >>>= 7;
            }
            this.f6020a.j(i4);
        }

        void a(e.f fVar) throws IOException {
            a(fVar.f(), 127, 0);
            this.f6020a.b(fVar);
        }

        void a(List<f> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e.f fVarE = list.get(i).h.e();
                Integer num = (Integer) h.f6013b.get(fVarE);
                if (num != null) {
                    a(num.intValue() + 1, 15, 0);
                    a(list.get(i).i);
                } else {
                    this.f6020a.j(0);
                    a(fVarE);
                    a(list.get(i).i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e.f b(e.f fVar) throws IOException {
        int iF = fVar.f();
        for (int i = 0; i < iF; i++) {
            byte bA = fVar.a(i);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }

    private static Map<e.f, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f6012a.length);
        for (int i = 0; i < f6012a.length; i++) {
            if (!linkedHashMap.containsKey(f6012a[i].h)) {
                linkedHashMap.put(f6012a[i].h, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
