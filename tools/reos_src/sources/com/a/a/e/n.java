package com.a.a.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class n extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.a.a.j f2387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.e.a f2388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f2389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<n> f2390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private n f2391e;

    private class a implements l {
        private a() {
        }
    }

    public n() {
        this(new com.a.a.e.a());
    }

    @SuppressLint({"ValidFragment"})
    public n(com.a.a.e.a aVar) {
        this.f2389c = new a();
        this.f2390d = new HashSet<>();
        this.f2388b = aVar;
    }

    private void a(n nVar) {
        this.f2390d.add(nVar);
    }

    private void b(n nVar) {
        this.f2390d.remove(nVar);
    }

    com.a.a.e.a a() {
        return this.f2388b;
    }

    public void a(com.a.a.j jVar) {
        this.f2387a = jVar;
    }

    public com.a.a.j b() {
        return this.f2387a;
    }

    public l c() {
        return this.f2389c;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2391e = k.a().a(getActivity().getSupportFragmentManager());
        if (this.f2391e != this) {
            this.f2391e.a(this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2388b.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f2391e != null) {
            this.f2391e.b(this);
            this.f2391e = null;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.f2387a != null) {
            this.f2387a.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f2388b.a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f2388b.b();
    }
}
