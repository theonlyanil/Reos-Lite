package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class q extends AbstractList<GraphRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f4026a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f4027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<GraphRequest> f4028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4029d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4030e = Integer.valueOf(f4026a.incrementAndGet()).toString();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<a> f4031f = new ArrayList();
    private String g;

    public interface a {
        void a(q qVar);
    }

    public interface b extends a {
        void a(q qVar, long j, long j2);
    }

    public q() {
        this.f4028c = new ArrayList();
        this.f4028c = new ArrayList();
    }

    public q(Collection<GraphRequest> collection) {
        this.f4028c = new ArrayList();
        this.f4028c = new ArrayList(collection);
    }

    public q(GraphRequest... graphRequestArr) {
        this.f4028c = new ArrayList();
        this.f4028c = Arrays.asList(graphRequestArr);
    }

    public int a() {
        return this.f4029d;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final GraphRequest get(int i) {
        return this.f4028c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void add(int i, GraphRequest graphRequest) {
        this.f4028c.add(i, graphRequest);
    }

    final void a(Handler handler) {
        this.f4027b = handler;
    }

    public void a(a aVar) {
        if (this.f4031f.contains(aVar)) {
            return;
        }
        this.f4031f.add(aVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean add(GraphRequest graphRequest) {
        return this.f4028c.add(graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final GraphRequest remove(int i) {
        return this.f4028c.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final GraphRequest set(int i, GraphRequest graphRequest) {
        return this.f4028c.set(i, graphRequest);
    }

    final String b() {
        return this.f4030e;
    }

    final Handler c() {
        return this.f4027b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f4028c.clear();
    }

    final List<GraphRequest> d() {
        return this.f4028c;
    }

    final List<a> e() {
        return this.f4031f;
    }

    public final String f() {
        return this.g;
    }

    public final List<r> g() {
        return i();
    }

    public final p h() {
        return j();
    }

    List<r> i() {
        return GraphRequest.b(this);
    }

    p j() {
        return GraphRequest.c(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4028c.size();
    }
}
