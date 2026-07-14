package com.cube26.iota.smartlite.AlertViews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.a.e;
import android.support.v7.a.f;
import android.text.Html;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.c;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.ColorCodeChangeListener;
import com.cube26.iota.smartlite.util.d;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import f.l;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlertSpecPropActivity extends f implements HTTPLibrary.b, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static ArrayAdapter<String> x;
    private static String y;
    private static ArrayList<String> z;
    private ArrayList<String> A;
    private ArrayList<String> B;
    private Button C;
    private com.cube26.iota.smartlite.a.a D;
    private ImageButton E;
    private EditText G;
    private String H;
    private ProgressBar I;
    private AlertDialog J;
    private GoogleCloudMessaging P;
    private TextView Q;
    private String R;
    private ImageView S;
    private ImageView T;
    private ArrayList<byte[]> U;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AsyncTask f2838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f2840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f2841f;
    private GoogleApiClient g;
    private LocationRequest i;
    private AlertDialog o;
    private LocationManager p;
    private ProgressDialog q;
    private Spinner s;
    private Spinner t;
    private int u;
    private TextView v;
    private TextView w;
    private static long j = -1;
    private static int K = -1;
    private static final String[] M = {"Fade in", "Fade out", "Candle Flicker", "Strobe", "Kaleidoscope"};
    private static final String[] N = {"Fade in", "Fade out", "Flash Alert"};
    private static final Integer[] O = {1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2836a = {R.drawable.callactivated, R.drawable.smsactivated, R.drawable.youtubeactivated, R.drawable.weatheractivated, R.drawable.whatsappactivated, R.drawable.hikeactivated, R.drawable.olaactivated, R.drawable.uberactivated, R.drawable.facebookactivated, R.drawable.facebookactivated, R.drawable.tinderactivated};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Cursor f2837b = null;
    private final boolean h = true;
    private String k = "0.0";
    private String l = "0.0";
    private double m = 0.0d;
    private double n = 0.0d;
    private boolean r = false;
    private final int F = 2015;
    private int L = 0;

    private SharedPreferences a(Context context) {
        return context.getSharedPreferences("GCMPrefs", 0);
    }

    private void a(int i) {
        if (i == 1) {
            this.v.setText("If");
            this.w.setText("calls me");
        } else if (i == 2 || i == 5 || i == 6) {
            this.v.setText("If");
            this.w.setText("texts me");
        } else if (i == 7) {
            this.v.setText("When my ola arrives");
            this.s.setVisibility(4);
        } else if (i == 8) {
            this.v.setText("When my uber arrives");
            this.s.setVisibility(4);
        } else if (i == 11) {
            this.v.setText("If I match someone on Tinder");
            this.s.setVisibility(4);
        } else if (i == 12 || i == 14 || i == 15 || i == 13) {
            this.v.setText("When my food arrives");
            this.s.setVisibility(4);
        }
        this.A.add("Anyone");
        this.A.add("Select Contact");
        x = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, this.A);
        this.s.setAdapter((SpinnerAdapter) x);
        this.s.setSelection(this.A.size() - 2);
        this.C.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        SharedPreferences sharedPreferencesA = a(context);
        int iC = c(context);
        CLog.b("IOTA", "Saving regId on app version " + iC);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.putString("registration_id", str);
        editorEdit.putInt("appVersion", iC);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity$7] */
    public void a(final String str, boolean z2) {
        new AsyncTask<Void, Void, String>() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String doInBackground(Void... voidArr) {
                String str2 = "";
                CLog.a("IOTA", " registerating in background ");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.accumulate("gcm_key", str);
                    jSONObject.accumulate("device_id", h.a());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://180.151.30.102:8021//users/create").openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.connect();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                    outputStreamWriter.write(jSONObject.toString());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    CLog.a("IOTA", " response code " + httpURLConnection.getResponseCode());
                    if (httpURLConnection.getResponseCode() == 200) {
                        CLog.a("IOTA", " response OK");
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (inputStream != null) {
                            String strB = AlertSpecPropActivity.b(inputStream);
                            try {
                                JSONObject jSONObject2 = new JSONObject(strB);
                                String string = jSONObject2.getString(Constants.SMS_COLUMN_STATUS);
                                CLog.a("IOTA", "Result " + string);
                                if (string.equals("200")) {
                                    String string2 = jSONObject2.getJSONObject(Config.RESPONSE).getString("user_id");
                                    CLog.a("IOTA", "Unique id ::" + string2);
                                    AlertSpecPropActivity.this.b(AlertSpecPropActivity.this, string2);
                                    AlertSpecPropActivity.this.a((Context) AlertSpecPropActivity.this, str);
                                } else {
                                    CLog.a("IOTA", "Unique id ::null");
                                }
                                return strB;
                            } catch (IOException e2) {
                                str2 = strB;
                                e = e2;
                                e.printStackTrace();
                                return str2;
                            } catch (JSONException e3) {
                                str2 = strB;
                                e = e3;
                                e.printStackTrace();
                                return str2;
                            }
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (JSONException e5) {
                    e = e5;
                }
                return str2;
            }
        }.execute(null, null, null);
    }

    private SharedPreferences b(Context context) {
        return context.getSharedPreferences("USERIDPrefs", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return str;
            }
            str = str + line;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        SharedPreferences sharedPreferencesB = b(context);
        CLog.a("IOTA", "Saving user_id" + str);
        SharedPreferences.Editor editorEdit = sharedPreferencesB.edit();
        editorEdit.putString("user_id", str);
        editorEdit.commit();
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Could not get package name: " + e2);
        }
    }

    private boolean n() {
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (iIsGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(iIsGooglePlayServicesAvailable)) {
            GooglePlayServicesUtil.getErrorDialog(iIsGooglePlayServicesAvailable, this, 1000).show();
        } else {
            Toast.makeText(getApplicationContext(), "This device is not supported.", 1).show();
            finish();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
        String string = getSharedPreferences("USERIDPrefs", 0).getString("user_id", "DEFAULT");
        CLog.a("IOTA", " user id " + string);
        return string;
    }

    private void p() {
        HTTPLibrary.get(this, this, 4100, h.b.f3478b, "recipes/", null);
    }

    private void q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?").setCancelable(true).setPositiveButton("Settings", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertSpecPropActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                dialogInterface.cancel();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        this.o = builder.create();
        this.o.show();
    }

    protected synchronized void g() {
        this.g = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
    }

    protected void h() {
        this.i = new LocationRequest();
        this.i.setInterval(5000);
        this.i.setFastestInterval(5000);
        this.i.setPriority(100);
        this.i.setSmallestDisplacement(0);
    }

    protected void i() {
        LocationServices.FusedLocationApi.requestLocationUpdates(this.g, this.i, this);
    }

    protected void j() {
        LocationServices.FusedLocationApi.removeLocationUpdates(this.g, this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity$6] */
    public void k() {
        new AsyncTask<Void, Void, String>() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String doInBackground(Void... voidArr) {
                try {
                    CLog.a("IOTA", "Inside register in back ");
                    if (AlertSpecPropActivity.this.P == null) {
                        AlertSpecPropActivity.this.P = GoogleCloudMessaging.getInstance(AlertSpecPropActivity.this);
                    }
                    AlertSpecPropActivity.this.R = AlertSpecPropActivity.this.P.register("433584691981");
                    String str = "Device registered, registration ID=" + AlertSpecPropActivity.this.R;
                    CLog.a("IOTA", "GCM Reg Id :: " + str);
                    AlertSpecPropActivity.this.a(AlertSpecPropActivity.this.R, false);
                    AlertSpecPropActivity.this.a((Context) AlertSpecPropActivity.this, AlertSpecPropActivity.this.R);
                    return str;
                } catch (IOException e2) {
                    String str2 = "Error :" + e2.getMessage();
                    CLog.b("IOTA", "Error in GCM register ::" + str2);
                    return str2;
                }
            }
        }.execute(null, null, null);
    }

    public void l() {
        if (this.p.isProviderEnabled("gps")) {
            return;
        }
        q();
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z2;
        CLog.a("IOTA", "result code " + i);
        if (i != 2015 || i2 != -1) {
            this.s.setSelection(this.A.size() - 2);
            return;
        }
        Cursor cursorQuery = getContentResolver().query(intent.getData(), null, null, null, null);
        cursorQuery.moveToFirst();
        int columnIndex = cursorQuery.getColumnIndex("data1");
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("contact_id"));
        byte[] bArrA = h.a(this, Long.parseLong(string2));
        CLog.b("IOTA", "contact picked with name" + string + " and number " + cursorQuery.getString(columnIndex) + ":: id :: " + string2);
        if (this.u != 5) {
            if (this.A.contains(string)) {
                CLog.a("IOTA", string + " already contained at index :: " + this.A.indexOf(string));
                this.s.setSelection(this.A.indexOf(string));
                return;
            } else {
                this.A.add(0, string);
                this.B.add(0, cursorQuery.getString(columnIndex));
                this.U.add(0, bArrA);
                this.s.setSelection(0);
                return;
            }
        }
        CLog.a("IOTA", " id 5");
        if (this.f2837b != null && this.f2837b.getCount() > 0) {
            CLog.a("IOTA", " whatsapp cursor not null");
            this.f2837b.moveToFirst();
            while (true) {
                if (this.f2837b.isAfterLast()) {
                    z2 = false;
                    break;
                }
                String string3 = this.f2837b.getString(this.f2837b.getColumnIndex("display_name"));
                CLog.a("IOTA", "whatsapp :: " + string3);
                if (string3.equals(string)) {
                    CLog.a("IOTA", "is whatsapp contact loop::false");
                    z2 = true;
                    break;
                }
                this.f2837b.moveToNext();
            }
        } else {
            z2 = false;
            break;
        }
        CLog.a("IOTA", "is whatsapp contact ::" + z2);
        if (z2) {
            if (this.A.contains(string)) {
                CLog.a("IOTA", string + " already contained at index :: " + this.A.indexOf(string));
                this.s.setSelection(this.A.indexOf(string));
                return;
            }
            CLog.a("IOTA", " adding new contact :: " + string);
            this.A.add(0, string);
            this.U.add(0, bArrA);
            this.B.add(0, cursorQuery.getString(columnIndex));
            this.s.setSelection(0);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contact");
        builder.setCancelable(true);
        if (this.u == 5) {
            builder.setMessage("Selected contact is not on WhatsApp");
            this.s.setSelection(this.A.size() - 2);
        } else if (this.u == 6) {
            builder.setMessage("Selected contact not on Hike");
        }
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        builder.create().show();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        i();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        this.g.connect();
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.u = intent.getIntExtra("recipe_id", -1);
        intent.getStringExtra("open_type");
        this.p = (LocationManager) getSystemService("location");
        if (o().equalsIgnoreCase("DEFAULT")) {
            k();
        }
        if (this.u == 4 && n()) {
            g();
            h();
        }
        if (this.u == 3) {
            setContentView(R.layout.layout_youtube);
        } else {
            setContentView(R.layout.activity_alert_spec_prop);
        }
        this.H = b.f2943a[this.u - 1];
        if (this.H.equalsIgnoreCase("Youtube_channel")) {
            c().a(Html.fromHtml("<font color='#596475'>YouTube</font>"));
        } else {
            c().a(Html.fromHtml("<font color='#596475'>" + b.f2943a[this.u - 1] + "</font>"));
        }
        c().c(true);
        c().a(true);
        c().b(true);
        c.a().a(this);
        this.D = new com.cube26.iota.smartlite.a.a(getApplicationContext());
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.U = new ArrayList<>();
        this.G = (EditText) findViewById(R.id.sentence_header);
        this.T = (ImageView) findViewById(R.id.recipe_view);
        this.S = (ImageView) findViewById(R.id.recipe_type_view);
        if (this.u == 7) {
            this.G.setText("My Ola alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 8) {
            this.G.setText("My Uber alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 11) {
            this.G.setText("Tinder alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 1) {
            this.G.setText("Call alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 11) {
            this.G.setText("Tinder alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 6) {
            this.G.setText("Hike alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 5) {
            this.G.setText("Whatsapp alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 3) {
            this.G.setText("Youtube alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 9) {
            this.G.setText("Facebook alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 4) {
            this.G.setText("Weather alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 2) {
            this.G.setText("Sms alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 8) {
            this.G.setText("My Uber alert");
            this.G.setSelection(this.G.getText().length());
        } else if (this.u == 12 || this.u == 13 || this.u == 14 || this.u == 15) {
            this.G.setText("My food alert");
            this.G.setSelection(this.G.getText().length());
        }
        this.G.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        this.S.setImageResource(h.h[this.u - 1]);
        this.I = (ProgressBar) findViewById(R.id.progressBar);
        if (this.u == 3 || this.u == 4) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(4);
        }
        this.s = (Spinner) findViewById(R.id.type_holder);
        this.t = (Spinner) findViewById(R.id.prop_transition_picker);
        this.t.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
                switch (i) {
                    case 0:
                        AlertSpecPropActivity.this.f2840e.setImageResource(android.R.color.transparent);
                        break;
                    case 1:
                        AlertSpecPropActivity.this.f2840e.setImageResource(android.R.color.transparent);
                        break;
                    case 2:
                        if (!AlertSpecPropActivity.this.t.getSelectedItem().toString().equals("Flash Alert")) {
                            AlertSpecPropActivity.this.f2840e.setImageResource(R.drawable.candle);
                        } else {
                            AlertSpecPropActivity.this.f2840e.setImageResource(R.drawable.flash_dummy);
                        }
                        break;
                    case 3:
                        AlertSpecPropActivity.this.f2840e.setImageResource(R.drawable.strobe);
                        break;
                    case 4:
                        AlertSpecPropActivity.this.f2840e.setImageResource(R.drawable.kaleidoscope);
                        break;
                }
                if (i <= 1) {
                    AlertSpecPropActivity.this.f2840e.setBackground(d.a(AlertSpecPropActivity.this.L, 1, 1));
                    AlertSpecPropActivity.this.E.setVisibility(0);
                    AlertSpecPropActivity.this.Q.setVisibility(0);
                } else {
                    CLog.a("IOTA", "disabling color picker");
                    AlertSpecPropActivity.this.E.setVisibility(4);
                    AlertSpecPropActivity.this.Q.setVisibility(4);
                    AlertSpecPropActivity.this.f2840e.setBackground(d.a(android.R.color.transparent, 0, 1));
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter arrayAdapter = this.u == 1 ? new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, M) : new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, N);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.t.setAdapter((SpinnerAdapter) arrayAdapter);
        this.v = (TextView) findViewById(R.id.if_holder_text);
        this.w = (TextView) findViewById(R.id.if_suffix_holder);
        this.E = (ImageButton) findViewById(R.id.color_picker);
        this.f2840e = (ImageView) findViewById(R.id.alert_preview_color);
        this.Q = (TextView) findViewById(R.id.static_color_text);
        this.C = (Button) findViewById(R.id.prop_save);
        this.C.setEnabled(false);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                byte[] bArr;
                int i;
                String string;
                String str2;
                int i2;
                if (AlertSpecPropActivity.this.u == 4) {
                    if (AlertSpecPropActivity.this.r) {
                        AlertSpecPropActivity.this.j();
                    } else {
                        AlertSpecPropActivity.this.l();
                    }
                }
                if (AlertSpecPropActivity.this.u == 4 && !AlertSpecPropActivity.this.r) {
                    if (AlertSpecPropActivity.this.o == null) {
                        ProgressDialog progressDialog = new ProgressDialog(AlertSpecPropActivity.this);
                        progressDialog.setMessage("Fetching your location to add an alert");
                        progressDialog.setIndeterminate(true);
                        progressDialog.setCancelable(true);
                        progressDialog.show();
                        return;
                    }
                    if (AlertSpecPropActivity.this.o.isShowing()) {
                        return;
                    }
                    ProgressDialog progressDialog2 = new ProgressDialog(AlertSpecPropActivity.this);
                    progressDialog2.setMessage("Fetching your location to add an alert");
                    progressDialog2.setIndeterminate(true);
                    progressDialog2.setCancelable(true);
                    progressDialog2.show();
                    return;
                }
                if ((AlertSpecPropActivity.this.u == 3 || AlertSpecPropActivity.this.u == 4) && AlertSpecPropActivity.this.o().equalsIgnoreCase("DEFAULT")) {
                    Toast.makeText(AlertSpecPropActivity.this, "Could not register your device with GCM", 0).show();
                    return;
                }
                CLog.a("IOTA", "location avail " + AlertSpecPropActivity.this.r);
                String str3 = (String) AlertSpecPropActivity.this.s.getSelectedItem();
                CLog.b("IOTA", "type :" + str3);
                String str4 = (String) AlertSpecPropActivity.this.t.getSelectedItem();
                String string2 = AlertSpecPropActivity.this.G.getText().toString();
                String string3 = AlertSpecPropActivity.this.v.getText().toString();
                int i3 = AlertSpecPropActivity.this.L;
                CLog.a("IOTA", "color value prior alert insertion:" + AlertSpecPropActivity.this.L);
                if (!h.a(string2)) {
                    if (AlertSpecPropActivity.this.u != 4) {
                        Toast.makeText(AlertSpecPropActivity.this.getApplicationContext(), "Alert title can't be empty", 0).show();
                        return;
                    } else {
                        if (AlertSpecPropActivity.this.o == null || !(AlertSpecPropActivity.this.o == null || AlertSpecPropActivity.this.o.isShowing())) {
                            Toast.makeText(AlertSpecPropActivity.this.getApplicationContext(), "Alert title can't be empty", 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (i3 == 0 && AlertSpecPropActivity.this.t.getSelectedItemPosition() < 2) {
                    if (AlertSpecPropActivity.this.u != 4) {
                        Toast.makeText(AlertSpecPropActivity.this.getApplicationContext(), "Select transition color", 0).show();
                        return;
                    } else {
                        if (AlertSpecPropActivity.this.o == null || !(AlertSpecPropActivity.this.o == null || AlertSpecPropActivity.this.o.isShowing())) {
                            Toast.makeText(AlertSpecPropActivity.this.getApplicationContext(), "Select transition color", 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (AlertSpecPropActivity.this.u == 3 || AlertSpecPropActivity.this.u == 4 || AlertSpecPropActivity.this.u == 7 || AlertSpecPropActivity.this.u == 8 || AlertSpecPropActivity.this.u == 11 || AlertSpecPropActivity.this.u == 12 || AlertSpecPropActivity.this.u == 13 || AlertSpecPropActivity.this.u == 14 || AlertSpecPropActivity.this.u == 15) {
                    str = null;
                    bArr = null;
                    i = i3;
                    string = null;
                    str2 = str3;
                } else {
                    string = AlertSpecPropActivity.this.s.getSelectedItem().toString();
                    if (str4.equals("Fade in") || str4.equals("Fade out")) {
                        CLog.a("IOTA", "transition value :" + str4);
                        CLog.a("IOTA", "touched RGB :" + AlertSpecPropActivity.this.L);
                        i2 = AlertSpecPropActivity.this.L;
                    } else {
                        i2 = 0;
                    }
                    if (string.equals("Anyone")) {
                        str = null;
                        bArr = null;
                        int i4 = i2;
                        str2 = null;
                        i = i4;
                    } else {
                        bArr = (byte[]) AlertSpecPropActivity.this.U.get(AlertSpecPropActivity.this.s.getSelectedItemPosition());
                        str = (String) AlertSpecPropActivity.this.B.get(AlertSpecPropActivity.this.s.getSelectedItemPosition());
                        int i5 = i2;
                        str2 = null;
                        i = i5;
                    }
                }
                CLog.b("IOTA", "adding alert :" + AlertSpecPropActivity.this.u + " " + str2 + " " + i + " " + str4 + " " + string2 + " " + string + " " + str + " " + AlertSpecPropActivity.this.H + " " + AlertSpecPropActivity.K + " description " + string3 + "lat " + AlertSpecPropActivity.this.k + "long " + AlertSpecPropActivity.this.l);
                if ((AlertSpecPropActivity.this.u >= 3 && AlertSpecPropActivity.this.u != 6 && AlertSpecPropActivity.this.u != 5 && AlertSpecPropActivity.this.u != 7 && AlertSpecPropActivity.this.u != 8) || Build.VERSION.SDK_INT <= 22) {
                    CLog.a("IOTA", " contact blob :: " + bArr);
                    if (AlertSpecPropActivity.this.D.a(AlertSpecPropActivity.this.u, str2, Integer.valueOf(i), str4, string2, string, str, AlertSpecPropActivity.this.H, AlertSpecPropActivity.K, string3, AlertSpecPropActivity.this.k, AlertSpecPropActivity.this.l, bArr)) {
                        AlertSpecPropActivity.this.finish();
                        return;
                    }
                    return;
                }
                String str5 = null;
                int i6 = 0;
                switch (AlertSpecPropActivity.this.u) {
                    case 1:
                    case 5:
                    case 6:
                        AlertSpecPropActivity.this.f2839d = false;
                        str5 = "android.permission.READ_CONTACTS";
                        i6 = 101;
                        break;
                    case 2:
                    case 7:
                    case 8:
                        str5 = "android.permission.READ_SMS";
                        i6 = 103;
                        break;
                }
                int iCheckSelfPermission = Build.VERSION.SDK_INT > 22 ? AlertSpecPropActivity.this.checkSelfPermission(str5) : 1;
                if (Build.VERSION.SDK_INT > 22 && iCheckSelfPermission != 0) {
                    CLog.a("IOTA", "requesting  permission" + str5 + " token " + i6);
                    AlertSpecPropActivity.this.requestPermissions(new String[]{str5}, i6);
                    return;
                }
                CLog.a("IOTA", " already have permission ");
                CLog.a("IOTA", " contact blob :: " + bArr);
                if (AlertSpecPropActivity.this.D.a(AlertSpecPropActivity.this.u, str2, Integer.valueOf(i), str4, string2, string, str, AlertSpecPropActivity.this.H, AlertSpecPropActivity.K, string3, AlertSpecPropActivity.this.k, AlertSpecPropActivity.this.l, bArr)) {
                    if (AlertSpecPropActivity.this.u == 1 || AlertSpecPropActivity.this.u == 2 || AlertSpecPropActivity.this.u == 5 || AlertSpecPropActivity.this.u == 6) {
                        HashMap map = new HashMap();
                        if (AlertSpecPropActivity.this.s.getSelectedItem().toString().equals("Anyone")) {
                            map.put("mode_name", "anyone_contact");
                        } else {
                            map.put("mode_name", "particular_contact");
                        }
                        FlurryAgent.logEvent("contact_type", map);
                    }
                    new HashMap().put("alert_section_name", b.f2943a[AlertSpecPropActivity.this.u - 1]);
                    FlurryAgent.logEvent("alert_section");
                    AlertSpecPropActivity.this.finish();
                }
            }
        });
        if (this.u == 3 || this.u == 4) {
            CLog.a("IOTA", "recipe_unique_name  = " + this.H);
            if (h.e(this)) {
                p();
                getWindow().setFlags(16, 16);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Internet Connectivity");
                builder.setCancelable(false);
                builder.setMessage("Your internet is off. Please connect to internet to add an alert..!");
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.11
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertSpecPropActivity.this.finish();
                    }
                });
                this.J = builder.create();
                this.J.show();
            }
        } else {
            a(this.u);
        }
        this.s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
                CLog.b("IOTA", "item selected position" + i);
                String string = adapterView.getItemAtPosition(i).toString();
                if (AlertSpecPropActivity.this.u == 5 || AlertSpecPropActivity.this.u == 1 || AlertSpecPropActivity.this.u == 2 || AlertSpecPropActivity.this.u == 6) {
                    if (string.equals("Select Contact")) {
                        CLog.b("IOTA", "fetching contact");
                        AlertSpecPropActivity.this.f2839d = true;
                        int iCheckSelfPermission = Build.VERSION.SDK_INT > 22 ? AlertSpecPropActivity.this.checkSelfPermission("android.permission.READ_CONTACTS") : 1;
                        if (Build.VERSION.SDK_INT <= 22 || iCheckSelfPermission == 0) {
                            AlertSpecPropActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                            if (AlertSpecPropActivity.this.u == 5) {
                                AlertSpecPropActivity.this.f2837b = AlertSpecPropActivity.this.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"display_name"}, "account_type = ? ", new String[]{"com.whatsapp"}, null);
                            }
                        } else {
                            AlertSpecPropActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 101);
                        }
                    } else if (i == AlertSpecPropActivity.this.A.size() - 2) {
                        AlertSpecPropActivity.this.T.setImageResource(R.drawable.anyone_dummy);
                    } else if (AlertSpecPropActivity.this.U.get(i) != null) {
                        CLog.a("IOTA", " stream not null");
                        AlertSpecPropActivity.this.T.setImageBitmap(h.a(BitmapFactory.decodeStream(new ByteArrayInputStream((byte[]) AlertSpecPropActivity.this.U.get(i)))));
                    } else {
                        CLog.a("IOTA", " stream null");
                        AlertSpecPropActivity.this.T.setImageResource(R.drawable.anyone_dummy);
                    }
                }
                if (AlertSpecPropActivity.this.u == 4) {
                    AlertSpecPropActivity.this.T.setImageResource(d.f3461b[i]);
                }
                if (AlertSpecPropActivity.this.u == 3) {
                    AlertSpecPropActivity.this.T.setImageResource(d.f3460a[i]);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                CLog.b("IOTA", "nothing selected");
            }
        });
        new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, O).setDropDownViewResource(R.layout.spinner_item);
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate = LayoutInflater.from(AlertSpecPropActivity.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(AlertSpecPropActivity.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                AlertSpecPropActivity.this.f2841f = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.13.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.13.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        AlertSpecPropActivity.this.f2840e.setBackground(d.a(AlertSpecPropActivity.this.L, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
        if (this.u == 7 || this.u == 8) {
            this.v.setText("When my " + (this.u == 7 ? "ola" : "uber") + " arrives");
            this.s.setVisibility(8);
            this.T.setImageResource(R.drawable.cab);
        }
        if (this.u == 11) {
            this.T.setImageResource(R.drawable.tinder_dummy);
            this.s.setVisibility(8);
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        int i;
        int i2;
        int i3 = 255;
        try {
            this.L = colorCodeChangeListener.f3421a;
            CLog.a("IOTA", " touched color :: " + this.L);
            int iRed = Color.red(this.L);
            int iGreen = Color.green(this.L);
            int iBlue = Color.blue(this.L);
            if (iRed < 235 || iGreen < 235 || iBlue < 235) {
                i3 = iBlue;
                i = iGreen;
                i2 = iRed;
            } else {
                this.L = Color.rgb(255, 255, 255);
                CLog.a("IOTA", " white color :: " + this.L);
                i = 255;
                i2 = 255;
            }
            CLog.a("IOTA", "Dialog " + ("R: " + i2 + " B: " + i3 + " G: " + i));
            this.f2841f.setBackground(d.a(colorCodeChangeListener.f3421a, 0, 1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
    }

    @Override // com.google.android.gms.location.LocationListener
    public void onLocationChanged(Location location) {
        this.k = String.valueOf(location.getLatitude());
        this.l = String.valueOf(location.getLongitude());
        CLog.a("IOTA", "Lat" + this.k + "Longitude" + this.l);
        this.r = true;
        if (this.q == null || !this.q.isShowing()) {
            return;
        }
        this.q.dismiss();
    }

    @Override // android.support.v4.app.p, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f2838c != null) {
            this.f2838c.cancel(true);
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 101:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D");
                    CLog.a("IOTA", "Permission Granted :D :: + pickconta" + this.f2839d);
                    if ((this.u == 1 || this.u == 2 || this.u == 5 || this.u == 6) && this.f2839d) {
                        this.f2839d = false;
                        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                        this.f2837b = getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"display_name"}, "account_type = ? ", new String[]{"com.whatsapp"}, null);
                    } else if (this.f2839d) {
                        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                    }
                } else {
                    this.s.setSelection(this.A.size() - 2);
                    if (!shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                        e.a aVar = new e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar.a("Permission Denial");
                        aVar.b("Contacts access has not been granted & we require contacts access to set an alert .Are you sure you want to deny the permission?");
                        aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.14
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", AlertSpecPropActivity.this.getPackageName(), null));
                                AlertSpecPropActivity.this.startActivityForResult(intent, 100);
                            }
                        });
                        aVar.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.15
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                AlertSpecPropActivity.this.finish();
                            }
                        });
                        aVar.a(false);
                        aVar.c();
                    } else {
                        e.a aVar2 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar2.a("Permission Error");
                        aVar2.b("From Android M onwards, we require contacts permission to set alert for a particular contact. Please grant the permission for smooth functioning of the app or else you won't be able to set alerts for contacts.");
                        aVar2.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.16
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                AlertSpecPropActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 101);
                            }
                        });
                        aVar2.a(false);
                        aVar2.c();
                    }
                }
                break;
            case 103:
                CLog.a("IOTA", " read sms");
                this.s.setSelection(this.A.size() - 2);
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D");
                } else if (!shouldShowRequestPermissionRationale("android.permission.READ_SMS")) {
                    e.a aVar3 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar3.a("Permission Denial");
                    aVar3.b("Sms access has not been granted & we require sms access to set an alert .Are you sure you want to deny the permission?");
                    aVar3.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.17
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", AlertSpecPropActivity.this.getPackageName(), null));
                            AlertSpecPropActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar3.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            AlertSpecPropActivity.this.finish();
                        }
                    });
                    aVar3.a(false);
                    aVar3.c();
                } else {
                    e.a aVar4 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar4.a("Permission Error");
                    aVar4.b("From Android M onwards, we require sms permission to set alert for a particular contact. Please grant the permission for smooth functioning of the app or else you won't be able to set alerts for contacts.");
                    aVar4.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            AlertSpecPropActivity.this.requestPermissions(new String[]{"android.permission.READ_SMS"}, 103);
                        }
                    });
                    aVar4.a(false);
                    aVar4.c();
                }
                break;
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onResume() {
        super.onResume();
        CLog.a("IOTA", "resume");
        if (this.J == null || !this.J.isShowing()) {
            try {
                if (this.u == 4 && this.p.isProviderEnabled("gps") && !this.r) {
                    this.q = new ProgressDialog(this);
                    this.q.setMessage("Fetching your location to add an alert");
                    this.q.setIndeterminate(true);
                    this.q.setCancelable(true);
                    this.q.show();
                    if (this.g == null || !this.g.isConnected()) {
                        return;
                    }
                    i();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                CLog.a("IOTA", e2.getMessage());
                finish();
            }
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.g != null) {
            this.g.connect();
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.g == null || !this.g.isConnected()) {
            return;
        }
        this.g.disconnect();
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
        ArrayList<com.cube26.iota.smartlite.b.h> arrayListA;
        String strE = null;
        switch (i) {
            case 4100:
                try {
                    arrayListA = com.cube26.iota.smartlite.b.h.a(new ByteArrayInputStream(lVar.e().k().toString().getBytes()), getApplicationContext());
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    arrayListA = null;
                }
                try {
                    if (arrayListA == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Internet Connectivity");
                        builder.setCancelable(false);
                        builder.setMessage("We couldn't connect to internet.Please check your internet connection");
                        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecPropActivity.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                AlertSpecPropActivity.this.finish();
                            }
                        });
                        this.J = builder.create();
                        this.J.show();
                    } else {
                        CLog.a("IOTA", " onpostexecute name" + this.H);
                        try {
                            String strF = null;
                            HashMap<String, ArrayList<String>> mapH = null;
                            for (com.cube26.iota.smartlite.b.h hVar : arrayListA) {
                                CLog.a("IOTA", "widgetModel name " + hVar.i());
                                if (hVar.i().equalsIgnoreCase(this.H)) {
                                    strF = hVar.f();
                                    mapH = hVar.h();
                                    strE = com.cube26.iota.smartlite.b.h.e(strF);
                                    K = hVar.g();
                                }
                                mapH = mapH;
                                strF = strF;
                                strE = strE;
                            }
                            String strSubstring = strF.substring(0, strF.indexOf("<dd>"));
                            y = strSubstring;
                            CLog.b("IOTA", "if text : " + strSubstring);
                            CLog.b("IOTA", "types: " + mapH.size());
                            this.v.setText(strSubstring);
                            if (this.u == 4) {
                                strF.indexOf("</dd>");
                            }
                            ArrayList<String> arrayList = mapH.get(strE);
                            z = arrayList;
                            CLog.a("IOTA", "temp: " + arrayList);
                            x = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, arrayList);
                            x.setDropDownViewResource(R.layout.spinner_item);
                            this.s.setAdapter((SpinnerAdapter) x);
                            this.C.setEnabled(true);
                            getWindow().clearFlags(16);
                            this.I.setVisibility(4);
                            this.D.a(this.u, arrayList);
                        } catch (Exception e3) {
                            CLog.a("IOTA", "exception caught");
                            return;
                        }
                    }
                } catch (Exception e4) {
                    CLog.a("IOTA", "null token exception");
                    return;
                }
                break;
        }
    }
}
