package d.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class o extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f6162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f6163b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e2) {
            declaredMethod = null;
        }
        f6162a = declaredMethod;
    }

    public o(IOException iOException) {
        super(iOException);
        this.f6163b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        if (f6162a != null) {
            try {
                f6162a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    public IOException a() {
        return this.f6163b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f6163b);
        this.f6163b = iOException;
    }
}
