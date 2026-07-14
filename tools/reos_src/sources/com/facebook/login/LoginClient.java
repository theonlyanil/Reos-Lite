package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.p;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.aa;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.LoginClient.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LoginMethodHandler[] f3893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Fragment f3895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f3896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f3897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f3898f;
    Request g;
    Map<String, String> h;
    private f i;

    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.LoginClient.Request.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request[] newArray(int i) {
                return new Request[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f3899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f3900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.facebook.login.a f3901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f3902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f3903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f3904f;
        private String g;

        private Request(Parcel parcel) {
            this.f3904f = false;
            String string = parcel.readString();
            this.f3899a = string != null ? d.valueOf(string) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f3900b = new HashSet(arrayList);
            String string2 = parcel.readString();
            this.f3901c = string2 != null ? com.facebook.login.a.valueOf(string2) : null;
            this.f3902d = parcel.readString();
            this.f3903e = parcel.readString();
            this.f3904f = parcel.readByte() != 0;
            this.g = parcel.readString();
        }

        Request(d dVar, Set<String> set, com.facebook.login.a aVar, String str, String str2) {
            this.f3904f = false;
            this.f3899a = dVar;
            this.f3900b = set == null ? new HashSet<>() : set;
            this.f3901c = aVar;
            this.f3902d = str;
            this.f3903e = str2;
        }

        Set<String> a() {
            return this.f3900b;
        }

        void a(String str) {
            this.g = str;
        }

        void a(Set<String> set) {
            ae.a((Object) set, "permissions");
            this.f3900b = set;
        }

        void a(boolean z) {
            this.f3904f = z;
        }

        d b() {
            return this.f3899a;
        }

        com.facebook.login.a c() {
            return this.f3901c;
        }

        String d() {
            return this.f3902d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        String e() {
            return this.f3903e;
        }

        boolean f() {
            return this.f3904f;
        }

        String g() {
            return this.g;
        }

        boolean h() {
            Iterator<String> it = this.f3900b.iterator();
            while (it.hasNext()) {
                if (g.a(it.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3899a != null ? this.f3899a.name() : null);
            parcel.writeStringList(new ArrayList(this.f3900b));
            parcel.writeString(this.f3901c != null ? this.f3901c.name() : null);
            parcel.writeString(this.f3902d);
            parcel.writeString(this.f3903e);
            parcel.writeByte((byte) (this.f3904f ? 1 : 0));
            parcel.writeString(this.g);
        }
    }

    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.LoginClient.Result.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Result[] newArray(int i) {
                return new Result[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f3905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AccessToken f3906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f3907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final String f3908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Request f3909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f3910f;

        enum a {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");


            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f3915d;

            a(String str) {
                this.f3915d = str;
            }

            String a() {
                return this.f3915d;
            }
        }

        private Result(Parcel parcel) {
            this.f3905a = a.valueOf(parcel.readString());
            this.f3906b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f3907c = parcel.readString();
            this.f3908d = parcel.readString();
            this.f3909e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f3910f = ad.a(parcel);
        }

        Result(Request request, a aVar, AccessToken accessToken, String str, String str2) {
            ae.a(aVar, "code");
            this.f3909e = request;
            this.f3906b = accessToken;
            this.f3907c = str;
            this.f3905a = aVar;
            this.f3908d = str2;
        }

        static Result a(Request request, AccessToken accessToken) {
            return new Result(request, a.SUCCESS, accessToken, null, null);
        }

        static Result a(Request request, String str) {
            return new Result(request, a.CANCEL, null, str, null);
        }

        static Result a(Request request, String str, String str2) {
            return a(request, str, str2, null);
        }

        static Result a(Request request, String str, String str2, String str3) {
            return new Result(request, a.ERROR, null, TextUtils.join(": ", ad.b(str, str2)), str3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3905a.name());
            parcel.writeParcelable(this.f3906b, i);
            parcel.writeString(this.f3907c);
            parcel.writeString(this.f3908d);
            parcel.writeParcelable(this.f3909e, i);
            ad.a(parcel, this.f3910f);
        }
    }

    interface a {
        void a();

        void b();
    }

    public interface b {
        void a(Result result);
    }

    public LoginClient(Parcel parcel) {
        this.f3894b = -1;
        Parcelable[] parcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f3893a = new LoginMethodHandler[parcelableArray.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= parcelableArray.length) {
                this.f3894b = parcel.readInt();
                this.g = (Request) parcel.readParcelable(Request.class.getClassLoader());
                this.h = ad.a(parcel);
                return;
            } else {
                this.f3893a[i2] = (LoginMethodHandler) parcelableArray[i2];
                this.f3893a[i2].a(this);
                i = i2 + 1;
            }
        }
    }

    public LoginClient(Fragment fragment) {
        this.f3894b = -1;
        this.f3895c = fragment;
    }

    private void a(String str, Result result, Map<String, String> map) {
        a(str, result.f3905a.a(), result.f3907c, result.f3908d, map);
    }

    private void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.g == null) {
            o().a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            o().a(this.g.e(), str, str2, str3, str4, map);
        }
    }

    private void a(String str, String str2, boolean z) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey(str) && z) {
            str2 = this.h.get(str) + "," + str2;
        }
        this.h.put(str, str2);
    }

    private LoginMethodHandler[] c(Request request) {
        ArrayList arrayList = new ArrayList();
        d dVarB = request.b();
        if (dVarB.a()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (dVarB.b()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (dVarB.f()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (dVarB.e()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (dVarB.c()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (dVarB.d()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    public static int d() {
        return com.facebook.b.f.b.Login.a();
    }

    private void d(Result result) {
        if (this.f3896d != null) {
            this.f3896d.a(result);
        }
    }

    static String m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }

    private void n() {
        b(Result.a(this.g, "Login attempt failed.", null));
    }

    private f o() {
        if (this.i == null || !this.i.a().equals(this.g.d())) {
            this.i = new f(b(), this.g.d());
        }
        return this.i;
    }

    int a(String str) {
        return b().checkCallingOrSelfPermission(str);
    }

    public Fragment a() {
        return this.f3895c;
    }

    void a(Fragment fragment) {
        if (this.f3895c != null) {
            throw new k("Can't set fragment once it is already set.");
        }
        this.f3895c = fragment;
    }

    void a(Request request) {
        if (e()) {
            return;
        }
        b(request);
    }

    void a(Result result) {
        if (result.f3906b == null || AccessToken.a() == null) {
            b(result);
        } else {
            c(result);
        }
    }

    void a(a aVar) {
        this.f3897e = aVar;
    }

    void a(b bVar) {
        this.f3896d = bVar;
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.g != null) {
            return g().a(i, i2, intent);
        }
        return false;
    }

    p b() {
        return this.f3895c.getActivity();
    }

    void b(Request request) {
        if (request == null) {
            return;
        }
        if (this.g != null) {
            throw new k("Attempted to authorize while a request is pending.");
        }
        if (AccessToken.a() == null || h()) {
            this.g = request;
            this.f3893a = c(request);
            i();
        }
    }

    void b(Result result) {
        LoginMethodHandler loginMethodHandlerG = g();
        if (loginMethodHandlerG != null) {
            a(loginMethodHandlerG.a(), result, loginMethodHandlerG.f3916a);
        }
        if (this.h != null) {
            result.f3910f = this.h;
        }
        this.f3893a = null;
        this.f3894b = -1;
        this.g = null;
        this.h = null;
        d(result);
    }

    public Request c() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030 A[Catch: Exception -> 0x003a, TRY_LEAVE, TryCatch #0 {Exception -> 0x003a, blocks: (B:9:0x0016, B:11:0x0024, B:12:0x002c, B:14:0x0030), top: B:18:0x0016 }] */
    void c(Result result) {
        Result resultA;
        if (result.f3906b == null) {
            throw new k("Can't validate without a token");
        }
        AccessToken accessTokenA = AccessToken.a();
        AccessToken accessToken = result.f3906b;
        if (accessTokenA == null || accessToken == null) {
            resultA = Result.a(this.g, "User logged in as different Facebook user.", null);
        } else {
            try {
                if (accessTokenA.i().equals(accessToken.i())) {
                    resultA = Result.a(this.g, result.f3906b);
                } else {
                    resultA = Result.a(this.g, "User logged in as different Facebook user.", null);
                }
            } catch (Exception e2) {
                b(Result.a(this.g, "Caught exception", e2.getMessage()));
                return;
            }
        }
        b(resultA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    boolean e() {
        return this.g != null && this.f3894b >= 0;
    }

    void f() {
        if (this.f3894b >= 0) {
            g().b();
        }
    }

    LoginMethodHandler g() {
        if (this.f3894b >= 0) {
            return this.f3893a[this.f3894b];
        }
        return null;
    }

    boolean h() {
        if (this.f3898f) {
            return true;
        }
        if (a("android.permission.INTERNET") == 0) {
            this.f3898f = true;
            return true;
        }
        p pVarB = b();
        b(Result.a(this.g, pVarB.getString(aa.f.com_facebook_internet_permission_error_title), pVarB.getString(aa.f.com_facebook_internet_permission_error_message)));
        return false;
    }

    void i() {
        if (this.f3894b >= 0) {
            a(g().a(), "skipped", null, null, g().f3916a);
        }
        while (this.f3893a != null && this.f3894b < this.f3893a.length - 1) {
            this.f3894b++;
            if (j()) {
                return;
            }
        }
        if (this.g != null) {
            n();
        }
    }

    boolean j() {
        boolean zA = false;
        LoginMethodHandler loginMethodHandlerG = g();
        if (!loginMethodHandlerG.d() || h()) {
            zA = loginMethodHandlerG.a(this.g);
            if (zA) {
                o().a(this.g.e(), loginMethodHandlerG.a());
            } else {
                o().b(this.g.e(), loginMethodHandlerG.a());
                a("not_tried", loginMethodHandlerG.a(), true);
            }
        } else {
            a("no_internet_permission", "1", false);
        }
        return zA;
    }

    void k() {
        if (this.f3897e != null) {
            this.f3897e.a();
        }
    }

    void l() {
        if (this.f3897e != null) {
            this.f3897e.b();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f3893a, i);
        parcel.writeInt(this.f3894b);
        parcel.writeParcelable(this.g, i);
        ad.a(parcel, this.h);
    }
}
