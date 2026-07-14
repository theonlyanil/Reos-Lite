package a.a.a.b;

/* JADX INFO: loaded from: classes.dex */
public class i implements a.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f73a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f74b;

    public enum a {
        YIN,
        MPM,
        FFT_YIN,
        DYNAMIC_WAVELET,
        FFT_PITCH,
        AMDF;

        public h a(float f2, int i) {
            if (this == MPM) {
                return new e(f2, i);
            }
            if (this == DYNAMIC_WAVELET) {
                return new b(f2, i);
            }
            if (this == FFT_YIN) {
                return new d(f2, i);
            }
            if (this == AMDF) {
                return new a.a.a.b.a(f2, i);
            }
            return this == FFT_PITCH ? new c(Math.round(f2), i) : new j(f2, i);
        }
    }

    public i(a aVar, float f2, int i, f fVar) {
        this.f73a = aVar.a(f2, i);
        this.f74b = fVar;
    }

    @Override // a.a.a.c
    public void a() {
    }

    @Override // a.a.a.c
    public boolean a(a.a.a.b bVar) {
        this.f74b.a(this.f73a.a(bVar.a()), bVar);
        return true;
    }
}
