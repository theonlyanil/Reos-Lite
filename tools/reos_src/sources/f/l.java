package f;

import d.ab;
import d.ac;

/* JADX INFO: loaded from: classes.dex */
public final class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab f6572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f6573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ac f6574c;

    private l(ab abVar, T t, ac acVar) {
        this.f6572a = abVar;
        this.f6573b = t;
        this.f6574c = acVar;
    }

    public static <T> l<T> a(ac acVar, ab abVar) {
        if (acVar == null) {
            throw new NullPointerException("body == null");
        }
        if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (abVar.d()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new l<>(abVar, null, acVar);
    }

    public static <T> l<T> a(T t, ab abVar) {
        if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        }
        if (abVar.d()) {
            return new l<>(abVar, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public ab a() {
        return this.f6572a;
    }

    public int b() {
        return this.f6572a.c();
    }

    public String c() {
        return this.f6572a.e();
    }

    public boolean d() {
        return this.f6572a.d();
    }

    public T e() {
        return this.f6573b;
    }

    public ac f() {
        return this.f6574c;
    }
}
