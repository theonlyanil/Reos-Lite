package a.a.a.a.a;

import a.a.a.a.c;
import android.media.AudioRecord;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioRecord f27a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.a.a.a.b f28b;

    public a(AudioRecord audioRecord, a.a.a.a.b bVar) {
        this.f27a = audioRecord;
        this.f28b = bVar;
    }

    @Override // a.a.a.a.c
    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.f27a.read(bArr, i, i2);
    }

    @Override // a.a.a.a.c
    public long a(long j) throws IOException {
        throw new IOException("Can not skip in audio stream");
    }

    @Override // a.a.a.a.c
    public void a() throws IOException {
        this.f27a.stop();
        this.f27a.release();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.b b() {
        return this.f28b;
    }
}
