package com.cube26.iota.smartlite.AlertViews;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.d;
import com.cube26.iota.smartlite.util.h;
import f.l;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends CursorAdapter implements HTTPLibrary.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2922c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f2923d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f2924e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f2925f;
    static int g;
    static String h;
    static String i;
    static Dialog j;
    static int k;
    private static Context m;
    private static a n;
    public final ArrayList<Boolean> l;
    private final com.cube26.iota.smartlite.a.a o;
    private AlertDialog p;
    private int q;
    private int r;
    private String s;
    private double t;
    private double u;

    /* JADX INFO: renamed from: com.cube26.iota.smartlite.AlertViews.a$a, reason: collision with other inner class name */
    private class C0056a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f2937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f2938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f2939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ImageView f2940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ImageView f2941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Switch f2942f;

        private C0056a() {
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.q = -1;
        this.r = -1;
        this.t = 0.0d;
        this.u = 0.0d;
        m = context;
        n = this;
        this.o = new com.cube26.iota.smartlite.a.a(context);
        this.l = new ArrayList<>(cursor.getCount());
        a(cursor);
    }

    private int a(JsonReader jsonReader) throws Exception {
        int iNextInt = -1;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("user_recipe_id")) {
                    iNextInt = jsonReader.nextInt();
                    CLog.a("IOTA", "user_recipe_id :" + iNextInt);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        }
        jsonReader.endArray();
        return iNextInt;
    }

    private int a(JSONObject jSONObject) {
        int iA;
        Exception e2;
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(jSONObject.toString().getBytes(Charset.forName("UTF-8"))), "UTF-8"));
            jsonReader.beginObject();
            iA = 0;
            while (jsonReader.hasNext()) {
                try {
                    if (jsonReader.nextName().equals(Config.RESPONSE)) {
                        CLog.a("IOTA", " parsing response");
                        iA = a(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
            }
            jsonReader.endObject();
        } catch (Exception e4) {
            iA = 0;
            e2 = e4;
        }
        return iA;
    }

    public static void a(int i2, int i3, int i4) {
        JSONObject jSONObject;
        ProgressDialog progressDialog = new ProgressDialog(m);
        progressDialog.setMessage("Unsubscribing alert");
        progressDialog.setCancelable(false);
        progressDialog.show();
        j = progressDialog;
        f2925f = i3;
        k = i4;
        CLog.a("IOTA", "unsubscribe alert");
        String str = "{ \"user_recipes\": [\"" + i2 + "\"] }";
        CLog.a("IOTA", "delete json " + str);
        String string = m.getSharedPreferences("USERIDPrefs", 0).getString("user_id", "DEFAULT");
        CLog.a("IOTA", " user id " + string);
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        HTTPLibrary.post(m, n, 4002, h.b.f3478b, h.b.f3480d + string + "/recipes/delete", jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str, String str2, String str3) {
        JSONObject jSONObject;
        f2925f = i2;
        g = i3;
        h = str;
        i = str2;
        ProgressDialog progressDialog = new ProgressDialog(m);
        progressDialog.setMessage("Subscribing alert");
        progressDialog.setCancelable(false);
        progressDialog.show();
        j = progressDialog;
        String string = m.getSharedPreferences("USERIDPrefs", 0).getString("user_id", "DEFAULT");
        CLog.a("IOTA", " user id " + string);
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        HTTPLibrary.post(m, this, 4001, h.b.f3478b, h.b.f3480d + string + "/recipes", jSONObject, null);
    }

    private void a(Cursor cursor) {
        cursor.moveToFirst();
        for (int i2 = 0; i2 < cursor.getCount(); i2++) {
            this.l.add(i2, Boolean.valueOf(1 == cursor.getInt(cursor.getColumnIndex("alert_status"))));
            cursor.moveToNext();
        }
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.q;
        aVar.q = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        String string = Settings.Secure.getString(m.getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(m.getPackageName());
    }

    static /* synthetic */ int h(a aVar) {
        int i2 = aVar.r;
        aVar.r = i2 + 1;
        return i2;
    }

    public int a() {
        return this.l.size();
    }

    public void a(int i2) {
        if (i2 == -1 || i2 >= this.l.size()) {
            return;
        }
        this.l.remove(i2);
    }

    public void a(int i2, boolean z) {
        this.l.set(i2, Boolean.valueOf(z));
    }

    public void b() {
        this.l.add(false);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, final Context context, final Cursor cursor) {
        ByteArrayInputStream byteArrayInputStream;
        C0056a c0056a = (C0056a) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("alert_sentence"));
        int i2 = cursor.getInt(cursor.getColumnIndex("recipe_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("alert_transition"));
        String string3 = cursor.getString(cursor.getColumnIndex("alert_contact_name"));
        String string4 = cursor.getString(cursor.getColumnIndex("alert_color"));
        String string5 = cursor.getString(cursor.getColumnIndex("alert_type"));
        String string6 = cursor.getString(cursor.getColumnIndex("alert_contact_number"));
        if (i2 == 1 || i2 == 2 || i2 == 5 || i2 == 6) {
            if (string3.equals("Anyone")) {
                c0056a.f2939c.setImageResource(R.drawable.anyone_dummy);
            } else if (Build.VERSION.SDK_INT <= 22) {
                String strA = h.a(context, string6);
                byte[] bArrA = strA != null ? h.a(context, Long.parseLong(strA)) : null;
                if (bArrA != null) {
                    c0056a.f2939c.setImageBitmap(h.a(BitmapFactory.decodeStream(new ByteArrayInputStream(bArrA))));
                }
            } else if (context.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
                String strA2 = h.a(context, string6);
                byte[] bArrA2 = strA2 != null ? h.a(context, Long.parseLong(strA2)) : null;
                if (bArrA2 == null || (byteArrayInputStream = new ByteArrayInputStream(bArrA2)) == null) {
                    c0056a.f2939c.setImageResource(R.drawable.anyone_dummy);
                } else {
                    c0056a.f2939c.setImageBitmap(h.a(BitmapFactory.decodeStream(byteArrayInputStream)));
                }
            } else {
                c0056a.f2939c.setImageResource(R.drawable.anyone_dummy);
            }
        } else if (i2 == 9) {
            CLog.a("IOTA", "alertAttribute :: " + string3);
            if (string3.equals(FacebookAlertActivity.f2905a[0])) {
                c0056a.f2939c.setImageResource(R.drawable.fb_photos_dummy);
            } else if (string3.equals(FacebookAlertActivity.f2905a[1])) {
                c0056a.f2939c.setImageResource(R.drawable.fb_video_dummy);
            } else if (string3.equals(FacebookAlertActivity.f2905a[2])) {
                c0056a.f2939c.setImageResource(R.drawable.fb_post_dummy);
            } else if (string3.equals(FacebookAlertActivity.f2905a[3])) {
                c0056a.f2939c.setImageResource(R.drawable.fb_comment_dummy);
            } else if (string3.equals(FacebookAlertActivity.f2905a[4])) {
                c0056a.f2939c.setImageResource(R.drawable.fb_link_dummy);
            }
        } else if (i2 == 11) {
            c0056a.f2939c.setImageResource(R.drawable.tinder_dummy);
        } else if (i2 == 7) {
            c0056a.f2939c.setImageResource(R.drawable.ola);
        } else if (i2 == 4) {
            if (string5.equals("Rainy")) {
                c0056a.f2939c.setImageResource(R.drawable.rainy_dummy);
            } else if (string5.equals("Sunny")) {
                c0056a.f2939c.setImageResource(R.drawable.sunny_dummy);
            } else if (string5.equals("Cloudy")) {
                c0056a.f2939c.setImageResource(R.drawable.cloudy_dummy);
            } else if (string5.equals("Foggy")) {
                c0056a.f2939c.setImageResource(R.drawable.foggy_dummy);
            } else if (string5.equals("Thunder-Storm")) {
                c0056a.f2939c.setImageResource(R.drawable.thunderstorm_dummy);
            } else if (string5.equals("Flurries")) {
                c0056a.f2939c.setImageResource(R.drawable.flurries_dummy);
            } else if (string5.equals("Snowy")) {
                c0056a.f2939c.setImageResource(R.drawable.snowy_dummy);
            } else if (string5.equals("Windy")) {
                c0056a.f2939c.setImageResource(R.drawable.windy_dummy);
            }
        } else if (i2 == 3) {
            if (string5.equals("Vevo")) {
                c0056a.f2939c.setImageResource(R.drawable.vevo);
            } else if (string5.equals("Times Music")) {
                c0056a.f2939c.setImageResource(R.drawable.times_music);
            } else if (string5.equals("T-Series")) {
                c0056a.f2939c.setImageResource(R.drawable.t_series);
            } else if (string5.equals("Tips Music")) {
                c0056a.f2939c.setImageResource(R.drawable.tips_music);
            } else if (string5.equals("Musictoday")) {
                c0056a.f2939c.setImageResource(R.drawable.music_today);
            } else if (string5.equals("Saregama GenY")) {
                c0056a.f2939c.setImageResource(R.drawable.saregama_geny);
            } else if (string5.equals("Sony Music India")) {
                c0056a.f2939c.setImageResource(R.drawable.sony_music);
            } else if (string5.equals("SonyMusicIndiaVEVO")) {
                c0056a.f2939c.setImageResource(R.drawable.sony_music_vevo);
            } else if (string5.equals("Blue Frog")) {
                c0056a.f2939c.setImageResource(R.drawable.bluefrog);
            } else if (string5.equals("Eros Now")) {
                c0056a.f2939c.setImageResource(R.drawable.eros_now);
            }
        }
        c0056a.f2940d.setImageResource(h.h[i2 - 1]);
        int i3 = cursor.getInt(cursor.getColumnIndex(Constants.SMS_COLUMN_ID));
        CLog.b("IOTA", " _id :" + i3);
        c0056a.f2937a.setText(string);
        c0056a.f2937a.setTextColor(-16777216);
        c0056a.f2938b.setText(string2);
        if (i2 != 1) {
            c0056a.f2941e.setImageResource(android.R.color.transparent);
            c0056a.f2941e.setBackground(d.a(Integer.parseInt(string4), 0, 1));
        } else if (string2.equals("Strobe")) {
            c0056a.f2941e.setImageResource(R.drawable.strobe);
            c0056a.f2941e.setBackground(d.a(android.R.color.transparent, 0, 1));
        } else if (string2.equals("Candle Flicker")) {
            c0056a.f2941e.setImageResource(R.drawable.candle);
            c0056a.f2941e.setBackground(d.a(android.R.color.transparent, 0, 1));
        } else if (string2.equals("Kaleidoscope")) {
            c0056a.f2941e.setImageResource(R.drawable.kaleidoscope);
            c0056a.f2941e.setBackground(d.a(android.R.color.transparent, 0, 1));
        } else {
            c0056a.f2941e.setImageResource(android.R.color.transparent);
            c0056a.f2941e.setBackground(d.a(Integer.parseInt(string4), 0, 1));
        }
        if (string2.equals("Flash Alert")) {
            c0056a.f2941e.setImageResource(R.drawable.flash_dummy);
            c0056a.f2941e.setBackground(d.a(android.R.color.transparent, 0, 1));
        }
        final int position = cursor.getPosition();
        c0056a.f2942f.setTag(Integer.valueOf(i3));
        c0056a.f2942f.setOnCheckedChangeListener(null);
        c0056a.f2942f.setChecked(this.l.get(position).booleanValue());
        c0056a.f2942f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.AlertViews.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean z) {
                CLog.a("IOTA", "on checked change listener");
                int iIntValue = ((Integer) compoundButton.getTag()).intValue();
                cursor.moveToPosition(position);
                a.f2920a = position;
                a.f2921b = z;
                CLog.b("IOTA", "row _id switch " + iIntValue + " cursor position " + cursor.getPosition());
                int i4 = cursor.getInt(cursor.getColumnIndex("recipe_id"));
                CLog.a("IOTA", " sub alert :: " + a.this.q);
                if (i4 != 3 && i4 != 4) {
                    CLog.a("IOTA", " checked status :: " + z);
                    String str = "";
                    switch (i4) {
                        case 5:
                            str = "WhatsApp";
                            break;
                        case 6:
                            str = "Hike";
                            break;
                        case 8:
                            str = "Uber";
                            break;
                        case 12:
                            str = "Domino's";
                            break;
                        case 13:
                            str = "bigbasket";
                            break;
                        case 14:
                            str = "Grofers";
                            break;
                        case 15:
                            str = "Swiggy";
                            break;
                    }
                    if (i4 >= 5 && z && !a.this.c()) {
                        a.f2924e = iIntValue;
                        a.f2923d = position;
                        CLog.a("IOTA", " access _id :: " + iIntValue);
                        CLog.a("IOTA", " notificationAlert :: " + a.this.r);
                        a.h(a.this);
                        if (a.this.r % 2 == 0) {
                            a.this.r = 0;
                        }
                        if (a.this.r == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("Notification Access");
                            builder.setCancelable(false);
                            builder.setMessage("Lite app requires notification access for " + str + " alerts");
                            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.a.1.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i5) {
                                    if (!z) {
                                        compoundButton.setChecked(true);
                                    } else {
                                        compoundButton.setChecked(false);
                                        a.h(a.this);
                                    }
                                }
                            });
                            builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.a.1.3
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i5) {
                                    a.h(a.this);
                                    a.f2922c = true;
                                    context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                                }
                            });
                            builder.create().show();
                        }
                    } else if (z) {
                        CLog.a("IOTA", "checked");
                        a.this.o.a(iIntValue, 1);
                    } else {
                        CLog.a("IOTA", "unchecked");
                        a.this.o.a(iIntValue, 0);
                    }
                } else if (h.e(context)) {
                    CLog.a("IOTA", "checking b " + z);
                    if (z && (i4 == 3 || i4 == 4)) {
                        int i5 = cursor.getInt(cursor.getColumnIndex("recipe_api_id"));
                        String string7 = cursor.getString(cursor.getColumnIndex("recipe_unique_name"));
                        String string8 = cursor.getString(cursor.getColumnIndex("alert_type"));
                        CLog.a("IOTA", "key " + string7 + " value " + string8);
                        String string9 = cursor.getString(cursor.getColumnIndex("lat_value"));
                        String string10 = cursor.getString(cursor.getColumnIndex("long_value"));
                        int i6 = cursor.getInt(cursor.getColumnIndex(Constants.SMS_COLUMN_ID));
                        CLog.a("IOTA", "row_id" + i6);
                        switch (i4) {
                            case 3:
                                a.this.s = "{\"user_recipes\": [ { \"recipe_id\":" + i5 + ",\"recipe_config\": { \"channel_name\": \"" + string8 + "\"}} ]}";
                                break;
                            case 4:
                                a.this.s = "{\"user_recipes\": [ { \"recipe_id\":" + i5 + ",\"recipe_config\": { \"weather_type\": \"" + string8 + "\" , \"lat\":" + string9 + " , \"long\":" + string10 + "}} ]}";
                                break;
                        }
                        a.this.a(i6, i5, string7, string8, a.this.s);
                    } else if (i4 == 3 || i4 == 4) {
                        Cursor cursorQuery = a.this.o.getReadableDatabase().query("Alerts", null, " _id = ? ", new String[]{String.valueOf(iIntValue)}, null, null, null);
                        cursorQuery.moveToFirst();
                        int i7 = cursorQuery.getInt(cursorQuery.getColumnIndex("user_recipe_id"));
                        CLog.a("IOTA", " user recipe id " + i7);
                        a.a(i7, iIntValue, 1);
                    }
                } else {
                    a.b(a.this);
                    if (a.this.q % 2 == 0) {
                        a.this.q = 0;
                    }
                    if (a.this.q == 0) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                        builder2.setTitle("Internet Connectivity");
                        builder2.setCancelable(false);
                        builder2.setMessage("Your internet is off.To " + (z ? "subscribe" : "unsubscribe") + ", please connect to internet");
                        builder2.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.a.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i8) {
                                if (a.this.p == null || !a.this.p.isShowing()) {
                                    return;
                                }
                                a.this.p.dismiss();
                                if (z) {
                                    compoundButton.setChecked(false);
                                } else {
                                    compoundButton.setChecked(true);
                                }
                            }
                        });
                        a.this.p = builder2.create();
                        a.this.p.show();
                    }
                }
                a.this.l.set(position, Boolean.valueOf(z));
                CLog.a("IOTA", "adding alert status at position :: " + position + " :: " + z);
            }
        });
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.custom_alert_item, viewGroup, false);
        C0056a c0056a = new C0056a();
        c0056a.f2937a = (TextView) viewInflate.findViewById(R.id.alert_title);
        c0056a.f2942f = (Switch) viewInflate.findViewById(R.id.alert_switch);
        c0056a.f2938b = (TextView) viewInflate.findViewById(R.id.alert_effect);
        c0056a.f2941e = (ImageView) viewInflate.findViewById(R.id.alert_preview_color);
        c0056a.f2939c = (ImageView) viewInflate.findViewById(R.id.alert_recipe_view);
        c0056a.f2940d = (ImageView) viewInflate.findViewById(R.id.alert_recipe_type_view);
        viewInflate.setTag(c0056a);
        return viewInflate;
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i2, l<com.google.a.l> lVar) {
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i2, l<com.google.a.l> lVar) {
        JSONObject jSONObject;
        switch (i2) {
            case 4001:
                try {
                    jSONObject = new JSONObject(lVar.e().k().toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject = null;
                }
                this.o.b(f2925f, a(jSONObject));
                this.o.a(f2925f, 1);
                j.dismiss();
                break;
            case 4002:
                try {
                    new JSONObject(lVar.e().k().toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                com.cube26.iota.smartlite.a.a aVar = new com.cube26.iota.smartlite.a.a(m);
                if (k == 0) {
                    aVar.g(f2925f);
                } else {
                    aVar.a(f2925f, 0);
                }
                j.dismiss();
                break;
        }
    }
}
