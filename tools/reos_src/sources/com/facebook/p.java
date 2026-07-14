package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.net.HttpURLConnection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p extends AsyncTask<Void, Void, List<r>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4022a = p.class.getCanonicalName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpURLConnection f4023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f4024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Exception f4025d;

    public p(q qVar) {
        this(null, qVar);
    }

    public p(HttpURLConnection httpURLConnection, q qVar) {
        this.f4024c = qVar;
        this.f4023b = httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<r> doInBackground(Void... voidArr) {
        try {
            return this.f4023b == null ? this.f4024c.g() : GraphRequest.a(this.f4023b, this.f4024c);
        } catch (Exception e2) {
            this.f4025d = e2;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<r> list) {
        super.onPostExecute(list);
        if (this.f4025d != null) {
            Log.d(f4022a, String.format("onPostExecute: exception encountered during request: %s", this.f4025d.getMessage()));
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (m.b()) {
            Log.d(f4022a, String.format("execute async task: %s", this));
        }
        if (this.f4024c.c() == null) {
            this.f4024c.a(Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper()));
        }
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.f4023b + ", requests: " + this.f4024c + "}";
    }
}
