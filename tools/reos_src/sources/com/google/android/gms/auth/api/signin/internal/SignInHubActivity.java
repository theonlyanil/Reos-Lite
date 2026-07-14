package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.p;
import android.support.v4.app.z;
import android.support.v4.b.i;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.android.apps.config.Config;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class SignInHubActivity extends p {
    private zzn zzWm;
    private zzj zzWn;
    private SignInConfiguration zzWo;
    private boolean zzWp;
    private String zzWq;
    private boolean zzWr;
    private int zzWs;
    private Intent zzWt;

    private class zza implements z.a<Void> {
        private zza() {
        }

        @Override // android.support.v4.app.z.a
        public i<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.zzoE());
        }

        @Override // android.support.v4.app.z.a
        public void onLoaderReset(i<Void> iVar) {
        }

        @Override // android.support.v4.app.z.a
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(i<Void> iVar, Void r5) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzWs, SignInHubActivity.this.zzWt);
            SignInHubActivity.this.finish();
        }
    }

    private void zza(int i, int i2, Intent intent) {
        Iterator<zzld> it = this.zzWn.zzmO().iterator();
        while (it.hasNext() && !it.next().zza(i, i2, intent, zzmU())) {
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.zzmD() != null) {
                GoogleSignInAccount googleSignInAccountZzmD = signInAccount.zzmD();
                this.zzWm.zzb(googleSignInAccountZzmD, this.zzWo.zzmR());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountZzmD);
                this.zzWr = true;
                this.zzWs = i;
                this.zzWt = intent;
                zzd(i, intent);
                return;
            }
            if (intent.hasExtra("errorCode")) {
                zzaS(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzaS(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzaR(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void zzaS(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzb(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount == null) {
                Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
                zzaR(2);
                return;
            } else {
                this.zzWm.zzb(signInAccount, this.zzWo);
                setResult(-1, intent);
                finish();
                return;
            }
        }
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(Scopes.EMAIL);
        com.google.android.gms.auth.api.signin.zze zzeVarZzbI = com.google.android.gms.auth.api.signin.zze.zzbI(intent.getStringExtra("idProvider"));
        if (zzeVarZzbI == null) {
            setResult(i, intent);
            finish();
            return;
        }
        this.zzWq = intent.getStringExtra("pendingToken");
        Intent intentZzmt = this.zzWo.zzmS().zzmt();
        if (com.google.android.gms.auth.api.signin.zze.FACEBOOK.equals(zzeVarZzbI) && this.zzWo.zzmS() != null && intentZzmt != null) {
            startActivityForResult(intentZzmt, 45057);
            return;
        }
        zzld zzldVarZza = this.zzWn.zza(zzeVarZzbI);
        if (zzldVarZza == null) {
            Log.w("AuthSignInClient", ((Object) zzeVarZzbI.zzad(this)) + " is not supported. Please check your configuration");
            zzaR(1);
            return;
        }
        int intExtra = intent.getIntExtra("userProfile", -1);
        if (intExtra == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                zzldVarZza.zza(zzmU());
                return;
            } else {
                zzldVarZza.zza(stringExtra, zzmU());
                return;
            }
        }
        if (intExtra == 1 && !TextUtils.isEmpty(this.zzWq) && !TextUtils.isEmpty(stringExtra)) {
            zzldVarZza.zza(stringExtra, this.zzWq, zzmU());
        } else {
            Log.w("AuthSignInClient", "Internal error!");
            zzaR(2);
        }
    }

    private void zzc(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.zzWc);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.zzWq);
        intent2.putExtra("idProvider", com.google.android.gms.auth.api.signin.zze.FACEBOOK.zzmC());
        zzj(intent2);
    }

    private void zzd(int i, Intent intent) {
        getSupportLoaderManager().a(0, null, new zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra(Config.CONFIG, this.zzWo);
        try {
            startActivityForResult(intent, this.zzWp ? 40962 : 40961);
        } catch (ActivityNotFoundException e2) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.zzWp) {
                zzaS(8);
            } else {
                zzaR(2);
            }
        }
    }

    private zzld.zza zzmU() {
        return new zzld.zza() { // from class: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.1
            @Override // com.google.android.gms.internal.zzld.zza
            public void zza(Exception exc) {
                Log.w("AuthSignInClient", "Idp signin failed!" + ((exc == null || exc.getMessage() == null) ? "" : " " + exc.getMessage()));
                SignInHubActivity.this.zzaR(4);
            }

            @Override // com.google.android.gms.internal.zzld.zza
            public void zzk(Intent intent) {
                if (intent != null) {
                    SignInHubActivity.this.zzj(intent);
                } else {
                    Log.w("AuthSignInClient", "Idp signin failed!");
                    SignInHubActivity.this.zzaR(4);
                }
            }

            @Override // com.google.android.gms.internal.zzld.zza
            public void zzmV() {
                SignInHubActivity.this.setResult(0);
                SignInHubActivity.this.finish();
            }
        };
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        setResult(0);
        switch (i) {
            case 40961:
                zzb(i2, intent);
                break;
            case 40962:
                zza(i2, intent);
                break;
            case 45057:
                zzc(i2, intent);
                break;
            default:
                zza(i, i2, intent);
                break;
        }
    }

    @Override // android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        zzlf zzlfVar;
        Intent intent;
        boolean z = false;
        super.onCreate(bundle);
        this.zzWm = zzn.zzae(this);
        this.zzWo = (SignInConfiguration) getIntent().getParcelableExtra(Config.CONFIG);
        this.zzWp = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(getIntent().getAction());
        if (this.zzWo == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap map = new HashMap();
        zzh.zza(this.zzWo, linkedList, map);
        this.zzWn = new zzj(this, linkedList, map);
        if (this.zzWo.zzmS() != null) {
            zzlf zzlfVar2 = (zzlf) this.zzWn.zza(com.google.android.gms.auth.api.signin.zze.FACEBOOK);
            zzlfVar2.zzaf(this);
            if (this.zzWo.zzmQ() == null && this.zzWo.zzmR() == null) {
                z = true;
                zzlfVar = zzlfVar2;
            } else {
                zzlfVar = zzlfVar2;
            }
        } else {
            zzlfVar = null;
        }
        if (bundle != null) {
            this.zzWq = bundle.getString("pendingToken");
            this.zzWr = bundle.getBoolean("signingInGoogleApiClients");
            if (this.zzWr) {
                this.zzWs = bundle.getInt("signInResultCode");
                this.zzWt = (Intent) bundle.getParcelable("signInResultData");
                zzd(this.zzWs, this.zzWt);
                return;
            }
            return;
        }
        if (this.zzWp) {
            intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        } else {
            intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
            if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(getIntent().getAction())) {
                intent.fillIn(getIntent(), 3);
            } else {
                this.zzWm.zzmY();
                if (zzlfVar != null) {
                    try {
                        zzlf.zzag(this);
                    } catch (IllegalStateException e2) {
                    }
                }
            }
        }
        if (z) {
            zzlfVar.zza(zzmU());
        } else {
            zzj(intent);
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pendingToken", this.zzWq);
        bundle.putBoolean("signingInGoogleApiClients", this.zzWr);
        if (this.zzWr) {
            bundle.putInt("signInResultCode", this.zzWs);
            bundle.putParcelable("signInResultData", this.zzWt);
        }
    }
}
