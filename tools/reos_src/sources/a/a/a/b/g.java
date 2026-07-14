package a.a.a.b;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f70a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f71b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f72c;

    public g() {
        this.f70a = -1.0f;
        this.f71b = -1.0f;
        this.f72c = false;
    }

    public g(g gVar) {
        this.f70a = gVar.f70a;
        this.f71b = gVar.f71b;
        this.f72c = gVar.f72c;
    }

    public float a() {
        return this.f70a;
    }

    public void a(float f2) {
        this.f70a = f2;
    }

    public void a(boolean z) {
        this.f72c = z;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g clone() {
        return new g(this);
    }

    public void b(float f2) {
        this.f71b = f2;
    }

    public float c() {
        return this.f71b;
    }
}
