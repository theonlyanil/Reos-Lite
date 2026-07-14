package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s<?> f667a;

    private r(s<?> sVar) {
        this.f667a = sVar;
    }

    public static final r a(s<?> sVar) {
        return new r(sVar);
    }

    Fragment a(String str) {
        return this.f667a.f671d.b(str);
    }

    public t a() {
        return this.f667a.k();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f667a.f671d.a(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.f667a.f671d.a(configuration);
    }

    public void a(Parcelable parcelable, List<Fragment> list) {
        this.f667a.f671d.a(parcelable, list);
    }

    public void a(Fragment fragment) {
        this.f667a.f671d.a(this.f667a, this.f667a, fragment);
    }

    public void a(android.support.v4.h.i<String, z> iVar) {
        this.f667a.a(iVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f667a.b(str, fileDescriptor, printWriter, strArr);
    }

    public void a(boolean z) {
        this.f667a.a(z);
    }

    public boolean a(Menu menu) {
        return this.f667a.f671d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f667a.f671d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f667a.f671d.a(menuItem);
    }

    public z b() {
        return this.f667a.l();
    }

    public void b(Menu menu) {
        this.f667a.f671d.b(menu);
    }

    public boolean b(MenuItem menuItem) {
        return this.f667a.f671d.b(menuItem);
    }

    public void c() {
        this.f667a.f671d.k();
    }

    public Parcelable d() {
        return this.f667a.f671d.j();
    }

    public List<Fragment> e() {
        return this.f667a.f671d.i();
    }

    public void f() {
        this.f667a.f671d.l();
    }

    public void g() {
        this.f667a.f671d.m();
    }

    public void h() {
        this.f667a.f671d.n();
    }

    public void i() {
        this.f667a.f671d.o();
    }

    public void j() {
        this.f667a.f671d.p();
    }

    public void k() {
        this.f667a.f671d.q();
    }

    public void l() {
        this.f667a.f671d.r();
    }

    public void m() {
        this.f667a.f671d.t();
    }

    public void n() {
        this.f667a.f671d.u();
    }

    public boolean o() {
        return this.f667a.f671d.g();
    }

    public void p() {
        this.f667a.n();
    }

    public void q() {
        this.f667a.o();
    }

    public void r() {
        this.f667a.p();
    }

    public android.support.v4.h.i<String, z> s() {
        return this.f667a.q();
    }
}
