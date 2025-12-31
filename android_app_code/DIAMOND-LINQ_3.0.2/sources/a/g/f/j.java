package a.g.f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f165a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f166b;
    final /* synthetic */ ReentrantLock c;
    final /* synthetic */ AtomicBoolean d;
    final /* synthetic */ Condition e;
    final /* synthetic */ k f;

    j(k kVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f = kVar;
        this.f165a = atomicReference;
        this.f166b = callable;
        this.c = reentrantLock;
        this.d = atomicBoolean;
        this.e = condition;
    }

    public void run() {
        try {
            this.f165a.set(this.f166b.call());
        } catch (Exception unused) {
        }
        this.c.lock();
        try {
            this.d.set(false);
            this.e.signal();
        } finally {
            this.c.unlock();
        }
    }
}
