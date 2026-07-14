package com.cube26.iota.smartlite.AlertViews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.a.e;
import android.support.v7.a.f;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.h;
import com.getbase.floatingactionbutton.AddFloatingActionButton;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class AlertSpecificActivity extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f2864f;
    private static final int[] l = {R.drawable.call, R.drawable.sms, R.drawable.youtube, R.drawable.weather, R.drawable.whatsapp, R.drawable.hike, R.drawable.ola, R.drawable.ola, R.drawable.facebook, R.drawable.tinder, R.drawable.tinder, R.drawable.dominos, R.drawable.bigbasket, R.drawable.grofers, R.drawable.swiggy};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AddFloatingActionButton f2865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListView f2866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f2867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.cube26.iota.smartlite.AlertViews.a f2868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Cursor f2869e;
    private ProgressDialog g;
    private CoordinatorLayout h;
    private LinearLayout i;
    private ImageView j;
    private ImageView k;

    private class a extends AsyncTask<Integer[], Void, Void> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private InputStream f2879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2882e;

        private a() {
            this.f2879b = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Integer[]... numArr) {
            Integer[] numArr2 = numArr[0];
            this.f2881d = numArr2[1].intValue();
            this.f2882e = numArr2[0].intValue();
            this.f2880c = a();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            if (AlertSpecificActivity.this.g.isShowing()) {
                AlertSpecificActivity.this.g.dismiss();
            }
            if (this.f2880c) {
                com.cube26.iota.smartlite.AlertViews.a.a(this.f2881d, this.f2882e, 0);
                AlertSpecificActivity.this.f2867c.g(this.f2882e);
                AlertSpecificActivity.this.h();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertSpecificActivity.this);
                builder.setTitle("Internet Connectivity");
                builder.setCancelable(false);
                builder.setMessage("We couldn't unsubscribe alert.\nPlease check your internet connection.");
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.a.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
        }

        public boolean a() {
            if (h.e(AlertSpecificActivity.this)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
                    httpURLConnection.setRequestProperty("User-Agent", "Test");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setConnectTimeout(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    httpURLConnection.connect();
                    this.f2880c = httpURLConnection.getResponseCode() == 200;
                    return this.f2880c;
                } catch (SocketTimeoutException e2) {
                    CLog.a("IOTA", " socket timeout");
                } catch (IOException e3) {
                    CLog.a("IOTA", "Error checking internet connection", e3);
                }
            } else {
                CLog.a("IOTA", "No network available!");
            }
            this.f2880c = false;
            return this.f2880c;
        }
    }

    private void a(Cursor cursor) {
        this.f2868d = new com.cube26.iota.smartlite.AlertViews.a(this, cursor, true);
        this.f2866b.setAdapter((ListAdapter) this.f2868d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Cursor cursorD = this.f2867c.d(f2864f);
        CLog.a("IOTA", this.f2869e.getCount() + "on resume");
        this.f2868d.changeCursor(cursorD);
        if (cursorD.getCount() > this.f2868d.a()) {
            CLog.a("IOTA", "adding new alert into status list");
            this.f2868d.b();
        }
        this.f2868d.notifyDataSetChanged();
        CLog.a("IOTA", "notifying data set change");
    }

    private boolean i() {
        String string = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(getPackageName());
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_alert_specific);
        CLog.a("IOTA", "on create");
        this.f2867c = new com.cube26.iota.smartlite.a.a(getApplicationContext());
        this.f2866b = (ListView) findViewById(R.id.alerts_list);
        this.i = (LinearLayout) findViewById(R.id.emptyView);
        this.j = (ImageView) findViewById(R.id.no_alert_image_holder_1);
        this.k = (ImageView) findViewById(R.id.no_alert_image_holder_2);
        this.f2866b.addFooterView(getLayoutInflater().inflate(R.layout.alert_list_footer, (ViewGroup) null), null, false);
        int intExtra = getIntent().getIntExtra("recipe_id", -1);
        if (intExtra != -1) {
            f2864f = intExtra;
        }
        this.j.setImageResource(l[f2864f - 1]);
        this.k.setImageResource(l[f2864f - 1]);
        CLog.a("IOTA", "specific recipe_id" + f2864f);
        String str = b.f2943a[f2864f - 1];
        c().b(true);
        c().a(true);
        if (str.equalsIgnoreCase("Youtube_channel")) {
            c().a(Html.fromHtml("<font color='#596475'>YouTube alert</font>"));
        } else {
            c().a(Html.fromHtml("<font color='#596475'>" + b.f2943a[f2864f - 1] + " alert</font>"));
        }
        this.h = (CoordinatorLayout) findViewById(R.id.alert_spec_page);
        this.f2865a = (AddFloatingActionButton) findViewById(R.id.edit_prop);
        this.f2865a.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(AlertSpecificActivity.this, (Class<?>) AlertSpecPropActivity.class);
                if (AlertSpecificActivity.f2864f == 9) {
                    intent = new Intent(AlertSpecificActivity.this, (Class<?>) FacebookAlertActivity.class);
                }
                intent.putExtra("recipe_id", AlertSpecificActivity.f2864f);
                intent.putExtra("mode", "new");
                AlertSpecificActivity.this.startActivity(intent);
            }
        });
        this.f2867c = new com.cube26.iota.smartlite.a.a(getApplicationContext());
        this.f2869e = this.f2867c.d(f2864f);
        this.f2869e.moveToFirst();
        while (!this.f2869e.isAfterLast()) {
            CLog.b("IOTA", "sentence " + this.f2869e.getString(this.f2869e.getColumnIndex("alert_sentence")) + " alert status " + this.f2869e.getInt(this.f2869e.getColumnIndex("alert_status")));
            this.f2869e.moveToNext();
        }
        CLog.b("IOTA", "alert cursor count" + this.f2869e.getCount());
        a(this.f2869e);
        CLog.b("IOTA", "setting custom adapter");
        this.f2866b.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                Snackbar.a(AlertSpecificActivity.this.h, "Delete alert ?", -1).a("Confirm", new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AlertSpecificActivity.this.f2868d.a(i);
                        Cursor cursorD = AlertSpecificActivity.this.f2867c.d(AlertSpecificActivity.f2864f);
                        cursorD.moveToPosition(i);
                        if (!cursorD.isAfterLast()) {
                            int i2 = cursorD.getInt(cursorD.getColumnIndex(Constants.SMS_COLUMN_ID));
                            int i3 = cursorD.getInt(cursorD.getColumnIndex("user_recipe_id"));
                            CLog.b("IOTA", " confirm to delete id " + i2);
                            CLog.a("IOTA", " user _recipe _id " + i3);
                            if (cursorD.getInt(cursorD.getColumnIndex("alert_status")) == 1 && (AlertSpecificActivity.f2864f == 3 || AlertSpecificActivity.f2864f == 4)) {
                                Integer[] numArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                                AlertSpecificActivity.this.g = new ProgressDialog(AlertSpecificActivity.this);
                                AlertSpecificActivity.this.g.setMessage("Unsubscribing alert");
                                AlertSpecificActivity.this.g.setCancelable(false);
                                AlertSpecificActivity.this.g.show();
                                new a().execute(numArr);
                            } else {
                                AlertSpecificActivity.this.f2867c.g(i2);
                                Cursor cursorD2 = AlertSpecificActivity.this.f2867c.d(AlertSpecificActivity.f2864f);
                                AlertSpecificActivity.this.f2868d.changeCursor(cursorD2);
                                if (cursorD2.getCount() > AlertSpecificActivity.this.f2869e.getCount()) {
                                    AlertSpecificActivity.this.f2868d.b();
                                }
                                CLog.a("IOTA", AlertSpecificActivity.this.f2869e.getCount() + "on dismiss");
                                AlertSpecificActivity.this.f2868d.notifyDataSetChanged();
                            }
                            if (AlertSpecificActivity.this.f2867c.d(AlertSpecificActivity.f2864f).getCount() > 0) {
                                AlertSpecificActivity.this.i.setVisibility(8);
                            } else {
                                AlertSpecificActivity.this.i.setVisibility(0);
                            }
                        }
                        if (AlertSpecificActivity.f2864f == 8 || AlertSpecificActivity.f2864f == 7 || AlertSpecificActivity.f2864f == 11 || AlertSpecificActivity.f2864f == 12 || AlertSpecificActivity.f2864f == 13 || AlertSpecificActivity.f2864f == 14 || AlertSpecificActivity.f2864f == 15) {
                            AlertSpecificActivity.this.f2865a.setVisibility(0);
                        }
                    }
                }).a();
                return true;
            }
        });
        this.f2866b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Cursor cursorD = AlertSpecificActivity.this.f2867c.d(AlertSpecificActivity.f2864f);
                cursorD.moveToPosition(i);
                int i2 = cursorD.getInt(cursorD.getColumnIndex(Constants.SMS_COLUMN_ID));
                Intent intent = new Intent(AlertSpecificActivity.this, (Class<?>) EditAlertActivity.class);
                if (AlertSpecificActivity.f2864f == 9) {
                    intent = new Intent(AlertSpecificActivity.this, (Class<?>) FacebookAlertActivity.class);
                    intent.putExtra("mode", "edit");
                }
                intent.putExtra("row_id", i2);
                intent.putExtra("recipe_id", AlertSpecificActivity.f2864f);
                AlertSpecificActivity.this.startActivity(intent);
            }
        });
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        CLog.a("IOTA", " permissions result ");
        switch (i) {
            case 200:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D");
                } else if (!shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                    e.a aVar = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar.a("Permission Denial");
                    aVar.b("Contacts Access has not been granted & we require contact for call and sms alerts .Are you sure you want to deny the permission ?");
                    aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", AlertSpecificActivity.this.getPackageName(), null));
                            AlertSpecificActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            AlertSpecificActivity.this.finish();
                        }
                    });
                    aVar.a(false);
                    aVar.c();
                } else {
                    e.a aVar2 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar2.a("Permission Error");
                    aVar2.b("From Android M onwards, we require contacts access permission to read your contacts. Please grant the permission for smooth functioning of the app or else you won't be able to connect Lite with the smartphone.");
                    aVar2.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            AlertSpecificActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 200);
                        }
                    });
                    aVar2.a(false);
                    aVar2.c();
                }
                break;
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onResume() {
        super.onResume();
        CLog.b("IOTA", "on resume");
        CLog.a("IOTA", "recipe id " + f2864f);
        CLog.a("IOTA", "recipe cursor count " + this.f2869e.getCount());
        this.f2869e = this.f2867c.d(f2864f);
        if (this.f2869e.getCount() > 0) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        if ((f2864f == 7 || f2864f == 8 || f2864f == 11 || f2864f == 12 || f2864f == 13 || f2864f == 14 || f2864f == 15) && this.f2869e.getCount() == 1) {
            CLog.a("IOTA", " already an alert present");
            this.f2865a.setVisibility(4);
        }
        if (com.cube26.iota.smartlite.AlertViews.a.f2922c) {
            CLog.a("IOTA", "setting switch " + com.cube26.iota.smartlite.AlertViews.a.f2924e);
            if (i()) {
                this.f2867c.a(com.cube26.iota.smartlite.AlertViews.a.f2924e, 1);
                this.f2868d.a(com.cube26.iota.smartlite.AlertViews.a.f2923d, true);
            } else {
                this.f2867c.a(com.cube26.iota.smartlite.AlertViews.a.f2924e, 0);
                this.f2868d.a(com.cube26.iota.smartlite.AlertViews.a.f2923d, false);
            }
            com.cube26.iota.smartlite.AlertViews.a.f2922c = false;
        }
        h();
    }
}
