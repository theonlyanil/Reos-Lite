package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes.dex */
public class e extends n implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f1096a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.a f1097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1098b;

        public a(Context context) {
            this(context, e.a(context, 0));
        }

        public a(Context context, int i) {
            this.f1097a = new d.a(new ContextThemeWrapper(context, e.a(context, i)));
            this.f1098b = i;
        }

        public Context a() {
            return this.f1097a.f1077a;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f1097a.r = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.f1097a.f1080d = drawable;
            return this;
        }

        public a a(View view) {
            this.f1097a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f1097a.t = listAdapter;
            this.f1097a.u = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f1097a.f1082f = charSequence;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1097a.i = charSequence;
            this.f1097a.j = onClickListener;
            return this;
        }

        public a a(boolean z) {
            this.f1097a.o = z;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f1097a.s = charSequenceArr;
            this.f1097a.u = onClickListener;
            return this;
        }

        public a b(View view) {
            this.f1097a.w = view;
            this.f1097a.v = 0;
            this.f1097a.B = false;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f1097a.h = charSequence;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1097a.k = charSequence;
            this.f1097a.l = onClickListener;
            return this;
        }

        public e b() {
            e eVar = new e(this.f1097a.f1077a, this.f1098b, false);
            this.f1097a.a(eVar.f1096a);
            eVar.setCancelable(this.f1097a.o);
            if (this.f1097a.o) {
                eVar.setCanceledOnTouchOutside(true);
            }
            eVar.setOnCancelListener(this.f1097a.p);
            eVar.setOnDismissListener(this.f1097a.q);
            if (this.f1097a.r != null) {
                eVar.setOnKeyListener(this.f1097a.r);
            }
            return eVar;
        }

        public e c() {
            e eVarB = b();
            eVarB.show();
            return eVarB;
        }
    }

    e(Context context, int i, boolean z) {
        super(context, a(context, i));
        this.f1096a = new d(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1096a.a(i, charSequence, onClickListener, (Message) null);
    }

    public void a(CharSequence charSequence) {
        this.f1096a.b(charSequence);
    }

    @Override // android.support.v7.a.n, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1096a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1096a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1096a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.support.v7.a.n, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1096a.a(charSequence);
    }
}
