package d.a.a;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface b extends Closeable {

    public interface a {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<f> list) throws IOException;

        void a(int i, long j);

        void a(int i, d.a.a.a aVar);

        void a(int i, d.a.a.a aVar, e.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, e.e eVar, int i2) throws IOException;

        void a(boolean z, n nVar);

        void a(boolean z, boolean z2, int i, int i2, List<f> list, g gVar);
    }

    void a() throws IOException;

    boolean a(a aVar) throws IOException;
}
