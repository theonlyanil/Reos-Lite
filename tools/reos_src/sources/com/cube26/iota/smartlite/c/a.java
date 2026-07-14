package com.cube26.iota.smartlite.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.AlertViews.AlertSpecificActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.b.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.cube26.iota.smartlite.AlertViews.b f3251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3252c = null;

    public a() {
    }

    public a(Context context) {
        this.f3250a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final String str2) {
        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(getActivity(), R.style.AppCompatAlertDialogStyle);
        aVar.a(str);
        aVar.b("To set an alert for " + str + ", download it from Google Playstore");
        aVar.a("Download", new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.c.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str2)));
                } catch (ActivityNotFoundException e2) {
                    a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str2)));
                }
            }
        });
        aVar.b("Cancel", null);
        aVar.a(false);
        aVar.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_four, viewGroup, false);
        ArrayList arrayList = new ArrayList();
        GridView gridView = (GridView) viewInflate.findViewById(R.id.widgetGrid);
        h hVar = new h();
        hVar.c(1);
        hVar.d("Call");
        hVar.a("Call");
        hVar.b(R.drawable.call);
        hVar.a(R.drawable.callactivated);
        h hVar2 = new h();
        hVar2.c(2);
        hVar2.d("SMS");
        hVar2.a("SMS");
        hVar2.b(R.drawable.sms);
        hVar2.a(R.drawable.smsactivated);
        h hVar3 = new h();
        hVar3.c(3);
        hVar3.d("youtube_channel");
        hVar3.a("YouTube");
        hVar3.b(R.drawable.youtube);
        hVar3.a(R.drawable.youtubeactivated);
        h hVar4 = new h();
        hVar4.c(4);
        hVar4.d("weather");
        hVar4.a("Weather");
        hVar4.b(R.drawable.weather);
        hVar4.a(R.drawable.weatheractivated);
        h hVar5 = new h();
        hVar5.c(5);
        hVar5.d("WhatsApp");
        hVar5.a("WhatsApp");
        hVar5.b(R.drawable.whatsapp);
        hVar5.a(R.drawable.whatsappactivated);
        h hVar6 = new h();
        hVar6.c(6);
        hVar6.d("Hike");
        hVar6.a("Hike");
        hVar6.b(R.drawable.hike);
        hVar6.a(R.drawable.hikeactivated);
        h hVar7 = new h();
        hVar7.c(7);
        hVar7.d("Ola");
        hVar7.a("Ola");
        hVar7.b(R.drawable.ola);
        hVar7.a(R.drawable.olaactivated);
        h hVar8 = new h();
        hVar8.c(8);
        hVar8.d("Uber");
        hVar8.a("Uber");
        hVar8.b(R.drawable.uber);
        hVar8.a(R.drawable.uberactivated);
        h hVar9 = new h();
        hVar9.c(9);
        hVar9.d("Facebook");
        hVar9.a("Facebook");
        hVar9.b(R.drawable.facebook);
        hVar9.a(R.drawable.facebookactivated);
        h hVar10 = new h();
        hVar10.c(11);
        hVar10.d("Tinder");
        hVar10.a("Tinder");
        hVar10.b(R.drawable.tinder);
        hVar10.a(R.drawable.tinderactivated);
        h hVar11 = new h();
        hVar11.c(12);
        hVar11.d("Domino's");
        hVar11.a("Domino's");
        hVar11.b(R.drawable.dominos);
        hVar11.a(R.drawable.dominosactivated);
        h hVar12 = new h();
        hVar12.c(13);
        hVar12.d("bigbasket");
        hVar12.a("bigbasket");
        hVar12.b(R.drawable.bigbasket);
        hVar12.a(R.drawable.bigbasketactivated);
        h hVar13 = new h();
        hVar13.c(14);
        hVar13.d("Grofers");
        hVar13.a("Grofers");
        hVar13.b(R.drawable.grofers);
        hVar13.a(R.drawable.grofersactivated);
        h hVar14 = new h();
        hVar14.c(15);
        hVar14.d("Swiggy");
        hVar14.a("Swiggy");
        hVar14.b(R.drawable.swiggy);
        hVar14.a(R.drawable.swiggyactivated);
        arrayList.add(hVar);
        arrayList.add(hVar2);
        arrayList.add(hVar3);
        arrayList.add(hVar4);
        arrayList.add(hVar5);
        arrayList.add(hVar6);
        arrayList.add(hVar7);
        arrayList.add(hVar8);
        arrayList.add(hVar9);
        arrayList.add(hVar10);
        arrayList.add(hVar11);
        arrayList.add(hVar12);
        arrayList.add(hVar13);
        arrayList.add(hVar14);
        this.f3252c = com.cube26.iota.smartlite.util.h.c(getActivity().getApplicationContext());
        this.f3251b = new com.cube26.iota.smartlite.AlertViews.b(getActivity(), arrayList);
        gridView.setAdapter((ListAdapter) this.f3251b);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.cube26.iota.smartlite.c.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (com.cube26.iota.smartlite.util.h.f3467a) {
                    com.cube26.iota.smartlite.util.h.a(a.this.getActivity());
                    return;
                }
                Intent intent = new Intent(a.this.getActivity(), (Class<?>) AlertSpecificActivity.class);
                int iE = ((h) adapterView.getAdapter().getItem(i)).e();
                CLog.a("IOTA", "recipe_id " + iE);
                intent.putExtra("recipe_id", iE);
                a.this.f3252c = com.cube26.iota.smartlite.util.h.c(a.this.getActivity().getApplicationContext());
                if (iE < 3 && Build.VERSION.SDK_INT > 22) {
                    if (a.this.getActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                        CLog.a("IOTA", " already have phone state permission ");
                        a.this.startActivity(intent);
                        return;
                    }
                    CLog.a("IOTA", "requesting phone state permission");
                    if (iE == 1) {
                        android.support.v4.app.a.a(a.this.getActivity(), new String[]{"android.permission.READ_PHONE_STATE"}, 107);
                        return;
                    } else {
                        android.support.v4.app.a.a(a.this.getActivity(), new String[]{"android.permission.READ_PHONE_STATE"}, 108);
                        return;
                    }
                }
                if (iE == 5) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.whatsapp")) {
                        a.this.a("WhatsApp", "com.whatsapp");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 6) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.bsb.hike")) {
                        a.this.a("Hike", "com.bsb.hike");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 7) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.olacabs.customer")) {
                        a.this.a("Ola", "com.olacabs.customer");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 8) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.ubercab")) {
                        a.this.a("Uber", "com.ubercab");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 9) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.facebook.katana")) {
                        a.this.a("Facebook", "com.facebook.katana");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 11) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.tinder")) {
                        a.this.a("Tinder", "com.tinder");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 12) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.Dominos")) {
                        a.this.a("Domino's", "com.Dominos");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 13) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.bigbasket.mobileapp")) {
                        a.this.a("bigbasket", "com.bigbasket.mobileapp");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE == 14) {
                    if (a.this.f3252c == null || !a.this.f3252c.contains("com.grofers.customerapp")) {
                        a.this.a("Grofers", "com.grofers.customerapp");
                        return;
                    } else {
                        a.this.startActivity(intent);
                        return;
                    }
                }
                if (iE != 15) {
                    a.this.startActivity(intent);
                } else if (a.this.f3252c == null || !a.this.f3252c.contains("in.swiggy.android")) {
                    a.this.a("Swiggy", "in.swiggy.android");
                } else {
                    a.this.startActivity(intent);
                }
            }
        });
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3251b != null) {
            this.f3251b.notifyDataSetChanged();
        }
    }
}
