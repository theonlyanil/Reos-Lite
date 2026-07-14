package com.cube26.iota.smartlite.Apps;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.b.e;
import com.cube26.iota.smartlite.b.f;
import com.cube26.iota.smartlite.b.g;
import com.cube26.iota.smartlite.util.d;
import com.cube26.iota.smartlite.util.h;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class a extends ArrayAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f2993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<g> f2994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f2995d;

    /* JADX INFO: renamed from: com.cube26.iota.smartlite.Apps.a$a, reason: collision with other inner class name */
    static class C0057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f2998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f2999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f3000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Switch f3001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ImageView f3002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f3003f;

        C0057a() {
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f3004a;

        b() {
        }
    }

    public a(Context context, ArrayList<g> arrayList) {
        super(context, 0);
        this.f2992a = context;
        this.f2994c = arrayList;
        this.f2993b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2995d = new com.cube26.iota.smartlite.a.a(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f2994c.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public Object getItem(int i) {
        return this.f2994c.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f2994c.get(i).m() ? 0 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0057a c0057a;
        b bVar;
        int itemViewType = getItemViewType(i);
        g gVar = this.f2994c.get(i);
        switch (itemViewType) {
            case 0:
                f fVar = (f) gVar;
                if (view == null) {
                    b bVar2 = new b();
                    view = this.f2993b.inflate(R.layout.custom_schedule_header, (ViewGroup) null);
                    bVar2.f3004a = (TextView) view.findViewById(R.id.schedule_header);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.f3004a.setText(fVar.a());
                return view;
            case 1:
                final e eVar = (e) gVar;
                if (view == null) {
                    C0057a c0057a2 = new C0057a();
                    view = this.f2993b.inflate(R.layout.custom_schedule, (ViewGroup) null);
                    c0057a2.f2998a = (TextView) view.findViewById(R.id.schedule_name);
                    c0057a2.f2999b = (TextView) view.findViewById(R.id.schedule_time);
                    c0057a2.f3000c = (TextView) view.findViewById(R.id.schedule_days);
                    c0057a2.f3003f = (TextView) view.findViewById(R.id.schedule_mode);
                    c0057a2.f3002e = (ImageView) view.findViewById(R.id.schedule_mode_color);
                    c0057a2.f3001d = (Switch) view.findViewById(R.id.schedule_valid);
                    view.setTag(c0057a2);
                    c0057a = c0057a2;
                } else {
                    c0057a = (C0057a) view.getTag();
                }
                c0057a.f2998a.setText(eVar.d());
                c0057a.f2999b.setText(eVar.e());
                c0057a.f3001d.setOnCheckedChangeListener(null);
                c0057a.f3001d.setChecked(eVar.k());
                c0057a.f3001d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.Apps.a.1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        int iB = h.b(eVar.c(), h.v);
                        eVar.a(z ? 1 : 0);
                        h.a(iB, eVar.b(), z ? 1 : 0, eVar.j(), Color.red(eVar.l()), Color.green(eVar.l()), Color.blue(eVar.l()), 0, (byte) eVar.g(), (byte) eVar.h(), (byte) Integer.parseInt(eVar.i(), 2));
                        a.this.f2995d.a(eVar.b(), eVar.c(), z ? 1 : 0);
                        if (!z) {
                            h.a(a.this.f2992a, eVar.f());
                            return;
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(11, eVar.g());
                        calendar.set(12, eVar.h());
                        CLog.a("IOTA", " schedule repeat :: " + eVar.i());
                        if (eVar.i().contains("1")) {
                            h.a(a.this.f2992a, eVar.f(), h.b(eVar.i(), eVar.g(), eVar.h(), eVar.a()));
                        }
                    }
                });
                c0057a.f3000c.setText(h.b(eVar.i()), TextView.BufferType.SPANNABLE);
                if (eVar.j() == 0) {
                    c0057a.f3003f.setText("Turn off");
                    c0057a.f3002e.setVisibility(4);
                } else {
                    c0057a.f3003f.setText("Turn on");
                    CLog.a("IOTA", " mode color :: " + eVar.l());
                    c0057a.f3002e.setVisibility(0);
                    c0057a.f3002e.setBackground(d.a(eVar.l(), 0, 1));
                }
                return view;
            default:
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
