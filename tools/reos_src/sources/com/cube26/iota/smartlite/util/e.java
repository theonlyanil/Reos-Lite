package com.cube26.iota.smartlite.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.android.apps.config.Config;
import com.android.library.appusage.AppUsage;
import com.android.library.rmnlibrary.GCMListenerService;
import com.android.library.rmnlibrary.RMNRegistrationService;
import com.android.library.userprofile.util.Constants;
import com.android.library.userprofile.util.UtilFunctions;
import com.cube26.iota.smartlite.R;
import com.google.android.gms.plus.PlusShare;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(Context context) {
        try {
            com.android.library.deviceData.b.init(context);
            UtilFunctions.init(context);
            AppUsage.init(context);
            c(context);
        } catch (Exception e2) {
        }
    }

    public static void b(Context context) {
        try {
            b.a("IOTA", " on boot libs");
            com.android.library.deviceData.b.onBoot(context);
            UtilFunctions.onBoot(context);
            AppUsage.onBoot(context);
            c(context);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        h.a(context, str, PendingIntent.getActivity(context, new Random().nextInt(100), new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())), 134217728));
    }

    public static void c(final Context context) {
        Intent intent = new Intent(context, (Class<?>) RMNRegistrationService.class);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_SENDER_ID, "433584691981");
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_DRAWABLE_ID, R.drawable.lite);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_GCM_APPEND_URL, "gcm-register");
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_YOUTUBE_API_KEY, "AIzaSyBCR_PuyEdYRlgexify3fTIrbwWBc9rg2Q");
        context.startService(intent);
        GCMListenerService.a("reoslite", new com.android.library.rmnlibrary.a.a() { // from class: com.cube26.iota.smartlite.util.e.1
            @Override // com.android.library.rmnlibrary.a.a
            public void a(String str, String str2) {
                boolean z;
                String str3;
                String str4;
                String str5;
                int i;
                String str6;
                Exception e2;
                String str7;
                String string;
                boolean z2;
                com.cube26.iota.smartlite.a.a aVar = new com.cube26.iota.smartlite.a.a(context);
                b.a("IOTA", "" + str2);
                try {
                    JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.RESPONSE).getJSONObject("alert_message");
                    if (jSONObject.has("is_update_available")) {
                        z2 = jSONObject.getBoolean(Constants.SMS_COLUMN_STATUS);
                        try {
                            string = jSONObject.getString("message");
                            str7 = null;
                            str5 = str7;
                            String str8 = string;
                            z = z2;
                            str4 = str8;
                        } catch (JSONException e3) {
                            str3 = null;
                            e = e3;
                            z = z2;
                            e.printStackTrace();
                            str4 = null;
                            str5 = str3;
                        }
                    } else {
                        String string2 = jSONObject.getString("data");
                        try {
                            String string3 = jSONObject.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
                            str7 = string2;
                            string = string3;
                            z2 = false;
                            str5 = str7;
                            String str9 = string;
                            z = z2;
                            str4 = str9;
                        } catch (JSONException e4) {
                            e = e4;
                            str3 = string2;
                            z = false;
                            e.printStackTrace();
                            str4 = null;
                            str5 = str3;
                        }
                    }
                } catch (JSONException e5) {
                    e = e5;
                    z = false;
                    str3 = null;
                }
                if (z) {
                    e.b(context, str4);
                    return;
                }
                b.a("IOTA", str5 + " message " + str4);
                try {
                    JSONArray jSONArray = new JSONArray(str5);
                    int iNextInt = new Random().nextInt(jSONArray.length());
                    b.a("IOTA", " randomly picked recipe id " + jSONArray.getString(iNextInt));
                    i = Integer.parseInt(jSONArray.getString(iNextInt));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                    i = -1;
                }
                try {
                    Cursor cursorI = aVar.i(i);
                    cursorI.moveToFirst();
                    String string4 = cursorI.getString(cursorI.getColumnIndex("alert_transition"));
                    int[] iArrA = h.a(cursorI.getInt(cursorI.getColumnIndex("alert_color")));
                    str6 = cursorI.getInt(cursorI.getColumnIndex("recipe_id")) == 3 ? str4 + " on " + cursorI.getString(cursorI.getColumnIndex("alert_type")) : str4;
                    for (int i2 = 0; i2 < h.v.size(); i2++) {
                        try {
                            h.a(iArrA[0], iArrA[1], iArrA[2], 200, i2, "Phone", string4);
                        } catch (Exception e7) {
                            e2 = e7;
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e8) {
                    str6 = str4;
                    e2 = e8;
                }
                b.b("IOTA", "Received message :: " + str6);
                h.a(context, str6, (PendingIntent) null);
            }
        });
    }
}
