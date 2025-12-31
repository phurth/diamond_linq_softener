package androidx.fragment.app;

import a.g.h.g;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.n  reason: case insensitive filesystem */
public abstract class C0138n<E> extends C0135k {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f810a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f811b;
    private final Handler c;
    private final int d;
    final w e;

    C0138n(C0134j jVar) {
        this(jVar, jVar, new Handler(), 0);
    }

    public View a(int i) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar) {
    }

    public void a(C0132h hVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f811b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity b() {
        return this.f810a;
    }

    public boolean b(C0132h hVar) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Context d() {
        return this.f811b;
    }

    /* access modifiers changed from: package-private */
    public Handler e() {
        return this.c;
    }

    public LayoutInflater f() {
        return LayoutInflater.from(this.f811b);
    }

    public int g() {
        return this.d;
    }

    public boolean h() {
        return true;
    }

    public void i() {
    }

    C0138n(Activity activity, Context context, Handler handler, int i) {
        this.e = new w();
        this.f810a = activity;
        g.a(context, "context == null");
        this.f811b = context;
        g.a(handler, "handler == null");
        this.c = handler;
        this.d = i;
    }
}
