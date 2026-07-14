package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class b extends e implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Drawable.Callback f155e;

    private static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f f158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<Animator> f159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        android.support.v4.h.a<Animator, String> f160d;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f157a = aVar.f157a;
                if (aVar.f158b != null) {
                    Drawable.ConstantState constantState = aVar.f158b.getConstantState();
                    if (resources != null) {
                        this.f158b = (f) constantState.newDrawable(resources);
                    } else {
                        this.f158b = (f) constantState.newDrawable();
                    }
                    this.f158b = (f) this.f158b.mutate();
                    this.f158b.setCallback(callback);
                    this.f158b.setBounds(aVar.f158b.getBounds());
                    this.f158b.a(false);
                }
                if (aVar.f159c != null) {
                    int size = aVar.f159c.size();
                    this.f159c = new ArrayList<>(size);
                    this.f160d = new android.support.v4.h.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f159c.get(i);
                        Animator animatorClone = animator.clone();
                        String str = aVar.f160d.get(animator);
                        animatorClone.setTarget(this.f158b.a(str));
                        this.f159c.add(animatorClone);
                        this.f160d.put(animatorClone, str);
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f157a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.b$b, reason: collision with other inner class name */
    private static class C0004b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f161a;

        public C0004b(Drawable.ConstantState constantState) {
            this.f161a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f161a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f161a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            bVar.f166a = this.f161a.newDrawable();
            bVar.f166a.setCallback(bVar.f155e);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            bVar.f166a = this.f161a.newDrawable(resources);
            bVar.f166a.setCallback(bVar.f155e);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            bVar.f166a = this.f161a.newDrawable(resources, theme);
            bVar.f166a.setCallback(bVar.f155e);
            return bVar;
        }
    }

    private b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, a aVar, Resources resources) {
        this.f154d = null;
        this.f155e = new Drawable.Callback() { // from class: android.support.b.a.b.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                b.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                b.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                b.this.unscheduleSelf(runnable);
            }
        };
        this.f153c = context;
        if (aVar != null) {
            this.f152b = aVar;
        } else {
            this.f152b = new a(context, aVar, this.f155e, resources);
        }
    }

    static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f154d == null) {
                    this.f154d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f154d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f152b.f158b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.f152b.f159c == null) {
            this.f152b.f159c = new ArrayList<>();
            this.f152b.f160d = new android.support.v4.h.a<>();
        }
        this.f152b.f159c.add(animator);
        this.f152b.f160d.put(animator, str);
    }

    private boolean a() {
        ArrayList<Animator> arrayList = this.f152b.f159c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f166a != null) {
            return android.support.v4.c.a.a.d(this.f166a);
        }
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
        this.f152b.f158b.draw(canvas);
        if (a()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f166a != null ? android.support.v4.c.a.a.c(this.f166a) : this.f152b.f158b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f166a != null ? this.f166a.getChangingConfigurations() : super.getChangingConfigurations() | this.f152b.f157a;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f166a != null) {
            return new C0004b(this.f166a.getConstantState());
        }
        return null;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f166a != null ? this.f166a.getIntrinsicHeight() : this.f152b.f158b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f166a != null ? this.f166a.getIntrinsicWidth() : this.f152b.f158b.getIntrinsicWidth();
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
        return this.f166a != null ? this.f166a.getOpacity() : this.f152b.f158b.getOpacity();
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
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayA = a(resources, theme, attributeSet, android.support.b.a.a.f150e);
                    int resourceId = typedArrayA.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVarA = f.a(resources, resourceId, theme);
                        fVarA.a(false);
                        fVarA.setCallback(this.f155e);
                        if (this.f152b.f158b != null) {
                            this.f152b.f158b.setCallback(null);
                        }
                        this.f152b.f158b = fVarA;
                    }
                    typedArrayA.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, android.support.b.a.a.f151f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f153c == null) {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        a(string, AnimatorInflater.loadAnimator(this.f153c, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.f166a != null) {
            return ((AnimatedVectorDrawable) this.f166a).isRunning();
        }
        ArrayList<Animator> arrayList = this.f152b.f159c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f166a != null ? this.f166a.isStateful() : this.f152b.f158b.isStateful();
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f166a == null) {
            throw new IllegalStateException("Mutate() is not supported for older platform");
        }
        this.f166a.mutate();
        return this;
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f166a != null) {
            this.f166a.setBounds(rect);
        } else {
            this.f152b.f158b.setBounds(rect);
        }
    }

    @Override // android.support.b.a.e, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f166a != null ? this.f166a.setLevel(i) : this.f152b.f158b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.f166a != null ? this.f166a.setState(iArr) : this.f152b.f158b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f166a != null) {
            this.f166a.setAlpha(i);
        } else {
            this.f152b.f158b.setAlpha(i);
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
            this.f152b.f158b.setColorFilter(colorFilter);
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
            this.f152b.f158b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintList(ColorStateList colorStateList) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, colorStateList);
        } else {
            this.f152b.f158b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f166a != null) {
            android.support.v4.c.a.a.a(this.f166a, mode);
        } else {
            this.f152b.f158b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f166a != null) {
            return this.f166a.setVisible(z, z2);
        }
        this.f152b.f158b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f166a != null) {
            ((AnimatedVectorDrawable) this.f166a).start();
            return;
        }
        if (a()) {
            return;
        }
        ArrayList<Animator> arrayList = this.f152b.f159c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).start();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f166a != null) {
            ((AnimatedVectorDrawable) this.f166a).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.f152b.f159c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }
}
