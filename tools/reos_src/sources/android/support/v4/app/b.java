package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.session.MediaController;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b {

    public static abstract class a {
        public abstract Parcelable a(View view, Matrix matrix, RectF rectF);

        public abstract View a(Context context, Parcelable parcelable);

        public abstract void a(List<View> list);

        public abstract void a(List<String> list, List<View> list2, List<View> list3);

        public abstract void a(List<String> list, Map<String, View> map);

        public abstract void b(List<String> list, List<View> list2, List<View> list3);
    }

    /* JADX INFO: renamed from: android.support.v4.app.b$b, reason: collision with other inner class name */
    private static class SharedElementCallbackC0013b extends SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a f628a;

        public SharedElementCallbackC0013b(a aVar) {
            this.f628a = aVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f628a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f628a.a(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f628a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f628a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f628a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f628a.a(list, list2, list3);
        }
    }

    private static SharedElementCallback a(a aVar) {
        if (aVar != null) {
            return new SharedElementCallbackC0013b(aVar);
        }
        return null;
    }

    public static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void a(Activity activity, a aVar) {
        activity.setEnterSharedElementCallback(a(aVar));
    }

    public static void a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void b(Activity activity, a aVar) {
        activity.setExitSharedElementCallback(a(aVar));
    }

    public static void c(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
