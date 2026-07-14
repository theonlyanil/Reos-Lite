package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class x {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f712a;
    }

    public interface b {
        View a();
    }

    public static Object a(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static Object a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        b(arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        b((Transition) obj, arrayList);
        return obj;
    }

    public static Object a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        if (z) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition ordering = null;
        if (transition2 != null && transition != null) {
            ordering = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            ordering = transition2;
        } else if (transition != null) {
            ordering = transition;
        }
        if (transition3 == null) {
            return ordering;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (ordering != null) {
            transitionSet2.addTransition(ordering);
        }
        transitionSet2.addTransition(transition3);
        return transitionSet2;
    }

    public static String a(View view) {
        return view.getTransitionName();
    }

    private static void a(Transition transition, final a aVar) {
        if (transition != null) {
            transition.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.support.v4.app.x.3

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private Rect f705b;

                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition2) {
                    if (this.f705b == null && aVar.f712a != null) {
                        this.f705b = x.c(aVar.f712a);
                    }
                    return this.f705b;
                }
            });
        }
    }

    public static void a(final View view, final View view2, Object obj, final ArrayList<View> arrayList, Object obj2, final ArrayList<View> arrayList2, Object obj3, final ArrayList<View> arrayList3, Object obj4, final ArrayList<View> arrayList4, final Map<String, View> map) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj2;
        final Transition transition3 = (Transition) obj3;
        final Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.x.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        x.a(transition, (ArrayList<View>) arrayList);
                    }
                    if (transition2 != null) {
                        x.a(transition2, (ArrayList<View>) arrayList2);
                    }
                    if (transition3 != null) {
                        x.a(transition3, (ArrayList<View>) arrayList3);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                    }
                    int size = arrayList4.size();
                    for (int i = 0; i < size; i++) {
                        transition4.excludeTarget((View) arrayList4.get(i), false);
                    }
                    transition4.excludeTarget(view2, false);
                    return true;
                }
            });
        }
    }

    public static void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void a(Object obj, View view) {
        final Rect rectC = c(view);
        ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.support.v4.app.x.1
            @Override // android.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(Transition transition) {
                return rectC;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(targets, arrayList.get(i));
        }
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, Object obj2, final View view, final b bVar, final View view2, a aVar, final Map<String, String> map, final ArrayList<View> arrayList, Map<String, View> map2, final Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj == null && obj2 == null) {
            return;
        }
        final Transition transition = (Transition) obj;
        if (transition != null) {
            transition.addTarget(view2);
        }
        if (obj2 != null) {
            a(obj2, view2, map2, arrayList2);
        }
        if (bVar != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.x.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        transition.removeTarget(view2);
                    }
                    View viewA = bVar.a();
                    if (viewA == null) {
                        return true;
                    }
                    if (!map.isEmpty()) {
                        x.a((Map<String, View>) map3, viewA);
                        map3.keySet().retainAll(map.values());
                        for (Map.Entry entry : map.entrySet()) {
                            View view3 = (View) map3.get((String) entry.getValue());
                            if (view3 != null) {
                                view3.setTransitionName((String) entry.getKey());
                            }
                        }
                    }
                    if (transition == null) {
                        return true;
                    }
                    x.b((ArrayList<View>) arrayList, viewA);
                    arrayList.removeAll(map3.values());
                    arrayList.add(view2);
                    x.b(transition, (ArrayList<View>) arrayList);
                    return true;
                }
            });
        }
        a(transition, aVar);
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), arrayList);
            }
            return;
        }
        if (a(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            transition.removeTarget(arrayList.get(size));
        }
    }

    private static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private static boolean a(Transition transition) {
        return (a((List) transition.getTargetIds()) && a((List) transition.getTargetNames()) && a((List) transition.getTargetTypes())) ? false : true;
    }

    private static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static Object b(Object obj) {
        Transition transition;
        if (obj == null || (transition = (Transition) obj) == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                b(transitionSet.getTransitionAt(i), arrayList);
            }
            return;
        }
        if (a(transition) || !a((List) transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            transition.addTarget(arrayList.get(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                b(arrayList, viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }
}
