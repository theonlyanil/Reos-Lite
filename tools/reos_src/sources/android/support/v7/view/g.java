package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f1207a = {Context.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f1208b = f1207a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f1209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f1210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f1211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f1212f;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Class<?>[] f1213a = {MenuItem.class};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f1214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1215c;

        public a(Object obj, String str) {
            this.f1214b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1215c = cls.getMethod(str, f1213a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1215c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1215c.invoke(this.f1214b, menuItem)).booleanValue();
                }
                this.f1215c.invoke(this.f1214b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Menu f1217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1221f;
        private boolean g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private CharSequence l;
        private CharSequence m;
        private int n;
        private char o;
        private char p;
        private int q;
        private boolean r;
        private boolean s;
        private boolean t;
        private int u;
        private int v;
        private String w;
        private String x;
        private String y;
        private android.support.v4.view.d z;

        public b(Menu menu) {
            this.f1217b = menu;
            a();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.f1211e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t).setCheckable(this.q >= 1).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
            if (this.u >= 0) {
                q.a(menuItem, this.u);
            }
            if (this.y != null) {
                if (g.this.f1211e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.c(), this.y));
            }
            if (menuItem instanceof android.support.v7.view.menu.h) {
            }
            if (this.q >= 2) {
                if (menuItem instanceof android.support.v7.view.menu.h) {
                    ((android.support.v7.view.menu.h) menuItem).a(true);
                } else if (menuItem instanceof android.support.v7.view.menu.i) {
                    ((android.support.v7.view.menu.i) menuItem).a(true);
                }
            }
            if (this.w != null) {
                q.a(menuItem, (View) a(this.w, g.f1207a, g.this.f1209c));
            } else {
                z = false;
            }
            if (this.v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    q.b(menuItem, this.v);
                }
            }
            if (this.z != null) {
                q.a(menuItem, this.z);
            }
        }

        public void a() {
            this.f1218c = 0;
            this.f1219d = 0;
            this.f1220e = 0;
            this.f1221f = 0;
            this.g = true;
            this.h = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f1211e.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.MenuGroup);
            this.f1218c = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.MenuGroup_android_id, 0);
            this.f1219d = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuGroup_android_menuCategory, 0);
            this.f1220e = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuGroup_android_orderInCategory, 0);
            this.f1221f = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuGroup_android_checkableBehavior, 0);
            this.g = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuGroup_android_visible, true);
            this.h = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void b() {
            this.i = true;
            a(this.f1217b.add(this.f1218c, this.j, this.k, this.l));
        }

        public void b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f1211e.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.MenuItem);
            this.j = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.MenuItem_android_id, 0);
            this.k = (typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuItem_android_menuCategory, this.f1219d) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuItem_android_orderInCategory, this.f1220e) & 65535);
            this.l = typedArrayObtainStyledAttributes.getText(android.support.v7.b.a.k.MenuItem_android_title);
            this.m = typedArrayObtainStyledAttributes.getText(android.support.v7.b.a.k.MenuItem_android_titleCondensed);
            this.n = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.MenuItem_android_icon, 0);
            this.o = a(typedArrayObtainStyledAttributes.getString(android.support.v7.b.a.k.MenuItem_android_alphabeticShortcut));
            this.p = a(typedArrayObtainStyledAttributes.getString(android.support.v7.b.a.k.MenuItem_android_numericShortcut));
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.MenuItem_android_checkable)) {
                this.q = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.q = this.f1221f;
            }
            this.r = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuItem_android_checked, false);
            this.s = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuItem_android_visible, this.g);
            this.t = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuItem_android_enabled, this.h);
            this.u = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.MenuItem_showAsAction, -1);
            this.y = typedArrayObtainStyledAttributes.getString(android.support.v7.b.a.k.MenuItem_android_onClick);
            this.v = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.MenuItem_actionLayout, 0);
            this.w = typedArrayObtainStyledAttributes.getString(android.support.v7.b.a.k.MenuItem_actionViewClass);
            this.x = typedArrayObtainStyledAttributes.getString(android.support.v7.b.a.k.MenuItem_actionProviderClass);
            boolean z = this.x != null;
            if (z && this.v == 0 && this.w == null) {
                this.z = (android.support.v4.view.d) a(this.x, g.f1208b, g.this.f1210d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.z = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.i = false;
        }

        public SubMenu c() {
            this.i = true;
            SubMenu subMenuAddSubMenu = this.f1217b.addSubMenu(this.f1218c, this.j, this.k, this.l);
            a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.i;
        }
    }

    public g(Context context) {
        super(context);
        this.f1211e = context;
        this.f1209c = new Object[]{context};
        this.f1210d = this.f1209c;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
                break;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z = false;
        int next = eventType;
        boolean z2 = false;
        while (!z2) {
            switch (next) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (z) {
                        z = z;
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals("group")) {
                            bVar.a(attributeSet);
                            z = z;
                        } else if (name2.equals("item")) {
                            bVar.b(attributeSet);
                            z = z;
                        } else if (name2.equals("menu")) {
                            a(xmlPullParser, attributeSet, bVar.c());
                            z = z;
                        } else {
                            str = name2;
                            z = true;
                        }
                    }
                    boolean z3 = z;
                    next = xmlPullParser.next();
                    z = z3;
                    break;
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (z && name3.equals(str)) {
                        str = null;
                        z = false;
                    } else if (name3.equals("group")) {
                        bVar.a();
                        z = z;
                    } else if (!name3.equals("item")) {
                        if (name3.equals("menu")) {
                            z2 = true;
                            z = z;
                        }
                        break;
                    } else if (bVar.d()) {
                        break;
                    } else if (bVar.z == null || !bVar.z.e()) {
                        bVar.b();
                        z = z;
                    } else {
                        bVar.c();
                        z = z;
                    }
                    boolean z4 = z;
                    next = xmlPullParser.next();
                    z = z4;
                    break;
            }
            boolean z5 = z;
            next = xmlPullParser.next();
            z = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c() {
        if (this.f1212f == null) {
            this.f1212f = a(this.f1211e);
        }
        return this.f1212f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof android.support.v4.d.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                layout = this.f1211e.getResources().getLayout(i);
                a(layout, Xml.asAttributeSet(layout), menu);
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
