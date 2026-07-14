package d.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d.k> f5927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5928b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5930d;

    public a(List<d.k> list) {
        this.f5927a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        int i = this.f5928b;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5927a.size()) {
                return false;
            }
            if (this.f5927a.get(i2).a(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public d.k a(SSLSocket sSLSocket) throws IOException {
        d.k kVar;
        int i = this.f5928b;
        int size = this.f5927a.size();
        int i2 = i;
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f5927a.get(i2);
            if (kVar.a(sSLSocket)) {
                this.f5928b = i2 + 1;
                break;
            }
            i2++;
        }
        if (kVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5930d + ", modes=" + this.f5927a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f5929c = b(sSLSocket);
        d.f6187b.a(kVar, sSLSocket, this.f5930d);
        return kVar;
    }

    public boolean a(IOException iOException) {
        this.f5930d = true;
        if (!this.f5929c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }
}
