package com.cube26.iota.smartlite.AlertViews;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
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
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.ColorCodeChangeListener;
import com.cube26.iota.smartlite.util.d;
import com.cube26.iota.smartlite.util.h;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class EditAlertActivity extends f {
    private static final String[] k = {"Fade in", "Fade out", "Candle Flicker", "Strobe", "Kaleidoscope"};
    private static final String[] l = {"Fade in", "Fade out", "Flash Alert"};
    private static int o = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f2888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditText f2889f;
    private TextView g;
    private Spinner h;
    private Spinner i;
    private ImageButton j;
    private ArrayList<String> m;
    private ArrayList<String> n;
    private int p;
    private String q;
    private int r;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private Button w;
    private ImageView x;
    private ImageView y;
    private ArrayList<byte[]> z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Cursor f2884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2885b = 2015;
    private boolean s = false;

    public static boolean a(String str) {
        return (str == null || str.isEmpty() || str.trim().isEmpty()) ? false : true;
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        CLog.a("IOTA", "result code " + i);
        if (i != 2015 || i2 != -1) {
            this.h.setSelection(this.m.size() - 2);
            return;
        }
        Cursor cursorQuery = getContentResolver().query(intent.getData(), null, null, null, null);
        cursorQuery.moveToFirst();
        int columnIndex = cursorQuery.getColumnIndex("data1");
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
        byte[] bArrA = h.a(this, Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("contact_id"))));
        CLog.b("IOTA", "contact picked with name" + string + " and number " + cursorQuery.getString(columnIndex));
        if (this.f2887d != 5) {
            if (this.m.contains(string)) {
                CLog.a("IOTA", string + " already contained at index :: " + this.m.indexOf(string));
                this.z.add(this.m.indexOf(string), bArrA);
                this.h.setSelection(this.m.indexOf(string));
                return;
            } else {
                this.m.add(0, string);
                this.n.add(0, cursorQuery.getString(columnIndex));
                this.z.add(0, bArrA);
                this.h.setSelection(0);
                return;
            }
        }
        CLog.a("IOTA", " id 5");
        if (this.f2884a != null && this.f2884a.getCount() > 0) {
            CLog.a("IOTA", " whatsapp cursor not null");
            this.f2884a.moveToFirst();
            while (true) {
                if (this.f2884a.isAfterLast()) {
                    z = false;
                    break;
                }
                String string2 = this.f2884a.getString(this.f2884a.getColumnIndex("display_name"));
                CLog.a("IOTA", "whatsapp :: " + string2);
                if (string2.equals(string)) {
                    CLog.a("IOTA", "is whatsapp contact loop::false");
                    z = true;
                    break;
                }
                this.f2884a.moveToNext();
            }
        } else {
            z = false;
            break;
        }
        CLog.a("IOTA", "is whatsapp contact ::" + z);
        if (z) {
            this.m.add(0, string);
            this.n.add(0, cursorQuery.getString(columnIndex));
            this.z.add(0, bArrA);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contact");
        builder.setCancelable(true);
        if (this.f2887d == 5) {
            builder.setMessage("Selected contact is not on WhatsApp");
            this.h.setSelection(this.m.size() - 2);
        }
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        builder.create().show();
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        byte[] bArrA;
        int i;
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f2886c = intent.getIntExtra("row_id", -1);
        this.f2887d = intent.getIntExtra("recipe_id", -1);
        if (this.f2887d == 3) {
            setContentView(R.layout.layout_youtube);
        } else {
            setContentView(R.layout.activity_alert_spec_prop);
        }
        if (this.f2887d == 3) {
            c().a(Html.fromHtml("<font color='#596475'>YouTube</font>"));
        } else {
            c().a(Html.fromHtml("<font color='#596475'>" + b.f2943a[this.f2887d - 1] + "</font>"));
        }
        c().c(true);
        c().a(true);
        c().b(true);
        this.f2888e = new com.cube26.iota.smartlite.a.a(this);
        c.a().a(this);
        this.g = (TextView) findViewById(R.id.if_holder_text);
        TextView textView = (TextView) findViewById(R.id.if_suffix_holder);
        TextView textView2 = (TextView) findViewById(R.id.if_holder_text);
        this.f2889f = (EditText) findViewById(R.id.sentence_header);
        this.h = (Spinner) findViewById(R.id.type_holder);
        this.i = (Spinner) findViewById(R.id.prop_transition_picker);
        this.j = (ImageButton) findViewById(R.id.color_picker);
        this.t = (ImageView) findViewById(R.id.alert_preview_color);
        this.v = (TextView) findViewById(R.id.static_color_text);
        this.w = (Button) findViewById(R.id.prop_save);
        this.y = (ImageView) findViewById(R.id.recipe_view);
        this.x = (ImageView) findViewById(R.id.recipe_type_view);
        ((ProgressBar) findViewById(R.id.progressBar)).setVisibility(4);
        this.n = new ArrayList<>();
        this.z = new ArrayList<>();
        this.f2889f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        this.x.setImageResource(h.h[this.f2887d - 1]);
        this.i.setAdapter((SpinnerAdapter) (this.f2887d == 1 ? new ArrayAdapter(this, R.layout.spinner_item, k) : new ArrayAdapter(this, R.layout.spinner_item, l)));
        this.i.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                switch (i2) {
                    case 0:
                        EditAlertActivity.this.t.setImageResource(android.R.color.transparent);
                        break;
                    case 1:
                        EditAlertActivity.this.t.setImageResource(android.R.color.transparent);
                        break;
                    case 2:
                        if (!EditAlertActivity.this.i.getSelectedItem().toString().equals("Flash Alert")) {
                            EditAlertActivity.this.t.setImageResource(R.drawable.candle);
                        } else {
                            EditAlertActivity.this.t.setImageResource(R.drawable.flash_dummy);
                        }
                        break;
                    case 3:
                        EditAlertActivity.this.t.setImageResource(R.drawable.strobe);
                        break;
                    case 4:
                        EditAlertActivity.this.t.setImageResource(R.drawable.kaleidoscope);
                        break;
                }
                if (i2 <= 1) {
                    EditAlertActivity.this.t.setBackground(d.a(EditAlertActivity.o, 1, 1));
                    EditAlertActivity.this.j.setVisibility(0);
                    EditAlertActivity.this.v.setVisibility(0);
                } else {
                    CLog.a("IOTA", "disabling color picker");
                    EditAlertActivity.this.j.setVisibility(4);
                    EditAlertActivity.this.v.setVisibility(4);
                    EditAlertActivity.this.t.setBackground(d.a(android.R.color.transparent, 0, 1));
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (this.f2887d == 3 || this.f2887d == 4) {
            this.h.setEnabled(false);
        } else {
            this.h.setEnabled(true);
        }
        this.h.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                CLog.b("IOTA", "item selected position" + i2);
                String string = adapterView.getItemAtPosition(i2).toString();
                if (EditAlertActivity.this.f2887d == 5 || EditAlertActivity.this.f2887d == 1 || EditAlertActivity.this.f2887d == 2 || EditAlertActivity.this.f2887d == 6 || EditAlertActivity.this.f2887d == 8 || EditAlertActivity.this.f2887d == 12 || EditAlertActivity.this.f2887d == 13 || EditAlertActivity.this.f2887d == 14 || EditAlertActivity.this.f2887d == 15) {
                    if (string.equals("Select Contact")) {
                        CLog.b("IOTA", "fetching contact");
                        EditAlertActivity.this.s = true;
                        int iCheckSelfPermission = Build.VERSION.SDK_INT > 22 ? EditAlertActivity.this.checkSelfPermission("android.permission.READ_CONTACTS") : 1;
                        if (Build.VERSION.SDK_INT <= 22 || iCheckSelfPermission == 0) {
                            EditAlertActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                            if (EditAlertActivity.this.f2887d == 5) {
                                EditAlertActivity.this.f2884a = EditAlertActivity.this.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"display_name"}, "account_type = ? ", new String[]{"com.whatsapp"}, null);
                            }
                        } else {
                            EditAlertActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 101);
                        }
                    } else if (i2 == EditAlertActivity.this.m.size() - 2) {
                        EditAlertActivity.this.y.setImageResource(R.drawable.anyone_dummy);
                    } else if (EditAlertActivity.this.z.get(i2) != null) {
                        CLog.a("IOTA", " stream not null");
                        EditAlertActivity.this.y.setImageBitmap(h.a(BitmapFactory.decodeStream(new ByteArrayInputStream((byte[]) EditAlertActivity.this.z.get(i2)))));
                    } else {
                        CLog.a("IOTA", " stream null");
                        EditAlertActivity.this.y.setImageResource(R.drawable.anyone_dummy);
                    }
                }
                if (EditAlertActivity.this.f2887d == 4) {
                    EditAlertActivity.this.y.setImageResource(d.f3461b[i2]);
                }
                if (EditAlertActivity.this.f2887d == 3) {
                    EditAlertActivity.this.y.setImageResource(d.f3460a[i2]);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                CLog.b("IOTA", "nothing selected");
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate = LayoutInflater.from(EditAlertActivity.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(EditAlertActivity.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                EditAlertActivity.this.u = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.5.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        EditAlertActivity.this.t.setBackground(d.a(EditAlertActivity.o, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
        Cursor cursorE = this.f2888e.e(this.f2886c);
        cursorE.moveToFirst();
        String string = cursorE.getString(cursorE.getColumnIndex("alert_sentence"));
        String string2 = cursorE.getString(cursorE.getColumnIndex("alert_description"));
        int i2 = cursorE.getInt(cursorE.getColumnIndex("alert_color"));
        String string3 = cursorE.getString(cursorE.getColumnIndex("alert_transition"));
        String string4 = cursorE.getString(cursorE.getColumnIndex("alert_type"));
        String string5 = cursorE.getString(cursorE.getColumnIndex("alert_contact_name"));
        String string6 = cursorE.getString(cursorE.getColumnIndex("alert_contact_number"));
        byte[] blob = cursorE.getBlob(cursorE.getColumnIndex("alert_contact_blob"));
        this.p = cursorE.getInt(cursorE.getColumnIndex("alert_status"));
        CLog.a("IOTA", " contact blob :: " + blob);
        if ((this.f2887d == 1 || this.f2887d == 2) && !string5.equals("Anyone") && blob == null && Build.VERSION.SDK_INT > 22 && checkSelfPermission("android.permission.READ_CONTACTS") == 0 && (bArrA = h.a(this, Long.parseLong(h.a(this, string6)))) != null) {
            blob = bArrA;
        }
        this.n.add(0, string6);
        this.z.add(0, blob);
        o = i2;
        String[] strArr = this.f2887d == 1 ? k : l;
        int i3 = 0;
        while (i3 < strArr.length && !strArr[i3].equals(string3)) {
            i3++;
        }
        CLog.a("IOTA", " selected transition index " + i3);
        this.i.setSelection(i3);
        this.f2889f.setText(string);
        this.f2889f.setSelection(this.f2889f.getText().length());
        this.g.setText(string2);
        this.t.setBackground(d.a(o, 0, 1));
        if (this.f2887d < 3 || this.f2887d == 5 || this.f2887d == 6) {
            this.m = new ArrayList<>();
            this.m.add("Anyone");
            this.m.add("Select Contact");
            if (!string5.equals("Anyone")) {
                this.m.add(0, string5);
            }
        } else if (this.f2887d == 3 || this.f2887d == 4) {
            this.m = this.f2888e.f(this.f2887d);
        }
        switch (this.f2887d) {
            case 1:
                textView.setText("calls me");
                break;
            case 2:
            case 5:
            case 6:
                textView.setText("texts me");
                break;
            case 7:
                textView2.setText("When my ola arrives");
                this.h.setVisibility(4);
                break;
            case 8:
                textView2.setText("When my uber arrives");
                this.h.setVisibility(4);
                break;
            case 11:
                textView2.setText("If I match someone on Tinder");
                this.h.setVisibility(4);
                break;
            case 12:
                textView2.setText("When my food arrives");
                this.h.setVisibility(4);
                break;
            case 13:
                textView2.setText("When my food arrives");
                this.h.setVisibility(4);
                break;
            case 14:
                textView2.setText("When my food arrives");
                this.h.setVisibility(4);
                break;
            case 15:
                textView2.setText("When my food arrives");
                this.h.setVisibility(4);
                break;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, this.m);
        if (this.f2887d == 7 || this.f2887d == 8) {
            this.g.setText("When my " + (this.f2887d == 7 ? "ola" : "uber") + " arrives");
            this.h.setVisibility(8);
        } else if (this.f2887d == 11 || this.f2887d == 12 || this.f2887d == 13 || this.f2887d == 14 || this.f2887d == 15) {
            this.h.setVisibility(8);
        } else {
            this.h.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        if (this.f2887d == 3 || this.f2887d == 4) {
            int i4 = 0;
            while (true) {
                i = i4;
                if (i < this.m.size() && !this.m.get(i).equals(string4)) {
                    i4 = i + 1;
                }
            }
            this.h.setSelection(i);
        }
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i5;
                String str;
                String string7;
                String str2;
                int i6;
                byte[] bArr = null;
                String str3 = (String) EditAlertActivity.this.h.getSelectedItem();
                CLog.b("IOTA", "type :" + str3);
                String str4 = (String) EditAlertActivity.this.i.getSelectedItem();
                String string8 = EditAlertActivity.this.f2889f.getText().toString();
                String string9 = EditAlertActivity.this.g.getText().toString();
                int i7 = EditAlertActivity.o;
                CLog.a("IOTA", "color value prior alert insertion:" + EditAlertActivity.o);
                if (!EditAlertActivity.a(string8)) {
                    Toast.makeText(EditAlertActivity.this.getApplicationContext(), "Create Sentence .. !", 0).show();
                    return;
                }
                if ((i7 == 0 || i7 == 1) && EditAlertActivity.this.i.getSelectedItemPosition() < 2) {
                    Toast.makeText(EditAlertActivity.this.getApplicationContext(), "Select transition color .. !", 0).show();
                    return;
                }
                if (EditAlertActivity.this.f2887d == 3 || EditAlertActivity.this.f2887d == 4 || EditAlertActivity.this.f2887d == 8 || EditAlertActivity.this.f2887d == 7 || EditAlertActivity.this.f2887d == 11 || EditAlertActivity.this.f2887d == 12 || EditAlertActivity.this.f2887d == 13 || EditAlertActivity.this.f2887d == 14 || EditAlertActivity.this.f2887d == 15) {
                    i5 = i7;
                    str = null;
                    string7 = null;
                    str2 = str3;
                } else {
                    string7 = EditAlertActivity.this.h.getSelectedItem().toString();
                    if (str4.equals("Fade in") || str4.equals("Fade out")) {
                        CLog.a("IOTA", "transition value :" + str4);
                        CLog.a("IOTA", "touched RGB :" + EditAlertActivity.o);
                        i6 = EditAlertActivity.o;
                    } else {
                        i6 = 0;
                    }
                    if (string7.equals("Anyone")) {
                        i5 = i6;
                        str = null;
                        str2 = null;
                    } else {
                        byte[] bArr2 = (byte[]) EditAlertActivity.this.z.get(EditAlertActivity.this.h.getSelectedItemPosition());
                        i5 = i6;
                        str = (String) EditAlertActivity.this.n.get(EditAlertActivity.this.h.getSelectedItemPosition());
                        str2 = null;
                        bArr = bArr2;
                    }
                }
                CLog.b("IOTA", "adding alert :" + EditAlertActivity.this.f2887d + " " + str2 + " " + i5 + " " + str4 + " " + string8 + " " + string7 + " " + str + " " + EditAlertActivity.this.q + " " + EditAlertActivity.this.r + " description " + string9);
                if (EditAlertActivity.this.f2888e.a(EditAlertActivity.this.f2886c, EditAlertActivity.this.f2887d, str2, Integer.valueOf(i5), str4, string8, string7, str, EditAlertActivity.this.q, EditAlertActivity.this.r, string9, EditAlertActivity.this.p, bArr)) {
                    EditAlertActivity.this.finish();
                }
            }
        });
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        int i;
        int i2;
        int i3 = 255;
        try {
            o = colorCodeChangeListener.f3421a;
            int iRed = Color.red(o);
            int iGreen = Color.green(o);
            int iBlue = Color.blue(o);
            if (iRed < 235 || iGreen < 235 || iBlue < 235) {
                i3 = iBlue;
                i = iGreen;
                i2 = iRed;
            } else {
                o = Color.rgb(255, 255, 255);
                i = 255;
                i2 = 255;
            }
            CLog.a("IOTA", "Dialog " + ("R: " + i2 + " B: " + i3 + " G: " + i));
            this.u.setBackground(d.a(colorCodeChangeListener.f3421a, 0, 1));
        } catch (Exception e2) {
        }
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.support.v4.app.a.InterfaceC0010a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 101:
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D :: + pickconta" + this.s);
                    if ((this.f2887d == 1 || this.f2887d == 2 || this.f2887d == 5 || this.f2887d == 6) && this.s) {
                        this.s = false;
                        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                        this.f2884a = getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"display_name"}, "account_type = ? ", new String[]{"com.whatsapp"}, null);
                    } else if (this.s) {
                        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 2015);
                    }
                } else {
                    this.h.setSelection(this.m.size() - 2);
                    if (!shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                        e.a aVar = new e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar.a("Permission Denial");
                        aVar.b("Contacts access has not been granted & we require contacts access to set an alert .Are you sure you want to deny the permission?");
                        aVar.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", EditAlertActivity.this.getPackageName(), null));
                                EditAlertActivity.this.startActivityForResult(intent, 100);
                            }
                        });
                        aVar.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.9
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                EditAlertActivity.this.finish();
                            }
                        });
                        aVar.a(false);
                        aVar.c();
                    } else {
                        e.a aVar2 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                        aVar2.a("Permission Error");
                        aVar2.b("From Android M onwards, we require contacts permission to set alert for a particular contact. Please grant the permission for smooth functioning of the app or else you won't be able to set alerts for contacts.");
                        aVar2.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.10
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                EditAlertActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 101);
                            }
                        });
                        aVar2.a(false);
                        aVar2.c();
                    }
                }
                break;
            case 103:
                CLog.a("IOTA", " read sms");
                this.h.setSelection(this.m.size() - 2);
                if (iArr.length > 0 && iArr[0] == 0) {
                    CLog.a("IOTA", "Permission Granted :D");
                } else if (!shouldShowRequestPermissionRationale("android.permission.READ_SMS")) {
                    e.a aVar3 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar3.a("Permission Denial");
                    aVar3.b("Sms access has not been granted & we require sms access to set an alert .Are you sure you want to deny the permission?");
                    aVar3.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", EditAlertActivity.this.getPackageName(), null));
                            EditAlertActivity.this.startActivityForResult(intent, 100);
                        }
                    });
                    aVar3.b("I'M Sure", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            EditAlertActivity.this.finish();
                        }
                    });
                    aVar3.a(false);
                    aVar3.c();
                } else {
                    e.a aVar4 = new e.a(this, R.style.AppCompatAlertDialogStyle);
                    aVar4.a("Permission Error");
                    aVar4.b("From Android M onwards, we require sms permission to set alert for a particular contact. Please grant the permission for smooth functioning of the app or else you won't be able to set alerts for contacts.");
                    aVar4.a("Retry", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.EditAlertActivity.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            EditAlertActivity.this.requestPermissions(new String[]{"android.permission.READ_SMS"}, 103);
                        }
                    });
                    aVar4.a(false);
                    aVar4.c();
                }
                break;
        }
    }
}
