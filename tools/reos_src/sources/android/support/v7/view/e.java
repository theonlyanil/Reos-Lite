package android.support.v7.view;

import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements android.support.v7.view.menu.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionBarContextView f1196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.a f1197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<View> f1198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1200f;
    private android.support.v7.view.menu.f g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f1195a = context;
        this.f1196b = actionBarContextView;
        this.f1197c = aVar;
        this.g = new android.support.v7.view.menu.f(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f1200f = z;
    }

    @Override // android.support.v7.view.b
    public MenuInflater a() {
        return new g(this.f1196b.getContext());
    }

    @Override // android.support.v7.view.b
    public void a(int i) {
        b(this.f1195a.getString(i));
    }

    @Override // android.support.v7.view.menu.f.a
    public void a(android.support.v7.view.menu.f fVar) {
        d();
        this.f1196b.a();
    }

    @Override // android.support.v7.view.b
    public void a(View view) {
        this.f1196b.setCustomView(view);
        this.f1198d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.b
    public void a(CharSequence charSequence) {
        this.f1196b.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public void a(boolean z) {
        super.a(z);
        this.f1196b.setTitleOptional(z);
    }

    @Override // android.support.v7.view.menu.f.a
    public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
        return this.f1197c.a(this, menuItem);
    }

    @Override // android.support.v7.view.b
    public Menu b() {
        return this.g;
    }

    @Override // android.support.v7.view.b
    public void b(int i) {
        a((CharSequence) this.f1195a.getString(i));
    }

    @Override // android.support.v7.view.b
    public void b(CharSequence charSequence) {
        this.f1196b.setTitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public void c() {
        if (this.f1199e) {
            return;
        }
        this.f1199e = true;
        this.f1196b.sendAccessibilityEvent(32);
        this.f1197c.a(this);
    }

    @Override // android.support.v7.view.b
    public void d() {
        this.f1197c.b(this, this.g);
    }

    @Override // android.support.v7.view.b
    public CharSequence f() {
        return this.f1196b.getTitle();
    }

    @Override // android.support.v7.view.b
    public CharSequence g() {
        return this.f1196b.getSubtitle();
    }

    @Override // android.support.v7.view.b
    public boolean h() {
        return this.f1196b.d();
    }

    @Override // android.support.v7.view.b
    public View i() {
        if (this.f1198d != null) {
            return this.f1198d.get();
        }
        return null;
    }
}
