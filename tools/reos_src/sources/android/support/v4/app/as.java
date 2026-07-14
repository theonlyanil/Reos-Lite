package android.support.v4.app;

import android.app.RemoteInput;

/* JADX INFO: loaded from: classes.dex */
class as {
    static RemoteInput[] a(at.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            at.a aVar = aVarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(aVar.a()).setLabel(aVar.b()).setChoices(aVar.c()).setAllowFreeFormInput(aVar.d()).addExtras(aVar.e()).build();
        }
        return remoteInputArr;
    }
}
