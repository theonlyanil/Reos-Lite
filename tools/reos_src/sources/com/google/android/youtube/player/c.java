package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.youtube.player.a.aa;
import com.google.android.youtube.player.a.ab;
import com.google.android.youtube.player.a.p;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    private static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f5361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Intent f5362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5363c;

        public a(Activity activity, Intent intent, int i) {
            this.f5361a = (Activity) com.google.android.youtube.player.a.c.a(activity);
            this.f5362b = (Intent) com.google.android.youtube.player.a.c.a(intent);
            this.f5363c = ((Integer) com.google.android.youtube.player.a.c.a(Integer.valueOf(i))).intValue();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f5361a.startActivityForResult(this.f5362b, this.f5363c);
                dialogInterface.dismiss();
            } catch (ActivityNotFoundException e2) {
                aa.a("Can't perform resolution for YouTubeInitalizationError", e2);
            }
        }
    }

    public final Dialog a(Activity activity, int i) {
        return a(activity, i, null);
    }

    public final Dialog a(Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        Intent intentA;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                intentA = ab.b(ab.a(activity));
                break;
            case SERVICE_DISABLED:
                intentA = ab.a(ab.a(activity));
                break;
            default:
                intentA = null;
                break;
        }
        a aVar = new a(activity, intentA, i);
        p pVar = new p(activity);
        switch (this) {
            case SERVICE_MISSING:
                return builder.setTitle(pVar.f5319b).setMessage(pVar.f5320c).setPositiveButton(pVar.f5321d, aVar).create();
            case SERVICE_DISABLED:
                return builder.setTitle(pVar.f5322e).setMessage(pVar.f5323f).setPositiveButton(pVar.g, aVar).create();
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return builder.setTitle(pVar.h).setMessage(pVar.i).setPositiveButton(pVar.j, aVar).create();
            default:
                String strValueOf = String.valueOf(name());
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unexpected errorReason: ".concat(strValueOf) : new String("Unexpected errorReason: "));
        }
    }

    public final boolean a() {
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_DISABLED:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return true;
            default:
                return false;
        }
    }
}
