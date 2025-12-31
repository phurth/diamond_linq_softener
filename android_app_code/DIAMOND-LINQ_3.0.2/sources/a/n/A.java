package a.n;

import android.view.View;
import android.view.ViewGroup;

public class A {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f265a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f266b;

    public void a() {
        Runnable runnable;
        if (a(this.f265a) == this && (runnable = this.f266b) != null) {
            runnable.run();
        }
    }

    static void a(View view, A a2) {
        view.setTag(C0069y.transition_current_scene, a2);
    }

    static A a(View view) {
        return (A) view.getTag(C0069y.transition_current_scene);
    }
}
