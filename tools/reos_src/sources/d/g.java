package d;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6296a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f6297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.a.d.f f6298c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f6299a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.a.d.f f6300b;

        public a() {
        }

        a(g gVar) {
            this.f6299a.addAll(gVar.f6297b);
            this.f6300b = gVar.f6298c;
        }

        public a a(d.a.d.f fVar) {
            this.f6300b = fVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f6301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f6302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e.f f6303c;

        boolean a(String str) {
            boolean z = false;
            if (this.f6301a.equals(str)) {
                return true;
            }
            int iIndexOf = str.indexOf(46);
            if (this.f6301a.startsWith("*.") && str.regionMatches(false, iIndexOf + 1, this.f6301a, 2, this.f6301a.length() - 2)) {
                z = true;
            }
            return z;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && this.f6301a.equals(((b) obj).f6301a) && this.f6302b.equals(((b) obj).f6302b) && this.f6303c.equals(((b) obj).f6303c);
        }

        public int hashCode() {
            return ((((this.f6301a.hashCode() + 527) * 31) + this.f6302b.hashCode()) * 31) + this.f6303c.hashCode();
        }

        public String toString() {
            return this.f6302b + this.f6303c.b();
        }
    }

    private g(a aVar) {
        this.f6297b = d.a.j.a(aVar.f6299a);
        this.f6298c = aVar.f6300b;
    }

    static e.f a(X509Certificate x509Certificate) {
        return d.a.j.a(e.f.a(x509Certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static e.f b(X509Certificate x509Certificate) {
        return d.a.j.b(e.f.a(x509Certificate.getPublicKey().getEncoded()));
    }

    a a() {
        return new a(this);
    }

    List<b> a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f6297b) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listA = a(str);
        if (listA.isEmpty()) {
            return;
        }
        if (this.f6298c != null) {
            list = new d.a.d.b(this.f6298c).a(list);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listA.size();
            int i2 = 0;
            e.f fVarB = null;
            e.f fVarA = null;
            while (i2 < size2) {
                b bVar = listA.get(i2);
                if (bVar.f6302b.equals("sha256/")) {
                    if (fVarB == null) {
                        fVarB = b(x509Certificate);
                    }
                    if (bVar.f6303c.equals(fVarB)) {
                        return;
                    }
                } else {
                    if (!bVar.f6302b.equals("sha1/")) {
                        throw new AssertionError();
                    }
                    if (fVarA == null) {
                        fVarA = a(x509Certificate);
                    }
                    if (bVar.f6303c.equals(fVarA)) {
                        return;
                    }
                }
                i2++;
                fVarA = fVarA;
                fVarB = fVarB;
            }
        }
        StringBuilder sbAppend = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sbAppend.append("\n    ").append(a((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sbAppend.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listA.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sbAppend.append("\n    ").append(listA.get(i4));
        }
        throw new SSLPeerUnverifiedException(sbAppend.toString());
    }
}
