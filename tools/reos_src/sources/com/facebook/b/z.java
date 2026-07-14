package com.facebook.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class z implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f3842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Messenger f3844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3845f;
    private int g;
    private final String h;
    private final int i;

    public interface a {
        void a(Bundle bundle);
    }

    public z(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f3840a = applicationContext != null ? applicationContext : context;
        this.f3845f = i;
        this.g = i2;
        this.h = str;
        this.i = i3;
        this.f3841b = new Handler() { // from class: com.facebook.b.z.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                z.this.a(message);
            }
        };
    }

    private void b(Bundle bundle) {
        if (this.f3843d) {
            this.f3843d = false;
            a aVar = this.f3842c;
            if (aVar != null) {
                aVar.a(bundle);
            }
        }
    }

    private void c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.h);
        a(bundle);
        Message messageObtain = Message.obtain((Handler) null, this.f3845f);
        messageObtain.arg1 = this.i;
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(this.f3841b);
        try {
            this.f3844e.send(messageObtain);
        } catch (RemoteException e2) {
            b(null);
        }
    }

    protected abstract void a(Bundle bundle);

    protected void a(Message message) {
        if (message.what == this.g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                b(null);
            } else {
                b(data);
            }
            try {
                this.f3840a.unbindService(this);
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public void a(a aVar) {
        this.f3842c = aVar;
    }

    public boolean a() {
        Intent intentA;
        if (this.f3843d || y.b(this.i) == -1 || (intentA = y.a(this.f3840a)) == null) {
            return false;
        }
        this.f3843d = true;
        this.f3840a.bindService(intentA, this, 1);
        return true;
    }

    public void b() {
        this.f3843d = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3844e = new Messenger(iBinder);
        c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f3844e = null;
        try {
            this.f3840a.unbindService(this);
        } catch (IllegalArgumentException e2) {
        }
        b(null);
    }
}
