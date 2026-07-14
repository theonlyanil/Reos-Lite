package android.support.v4.f;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
class b {
    static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
