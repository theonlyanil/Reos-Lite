package android.support.v7.view;

import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f1224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private be f1225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1226e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1223b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final bf f1227f = new bf() { // from class: android.support.v7.view.h.1

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1229b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1230c = 0;

        void a() {
            this.f1230c = 0;
            this.f1229b = false;
            h.this.c();
        }

        @Override // android.support.v4.view.bf, android.support.v4.view.be
        public void a(View view) {
            if (this.f1229b) {
                return;
            }
            this.f1229b = true;
            if (h.this.f1225d != null) {
                h.this.f1225d.a(null);
            }
        }

        @Override // android.support.v4.view.bf, android.support.v4.view.be
        public void b(View view) {
            int i = this.f1230c + 1;
            this.f1230c = i;
            if (i == h.this.f1222a.size()) {
                if (h.this.f1225d != null) {
                    h.this.f1225d.b(null);
                }
                a();
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<ba> f1222a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f1226e = false;
    }

    public h a(long j) {
        if (!this.f1226e) {
            this.f1223b = j;
        }
        return this;
    }

    public h a(ba baVar) {
        if (!this.f1226e) {
            this.f1222a.add(baVar);
        }
        return this;
    }

    public h a(ba baVar, ba baVar2) {
        this.f1222a.add(baVar);
        baVar2.b(baVar.a());
        this.f1222a.add(baVar2);
        return this;
    }

    public h a(be beVar) {
        if (!this.f1226e) {
            this.f1225d = beVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f1226e) {
            this.f1224c = interpolator;
        }
        return this;
    }

    public void a() {
        if (this.f1226e) {
            return;
        }
        for (ba baVar : this.f1222a) {
            if (this.f1223b >= 0) {
                baVar.a(this.f1223b);
            }
            if (this.f1224c != null) {
                baVar.a(this.f1224c);
            }
            if (this.f1225d != null) {
                baVar.a(this.f1227f);
            }
            baVar.c();
        }
        this.f1226e = true;
    }

    public void b() {
        if (this.f1226e) {
            Iterator<ba> it = this.f1222a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f1226e = false;
        }
    }
}
