package d.a.d;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, List<X509Certificate>> f6198a = new LinkedHashMap();

    public e(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List<X509Certificate> arrayList = this.f6198a.get(subjectX500Principal);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f6198a.put(subjectX500Principal, arrayList);
            }
            arrayList.add(x509Certificate);
        }
    }

    @Override // d.a.d.f
    public X509Certificate a(X509Certificate x509Certificate) {
        List<X509Certificate> list = this.f6198a.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception e2) {
            }
        }
        return null;
    }
}
