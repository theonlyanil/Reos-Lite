package d;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f6321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f6322f;
    private final String[] g;
    private final String[] h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h[] f6320d = {h.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, h.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, h.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, h.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, h.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, h.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, h.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, h.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, h.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, h.TLS_RSA_WITH_AES_128_GCM_SHA256, h.TLS_RSA_WITH_AES_128_CBC_SHA, h.TLS_RSA_WITH_AES_256_CBC_SHA, h.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f6317a = new a(true).a(f6320d).a(ae.TLS_1_2, ae.TLS_1_1, ae.TLS_1_0).a(true).a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f6318b = new a(f6317a).a(ae.TLS_1_0).a(true).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f6319c = new a(false).a();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f6324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f6325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6326d;

        public a(k kVar) {
            this.f6323a = kVar.f6321e;
            this.f6324b = kVar.g;
            this.f6325c = kVar.h;
            this.f6326d = kVar.f6322f;
        }

        a(boolean z) {
            this.f6323a = z;
        }

        public a a(boolean z) {
            if (!this.f6323a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f6326d = z;
            return this;
        }

        public a a(ae... aeVarArr) {
            if (!this.f6323a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[aeVarArr.length];
            for (int i = 0; i < aeVarArr.length; i++) {
                strArr[i] = aeVarArr[i].f6255e;
            }
            return b(strArr);
        }

        public a a(h... hVarArr) {
            if (!this.f6323a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].aS;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.f6323a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f6324b = (String[]) strArr.clone();
            return this;
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.f6323a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f6325c = (String[]) strArr.clone();
            return this;
        }
    }

    private k(a aVar) {
        this.f6321e = aVar.f6323a;
        this.g = aVar.f6324b;
        this.h = aVar.f6325c;
        this.f6322f = aVar.f6326d;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (d.a.j.a(strArr2, str)) {
                return true;
            }
        }
        return false;
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites = this.g != null ? (String[]) d.a.j.a(String.class, this.g, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] enabledProtocols = this.h != null ? (String[]) d.a.j.a(String.class, this.h, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && d.a.j.a(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = d.a.j.b(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    void a(SSLSocket sSLSocket, boolean z) {
        k kVarB = b(sSLSocket, z);
        if (kVarB.h != null) {
            sSLSocket.setEnabledProtocols(kVarB.h);
        }
        if (kVarB.g != null) {
            sSLSocket.setEnabledCipherSuites(kVarB.g);
        }
    }

    public boolean a() {
        return this.f6321e;
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f6321e) {
            return false;
        }
        if (this.h == null || a(this.h, sSLSocket.getEnabledProtocols())) {
            return this.g == null || a(this.g, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public List<h> b() {
        if (this.g == null) {
            return null;
        }
        h[] hVarArr = new h[this.g.length];
        for (int i = 0; i < this.g.length; i++) {
            hVarArr[i] = h.a(this.g[i]);
        }
        return d.a.j.a(hVarArr);
    }

    public List<ae> c() {
        if (this.h == null) {
            return null;
        }
        ae[] aeVarArr = new ae[this.h.length];
        for (int i = 0; i < this.h.length; i++) {
            aeVarArr[i] = ae.a(this.h[i]);
        }
        return d.a.j.a(aeVarArr);
    }

    public boolean d() {
        return this.f6322f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        if (this.f6321e == kVar.f6321e) {
            return !this.f6321e || (Arrays.equals(this.g, kVar.g) && Arrays.equals(this.h, kVar.h) && this.f6322f == kVar.f6322f);
        }
        return false;
    }

    public int hashCode() {
        if (!this.f6321e) {
            return 17;
        }
        return (this.f6322f ? 0 : 1) + ((((Arrays.hashCode(this.g) + 527) * 31) + Arrays.hashCode(this.h)) * 31);
    }

    public String toString() {
        if (!this.f6321e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.g != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.h != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f6322f + ")";
    }
}
