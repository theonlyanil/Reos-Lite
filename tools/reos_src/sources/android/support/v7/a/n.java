package android.support.v7.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class n extends Dialog implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1134a;

    public n(Context context, int i) {
        super(context, a(context, i));
        a().a((Bundle) null);
        a().i();
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public h a() {
        if (this.f1134a == null) {
            this.f1134a = h.a(this, this);
        }
        return this.f1134a;
    }

    @Override // android.support.v7.a.g
    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        return null;
    }

    @Override // android.support.v7.a.g
    public void a(android.support.v7.view.b bVar) {
    }

    public boolean a(int i) {
        return a().c(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.support.v7.a.g
    public void b(android.support.v7.view.b bVar) {
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return a().a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().e();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().c();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().b(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}
