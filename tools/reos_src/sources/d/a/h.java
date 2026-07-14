package d.a;

import d.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f6203a = c();

    private static class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f6204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g<Socket> f6205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g<Socket> f6206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final g<Socket> f6207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final g<Socket> f6208e;

        public a(Class<?> cls, g<Socket> gVar, g<Socket> gVar2, g<Socket> gVar3, g<Socket> gVar4) {
            this.f6204a = cls;
            this.f6205b = gVar;
            this.f6206c = gVar2;
            this.f6207d = gVar3;
            this.f6208e = gVar4;
        }

        @Override // d.a.h
        public d.a.d.f a(X509TrustManager x509TrustManager) {
            d.a.d.f fVarA = d.a.d.a.a(x509TrustManager);
            return fVarA != null ? fVarA : super.a(x509TrustManager);
        }

        @Override // d.a.h
        public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
            Object objA;
            Object objA2 = a(sSLSocketFactory, this.f6204a, "sslParameters");
            if (objA2 == null) {
                try {
                    objA = a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException e2) {
                    return super.a(sSLSocketFactory);
                }
            } else {
                objA = objA2;
            }
            X509TrustManager x509TrustManager = (X509TrustManager) a(objA, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) a(objA, X509TrustManager.class, "trustManager");
        }

        @Override // d.a.h
        public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e2) {
                if (!j.a(e2)) {
                    throw e2;
                }
                throw new IOException(e2);
            } catch (SecurityException e3) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
        }

        @Override // d.a.h
        public void a(SSLSocket sSLSocket, String str, List<x> list) {
            if (str != null) {
                this.f6205b.b(sSLSocket, true);
                this.f6206c.b(sSLSocket, str);
            }
            if (this.f6208e == null || !this.f6208e.a(sSLSocket)) {
                return;
            }
            this.f6208e.d(sSLSocket, a(list));
        }

        @Override // d.a.h
        public String b(SSLSocket sSLSocket) {
            if (this.f6207d == null || !this.f6207d.a(sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.f6207d.d(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, j.f6220c) : null;
        }
    }

    private static class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f6209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f6210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f6211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Class<?> f6212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Class<?> f6213e;

        public b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f6209a = method;
            this.f6210b = method2;
            this.f6211c = method3;
            this.f6212d = cls;
            this.f6213e = cls2;
        }

        @Override // d.a.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f6211c.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new AssertionError();
            }
        }

        @Override // d.a.h
        public void a(SSLSocket sSLSocket, String str, List<x> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                x xVar = list.get(i);
                if (xVar != x.HTTP_1_0) {
                    arrayList.add(xVar.toString());
                }
            }
            try {
                this.f6209a.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f6212d, this.f6213e}, new c(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // d.a.h
        public String b(SSLSocket sSLSocket) {
            try {
                c cVar = (c) Proxy.getInvocationHandler(this.f6210b.invoke(null, sSLSocket));
                if (cVar.f6215b || cVar.f6216c != null) {
                    return cVar.f6215b ? null : cVar.f6216c;
                }
                d.f6186a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new AssertionError();
            }
        }
    }

    private static class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f6214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f6216c;

        public c(List<String> list) {
            this.f6214a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = j.f6219b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f6215b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f6214a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f6216c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f6214a.contains(list.get(i))) {
                    String str = (String) list.get(i);
                    this.f6216c = str;
                    return str;
                }
            }
            String str2 = this.f6214a.get(0);
            this.f6216c = str2;
            return str2;
        }
    }

    public static h a() {
        return f6203a;
    }

    static <T> T a(Object obj, Class<T> cls, String str) {
        Object objA;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null || !cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            } catch (NoSuchFieldException e3) {
            }
        }
        if (str.equals("delegate") || (objA = a(obj, (Class<Object>) Object.class, "delegate")) == null) {
            return null;
        }
        return (T) a(objA, cls, str);
    }

    static byte[] a(List<x> list) {
        e.c cVar = new e.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            x xVar = list.get(i);
            if (xVar != x.HTTP_1_0) {
                cVar.j(xVar.toString().length());
                cVar.b(xVar.toString());
            }
        }
        return cVar.t();
    }

    private static h c() {
        Class<?> cls;
        g gVar;
        g gVar2;
        g gVar3;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException e2) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            g gVar4 = new g(null, "setUseSessionTickets", Boolean.TYPE);
            g gVar5 = new g(null, "setHostname", String.class);
            try {
                Class.forName("android.net.Network");
                gVar = new g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    gVar2 = new g(null, "setAlpnProtocols", byte[].class);
                    gVar3 = gVar;
                } catch (ClassNotFoundException e3) {
                    gVar2 = null;
                    gVar3 = gVar;
                }
            } catch (ClassNotFoundException e4) {
                gVar = null;
            }
            return new a(cls, gVar4, gVar5, gVar3, gVar2);
        } catch (ClassNotFoundException e5) {
            try {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                return new b(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException e6) {
                return new h();
            }
        }
    }

    public d.a.d.f a(X509TrustManager x509TrustManager) {
        return new d.a.d.e(x509TrustManager.getAcceptedIssuers());
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object objA = a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objA == null) {
                return null;
            }
            return (X509TrustManager) a(objA, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    public void a(String str) {
        System.out.println(str);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<x> list) {
    }

    public String b() {
        return "OkHttp";
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }
}
