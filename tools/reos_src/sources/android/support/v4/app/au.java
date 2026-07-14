package android.support.v4.app;

import android.os.Bundle;
import com.google.android.gms.plus.PlusShare;

/* JADX INFO: loaded from: classes.dex */
class au {
    static Bundle a(at.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", aVar.a());
        bundle.putCharSequence(PlusShare.KEY_CALL_TO_ACTION_LABEL, aVar.b());
        bundle.putCharSequenceArray("choices", aVar.c());
        bundle.putBoolean("allowFreeFormInput", aVar.d());
        bundle.putBundle("extras", aVar.e());
        return bundle;
    }

    static Bundle[] a(at.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            bundleArr[i] = a(aVarArr[i]);
        }
        return bundleArr;
    }
}
