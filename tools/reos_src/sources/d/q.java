package d;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ae f6346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f6347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f6348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f6349d;

    private q(ae aeVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f6346a = aeVar;
        this.f6347b = hVar;
        this.f6348c = list;
        this.f6349d = list2;
    }

    public static q a(ae aeVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        if (hVar == null) {
            throw new IllegalArgumentException("cipherSuite == null");
        }
        return new q(aeVar, hVar, d.a.j.a(list), d.a.j.a(list2));
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h hVarA = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ae aeVarA = ae.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e2) {
            peerCertificates = null;
        }
        List listA = peerCertificates != null ? d.a.j.a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(aeVarA, hVarA, listA, localCertificates != null ? d.a.j.a(localCertificates) : Collections.emptyList());
    }

    public ae a() {
        return this.f6346a;
    }

    public h b() {
        return this.f6347b;
    }

    public List<Certificate> c() {
        return this.f6348c;
    }

    public List<Certificate> d() {
        return this.f6349d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return d.a.j.a(this.f6347b, qVar.f6347b) && this.f6347b.equals(qVar.f6347b) && this.f6348c.equals(qVar.f6348c) && this.f6349d.equals(qVar.f6349d);
    }

    public int hashCode() {
        return (((((((this.f6346a != null ? this.f6346a.hashCode() : 0) + 527) * 31) + this.f6347b.hashCode()) * 31) + this.f6348c.hashCode()) * 31) + this.f6349d.hashCode();
    }
}
