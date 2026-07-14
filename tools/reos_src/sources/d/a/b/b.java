package d.a.b;

import d.ab;
import d.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f6097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ab f6098b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f6099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final z f6100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ab f6101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f6102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f6103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f6104f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, z zVar, ab abVar) {
            this.l = -1;
            this.f6099a = j;
            this.f6100b = zVar;
            this.f6101c = abVar;
            if (abVar != null) {
                d.r rVarG = abVar.g();
                int iA = rVarG.a();
                for (int i = 0; i < iA; i++) {
                    String strA = rVarG.a(i);
                    String strB = rVarG.b(i);
                    if ("Date".equalsIgnoreCase(strA)) {
                        this.f6102d = f.a(strB);
                        this.f6103e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = f.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f6104f = f.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = c.b(strB, -1);
                    } else if (j.f6153b.equalsIgnoreCase(strA)) {
                        this.i = Long.parseLong(strB);
                    } else if (j.f6154c.equalsIgnoreCase(strA)) {
                        this.j = Long.parseLong(strB);
                    }
                }
            }
        }

        private static boolean a(z zVar) {
            return (zVar.a("If-Modified-Since") == null && zVar.a("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private b b() {
            long millis = 0;
            ab abVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.f6101c == null) {
                return new b(this.f6100b, abVar);
            }
            if (this.f6100b.g() && this.f6101c.f() == null) {
                return new b(this.f6100b, objArr11 == true ? 1 : 0);
            }
            if (!b.a(this.f6101c, this.f6100b)) {
                return new b(this.f6100b, objArr9 == true ? 1 : 0);
            }
            d.d dVarF = this.f6100b.f();
            if (dVarF.a() || a(this.f6100b)) {
                return new b(this.f6100b, objArr2 == true ? 1 : 0);
            }
            long jD = d();
            long jC = c();
            if (dVarF.c() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(dVarF.c()));
            }
            long millis2 = dVarF.h() != -1 ? TimeUnit.SECONDS.toMillis(dVarF.h()) : 0L;
            d.d dVarK = this.f6101c.k();
            if (!dVarK.f() && dVarF.g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarF.g());
            }
            if (!dVarK.a() && jD + millis2 < millis + jC) {
                ab.a aVarI = this.f6101c.i();
                if (millis2 + jD >= jC) {
                    aVarI.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (jD > 86400000 && e()) {
                    aVarI.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new b(objArr7 == true ? 1 : 0, aVarI.a());
            }
            z.a aVarE = this.f6100b.e();
            if (this.k != null) {
                aVarE.a("If-None-Match", this.k);
            } else if (this.f6104f != null) {
                aVarE.a("If-Modified-Since", this.g);
            } else if (this.f6102d != null) {
                aVarE.a("If-Modified-Since", this.f6103e);
            }
            z zVarA = aVarE.a();
            return a(zVarA) ? new b(zVarA, this.f6101c) : new b(zVarA, objArr4 == true ? 1 : 0);
        }

        private long c() {
            d.d dVarK = this.f6101c.k();
            if (dVarK.c() != -1) {
                return TimeUnit.SECONDS.toMillis(dVarK.c());
            }
            if (this.h != null) {
                long time = this.h.getTime() - (this.f6102d != null ? this.f6102d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            }
            if (this.f6104f == null || this.f6101c.a().a().l() != null) {
                return 0L;
            }
            long time2 = (this.f6102d != null ? this.f6102d.getTime() : this.i) - this.f6104f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long d() {
            long jMax = this.f6102d != null ? Math.max(0L, this.j - this.f6102d.getTime()) : 0L;
            if (this.l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
            }
            return jMax + (this.j - this.i) + (this.f6099a - this.j);
        }

        private boolean e() {
            return this.f6101c.k().c() == -1 && this.h == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b a() {
            z zVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            b bVarB = b();
            return (bVarB.f6097a == null || !this.f6100b.f().i()) ? bVarB : new b(zVar, objArr2 == true ? 1 : 0);
        }
    }

    private b(z zVar, ab abVar) {
        this.f6097a = zVar;
        this.f6098b = abVar;
    }

    public static boolean a(ab abVar, z zVar) {
        switch (abVar.c()) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case 308:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            case 302:
            case 307:
                if (abVar.a("Expires") == null && abVar.k().c() == -1 && !abVar.k().e() && !abVar.k().d()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return (abVar.k().b() || zVar.f().b()) ? false : true;
    }
}
