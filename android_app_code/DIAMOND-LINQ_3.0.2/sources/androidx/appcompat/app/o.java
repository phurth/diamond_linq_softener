package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Ma;
import androidx.appcompat.widget.Toolbar;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static int f423a = -100;

    o() {
    }

    public static o a(Activity activity, n nVar) {
        return new x(activity, nVar);
    }

    public abstract <T extends View> T a(int i);

    public abstract void a(Context context);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract int b();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b(int i);

    public abstract MenuInflater c();

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract C0071a d();

    public abstract void d(int i);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public static o a(Dialog dialog, n nVar) {
        return new x(dialog, nVar);
    }

    public static int a() {
        return f423a;
    }

    public static void a(boolean z) {
        Ma.a(z);
    }
}
