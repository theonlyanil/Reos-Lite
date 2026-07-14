package d;

/* JADX INFO: loaded from: classes.dex */
public enum ae {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f6255e;

    ae(String str) {
        this.f6255e = str;
    }

    public static ae a(String str) {
        switch (str) {
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1":
                return TLS_1_0;
            case "SSLv3":
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    public String a() {
        return this.f6255e;
    }
}
