package com.cube26.iota.smartlite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.e;
import android.support.v7.a.f;
import android.text.Html;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.c;
import com.android.apps.config.util.CLog;
import com.appyvet.rangebar.RangeBar;
import com.cube26.iota.smartlite.b.d;
import com.cube26.iota.smartlite.util.ColorCodeChangeListener;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UpdateMode extends f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f3134a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f3135b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f3136c = false;
    private TextView I;
    private ImageView J;
    private int K;
    private ImageView N;
    private int P;
    private TextView Q;
    private TextView R;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    EditText f3139f;
    EditText g;
    RangeBar k;
    RangeBar l;
    Button m;
    ImageView v;
    c x;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f3137d = new int[12];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Bundle f3138e = new Bundle();
    boolean h = false;
    boolean i = false;
    boolean j = false;
    boolean n = false;
    boolean o = false;
    boolean p = false;
    boolean q = false;
    d r = new d();
    ImageView[] s = new ImageView[6];
    ArrayList<d> t = new ArrayList<>();
    final com.cube26.iota.smartlite.a.a u = new com.cube26.iota.smartlite.a.a(this);
    int w = -1;
    boolean y = false;
    boolean z = false;
    boolean A = false;
    c.a.a.a.a B = null;
    private e C = null;
    private int D = 10;
    private int E = 10;
    private int F = 0;
    private int G = 0;
    private final int[] H = new int[6];
    private int L = 0;
    private int M = -1;
    private int O = 0;
    private StringBuilder S = new StringBuilder("");
    private a T = new a(this);
    private int U = Color.parseColor("#a1ff0000");
    private int V = Color.parseColor("#a1ff009c");
    private int W = Color.parseColor("#a14100ff");
    private int X = Color.parseColor("#a10056ff");
    private int Y = Color.parseColor("#a1ffa700");
    private int Z = Color.parseColor("#a100ff4c");
    private int aa = Color.parseColor("#00000000");
    private int ab = Color.parseColor("#ff6a00");
    private ImageView[] ac = new ImageView[6];
    private ImageView[] ad = new ImageView[6];
    private CheckBox[] ae = new CheckBox[6];
    private TextView[] af = new TextView[6];
    private int[] ag = {this.U, this.V, this.W, this.X, this.Y, this.Z};
    private int[] ah = {this.aa, this.aa, this.aa, this.aa, this.aa, this.aa};

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f3158b;

        public a(Context context) {
            this.f3158b = context;
            CLog.a("IOTA", "Size of thumbs" + h.S.length);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return h.S.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            CLog.a("IOTA", "image get view ");
            if (view == null) {
                imageView = new ImageView(this.f3158b);
                imageView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setPadding(20, 20, 20, 20);
            } else {
                imageView = (ImageView) view;
            }
            imageView.setImageResource(h.S[i].intValue());
            if (i == UpdateMode.this.O) {
                CLog.a("IOTA", " selected icon position " + UpdateMode.this.O);
                imageView.setColorFilter(Color.argb(255, 255, 255, 255));
                imageView.setBackground(com.cube26.iota.smartlite.util.d.a(UpdateMode.this.ab, 0, 1));
            } else {
                imageView.setColorFilter(Color.argb(255, 117, 117, 117));
                imageView.setBackgroundColor(UpdateMode.this.aa);
            }
            return imageView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        CLog.a("IOTA", " removedcolorposition :: " + i + " ::  chosencoloposition :: " + this.L);
        while (i < this.L - 1) {
            this.ah[i] = this.ah[i + 1];
            this.ad[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ah[i], 0, 1));
            if (this.R.getVisibility() == 0) {
                this.ae[i].setVisibility(0);
            }
            this.ae[i].setChecked(this.ae[i + 1].isChecked());
            this.af[i].setVisibility(0);
            this.af[i].setVisibility(this.af[i + 1].getVisibility());
            i++;
        }
        this.ah[this.L - 1] = this.aa;
        this.ad[this.L - 1].setBackground(com.cube26.iota.smartlite.util.d.a(this.aa, 1, 1));
    }

    private void b(int i) {
        if (i < this.L) {
            this.ad[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ah[i], 5, 1));
            if (this.N.getVisibility() == 0 && this.M == i) {
                this.N.setVisibility(4);
                this.ad[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ah[i], 1, 1));
            } else {
                this.M = i;
                if (this.M < this.L) {
                    l();
                }
            }
        }
    }

    static /* synthetic */ int g(UpdateMode updateMode) {
        int i = updateMode.L;
        updateMode.L = i + 1;
        return i;
    }

    private void g() {
        this.I = (TextView) findViewById(R.id.pick_icon);
        this.f3139f = (EditText) findViewById(R.id.modenameedit);
        this.g = (EditText) findViewById(R.id.modedescedit);
        this.k = (RangeBar) findViewById(R.id.intervalbar);
        this.l = (RangeBar) findViewById(R.id.speedbar);
        this.m = (Button) findViewById(R.id.createmode);
        this.v = (ImageView) findViewById(R.id.add);
        this.N = (ImageView) findViewById(R.id.remove_chosen_color);
        this.Q = (TextView) findViewById(R.id.enable_strobe);
        this.R = (TextView) findViewById(R.id.set_strobe);
    }

    private void h() {
        this.f3139f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMode.this.P = UpdateMode.this.O;
                UpdateMode.this.i();
            }
        });
        this.N.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMode.this.a(UpdateMode.this.M);
                UpdateMode.s(UpdateMode.this);
                UpdateMode.this.N.setVisibility(4);
                UpdateMode.this.ae[UpdateMode.this.L].setChecked(false);
                UpdateMode.this.ae[UpdateMode.this.L].setVisibility(4);
                UpdateMode.this.af[UpdateMode.this.L].setVisibility(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_icon_picker, (ViewGroup) null);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.dialog_icon_grid);
        gridView.setChoiceMode(1);
        gridView.setAdapter((ListAdapter) this.T);
        e.a aVar = new e.a(this);
        aVar.b(viewInflate);
        final e eVarB = aVar.b();
        eVarB.setCancelable(true);
        eVarB.show();
        TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVarB.dismiss();
                UpdateMode.this.O = UpdateMode.this.P;
                UpdateMode.this.I.setCompoundDrawablesWithIntrinsicBounds(UpdateMode.this.getApplicationContext().getResources().getDrawable(h.S[UpdateMode.this.P].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVarB.dismiss();
                UpdateMode.this.I.setCompoundDrawablesWithIntrinsicBounds(UpdateMode.this.getApplicationContext().getResources().getDrawable(h.S[UpdateMode.this.O].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UpdateMode.this.O = i;
                UpdateMode.this.T.notifyDataSetChanged();
            }
        });
        FlurryAgent.logEvent("mode_icon_change_icon_button_tapped");
    }

    private void j() {
        this.ac[0] = (ImageView) findViewById(R.id.gridcolor1);
        this.ac[1] = (ImageView) findViewById(R.id.gridcolor2);
        this.ac[2] = (ImageView) findViewById(R.id.gridcolor3);
        this.ac[3] = (ImageView) findViewById(R.id.gridcolor4);
        this.ac[4] = (ImageView) findViewById(R.id.gridcolor5);
        this.ac[5] = (ImageView) findViewById(R.id.gridcolor6);
        this.ad[0] = (ImageView) findViewById(R.id.colorchosen1);
        this.ad[1] = (ImageView) findViewById(R.id.colorchosen2);
        this.ad[2] = (ImageView) findViewById(R.id.colorchosen3);
        this.ad[3] = (ImageView) findViewById(R.id.colorchosen4);
        this.ad[4] = (ImageView) findViewById(R.id.colorchosen5);
        this.ad[5] = (ImageView) findViewById(R.id.colorchosen6);
        this.ae[0] = (CheckBox) findViewById(R.id.colorChecked1);
        this.ae[1] = (CheckBox) findViewById(R.id.colorChecked2);
        this.ae[2] = (CheckBox) findViewById(R.id.colorChecked3);
        this.ae[3] = (CheckBox) findViewById(R.id.colorChecked4);
        this.ae[4] = (CheckBox) findViewById(R.id.colorChecked5);
        this.ae[5] = (CheckBox) findViewById(R.id.colorChecked6);
        this.af[0] = (TextView) findViewById(R.id.colorStrobe1);
        this.af[1] = (TextView) findViewById(R.id.colorStrobe2);
        this.af[2] = (TextView) findViewById(R.id.colorStrobe3);
        this.af[3] = (TextView) findViewById(R.id.colorStrobe4);
        this.af[4] = (TextView) findViewById(R.id.colorStrobe5);
        this.af[5] = (TextView) findViewById(R.id.colorStrobe6);
        for (int i = 0; i < 6; i++) {
            this.ad[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ah[i], 1, 1));
            this.ad[i].setOnClickListener(this);
            this.ac[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ag[i], 0, 1));
            this.ac[i].setOnClickListener(this);
        }
    }

    private void k() {
        for (int i = 0; i < this.L; i++) {
            this.ad[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.ah[i], 0, 1));
        }
    }

    private void l() {
        if (this.L > 0) {
            this.N.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Toast.makeText(this, "You can only pick 6 colors.", 0).show();
    }

    static /* synthetic */ int s(UpdateMode updateMode) {
        int i = updateMode.L;
        updateMode.L = i - 1;
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.colorchosen1 /* 2131624276 */:
                if (this.L > 0) {
                    k();
                }
                b(0);
                break;
            case R.id.colorchosen2 /* 2131624277 */:
                if (this.L > 1) {
                    k();
                }
                b(1);
                break;
            case R.id.colorchosen3 /* 2131624278 */:
                if (this.L > 2) {
                    k();
                }
                b(2);
                break;
            case R.id.colorchosen4 /* 2131624279 */:
                if (this.L > 3) {
                    k();
                }
                b(3);
                break;
            case R.id.colorchosen5 /* 2131624280 */:
                if (this.L > 4) {
                    k();
                }
                b(4);
                break;
            case R.id.colorchosen6 /* 2131624281 */:
                if (this.L > 5) {
                    k();
                }
                b(5);
                break;
            case R.id.gridcolor1 /* 2131624300 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.U;
                    ImageView[] imageViewArr = this.ad;
                    int i = this.L;
                    this.L = i + 1;
                    imageViewArr[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.U, 0, 1));
                }
                break;
            case R.id.gridcolor2 /* 2131624301 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.V;
                    ImageView[] imageViewArr2 = this.ad;
                    int i2 = this.L;
                    this.L = i2 + 1;
                    imageViewArr2[i2].setBackground(com.cube26.iota.smartlite.util.d.a(this.V, 0, 1));
                }
                break;
            case R.id.gridcolor3 /* 2131624302 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.W;
                    ImageView[] imageViewArr3 = this.ad;
                    int i3 = this.L;
                    this.L = i3 + 1;
                    imageViewArr3[i3].setBackground(com.cube26.iota.smartlite.util.d.a(this.W, 0, 1));
                }
                break;
            case R.id.gridcolor4 /* 2131624303 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.X;
                    ImageView[] imageViewArr4 = this.ad;
                    int i4 = this.L;
                    this.L = i4 + 1;
                    imageViewArr4[i4].setBackground(com.cube26.iota.smartlite.util.d.a(this.X, 0, 1));
                }
                break;
            case R.id.gridcolor5 /* 2131624304 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.Y;
                    ImageView[] imageViewArr5 = this.ad;
                    int i5 = this.L;
                    this.L = i5 + 1;
                    imageViewArr5[i5].setBackground(com.cube26.iota.smartlite.util.d.a(this.Y, 0, 1));
                }
                break;
            case R.id.gridcolor6 /* 2131624305 */:
                if (this.L >= 6) {
                    m();
                } else {
                    if (this.R.getVisibility() == 0) {
                        this.ae[this.L].setVisibility(0);
                    }
                    this.ah[this.L] = this.Z;
                    ImageView[] imageViewArr6 = this.ad;
                    int i6 = this.L;
                    this.L = i6 + 1;
                    imageViewArr6[i6].setBackground(com.cube26.iota.smartlite.util.d.a(this.Z, 0, 1));
                }
                break;
        }
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.modecreation);
        c().c(true);
        c().b(true);
        c().a(Html.fromHtml("<font color='#596475'>Update Mode</font>"));
        this.x = c.a();
        this.x.a(this);
        g();
        h();
        this.t = this.u.a(getIntent().getExtras().getString("UpdateMood"));
        CLog.a("IOTA", " selected icon position :: " + this.t.get(0).e());
        if (this.t.get(0).f() != 0) {
            this.ah[0] = this.t.get(0).f();
            this.L++;
        }
        if (this.t.get(0).g() != 0) {
            this.ah[1] = this.t.get(0).g();
            this.L++;
        }
        if (this.t.get(0).h() != 0) {
            this.ah[2] = this.t.get(0).h();
            this.L++;
        }
        if (this.t.get(0).i() != 0) {
            this.ah[3] = this.t.get(0).i();
            this.L++;
        }
        if (this.t.get(0).j() != 0) {
            this.ah[4] = this.t.get(0).j();
            this.L++;
        }
        if (this.t.get(0).k() != 0) {
            this.ah[5] = this.t.get(0).k();
            this.L++;
        }
        j();
        this.f3139f.setText(this.t.get(0).c());
        this.f3139f.setSelection(this.f3139f.getText().length());
        this.g.setText(this.t.get(0).d());
        this.g.setSelection(this.g.getText().length());
        this.D = this.t.get(0).m();
        this.E = this.t.get(0).n();
        CLog.a("IOTA", " interval :: " + this.t.get(0).m());
        this.k.setSeekPinByValue(this.t.get(0).m());
        CLog.a("IOTA", " interval :: " + this.t.get(0).n());
        this.l.setSeekPinByValue(this.t.get(0).n());
        this.r.d("color");
        int iE = this.t.get(0).e();
        this.P = iE;
        this.O = iE;
        CLog.a("IOTA", " selected icon position :: " + this.O);
        this.S = new StringBuilder(this.t.get(0).a());
        for (int i = 0; i < 6; i++) {
            if (this.S.toString().contains(String.valueOf(i))) {
                this.ae[i].setChecked(true);
                this.af[i].setVisibility(0);
            }
        }
        this.I.setCompoundDrawablesWithIntrinsicBounds(getApplicationContext().getResources().getDrawable(h.S[this.O].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateMode.this.L >= 6) {
                    UpdateMode.this.m();
                    return;
                }
                View viewInflate = LayoutInflater.from(UpdateMode.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(UpdateMode.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                UpdateMode.this.J = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        if (UpdateMode.this.R.getVisibility() == 0) {
                            UpdateMode.this.ae[UpdateMode.this.L].setVisibility(0);
                        }
                        UpdateMode.this.ah[UpdateMode.this.L] = UpdateMode.this.K;
                        UpdateMode.this.ad[UpdateMode.g(UpdateMode.this)].setBackground(com.cube26.iota.smartlite.util.d.a(UpdateMode.this.K, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (com.cube26.iota.smartlite.d.a aVar : h.v) {
                    if (aVar.o() != null && !aVar.o().equals("1.04")) {
                        Toast.makeText(UpdateMode.this, "Color strobing is supported in the latest lite firmware. Please upgrade your lite firmware from its settings.", 1).show();
                        break;
                    }
                }
                UpdateMode.this.R.setVisibility(0);
                UpdateMode.this.Q.setVisibility(4);
                for (int i2 = 0; i2 < UpdateMode.this.L; i2++) {
                    UpdateMode.this.ae[i2].setVisibility(0);
                    UpdateMode.this.af[i2].setVisibility(4);
                }
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMode.this.S = new StringBuilder("");
                UpdateMode.this.R.setVisibility(4);
                UpdateMode.this.Q.setVisibility(0);
                for (int i2 = 0; i2 < 6; i2++) {
                    if (UpdateMode.this.ae[i2].isChecked()) {
                        UpdateMode.this.S.append(i2);
                        UpdateMode.this.af[i2].setVisibility(0);
                    }
                    UpdateMode.this.ae[i2].setVisibility(4);
                }
                FlurryAgent.logEvent("set_strobe_button_tapped");
                CLog.a("IOTA", " checkedpos ::" + ((Object) UpdateMode.this.S));
            }
        });
        this.k.setOnRangeBarChangeListener(new RangeBar.a() { // from class: com.cube26.iota.smartlite.UpdateMode.6
            @Override // com.appyvet.rangebar.RangeBar.a
            public void a(RangeBar rangeBar, int i2, int i3, String str, String str2) {
                UpdateMode.this.D = i3 * 10 * 2;
                UpdateMode.this.o = true;
                FlurryAgent.logEvent("mode_lumonisity_value_adjusted");
            }
        });
        this.l.setOnRangeBarChangeListener(new RangeBar.a() { // from class: com.cube26.iota.smartlite.UpdateMode.7
            @Override // com.appyvet.rangebar.RangeBar.a
            public void a(RangeBar rangeBar, int i2, int i3, String str, String str2) {
                UpdateMode.this.E = i3 * 10 * 2;
                UpdateMode.this.p = true;
                FlurryAgent.logEvent("mode_transition_time_adjusted");
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.UpdateMode.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMode.this.r = new d();
                UpdateMode.this.r.a(UpdateMode.this.S.toString());
                CLog.a("IOTA", "Name" + UpdateMode.this.f3139f.getText().toString() + "Desc" + UpdateMode.this.g.getText().toString() + "IconPos" + UpdateMode.this.F + "interval" + UpdateMode.this.D + "speed" + UpdateMode.this.E + "col" + UpdateMode.this.H[0] + "col2" + UpdateMode.this.H[1]);
                if (!h.a(UpdateMode.this.f3139f.getText().toString())) {
                    UpdateMode.this.f3139f.setError("Mood Name is required!");
                    UpdateMode.this.n = true;
                    return;
                }
                UpdateMode.this.f3139f.setError(null);
                UpdateMode.this.r.b(UpdateMode.this.f3139f.getText().toString());
                UpdateMode.this.n = false;
                if (UpdateMode.this.L == 0) {
                    Toast.makeText(UpdateMode.this, "Pick at least one color.", 0).show();
                    return;
                }
                if (UpdateMode.this.g.getText().toString().length() == 0) {
                    UpdateMode.this.r.c("");
                } else {
                    UpdateMode.this.g.setError(null);
                    UpdateMode.this.r.c(UpdateMode.this.g.getText().toString());
                    UpdateMode.this.n = false;
                }
                UpdateMode.this.r.b(UpdateMode.this.O);
                UpdateMode.this.r.d("color");
                UpdateMode.this.r.i(UpdateMode.this.D);
                UpdateMode.this.r.j(UpdateMode.this.E);
                if (UpdateMode.this.ah[0] != 0) {
                    UpdateMode.this.r.c(UpdateMode.this.ah[0]);
                } else {
                    UpdateMode.this.r.c(0);
                }
                if (UpdateMode.this.ah[1] != 0) {
                    UpdateMode.this.r.d(UpdateMode.this.ah[1]);
                } else {
                    UpdateMode.this.r.d(0);
                }
                if (UpdateMode.this.ah[2] != 0) {
                    UpdateMode.this.r.e(UpdateMode.this.ah[2]);
                } else {
                    UpdateMode.this.r.e(0);
                }
                if (UpdateMode.this.ah[3] != 0) {
                    UpdateMode.this.r.f(UpdateMode.this.ah[3]);
                } else {
                    UpdateMode.this.r.f(0);
                }
                if (UpdateMode.this.ah[4] != 0) {
                    UpdateMode.this.r.g(UpdateMode.this.ah[4]);
                } else {
                    UpdateMode.this.r.g(0);
                }
                if (UpdateMode.this.ah[5] != 0) {
                    UpdateMode.this.r.h(UpdateMode.this.ah[5]);
                } else {
                    UpdateMode.this.r.h(0);
                }
                if (UpdateMode.this.n) {
                    return;
                }
                UpdateMode.this.u.b(UpdateMode.this.r);
                CLog.a("IOTA", "Mode Updated Successfuly");
                UpdateMode.this.setResult(-1, new Intent(UpdateMode.this, (Class<?>) MainActivity.class));
                FlurryAgent.logEvent("mode_color_selected");
                UpdateMode.this.finish();
            }
        });
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        try {
            this.J.setBackground(com.cube26.iota.smartlite.util.d.a(colorCodeChangeListener.f3421a, 0, 1));
            this.K = colorCodeChangeListener.f3421a;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
