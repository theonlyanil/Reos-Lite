package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class f extends android.support.b.a.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PorterDuff.Mode f167b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0005f f168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuffColorFilter f169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorFilter f170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f171f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private static class a extends d {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.m = android.support.b.a.c.a(string2);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (android.support.b.a.d.a(xmlPullParser, "pathData")) {
                TypedArray typedArrayB = android.support.b.a.e.b(resources, theme, attributeSet, android.support.b.a.a.f149d);
                a(typedArrayB);
                typedArrayB.recycle();
            }
        }

        @Override // android.support.b.a.f.d
        public boolean a() {
            return true;
        }
    }

    private static class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f177f;
        float g;
        float h;
        float i;
        Paint.Cap j;
        Paint.Join k;
        float l;
        private int[] p;

        public b() {
            this.f172a = 0;
            this.f173b = BitmapDescriptorFactory.HUE_RED;
            this.f174c = 0;
            this.f175d = 1.0f;
            this.f177f = 1.0f;
            this.g = BitmapDescriptorFactory.HUE_RED;
            this.h = 1.0f;
            this.i = BitmapDescriptorFactory.HUE_RED;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.f172a = 0;
            this.f173b = BitmapDescriptorFactory.HUE_RED;
            this.f174c = 0;
            this.f175d = 1.0f;
            this.f177f = 1.0f;
            this.g = BitmapDescriptorFactory.HUE_RED;
            this.h = 1.0f;
            this.i = BitmapDescriptorFactory.HUE_RED;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
            this.p = bVar.p;
            this.f172a = bVar.f172a;
            this.f173b = bVar.f173b;
            this.f175d = bVar.f175d;
            this.f174c = bVar.f174c;
            this.f176e = bVar.f176e;
            this.f177f = bVar.f177f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Paint.Join a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.p = null;
            if (android.support.b.a.d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.m = android.support.b.a.c.a(string2);
                }
                this.f174c = android.support.b.a.d.b(typedArray, xmlPullParser, "fillColor", 1, this.f174c);
                this.f177f = android.support.b.a.d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f177f);
                this.j = a(android.support.b.a.d.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(android.support.b.a.d.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = android.support.b.a.d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.f172a = android.support.b.a.d.b(typedArray, xmlPullParser, "strokeColor", 3, this.f172a);
                this.f175d = android.support.b.a.d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f175d);
                this.f173b = android.support.b.a.d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f173b);
                this.h = android.support.b.a.d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = android.support.b.a.d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = android.support.b.a.d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayB = android.support.b.a.e.b(resources, theme, attributeSet, android.support.b.a.a.f148c);
            a(typedArrayB, xmlPullParser);
            typedArrayB.recycle();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<Object> f178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Matrix f179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f182e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f183f;
        private float g;
        private float h;
        private float i;
        private final Matrix j;
        private int k;
        private int[] l;
        private String m;

        public c() {
            this.f179b = new Matrix();
            this.f178a = new ArrayList<>();
            this.f180c = BitmapDescriptorFactory.HUE_RED;
            this.f181d = BitmapDescriptorFactory.HUE_RED;
            this.f182e = BitmapDescriptorFactory.HUE_RED;
            this.f183f = 1.0f;
            this.g = 1.0f;
            this.h = BitmapDescriptorFactory.HUE_RED;
            this.i = BitmapDescriptorFactory.HUE_RED;
            this.j = new Matrix();
            this.m = null;
        }

        public c(c cVar, android.support.v4.h.a<String, Object> aVar) {
            d aVar2;
            this.f179b = new Matrix();
            this.f178a = new ArrayList<>();
            this.f180c = BitmapDescriptorFactory.HUE_RED;
            this.f181d = BitmapDescriptorFactory.HUE_RED;
            this.f182e = BitmapDescriptorFactory.HUE_RED;
            this.f183f = 1.0f;
            this.g = 1.0f;
            this.h = BitmapDescriptorFactory.HUE_RED;
            this.i = BitmapDescriptorFactory.HUE_RED;
            this.j = new Matrix();
            this.m = null;
            this.f180c = cVar.f180c;
            this.f181d = cVar.f181d;
            this.f182e = cVar.f182e;
            this.f183f = cVar.f183f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            if (this.m != null) {
                aVar.put(this.m, this);
            }
            this.j.set(cVar.j);
            ArrayList<Object> arrayList = cVar.f178a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                Object obj = arrayList.get(i2);
                if (obj instanceof c) {
                    this.f178a.add(new c((c) obj, aVar));
                } else {
                    if (obj instanceof b) {
                        aVar2 = new b((b) obj);
                    } else {
                        if (!(obj instanceof a)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        aVar2 = new a((a) obj);
                    }
                    this.f178a.add(aVar2);
                    if (aVar2.n != null) {
                        aVar.put(aVar2.n, aVar2);
                    }
                }
                i = i2 + 1;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f180c = android.support.b.a.d.a(typedArray, xmlPullParser, "rotation", 5, this.f180c);
            this.f181d = typedArray.getFloat(1, this.f181d);
            this.f182e = typedArray.getFloat(2, this.f182e);
            this.f183f = android.support.b.a.d.a(typedArray, xmlPullParser, "scaleX", 3, this.f183f);
            this.g = android.support.b.a.d.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = android.support.b.a.d.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = android.support.b.a.d.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.f181d, -this.f182e);
            this.j.postScale(this.f183f, this.g);
            this.j.postRotate(this.f180c, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.j.postTranslate(this.h + this.f181d, this.i + this.f182e);
        }

        public String a() {
            return this.m;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayB = android.support.b.a.e.b(resources, theme, attributeSet, android.support.b.a.a.f147b);
            a(typedArrayB, xmlPullParser);
            typedArrayB.recycle();
        }
    }

    private static class d {
        protected android.support.b.a.c.b[] m;
        String n;
        int o;

        public d() {
            this.m = null;
        }

        public d(d dVar) {
            this.m = null;
            this.n = dVar.n;
            this.o = dVar.o;
            this.m = android.support.b.a.c.a(dVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                android.support.b.a.c.b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public String b() {
            return this.n;
        }
    }

    private static class e {
        private static final Matrix j = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f187d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f188e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f189f;
        final android.support.v4.h.a<String, Object> g;
        private final Path h;
        private final Path i;
        private final Matrix k;
        private Paint l;
        private Paint m;
        private PathMeasure n;
        private int o;
        private final c p;

        public e() {
            this.k = new Matrix();
            this.f184a = BitmapDescriptorFactory.HUE_RED;
            this.f185b = BitmapDescriptorFactory.HUE_RED;
            this.f186c = BitmapDescriptorFactory.HUE_RED;
            this.f187d = BitmapDescriptorFactory.HUE_RED;
            this.f188e = 255;
            this.f189f = null;
            this.g = new android.support.v4.h.a<>();
            this.p = new c();
            this.h = new Path();
            this.i = new Path();
        }

        public e(e eVar) {
            this.k = new Matrix();
            this.f184a = BitmapDescriptorFactory.HUE_RED;
            this.f185b = BitmapDescriptorFactory.HUE_RED;
            this.f186c = BitmapDescriptorFactory.HUE_RED;
            this.f187d = BitmapDescriptorFactory.HUE_RED;
            this.f188e = 255;
            this.f189f = null;
            this.g = new android.support.v4.h.a<>();
            this.p = new c(eVar.p, this.g);
            this.h = new Path(eVar.h);
            this.i = new Path(eVar.i);
            this.f184a = eVar.f184a;
            this.f185b = eVar.f185b;
            this.f186c = eVar.f186c;
            this.f187d = eVar.f187d;
            this.o = eVar.o;
            this.f188e = eVar.f188e;
            this.f189f = eVar.f189f;
            if (eVar.f189f != null) {
                this.g.put(eVar.f189f, this);
            }
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private float a(Matrix matrix) {
            float[] fArr = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            return fMax > BitmapDescriptorFactory.HUE_RED ? Math.abs(fA) / fMax : BitmapDescriptorFactory.HUE_RED;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f179b.set(matrix);
            cVar.f179b.preConcat(cVar.j);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= cVar.f178a.size()) {
                    return;
                }
                Object obj = cVar.f178a.get(i4);
                if (obj instanceof c) {
                    a((c) obj, cVar.f179b, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    a(cVar, (d) obj, canvas, i, i2, colorFilter);
                }
                i3 = i4 + 1;
            }
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f2 = i / this.f186c;
            float f3 = i2 / this.f187d;
            float fMin = Math.min(f2, f3);
            Matrix matrix = cVar.f179b;
            this.k.set(matrix);
            this.k.postScale(f2, f3);
            float fA = a(matrix);
            if (fA == BitmapDescriptorFactory.HUE_RED) {
                return;
            }
            dVar.a(this.h);
            Path path = this.h;
            this.i.reset();
            if (dVar.a()) {
                this.i.addPath(path, this.k);
                canvas.clipPath(this.i, Region.Op.REPLACE);
                return;
            }
            b bVar = (b) dVar;
            if (bVar.g != BitmapDescriptorFactory.HUE_RED || bVar.h != 1.0f) {
                float f4 = (bVar.g + bVar.i) % 1.0f;
                float f5 = (bVar.h + bVar.i) % 1.0f;
                if (this.n == null) {
                    this.n = new PathMeasure();
                }
                this.n.setPath(this.h, false);
                float length = this.n.getLength();
                float f6 = f4 * length;
                float f7 = f5 * length;
                path.reset();
                if (f6 > f7) {
                    this.n.getSegment(f6, length, path, true);
                    this.n.getSegment(BitmapDescriptorFactory.HUE_RED, f7, path, true);
                } else {
                    this.n.getSegment(f6, f7, path, true);
                }
                path.rLineTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            }
            this.i.addPath(path, this.k);
            if (bVar.f174c != 0) {
                if (this.m == null) {
                    this.m = new Paint();
                    this.m.setStyle(Paint.Style.FILL);
                    this.m.setAntiAlias(true);
                }
                Paint paint = this.m;
                paint.setColor(f.b(bVar.f174c, bVar.f177f));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.i, paint);
            }
            if (bVar.f172a != 0) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setStyle(Paint.Style.STROKE);
                    this.l.setAntiAlias(true);
                }
                Paint paint2 = this.l;
                if (bVar.k != null) {
                    paint2.setStrokeJoin(bVar.k);
                }
                if (bVar.j != null) {
                    paint2.setStrokeCap(bVar.j);
                }
                paint2.setStrokeMiter(bVar.l);
                paint2.setColor(f.b(bVar.f172a, bVar.f175d));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(fA * fMin * bVar.f173b);
                canvas.drawPath(this.i, paint2);
            }
        }

        public int a() {
            return this.f188e;
        }

        public void a(float f2) {
            a((int) (255.0f * f2));
        }

        public void a(int i) {
            this.f188e = i;
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.p, j, canvas, i, i2, colorFilter);
        }

        public float b() {
            return a() / 255.0f;
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.f$f, reason: collision with other inner class name */
    private static class C0005f extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f195f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public C0005f() {
            this.f192c = null;
            this.f193d = f.f167b;
            this.f191b = new e();
        }

        public C0005f(C0005f c0005f) {
            this.f192c = null;
            this.f193d = f.f167b;
            if (c0005f != null) {
                this.f190a = c0005f.f190a;
                this.f191b = new e(c0005f.f191b);
                if (c0005f.f191b.m != null) {
                    this.f191b.m = new Paint(c0005f.f191b.m);
                }
                if (c0005f.f191b.l != null) {
                    this.f191b.l = new Paint(c0005f.f191b.l);
                }
                this.f192c = c0005f.f192c;
                this.f193d = c0005f.f193d;
                this.f194e = c0005f.f194e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f191b.a());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i, int i2) {
            this.f195f.eraseColor(0);
            this.f191b.a(new Canvas(this.f195f), i, i2, (ColorFilter) null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f195f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.f191b.a() < 255;
        }

        public void b(int i, int i2) {
            if (this.f195f == null || !c(i, i2)) {
                this.f195f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return !this.k && this.g == this.f192c && this.h == this.f193d && this.j == this.f194e && this.i == this.f191b.a();
        }

        public void c() {
            this.g = this.f192c;
            this.h = this.f193d;
            this.i = this.f191b.a();
            this.j = this.f194e;
            this.k = false;
        }

        public boolean c(int i, int i2) {
            return i == this.f195f.getWidth() && i2 == this.f195f.getHeight();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f190a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    private static class g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f196a;

        public g(Drawable.ConstantState constantState) {
            this.f196a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f196a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f196a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f166a = (VectorDrawable) this.f196a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f166a = (VectorDrawable) this.f196a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f166a = (VectorDrawable) this.f196a.newDrawable(resources, theme);
            return fVar;
        }
    }

    private f() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f168c = new C0005f();
    }

    private f(C0005f c0005f) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f168c = c0005f;
        this.f169d = a(this.f169d, c0005f.f192c, c0005f.f193d);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }

    public static f a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.f166a = android.support.v4.b.a.a.a(resources, i, theme);
            fVar.h = new g(fVar.f166a.getConstantState());
            return fVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
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
            return a(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0005f c0005f = this.f168c;
        e eVar = c0005f.f191b;
        c0005f.f193d = a(android.support.b.a.d.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0005f.f192c = colorStateList;
        }
        c0005f.f194e = android.support.b.a.d.a(typedArray, xmlPullParser, "autoMirrored", 5, c0005f.f194e);
        eVar.f186c = android.support.b.a.d.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.f186c);
        eVar.f187d = android.support.b.a.d.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.f187d);
        if (eVar.f186c <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.f187d <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        eVar.f184a = typedArray.getDimension(3, eVar.f184a);
        eVar.f185b = typedArray.getDimension(2, eVar.f185b);
        if (eVar.f184a <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (eVar.f185b <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        eVar.a(android.support.b.a.d.a(typedArray, xmlPullParser, "alpha", 4, eVar.b()));
        String string = typedArray.getString(0);
        if (string != null) {
            eVar.f189f = string;
            eVar.g.put(string, eVar);
        }
    }

    private boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, float f2) {
        return (((int) (Color.alpha(i) * f2)) << 24) | (16777215 & i);
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        C0005f c0005f = this.f168c;
        e eVar = c0005f.f191b;
        Stack stack = new Stack();
        stack.push(eVar.p);
        int eventType = xmlPullParser.getEventType();
        boolean z2 = true;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f178a.add(bVar);
                    if (bVar.b() != null) {
                        eVar.g.put(bVar.b(), bVar);
                    }
                    z = false;
                    c0005f.f190a = bVar.o | c0005f.f190a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f178a.add(aVar);
                    if (aVar.b() != null) {
                        eVar.g.put(aVar.b(), aVar);
                    }
                    c0005f.f190a |= aVar.o;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.f178a.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.a() != null) {
                            eVar.g.put(cVar2.a(), cVar2);
                        }
                        c0005f.f190a |= cVar2.k;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + ((Object) stringBuffer) + " defined");
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object a(String str) {
        return this.f168c.f191b.g.get(str);
    }

    void a(boolean z) {
        this.g = z;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f166a == null) {
            return false;
        }
        android.support.v4.c.a.a.d(this.f166a);
        return false;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f166a != null) {
            this.f166a.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f170e == null ? this.f169d : this.f170e;
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float fAbs = Math.abs(this.i[0]);
        float fAbs2 = Math.abs(this.i[4]);
        float fAbs3 = Math.abs(this.i[1]);
        float fAbs4 = Math.abs(this.i[3]);
        if (fAbs3 != BitmapDescriptorFactory.HUE_RED || fAbs4 != BitmapDescriptorFactory.HUE_RED) {
            fAbs2 = 1.0f;
            fAbs = 1.0f;
        }
        int iWidth = (int) (fAbs * this.k.width());
        int iHeight = (int) (fAbs2 * this.k.height());
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.k.left, this.k.top);
        if (a()) {
            canvas.translate(this.k.width(), BitmapDescriptorFactory.HUE_RED);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.f168c.b(iMin, iMin2);
        if (!this.g) {
            this.f168c.a(iMin, iMin2);
        } else if (!this.f168c.b()) {
            this.f168c.a(iMin, iMin2);
            this.f168c.c();
        }
        this.f168c.a(canvas, colorFilter, this.k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f166a != null ? android.support.v4.c.a.a.c(this.f166a) : this.f168c.f191b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f166a != null ? this.f166a.getChangingConfigurations() : super.getChangingConfigurations() | this.f168c.getChangingConfigurations();
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f166a != null) {
            return new g(this.f166a.getConstantState());
        }
        this.f168c.f190a = getChangingConfigurations();
        return this.f168c;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f166a != null ? this.f166a.getIntrinsicHeight() : (int) this.f168c.f191b.f185b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f166a != null ? this.f166a.getIntrinsicWidth() : (int) this.f168c.f191b.f184a;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f166a != null) {
            return this.f166a.getOpacity();
        }
        return -3;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f166a != null) {
            this.f166a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0005f c0005f = this.f168c;
        c0005f.f191b = new e();
        TypedArray typedArrayB = b(resources, theme, attributeSet, android.support.b.a.a.f146a);
        a(typedArrayB, xmlPullParser);
        typedArrayB.recycle();
        c0005f.f190a = getChangingConfigurations();
        c0005f.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.f169d = a(this.f169d, c0005f.f192c, c0005f.f193d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f166a != null) {
            this.f166a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f166a != null) {
            return this.f166a.isStateful();
        }
        return super.isStateful() || !(this.f168c == null || this.f168c.f192c == null || !this.f168c.f192c.isStateful());
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f166a != null) {
            this.f166a.mutate();
        } else if (!this.f171f && super.mutate() == this) {
            this.f168c = new C0005f(this.f168c);
            this.f171f = true;
        }
        return this;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f166a != null) {
            this.f166a.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f166a != null) {
            return this.f166a.setState(iArr);
        }
        C0005f c0005f = this.f168c;
        if (c0005f.f192c == null || c0005f.f193d == null) {
            return false;
        }
        this.f169d = a(this.f169d, c0005f.f192c, c0005f.f193d);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f166a != null) {
            this.f166a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f166a != null) {
            this.f166a.setAlpha(i);
        } else if (this.f168c.f191b.a() != i) {
            this.f168c.f191b.a(i);
            invalidateSelf();
        }
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f166a != null) {
            this.f166a.setColorFilter(colorFilter);
        } else {
            this.f170e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTint(int i) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintList(ColorStateList colorStateList) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, colorStateList);
            return;
        }
        C0005f c0005f = this.f168c;
        if (c0005f.f192c != colorStateList) {
            c0005f.f192c = colorStateList;
            this.f169d = a(this.f169d, colorStateList, c0005f.f193d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, mode);
            return;
        }
        C0005f c0005f = this.f168c;
        if (c0005f.f193d != mode) {
            c0005f.f193d = mode;
            this.f169d = a(this.f169d, c0005f.f192c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f166a != null ? this.f166a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f166a != null) {
            this.f166a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
