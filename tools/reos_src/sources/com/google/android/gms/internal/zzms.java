package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzms<R extends Result> extends zze<R> implements ResultCallback<R> {
    private final Object zzafd;
    private zzb<? super R, ? extends Result> zzahj;
    private zzms<? extends Result> zzahk;
    private ResultCallbacks<? super R> zzahl;
    private PendingResult<R> zzahm;

    private void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e2) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e2);
            }
        }
    }

    private void zzpD() {
        if (this.zzahm != null) {
            if (this.zzahj == null && this.zzahl == null) {
                return;
            }
            this.zzahm.setResultCallback(this);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(R r) {
        synchronized (this.zzafd) {
            if (!r.getStatus().isSuccess()) {
                zzz(r.getStatus());
                zzd(r);
            } else if (this.zzahj != null) {
                PendingResult<S> pendingResultZza = this.zzahj.zza(r);
                if (pendingResultZza == 0) {
                    zzz(new Status(13, "Transform returned null"));
                } else {
                    this.zzahk.zza(pendingResultZza);
                }
                zzd(r);
            } else if (this.zzahl != null) {
                this.zzahl.onSuccess(r);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzafd) {
            this.zzahm = pendingResult;
            zzpD();
        }
    }

    public void zzz(Status status) {
        synchronized (this.zzafd) {
            if (this.zzahj != null) {
                Status statusZzw = this.zzahj.zzw(status);
                zzx.zzb(statusZzw, "onFailure must not return null");
                this.zzahk.zzz(statusZzw);
            } else if (this.zzahl != null) {
                this.zzahl.onFailure(status);
            }
        }
    }
}
