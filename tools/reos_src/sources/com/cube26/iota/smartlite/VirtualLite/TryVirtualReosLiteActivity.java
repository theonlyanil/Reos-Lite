package com.cube26.iota.smartlite.VirtualLite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.a.e;
import android.support.v7.a.f;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.g;
import com.google.b.e.a.b;

/* JADX INFO: loaded from: classes.dex */
public class TryVirtualReosLiteActivity extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f3207a;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        new com.google.b.e.a.a(this).c();
    }

    private void h() {
        this.f3207a.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.VirtualLite.TryVirtualReosLiteActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.a(TryVirtualReosLiteActivity.this, "android.permission.CAMERA")) {
                    TryVirtualReosLiteActivity.this.g();
                } else {
                    g.a(TryVirtualReosLiteActivity.this, "android.permission.CAMERA", 1001);
                }
            }
        });
    }

    private void i() {
        this.f3207a = (Button) findViewById(R.id.virtual_reos_lite_scan_qr_code_button);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        b bVarA = com.google.b.e.a.a.a(i, i2, intent);
        if (bVarA != null) {
            CLog.a("IOTA", " scan result");
            String strA = bVarA.a();
            if (strA == null) {
                return;
            }
            if (!strA.substring(0, 4).equalsIgnoreCase("REOS") || !strA.substring(strA.length() - 4, strA.length()).equalsIgnoreCase("LITE")) {
                Toast.makeText(this, "Invalid QR code. Please try again.", 0).show();
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
            intent2.putExtra("clientSessionId", strA.substring(10, strA.length() - 5));
            startActivity(intent2);
            finish();
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_try_virtual_reos_lite);
        i();
        h();
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 1001:
                if (iArr.length != 0 && iArr[0] != -1) {
                    g();
                } else if (android.support.v4.app.a.a((Activity) this, "android.permission.RECEIVE_SMS")) {
                    e.a aVar = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar.a("Permission Denial");
                    aVar.b("We require camera permission for scanning the QR code. Please provide the permission for scanning the QR code.");
                    aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.VirtualLite.TryVirtualReosLiteActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", TryVirtualReosLiteActivity.this.getPackageName(), null));
                            TryVirtualReosLiteActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar.a(false);
                    aVar.c();
                }
                break;
        }
    }
}
