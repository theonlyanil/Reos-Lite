package android.support.v4.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends i<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile a<D>.RunnableC0015a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile a<D>.RunnableC0015a mTask;
    long mUpdateThrottle;

    /* JADX INFO: renamed from: android.support.v4.b.a$a, reason: collision with other inner class name */
    final class RunnableC0015a extends k<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f714a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CountDownLatch f716d = new CountDownLatch(1);

        RunnableC0015a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.b.k
        public D a(Void... voidArr) {
            try {
                return (D) a.this.onLoadInBackground();
            } catch (android.support.v4.f.c e2) {
                if (d()) {
                    return null;
                }
                throw e2;
            }
        }

        public void a() {
            try {
                this.f716d.await();
            } catch (InterruptedException e2) {
            }
        }

        @Override // android.support.v4.b.k
        protected void a(D d2) {
            try {
                a.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.f716d.countDown();
            }
        }

        @Override // android.support.v4.b.k
        protected void b(D d2) {
            try {
                a.this.dispatchOnCancelled(this, d2);
            } finally {
                this.f716d.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f714a = a.DEBUG;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        this(context, k.f732c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(a<D>.RunnableC0015a runnableC0015a, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == runnableC0015a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(a<D>.RunnableC0015a runnableC0015a, D d2) {
        if (this.mTask != runnableC0015a) {
            dispatchOnCancelled(runnableC0015a, d2);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d2);
            return;
        }
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(d2);
    }

    @Override // android.support.v4.b.i
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f714a);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f714a);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            android.support.v4.h.k.a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            android.support.v4.h.k.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.f714a) {
            this.mTask.f714a = DEBUG;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.a(this.mExecutor, (Void[]) null);
        } else {
            this.mTask.f714a = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask != null) {
            return true;
        }
        return DEBUG;
    }

    public abstract D loadInBackground();

    @Override // android.support.v4.b.i
    protected boolean onCancelLoad() {
        boolean zA = DEBUG;
        if (this.mTask != null) {
            if (this.mCancellingTask != null) {
                if (this.mTask.f714a) {
                    this.mTask.f714a = DEBUG;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.f714a) {
                this.mTask.f714a = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                zA = this.mTask.a(DEBUG);
                if (zA) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
            }
        }
        return zA;
    }

    public void onCanceled(D d2) {
    }

    @Override // android.support.v4.b.i
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0015a();
        executePendingTask();
    }

    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        a<D>.RunnableC0015a runnableC0015a = this.mTask;
        if (runnableC0015a != null) {
            runnableC0015a.a();
        }
    }
}
