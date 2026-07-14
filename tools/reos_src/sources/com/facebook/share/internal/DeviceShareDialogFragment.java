package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.o;
import android.support.v4.app.p;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.aa;
import com.facebook.b.ae;
import com.facebook.r;
import com.facebook.s;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceShareDialogFragment extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f4043f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f4044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f4045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f4046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile RequestState f4047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile ScheduledFuture f4048e;
    private ShareContent g;

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.RequestState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4053b;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.f4052a = parcel.readString();
            this.f4053b = parcel.readLong();
        }

        public String a() {
            return this.f4052a;
        }

        public void a(long j) {
            this.f4053b = j;
        }

        public void a(String str) {
            this.f4052a = str;
        }

        public long b() {
            return this.f4053b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4052a);
            parcel.writeLong(this.f4053b);
        }
    }

    private void a() {
        if (isAdded()) {
            getFragmentManager().a().a(this).a();
        }
    }

    private void a(int i, Intent intent) {
        if (isAdded()) {
            p activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FacebookRequestError facebookRequestError) {
        a();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        a(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RequestState requestState) {
        this.f4047d = requestState;
        this.f4045b.setText(requestState.a());
        this.f4045b.setVisibility(0);
        this.f4044a.setVisibility(8);
        this.f4048e = d().schedule(new Runnable() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                DeviceShareDialogFragment.this.f4046c.dismiss();
            }
        }, requestState.b(), TimeUnit.SECONDS);
    }

    private Bundle b() {
        ShareContent shareContent = this.g;
        if (shareContent == null) {
            return null;
        }
        if (shareContent instanceof ShareLinkContent) {
            return k.a((ShareLinkContent) shareContent);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            return k.a((ShareOpenGraphContent) shareContent);
        }
        return null;
    }

    private void c() {
        Bundle bundleB = b();
        if (bundleB == null || bundleB.size() == 0) {
            a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        bundleB.putString("access_token", ae.b() + "|" + ae.c());
        new GraphRequest(null, "device/share", bundleB, s.POST, new GraphRequest.b() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.2
            @Override // com.facebook.GraphRequest.b
            public void a(r rVar) {
                FacebookRequestError facebookRequestErrorA = rVar.a();
                if (facebookRequestErrorA != null) {
                    DeviceShareDialogFragment.this.a(facebookRequestErrorA);
                    return;
                }
                JSONObject jSONObjectB = rVar.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jSONObjectB.getString("user_code"));
                    requestState.a(jSONObjectB.getLong("expires_in"));
                    DeviceShareDialogFragment.this.a(requestState);
                } catch (JSONException e2) {
                    DeviceShareDialogFragment.this.a(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).j();
    }

    private static synchronized ScheduledThreadPoolExecutor d() {
        if (f4043f == null) {
            f4043f = new ScheduledThreadPoolExecutor(1);
        }
        return f4043f;
    }

    public void a(ShareContent shareContent) {
        this.g = shareContent;
    }

    @Override // android.support.v4.app.o
    public Dialog onCreateDialog(Bundle bundle) {
        this.f4046c = new Dialog(getActivity(), aa.g.com_facebook_auth_dialog);
        View viewInflate = getActivity().getLayoutInflater().inflate(aa.e.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.f4044a = (ProgressBar) viewInflate.findViewById(aa.d.progress_bar);
        this.f4045b = (TextView) viewInflate.findViewById(aa.d.confirmation_code);
        ((Button) viewInflate.findViewById(aa.d.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceShareDialogFragment.this.f4046c.dismiss();
            }
        });
        ((TextView) viewInflate.findViewById(aa.d.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(aa.f.com_facebook_device_auth_instructions)));
        this.f4046c.setContentView(viewInflate);
        c();
        return this.f4046c;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            a(requestState);
        }
        return viewOnCreateView;
    }

    @Override // android.support.v4.app.o, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f4048e != null) {
            this.f4048e.cancel(true);
        }
        a(-1, new Intent());
    }

    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4047d != null) {
            bundle.putParcelable("request_state", this.f4047d);
        }
    }
}
