package com.cube26.iota.smartlite.AlertViews;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FacebookAlertActivity extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2905a = {"photo", "video", "post", "comment", "link"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2906b = {"comments on my", "tags me in a", "shares a", "messages me", "sends me friend request", "accepts my friend request", "pokes me", "posts on my timeline"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2907c = {"Fade in", "Fade out", "Flash Alert"};
    private static final HashMap<String, ArrayList<String>> t = new HashMap<>();
    private static int u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EditText f2908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spinner f2909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f2910f;
    private Spinner g;
    private Button h;
    private ImageButton i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private String p;
    private com.cube26.iota.smartlite.a.a q;
    private int r;
    private int o = -1;
    private int s = -1;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList.add(f2905a[0]);
        arrayList.add(f2905a[1]);
        arrayList.add(f2905a[2]);
        arrayList.add(f2905a[4]);
        arrayList2.add(f2905a[0]);
        arrayList2.add(f2905a[2]);
        arrayList2.add(f2905a[3]);
        arrayList3.add(f2905a[4]);
        arrayList3.add(f2905a[2]);
        t.put(f2906b[0], arrayList);
        t.put(f2906b[1], arrayList2);
        t.put(f2906b[2], arrayList3);
    }

    private void i() {
        this.f2908d = (EditText) findViewById(R.id.alertTitle);
        this.f2909e = (Spinner) findViewById(R.id.alertAction);
        this.f2910f = (Spinner) findViewById(R.id.alertAttribute);
        this.g = (Spinner) findViewById(R.id.alertTransition);
        this.h = (Button) findViewById(R.id.alertSave);
        this.i = (ImageButton) findViewById(R.id.alertColor);
        this.j = (ImageView) findViewById(R.id.alert_preview_color);
        this.n = (TextView) findViewById(R.id.static_color_text);
        this.m = (ImageView) findViewById(R.id.recipe_view);
        this.l = (ImageView) findViewById(R.id.recipe_type_view);
        this.l.setImageResource(R.drawable.facebookactivated);
        this.f2908d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_facebook_alert);
        c().c(true);
        c().a(true);
        c().b(true);
        c().a(Html.fromHtml("<font color='#596475'>Facebook</font>"));
        i();
        this.p = getIntent().getStringExtra("mode");
        c.a().a(this);
        this.q = new com.cube26.iota.smartlite.a.a(this);
        this.f2909e.setAdapter((SpinnerAdapter) new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, f2906b));
        this.g.setAdapter((SpinnerAdapter) new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, f2907c));
        this.f2909e.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 3) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.anyone_dummy);
                    FacebookAlertActivity.this.f2910f.setEnabled(false);
                    FacebookAlertActivity.this.f2910f.setVisibility(8);
                    return;
                }
                FacebookAlertActivity.this.f2910f.setVisibility(0);
                FacebookAlertActivity.this.f2910f.setEnabled(true);
                FacebookAlertActivity.this.f2910f.setAdapter((SpinnerAdapter) new ArrayAdapter(FacebookAlertActivity.this.getApplicationContext(), R.layout.spinner_item, (List) FacebookAlertActivity.t.get(FacebookAlertActivity.f2906b[i])));
                if (FacebookAlertActivity.this.p.equals("edit")) {
                    FacebookAlertActivity.this.f2910f.setSelection(FacebookAlertActivity.u);
                    CLog.a("IOTA", " selectedAttributePosition :: " + FacebookAlertActivity.u);
                    int unused = FacebookAlertActivity.u = 0;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate = LayoutInflater.from(FacebookAlertActivity.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(FacebookAlertActivity.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                FacebookAlertActivity.this.k = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        FacebookAlertActivity.this.j.setBackground(d.a(FacebookAlertActivity.this.o, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
        this.g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    FacebookAlertActivity.this.j.setImageResource(android.R.color.transparent);
                    FacebookAlertActivity.this.j.setBackground(d.a(FacebookAlertActivity.this.o, 1, 1));
                    FacebookAlertActivity.this.n.setVisibility(0);
                    FacebookAlertActivity.this.i.setVisibility(0);
                    return;
                }
                CLog.a("IOTA", "disabling color picker");
                FacebookAlertActivity.this.n.setVisibility(4);
                FacebookAlertActivity.this.i.setVisibility(4);
                FacebookAlertActivity.this.j.setImageResource(R.drawable.flash_dummy);
                FacebookAlertActivity.this.j.setBackground(d.a(android.R.color.transparent, 0, 1));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                String string = FacebookAlertActivity.this.f2908d.getText().toString();
                int i2 = FacebookAlertActivity.this.o;
                String string2 = FacebookAlertActivity.this.f2909e.getSelectedItem().toString();
                String string3 = FacebookAlertActivity.this.f2910f.isEnabled() ? FacebookAlertActivity.this.f2910f.getSelectedItem().toString() : "null";
                String string4 = FacebookAlertActivity.this.g.getSelectedItem().toString();
                if (!h.a(string)) {
                    Toast.makeText(FacebookAlertActivity.this.getApplicationContext(), "Alert title can't be empty", 0).show();
                    return;
                }
                if ((i2 == 0 || i2 == -1) && FacebookAlertActivity.this.g.getSelectedItemPosition() < 2) {
                    Toast.makeText(FacebookAlertActivity.this.getApplicationContext(), "Select transition color", 0).show();
                    return;
                }
                if (string4.equals("Fade in") || string4.equals("Fade out")) {
                    CLog.a("IOTA", "transition value :" + string4);
                    CLog.a("IOTA", "touched RGB :" + FacebookAlertActivity.this.o);
                    i = FacebookAlertActivity.this.o;
                } else {
                    i = 0;
                }
                if (FacebookAlertActivity.this.p.equals("edit")) {
                    if (FacebookAlertActivity.this.q.a(FacebookAlertActivity.this.r, 9, string2, Integer.valueOf(i), string4, string, string3, (String) null, (String) null, -1, (String) null, FacebookAlertActivity.this.s, (byte[]) null)) {
                        FacebookAlertActivity.this.finish();
                    }
                } else if (FacebookAlertActivity.this.q.a(9, string2, Integer.valueOf(i), string4, string, string3, (String) null, (String) null, -1, (String) null, (String) null, (String) null, (byte[]) null)) {
                    FacebookAlertActivity.this.finish();
                }
            }
        });
        this.f2910f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                CLog.a("IOTA", " attribute selected " + i);
                String string = adapterView.getItemAtPosition(i).toString();
                if (string.equals("photo")) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.fb_photos_dummy);
                    return;
                }
                if (string.equals("video")) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.fb_video_dummy);
                    return;
                }
                if (string.equals("post")) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.fb_post_dummy);
                } else if (string.equals("link")) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.fb_link_dummy);
                } else if (string.equals("comment")) {
                    FacebookAlertActivity.this.m.setImageResource(R.drawable.fb_comment_dummy);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.j.setBackground(d.a(this.o, 0, 1));
        if (this.p.equals("edit")) {
            this.r = getIntent().getIntExtra("row_id", -1);
            Cursor cursorE = this.q.e(this.r);
            cursorE.moveToFirst();
            String string = cursorE.getString(cursorE.getColumnIndex("alert_sentence"));
            String string2 = cursorE.getString(cursorE.getColumnIndex("alert_type"));
            String string3 = cursorE.getString(cursorE.getColumnIndex("alert_contact_name"));
            int i = cursorE.getInt(cursorE.getColumnIndex("alert_color"));
            String string4 = cursorE.getString(cursorE.getColumnIndex("alert_transition"));
            this.s = cursorE.getInt(cursorE.getColumnIndex("alert_status"));
            this.f2908d.setText(string);
            CLog.a("IOTA", string + string2 + string3 + i + string4);
            int i2 = 0;
            while (i2 < f2906b.length) {
                if (f2906b[i2].equals(string2)) {
                    CLog.a("IOTA", " edit action :: " + i2);
                    break;
                }
                i2++;
            }
            this.f2909e.setSelection(i2);
            ArrayList<String> arrayList = t.get(f2906b[i2]);
            if (i2 < 3) {
                CLog.a("IOTA", " mapped list :: " + arrayList.toString());
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    if (arrayList.get(i3).equals(string3)) {
                        CLog.a("IOTA", " edit attribute :: " + i3);
                        break;
                    }
                    i3++;
                }
                this.f2910f.setVisibility(0);
                u = i3;
            } else {
                this.f2910f.setVisibility(8);
            }
            int i4 = 0;
            while (i4 < f2907c.length) {
                if (f2907c[i4].equals(string4)) {
                    CLog.a("IOTA", " edit transition :: " + i4);
                    break;
                }
                i4++;
            }
            this.g.setSelection(i4);
            if (this.g.getSelectedItemPosition() > 1) {
                this.i.setVisibility(4);
                this.n.setVisibility(4);
            } else {
                this.o = i;
                this.j.setBackground(d.a(this.o, 0, 1));
                this.n.setVisibility(0);
                this.i.setVisibility(0);
            }
        } else {
            this.f2908d.setText("Facebook alert");
        }
        this.f2908d.setSelection(this.f2908d.getText().length());
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        int i;
        int i2;
        int i3 = 255;
        try {
            this.o = colorCodeChangeListener.f3421a;
            CLog.a("IOTA", " touched color :: " + this.o);
            int iRed = Color.red(this.o);
            int iGreen = Color.green(this.o);
            int iBlue = Color.blue(this.o);
            if (iRed < 235 || iGreen < 235 || iBlue < 235) {
                i3 = iBlue;
                i = iGreen;
                i2 = iRed;
            } else {
                this.o = Color.rgb(255, 255, 255);
                CLog.a("IOTA", " white color :: " + this.o);
                i = 255;
                i2 = 255;
            }
            CLog.a("IOTA", "Dialog " + ("R: " + i2 + " B: " + i3 + " G: " + i));
            this.k.setBackground(d.a(colorCodeChangeListener.f3421a, 0, 1));
        } catch (NullPointerException e2) {
        } catch (Exception e3) {
        }
    }
}
