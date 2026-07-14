package com.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.a.a.e.m;
import com.a.a.h.b.k;

/* JADX INFO: loaded from: classes.dex */
public class e<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<ModelType> f2355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f2356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g f2357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Class<TranscodeType> f2358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final m f2359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.a.a.e.g f2360f;
    private com.a.a.g.a<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private com.a.a.d.c i;
    private boolean j;
    private int k;
    private int l;
    private com.a.a.h.f<? super ModelType, TranscodeType> m;
    private Float n;
    private e<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private i s;
    private boolean t;
    private com.a.a.h.a.d<TranscodeType> u;
    private int v;
    private int w;
    private com.a.a.d.b.b x;
    private com.a.a.d.g<ResourceType> y;
    private boolean z;

    /* JADX INFO: renamed from: com.a.a.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2363a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f2363a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2363a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2363a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2363a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    e(Context context, Class<ModelType> cls, com.a.a.g.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, g gVar, m mVar, com.a.a.e.g gVar2) {
        this.i = com.a.a.i.b.a();
        this.p = Float.valueOf(1.0f);
        this.s = null;
        this.t = true;
        this.u = com.a.a.h.a.e.a();
        this.v = -1;
        this.w = -1;
        this.x = com.a.a.d.b.b.RESULT;
        this.y = com.a.a.d.d.d.b();
        this.f2356b = context;
        this.f2355a = cls;
        this.f2358d = cls2;
        this.f2357c = gVar;
        this.f2359e = mVar;
        this.f2360f = gVar2;
        this.g = fVar != null ? new com.a.a.g.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    e(com.a.a.g.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        this(eVar.f2356b, eVar.f2355a, fVar, cls, eVar.f2357c, eVar.f2359e, eVar.f2360f);
        this.h = eVar.h;
        this.j = eVar.j;
        this.i = eVar.i;
        this.x = eVar.x;
        this.t = eVar.t;
    }

    private com.a.a.h.c a(k<TranscodeType> kVar, float f2, i iVar, com.a.a.h.d dVar) {
        return com.a.a.h.b.a(this.g, this.h, this.i, this.f2356b, iVar, kVar, f2, this.q, this.k, this.r, this.l, this.B, this.C, this.m, dVar, this.f2357c.b(), this.y, this.f2358d, this.t, this.u, this.w, this.v, this.x);
    }

    private com.a.a.h.c a(k<TranscodeType> kVar, com.a.a.h.h hVar) {
        if (this.o == null) {
            if (this.n == null) {
                return a(kVar, this.p.floatValue(), this.s, hVar);
            }
            com.a.a.h.h hVar2 = new com.a.a.h.h(hVar);
            hVar2.a(a(kVar, this.p.floatValue(), this.s, hVar2), a(kVar, this.n.floatValue(), a(), hVar2));
            return hVar2;
        }
        if (this.A) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.o.u.equals(com.a.a.h.a.e.a())) {
            this.o.u = this.u;
        }
        if (this.o.s == null) {
            this.o.s = a();
        }
        if (com.a.a.j.h.a(this.w, this.v) && !com.a.a.j.h.a(this.o.w, this.o.v)) {
            this.o.b(this.w, this.v);
        }
        com.a.a.h.h hVar3 = new com.a.a.h.h(hVar);
        com.a.a.h.c cVarA = a(kVar, this.p.floatValue(), this.s, hVar3);
        this.A = true;
        com.a.a.h.c cVarA2 = this.o.a(kVar, hVar3);
        this.A = false;
        hVar3.a(cVarA, cVarA2);
        return hVar3;
    }

    private i a() {
        if (this.s == i.LOW) {
            return i.NORMAL;
        }
        return this.s == i.NORMAL ? i.HIGH : i.IMMEDIATE;
    }

    private com.a.a.h.c b(k<TranscodeType> kVar) {
        if (this.s == null) {
            this.s = i.NORMAL;
        }
        return a(kVar, null);
    }

    e<ModelType, DataType, ResourceType, TranscodeType> a(com.a.a.h.a.d<TranscodeType> dVar) {
        if (dVar == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.u = dVar;
        return this;
    }

    public k<TranscodeType> a(ImageView imageView) {
        com.a.a.j.h.a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.z && imageView.getScaleType() != null) {
            switch (AnonymousClass2.f2363a[imageView.getScaleType().ordinal()]) {
                case 1:
                    e();
                    break;
                case 2:
                case 3:
                case 4:
                    d();
                    break;
            }
        }
        return a(this.f2357c.a(imageView, this.f2358d));
    }

    public <Y extends k<TranscodeType>> Y a(Y y) {
        com.a.a.j.h.a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        com.a.a.h.c cVarA = y.a();
        if (cVarA != null) {
            cVarA.d();
            this.f2359e.b(cVarA);
            cVarA.a();
        }
        com.a.a.h.c cVarB = b((k) y);
        y.a(cVarB);
        this.f2360f.a(y);
        this.f2359e.a(cVarB);
        return y;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(int i, int i2) {
        if (!com.a.a.j.h.a(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.w = i;
        this.v = i2;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.b.b bVar) {
        this.x = bVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.b<DataType> bVar) {
        if (this.g != null) {
            this.g.a(bVar);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.i = cVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.e<DataType, ResourceType> eVar) {
        if (this.g != null) {
            this.g.a(eVar);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(ModelType modeltype) {
        this.h = modeltype;
        this.j = true;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(boolean z) {
        this.t = !z;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.g<ResourceType>... gVarArr) {
        this.z = true;
        if (gVarArr.length == 1) {
            this.y = gVarArr[0];
        } else {
            this.y = new com.a.a.d.d(gVarArr);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> c(int i) {
        this.l = i;
        return this;
    }

    public com.a.a.h.a<TranscodeType> c(int i, int i2) {
        final com.a.a.h.e eVar = new com.a.a.h.e(this.f2357c.g(), i, i2);
        this.f2357c.g().post(new Runnable() { // from class: com.a.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (eVar.isCancelled()) {
                    return;
                }
                e.this.a(eVar);
            }
        });
        return eVar;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> d(int i) {
        this.k = i;
        return this;
    }

    void d() {
    }

    void e() {
    }

    @Override // 
    public e<ModelType, DataType, ResourceType, TranscodeType> f() {
        try {
            e<ModelType, DataType, ResourceType, TranscodeType> eVar = (e) super.clone();
            eVar.g = this.g != null ? this.g.clone() : null;
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
