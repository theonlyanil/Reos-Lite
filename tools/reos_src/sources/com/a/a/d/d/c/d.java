package com.a.a.d.d.c;

import com.a.a.d.b.k;
import com.a.a.d.c.o;
import com.a.a.d.e;
import com.a.a.d.f;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.a.a.g.b<InputStream, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2281a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<File, File> f2282b = new com.a.a.d.d.c.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.b<InputStream> f2283c = new o();

    private static class a implements e<InputStream, File> {
        private a() {
        }

        @Override // com.a.a.d.e
        public k<File> a(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // com.a.a.d.e
        public String a() {
            return "";
        }
    }

    @Override // com.a.a.g.b
    public e<File, File> a() {
        return this.f2282b;
    }

    @Override // com.a.a.g.b
    public e<InputStream, File> b() {
        return f2281a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.f2283c;
    }

    @Override // com.a.a.g.b
    public f<File> d() {
        return com.a.a.d.d.b.b();
    }
}
