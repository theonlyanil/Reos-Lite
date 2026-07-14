package android.support.v4.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
abstract class k<Params, Progress, Result> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f733d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadFactory f730a = new ThreadFactory() { // from class: android.support.v4.b.k.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f736a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f736a.getAndIncrement());
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f731b = new LinkedBlockingQueue(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f732c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f731b, f730a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Executor f734e = f732c;
    private volatile c h = c.PENDING;
    private final AtomicBoolean i = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d<Params, Result> f735f = new d<Params, Result>() { // from class: android.support.v4.b.k.2
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            k.this.i.set(true);
            Process.setThreadPriority(10);
            return (Result) k.this.d(k.this.a((Object[]) this.f746b));
        }
    };
    private final FutureTask<Result> g = new FutureTask<Result>(this.f735f) { // from class: android.support.v4.b.k.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                k.this.c(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException e3) {
                k.this.c(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    private static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k f740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f741b;

        a(k kVar, Data... dataArr) {
            this.f740a = kVar;
            this.f741b = dataArr;
        }
    }

    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f740a.e(aVar.f741b[0]);
                    break;
                case 2:
                    aVar.f740a.b((Object[]) aVar.f741b);
                    break;
            }
        }
    }

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class d<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Params[] f746b;

        private d() {
        }
    }

    private static Handler a() {
        b bVar;
        synchronized (k.class) {
            if (f733d == null) {
                f733d = new b();
            }
            bVar = f733d;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Result result) {
        if (this.i.get()) {
            return;
        }
        d(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result d(Result result) {
        a().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Result result) {
        if (d()) {
            b(result);
        } else {
            a(result);
        }
        this.h = c.FINISHED;
    }

    public final k<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.h != c.PENDING) {
            switch (this.h) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.h = c.RUNNING;
        b();
        this.f735f.f746b = paramsArr;
        executor.execute(this.g);
        return this;
    }

    protected abstract Result a(Params... paramsArr);

    protected void a(Result result) {
    }

    public final boolean a(boolean z) {
        return this.g.cancel(z);
    }

    protected void b() {
    }

    protected void b(Result result) {
        c();
    }

    protected void b(Progress... progressArr) {
    }

    protected void c() {
    }

    public final boolean d() {
        return this.g.isCancelled();
    }
}
