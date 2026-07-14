package uk.co.deanwild.materialshowcaseview;

import android.app.Activity;
import android.view.View;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f f6626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Queue<MaterialShowcaseView> f6627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Activity f6628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f6630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6631f;

    public e(Activity activity) {
        this.f6629d = false;
        this.f6631f = 0;
        this.f6628c = activity;
        this.f6627b = new LinkedList();
    }

    public e(Activity activity, String str) {
        this(activity);
        a(str);
    }

    private void c() {
        if (this.f6627b.size() <= 0 || this.f6628c.isFinishing()) {
            if (this.f6629d) {
                this.f6626a.b();
            }
        } else {
            MaterialShowcaseView materialShowcaseViewRemove = this.f6627b.remove();
            materialShowcaseViewRemove.setDetachedListener(this);
            materialShowcaseViewRemove.a(this.f6628c);
        }
    }

    public e a(View view, String str, String str2) {
        MaterialShowcaseView materialShowcaseViewA = new MaterialShowcaseView.a(this.f6628c).a(view).a((CharSequence) str2).b(str).a();
        if (this.f6630e != null) {
            materialShowcaseViewA.setConfig(this.f6630e);
        }
        this.f6627b.add(materialShowcaseViewA);
        return this;
    }

    public e a(String str) {
        this.f6629d = true;
        this.f6626a = new f(this.f6628c, str);
        return this;
    }

    @Override // uk.co.deanwild.materialshowcaseview.c
    public void a(MaterialShowcaseView materialShowcaseView, boolean z) {
        materialShowcaseView.setDetachedListener(null);
        if (z) {
            if (this.f6626a != null) {
                this.f6631f++;
                this.f6626a.a(this.f6631f);
            }
            c();
        }
    }

    public void a(h hVar) {
        this.f6630e = hVar;
    }

    public boolean a() {
        return this.f6626a.c() == f.f6633b;
    }

    public void b() {
        if (this.f6629d) {
            if (a()) {
                return;
            }
            this.f6631f = this.f6626a.c();
            if (this.f6631f > 0) {
                for (int i = 0; i < this.f6631f; i++) {
                    this.f6627b.poll();
                }
            }
        }
        if (this.f6627b.size() > 0) {
            c();
        }
    }
}
