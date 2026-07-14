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

/* JADX INFO: loaded from: classes.dex */
public class ModeCreation extends f implements View.OnClickListener {
    private ImageView Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    EditText f3095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    EditText f3096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RangeBar f3097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    RangeBar f3098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Button f3099e;
    ImageView l;
    c m;
    private TextView r;
    private ImageView s;
    private int t;
    private TextView u;
    private TextView v;
    private int z;
    private int n = 10;
    private int o = 10;
    private int p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f3100f = false;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    final com.cube26.iota.smartlite.a.a j = new com.cube26.iota.smartlite.a.a(this);
    final d k = new d();
    private final int[] q = new int[6];
    private StringBuilder w = new StringBuilder("");
    private a x = new a(this);
    private int y = 0;
    private int A = Color.parseColor("#a1ff0000");
    private int B = Color.parseColor("#a1ff009c");
    private int C = Color.parseColor("#a14100ff");
    private int D = Color.parseColor("#a10056ff");
    private int E = Color.parseColor("#a1ffa700");
    private int F = Color.parseColor("#a100ff4c");
    private int G = Color.parseColor("#00000000");
    private int H = Color.parseColor("#ff6a00");
    private ImageView[] I = new ImageView[6];
    private ImageView[] J = new ImageView[6];
    private CheckBox[] K = new CheckBox[6];
    private TextView[] L = new TextView[6];
    private int[] M = {this.A, this.B, this.C, this.D, this.E, this.F};
    private int[] N = {this.G, this.G, this.G, this.G, this.G, this.G};
    private int O = 0;
    private int P = -1;

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f3119b;

