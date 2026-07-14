package com.cube26.iota.smartlite.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.cube26.iota.smartlite.Groups.CreateGroupActivity;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.LiteSettings;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import com.getbase.floatingactionbutton.AddFloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

/* JADX INFO: loaded from: classes.dex */
public class e extends BaseAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f3323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f3324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f3325d;
    private SharedPreferences k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<com.cube26.iota.smartlite.d.a> f3326e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<com.cube26.iota.smartlite.d.a> f3327f = new ArrayList<>();
    private ArrayList<com.cube26.iota.smartlite.b.a> g = new ArrayList<>();
    private com.cube26.iota.smartlite.b.b h = new com.cube26.iota.smartlite.b.b(R.layout.saved_lite_header);
    private com.cube26.iota.smartlite.b.b i = new com.cube26.iota.smartlite.b.b(R.layout.saved_group_list_header);
    private com.cube26.iota.smartlite.b.b j = new com.cube26.iota.smartlite.b.b(R.layout.header);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<com.cube26.iota.smartlite.b.c> f3322a = new ArrayList<>();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AddFloatingActionButton f3344a;

        a() {
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CheckBox f3345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f3346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f3347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f3348d;

        b() {
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CheckBox f3349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f3350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f3351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ImageView f3352d;

        c() {
        }
    }

    public e(Context context) {
        this.f3323b = context;
        this.f3324c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3325d = new com.cube26.iota.smartlite.a.a(context);
        this.k = context.getSharedPreferences("tut", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Message messageObtain = Message.obtain(h.y.a());
        messageObtain.what = 14594;
        messageObtain.arg1 = i;
        h.y.a().sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, View view) {
        switch (i) {
            case 0:
                if (!this.k.getBoolean("liteCheck", false)) {
                    new MaterialShowcaseView.a((Activity) context).a(view).a("liteCheck").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.c.e.9
                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void a(MaterialShowcaseView materialShowcaseView) {
                        }

                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void b(MaterialShowcaseView materialShowcaseView) {
                            e.this.k.edit().putBoolean("liteCheck", true).commit();
                        }
                    }).a((CharSequence) "Got It").a(context.getResources().getColor(R.color.navtabselectedcolor)).b("Choose your lite to connect.").b();
                }
                break;
            case 1:
                if (!this.k.getBoolean("liteFlash", false)) {
                    new MaterialShowcaseView.a((Activity) context).a(view).a("liteFlash").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.c.e.10
                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void a(MaterialShowcaseView materialShowcaseView) {
                        }

                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void b(MaterialShowcaseView materialShowcaseView) {
                            e.this.k.edit().putBoolean("liteFlash", true).commit();
                        }
                    }).a((CharSequence) "Got It").a(context.getResources().getColor(R.color.navtabselectedcolor)).b("Blink your lite.").b();
                }
                break;
            case 2:
                if (!this.k.getBoolean("liteEdit", false)) {
                    new MaterialShowcaseView.a((Activity) context).a(view).a("liteEdit").a(new uk.co.deanwild.materialshowcaseview.d() { // from class: com.cube26.iota.smartlite.c.e.2
                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void a(MaterialShowcaseView materialShowcaseView) {
                        }

                        @Override // uk.co.deanwild.materialshowcaseview.d
                        public void b(MaterialShowcaseView materialShowcaseView) {
                            e.this.k.edit().putBoolean("liteEdit", true).commit();
                        }
                    }).a((CharSequence) "Got It").a(context.getResources().getColor(R.color.navtabselectedcolor)).b("Edit your lite settings.").b();
                }
                break;
        }
    }

    public ArrayList<com.cube26.iota.smartlite.d.a> a() {
        return this.f3326e;
    }

    public void a(com.cube26.iota.smartlite.b.a aVar) {
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        for (com.cube26.iota.smartlite.d.a aVar2 : aVar.d()) {
            if (!this.f3326e.get(this.f3326e.indexOf(aVar2)).e()) {
                z3 = false;
            }
            boolean z4 = !this.f3326e.get(this.f3326e.indexOf(aVar2)).t() ? false : z2;
            z = !this.f3326e.get(this.f3326e.indexOf(aVar2)).r() ? false : z;
            z2 = z4;
        }
        aVar.b(z3);
        aVar.a(z2);
        aVar.c(z);
        this.g.add(aVar);
    }

    public void a(com.cube26.iota.smartlite.d.a aVar) {
        if (this.f3326e.contains(aVar)) {
            return;
        }
        this.f3326e.add(aVar);
    }

    public void a(ArrayList<com.cube26.iota.smartlite.b.a> arrayList) {
        this.g.addAll(arrayList);
    }

    public ArrayList<com.cube26.iota.smartlite.d.a> b() {
        return this.f3327f;
    }

    public void b(com.cube26.iota.smartlite.b.a aVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.g.size()) {
                break;
            }
            com.cube26.iota.smartlite.b.a aVar2 = this.g.get(i);
            if (aVar2.c() == aVar.c()) {
                this.g.remove(aVar2);
                break;
            }
            i2 = i + 1;
        }
        this.g.add(i, aVar);
    }

    public void b(com.cube26.iota.smartlite.d.a aVar) {
        if (this.f3327f.contains(aVar)) {
            return;
        }
        this.f3327f.add(aVar);
    }

    public void c() {
        Iterator<com.cube26.iota.smartlite.d.a> it = this.f3327f.iterator();
        while (it.hasNext()) {
            it.next().x();
        }
    }

    public void c(com.cube26.iota.smartlite.b.a aVar) {
    }

    public void c(com.cube26.iota.smartlite.d.a aVar) {
        int size = this.f3326e.size();
        if (this.f3326e.contains(aVar)) {
            size = this.f3326e.indexOf(aVar);
            this.f3326e.remove(aVar);
        }
        this.f3326e.add(size, aVar);
    }

    public void d(com.cube26.iota.smartlite.d.a aVar) {
        this.f3326e.remove(aVar);
    }

    public void e(com.cube26.iota.smartlite.d.a aVar) {
        this.f3327f.remove(aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3322a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3322a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f3322a.get(i).g()) {
            return 0;
        }
        return this.f3322a.get(i).h() ? 2 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0309 A[PHI: r6 r7
      0x0309: PHI (r6v3 boolean) = (r6v2 boolean), (r6v6 boolean) binds: [B:33:0x023e, B:41:0x027c] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r7v3 boolean) = (r7v2 boolean), (r7v6 boolean) binds: [B:33:0x023e, B:41:0x027c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z;
        c cVar;
        int itemViewType = getItemViewType(i);
        com.cube26.iota.smartlite.b.c cVar2 = this.f3322a.get(i);
        switch (itemViewType) {
            case 0:
                com.cube26.iota.smartlite.b.b bVar2 = (com.cube26.iota.smartlite.b.b) cVar2;
                View viewInflate = this.f3324c.inflate(bVar2.a(), viewGroup, false);
                if (bVar2.a() != R.layout.saved_group_list_header) {
                    return viewInflate;
                }
                View viewInflate2 = this.f3324c.inflate(R.layout.saved_group_list_header, viewGroup, false);
                a aVar = new a();
                aVar.f3344a = (AddFloatingActionButton) viewInflate2.findViewById(R.id.create_group);
                aVar.f3344a.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        e.this.f3323b.startActivity(new Intent(e.this.f3323b, (Class<?>) CreateGroupActivity.class).putExtra("mode", "new"));
                    }
                });
                return viewInflate2;
            case 1:
                final com.cube26.iota.smartlite.d.a aVar2 = (com.cube26.iota.smartlite.d.a) cVar2;
                if (view == null) {
                    c cVar3 = new c();
                    view = this.f3324c.inflate(R.layout.custom_saved_lite, viewGroup, false);
                    cVar3.f3349a = (CheckBox) view.findViewById(R.id.lite_check);
                    cVar3.f3350b = (TextView) view.findViewById(R.id.lite_status);
                    cVar3.f3351c = (ImageView) view.findViewById(R.id.lite_flash);
                    cVar3.f3352d = (ImageView) view.findViewById(R.id.lite_edit);
                    view.setTag(cVar3);
                    cVar = cVar3;
                } else {
                    cVar = (c) view.getTag();
                }
                cVar.f3351c.setEnabled(false);
                cVar.f3352d.setEnabled(false);
                cVar.f3349a.setEnabled(false);
                cVar.f3351c.setImageResource(R.drawable.de_lite_dummy);
                cVar.f3352d.setImageResource(R.drawable.de_edit_lite);
                cVar.f3349a.setOnCheckedChangeListener(null);
                if (aVar2.f()) {
                    cVar.f3349a.setText(aVar2.p());
                    cVar.f3350b.setVisibility(0);
                    if (aVar2.t()) {
                        cVar.f3350b.setText("Connected");
                        cVar.f3351c.setImageResource(R.drawable.lite_dummy);
                        cVar.f3352d.setImageResource(R.drawable.edit_lite);
                        cVar.f3351c.setEnabled(true);
                        cVar.f3352d.setEnabled(true);
                        cVar.f3349a.setEnabled(true);
                    } else if (aVar2.e()) {
                        cVar.f3350b.setText("Available");
                        cVar.f3349a.setEnabled(true);
                    } else {
                        cVar.f3350b.setText("Offline");
                        cVar.f3349a.setEnabled(false);
                    }
                } else {
                    cVar.f3349a.setText("Lite - " + (this.f3327f.indexOf(aVar2) + 1));
                    cVar.f3349a.setEnabled(true);
                    cVar.f3352d.setVisibility(0);
                    cVar.f3351c.setVisibility(0);
                    cVar.f3350b.setVisibility(4);
                    if (aVar2.t()) {
                        cVar.f3352d.setEnabled(true);
                        cVar.f3351c.setEnabled(true);
                        cVar.f3351c.setImageResource(R.drawable.lite_dummy);
                        cVar.f3352d.setImageResource(R.drawable.edit_lite);
                    } else {
                        cVar.f3352d.setEnabled(false);
                        cVar.f3351c.setEnabled(false);
                        cVar.f3349a.setSelected(false);
                        cVar.f3351c.setImageResource(R.drawable.de_lite_dummy);
                        cVar.f3352d.setImageResource(R.drawable.de_edit_lite);
                    }
                }
                cVar.f3351c.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        FlurryAgent.logEvent("bulb_strobe_button_tapped");
                        if (!e.this.k.getBoolean("liteFlash", false)) {
                            e.this.a(e.this.f3323b, 1, view2);
                            return;
                        }
                        int iIndexOf = h.v.indexOf(aVar2);
                        if (aVar2.t() && aVar2.o() != null && iIndexOf != -1) {
                            h.a(0, 0, 0, 0, h.v.indexOf(aVar2), "Phone", "Flash Alert");
                            return;
                        }
                        aVar2.x();
                        aVar2.e(false);
                        aVar2.e(0);
                        aVar2.b(false);
                        h.v.remove(aVar2);
                        e.this.notifyDataSetChanged();
                    }
                });
                cVar.f3352d.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        FlurryAgent.logEvent("bulb_edited");
                        if (!e.this.k.getBoolean("liteEdit", false)) {
                            e.this.a(e.this.f3323b, 2, view2);
                            return;
                        }
                        int iIndexOf = h.v.indexOf(aVar2);
                        if (!aVar2.t()) {
                            aVar2.x();
                            aVar2.e(false);
                            aVar2.e(0);
                            aVar2.b(false);
                            h.v.remove(aVar2);
                            e.this.notifyDataSetChanged();
                            return;
                        }
                        Intent intent = new Intent(e.this.f3323b, (Class<?>) LiteSettings.class);
                        if (iIndexOf != -1) {
                            intent.putExtra("port", iIndexOf);
                            if (aVar2.f()) {
                                intent.putExtra("editMode", 1);
                            } else {
                                intent.putExtra("editMode", 0);
                            }
                            e.this.f3323b.startActivity(intent);
                        }
                    }
                });
                cVar.f3349a.setChecked(aVar2.r());
                cVar.f3349a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.e.5
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        e.this.a(e.this.f3323b, 0, compoundButton);
                        aVar2.e(z2);
                        if (z2) {
                            MainActivity.f3045a = true;
                            if (!h.v.contains(aVar2)) {
                                h.v.add(aVar2);
                            }
                            int iIndexOf = h.v.indexOf(aVar2);
                            Message messageObtain = Message.obtain(h.y.a());
                            messageObtain.what = 14594;
                            messageObtain.arg1 = iIndexOf;
                            h.y.a().sendMessage(messageObtain);
                        } else {
                            h.v.remove(aVar2);
                            if (aVar2.t()) {
                                aVar2.x();
                                aVar2.e(0);
                                aVar2.b(true);
                                aVar2.e(false);
                                e.this.notifyDataSetChanged();
                            }
                        }
                        e.this.notifyDataSetChanged();
                    }
                });
                return view;
            case 2:
                final com.cube26.iota.smartlite.b.a aVar3 = (com.cube26.iota.smartlite.b.a) cVar2;
                if (view == null) {
                    b bVar3 = new b();
                    view = this.f3324c.inflate(R.layout.custom_saved_lite, viewGroup, false);
                    bVar3.f3345a = (CheckBox) view.findViewById(R.id.lite_check);
                    bVar3.f3346b = (ImageView) view.findViewById(R.id.lite_flash);
                    bVar3.f3347c = (ImageView) view.findViewById(R.id.lite_edit);
                    bVar3.f3348d = (TextView) view.findViewById(R.id.lite_status);
                    view.setTag(bVar3);
                    bVar = bVar3;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.f3345a.setText(aVar3.b());
                bVar.f3348d.setVisibility(0);
                bVar.f3345a.setEnabled(false);
                bVar.f3346b.setEnabled(false);
                bVar.f3347c.setEnabled(false);
                bVar.f3346b.setImageResource(R.drawable.de_lite_dummy);
                bVar.f3347c.setImageResource(R.drawable.de_edit_lite);
                bVar.f3345a.setOnCheckedChangeListener(null);
                boolean z2 = true;
                boolean z3 = true;
                boolean z4 = true;
                for (com.cube26.iota.smartlite.d.a aVar4 : aVar3.d()) {
                    if (this.f3326e.contains(aVar4)) {
                        if (!this.f3326e.get(this.f3326e.indexOf(aVar4)).e()) {
                            z4 = false;
                        }
                        if (!this.f3326e.get(this.f3326e.indexOf(aVar4)).t()) {
                            z3 = false;
                        }
                        if (this.f3326e.get(this.f3326e.indexOf(aVar4)).r()) {
                            z = z2;
                        } else {
                            z = false;
                        }
                    } else {
                        z = z2;
                    }
                    z3 = z3;
                    z4 = z4;
                    z2 = z;
                }
                aVar3.b(z4);
                aVar3.a(z3);
                aVar3.c(z2);
                if (aVar3.a()) {
                    bVar.f3348d.setText("Connected");
                    bVar.f3346b.setImageResource(R.drawable.lite_dummy);
                    bVar.f3347c.setImageResource(R.drawable.edit_lite);
                    bVar.f3346b.setEnabled(true);
                    bVar.f3347c.setEnabled(true);
                    bVar.f3345a.setEnabled(true);
                } else if (aVar3.e()) {
                    bVar.f3348d.setText("Available");
                    bVar.f3345a.setEnabled(true);
                } else {
                    bVar.f3348d.setText("Offline");
                    bVar.f3345a.setEnabled(false);
                }
                bVar.f3345a.setChecked(aVar3.f());
                bVar.f3345a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.e.6
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                        aVar3.c(z5);
                        aVar3.b(true);
                        for (com.cube26.iota.smartlite.d.a aVar5 : aVar3.d()) {
                            if (e.this.f3326e.contains(aVar5)) {
                                ((com.cube26.iota.smartlite.d.a) e.this.f3326e.get(e.this.f3326e.indexOf(aVar5))).e(z5);
                            }
                        }
                        if (z5) {
                            MainActivity.f3045a = true;
                            for (com.cube26.iota.smartlite.d.a aVar6 : aVar3.d()) {
                                if (!h.v.contains(e.this.f3326e.get(e.this.f3326e.indexOf(aVar6)))) {
                                    h.v.add((com.cube26.iota.smartlite.d.a) e.this.f3326e.get(e.this.f3326e.indexOf(aVar6)));
                                }
                                e.this.a(h.v.indexOf(aVar6));
                            }
                        } else {
                            for (com.cube26.iota.smartlite.d.a aVar7 : aVar3.d()) {
                                com.cube26.iota.smartlite.d.a aVar8 = (com.cube26.iota.smartlite.d.a) e.this.f3326e.get(e.this.f3326e.indexOf(aVar7));
                                if (aVar8.t()) {
                                    aVar8.x();
                                    aVar8.e(0);
                                    aVar8.b(true);
                                    aVar8.e(false);
                                } else {
                                    aVar8.b(true);
                                    aVar8.e(false);
                                }
                                h.v.remove(aVar7);
                            }
                        }
                        e.this.notifyDataSetChanged();
                    }
                });
                bVar.f3346b.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.e.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Iterator<com.cube26.iota.smartlite.d.a> it = aVar3.d().iterator();
                        while (it.hasNext()) {
                            h.a(0, 0, 0, 0, h.v.indexOf(it.next()), "Phone", "Flash Alert");
                        }
                    }
                });
                bVar.f3347c.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.e.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Intent intent = new Intent(e.this.f3323b, (Class<?>) CreateGroupActivity.class);
                        intent.putExtra("mode", "edit");
                        intent.putExtra("groupId", aVar3.c());
                        intent.putExtra("groupName", aVar3.b());
                        e.this.f3323b.startActivity(intent);
                    }
                });
                return view;
            default:
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.f3322a.clear();
        if (this.f3326e.size() > 0) {
            this.f3322a.add(this.h);
            this.f3322a.addAll(this.f3326e);
        }
        if (this.f3326e.size() >= 2) {
            this.f3322a.add(this.i);
        }
        if (this.g.size() > 0) {
            this.f3322a.addAll(this.g);
        }
        if (this.f3327f.size() > 0) {
            this.f3322a.add(this.j);
            this.f3322a.addAll(this.f3327f);
        }
        super.notifyDataSetChanged();
    }
}
