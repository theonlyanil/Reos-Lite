package d.a;

import d.s;
import e.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f6218a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f6219b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f6220c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeZone f6221d = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f6222e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int a(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c2) {
                return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static e.f a(e.f fVar) {
        try {
            return e.f.a(MessageDigest.getInstance("SHA-1").digest(fVar.g()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String a(s sVar, boolean z) {
        String strF = sVar.f().contains(":") ? "[" + sVar.f() + "]" : sVar.f();
        return (z || sVar.g() != s.a(sVar.b())) ? strF + ":" + sVar.g() : strF;
    }

    public static String a(String str) {
        try {
            return e.f.a(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).d();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    private static <T> List<T> a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            for (T t2 : tArr2) {
                if (t.equals(t2)) {
                    arrayList.add(t2);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: d.a.j.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static void a(Closeable closeable, Closeable closeable2) throws IOException {
        Throwable th = null;
        try {
            closeable.close();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            closeable2.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        if (th == null) {
            return;
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new AssertionError(th);
        }
        throw ((Error) th);
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception e4) {
            }
        }
    }

    public static boolean a(t tVar, int i, TimeUnit timeUnit) {
        try {
            return b(tVar, i, timeUnit);
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List listA = a((Object[]) tArr, (Object[]) tArr2);
        return (T[]) listA.toArray((Object[]) Array.newInstance((Class<?>) cls, listA.size()));
    }

    public static int b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static e.f b(e.f fVar) {
        try {
            return e.f.a(MessageDigest.getInstance("SHA-256").digest(fVar.g()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String b(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public static boolean b(t tVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jD = tVar.a().h_() ? tVar.a().d() - jNanoTime : Long.MAX_VALUE;
        tVar.a().a(Math.min(jD, timeUnit.toNanos(i)) + jNanoTime);
        try {
            e.c cVar = new e.c();
            while (tVar.a(cVar, 2048L) != -1) {
                cVar.u();
            }
            if (jD == Long.MAX_VALUE) {
                tVar.a().f();
            } else {
                tVar.a().a(jD + jNanoTime);
            }
            return true;
        } catch (InterruptedIOException e2) {
            if (jD == Long.MAX_VALUE) {
                tVar.a().f();
            } else {
                tVar.a().a(jD + jNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jD == Long.MAX_VALUE) {
                tVar.a().f();
            } else {
                tVar.a().a(jD + jNanoTime);
            }
            throw th;
        }
    }

    public static String[] b(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static String c(String str, int i, int i2) {
        int iA = a(str, i, i2);
        return str.substring(iA, b(str, iA, i2));
    }

    public static boolean c(String str) {
        return f6222e.matcher(str).matches();
    }

    private static boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
