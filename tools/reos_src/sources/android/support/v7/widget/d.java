package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class d extends DataSetObservable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1770a = d.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f1771b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, d> f1772c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f1773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a> f1774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c> f1775f;
    private final Context g;
    private final String h;
    private Intent i;
    private b j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private InterfaceC0034d p;

    public final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f1776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1777b;

        public a(ResolveInfo resolveInfo) {
            this.f1776a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f1777b) - Float.floatToIntBits(this.f1777b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1777b) == Float.floatToIntBits(((a) obj).f1777b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1777b) + 31;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.f1776a.toString());
            sb.append("; weight:").append(new BigDecimal(this.f1777b));
            sb.append("]");
            return sb.toString();
        }
    }

    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f1779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1781c;

        public c(ComponentName componentName, long j, float f2) {
            this.f1779a = componentName;
            this.f1780b = j;
            this.f1781c = f2;
        }

        public c(String str, long j, float f2) {
            this(ComponentName.unflattenFromString(str), j, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f1779a == null) {
                    if (cVar.f1779a != null) {
                        return false;
                    }
                } else if (!this.f1779a.equals(cVar.f1779a)) {
                    return false;
                }
                return this.f1780b == cVar.f1780b && Float.floatToIntBits(this.f1781c) == Float.floatToIntBits(cVar.f1781c);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f1779a == null ? 0 : this.f1779a.hashCode()) + 31) * 31) + ((int) (this.f1780b ^ (this.f1780b >>> 32)))) * 31) + Float.floatToIntBits(this.f1781c);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.f1779a);
            sb.append("; time:").append(this.f1780b);
            sb.append("; weight:").append(new BigDecimal(this.f1781c));
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$d, reason: collision with other inner class name */
    public interface InterfaceC0034d {
        boolean a(d dVar, Intent intent);
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        private e() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = d.this.g.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                        xmlSerializerNewSerializer.startDocument("UTF-8", true);
                        xmlSerializerNewSerializer.startTag(null, "historical-records");
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            c cVar = (c) list.remove(0);
                            xmlSerializerNewSerializer.startTag(null, "historical-record");
                            xmlSerializerNewSerializer.attribute(null, "activity", cVar.f1779a.flattenToString());
                            xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(cVar.f1780b));
                            xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(cVar.f1781c));
                            xmlSerializerNewSerializer.endTag(null, "historical-record");
                        }
                        xmlSerializerNewSerializer.endTag(null, "historical-records");
                        xmlSerializerNewSerializer.endDocument();
                        d.this.l = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (Throwable th) {
                        d.this.l = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    Log.e(d.f1770a, "Error writing historical recrod file: " + d.this.h, e4);
                    d.this.l = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IllegalArgumentException e6) {
                    Log.e(d.f1770a, "Error writing historical recrod file: " + d.this.h, e6);
                    d.this.l = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (IllegalStateException e8) {
                    Log.e(d.f1770a, "Error writing historical recrod file: " + d.this.h, e8);
                    d.this.l = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e9) {
                        }
                    }
                }
            } catch (FileNotFoundException e10) {
                Log.e(d.f1770a, "Error writing historical recrod file: " + str, e10);
            }
            return null;
        }
    }

    private boolean a(c cVar) {
        boolean zAdd = this.f1775f.add(cVar);
        if (zAdd) {
            this.n = true;
            j();
            e();
            g();
            notifyChanged();
        }
        return zAdd;
    }

    private void e() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.h)) {
                return;
            }
            android.support.v4.f.a.a(new e(), new ArrayList(this.f1775f), this.h);
        }
    }

    private void f() {
        boolean zH = h() | i();
        j();
        if (zH) {
            g();
            notifyChanged();
        }
    }

    private boolean g() {
        if (this.j == null || this.i == null || this.f1774e.isEmpty() || this.f1775f.isEmpty()) {
            return false;
        }
        this.j.a(this.i, this.f1774e, Collections.unmodifiableList(this.f1775f));
        return true;
    }

    private boolean h() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.f1774e.clear();
        List<ResolveInfo> listQueryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1774e.add(new a(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean i() {
        if (!this.l || !this.n || TextUtils.isEmpty(this.h)) {
            return false;
        }
        this.l = false;
        this.m = true;
        k();
        return true;
    }

    private void j() {
        int size = this.f1775f.size() - this.k;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.f1775f.remove(0);
        }
    }

    private void k() {
        FileInputStream fileInputStreamOpenFileInput;
        try {
            try {
                fileInputStreamOpenFileInput = this.g.openFileInput(this.h);
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<c> list = this.f1775f;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    try {
                                        fileInputStreamOpenFileInput.close();
                                        return;
                                    } catch (IOException e2) {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (next2 != 3 && next2 != 4) {
                                if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new c(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (XmlPullParserException e3) {
                        Log.e(f1770a, "Error reading historical recrod file: " + this.h, e3);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                } catch (IOException e5) {
                    Log.e(f1770a, "Error reading historical recrod file: " + this.h, e5);
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (FileNotFoundException e7) {
            }
        } catch (Throwable th) {
            if (fileInputStreamOpenFileInput != null) {
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }

    public int a() {
        int size;
        synchronized (this.f1773d) {
            f();
            size = this.f1774e.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.f1773d) {
            f();
            List<a> list = this.f1774e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1776a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1773d) {
            f();
            resolveInfo = this.f1774e.get(i).f1776a;
        }
        return resolveInfo;
    }

    public Intent b(int i) {
        synchronized (this.f1773d) {
            if (this.i == null) {
                return null;
            }
            f();
            a aVar = this.f1774e.get(i);
            ComponentName componentName = new ComponentName(aVar.f1776a.activityInfo.packageName, aVar.f1776a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.f1773d) {
            f();
            if (this.f1774e.isEmpty()) {
                return null;
            }
            return this.f1774e.get(0).f1776a;
        }
    }

    public int c() {
        int size;
        synchronized (this.f1773d) {
            f();
            size = this.f1775f.size();
        }
        return size;
    }

    public void c(int i) {
        synchronized (this.f1773d) {
            f();
            a aVar = this.f1774e.get(i);
            a aVar2 = this.f1774e.get(0);
            a(new c(new ComponentName(aVar.f1776a.activityInfo.packageName, aVar.f1776a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1777b - aVar.f1777b) + 5.0f : 1.0f));
        }
    }
}
