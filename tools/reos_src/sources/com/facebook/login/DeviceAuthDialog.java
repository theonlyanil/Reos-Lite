package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.o;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.aa;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.k;
import com.facebook.m;
import com.facebook.p;
import com.facebook.r;
import com.facebook.s;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceAuthDialog extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f3870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DeviceAuthMethodHandler f3872c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile p f3874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile ScheduledFuture f3875f;
    private volatile RequestState g;
    private Dialog h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f3873d = new AtomicBoolean();
    private boolean i = false;

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.login.DeviceAuthDialog.RequestState.1
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
        private String f3882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f3884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f3885d;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.f3882a = parcel.readString();
            this.f3883b = parcel.readString();
            this.f3884c = parcel.readLong();
            this.f3885d = parcel.readLong();
        }

        public String a() {
            return this.f3882a;
        }

        public void a(long j) {
            this.f3884c = j;
        }

        public void a(String str) {
            this.f3882a = str;
        }

        public String b() {
            return this.f3883b;
        }

        public void b(long j) {
            this.f3885d = j;
        }

        public void b(String str) {
            this.f3883b = str;
        }

        public long c() {
            return this.f3884c;
        }

        public boolean d() {
            return this.f3885d != 0 && (new Date().getTime() - this.f3885d) - (this.f3884c * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3882a);
            parcel.writeString(this.f3883b);
            parcel.writeLong(this.f3884c);
            parcel.writeLong(this.f3885d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.g.b(new Date().getTime());
        this.f3874e = c().j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        if (this.f3873d.compareAndSet(false, true)) {
            this.f3872c.a(kVar);
            this.h.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RequestState requestState) {
        this.g = requestState;
        this.f3871b.setText(requestState.a());
        this.f3871b.setVisibility(0);
        this.f3870a.setVisibility(8);
        if (requestState.d()) {
            b();
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions");
        new GraphRequest(new AccessToken(str, m.i(), "0", null, null, null, null, null), "me", bundle, s.GET, new GraphRequest.b() { // from class: com.facebook.login.DeviceAuthDialog.5
            @Override // com.facebook.GraphRequest.b
            public void a(r rVar) {
                if (DeviceAuthDialog.this.f3873d.get()) {
                    return;
                }
                if (rVar.a() != null) {
                    DeviceAuthDialog.this.a(rVar.a().f());
                    return;
                }
                try {
                    JSONObject jSONObjectB = rVar.b();
                    String string = jSONObjectB.getString("id");
                    ad.e eVarA = ad.a(jSONObjectB);
                    DeviceAuthDialog.this.f3872c.a(str, m.i(), string, eVarA.a(), eVarA.b(), com.facebook.c.DEVICE_AUTH, null, null);
                    DeviceAuthDialog.this.h.dismiss();
                } catch (JSONException e2) {
                    DeviceAuthDialog.this.a(new k(e2));
                }
            }
        }).j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f3875f = DeviceAuthMethodHandler.c().schedule(new Runnable() { // from class: com.facebook.login.DeviceAuthDialog.3
            @Override // java.lang.Runnable
            public void run() {
                DeviceAuthDialog.this.a();
            }
        }, this.g.c(), TimeUnit.SECONDS);
    }

    private GraphRequest c() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.g.b());
        return new GraphRequest(null, "device/login_status", bundle, s.POST, new GraphRequest.b() { // from class: com.facebook.login.DeviceAuthDialog.4
            @Override // com.facebook.GraphRequest.b
            public void a(r rVar) {
                if (DeviceAuthDialog.this.f3873d.get()) {
                }
                FacebookRequestError facebookRequestErrorA = rVar.a();
                if (facebookRequestErrorA == null) {
                    try {
                        DeviceAuthDialog.this.a(rVar.b().getString("access_token"));
                        return;
                    } catch (JSONException e2) {
                        DeviceAuthDialog.this.a(new k(e2));
                        return;
                    }
                }
                switch (facebookRequestErrorA.c()) {
                    case 1349152:
                    case 1349173:
                        DeviceAuthDialog.this.d();
                        break;
                    case 1349172:
                    case 1349174:
                        DeviceAuthDialog.this.b();
                        break;
                    default:
                        DeviceAuthDialog.this.a(rVar.a().f());
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f3873d.compareAndSet(false, true)) {
            if (this.f3872c != null) {
                this.f3872c.e_();
            }
            this.h.dismiss();
        }
    }

    public void a(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.a()));
        String strG = request.g();
        if (strG != null) {
            bundle.putString("redirect_uri", strG);
        }
        bundle.putString("access_token", ae.b() + "|" + ae.c());
        new GraphRequest(null, "device/login", bundle, s.POST, new GraphRequest.b() { // from class: com.facebook.login.DeviceAuthDialog.2
            @Override // com.facebook.GraphRequest.b
            public void a(r rVar) {
                if (rVar.a() != null) {
                    DeviceAuthDialog.this.a(rVar.a().f());
                    return;
                }
                JSONObject jSONObjectB = rVar.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jSONObjectB.getString("user_code"));
                    requestState.b(jSONObjectB.getString("code"));
                    requestState.a(jSONObjectB.getLong("interval"));
                    DeviceAuthDialog.this.a(requestState);
                } catch (JSONException e2) {
                    DeviceAuthDialog.this.a(new k(e2));
                }
            }
        }).j();
    }

    @Override // android.support.v4.app.o
    public Dialog onCreateDialog(Bundle bundle) {
        this.h = new Dialog(getActivity(), aa.g.com_facebook_auth_dialog);
        View viewInflate = getActivity().getLayoutInflater().inflate(aa.e.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.f3870a = (ProgressBar) viewInflate.findViewById(aa.d.progress_bar);
        this.f3871b = (TextView) viewInflate.findViewById(aa.d.confirmation_code);
        ((Button) viewInflate.findViewById(aa.d.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceAuthDialog.this.d();
            }
        });
        ((TextView) viewInflate.findViewById(aa.d.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(aa.f.com_facebook_device_auth_instructions)));
        this.h.setContentView(viewInflate);
        return this.h;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f3872c = (DeviceAuthMethodHandler) ((e) ((FacebookActivity) getActivity()).a()).a().g();
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            a(requestState);
        }
        return viewOnCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.i = true;
        this.f3873d.set(true);
        super.onDestroy();
        if (this.f3874e != null) {
            this.f3874e.cancel(true);
        }
        if (this.f3875f != null) {
            this.f3875f.cancel(true);
        }
    }

    @Override // android.support.v4.app.o, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.i) {
            return;
        }
        d();
    }

    @Override // android.support.v4.app.o, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.g != null) {
            bundle.putParcelable("request_state", this.g);
        }
    }
}