        public a(Context context) {
            this.f3119b = context;
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
                imageView = new ImageView(this.f3119b);
                imageView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setPadding(20, 20, 20, 20);
            } else {
                imageView = (ImageView) view;
            }
            imageView.setImageResource(h.S[i].intValue());
            if (i == ModeCreation.this.y) {
                CLog.a("IOTA", " selected icon position " + ModeCreation.this.y);
                imageView.setColorFilter(Color.argb(255, 255, 255, 255));
                imageView.setBackground(com.cube26.iota.smartlite.util.d.a(ModeCreation.this.H, 0, 1));
            } else {
                imageView.setColorFilter(Color.argb(255, 117, 117, 117));
                imageView.setBackgroundColor(ModeCreation.this.G);
            }
            return imageView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        CLog.a("IOTA", " removedcolorposition :: " + i + " ::  chosencoloposition :: " + this.O);
        while (i < this.O - 1) {
            this.N[i] = this.N[i + 1];
            this.J[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.N[i], 0, 1));
            if (this.v.getVisibility() == 0) {
                this.K[i].setVisibility(0);
            }
            this.K[i].setChecked(this.K[i + 1].isChecked());
            this.L[i].setVisibility(0);
            this.L[i].setVisibility(this.L[i + 1].getVisibility());
            i++;
        }
        this.N[this.O - 1] = this.G;
        this.J[this.O - 1].setBackground(com.cube26.iota.smartlite.util.d.a(this.G, 1, 1));
    }

    private void b(int i) {
        if (i < this.O) {
            this.J[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.N[i], 5, 1));
            if (this.Q.getVisibility() == 0 && this.P == i) {
                this.Q.setVisibility(4);
                this.J[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.N[i], 1, 1));
            } else {
                this.P = i;
                if (this.P < this.O) {
                    l();
                }
            }
        }
    }

    static /* synthetic */ int g(ModeCreation modeCreation) {
        int i = modeCreation.O;
        modeCreation.O = i + 1;
        return i;
    }

    private void g() {
        this.r = (TextView) findViewById(R.id.pick_icon);
        this.f3095a = (EditText) findViewById(R.id.modenameedit);
        this.f3096b = (EditText) findViewById(R.id.modedescedit);
        this.f3097c = (RangeBar) findViewById(R.id.intervalbar);
        this.f3098d = (RangeBar) findViewById(R.id.speedbar);
        this.f3099e = (Button) findViewById(R.id.createmode);
        this.l = (ImageView) findViewById(R.id.add);
        this.Q = (ImageView) findViewById(R.id.remove_chosen_color);
        this.u = (TextView) findViewById(R.id.enable_strobe);
        this.v = (TextView) findViewById(R.id.set_strobe);
    }

    private void h() {
        this.f3095a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.f3096b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ModeCreation.this.z = ModeCreation.this.y;
                ModeCreation.this.i();
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ModeCreation.this.a(ModeCreation.this.P);
                ModeCreation.r(ModeCreation.this);
                ModeCreation.this.Q.setVisibility(4);
                ModeCreation.this.K[ModeCreation.this.O].setChecked(false);
                ModeCreation.this.K[ModeCreation.this.O].setVisibility(4);
                ModeCreation.this.L[ModeCreation.this.O].setVisibility(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_icon_picker, (ViewGroup) null);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.dialog_icon_grid);
        gridView.setChoiceMode(1);
        gridView.setAdapter((ListAdapter) this.x);
        e.a aVar = new e.a(this);
        aVar.b(viewInflate);
        final e eVarB = aVar.b();
        eVarB.setCancelable(false);
        eVarB.show();
        TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVarB.dismiss();
                ModeCreation.this.y = ModeCreation.this.z;
                ModeCreation.this.r.setCompoundDrawablesWithIntrinsicBounds(ModeCreation.this.getApplicationContext().getResources().getDrawable(h.S[ModeCreation.this.z].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVarB.dismiss();
                ModeCreation.this.r.setCompoundDrawablesWithIntrinsicBounds(ModeCreation.this.getApplicationContext().getResources().getDrawable(h.S[ModeCreation.this.y].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ModeCreation.this.y = i;
                ModeCreation.this.x.notifyDataSetChanged();
            }
        });
        FlurryAgent.logEvent("mode_icon_change_icon_button_tapped");
    }

    private void j() {
        this.I[0] = (ImageView) findViewById(R.id.gridcolor1);
        this.I[1] = (ImageView) findViewById(R.id.gridcolor2);
        this.I[2] = (ImageView) findViewById(R.id.gridcolor3);
        this.I[3] = (ImageView) findViewById(R.id.gridcolor4);
        this.I[4] = (ImageView) findViewById(R.id.gridcolor5);
        this.I[5] = (ImageView) findViewById(R.id.gridcolor6);
        this.J[0] = (ImageView) findViewById(R.id.colorchosen1);
        this.J[1] = (ImageView) findViewById(R.id.colorchosen2);
        this.J[2] = (ImageView) findViewById(R.id.colorchosen3);
        this.J[3] = (ImageView) findViewById(R.id.colorchosen4);
        this.J[4] = (ImageView) findViewById(R.id.colorchosen5);
        this.J[5] = (ImageView) findViewById(R.id.colorchosen6);
        this.K[0] = (CheckBox) findViewById(R.id.colorChecked1);
        this.K[1] = (CheckBox) findViewById(R.id.colorChecked2);
        this.K[2] = (CheckBox) findViewById(R.id.colorChecked3);
        this.K[3] = (CheckBox) findViewById(R.id.colorChecked4);
        this.K[4] = (CheckBox) findViewById(R.id.colorChecked5);
        this.K[5] = (CheckBox) findViewById(R.id.colorChecked6);
        this.L[0] = (TextView) findViewById(R.id.colorStrobe1);
        this.L[1] = (TextView) findViewById(R.id.colorStrobe2);
        this.L[2] = (TextView) findViewById(R.id.colorStrobe3);
        this.L[3] = (TextView) findViewById(R.id.colorStrobe4);
        this.L[4] = (TextView) findViewById(R.id.colorStrobe5);
        this.L[5] = (TextView) findViewById(R.id.colorStrobe6);
        for (int i = 0; i < 6; i++) {
            this.J[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.G, 1, 1));
            this.J[i].setOnClickListener(this);
            this.I[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.M[i], 0, 1));
            this.I[i].setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Toast.makeText(this, "You can only pick 6 colors.", 0).show();
    }

    private void l() {
        if (this.O > 0) {
            this.Q.setVisibility(0);
        }
    }

    private void m() {
        for (int i = 0; i < this.O; i++) {
            this.J[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.N[i], 0, 1));
        }
    }

    static /* synthetic */ int r(ModeCreation modeCreation) {
        int i = modeCreation.O;
        modeCreation.O = i - 1;
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.colorchosen1 /* 2131624276 */:
                if (this.O > 0) {
                    m();
                }
                b(0);
                break;
            case R.id.colorchosen2 /* 2131624277 */:
                if (this.O > 1) {
                    m();
                }
                b(1);
                break;
            case R.id.colorchosen3 /* 2131624278 */:
                if (this.O > 2) {
                    m();
                }
                b(2);
                break;
            case R.id.colorchosen4 /* 2131624279 */:
                if (this.O > 3) {
                    m();
                }
                b(3);
                break;
            case R.id.colorchosen5 /* 2131624280 */:
                if (this.O > 4) {
                    m();
                }
                b(4);
                break;
            case R.id.colorchosen6 /* 2131624281 */:
                if (this.O > 5) {
                    m();
                }
                b(5);
                break;
            case R.id.gridcolor1 /* 2131624300 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.A;
                    ImageView[] imageViewArr = this.J;
                    int i = this.O;
                    this.O = i + 1;
                    imageViewArr[i].setBackground(com.cube26.iota.smartlite.util.d.a(this.A, 0, 1));
                }
                break;
            case R.id.gridcolor2 /* 2131624301 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.B;
                    ImageView[] imageViewArr2 = this.J;
                    int i2 = this.O;
                    this.O = i2 + 1;
                    imageViewArr2[i2].setBackground(com.cube26.iota.smartlite.util.d.a(this.B, 0, 1));
                }
                break;
            case R.id.gridcolor3 /* 2131624302 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.C;
                    ImageView[] imageViewArr3 = this.J;
                    int i3 = this.O;
                    this.O = i3 + 1;
                    imageViewArr3[i3].setBackground(com.cube26.iota.smartlite.util.d.a(this.C, 0, 1));
                }
                break;
            case R.id.gridcolor4 /* 2131624303 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.D;
                    ImageView[] imageViewArr4 = this.J;
                    int i4 = this.O;
                    this.O = i4 + 1;
                    imageViewArr4[i4].setBackground(com.cube26.iota.smartlite.util.d.a(this.D, 0, 1));
                }
                break;
            case R.id.gridcolor5 /* 2131624304 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.E;
                    ImageView[] imageViewArr5 = this.J;
                    int i5 = this.O;
                    this.O = i5 + 1;
                    imageViewArr5[i5].setBackground(com.cube26.iota.smartlite.util.d.a(this.E, 0, 1));
                }
                break;
            case R.id.gridcolor6 /* 2131624305 */:
                if (this.O >= 6) {
                    k();
                } else {
                    if (this.v.getVisibility() == 0) {
                        this.K[this.O].setVisibility(0);
                    }
                    this.N[this.O] = this.F;
                    ImageView[] imageViewArr6 = this.J;
                    int i6 = this.O;
                    this.O = i6 + 1;
                    imageViewArr6[i6].setBackground(com.cube26.iota.smartlite.util.d.a(this.F, 0, 1));
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
        c().a(Html.fromHtml("<font color='#596475'>All Modes</font>"));
        this.m = c.a();
        this.m.a(this);
        g();
        h();
        j();
        this.r.setCompoundDrawablesWithIntrinsicBounds(getApplicationContext().getResources().getDrawable(h.S[this.y].intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ModeCreation.this.O >= 6) {
                    ModeCreation.this.k();
                    return;
                }
                View viewInflate = LayoutInflater.from(ModeCreation.this).inflate(R.layout.custom_dialog, (ViewGroup) null);
                e.a aVar = new e.a(ModeCreation.this);
                aVar.b(viewInflate);
                final e eVarB = aVar.b();
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel_pick_color);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.confirm_pick_color);
                ModeCreation.this.s = (ImageView) viewInflate.findViewById(R.id.preview_color);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVarB.dismiss();
                        if (ModeCreation.this.v.getVisibility() == 0) {
                            ModeCreation.this.K[ModeCreation.this.O].setVisibility(0);
                        }
                        ModeCreation.this.N[ModeCreation.this.O] = ModeCreation.this.t;
                        ModeCreation.this.J[ModeCreation.g(ModeCreation.this)].setBackground(com.cube26.iota.smartlite.util.d.a(ModeCreation.this.t, 0, 1));
                    }
                });
                eVarB.show();
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (com.cube26.iota.smartlite.d.a aVar : h.v) {
                    if (aVar.o() != null && !aVar.o().equals("1.04")) {
                        Toast.makeText(ModeCreation.this, "Color strobing is supported in the latest lite firmware. Please upgrade your lite firmware from its settings.", 1).show();
                        break;
                    }
                }
                ModeCreation.this.v.setVisibility(0);
                ModeCreation.this.u.setVisibility(4);
                for (int i = 0; i < ModeCreation.this.O; i++) {
                    ModeCreation.this.K[i].setVisibility(0);
                    ModeCreation.this.L[i].setVisibility(4);
                }
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ModeCreation.this.w = new StringBuilder("");
                ModeCreation.this.v.setVisibility(4);
                ModeCreation.this.u.setVisibility(0);
                for (int i = 0; i < 6; i++) {
                    if (ModeCreation.this.K[i].isChecked()) {
                        ModeCreation.this.w.append(i);
                        ModeCreation.this.L[i].setVisibility(0);
                    }
                    ModeCreation.this.K[i].setVisibility(4);
                }
                FlurryAgent.logEvent("set_strobe_button_tapped");
                CLog.a("IOTA", " checkedpos ::" + ((Object) ModeCreation.this.w));
            }
        });
        this.f3097c.setOnRangeBarChangeListener(new RangeBar.a() { // from class: com.cube26.iota.smartlite.ModeCreation.6
            @Override // com.appyvet.rangebar.RangeBar.a
            public void a(RangeBar rangeBar, int i, int i2, String str, String str2) {
                ModeCreation.this.n = i2 * 10 * 2;
                CLog.a("IOTA", "Interval :: " + ModeCreation.this.n);
                ModeCreation.this.g = true;
                FlurryAgent.logEvent("mode_lumonisity_value_adjusted");
            }
        });
        this.f3098d.setOnRangeBarChangeListener(new RangeBar.a() { // from class: com.cube26.iota.smartlite.ModeCreation.7
            @Override // com.appyvet.rangebar.RangeBar.a
            public void a(RangeBar rangeBar, int i, int i2, String str, String str2) {
                ModeCreation.this.o = i2 * 10 * 2;
                CLog.a("IOTA", "speed :: " + ModeCreation.this.o);
                ModeCreation.this.h = true;
                FlurryAgent.logEvent("mode_transition_time_adjusted");
            }
        });
        this.f3099e.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.ModeCreation.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ModeCreation.this.k.d("color");
                ModeCreation.this.k.a(ModeCreation.this.w.toString());
                if (!h.a(ModeCreation.this.f3095a.getText().toString())) {
                    ModeCreation.this.f3095a.setError("Mood Name is required!");
                    ModeCreation.this.f3100f = true;
                    return;
                }
                ModeCreation.this.f3095a.setError(null);
                ModeCreation.this.k.b(ModeCreation.this.f3095a.getText().toString());
                ModeCreation.this.f3100f = false;
                if (ModeCreation.this.O == 0) {
                    Toast.makeText(ModeCreation.this, "Pick at least one color.", 0).show();
                    return;
                }
                if (ModeCreation.this.f3096b.getText().toString().length() == 0) {
                    ModeCreation.this.k.c("");
                } else {
                    ModeCreation.this.f3096b.setError(null);
                    ModeCreation.this.k.c(ModeCreation.this.f3096b.getText().toString());
                    ModeCreation.this.f3100f = false;
                }
                CLog.a("IOTA", " interval :: " + ModeCreation.this.n + " speed :: " + ModeCreation.this.o);
                ModeCreation.this.k.b(ModeCreation.this.y);
                if (ModeCreation.this.g) {
                    ModeCreation.this.k.i(ModeCreation.this.n);
                } else {
                    ModeCreation.this.k.i(100);
                }
                if (ModeCreation.this.h) {
                    ModeCreation.this.k.j(ModeCreation.this.o);
                } else {
                    ModeCreation.this.k.j(100);
                }
                CLog.a("IOTA", "Transition Color" + ModeCreation.this.q[0] + "1" + ModeCreation.this.q[1]);
                if (ModeCreation.this.N[0] != 0) {
                    ModeCreation.this.k.c(ModeCreation.this.N[0]);
                } else {
                    ModeCreation.this.k.c(0);
                }
                if (ModeCreation.this.N[1] != 0) {
                    ModeCreation.this.k.d(ModeCreation.this.N[1]);
                } else {
                    ModeCreation.this.k.d(0);
                }
                if (ModeCreation.this.N[2] != 0) {
                    ModeCreation.this.k.e(ModeCreation.this.N[2]);
                } else {
                    ModeCreation.this.k.e(0);
                }
                if (ModeCreation.this.N[3] != 0) {
                    ModeCreation.this.k.f(ModeCreation.this.N[3]);
                } else {
                    ModeCreation.this.k.f(0);
                }
                if (ModeCreation.this.N[4] != 0) {
                    ModeCreation.this.k.g(ModeCreation.this.N[4]);
                } else {
                    ModeCreation.this.k.g(0);
                }
                if (ModeCreation.this.N[5] != 0) {
                    ModeCreation.this.k.h(ModeCreation.this.N[5]);
                } else {
                    ModeCreation.this.k.h(0);
                }
                if (ModeCreation.this.f3100f) {
                    if (ModeCreation.this.i) {
                        Toast.makeText(ModeCreation.this.getApplicationContext(), "Please Choose Transition", 0).show();
                    }
                } else {
                    ModeCreation.this.j.a(ModeCreation.this.k);
                    ModeCreation.this.setResult(-1, new Intent(ModeCreation.this, (Class<?>) MainActivity.class));
                    FlurryAgent.logEvent("mode_color_selected");
                    ModeCreation.this.finish();
                    CLog.a("IOTA", "Mode Created Successfully");
                }
            }
        });
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        try {
            this.s.setBackground(com.cube26.iota.smartlite.util.d.a(colorCodeChangeListener.f3421a, 0, 1));
            this.t = colorCodeChangeListener.f3421a;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
