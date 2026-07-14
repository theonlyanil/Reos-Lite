package com.cube26.iota.smartlite.AlertViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.b.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2943a = {"Call", "SMS", "Youtube_channel", "Weather", "WhatsApp", "Hike", "Ola", "Uber", "Facebook", "FbMessenger", "Tinder", "Domino's", "bigbasket", "Grofers", "Swiggy"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutInflater f2944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<h> f2945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.cube26.iota.smartlite.a.a f2946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f2947e;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f2948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f2949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f2950c;

        a() {
        }
    }

    public b(Context context, ArrayList<h> arrayList) {
        this.f2945c = arrayList;
        this.f2947e = context;
        this.f2944b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2946d = new com.cube26.iota.smartlite.a.a(context);
    }

    private boolean a(int i) {
        return com.cube26.iota.smartlite.util.h.c(this.f2947e).contains(com.cube26.iota.smartlite.util.h.j.get(Integer.valueOf(i)));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CLog.b("weather", "get count " + this.f2945c.size());
        return this.f2945c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        CLog.b("weather", "get item");
        return this.f2945c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f2944b.inflate(R.layout.custom_widget, viewGroup, false);
            aVar = new a();
            aVar.f2948a = (ImageView) view.findViewById(R.id.widgetImage);
            aVar.f2950c = (TextView) view.findViewById(R.id.widgetTitle);
            aVar.f2949b = (ImageView) view.findViewById(R.id.widgetSetIndicator);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        CLog.b("weather", "get view ");
        CLog.b("weather", "title : " + this.f2945c.get(i).c());
        CLog.b("weather", "icon : " + this.f2945c.get(i).d());
        h hVar = this.f2945c.get(i);
        int iE = hVar.e();
        aVar.f2950c.setText(hVar.c());
        if (this.f2946d != null) {
            if (this.f2946d.d(iE).getCount() > 0) {
                aVar.f2949b.setVisibility(0);
            } else {
                aVar.f2949b.setVisibility(4);
            }
            if (iE <= 4 || a(iE)) {
                aVar.f2948a.setImageResource(hVar.a());
            } else {
                if (this.f2946d.d(iE).getCount() > 0) {
                    this.f2946d.h(iE);
                    notifyDataSetChanged();
                }
                aVar.f2949b.setVisibility(4);
                aVar.f2948a.setImageResource(hVar.b());
            }
        }
        return view;
    }
}
