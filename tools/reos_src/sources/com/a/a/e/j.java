package com.a.a.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class j extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.e.a f2373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f2374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.j f2375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<j> f2376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f2377e;

    private class a implements l {
        private a() {
        }
    }

    public j() {
        this(new com.a.a.e.a());
    }

    @SuppressLint({"ValidFragment"})
    j(com.a.a.e.a aVar) {
        this.f2374b = new a();
        this.f2376d = new HashSet<>();
        this.f2373a = aVar;
    }

    private void a(j jVar) {
        this.f2376d.add(jVar);
    }

    private void b(j jVar) {
        this.f2376d.remove(jVar);
    }

    com.a.a.e.a a() {
        return this.f2373a;
    }

    public void a(com.a.a.j jVar) {
        this.f2375c = jVar;
    }

    public com.a.a.j b() {
        return this.f2375c;
    }

    public l c() {
        return this.f2374b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2377e = k.a().a(getActivity().getFragmentManager());
        if (this.f2377e != this) {
            this.f2377e.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2373a.c();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f2377e != null) {
            this.f2377e.b(this);
            this.f2377e = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.f2375c != null) {
            this.f2375c.a();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f2373a.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f2373a.b();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.f2375c != null) {
            this.f2375c.a(i);
        }
    }
}
