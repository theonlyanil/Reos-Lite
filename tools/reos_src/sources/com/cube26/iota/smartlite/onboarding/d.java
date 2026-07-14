package com.cube26.iota.smartlite.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cube26.iota.smartlite.R;

/* JADX INFO: loaded from: classes.dex */
public class d extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3408c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof c)) {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
        this.f3408c = (c) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f3406a = getArguments().getString("param1");
            this.f3407b = getArguments().getString("param2");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_second, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3408c = null;
    }
}
