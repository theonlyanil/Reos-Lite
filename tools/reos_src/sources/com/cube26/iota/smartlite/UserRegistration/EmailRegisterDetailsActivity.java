package com.cube26.iota.smartlite.UserRegistration;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.util.h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EmailRegisterDetailsActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f3161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IntentFilter f3162d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3164f;
    private a g;
    private EditText h;
    private EditText i;
    private EditText j;
    private boolean k;
    private boolean l;
    private Handler m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3163e = "test9";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3159a = false;

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3166b;

        public a(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            EmailRegisterDetailsActivity.this.b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", EmailRegisterDetailsActivity.this.f3163e);
                jSONObject.put("app_key", "test9");
                jSONObject.put("mobile_no", EmailRegisterDetailsActivity.this.f3164f);
                jSONObject.put("otp", str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://45.79.141.163/mobile/verify").openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.connect();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.flush();
                CLog.a("IOTA", "writer flushed ");
                outputStreamWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                JSONObject jSONObject2 = new JSONObject(inputStream != null ? h.a(inputStream) : null);
                if (!jSONObject2.getBoolean(Constants.SMS_COLUMN_STATUS)) {
                    Toast.makeText(EmailRegisterDetailsActivity.this, " otp verification failed", 0).show();
                    return;
                }
                Toast.makeText(EmailRegisterDetailsActivity.this, " otp verified", 0).show();
                EmailRegisterDetailsActivity.this.f3160b = jSONObject2.getString("access_token");
                EmailRegisterDetailsActivity.this.m.sendMessage(Message.obtain(EmailRegisterDetailsActivity.this.m, 4));
            } catch (SocketTimeoutException e2) {
                CLog.a("IOTA", " socket timeout");
            } catch (IOException e3) {
                CLog.a("IOTA", "Error checking internet connection", e3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_id", EmailRegisterDetailsActivity.this.f3163e);
                jSONObject2.put("app_key", "test9");
                jSONObject2.put("access_token", "91ab6fd9bacfb5d73180fdd8ca50bbd08ae1d4b6f5a6fb1b005751ccec6c4aab3007c46a9784c0485b1cc867cccc41ca7c779faa46cf7d304896ad4ff8e71558");
                jSONObject2.put("user_data", jSONObject);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://45.79.141.163/add-user-data").openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.connect();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                outputStreamWriter.write(jSONObject2.toString());
                outputStreamWriter.flush();
                CLog.a("IOTA", "writer flushed ");
                outputStreamWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (!new JSONObject(inputStream != null ? h.a(inputStream) : null).getBoolean(Constants.SMS_COLUMN_STATUS)) {
                    Toast.makeText(EmailRegisterDetailsActivity.this, " data sending failed", 0).show();
                } else {
                    Toast.makeText(EmailRegisterDetailsActivity.this, " data sent", 0).show();
                    EmailRegisterDetailsActivity.this.a(EmailRegisterDetailsActivity.this.f3160b);
                }
            } catch (SocketTimeoutException e2) {
                CLog.a("IOTA", " socket timeout");
            } catch (IOException e3) {
                CLog.a("IOTA", "Error checking internet connection", e3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (h.e(EmailRegisterDetailsActivity.this)) {
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
            EmailRegisterDetailsActivity.this.a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", EmailRegisterDetailsActivity.this.f3163e);
                jSONObject.put("app_key", "test9");
                jSONObject.put("mobile_no", str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://45.79.141.163/mobile/register").openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.connect();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.flush();
                CLog.a("IOTA", "writer flushed ");
                outputStreamWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                EmailRegisterDetailsActivity.this.l = new JSONObject(inputStream != null ? h.a(inputStream) : null).getBoolean(Constants.SMS_COLUMN_STATUS);
            } catch (SocketTimeoutException e2) {
                CLog.a("IOTA", " socket timeout");
            } catch (IOException e3) {
                CLog.a("IOTA", "Error checking internet connection", e3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            EmailRegisterDetailsActivity.this.m = new Handler() { // from class: com.cube26.iota.smartlite.UserRegistration.EmailRegisterDetailsActivity.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    switch (message.what) {
                        case 1:
                            a.this.f3166b = a.this.a();
                            break;
                        case 2:
                            if (a.this.a()) {
                                a.this.b((String) message.obj);
                            }
                            break;
                        case 3:
                            if (a.this.a() && EmailRegisterDetailsActivity.this.k) {
                                a.this.a((String) message.obj);
                                break;
                            }
                            break;
                        case 4:
                            if (a.this.a()) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("full_name", EmailRegisterDetailsActivity.this.h.getText().toString());
                                    jSONObject.put("age_range", "");
                                    jSONObject.put("dob", EmailRegisterDetailsActivity.this.j.getText().toString());
                                    jSONObject.put("gender", "");
                                    jSONObject.put(Scopes.EMAIL, EmailRegisterDetailsActivity.this.i.getText().toString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                a.this.a(jSONObject);
                            }
                            break;
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f3162d = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(this.f3161c, this.f3162d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("authify_access_token", str);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        unregisterReceiver(this.f3161c);
    }

    public void dismiss(View view) {
        this.f3159a = true;
        setResult(0);
        finishAfterTransition();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        dismiss(null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.g == null || !this.g.isAlive()) {
            return;
        }
        this.g.quit();
        this.g = null;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g = new a(a.class.getName());
        this.g.start();
    }
}
