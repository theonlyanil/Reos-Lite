package android.support.v7.a;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1054a = {R.attr.homeAsUpIndicator};

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f1055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f1056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f1057c;

        a(Activity activity) {
            try {
                this.f1055a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f1056b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException e2) {
                View viewFindViewById = activity.findViewById(R.id.home);
                if (viewFindViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                        if (childAt2 instanceof ImageView) {
                            this.f1057c = (ImageView) childAt2;
                        }
                    }
                }
            }
        }
    }

    public static Drawable a(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(f1054a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public static a a(a aVar, Activity activity, int i) {
        if (aVar == null) {
            aVar = new a(activity);
        }
        if (aVar.f1055a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f1056b.invoke(actionBar, Integer.valueOf(i));
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e2) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e2);
            }
        }
        return aVar;
    }

    public static a a(a aVar, Activity activity, Drawable drawable, int i) {
        a aVar2 = new a(activity);
        if (aVar2.f1055a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar2.f1055a.invoke(actionBar, drawable);
                aVar2.f1056b.invoke(actionBar, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e2);
            }
        } else if (aVar2.f1057c != null) {
            aVar2.f1057c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return aVar2;
    }
}
