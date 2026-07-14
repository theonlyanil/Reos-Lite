package com.android.library.http.b;

import android.content.Context;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import d.c;
import d.w;
import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static c a(Context context) {
        if (context == null) {
            return null;
        }
        return new c(b(context), 10485760L);
    }

    public static w a(Context context, int i, w wVar, HTTPLibrary.c cVar, boolean z) {
        InputStream inputStreamOpenRawResource = (cVar == HTTPLibrary.c.UPLOAD || cVar == HTTPLibrary.c.DOWNLOAD) ? context.getResources().openRawResource(com.android.library.http.b.a.cubecertificatessluploaddownload) : context.getResources().openRawResource(com.android.library.http.b.a.cubecertificatessl);
        if (inputStreamOpenRawResource != null) {
            try {
                SSLContext sSLContextA = a(inputStreamOpenRawResource);
                if (sSLContextA != null) {
                    if (cVar == HTTPLibrary.c.ANALYTICS) {
                        CLog.b("HTTPLibrary", "GZip Analytics data");
                        wVar = wVar.x().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(new a()).a(sSLContextA.getSocketFactory()).a();
                    } else if (cVar != HTTPLibrary.c.GET) {
                        CLog.b("HTTPLibrary", "GZip not done because it is not a Analytics data");
                        wVar = wVar.x().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(sSLContextA.getSocketFactory()).a();
                    } else if (z) {
                        CLog.b("HTTPLibrary", "GZip not done and cache is enabled since it is GET request");
                        try {
                            wVar = wVar.x().a(a(context)).b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(sSLContextA.getSocketFactory()).a();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        try {
                            wVar = wVar.x().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(sSLContextA.getSocketFactory()).a();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return wVar;
    }

    private static KeyStore a(char[] cArr) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load((InputStream) null, cArr);
            return keyStore;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static SSLContext a(InputStream inputStream) {
        try {
            Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
            if (collectionGenerateCertificates.isEmpty()) {
                throw new IllegalArgumentException("expected non-empty set of trusted certificates");
            }
            char[] charArray = "password".toCharArray();
            KeyStore keyStoreA = a(charArray);
            Iterator<? extends Certificate> it = collectionGenerateCertificates.iterator();
            int i = 0;
            while (it.hasNext()) {
                keyStoreA.setCertificateEntry(Integer.toString(i), it.next());
                i++;
            }
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStoreA, charArray);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStoreA);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sSLContext;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static File b(Context context) {
        return new File(context.getCacheDir(), "HTTPLibraryCache");
    }
}
