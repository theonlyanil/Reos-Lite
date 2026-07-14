package com.facebook.b;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.plus.PlusShare;

/* JADX INFO: loaded from: classes.dex */
public class k extends android.support.v4.app.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f3740a;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        android.support.v4.app.p activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, com.facebook.k kVar) {
        android.support.v4.app.p activity = getActivity();
        activity.setResult(kVar == null ? -1 : 0, y.a(activity.getIntent(), bundle, kVar));
        activity.finish();
    }

    public void a(Dialog dialog) {
        this.f3740a = dialog;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.f3740a instanceof af) && isResumed()) {
            ((af) this.f3740a).d();
        }
    }

    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        af mVar;
        super.onCreate(bundle);
        if (this.f3740a == null) {
            android.support.v4.app.p activity = getActivity();
            Bundle bundleD = y.d(activity.getIntent());
            if (bundleD.getBoolean("is_fallback", false)) {
                String string = bundleD.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (ad.a(string)) {
                    ad.a("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                } else {
                    mVar = new m(activity, string, String.format("fb%s://bridge/", com.facebook.m.i()));
                    mVar.a(new af.c() { // from class: com.facebook.b.k.2
                        @Override // com.facebook.b.af.c
                        public void a(Bundle bundle2, com.facebook.k kVar) {
                            k.this.a(bundle2);
                        }
                    });
                }
            } else {
                String string2 = bundleD.getString("action");
                Bundle bundle2 = bundleD.getBundle("params");
                if (ad.a(string2)) {
                    ad.a("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                mVar = new af.a(activity, string2, bundle2).a(new af.c() { // from class: com.facebook.b.k.1
                    @Override // com.facebook.b.af.c
                    public void a(Bundle bundle3, com.facebook.k kVar) {
                        k.this.a(bundle3, kVar);
                    }
                }).a();
            }
            this.f3740a = mVar;
        }
    }

    @Override // android.support.v4.app.o
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f3740a == null) {
            a((Bundle) null, (com.facebook.k) null);
            setShowsDialog(false);
        }
        return this.f3740a;
    }

    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3740a instanceof af) {
            ((af) this.f3740a).d();
        }
    }
}
