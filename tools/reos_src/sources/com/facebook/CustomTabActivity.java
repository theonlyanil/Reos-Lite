package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3488a = CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3489b = CustomTabActivity.class.getSimpleName() + ".action_destroy";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f3490c;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(f3488a);
            intent2.putExtra(CustomTabMainActivity.f3494c, getIntent().getDataString());
            android.support.v4.b.j.a(this).a(intent2);
            this.f3490c = new BroadcastReceiver() { // from class: com.facebook.CustomTabActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent3) {
                    CustomTabActivity.this.finish();
                }
            };
            android.support.v4.b.j.a(this).a(this.f3490c, new IntentFilter(f3489b));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) CustomTabMainActivity.class);
        intent.setAction(f3488a);
        intent.putExtra(CustomTabMainActivity.f3494c, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        android.support.v4.b.j.a(this).a(this.f3490c);
        super.onDestroy();
    }
}
