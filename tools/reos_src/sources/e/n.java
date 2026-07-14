package e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f6469a = Logger.getLogger(n.class.getName());

    private n() {
    }

    public static d a(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        return new o(sVar);
    }

    public static e a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        return new p(tVar);
    }

    public static s a(OutputStream outputStream) {
        return a(outputStream, new u());
    }

    private static s a(final OutputStream outputStream, final u uVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (uVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new s() { // from class: e.n.1
            @Override // e.s
            public u a() {
                return uVar;
            }

            @Override // e.s
            public void a_(c cVar, long j) throws IOException {
                v.a(cVar.f6441b, 0L, j);
                while (j > 0) {
                    uVar.g();
                    q qVar = cVar.f6440a;
                    int iMin = (int) Math.min(j, qVar.f6484c - qVar.f6483b);
                    outputStream.write(qVar.f6482a, qVar.f6483b, iMin);
                    qVar.f6483b += iMin;
                    j -= (long) iMin;
                    cVar.f6441b -= (long) iMin;
                    if (qVar.f6483b == qVar.f6484c) {
                        cVar.f6440a = qVar.a();
                        r.a(qVar);
                    }
                }
            }

            @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // e.s, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static s a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getOutputStream(), aVarC));
    }

    public static t a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static t a(InputStream inputStream) {
        return a(inputStream, new u());
    }

    private static t a(final InputStream inputStream, final u uVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (uVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new t() { // from class: e.n.2
            @Override // e.t
            public long a(c cVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                uVar.g();
                q qVarF = cVar.f(1);
                int i = inputStream.read(qVarF.f6482a, qVarF.f6484c, (int) Math.min(j, 2048 - qVarF.f6484c));
                if (i == -1) {
                    return -1L;
                }
                qVarF.f6484c += i;
                cVar.f6441b += (long) i;
                return i;
            }

            @Override // e.t
            public u a() {
                return uVar;
            }

            @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static s b(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static t b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getInputStream(), aVarC));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: e.n.3
            @Override // e.a
            protected IOException a(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // e.a
            protected void a() {
                try {
                    socket.close();
                } catch (AssertionError e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    n.f6469a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                } catch (Exception e3) {
                    n.f6469a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
                }
            }
        };
    }

    public static s c(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }
}
