package android.support.v7.widget;

/* JADX INFO: loaded from: classes.dex */
class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1706a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1707b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1708c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1709d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1710e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1711f = 0;
    private boolean g = false;
    private boolean h = false;

    af() {
    }

    public int a() {
        return this.f1706a;
    }

    public void a(int i, int i2) {
        this.f1708c = i;
        this.f1709d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1706a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1707b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1706a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1707b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f1706a = this.f1710e;
            this.f1707b = this.f1711f;
        } else if (z) {
            this.f1706a = this.f1709d != Integer.MIN_VALUE ? this.f1709d : this.f1710e;
            this.f1707b = this.f1708c != Integer.MIN_VALUE ? this.f1708c : this.f1711f;
        } else {
            this.f1706a = this.f1708c != Integer.MIN_VALUE ? this.f1708c : this.f1710e;
            this.f1707b = this.f1709d != Integer.MIN_VALUE ? this.f1709d : this.f1711f;
        }
    }

    public int b() {
        return this.f1707b;
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1710e = i;
            this.f1706a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1711f = i2;
            this.f1707b = i2;
        }
    }

    public int c() {
        return this.g ? this.f1707b : this.f1706a;
    }

    public int d() {
        return this.g ? this.f1706a : this.f1707b;
    }
}
