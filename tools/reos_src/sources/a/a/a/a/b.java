package a.a.a.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f29a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f30b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f31c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f32d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f33e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f34f;
    protected boolean g;
    private HashMap<String, Object> h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35a = new a("PCM_SIGNED");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f36b = new a("PCM_UNSIGNED");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f37c = new a("ULAW");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f38d = new a("ALAW");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f39e;

        public a(String str) {
            this.f39e = str;
        }

        public final boolean equals(Object obj) {
            if (toString() == null) {
                return obj != null && obj.toString() == null;
            }
            if (obj instanceof a) {
                return toString().equals(obj.toString());
            }
            return false;
        }

        public final int hashCode() {
            if (toString() == null) {
                return 0;
            }
            return toString().hashCode();
        }

        public final String toString() {
            return this.f39e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(float f2, int i, int i2, boolean z, boolean z2) {
        int i3 = -1;
        a aVar = z ? a.f35a : a.f36b;
        if (i2 != -1 && i != -1) {
            i3 = ((i + 7) / 8) * i2;
        }
        this(aVar, f2, i, i2, i3, f2, z2);
    }

    public b(a aVar, float f2, int i, int i2, int i3, float f3, boolean z) {
        this.f29a = aVar;
        this.f30b = f2;
        this.f31c = i;
        this.f32d = i2;
        this.f33e = i3;
        this.f34f = f3;
        this.g = z;
        this.h = null;
    }

    public a a() {
        return this.f29a;
    }

    public float b() {
        return this.f30b;
    }

    public int c() {
        return this.f31c;
    }

    public int d() {
        return this.f32d;
    }

    public int e() {
        return this.f33e;
    }

    public float f() {
        return this.f34f;
    }

    public boolean g() {
        return this.g;
    }

    public String toString() {
        String str;
        String str2 = a() != null ? a().toString() + " " : "";
        String str3 = b() == -1.0f ? "unknown sample rate, " : "" + b() + " Hz, ";
        String str4 = ((float) c()) == -1.0f ? "unknown bits per sample, " : "" + c() + " bit, ";
        if (d() == 1) {
            str = "mono, ";
        } else if (d() == 2) {
            str = "stereo, ";
        } else {
            str = d() == -1 ? " unknown number of channels, " : "" + d() + " channels, ";
        }
        String str5 = ((float) e()) == -1.0f ? "unknown frame size, " : "" + e() + " bytes/frame, ";
        String str6 = "";
        if (Math.abs(b() - f()) > 1.0E-5d) {
            str6 = f() == -1.0f ? "unknown frame rate, " : f() + " frames/second, ";
        }
        String str7 = "";
        if ((a().equals(a.f35a) || a().equals(a.f36b)) && (c() > 8 || c() == -1)) {
            str7 = g() ? "big-endian" : "little-endian";
        }
        return str2 + str3 + str4 + str + str5 + str6 + str7;
    }
}
