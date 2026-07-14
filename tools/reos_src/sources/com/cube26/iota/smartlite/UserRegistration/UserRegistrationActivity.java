package com.cube26.iota.smartlite.UserRegistration;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.a.f;
import android.support.v7.widget.AppCompatImageView;
import android.telephony.SmsMessage;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.VirtualLite.TryVirtualReosLiteActivity;
import com.cube26.iota.smartlite.onboarding.OnBoardingActivity;
import com.cube26.iota.smartlite.util.c;
import com.cube26.iota.smartlite.util.h;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.d;
import com.facebook.e;
import com.facebook.k;
import com.facebook.login.g;
import com.facebook.login.widget.LoginButton;
import com.facebook.r;
import com.facebook.x;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import f.l;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UserRegistrationActivity extends f implements HTTPLibrary.b, c.a, GoogleApiClient.OnConnectionFailedListener {
    private boolean A;
    private String B;
    private d C;
    private x D;
    private AccessToken E;
    private com.cube26.iota.smartlite.UserRegistration.a F;
    private Class G;
    private FrameLayout H;
    private FloatingActionButton I;
    private AppCompatImageView J;
    private RadioButton K;
    private RadioButton L;
    private com.cube26.iota.smartlite.UserRegistration.a M;
    private RelativeLayout N;
    private LinearLayout O;
    private EditText P;
    private android.support.b.a.f Q;
    private android.support.b.a.f R;
    private TextView S;
    private android.support.b.a.f T;
    private android.support.b.a.f U;
    private android.support.b.a.f V;
    private android.support.b.a.f W;
    private Button X;
    private RelativeLayout Y;
    private RelativeLayout Z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AppCompatImageView f3169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f3170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View f3171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f3172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IntentFilter f3173f;
    private String h;
    private String i;
    private a j;
    private EditText k;
    private EditText l;
    private EditText m;
    private TextView n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private Handler t;
    private Button u;
    private TextView v;
    private GoogleApiClient w;
    private LoginButton x;
    private e y;
    private GraphRequest z;
    private String g = "com.cube26.iota.smartlite";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3168a = false;

    /* JADX INFO: renamed from: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity$13, reason: invalid class name */
    class AnonymousClass13 extends d {
        AnonymousClass13() {
        }

        @Override // com.facebook.d
        protected void a(AccessToken accessToken, AccessToken accessToken2) {
            UserRegistrationActivity.this.E = accessToken2;
            if (UserRegistrationActivity.this.A) {
                return;
            }
            UserRegistrationActivity.this.z = GraphRequest.a(AccessToken.a(), new GraphRequest.c() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.13.1
                @Override // com.facebook.GraphRequest.c
                public void a(JSONObject jSONObject, r rVar) {
                    UserRegistrationActivity.this.M = new com.cube26.iota.smartlite.UserRegistration.a();
                    try {
                        UserRegistrationActivity.this.M.a(false);
                        UserRegistrationActivity.this.M.a(jSONObject.getString("name"));
                        UserRegistrationActivity.this.M.d(jSONObject.getString(Scopes.EMAIL));
                        UserRegistrationActivity.this.M.c(jSONObject.getString("age_range"));
                        UserRegistrationActivity.this.M.b(jSONObject.getString("gender"));
                        g.c().d();
                        UserRegistrationActivity.this.s = true;
                    } catch (NullPointerException e2) {
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    ((GradientDrawable) UserRegistrationActivity.this.X.getBackground()).setColor(Color.parseColor("#6496FF"));
                    UserRegistrationActivity.this.X.setTextColor(-1);
                    UserRegistrationActivity.this.X.setCompoundDrawablesWithIntrinsicBounds(UserRegistrationActivity.this.U, (Drawable) null, (Drawable) null, (Drawable) null);
                    UserRegistrationActivity.this.X.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.13.1.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            UserRegistrationActivity.this.o();
                            return true;
                        }
                    });
                    UserRegistrationActivity.this.a(UserRegistrationActivity.this.M);
                    CLog.a("IOTA", "object");
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,name,link,email,age_range,hometown,gender");
            UserRegistrationActivity.this.z.a(bundle);
            UserRegistrationActivity.this.z.j();
        }
    }

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3198b;

        public a(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            UserRegistrationActivity.this.t();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", UserRegistrationActivity.this.g);
                jSONObject.put("app_key", "edb45545e5c3fc59ad5a02be276d56a00260593c6596f84b8b132b1e3b0545ef");
                jSONObject.put("mobile_no", UserRegistrationActivity.this.h);
                jSONObject.put("otp", str);
                HTTPLibrary.post(UserRegistrationActivity.this, UserRegistrationActivity.this, 3, h.a.f3473a, h.a.f3475c, jSONObject, h.b(UserRegistrationActivity.this, "Verifying OTP"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_id", UserRegistrationActivity.this.g);
                jSONObject2.put("app_key", "edb45545e5c3fc59ad5a02be276d56a00260593c6596f84b8b132b1e3b0545ef");
                jSONObject2.put("access_token", UserRegistrationActivity.this.B);
                jSONObject2.put("user_data", jSONObject);
                HTTPLibrary.post(UserRegistrationActivity.this, UserRegistrationActivity.this, 4, h.a.f3473a, h.a.f3476d, jSONObject2, null);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (h.e(UserRegistrationActivity.this)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
                    httpURLConnection.setRequestProperty("User-Agent", "Test");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setConnectTimeout(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    httpURLConnection.connect();
                    return httpURLConnection.getResponseCode() == 200;
                } catch (SocketTimeoutException e2) {
                    CLog.a("IOTA", " socket timeout");
                } catch (IOException e3) {
                    CLog.a("IOTA", "Error checking internet connection", e3);
                }
            } else {
                CLog.a("IOTA", "No network available!");
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            UserRegistrationActivity.this.s();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", UserRegistrationActivity.this.g);
                jSONObject.put("app_key", "edb45545e5c3fc59ad5a02be276d56a00260593c6596f84b8b132b1e3b0545ef");
                jSONObject.put("android_id", com.android.library.deviceData.c.a.e(UserRegistrationActivity.this.getApplicationContext()));
                jSONObject.put("mobile_no", str);
                HTTPLibrary.post(UserRegistrationActivity.this, UserRegistrationActivity.this, 2, h.a.f3473a, h.a.f3474b, jSONObject, h.b(UserRegistrationActivity.this, "Requesting OTP"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            UserRegistrationActivity.this.t = new Handler() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    switch (message.what) {
                        case 1:
                            a.this.f3198b = a.this.a();
                            break;
                        case 2:
                            if (!a.this.a()) {
                                h.d(UserRegistrationActivity.this);
                            } else {
                                a.this.b((String) message.obj);
                            }
                            break;
                        case 3:
                            if (a.this.a() && UserRegistrationActivity.this.p) {
                                a.this.a((String) message.obj);
                            } else {
                                h.d(UserRegistrationActivity.this);
                            }
                            break;
                        case 4:
                            if (!a.this.a()) {
                                h.d(UserRegistrationActivity.this);
                            } else {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("full_name", UserRegistrationActivity.this.k.getText().toString());
                                    if (UserRegistrationActivity.this.q && UserRegistrationActivity.this.r) {
                                        jSONObject.put("age_range", UserRegistrationActivity.this.q ? UserRegistrationActivity.this.F.c() : UserRegistrationActivity.this.M.c());
                                    } else {
                                        jSONObject.put("age_range", "");
                                    }
                                    jSONObject.put("dob", new SimpleDateFormat("yyyy/mm/dd").format(new SimpleDateFormat("dd/mm/yyyy").parse(UserRegistrationActivity.this.n.getText().toString())));
                                    jSONObject.put("gender", UserRegistrationActivity.this.K.isChecked() ? "male" : "female");
                                    jSONObject.put(Scopes.EMAIL, UserRegistrationActivity.this.m.getText().toString());
                                } catch (ParseException e2) {
                                    e2.printStackTrace();
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                }
                                a.this.a(jSONObject);
                            }
                            break;
                    }
                }
            };
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f3200a = Pattern.compile("\\d+");

        public static boolean a(String str) {
            if (str == null) {
                return false;
            }
            return Pattern.matches("[0-9]{6}", str);
        }

        public static String b(String str) {
            String strGroup = "";
            if (str != null) {
                Matcher matcher = f3200a.matcher(str);
                while (matcher.find()) {
                    strGroup = matcher.group();
                    if (a(strGroup)) {
                        break;
                    }
                }
            }
            return strGroup;
        }
    }

    static {
        android.support.v7.a.h.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cube26.iota.smartlite.UserRegistration.a aVar) {
        if (aVar.b() != null) {
            this.k.setText(aVar.b());
            this.k.setSelection(this.k.length());
        }
        if (aVar.d() != null) {
            this.m.setText(aVar.d());
            this.m.setSelection(this.m.length());
        }
        if (aVar.a() != null) {
            this.n.setText(aVar.a());
        }
    }

    private void a(GoogleSignInResult googleSignInResult) {
        CLog.a("IOTA", "handleSignInResult:" + googleSignInResult.isSuccess());
        if (googleSignInResult.isSuccess()) {
            GoogleSignInAccount signInAccount = googleSignInResult.getSignInAccount();
            ((GradientDrawable) this.u.getBackground()).setColor(-65536);
            this.u.setTextColor(-1);
            Person currentPerson = Plus.PeopleApi.getCurrentPerson(this.w);
            this.F.a(currentPerson.getDisplayName());
            if (currentPerson.getAgeRange() != null) {
                this.F.c(currentPerson.getAgeRange().toString());
            }
            this.F.d(signInAccount.getEmail());
            this.F.b(currentPerson.getGender() + "");
            this.F.a(true);
            q();
            a(this.F);
            this.s = true;
            this.u.setCompoundDrawablesWithIntrinsicBounds(this.W, (Drawable) null, (Drawable) null, (Drawable) null);
            this.x.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    UserRegistrationActivity.this.o();
                    return true;
                }
            });
            this.X.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    UserRegistrationActivity.this.o();
                    return true;
                }
            });
        }
    }

    private void a(String str) {
        r();
        getSharedPreferences("user_reg_shared_prefs", 0).edit().putBoolean("is_completed", true).commit();
        if (getSharedPreferences("walkthrough_shared_prefs", 0).getBoolean("is_completed", false)) {
            this.G = MainActivity.class;
        } else {
            this.G = OnBoardingActivity.class;
        }
        getSharedPreferences("user_reg_shared_prefs", 0).edit().putString("authify_access_token", this.B).commit();
        startActivity(new Intent(this, (Class<?>) this.G));
        finish();
    }

    private void g() {
        Config config = Config.getInstance(this);
        h.a.f3473a = config.get("authifyLib.authifyUrl");
        h.b.f3478b = config.get("lite.registrationUrl");
    }

    private void h() {
        this.f3172e = new BroadcastReceiver() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.11
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Bundle extras;
                String strB;
                if ((!(intent != null) || !(intent.getAction() != null)) || !intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") || (extras = intent.getExtras()) == null) {
                    return;
                }
                try {
                    for (Object obj : (Object[]) extras.get("pdus")) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                        String displayOriginatingAddress = smsMessageCreateFromPdu.getDisplayOriginatingAddress();
                        String displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                        CLog.b("IOTA", "senderNum: " + displayOriginatingAddress + "; message: " + displayMessageBody);
                        if (displayOriginatingAddress.contains("REOS") && (strB = b.b(displayMessageBody)) != null && b.a(strB)) {
                            UserRegistrationActivity.this.i = strB;
                            UserRegistrationActivity.this.o = true;
                            UserRegistrationActivity.this.P.setText(strB);
                        }
                    }
                } catch (NullPointerException e2) {
                    CLog.d("SmsReceiver", "Exception smsReceiver" + e2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestScopes(new Scope(Scopes.PLUS_LOGIN), new Scope[0]).build();
        if (this.w != null && this.w.isConnected()) {
            this.w.stopAutoManage(this);
            this.w.disconnect();
            this.w = null;
        }
        this.w = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Plus.API).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsBuild).addScope(Plus.SCOPE_PLUS_LOGIN).build();
        this.w.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.y = e.a.a();
        g.c().a(this.y, new com.facebook.h<com.facebook.login.h>() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.12
            @Override // com.facebook.h
            public void a() {
            }

            @Override // com.facebook.h
            public void a(k kVar) {
            }

            @Override // com.facebook.h
            public void a(com.facebook.login.h hVar) {
                UserRegistrationActivity.this.B = hVar.a().b();
                CLog.a("IOTA", " access token  :: " + hVar.a().b() + " token :: " + AccessToken.a());
            }
        });
        this.C = new AnonymousClass13();
        this.x.setReadPermissions(Scopes.EMAIL);
        this.D = new x() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.14
            @Override // com.facebook.x
            protected void a(Profile profile, Profile profile2) {
                CLog.a("IOTA", "onCurrentProfileChanged");
            }
        };
    }

    private void k() {
        this.Y = (RelativeLayout) findViewById(R.id.reg_screen_bg_layout);
        this.Z = (RelativeLayout) findViewById(R.id.unreg_screen_bg_layout);
        this.u = (Button) findViewById(R.id.register_google_button);
        this.x = (LoginButton) findViewById(R.id.register_facebook_button);
        this.v = (TextView) findViewById(R.id.register_try_virtual_lite_text);
        this.H = (FrameLayout) findViewById(R.id.register_layout);
        this.I = (FloatingActionButton) findViewById(R.id.request_otp);
        this.J = (AppCompatImageView) findViewById(R.id.register_help);
        this.K = (RadioButton) findViewById(R.id.radio_male);
        this.L = (RadioButton) findViewById(R.id.radio_female);
        this.k = (EditText) findViewById(R.id.edit_name);
        this.m = (EditText) findViewById(R.id.edit_email_id);
        this.n = (TextView) findViewById(R.id.edit_date_of_birth);
        this.l = (EditText) findViewById(R.id.edit_mobile_no);
        this.O = (LinearLayout) findViewById(R.id.form_details);
        this.X = (Button) findViewById(R.id.register_fb_button_overlay);
        this.N = (RelativeLayout) findViewById(R.id.otp_verify_form);
        this.P = (EditText) findViewById(R.id.enter_otp);
        this.S = (TextView) findViewById(R.id.otp_verification_mobile_view);
        this.x.setTextColor(Color.parseColor("#7f0e0027"));
        this.x.setGravity(17);
        this.u.setTextColor(getResources().getColor(R.color.google_color_code));
        this.u.setGravity(17);
        this.Q = android.support.b.a.f.a(getResources(), R.drawable.proceed_drawable, (Resources.Theme) null);
        this.R = android.support.b.a.f.a(getResources(), R.drawable.confirm_drawable, (Resources.Theme) null);
        this.T = android.support.b.a.f.a(getResources(), R.drawable.fb_drawable, (Resources.Theme) null);
        this.V = android.support.b.a.f.a(getResources(), R.drawable.google_drawable, (Resources.Theme) null);
        this.W = android.support.b.a.f.a(getResources(), R.drawable.google_white_drawable, (Resources.Theme) null);
        this.U = android.support.b.a.f.a(getResources(), R.drawable.facebook_white_drawable, (Resources.Theme) null);
        this.I.setImageDrawable(this.Q);
        this.x.setTextColor(getResources().getColor(R.color.fb_color_code));
        this.X.setCompoundDrawablesWithIntrinsicBounds(this.T, (Drawable) null, (Drawable) null, (Drawable) null);
        this.u.setCompoundDrawablesWithIntrinsicBounds(this.V, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void l() {
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new c().show(UserRegistrationActivity.this.getSupportFragmentManager(), "datePicker");
            }
        });
        this.X.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UserRegistrationActivity.this.x.onTouchEvent(motionEvent);
                if (UserRegistrationActivity.this.s) {
                    UserRegistrationActivity.this.o();
                } else {
                    UserRegistrationActivity.this.r = true;
                    UserRegistrationActivity.this.j();
                }
                return true;
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRegistrationActivity.this.startActivity(new Intent(UserRegistrationActivity.this, (Class<?>) TryVirtualReosLiteActivity.class));
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserRegistrationActivity.this.s) {
                    UserRegistrationActivity.this.o();
                    return;
                }
                UserRegistrationActivity.this.q = true;
                UserRegistrationActivity.this.i();
                UserRegistrationActivity.this.p();
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                android.support.v7.a.e eVarB = new android.support.v7.a.e.a(UserRegistrationActivity.this).b();
                eVarB.setTitle("Warranty");
                eVarB.a("Please register with your information for warranty services.");
                eVarB.a(-3, "OK", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                eVarB.show();
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserRegistrationActivity.this.k.getText() != null && !h.a(UserRegistrationActivity.this.k.getText().toString())) {
                    UserRegistrationActivity.this.k.setError("Invalid name");
                    Toast.makeText(UserRegistrationActivity.this, "Please enter required fields!", 0).show();
                    return;
                }
                if (UserRegistrationActivity.this.m.getText() != null && !h.a(UserRegistrationActivity.this.m.getText().toString())) {
                    UserRegistrationActivity.this.m.setError("Invalid emailId");
                    Toast.makeText(UserRegistrationActivity.this, "Please enter required fields!", 0).show();
                    return;
                }
                if (UserRegistrationActivity.this.l.getText() != null && !h.a(UserRegistrationActivity.this.l.getText().toString())) {
                    UserRegistrationActivity.this.l.setError("Invalid Mobile Number");
                    Toast.makeText(UserRegistrationActivity.this, "Please enter your mobile number for verification!", 0).show();
                } else {
                    if (!h.a((CharSequence) UserRegistrationActivity.this.m.getText().toString())) {
                        Toast.makeText(UserRegistrationActivity.this, "Please enter valid email!", 0).show();
                        return;
                    }
                    if (!h.b((CharSequence) UserRegistrationActivity.this.l.getText().toString())) {
                        Toast.makeText(UserRegistrationActivity.this, "Please enter valid mobile number!", 0).show();
                    } else if (com.cube26.iota.smartlite.util.g.a(UserRegistrationActivity.this, "android.permission.RECEIVE_SMS")) {
                        UserRegistrationActivity.this.m();
                    } else {
                        com.cube26.iota.smartlite.util.g.a(UserRegistrationActivity.this, "android.permission.RECEIVE_SMS", 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.p && (this.P.getText() == null || !h.a(this.P.getText().toString()))) {
            Toast.makeText(this, "Enter otp!", 0).show();
            return;
        }
        Message messageObtain = Message.obtain(this.t);
        if (this.p) {
            messageObtain.what = 3;
            messageObtain.obj = this.P.getText().toString().trim();
        } else {
            messageObtain.what = 2;
            messageObtain.obj = "91" + this.l.getText().toString().trim();
            this.h = "91" + this.l.getText().toString().trim();
        }
        this.t.sendMessage(messageObtain);
    }

    private void n() {
        this.u.setEnabled(false);
        this.x.setEnabled(false);
        this.O.setVisibility(4);
        this.N.setVisibility(0);
        this.I.setImageDrawable(this.R);
        this.S.setText(this.l.getText().toString().trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Toast.makeText(this, "Kindly fill the mandatory fields.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.w), PlacesStatusCodes.USAGE_LIMIT_EXCEEDED);
    }

    private void q() {
        Auth.GoogleSignInApi.signOut(this.w).setResultCallback(new ResultCallback<Status>() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.8
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess()) {
                }
            }
        });
    }

    private void r() {
        if (this.j == null || !this.j.isAlive()) {
            return;
        }
        this.j.quit();
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f3173f = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(this.f3172e, this.f3173f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            unregisterReceiver(this.f3172e);
        } catch (IllegalArgumentException e2) {
        }
    }

    private void u() {
        ((GradientDrawable) this.u.getBackground()).setColor(-1);
        this.u.setTextColor(getResources().getColor(R.color.google_color_code));
        this.u.setGravity(17);
        this.u.setCompoundDrawablesWithIntrinsicBounds(this.V, (Drawable) null, (Drawable) null, (Drawable) null);
        ((GradientDrawable) this.X.getBackground()).setColor(-1);
        this.X.setTextColor(getResources().getColor(R.color.fb_color_code));
        this.X.setGravity(17);
        this.X.setCompoundDrawablesWithIntrinsicBounds(this.T, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void v() {
        this.f3169b = (AppCompatImageView) findViewById(R.id.splash_app_icon);
        this.f3170c = findViewById(R.id.splash_app_text);
        this.f3171d = findViewById(R.id.reg_screen_bg_layout);
        this.f3169b.setTranslationX(1000.0f);
        this.f3170c.setTranslationX(1000.0f);
        this.f3169b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.10
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                UserRegistrationActivity.this.f3169b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                UserRegistrationActivity.this.f3169b.animate().x(((UserRegistrationActivity.this.f3171d.getX() + UserRegistrationActivity.this.f3171d.getWidth()) / 2.0f) + (UserRegistrationActivity.this.f3170c.getWidth() / 2)).setStartDelay(500L).setDuration(1000L).setInterpolator(new OvershootInterpolator(1.2f)).start();
                UserRegistrationActivity.this.f3170c.animate().x(((UserRegistrationActivity.this.f3171d.getX() + UserRegistrationActivity.this.f3171d.getWidth()) / 2.0f) - (UserRegistrationActivity.this.f3170c.getWidth() / 2)).setStartDelay(300L).setDuration(1000L).setInterpolator(new OvershootInterpolator(1.2f)).start();
            }
        });
    }

    @Override // com.cube26.iota.smartlite.util.c.a
    public void a(int i, int i2, int i3) {
        this.n.setText(i + "/" + (i2 + 1) + "/" + i3);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            if (i == 9001) {
                a(Auth.GoogleSignInApi.getSignInResultFromIntent(intent));
            } else {
                this.y.a(i, i2, intent);
            }
        } catch (Exception e2) {
            CLog.a("IOTA", " exception g+");
            this.u.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.X.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            Toast.makeText(this, "Could not register your information. Kindly enter it manually.", 0).show();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        CLog.a("IOTA", "onConnectionFailed:" + connectionResult);
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c().b();
        setContentView(R.layout.user_registration_screen);
        g();
        k();
        l();
        h();
        this.F = new com.cube26.iota.smartlite.UserRegistration.a();
        this.Y.setVisibility(0);
        this.Z.setVisibility(8);
        v();
        new Handler().postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (UserRegistrationActivity.this.getSharedPreferences("user_reg_shared_prefs", 0).getBoolean("is_completed", false)) {
                    if (UserRegistrationActivity.this.getSharedPreferences("walkthrough_shared_prefs", 0).getBoolean("is_completed", false)) {
                        UserRegistrationActivity.this.G = MainActivity.class;
                    } else {
                        UserRegistrationActivity.this.G = OnBoardingActivity.class;
                    }
                    UserRegistrationActivity.this.startActivity(new Intent(UserRegistrationActivity.this, (Class<?>) UserRegistrationActivity.this.G));
                    UserRegistrationActivity.this.finish();
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, BitmapDescriptorFactory.HUE_RED);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(BitmapDescriptorFactory.HUE_RED, 1.0f);
                alphaAnimation2.setDuration(2000L);
                alphaAnimation2.setStartOffset(1000L);
                alphaAnimation.setDuration(2000L);
                alphaAnimation.setStartOffset(1000L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UserRegistrationActivity.this.Y.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.1.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UserRegistrationActivity.this.H.setVisibility(0);
                        UserRegistrationActivity.this.I.setVisibility(0);
                        UserRegistrationActivity.this.v.setVisibility(0);
                        UserRegistrationActivity.this.Z.setVisibility(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                UserRegistrationActivity.this.H.startAnimation(alphaAnimation2);
                UserRegistrationActivity.this.v.startAnimation(alphaAnimation2);
                UserRegistrationActivity.this.Z.startAnimation(alphaAnimation2);
                UserRegistrationActivity.this.f3169b.startAnimation(alphaAnimation);
                UserRegistrationActivity.this.f3170c.startAnimation(alphaAnimation);
            }
        }, 2000L);
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        r();
        if (this.r) {
            this.C.b();
            this.D.b();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0003. Please report as an issue. */
    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
        h.h(this);
        switch (i) {
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
        h.h(this);
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 1:
                if (iArr.length != 0 && iArr[0] != -1) {
                    m();
                } else if (android.support.v4.app.a.a((Activity) this, "android.permission.RECEIVE_SMS")) {
                    android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar.a("Permission Denial");
                    aVar.b("We require sms permission for OTP verification. Please provide the permission for successful registration.");
                    aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.UserRegistration.UserRegistrationActivity.9
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", UserRegistrationActivity.this.getPackageName(), null));
                            UserRegistrationActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar.a(false);
                    aVar.c();
                }
                break;
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    public void onStart() {
        super.onStart();
        u();
        this.j = new a(a.class.getName());
        this.j.start();
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
        switch (i) {
            case 2:
                try {
                    this.p = new JSONObject(lVar.e().k().toString()).getBoolean(Constants.SMS_COLUMN_STATUS);
                    if (this.p) {
                        n();
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 3:
                try {
                    JSONObject jSONObject = new JSONObject(lVar.e().k().toString());
                    if (jSONObject.getBoolean(Constants.SMS_COLUMN_STATUS)) {
                        this.B = jSONObject.getString("access_token");
                        this.t.sendMessage(Message.obtain(this.t, 4));
                    } else {
                        Toast.makeText(this, "Otp verification failed.", 0).show();
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 4:
                try {
                    if (new JSONObject(lVar.e().k().toString()).getBoolean(Constants.SMS_COLUMN_STATUS)) {
                        a(this.B);
                    } else {
                        Toast.makeText(this, " data sending failed", 0).show();
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }
}
