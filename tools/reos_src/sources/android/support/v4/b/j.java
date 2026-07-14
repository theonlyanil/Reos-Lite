package android.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.library.userprofile.util.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f718f = new Object();
    private static j g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f720b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f721c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<a> f722d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f723e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<b> f726b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f725a = intent;
            this.f726b = arrayList;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f729c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f727a = intentFilter;
            this.f728b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f728b);
            sb.append(" filter=");
            sb.append(this.f727a);
            sb.append("}");
            return sb.toString();
        }
    }

    private j(Context context) {
        this.f719a = context;
        this.f723e = new Handler(context.getMainLooper()) { // from class: android.support.v4.b.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        j.this.a();
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            }
        };
    }

    public static j a(Context context) {
        j jVar;
        synchronized (f718f) {
            if (g == null) {
                g = new j(context.getApplicationContext());
            }
            jVar = g;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        a[] aVarArr;
        while (true) {
            synchronized (this.f720b) {
                int size = this.f722d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.f722d.toArray(aVarArr);
                this.f722d.clear();
            }
            for (a aVar : aVarArr) {
                for (int i = 0; i < aVar.f726b.size(); i++) {
                    aVar.f726b.get(i).f728b.onReceive(this.f719a, aVar.f725a);
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.f720b) {
            ArrayList<IntentFilter> arrayListRemove = this.f720b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int i2 = 0; i2 < arrayListRemove.size(); i2++) {
                IntentFilter intentFilter = arrayListRemove.get(i2);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList<b> arrayList = this.f721c.get(action);
                    if (arrayList != null) {
                        int i4 = 0;
                        while (i4 < arrayList.size()) {
                            if (arrayList.get(i4).f728b == broadcastReceiver) {
                                arrayList.remove(i4);
                                i = i4 - 1;
                            } else {
                                i = i4;
                            }
                            i4 = i + 1;
                        }
                        if (arrayList.size() <= 0) {
                            this.f721c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f720b) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f720b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f720b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.f721c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f721c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.f720b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f719a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList2 = this.f721c.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    b bVar = arrayList2.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f727a);
                    }
                    if (!bVar.f729c) {
                        int iMatch = bVar.f727a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(bVar);
                            bVar.f729c = true;
                        } else {
                            if (z) {
                                switch (iMatch) {
                                    case -4:
                                        str = "category";
                                        break;
                                    case -3:
                                        str = "action";
                                        break;
                                    case -2:
                                        str = "data";
                                        break;
                                    case -1:
                                        str = Constants.SMS_COLUMN_TYPE;
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    } else if (z) {
                        Log.v("LocalBroadcastManager", "  Filter's target already added");
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList3;
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((b) arrayList3.get(i2)).f729c = false;
                    }
                    this.f722d.add(new a(intent, arrayList3));
                    if (!this.f723e.hasMessages(1)) {
                        this.f723e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
