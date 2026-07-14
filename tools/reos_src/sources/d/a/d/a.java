package d.a.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X509TrustManager f6188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f6189b;

    public a(X509TrustManager x509TrustManager, Method method) {
        this.f6189b = method;
        this.f6188a = x509TrustManager;
    }

    public static f a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    @Override // d.a.d.f
    public X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.f6189b.invoke(this.f6188a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        } catch (InvocationTargetException e3) {
            return null;
        }
    }
}
