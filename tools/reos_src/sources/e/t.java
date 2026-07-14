package e;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface t extends Closeable {
    long a(c cVar, long j) throws IOException;

    u a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
