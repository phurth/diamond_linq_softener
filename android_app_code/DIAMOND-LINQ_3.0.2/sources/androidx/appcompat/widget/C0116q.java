package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.C0090ca;

/* renamed from: androidx.appcompat.widget.q  reason: case insensitive filesystem */
public final class C0116q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final PorterDuff.Mode f632a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static C0116q f633b;
    private C0090ca c;

    public static synchronized C0116q b() {
        C0116q qVar;
        synchronized (C0116q.class) {
            if (f633b == null) {
                c();
            }
            qVar = f633b;
        }
        return qVar;
    }

    public static synchronized void c() {
        synchronized (C0116q.class) {
            if (f633b == null) {
                f633b = new C0116q();
                f633b.c = C0090ca.a();
                f633b.c.a((C0090ca.e) new C0115p());
            }
        }
    }

    public synchronized Drawable a(Context context, int i) {
        return this.c.a(context, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.c.a(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i) {
        return this.c.b(context, i);
    }

    static void a(Drawable drawable, xa xaVar, int[] iArr) {
        C0090ca.a(drawable, xaVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (C0116q.class) {
            a2 = C0090ca.a(i, mode);
        }
        return a2;
    }
}
