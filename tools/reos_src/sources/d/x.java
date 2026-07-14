package d;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6405e;

    x(String str) {
        this.f6405e = str;
    }

    public static x a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f6405e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f6405e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f6405e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f6405e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f6405e;
    }
}
