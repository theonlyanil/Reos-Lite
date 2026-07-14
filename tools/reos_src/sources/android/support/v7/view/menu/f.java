package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements android.support.v4.d.a.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1272d = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CharSequence f1273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable f1274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f1275c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f1276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Resources f1277f;
    private boolean g;
    private boolean h;
    private a i;
    private ContextMenu.ContextMenuInfo q;
    private h x;
    private boolean y;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<h> v = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<l>> w = new CopyOnWriteArrayList<>();
    private ArrayList<h> j = new ArrayList<>();
    private ArrayList<h> k = new ArrayList<>();
    private boolean l = true;
    private ArrayList<h> m = new ArrayList<>();
    private ArrayList<h> n = new ArrayList<>();
    private boolean o = true;

    public interface a {
        void a(f fVar);

        boolean a(f fVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(h hVar);
    }

    public f(Context context) {
        this.f1276e = context;
        this.f1277f = context.getResources();
        e(true);
    }

    private static int a(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private h a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new h(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesD = d();
        if (view != null) {
            this.f1275c = view;
            this.f1273a = null;
            this.f1274b = null;
        } else {
            if (i > 0) {
                this.f1273a = resourcesD.getText(i);
            } else if (charSequence != null) {
                this.f1273a = charSequence;
            }
            if (i2 > 0) {
                this.f1274b = android.support.v4.b.b.a(e(), i2);
            } else if (drawable != null) {
                this.f1274b = drawable;
            }
            this.f1275c = null;
        }
        a(false);
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.j.size()) {
            return;
        }
        this.j.remove(i);
        if (z) {
            a(true);
        }
    }

    private boolean a(p pVar, l lVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean zA = lVar != null ? lVar.a(pVar) : false;
        Iterator<WeakReference<l>> it = this.w.iterator();
        while (true) {
            boolean zA2 = zA;
            if (!it.hasNext()) {
                return zA2;
            }
            WeakReference<l> next = it.next();
            l lVar2 = next.get();
            if (lVar2 == null) {
                this.w.remove(next);
            } else if (!zA2) {
                zA2 = lVar2.a(pVar);
            }
            zA = zA2;
        }
    }

    private static int d(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f1272d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f1272d[i2] << 16) | (65535 & i);
    }

    private void d(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        g();
        for (WeakReference<l> weakReference : this.w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.w.remove(weakReference);
            } else {
                lVar.a(z);
            }
        }
        h();
    }

    private void e(Bundle bundle) {
        Parcelable parcelableC;
        if (this.w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<l> weakReference : this.w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.w.remove(weakReference);
            } else {
                int iB = lVar.b();
                if (iB > 0 && (parcelableC = lVar.c()) != null) {
                    sparseArray.put(iB, parcelableC);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private void e(boolean z) {
        this.h = z && this.f1277f.getConfiguration().keyboard != 1 && this.f1277f.getBoolean(android.support.v7.b.a.b.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    private void f(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.w.isEmpty()) {
            return;
        }
        for (WeakReference<l> weakReference : this.w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.w.remove(weakReference);
            } else {
                int iB = lVar.b();
                if (iB > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(iB)) != null) {
                    lVar.a(parcelable);
                }
            }
        }
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public f a(int i) {
        this.p = i;
        return this;
    }

    protected f a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected f a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    protected f a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    h a(int i, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zB = b();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = arrayList.get(i2);
            char alphabeticShortcut = zB ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (zB && alphabeticShortcut == '\b' && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iD = d(i3);
        h hVarA = a(i, i2, i3, iD, charSequence, this.p);
        if (this.q != null) {
            hVarA.a(this.q);
        }
        this.j.add(a(this.j, iD), hVarA);
        a(true);
        return hVarA;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        e(bundle);
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    void a(h hVar) {
        this.l = true;
        a(true);
    }

    public void a(l lVar) {
        a(lVar, this.f1276e);
    }

    public void a(l lVar, Context context) {
        this.w.add(new WeakReference<>(lVar));
        lVar.a(context, this);
        this.o = true;
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.j.get(i);
            if (hVar.getGroupId() == groupId && hVar.g() && hVar.isCheckable()) {
                hVar.b(hVar == menuItem);
            }
        }
    }

    void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean zB = b();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.j.get(i2);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = zB ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zB && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    public void a(boolean z) {
        if (this.r) {
            this.s = true;
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        d(z);
    }

    boolean a(f fVar, MenuItem menuItem) {
        return this.i != null && this.i.a(fVar, menuItem);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (l) null, i);
    }

    public boolean a(MenuItem menuItem, l lVar, int i) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean zB = hVar.b();
        android.support.v4.view.d dVarA = hVar.a();
        boolean z = dVarA != null && dVarA.e();
        if (hVar.n()) {
            boolean zExpandActionView = hVar.expandActionView() | zB;
            if (!zExpandActionView) {
                return zExpandActionView;
            }
            b(true);
            return zExpandActionView;
        }
        if (!hVar.hasSubMenu() && !z) {
            if ((i & 1) == 0) {
                b(true);
            }
            return zB;
        }
        b(false);
        if (!hVar.hasSubMenu()) {
            hVar.a(new p(e(), this, hVar));
        }
        p pVar = (p) hVar.getSubMenu();
        if (z) {
            dVarA.a(pVar);
        }
        boolean zA = a(pVar, lVar) | zB;
        if (zA) {
            return zA;
        }
        b(true);
        return zA;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f1277f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f1277f.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1276e.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1277f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1277f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        p pVar = new p(this.f1276e, this, hVar);
        hVar.a(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        f(bundle);
    }

    void b(h hVar) {
        this.o = true;
        a(true);
    }

    public void b(l lVar) {
        for (WeakReference<l> weakReference : this.w) {
            l lVar2 = weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.w.remove(weakReference);
            }
        }
    }

    public final void b(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        for (WeakReference<l> weakReference : this.w) {
            l lVar = weakReference.get();
            if (lVar == null) {
                this.w.remove(weakReference);
            } else {
                lVar.a(this, z);
            }
        }
        this.u = false;
    }

    boolean b() {
        return this.g;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public void c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray<Parcelable> sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View viewA = android.support.v4.view.q.a(item);
            if (viewA != null && viewA.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                viewA.saveHierarchyState(sparseArray);
                if (android.support.v4.view.q.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray<Parcelable> sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void c(boolean z) {
        this.y = z;
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(h hVar) {
        boolean zA = false;
        if (!this.w.isEmpty()) {
            g();
            Iterator<WeakReference<l>> it = this.w.iterator();
            while (true) {
                boolean z = zA;
                if (!it.hasNext()) {
                    zA = z;
                    break;
                }
                WeakReference<l> next = it.next();
                l lVar = next.get();
                if (lVar == null) {
                    this.w.remove(next);
                    zA = z;
                } else {
                    zA = lVar.a(this, hVar);
                    if (zA) {
                        break;
                    }
                }
            }
            h();
            if (zA) {
                this.x = hVar;
            }
        }
        return zA;
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.x != null) {
            d(this.x);
        }
        this.j.clear();
        a(true);
    }

    public void clearHeader() {
        this.f1274b = null;
        this.f1273a = null;
        this.f1275c = null;
        a(false);
    }

    @Override // android.view.Menu
    public void close() {
        b(true);
    }

    Resources d() {
        return this.f1277f;
    }

    public void d(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(a());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View viewA = android.support.v4.view.q.a(item);
            if (viewA != null && viewA.getId() != -1) {
                viewA.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).d(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        android.support.v4.view.q.b(menuItemFindItem);
    }

    public boolean d(h hVar) {
        boolean zB = false;
        if (!this.w.isEmpty() && this.x == hVar) {
            g();
            Iterator<WeakReference<l>> it = this.w.iterator();
            while (true) {
                boolean z = zB;
                if (!it.hasNext()) {
                    zB = z;
                    break;
                }
                WeakReference<l> next = it.next();
                l lVar = next.get();
                if (lVar == null) {
                    this.w.remove(next);
                    zB = z;
                } else {
                    zB = lVar.b(this, hVar);
                    if (zB) {
                        break;
                    }
                }
            }
            h();
            if (zB) {
                this.x = null;
            }
        }
        return zB;
    }

    public Context e() {
        return this.f1276e;
    }

    public void f() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public void g() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = false;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.j.get(i);
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            a(true);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<h> i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.j.get(i);
            if (hVar.isVisible()) {
                this.k.add(hVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void j() {
        boolean zA;
        ArrayList<h> arrayListI = i();
        if (this.o) {
            boolean z = false;
            for (WeakReference<l> weakReference : this.w) {
                l lVar = weakReference.get();
                if (lVar == null) {
                    this.w.remove(weakReference);
                    zA = z;
                } else {
                    zA = lVar.a() | z;
                }
                z = zA;
            }
            if (z) {
                this.m.clear();
                this.n.clear();
                int size = arrayListI.size();
                for (int i = 0; i < size; i++) {
                    h hVar = arrayListI.get(i);
                    if (hVar.j()) {
                        this.m.add(hVar);
                    } else {
                        this.n.add(hVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList<h> k() {
        j();
        return this.m;
    }

    public ArrayList<h> l() {
        j();
        return this.n;
    }

    public CharSequence m() {
        return this.f1273a;
    }

    public Drawable n() {
        return this.f1274b;
    }

    public View o() {
        return this.f1275c;
    }

    public f p() {
        return this;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        h hVarA = a(i, keyEvent);
        boolean zA = hVarA != null ? a(hVarA, i2) : false;
        if ((i2 & 2) != 0) {
            b(true);
        }
        return zA;
    }

    boolean q() {
        return this.t;
    }

    public h r() {
        return this.x;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iC = c(i);
        if (iC >= 0) {
            int size = this.j.size() - iC;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.j.get(iC).getGroupId() != i) {
                    break;
                }
                a(iC, false);
                i2 = i3;
            }
            a(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.a(z2);
                hVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            h hVar = this.j.get(i2);
            i2++;
            z2 = (hVar.getGroupId() == i && hVar.c(z)) ? true : z2;
        }
        if (z2) {
            a(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.g = z;
        a(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.j.size();
    }
}
