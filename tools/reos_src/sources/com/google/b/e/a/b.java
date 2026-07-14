package com.google.b.e.a;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f5530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f5531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5532e;

    b() {
        this(null, null, null, null, null);
    }

    b(String str, String str2, byte[] bArr, Integer num, String str3) {
        this.f5528a = str;
        this.f5529b = str2;
        this.f5530c = bArr;
        this.f5531d = num;
        this.f5532e = str3;
    }

    public String a() {
        return this.f5528a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("Format: ").append(this.f5529b).append('\n');
        sb.append("Contents: ").append(this.f5528a).append('\n');
        sb.append("Raw bytes: (").append(this.f5530c == null ? 0 : this.f5530c.length).append(" bytes)\n");
        sb.append("Orientation: ").append(this.f5531d).append('\n');
        sb.append("EC level: ").append(this.f5532e).append('\n');
        return sb.toString();
    }
}
