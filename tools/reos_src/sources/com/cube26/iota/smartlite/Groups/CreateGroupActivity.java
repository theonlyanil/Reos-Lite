package com.cube26.iota.smartlite.Groups;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.a.f;
import android.text.Html;
import android.text.InputFilter;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.a.a;
import com.cube26.iota.smartlite.util.h;
import com.flurry.android.FlurryAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CreateGroupActivity extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EditText f3032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListView f3033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<String> f3034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<String> f3035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f3036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayAdapter<String> f3037f;
    private Button g;
    private String h = "";
    private int i;
    private String j;
    private com.cube26.iota.smartlite.b.a k;
    private ArrayList<com.cube26.iota.smartlite.d.a> l;

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ArrayList<com.cube26.iota.smartlite.b.a> arrayList) {
        int iC = 0;
        Iterator<com.cube26.iota.smartlite.b.a> it = arrayList.iterator();
        while (true) {
            int i = iC;
            if (!it.hasNext()) {
                return i + 1;
            }
            com.cube26.iota.smartlite.b.a next = it.next();
            iC = next.c() >= i ? next.c() : i;
        }
    }

    private void g() {
        this.f3032a = (EditText) findViewById(R.id.group_name);
        this.f3033b = (ListView) findViewById(R.id.saved_lite_list);
        this.g = (Button) findViewById(R.id.save_group);
        this.f3035d = new ArrayList<>();
        this.f3034c = this.f3036e.d();
        for (int i = 0; i < this.f3034c.size(); i++) {
            this.f3035d.add(this.f3036e.b(this.f3034c.get(i)));
        }
        this.f3033b.setChoiceMode(2);
        this.f3037f = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, this.f3035d);
        this.f3033b.setAdapter((ListAdapter) this.f3037f);
        this.f3032a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
    }

    @Override // android.support.v7.a.f, android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_group);
        c().c(true);
        c().a(true);
        c().b(true);
        this.j = getIntent().getStringExtra("mode");
        if (this.j.equals("new")) {
            c().a(Html.fromHtml("<font color='#596475'>New group</font>"));
        } else {
            c().a(Html.fromHtml("<font color='#596475'>Edit " + getIntent().getStringExtra("groupName") + " group</font>"));
        }
        this.f3036e = new a(this);
        this.l = new ArrayList<>();
        g();
        if (this.j.equals("edit")) {
            this.i = getIntent().getIntExtra("groupId", -1);
            this.k = this.f3036e.a(this.i);
            this.f3032a.setText(getIntent().getStringExtra("groupName"));
            this.f3032a.setSelection(this.f3032a.getText().length());
            this.l = this.k.d();
            for (com.cube26.iota.smartlite.d.a aVar : this.l) {
                if (this.f3035d.contains(this.f3036e.b(aVar.q()))) {
                    this.f3033b.setItemChecked(this.f3034c.indexOf(aVar.q()), true);
                }
            }
        }
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.Groups.CreateGroupActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = true;
                String string = CreateGroupActivity.this.f3032a.getText().toString();
                if (!h.a(string)) {
                    CreateGroupActivity.this.f3032a.setError("Can't be empty");
                    return;
                }
                if (CreateGroupActivity.this.f3033b.getCheckedItemCount() < 2) {
                    Toast.makeText(CreateGroupActivity.this, " Pick at least 2 lites to make a group.", 0).show();
                    return;
                }
                CreateGroupActivity.this.l = new ArrayList();
                int count = CreateGroupActivity.this.f3033b.getCount();
                SparseBooleanArray checkedItemPositions = CreateGroupActivity.this.f3033b.getCheckedItemPositions();
                for (int i = 0; i < count; i++) {
                    if (checkedItemPositions.get(i)) {
                        CreateGroupActivity.this.h += ((String) CreateGroupActivity.this.f3034c.get(i)) + ";";
                        com.cube26.iota.smartlite.d.a aVar2 = new com.cube26.iota.smartlite.d.a();
                        aVar2.e((String) CreateGroupActivity.this.f3034c.get(i));
                        CreateGroupActivity.this.l.add(aVar2);
                    }
                }
                ArrayList<com.cube26.iota.smartlite.b.a> arrayListC = CreateGroupActivity.this.f3036e.c();
                if (CreateGroupActivity.this.j.equals("new")) {
                    CreateGroupActivity.this.k = new com.cube26.iota.smartlite.b.a(CreateGroupActivity.this.f3032a.getText().toString(), CreateGroupActivity.this.a(arrayListC), CreateGroupActivity.this.l);
                    if (Collections.frequency(arrayListC, CreateGroupActivity.this.k) != 0) {
                        Toast.makeText(CreateGroupActivity.this, "Group with similar name already exists.", 0).show();
                        return;
                    }
                    CreateGroupActivity.this.f3036e.b(string, CreateGroupActivity.this.h);
                    Message messageObtain = Message.obtain(h.f3470d);
                    messageObtain.what = 14;
                    messageObtain.obj = CreateGroupActivity.this.k;
                    h.f3470d.sendMessage(messageObtain);
                    CLog.a("IOTA", "saved grp :: " + CreateGroupActivity.this.k);
                    CreateGroupActivity.this.finish();
                    return;
                }
                CreateGroupActivity.this.k.a(CreateGroupActivity.this.f3032a.getText().toString());
                CreateGroupActivity.this.k.a(CreateGroupActivity.this.l);
                int iFrequency = Collections.frequency(arrayListC, CreateGroupActivity.this.k);
                if (iFrequency == 0) {
                    CreateGroupActivity.this.f3036e.a(CreateGroupActivity.this.i, string, CreateGroupActivity.this.h);
                    Message messageObtain2 = Message.obtain(h.f3470d);
                    messageObtain2.what = 18;
                    messageObtain2.obj = CreateGroupActivity.this.k;
                    h.f3470d.sendMessage(messageObtain2);
                    CLog.a("IOTA", "updated grp :: " + CreateGroupActivity.this.k);
                    FlurryAgent.logEvent("group_added");
                    CreateGroupActivity.this.finish();
                    return;
                }
                if (iFrequency != 1) {
                    Toast.makeText(CreateGroupActivity.this, "Group with similar name already exists.", 0).show();
                    return;
                }
                for (com.cube26.iota.smartlite.b.a aVar3 : arrayListC) {
                    z = (!CreateGroupActivity.this.k.equals(aVar3) || CreateGroupActivity.this.k.c() == aVar3.c()) ? z : false;
                }
                if (!z) {
                    Toast.makeText(CreateGroupActivity.this, "Group with similar name already exists.", 0).show();
                    return;
                }
                CreateGroupActivity.this.f3036e.a(CreateGroupActivity.this.i, string, CreateGroupActivity.this.h);
                Message messageObtain3 = Message.obtain(h.f3470d);
                messageObtain3.what = 18;
                messageObtain3.obj = CreateGroupActivity.this.k;
                h.f3470d.sendMessage(messageObtain3);
                CLog.a("IOTA", "updated grp :: " + CreateGroupActivity.this.k);
                FlurryAgent.logEvent("group_edited");
                CreateGroupActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.j.equals("edit")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.saved_lite_group, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.remove_lite_group /* 2131624442 */:
                FlurryAgent.logEvent("group_deleted");
                this.f3036e.b(this.i);
                Message messageObtain = Message.obtain(h.f3470d);
                messageObtain.what = 15;
                messageObtain.obj = this.k;
                h.f3470d.sendMessage(messageObtain);
                CLog.a("IOTA", "removed grp :: " + this.k);
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
