package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.DeviceAuthMethodHandler.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceAuthMethodHandler[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f3886c;

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private void b(LoginClient.Request request) {
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        deviceAuthDialog.show(this.f3917b.b().getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialog.a(request);
    }

    public static synchronized ScheduledThreadPoolExecutor c() {
        if (f3886c == null) {
            f3886c = new ScheduledThreadPoolExecutor(1);
        }
        return f3886c;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String a() {
        return "device_auth";
    }

    public void a(Exception exc) {
        this.f3917b.a(LoginClient.Result.a(this.f3917b.c(), null, exc.getMessage()));
    }

    public void a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, com.facebook.c cVar, Date date, Date date2) {
        this.f3917b.a(LoginClient.Result.a(this.f3917b.c(), new AccessToken(str, str2, str3, collection, collection2, cVar, date, date2)));
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(LoginClient.Request request) {
        b(request);
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e_() {
        this.f3917b.a(LoginClient.Result.a(this.f3917b.c(), "User canceled log in."));
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
