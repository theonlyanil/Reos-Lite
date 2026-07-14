package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
class o {
    static void a(ListView listView, int i) {
        View childAt;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }
}
