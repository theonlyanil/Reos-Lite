package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f1805b;
    private WeakHashMap<Context, SparseArray<ColorStateList>> j;
    private android.support.v4.h.a<String, c> k;
    private SparseArray<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, android.support.v4.h.e<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap<>(0);
    private TypedValue o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f1804a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f1806c = new b(6);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1807d = {android.support.v7.b.a.e.abc_textfield_search_default_mtrl_alpha, android.support.v7.b.a.e.abc_textfield_default_mtrl_alpha, android.support.v7.b.a.e.abc_ab_share_pack_mtrl_alpha};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f1808e = {android.support.v7.b.a.e.abc_ic_ab_back_mtrl_am_alpha, android.support.v7.b.a.e.abc_ic_go_search_api_mtrl_alpha, android.support.v7.b.a.e.abc_ic_search_api_mtrl_alpha, android.support.v7.b.a.e.abc_ic_commit_search_api_mtrl_alpha, android.support.v7.b.a.e.abc_ic_clear_mtrl_alpha, android.support.v7.b.a.e.abc_ic_menu_share_mtrl_alpha, android.support.v7.b.a.e.abc_ic_menu_copy_mtrl_am_alpha, android.support.v7.b.a.e.abc_ic_menu_cut_mtrl_alpha, android.support.v7.b.a.e.abc_ic_menu_selectall_mtrl_alpha, android.support.v7.b.a.e.abc_ic_menu_paste_mtrl_am_alpha, android.support.v7.b.a.e.abc_ic_menu_moreoverflow_mtrl_alpha, android.support.v7.b.a.e.abc_ic_voice_search_api_mtrl_alpha};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f1809f = {android.support.v7.b.a.e.abc_textfield_activated_mtrl_alpha, android.support.v7.b.a.e.abc_textfield_search_activated_mtrl_alpha, android.support.v7.b.a.e.abc_cab_background_top_mtrl_alpha, android.support.v7.b.a.e.abc_text_cursor_material};
    private static final int[] g = {android.support.v7.b.a.e.abc_popup_background_mtrl_mult, android.support.v7.b.a.e.abc_cab_background_internal_bg, android.support.v7.b.a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {android.support.v7.b.a.e.abc_edit_text_material, android.support.v7.b.a.e.abc_tab_indicator_material, android.support.v7.b.a.e.abc_textfield_search_material, android.support.v7.b.a.e.abc_spinner_mtrl_am_alpha, android.support.v7.b.a.e.abc_spinner_textfield_background_material, android.support.v7.b.a.e.abc_ratingbar_full_material, android.support.v7.b.a.e.abc_switch_track_mtrl_alpha, android.support.v7.b.a.e.abc_switch_thumb_material, android.support.v7.b.a.e.abc_btn_default_mtrl_shape, android.support.v7.b.a.e.abc_btn_borderless_material};
    private static final int[] i = {android.support.v7.b.a.e.abc_btn_check_material, android.support.v7.b.a.e.abc_btn_radio_material};

    private static class a implements c {
        private a() {
        }

        @Override // android.support.v7.widget.h.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class b extends android.support.v4.h.f<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    private static class d implements c {
        private d() {
        }

        @Override // android.support.v7.widget.h.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.b.a.f.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private ColorStateList a(Context context) {
        int iA = ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal);
        int iA2 = ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated);
        return new ColorStateList(new int[][]{ak.f1734a, ak.f1735b, ak.f1736c, ak.f1737d, ak.f1738e, ak.f1739f, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorControlNormal), iA2, iA2, iA2, iA2, iA2, iA});
    }

    public static PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA = f1806c.a(i2, mode);
        if (porterDuffColorFilterA != null) {
            return porterDuffColorFilterA;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        f1806c.a(i2, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null) {
            if (w.c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableF = android.support.v4.c.a.a.f(drawable);
            android.support.v4.c.a.a.a(drawableF, colorStateListB);
            PorterDuff.Mode modeA = a(i2);
            if (modeA == null) {
                return drawableF;
            }
            android.support.v4.c.a.a.a(drawableF, modeA);
            return drawableF;
        }
        if (i2 == android.support.v7.b.a.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(R.id.background), ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal), f1804a);
            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal), f1804a);
            a(layerDrawable.findDrawableByLayerId(R.id.progress), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated), f1804a);
            return drawable;
        }
        if (i2 != android.support.v7.b.a.e.abc_ratingbar_indicator_material && i2 != android.support.v7.b.a.e.abc_ratingbar_small_material) {
            if (a(context, i2, drawable) || !z) {
                return drawable;
            }
            return null;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        a(layerDrawable2.findDrawableByLayerId(R.id.background), ak.c(context, android.support.v7.b.a.C0029a.colorControlNormal), f1804a);
        a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated), f1804a);
        a(layerDrawable2.findDrawableByLayerId(R.id.progress), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated), f1804a);
        return drawable;
    }

    private Drawable a(Context context, long j) {
        synchronized (this.m) {
            android.support.v4.h.e<WeakReference<Drawable.ConstantState>> eVar = this.n.get(context);
            if (eVar == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReferenceA = eVar.a(j);
            if (weakReferenceA != null) {
                Drawable.ConstantState constantState = weakReferenceA.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                eVar.b(j);
            }
            return null;
        }
    }

    public static h a() {
        if (f1805b == null) {
            f1805b = new h();
            a(f1805b);
        }
        return f1805b;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        SparseArray<ColorStateList> sparseArray = this.j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.j.put(context, sparseArray);
        }
        sparseArray.append(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (w.c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1804a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    public static void a(Drawable drawable, an anVar, int[] iArr) {
        if (w.c(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (anVar.f1746d || anVar.f1745c) {
            drawable.setColorFilter(a(anVar.f1746d ? anVar.f1743a : null, anVar.f1745c ? anVar.f1744b : f1804a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static void a(h hVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            hVar.a("vector", new d());
            if (i2 >= 11) {
                hVar.a("animated-vector", new a());
            }
        }
    }

    private void a(String str, c cVar) {
        if (this.k == null) {
            this.k = new android.support.v4.h.a<>();
        }
        this.k.put(str, cVar);
    }

    static boolean a(Context context, int i2, Drawable drawable) {
        int iRound;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = f1804a;
        if (a(f1807d, i2)) {
            i3 = android.support.v7.b.a.C0029a.colorControlNormal;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (a(f1809f, i2)) {
            i3 = android.support.v7.b.a.C0029a.colorControlActivated;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (a(g, i2)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            iRound = -1;
        } else if (i2 == android.support.v7.b.a.e.abc_list_divider_mtrl_alpha) {
            i3 = R.attr.colorForeground;
            iRound = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            iRound = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (w.c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(ak.a(context, i3), mode));
        if (iRound == -1) {
            return true;
        }
        drawable.setAlpha(iRound);
        return true;
    }

    private boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            android.support.v4.h.e<WeakReference<Drawable.ConstantState>> eVar = this.n.get(context);
            if (eVar == null) {
                eVar = new android.support.v4.h.e<>();
                this.n.put(context, eVar);
            }
            eVar.b(j, new WeakReference<>(constantState));
        }
        return true;
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return new ColorStateList(new int[][]{ak.f1734a, ak.f1738e, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorControlNormal), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated), ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal)});
    }

    private ColorStateList c(Context context) {
        return new ColorStateList(new int[][]{ak.f1734a, ak.f1738e, ak.h}, new int[]{ak.a(context, R.attr.colorForeground, 0.1f), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated, 0.3f), ak.a(context, R.attr.colorForeground, 0.3f)});
    }

    private Drawable c(Context context, int i2) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA == null) {
            if (i2 == android.support.v7.b.a.e.abc_cab_background_top_material) {
                drawableA = new LayerDrawable(new Drawable[]{a(context, android.support.v7.b.a.e.abc_cab_background_internal_bg), a(context, android.support.v7.b.a.e.abc_cab_background_top_mtrl_alpha)});
            }
            if (drawableA != null) {
                drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, jA, drawableA);
            }
        }
        return drawableA;
    }

    private ColorStateList d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListB = ak.b(context, android.support.v7.b.a.C0029a.colorSwitchThumbNormal);
        if (colorStateListB == null || !colorStateListB.isStateful()) {
            iArr[0] = ak.f1734a;
            iArr2[0] = ak.c(context, android.support.v7.b.a.C0029a.colorSwitchThumbNormal);
            iArr[1] = ak.f1738e;
            iArr2[1] = ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated);
            iArr[2] = ak.h;
            iArr2[2] = ak.a(context, android.support.v7.b.a.C0029a.colorSwitchThumbNormal);
        } else {
            iArr[0] = ak.f1734a;
            iArr2[0] = colorStateListB.getColorForState(iArr[0], 0);
            iArr[1] = ak.f1738e;
            iArr2[1] = ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated);
            iArr[2] = ak.h;
            iArr2[2] = colorStateListB.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private Drawable d(Context context, int i2) {
        Drawable drawable;
        int next;
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        if (this.l != null) {
            String str = this.l.get(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.k.get(str) == null)) {
                return null;
            }
        } else {
            this.l = new SparseArray<>();
        }
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string == null || !typedValue.string.toString().endsWith(".xml")) {
            drawable = drawableA;
        } else {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.l.append(i2, name);
                c cVar = this.k.get(name);
                if (cVar != null) {
                    drawableA = cVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    if (a(context, jA, drawableA)) {
                    }
                }
                drawable = drawableA;
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManager", "Exception while inflating drawable", e2);
                drawable = drawableA;
            }
        }
        if (drawable != null) {
            return drawable;
        }
        this.l.append(i2, "appcompat_skip_skip");
        return drawable;
    }

    private ColorStateList e(Context context) {
        return new ColorStateList(new int[][]{ak.f1734a, ak.g, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorControlNormal), ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated)});
    }

    private ColorStateList e(Context context, int i2) {
        SparseArray<ColorStateList> sparseArray;
        if (this.j != null && (sparseArray = this.j.get(context)) != null) {
            return sparseArray.get(i2);
        }
        return null;
    }

    private ColorStateList f(Context context) {
        return f(context, ak.a(context, android.support.v7.b.a.C0029a.colorButtonNormal));
    }

    private ColorStateList f(Context context, int i2) {
        int iA = ak.a(context, android.support.v7.b.a.C0029a.colorControlHighlight);
        return new ColorStateList(new int[][]{ak.f1734a, ak.f1737d, ak.f1735b, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorButtonNormal), android.support.v4.c.a.a(iA, i2), android.support.v4.c.a.a(iA, i2), i2});
    }

    private ColorStateList g(Context context) {
        return f(context, 0);
    }

    private ColorStateList h(Context context) {
        return f(context, ak.a(context, android.support.v7.b.a.C0029a.colorAccent));
    }

    private ColorStateList i(Context context) {
        return new ColorStateList(new int[][]{ak.f1734a, ak.g, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorControlNormal), ak.a(context, android.support.v7.b.a.C0029a.colorControlNormal), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated)});
    }

    private ColorStateList j(Context context) {
        return new ColorStateList(new int[][]{ak.f1734a, ak.h}, new int[]{ak.c(context, android.support.v7.b.a.C0029a.colorControlActivated), ak.a(context, android.support.v7.b.a.C0029a.colorControlActivated)});
    }

    final PorterDuff.Mode a(int i2) {
        if (i2 == android.support.v7.b.a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    public Drawable a(Context context, int i2, boolean z) {
        Drawable drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = c(context, i2);
        }
        if (drawableD == null) {
            drawableD = android.support.v4.b.b.a(context, i2);
        }
        if (drawableD != null) {
            drawableD = a(context, i2, z, drawableD);
        }
        if (drawableD != null) {
            w.b(drawableD);
        }
        return drawableD;
    }

    public final Drawable a(Context context, ar arVar, int i2) {
        Drawable drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = arVar.a(i2);
        }
        if (drawableD != null) {
            return a(context, i2, false, drawableD);
        }
        return null;
    }

    public final ColorStateList b(Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE == null) {
            if (i2 == android.support.v7.b.a.e.abc_edit_text_material) {
                colorStateListE = e(context);
            } else if (i2 == android.support.v7.b.a.e.abc_switch_track_mtrl_alpha) {
                colorStateListE = c(context);
            } else if (i2 == android.support.v7.b.a.e.abc_switch_thumb_material) {
                colorStateListE = d(context);
            } else if (i2 == android.support.v7.b.a.e.abc_btn_default_mtrl_shape) {
                colorStateListE = f(context);
            } else if (i2 == android.support.v7.b.a.e.abc_btn_borderless_material) {
                colorStateListE = g(context);
            } else if (i2 == android.support.v7.b.a.e.abc_btn_colored_material) {
                colorStateListE = h(context);
            } else if (i2 == android.support.v7.b.a.e.abc_spinner_mtrl_am_alpha || i2 == android.support.v7.b.a.e.abc_spinner_textfield_background_material) {
                colorStateListE = i(context);
            } else if (a(f1808e, i2)) {
                colorStateListE = ak.b(context, android.support.v7.b.a.C0029a.colorControlNormal);
            } else if (a(h, i2)) {
                colorStateListE = a(context);
            } else if (a(i, i2)) {
                colorStateListE = b(context);
            } else if (i2 == android.support.v7.b.a.e.abc_seekbar_thumb_material) {
                colorStateListE = j(context);
            }
            if (colorStateListE != null) {
                a(context, i2, colorStateListE);
            }
        }
        return colorStateListE;
    }
}
