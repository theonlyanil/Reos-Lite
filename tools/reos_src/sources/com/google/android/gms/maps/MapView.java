package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MapView extends FrameLayout {
    private GoogleMap zzaPf;
    private final zzb zzaPl;

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaPm;
        private final IMapViewDelegate zzaPn;
        private View zzaPo;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaPn = (IMapViewDelegate) zzx.zzy(iMapViewDelegate);
            this.zzaPm = (ViewGroup) zzx.zzy(viewGroup);
        }

        @Override // com.google.android.gms.maps.internal.MapLifecycleDelegate
        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zzaPn.getMapAsync(new zzl.zza() { // from class: com.google.android.gms.maps.MapView.zza.1
                    @Override // com.google.android.gms.maps.internal.zzl
                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzaPn.onCreate(bundle);
                this.zzaPo = (View) zze.zzp(this.zzaPn.getView());
                this.zzaPm.removeAllViews();
                this.zzaPm.addView(this.zzaPo);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.zzaPn.onDestroy();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onEnterAmbient(Bundle bundle) {
            try {
                this.zzaPn.onEnterAmbient(bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public void onExitAmbient() {
            try {
                this.zzaPn.onExitAmbient();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
            try {
                this.zzaPn.onLowMemory();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaPn.onPause();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaPn.onResume();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaPn.onSaveInstanceState(bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
        }

        public IMapViewDelegate zzzi() {
            return this.zzaPn;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaPj;
        private final List<OnMapReadyCallback> zzaPk = new ArrayList();
        private final ViewGroup zzaPq;
        private final GoogleMapOptions zzaPr;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaPq = viewGroup;
            this.mContext = context;
            this.zzaPr = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzts() != null) {
                zzts().getMapAsync(onMapReadyCallback);
            } else {
                this.zzaPk.add(onMapReadyCallback);
            }
        }

        public void onEnterAmbient(Bundle bundle) {
            if (zzts() != null) {
                zzts().onEnterAmbient(bundle);
            }
        }

        public void onExitAmbient() {
            if (zzts() != null) {
                zzts().onExitAmbient();
            }
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zza> zzfVar) {
            this.zzaPj = zzfVar;
            zzzh();
        }

        public void zzzh() {
            if (this.zzaPj == null || zzts() != null) {
                return;
            }
            try {
                MapsInitializer.initialize(this.mContext);
                IMapViewDelegate iMapViewDelegateZza = zzy.zzaP(this.mContext).zza(zze.zzB(this.mContext), this.zzaPr);
                if (iMapViewDelegateZza == null) {
                    return;
                }
                this.zzaPj.zza(new zza(this.zzaPq, iMapViewDelegateZza));
                Iterator<OnMapReadyCallback> it = this.zzaPk.iterator();
                while (it.hasNext()) {
                    zzts().getMapAsync(it.next());
                }
                this.zzaPk.clear();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            } catch (GooglePlayServicesNotAvailableException e3) {
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaPl = new zzb(this, context, null);
        init();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaPl = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        init();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaPl = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        init();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.zzaPl = new zzb(this, context, googleMapOptions);
        init();
    }

    private void init() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzaPf != null) {
            return this.zzaPf;
        }
        this.zzaPl.zzzh();
        if (this.zzaPl.zzts() == null) {
            return null;
        }
        try {
            this.zzaPf = new GoogleMap(this.zzaPl.zzts().zzzi().getMap());
            return this.zzaPf;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzcx("getMapAsync() must be called on the main thread");
        this.zzaPl.getMapAsync(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.zzaPl.onCreate(bundle);
        if (this.zzaPl.zzts() == null) {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.zzaPl.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzx.zzcx("onEnterAmbient() must be called on the main thread");
        this.zzaPl.onEnterAmbient(bundle);
    }

    public final void onExitAmbient() {
        zzx.zzcx("onExitAmbient() must be called on the main thread");
        this.zzaPl.onExitAmbient();
    }

    public final void onLowMemory() {
        this.zzaPl.onLowMemory();
    }

    public final void onPause() {
        this.zzaPl.onPause();
    }

    public final void onResume() {
        this.zzaPl.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzaPl.onSaveInstanceState(bundle);
    }
}
