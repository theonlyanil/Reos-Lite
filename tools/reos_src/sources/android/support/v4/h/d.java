package android.support.v4.h;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class d extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f793b = new StringBuilder(128);

    public d(String str) {
        this.f792a = str;
    }

    private void a() {
        if (this.f793b.length() > 0) {
            Log.d(this.f792a, this.f793b.toString());
            this.f793b.delete(0, this.f793b.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f793b.append(c2);
            }
        }
    }
}
